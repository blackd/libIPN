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

import net.minecraft.client.Keyboard;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import org.anti_ad.mc.common.input.GlobalInputHandler;
import org.anti_ad.mc.common.input.GlobalScreenEventListener;
import org.anti_ad.mc.common.vanilla.Vanilla;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;


@Mixin(value = Keyboard.class, priority = 0)
public class MixinKeyboard {

    @Unique
    private int pressedCount = 0;
    @Unique
    private int releasedCount = 0;

    @Inject(method = "onKey", at = @At(value = "HEAD"), cancellable = true) // ref: malilib key hook
    private void onKeyFirst(long handle, int key, int scanCode, int action, int modifiers, CallbackInfo ci) {
        boolean res = false;
        if (Vanilla.INSTANCE.mc().isOnThread() && handle == Vanilla.INSTANCE.window().getHandle()) {
            pressedCount += action == GLFW_PRESS ? 1 : 0;
            releasedCount += action == GLFW_RELEASE ? 1 : 0;
            boolean checkPressing = pressedCount != 0 || releasedCount != 0;
            if (checkPressing) {
                pressedCount = 0;
                releasedCount = 0;
            }
            res = GlobalInputHandler.INSTANCE.onKey(key, scanCode, action, modifiers, checkPressing, handle);
            if (Vanilla.INSTANCE.screen() != null) {
                res = GlobalScreenEventListener.INSTANCE.onKey120(key, scanCode, action, modifiers, true);
            }
        }
        if (res) {
            ci.cancel();
        }
    }

    @Inject(method = "onKey", at = @At(value = "TAIL")) // ref: malilib key hook
    private void onKeyLast(long handle, int key, int scanCode, int action, int modifiers, CallbackInfo ci) {
        if (Vanilla.INSTANCE.mc().isOnThread() && handle == Vanilla.INSTANCE.window().getHandle()) {
            pressedCount += action == GLFW_PRESS ? -1 : 0;
            releasedCount += action == GLFW_RELEASE ? -1 : 0;
            if (Vanilla.INSTANCE.screen() != null) {
                GlobalScreenEventListener.INSTANCE.onKey120(key, scanCode, action, modifiers, false);
            }
        }
    }

    // early before return
    @Inject(method = "onKey", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/Screen;keyReleased(III)Z"), cancellable = true)
    private void onScreenKey(long handle, int key, int scanCode, int action, int modifiers, CallbackInfo ci) {
        Screen lastScreen = Vanilla.INSTANCE.screen();
        if (lastScreen instanceof ChatScreen) return;

        boolean result = GlobalInputHandler.INSTANCE.onKey(key, scanCode, action, modifiers, false, handle)
                || GlobalScreenEventListener.INSTANCE.onKey120(key, scanCode, action, modifiers, true);

        if (result || lastScreen != Vanilla.INSTANCE.screen()) { // detect gui change, cancel vanilla
            ci.cancel();
        }
    }
}
