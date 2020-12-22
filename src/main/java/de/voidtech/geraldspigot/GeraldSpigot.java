package main.java.de.voidtech.geraldspigot;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import main.java.de.voidtech.geraldspigot.commands.TestCommand;

@Plugin(name = "GeraldSpigot", version = "0.0.1")
@Author(name = "Montori, 0xffset, ElementalMP4")
@Command(name = "test", desc = "test command")
public class GeraldSpigot extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.println("I'm here, where is my buddy Bottius?");
		this.getCommand("test").setExecutor(new TestCommand());
	}

	@Override
	public void onDisable() {

	}
}
