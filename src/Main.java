import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Victor on 15.09.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4040);
        while (true) {
            Socket clientSocket = server.accept();
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            PrintWriter writer = new PrintWriter(os, true);

            while (true) {
                String input = reader.readLine();
//                System.out.println("input = " + input);

                if ("exit".equals(input)) {
                    break;
                }
//                System.out.println("input = " + input);

                writer.println(input);
//                writer.flush();
            }
//            System.out.println(input);
        }
    }
}
