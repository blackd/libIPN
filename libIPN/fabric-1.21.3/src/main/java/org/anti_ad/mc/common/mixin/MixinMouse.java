/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2019-2020 jsnimda <7615255+jsnimda@users.noreply.github.com>
 *   Copyright (c) 2021-2022 Plamen K. Kosseff <p.kosseff@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.anti_ad.mc.common.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.gui.screen.Screen;
import org.anti_ad.mc.common.gui.debug.DebugInfos;
import org.anti_ad.mc.common.input.GlobalInputHandler;
import org.anti_ad.mc.common.input.GlobalScreenEventListener;
import org.anti_ad.mc.common.vanilla.Vanilla;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.anti_ad.mc.common.input.KeyCodes.*;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

@Mixin(Mouse.class)
public class MixinMouse {
    @Inject(method = "onCursorPos", at = @At("RETURN"))
    private void onCursorPos(long handle, double xpos, double ypos, CallbackInfo ci) {
//    VanillaUtil.INSTANCE.updateMouse();
    }

    @Inject(method = "onMouseButton", at = @At(value = "RETURN"))
    private void onMouseButtonLast(long handle, int button, int action, int mods, CallbackInfo ci) {
        if (handle == Vanilla.INSTANCE.window().getHandle()) {
            GlobalInputHandler.INSTANCE.onMouseButton(button, action, mods);
            if (Vanilla.INSTANCE.screen() != null) {
                GlobalScreenEventListener.INSTANCE.onMouse(button, action, mods, false);
            }
        }
    }


    @Inject(method = "onMouseButton", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/Screen;mouseClicked(DDI)Z"), cancellable = true)
    private void onScreenMouseButtonPress(long handle, int button, int action, int mods, CallbackInfo ci) {
        Screen lastScreen = Vanilla.INSTANCE.screen();
        boolean result = GlobalScreenEventListener.INSTANCE.onMouse(button, action, mods, true);
        if (result || lastScreen != Vanilla.INSTANCE.screen()) { // detect gui change, cancel vanilla
            ci.cancel();
        }
    }

    @Inject(method = "onMouseButton", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/Screen;mouseReleased(DDI)Z"), cancellable = true)
    private void onScreenMouseButtonRelease(long handle, int button, int action, int mods, CallbackInfo ci) {
        Screen lastScreen = Vanilla.INSTANCE.screen();
        boolean result = GlobalScreenEventListener.INSTANCE.onMouse(button, action, mods, true);
        if (result || lastScreen != Vanilla.INSTANCE.screen()) { // detect gui change, cancel vanilla
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "onMouseScroll(JDD)V", cancellable = true)
    void onMouseScroll(long window, double horizontal, double vertical, CallbackInfo ci) {
        if (window == MinecraftClient.getInstance().getWindow().getHandle()) {
            DebugInfos.INSTANCE.onScrollButton(horizontal, vertical);
            boolean result = false;

            if (horizontal != 0) {
                int button = horizontal > 0 ? MOUSE_SCROLL_LEFT : MOUSE_SCROLL_RIGHT;

                result = GlobalInputHandler.INSTANCE.onMouseButton(button, GLFW_PRESS, 0);
                result = GlobalScreenEventListener.INSTANCE.onMouse(button, GLFW_PRESS, 0, true)
                        || result;
            }
            if (vertical != 0) {
                int button = vertical > 0 ? MOUSE_SCROLL_UP : MOUSE_SCROLL_DOWN;
                result = GlobalInputHandler.INSTANCE.onMouseButton(button, GLFW_PRESS, 0);
                result = GlobalScreenEventListener.INSTANCE.onMouse(button, GLFW_PRESS, 0, true)
                        || result;
            }

            if (horizontal != 0) {
                int button = horizontal > 0 ? MOUSE_SCROLL_LEFT: MOUSE_SCROLL_RIGHT;
                result = GlobalInputHandler.INSTANCE.onMouseButton(button, GLFW_RELEASE, 0);
                result = GlobalScreenEventListener.INSTANCE.onMouse(button, GLFW_RELEASE, 0, true)
                        || result;
            }
            if (vertical != 0) {
                int button = vertical > 0 ? MOUSE_SCROLL_UP : MOUSE_SCROLL_DOWN;
                result = GlobalInputHandler.INSTANCE.onMouseButton(button, GLFW_RELEASE, 0);
                result = GlobalScreenEventListener.INSTANCE.onMouse(button, GLFW_RELEASE, 0, true)
                        || result;
            }

            if (result) {
                ci.cancel();
            }
        } else {
            ci.cancel();
        }
    }
}
