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
		String newMessage = e.getMessage();
		// <3 -> ♥ check
		if(e.getMessage().contains("<3")) {
			 newMessage = newMessage.replaceAll("<3", ChatColor.RED + "♥" + ChatColor.RESET);
		}
		
		//:shrug: ->  ¯\_(ツ)_/¯ check
		if(e.getMessage().contains(":shrug:")) {
			 newMessage = newMessage.replaceAll(":shrug:", "¯\\_(ツ)_/¯");
		}
		
		// :) -> 🙂 check
		if(e.getMessage().contains(":)")) {
			 newMessage = newMessage.replaceAll(":)", "🙂");
		}
		
		//:( -> 🙁 check
		
		if(e.getMessage().contains(":(")) {
			 newMessage = newMessage.replaceAll(":(", "🙁");
		}
		
		e.setMessage(newMessage);
		
		
	}

}
