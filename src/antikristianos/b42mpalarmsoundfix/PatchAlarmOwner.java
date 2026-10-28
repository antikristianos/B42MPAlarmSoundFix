package antikristianos.b42mpalarmsoundfix;

import me.zed_0xff.zombie_buddy.Patch;
import zombie.characters.IsoPlayer;
import zombie.inventory.InventoryItem;
import zombie.inventory.ItemContainer;

@Patch(className = "zombie.inventory.InventoryItem", methodName = "getOwnerPlayer",
        warmUp = true, strictMatch = true)
public final class PatchAlarmOwner {
    private PatchAlarmOwner() {}

    @Patch.OnExit(suppress = RuntimeException.class)
    public static void exit(@Patch.This InventoryItem item, @Patch.Argument(0) ItemContainer container,
            @Patch.Return(readOnly = false) IsoPlayer owner) {
        owner = AlarmOwnerFix.resolve(item, container, owner);
    }
}
