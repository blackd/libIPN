<!-- latest begin -->

### 6.3.0

- support for 1.21.5
- lots of technical improvements that make the client mods configs simpler 
- 1.21.3 is no longer supported

<!-- latest end -->
<!-- rest begin -->

### 6.2.1

- Adds support for multiple key combinations per keybind. Accessible through the button icon of the keybind option.


### 6.2.0

- Support for fabric 1.21.4
- fixes keybinds of [InvTweaks Emulation for IPN](https://modrinth.com/mod/invtweaks-emu-for-ipn)


### 6.1.1

- fixed swipe shift click to detect mouse button release.


### 6.1.0

- support for 1.21.3


### 6.0.2

- minor changes needed by IPN 2.0.4


### 6.0.1
- showing that they are good descendant NeoForge pulled a Forge move and broke the API in the same major release.


### 6.0.0
- adds NeoForge 1.21 support

### 5.0.2
- adds forge 1.21 support
- small fixes and improvements

### 5.0.0

- Adds 1.21 compatibility.
- Minecraft versions below 1.21 will no longer receive updates!


### 4.0.2

- this is just preliminary release for future 1.20.5 compatible version


### 4.0.1

- fixed input handling where in some cases shortcuts weren't triggered on button/key release.

### 4.0.0

- compatibility with MC 1.20.2 that led to interface change
- removed 1.16 and 1.19.4 support.

### 3.0.2

- support for 1.20 fabric. Although the 1.20-preX version did partially work it had some problems that this fixes.
- forge version to fallow when Kotlin for Forge gets a release.

### Become a [Patreon](https://www.patreon.com/mirinimi/membership) to gain early access

### 3.0.1

- Fixed crash on forge while searching in the settings screen.

### 3.0.0

- adds support for 1.20. Due to major changes in the rendering system this version is not compatible with mods build against 2.x.x

### 2.0.7

- Fixes crash in forge versions and potential conflict with other mods in fabric versions.

### 2.0.6

- Adds search box in the settings screen. This will be applied to all compatible mods.


### 2.0.5

- added support for color picker dialog
- removed support for minecraft 1.19.3
- minecraft 1.19 and 1.19.1 are no longer officially supported. But the 1.19.2 version will probably work. Just no testing with those is done any more.

### 2.0.4

- Added support for 1.19.4 Forge.
- Finalised support for 1.19.4 Fabric.
- Fabric all versions now requires fabric loaded **0.14.17** or newer.
- Fabric minimal required version of Fabric Language Kotlin is now **1.9.2+kotlin.1.8.10**
- Forge 1.18.2 and 1.19.1-2 now require Kotlin for Forge 3.11.0 or newer.
- Forge 1.19.3-4 now require Kotlin for Forge 4.1.0 or newer.

### Note:

This is probably the last version that supports minecraft 1.19.3

### Become a [Patreon](https://www.patreon.com/mirinimi/membership) to gain early access


### 2.0.2

- better compatibility with mac os opengl strangeness.



### 2.0.0

- added support for 1.19.3 forge
- fixed toggle settings not working when more then one mod uses libIPN

### 1.0.8

- adds support for 1.19.3-rc1 and hopefully 1.19.3 proper

### 1.0.7

- adds support for 1.19.3
- some non-user facing changes because of the 1.19.3 support

### 1.0.6

- workaround for forge out of order mod initialization that causes crash for very small number of users.

### 1.0.5

- fixed situation where the all buttons in the settings become inaccessible preventing the player using the settings screen.
- added support for 1.19.3/1.20 snapshots. Available to patreons.

### 1.0.4

- Adds support for foods as a group of items.

### 1.0.2

- Added support for fishing rods.


### 1.0.1

- Hotkeys will no longer be activated while in chat.
- In resent versions of Minecraft displayed key combinations are now localized according to the active keyboard layout. Now `qwertz` users will see `r+z` instead of `r+y`.
- Fixed high CPU usage while a Settings screen is shown.
- Trace logs are no longer enabled by default. If any of the using mods enables trace logs they will automatically be enabled for libIPN.

### 1.0.0

Initial release.
