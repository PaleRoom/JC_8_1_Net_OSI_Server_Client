import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8090;

        while (true) { try
                (ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("Обнаружено новое подключение");

            final String name = in.readLine();

            out.println(String.format("Здравствуй, %s, твой порт:  %d", name, clientSocket.getPort()));
            out.println("Ты взрослый? да/нет");
            final String clientResp = in.readLine();

            if (clientResp.equals("да")) {
                out.println(String.format("Можно отдохнуть или спокойно поработать, %s", name));
            } else if (clientResp.equals("нет")) {
                out.println(String.format("Добро пожаловать на игровую площадку, %s!", name));
            } else out.println("неверный ввод");

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
}
