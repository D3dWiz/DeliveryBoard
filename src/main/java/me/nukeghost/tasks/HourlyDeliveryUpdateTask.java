package me.nukeghost.tasks;

import me.nukeghost.DeliveryBoard;
import me.nukeghost.handlers.GenerationHandler;
import org.bukkit.scheduler.BukkitRunnable;

import static me.nukeghost.DeliveryBoard.cooldown;

public class HourlyDeliveryUpdateTask extends BukkitRunnable {

    DeliveryBoard plugin;

    public HourlyDeliveryUpdateTask(DeliveryBoard plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        cooldown.put("hourly", currentTime + 3600000);
        DeliveryBoard.setHourlyItem(GenerationHandler.generateDeliveryItem("hourly"));
        DeliveryBoard.hourlyCompletedPlayerList.clear();

    }
}
