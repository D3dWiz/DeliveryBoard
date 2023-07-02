package me.deliveryboard.menusystem;

import me.deliveryboard.DeliveryBoard;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public abstract class Menu implements InventoryHolder {
    protected Inventory inventory;
    protected ItemStack FILLER_GLASS = new ItemStack(Material.getMaterial(DeliveryBoard.plugin.getConfig().getString("gui.static.fillerMaterial")));
    protected ItemStack ACCEPT = new ItemStack(Material.getMaterial(DeliveryBoard.plugin.getConfig().getString("gui.static.acceptMaterial")));
    protected ItemStack CANCEL = new ItemStack(Material.getMaterial(DeliveryBoard.plugin.getConfig().getString("gui.static.cancelMaterial")));
    protected PlayerMenuUtility playerMenuUtility;

    public Menu(PlayerMenuUtility playerMenuUtility) {
        this.playerMenuUtility = playerMenuUtility;
    }

    public abstract String getMenuName();
    public abstract int getSlots();
    public abstract void handleMenu(InventoryClickEvent e);
    public abstract void setMenuItems();
    public void open() {
        inventory = Bukkit.createInventory(this, getSlots(), getMenuName());
        this.setMenuItems();
        playerMenuUtility.getOwner().openInventory(inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public abstract void onClose(InventoryCloseEvent e);
}
