import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DesUtils {

    private static final String ALGORITHM = "DES";
    private static final String CHARSET_NAME = "UTF-8";
    static String key = "dwgy8ey";

    /**
     * 加密方法
     * @param data 要加密的数据
     * @param key 密钥
     * @return 加密后的数据
     */
    public static String encrypt(String data, String key) throws Exception {
        // 创建密钥
        SecretKey secretKey = new SecretKeySpec(key.getBytes(CHARSET_NAME), ALGORITHM);
        // 创建加密器
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        // 加密数据
        byte[] encryptedData = cipher.doFinal(data.getBytes(CHARSET_NAME));
        // 将加密后的数据转换为 Base64 编码的字符串
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    /**
     * 解密方法
     * @param data 要解密的数据
     * @param key 密钥
     * @return 解密后的数据
     */
    public static String decrypt(String data, String key) throws Exception {
        // 创建密钥
        SecretKey secretKey = new SecretKeySpec(key.getBytes(CHARSET_NAME), ALGORITHM);
        // 创建解密器
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        // 将 Base64 编码的字符串转换为字节数组
        byte[] encryptedData = Base64.getDecoder().decode(data);
        // 解密数据
        byte[] decryptedData = cipher.doFinal(encryptedData);
        // 将解密后的数据转换为字符串
        return new String(decryptedData, CHARSET_NAME);
    }

    public static void main(String[] args) throws Exception {
        String data = "Hello, World!"; // 要加密的数据
        String key = "9dg83892"; // 密钥
        String encryptedData = encrypt(data, key); // 加密
        String decryptedData = decrypt(encryptedData, key); // 解密
        System.out.println("加密前的数据：" + data);
        System.out.println("加密后的数据：" + encryptedData);
        System.out.println("解密后的数据：" + decryptedData);
    }
}