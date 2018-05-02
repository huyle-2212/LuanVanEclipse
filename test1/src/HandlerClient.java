

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

public abstract class HandlerClient extends Thread {

    protected IUser iUser;
    protected String DeviceID;
    protected BufferedReader BuR;
    protected ObjectOutputStream BuW;
    public static int count = 0;


    public HandlerClient(IUser iUser, Socket socket) throws IOException, SQLException, ClassNotFoundException {

        this.iUser = iUser;
        BuR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BuW = new ObjectOutputStream(socket.getOutputStream());
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {

                String content = BuR.readLine();
                System.out.println(content);
                Send(content);
               
             

            } catch (IOException e) {
                System.out.println("Socket Error");
            }
        }

    }

    public abstract void Send(String message) throws IOException;
    public abstract void Receive(String message);
}
