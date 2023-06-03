import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

class Receivers implements Runnable {
    private Socket skt;

    public Receivers(Socket socket) {
        this.skt = socket;
    }

    String receive_message() throws IOException {
        while (!this.skt.isClosed()) {
            InputStream inputStream = skt.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            return reader.readLine();
        }
        return "socket已关闭";
    }
    public void run() {
        try {
            System.out.println(receive_message());
            // put this return to Class ToScreen to make it seen to user.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}