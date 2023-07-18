package me.nukeghost.tasks;

import me.nukeghost.DeliveryBoard;
import me.nukeghost.handlers.GenerationHandler;
import org.bukkit.scheduler.BukkitRunnable;

import static me.nukeghost.DeliveryBoard.cooldown;

public class ThreeHourlyDeliveryUpdateTask extends BukkitRunnable {

    DeliveryBoard plugin;

    public ThreeHourlyDeliveryUpdateTask(DeliveryBoard plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        cooldown.put("six-hourly", System.currentTimeMillis() + (3600000 * 3));
        DeliveryBoard.setThreeHourlyItem(GenerationHandler.generateDeliveryItem("three-hourly"));
        DeliveryBoard.sixHourlyCompletedPlayerList.clear();
    }
}
