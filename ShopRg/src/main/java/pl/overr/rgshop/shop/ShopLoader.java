package pl.overr.rgshop.shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.overr.rgshop.ShopPlugin;
import pl.overr.rgshop.utils.ColorUtil;
import pl.overr.rgshop.utils.ItemStackUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShopLoader {
    private HashMap<String, Shop> shopMap = new HashMap<>();

    public Inventory shopInventory = Bukkit.createInventory(null, 36, ColorUtil.fixColor("&aSKLEP"));


    public void checkClickedItemStack(Player player,ItemStack itemStack) {
                Shop shop = shopMap.get(itemStack.getItemMeta().getDisplayName());
                int checkEmeralds = ItemStackUtil.getAmountOfItem(Material.EMERALD, player, (short) 0);
                player.sendMessage(String.valueOf(checkEmeralds));
                if ((checkEmeralds - shop.getPrize()) < 0){
                    player.sendMessage(ColorUtil.fixColor("&cNie masz wystarczajaco duzo emeraldow."));
                    return;
                }
                player.getInventory().remove(new ItemStack(Material.EMERALD,shop.getPrize()));
                player.getInventory().addItem(shop.getItemStack());
            }



    public void loadToGui(){
        FileConfiguration config = ShopPlugin.getShopPlugin().getConfig();
        for (String s : config.getConfigurationSection("Buy").getKeys(false)) {
            String item = config.getString("Buy." + s + ".item");
            String name = config.getString("Buy." + s + ".name");
            int prize = config.getInt("Buy." + s + ".prize");
            int amount = config.getInt("Buy." + s + ".amount");
            int durability = config.getInt("Buy." + s + ".durability");
            List<String> lore = config.getStringList("Buy." + s + ".lore");

            ItemStack itemStack = new ItemStack(Material.getMaterial(item.toUpperCase()), amount, (short) durability);
            ItemMeta itemMeta = itemStack.getItemMeta();
            String displayName = ColorUtil.fixColor(name);
            itemMeta.setDisplayName(displayName);
            itemMeta.setLore(ColorUtil.fixLore(lore));

            itemStack.setItemMeta(itemMeta);

            shopInventory.addItem(itemStack);
            shopMap.put(displayName, new Shop(item,name,prize,amount,durability,itemStack));
        }
    }
}
