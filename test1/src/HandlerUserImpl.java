

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class HandlerUserImpl extends HandlerClient {

    public HandlerUserImpl(IUser iUser, Socket socket) throws IOException, SQLException, ClassNotFoundException {
        super(iUser, socket);
    }

    @Override
    public void Send(String message) throws IOException {
        System.out.println(" Send Message:: "+message+" to"+this.DeviceID);
        iUser.SendData(message, this);
    }

    @Override
    public void Receive(String message) {

        System.out.println(this.DeviceID+" Received message: "+message);

    }
}
