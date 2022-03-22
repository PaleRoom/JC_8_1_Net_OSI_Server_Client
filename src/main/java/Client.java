import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8090;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите свое имя, товарищ.");

            String clientResp1 = scanner.nextLine();
            out.println(clientResp1);
            String serverResp1 = in.readLine();
            System.out.println(serverResp1);

            String serverMessage = in.readLine();
            System.out.println(serverMessage);

            String clientResp2 = scanner.nextLine();
            out.println(clientResp2);

            String ServerResp2 = in.readLine();
            System.out.println(ServerResp2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
