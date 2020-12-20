package source;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Hello implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String cmd = command.getName().toLowerCase();

        if (!cmd.equals("hello?"))
            return false;

        sender.sendMessage("source.Hello!");

        return true;
    }
}
