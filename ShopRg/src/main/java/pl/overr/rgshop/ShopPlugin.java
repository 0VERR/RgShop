package pl.overr.rgshop;

import org.bukkit.plugin.java.JavaPlugin;
import pl.overr.rgshop.listeners.InventoryClickGui;
import pl.overr.rgshop.shop.ShopCommand;
import pl.overr.rgshop.shop.ShopLoader;

public class ShopPlugin extends JavaPlugin {
    static ShopPlugin shopPlugin;

    public static ShopPlugin getShopPlugin(){
        return shopPlugin;
    }

    public void onEnable() {
        saveDefaultConfig();
        ShopLoader shopLoader = new ShopLoader();

        shopPlugin = this;
        shopLoader.loadToGui();

        getCommand("sklep").setExecutor(new ShopCommand(shopLoader));
        getServer().getPluginManager().registerEvents(new InventoryClickGui(shopLoader), this);
    }


    public void onDisable(){

    }
}

