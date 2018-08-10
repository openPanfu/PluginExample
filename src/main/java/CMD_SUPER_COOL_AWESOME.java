import org.openpanfu.gameserver.PanfuPacket;
import org.openpanfu.gameserver.User;
import org.openpanfu.gameserver.handler.IHandler;

public class CMD_SUPER_COOL_AWESOME implements IHandler {
    @Override
    public void handlePacket(PanfuPacket packet, User sender) {
        sender.sendAlert("You ran the super cool awesome command!");
    }
}
