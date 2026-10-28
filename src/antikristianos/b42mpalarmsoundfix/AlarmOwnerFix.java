package antikristianos.b42mpalarmsoundfix;

import zombie.characters.IsoPlayer;
import zombie.inventory.InventoryItem;
import zombie.inventory.ItemContainer;
import zombie.inventory.types.AlarmClock;
import zombie.inventory.types.AlarmClockClothing;
import zombie.network.GameClient;

public final class AlarmOwnerFix {
    private static boolean reported;

    private AlarmOwnerFix() {}

    public static IsoPlayer resolve(InventoryItem item, ItemContainer container, IsoPlayer original) {
        if (original != null || !GameClient.client || container == null
                || (!(item instanceof AlarmClock) && !(item instanceof AlarmClockClothing))
                || item.getContainer() != container || !item.isInLocalPlayerInventory()) {
            return original;
        }
        ItemContainer outer = item.getOutermostContainer();
        if (outer != null && outer.getParent() instanceof IsoPlayer player && player.isLocalPlayer()) {
            if (!reported) {
                reported = true;
                System.out.println("[B42MPAlarmSoundFix] Native MP alarm owner hook active; container identity preserved.");
            }
            return player;
        }
        return original;
    }
}
