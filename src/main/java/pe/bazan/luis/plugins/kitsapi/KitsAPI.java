package pe.bazan.luis.plugins.kitsapi;

import org.bukkit.plugin.java.JavaPlugin;
import pe.bazan.luis.plugins.kitsapi.commands.MainCommand;
import pe.bazan.luis.plugins.kitsapi.instances.Kit;

import javax.annotation.Nullable;

public final class KitsAPI extends JavaPlugin {
    private static KitsAPI instance;
    private KitsManager kitsManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        this.kitsManager = new KitsManager();
        registerCommands();
    }

    public void registerCommands() {
        getCommand("kitsapi").setExecutor(new MainCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public KitsManager getKitsManager() {
        return kitsManager;
    }

    public static KitsAPI getInstance() {
        return instance;
    }

    public static @Nullable Kit getKit(String name) {
        return getManager().getKit(name);
    }

    public static KitsManager getManager() {
        return instance.getKitsManager();
    }
}
