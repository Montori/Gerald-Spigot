package source;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class GeraldSpigot extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        Objects.requireNonNull(getCommand("hello?")).setExecutor(new Hello());
        Objects.requireNonNull(getCommand("setlevel")).setExecutor(new SetLevel());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
