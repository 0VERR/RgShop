package pl.overr.rgshop.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ColorUtil {
    public static String fixColor(String arg){
        return ChatColor.translateAlternateColorCodes('&', arg);
    }

    public static List<String>  fixLore(List<String> list){
        List<String> siema = new ArrayList<>();
        list.forEach(x ->{
            String lore = fixColor(x);
            siema.add(lore);

        });
        return siema;
    }
}
