

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class Server {

    ServerSocket serverSocket;



    public Server()  {
    }

    public void Process() {

        try {
            serverSocket = new ServerSocket(22) ;
            System.out.println("Server Starting...");
            IUser iUser = new ServerHandler();
            while (true) {

                Socket socket = serverSocket.accept();
                HandlerClient client = new HandlerUserImpl(iUser,socket);
                iUser.addUser(client);

            }

        } catch (IOException e) {
            throw new ArithmeticException("Port is not available");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new ArithmeticException("Check your Connection again");
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {


         new Server().Process();

    }

}


