import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {

String IP_DO_SERVIDOR = "";
int PORTA = ;

String mensagem = "";

try {

            Socket socket = new Socket(IP_DO_SERVIDOR, PORTA);
            System.out.println("Connectado ao servidor com sucesso!");

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(mensagem.getBytes());
            outputStream.flush();
            System.out.println("Mensagem enviada ao servidor: " + mensagem);

            InputStream inputStream =socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            String response = byteArrayOutputStream.toString("UTF-8");
            System.out.println(response);

            byteArrayOutputStream.close();
            inputStream.close();
            outputStream.close();
            socket.close();

        } catch( IOException e) {
            System.out.println("Ocorreu um erro: "+ e.getMessage());
        }
    }
}