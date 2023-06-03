import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

class Senders implements Runnable {
    private Socket skt;
    String new_message;

    Senders(Socket skt, String new_message) {
        this.skt = skt;
        this.new_message = new_message;
    }

    void sendMessage() throws IOException{
        OutputStream outputStream;
        while (true) {
            if (!this.new_message.isEmpty()) {
                outputStream = skt.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println(new_message);
                writer.flush(); // 强制输出缓冲区中的数据
            }
        }
    }

    @Override
    public void run() {
        try {
            sendMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}