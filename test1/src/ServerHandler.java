

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerHandler implements IUser {

    private List<HandlerClient> handlerClients;

    public ServerHandler()
    {
        this.handlerClients = new ArrayList<>();

    }

    @Override
    public void SendData(String message, HandlerClient handlerClient) throws IOException {

           for(HandlerClient u : this.handlerClients) {
               u.BuW.writeObject(message);
               u.BuW.flush();
           }
    }

    @Override
    public void addUser(HandlerClient user) {
        this.handlerClients.add(user);

    }

}
