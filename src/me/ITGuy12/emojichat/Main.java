package me.ITGuy12.emojichat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("emojis")) {
			cs.sendMessage(ChatColor.GOLD + "----------------------" + ChatColor.AQUA + "(EMOJIS)" + ChatColor.GOLD + "----------------------");
			cs.sendMessage(ChatColor.GREEN + "<3 --> ♥");
			cs.sendMessage(ChatColor.GREEN + ":shrug: --> ¯\\_(ツ)_/¯");
			cs.sendMessage(ChatColor.GREEN + ":) --> 🙂");
			cs.sendMessage(ChatColor.GREEN + ":( --> 🙁");
		}
		
		return false;
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		
		// <3 -> ♥ check
		if(e.getMessage().contains("<3")) {
			String newMessage = e.getMessage().replaceAll("<3", ChatColor.RED + "♥" + ChatColor.RESET);
			e.setMessage(newMessage);
		}
		
		//:shrug: ->  ¯\_(ツ)_/¯ check
		if(e.getMessage().contains(":shrug:")) {
			String newMessage = e.getMessage().replaceAll(":shrug:", "¯\\_(ツ)_/¯");
			e.setMessage(newMessage);
		}
		
		// :) -> 🙂 check
		if(e.getMessage().contains(":)")) {
			String newMessage = e.getMessage().replaceAll(":)", "🙂");
			e.setMessage(newMessage);
		}
		
		//:( -> 🙁 check
		
		if(e.getMessage().contains(":(")) {
			String newMessage = e.getMessage().replaceAll(":(", "🙁");
			e.setMessage(newMessage);
		}
		
		
		
	}

}
