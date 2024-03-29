package pe.bazan.luis.plugins.kitsapi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pe.bazan.luis.plugins.kitsapi.KitsAPI;
import pe.bazan.luis.plugins.kitsapi.api.KitsHelper;
import pe.bazan.luis.plugins.kitsapi.utils.MessageFormater;

public class ClearPermanentKit {

    public ClearPermanentKit(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(MessageFormater.formatMC("Use: /kitsapi clear-permanent <player/all>"));
            return;
        }
        Player player = Bukkit.getPlayer(args[1]);

        if (player == null && !args[1].equalsIgnoreCase("all")) {
            sender.sendMessage(MessageFormater.formatMC("Player not found"));
            return;
        }

        if (args[1].equalsIgnoreCase("all")) {
            for (Player playerOnline : Bukkit.getOnlinePlayers()) {
                KitsHelper.getKitManager(KitsAPI.getInstance()).cancelTrack(playerOnline);
            }
            sender.sendMessage(MessageFormater.formatMC("Cancel track of the kit for all players."));
        } else {
            KitsHelper.getKitManager(KitsAPI.getInstance()).cancelTrack(player);
            sender.sendMessage(MessageFormater.formatMC(String.format("Cancel track of the kit for %s.", player.getName())));
        }
    }
}
