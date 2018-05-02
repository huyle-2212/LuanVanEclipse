

import java.io.IOException;

public interface IUser {

    void SendData(String message, HandlerClient handlerClient) throws IOException;
    void addUser(HandlerClient user);
}
