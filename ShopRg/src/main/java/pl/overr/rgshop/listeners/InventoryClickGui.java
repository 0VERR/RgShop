package pl.overr.rgshop.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.overr.rgshop.shop.ShopLoader;
import pl.overr.rgshop.utils.ColorUtil;


public class InventoryClickGui implements Listener {

    private final ShopLoader shopLoader;

    public InventoryClickGui(ShopLoader shopLoader) {
        this.shopLoader = shopLoader;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (inventory.getName().equalsIgnoreCase(ColorUtil.fixColor("&aSKLEP"))) {
            if ((event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) && inventory.getName().equalsIgnoreCase(ColorUtil.fixColor("&ASKLEP"))) {
                event.setCancelled(true);
                return;
            }
                event.setCancelled(true);
                Player whoClicked = (Player) event.getWhoClicked();
                ItemStack itemStack = event.getCurrentItem();
                shopLoader.checkClickedItemStack(whoClicked, itemStack);

            }
        }
    }

