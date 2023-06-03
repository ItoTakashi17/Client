import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String serverAddress = "localhost";  // 服务器IP地址
        int serverPort = 6868;  // 服务器端口号
        // 创建一个Socket连接到服务器
//        String secret_key = "ydtwcdws";
//        int uid = input.nextInt();
//        String password = input.next();
//        String encrypted_uid = DesUtils.encrypt(String.valueOf(uid), secret_key);
//        String encrypted_password = DesUtils.encrypt(password, secret_key);
//        String encrypted_uid_pwd = encrypted_uid + encrypted_password;
        Socket socket = new Socket(serverAddress, serverPort);
        new Thread(new Receivers(socket));
        new Thread(new Senders(socket, "hello")).start();// Only people click the login button, be the function used again.
        System.out.println("ceshi");
//        new Receivers(socket);
    }


    static class Feedback{
        public String returnFeedback(String feedback){
            if(feedback.equals("-1"))
                return "Wrong uid or password";
            else if(feedback.equals("-2"))
                return "We didn't find this uid";
            else return "Login properly.";
        }
    }
}
