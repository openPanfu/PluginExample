import org.openpanfu.gameserver.User;
import org.openpanfu.gameserver.commands.Commands;
import org.openpanfu.gameserver.handler.Handler;
import org.openpanfu.gameserver.plugin.Plugin;
import org.openpanfu.gameserver.util.Logger;

public class ExamplePlugin extends Plugin {
    @Override
    public boolean onStartup() {
        Logger.info("Starting ExamplePlugin, registering commands.");
        // Register the command !mass
        if(!Commands.registerCommand("mass", new MassCommand())) {
            Logger.error("Failed to register command mass!");
        }

        // Register a custom packet with header 888
        Handler.addPacketHandler(888, new CMD_SUPER_COOL_AWESOME());

        // This plugin will handle player connects and chats, so we're going to listen.
        // Since we're going to listen, we return true.
        return true;
    }

    @Override
    public void onUserConnect(User user) {
        Logger.debug(String.format("[ExamplePlugin] User %s joined", user.getUsername()));
    }

    @Override
    public void onUserChat(User user, String message) {
        Logger.debug(String.format("[ExamplePlugin] User %s said %s", user.getUsername(), message));
    }

    @Override
    public boolean handleUserConnect(User user) {
        return true;
    }

}
