package java8;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * java8.Base64Demo
 *
 * @author Isen
 * @description
 * @date 2018/7/25 23:23
 **/
public class Base64Demo {
    public static void main(String args[]){
        try {

            //使用基本编解码器
            //编码
            String base64encodedString = Base64.getEncoder().encodeToString("java8 基本编码器".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);

            //解码
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
            System.out.println("Base64 解码字符串 (基本) 的原始字符串: " + new String(base64decodedBytes, "utf-8"));

            //使用URL编解码器
            //编码
            base64encodedString = Base64.getUrlEncoder().encodeToString("java8 URL编码器".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);

            //解码
            base64decodedBytes = Base64.getUrlDecoder().decode(base64encodedString);
            System.out.println("Base64 解码字符串 (URL) 的原始字符串: " + new String(base64decodedBytes, "utf-8"));

            //使用MIME编解码器
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }

            //编码
            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);

            //解码
            base64decodedBytes = Base64.getMimeDecoder().decode(mimeEncodedString);
            System.out.println("Base64 解码字符串 (MIME) 的原始字符串: " + new String(base64decodedBytes, "utf-8"));

        }catch(UnsupportedEncodingException e){
            System.out.println("Error :" + e.getMessage());
        }
    }
}
