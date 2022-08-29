package com.schoolvote.MCPlugin.Gongsun.AutoMine;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class Main extends JavaPlugin {

    Location loc = null;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("autoMine")) {
            Player p = Bukkit.getPlayer(args[0]);
            loc = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 2, p.getLocation().getBlockZ());
            if(Main.this.loc.getBlock().getType() == Material.AIR) {
                Random r = new Random();
                int oreNum = r.nextInt(99);
                if(oreNum < 59) {
                    Main.this.loc.getBlock().setType(Material.STONE);
                } else if(oreNum < 79) {
                    Main.this.loc.getBlock().setType(Material.IRON_ORE);
                } else if(oreNum < 94) {
                    Main.this.loc.getBlock().setType(Material.GOLD_ORE);
                } else if(oreNum < 99) {
                    Main.this.loc.getBlock().setType(Material.DIAMOND_ORE);
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Unknown command! Type /help to help.");
            return true;
        }
        return false;
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Au revoir, player");
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Loaded AutoMine Plugin by. TensorflowPepper");
    }
}
