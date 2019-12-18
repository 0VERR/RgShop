package pl.overr.rgshop.shop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {

    private final ShopLoader shopLoader;

    public ShopCommand(ShopLoader shopLoader) {
        this.shopLoader = shopLoader;
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        player.openInventory(shopLoader.shopInventory);
        return false;
    }
}
