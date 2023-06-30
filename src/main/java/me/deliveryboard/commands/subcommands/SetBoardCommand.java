package me.deliveryboard.commands.subcommands;

import me.deliveryboard.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import static me.deliveryboard.DeliveryBoard.plugin;

public class SetBoardCommand extends SubCommand {
    @Override
    public String getName() {
        return "setboard";
    }

    @Override
    public String getDescription() {
        return "Sets the target block as a board that shows the delivery board on right click.";
    }

    @Override
    public String getSyntax() {
        return "/db setboard";
    }

    @Override
    public String getPermissionNode() {
        return "deliveryboard.setboard";
    }

    @Override
    public void perform(Player p, String[] args) {
        if (p.getTargetBlockExact(7) == null || p.getTargetBlockExact(7).getType() == Material.AIR) return;
        String configBoardLocation = plugin.getConfig().getString("board-location");
        Location boardLocation = p.getTargetBlock(null, 7).getLocation();
        int x = (int) boardLocation.getBlockX();
        int z = (int) boardLocation.getBlockZ();
        int y = (int) boardLocation.getBlockY();

        String locationString = x + "/" + y + "/" + z;

        if (configBoardLocation.isEmpty()) {
            plugin.getConfig().set("board-location", locationString);
            plugin.saveConfig();
            p.sendMessage(ChatColor.AQUA + "Board has been successfully setup.");
        } else {
            p.sendMessage(ChatColor.YELLOW + "Overriding previous board location at" + ChatColor.GRAY + "(" + configBoardLocation + ")");
            plugin.getConfig().set("board-location", locationString);
            plugin.saveConfig();
            p.sendMessage(ChatColor.AQUA + "Board has been successfully setup.");
        }
    }
}