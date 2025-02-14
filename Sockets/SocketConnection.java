import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {

String Server_IP = "10.130.129.103";
int PORT = 12345;
String myMensage = "MjAxNw==";

try {

            Socket socket = new Socket(Server_IP, PORT);
            System.out.println("connected");

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(myMensage.getBytes());
            outputStream.flush();
            System.out.println("Mensage that was sent: " + myMensage);

            InputStream inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            String serverResponse = byteArrayOutputStream.toString("UTF-8");
            System.out.println(serverResponse);

            byteArrayOutputStream.close();
            inputStream.close();
            outputStream.close();
            socket.close();

        } catch( IOException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
}
