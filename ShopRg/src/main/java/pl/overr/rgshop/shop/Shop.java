package pl.overr.rgshop.shop;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Shop {
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    private  String item;

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    private int durability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private  String name;
    private  int prize;
    private  int amount;

    public ItemStack getItemStack() {
        return itemStack;
    }

    private ItemStack itemStack;
    public Shop(String item, String name, int prize, int amount, int durability, ItemStack itemStack) {
        this.item = item;
        this.name = name;
        this.prize = prize;
        this.amount = amount;
        this.durability = durability;
        this.itemStack = itemStack;
    }
}

