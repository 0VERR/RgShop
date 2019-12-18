package pl.overr.rgshop.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemStackUtil {

    public static int getAmountOfItem(Material material, Player player, short durability){
        int amount = 0;
        ItemStack[] contents;
        int lenght = (contents = player.getInventory().getContents()).length;
        for (int i = 0; i < lenght; i++){
            ItemStack itemStack = contents[i];
            if (itemStack != null && (itemStack.getType().equals(material)) && itemStack.getDurability() == durability){
                amount += itemStack.getAmount();
            }
        }
        return amount;
    }
}
