import java.io.*;
import java.net.*;

public class PhraseServer {
    String[] phraseList = {"And another one bites the dust!", "Don't eat yellow snow",
    "Did I leave the stove on?", "Bazinga!", "What's up?",
    "This is a public service announcement."};

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while(true) {
                Socket sock = serverSocket.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String phrase = getPhrase();
                writer.println(phrase);
                writer.close();
                System.out.println(phrase);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getPhrase() {
        int random = (int) (Math.random() * phraseList.length);
        return phraseList[random];
    }

    public static void main(String[] args) {
        PhraseServer server = new PhraseServer();
        server.go();
    }
}
