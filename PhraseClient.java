import java.io.*;
import java.net.*;

public class PhraseClient {

    public void go() {
        try {
            Socket sock = new Socket("127.0.0.1", 5000);

            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String phrase = reader.readLine();
            System.out.printf("Your lucky phrase: %s", phrase);

            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

        public static void main(String[] args) {
            PhraseClient client = new PhraseClient();
            client.go();
        }
}
