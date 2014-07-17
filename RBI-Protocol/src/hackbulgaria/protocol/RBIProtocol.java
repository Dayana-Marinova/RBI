package hackbulgaria.protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RBIProtocol {
    static String EOM = "End of message!";
    int portNumber;
    static String inputLine;
    static StringBuilder readMessage;

    public static StringBuilder read(Socket socket) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (!(inputLine = input.readLine()).equals(EOM)) {
            readMessage.append(inputLine);
            readMessage.append('\n');
        }
        return readMessage;
    }

    public static void write(String message, Socket socket) throws IOException {
        PrintWriter outline = new PrintWriter(socket.getOutputStream());
        outline.println(message);
        outline.println(EOM);
        outline.flush();
    }

}
