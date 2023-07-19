package me.nukeghost.tasks;

import me.nukeghost.DeliveryBoard;
import me.nukeghost.handlers.GenerationHandler;
import org.bukkit.scheduler.BukkitRunnable;

import static me.nukeghost.DeliveryBoard.cooldown;

public class SixHourlyDeliveryUpdateTask extends BukkitRunnable {

    DeliveryBoard plugin;

    public SixHourlyDeliveryUpdateTask(DeliveryBoard plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        cooldown.put("six-hourly", currentTime + 3600000 * 6);
        DeliveryBoard.setThreeHourlyItem(GenerationHandler.generateDeliveryItem("six-hourly"));
        DeliveryBoard.sixHourlyCompletedPlayerList.clear();
    }
}
