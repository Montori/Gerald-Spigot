package source;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLevel implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String cmd = command.getName().toLowerCase();

        if (!cmd.equals("setlevel") || args.length != 1)
            return false;

        sender.sendMessage("source.Hello!");
        int level;

        try {
            level = Integer.parseInt(args[0]);
            if (level < 0)
                throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            sender.sendMessage("Only valid numeric numbers allowed!");
            return false;
        } catch (IllegalArgumentException e) {
            sender.sendMessage("Only levels 0+ allowed!");
            return false;
        }

        ((Player) sender).setLevel(level);
        sender.sendMessage("Level successful changed");
        return true;
    }
}
