package 加密;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * 对称加密：DES、3DES、AES、IDEA、RC2、RC4、SKIPJACK、RC5算法
 *
 * <P>
 * DES算法为密码体制中的对称密码体制，又被成为美国数据加密标准，是1972年美国IBM公司研制的对称密码体制加密算法。
 * 明文按64位进行分组, 密钥长64位，密钥事实上是56位参与DES运算（第8、16、24、32、40、48、56、64位是校验位，
 * 使得每个密钥都有奇数个1）分组后的明文组和56位的密钥按位替代或交换的方法形成密文组的加密方法。
 * </P>
 *
 * <p>
 * 3DES(Triple DES),是DES向AES过渡的加密算法（1999年，NIST将3-DES指定为过渡的加密标准），是DES的一个更安全的变形。
 * 设Ek()和Dk()代表DES算法的加密和解密过程，K代表DES算法使用的密钥，P代表明文，C代表密文，
 * 这样， 　　
 * 3DES加密过程为：C=Ek3(Dk2(Ek1(P)))
 * 3DES解密过程为：P=Dk1((EK2(Dk3(C)))
 * </p>
 *
 * <p>
 * AES密码学中的高级加密标准（Advanced Encryption Standard，AES），又称 高级加密标准
 * Rijndael加密法，是美国联邦政府采用的一种区块加密标准。这个标准用来替代原先的DES，已经被多方分析且广为全世界所使用。
 * 经过五年的甄选流程，高级加密标准由美国国家标准与技术研究院（NIST）于2001年11月26日发布于FIPS PUB 197，
 * 并在2002年5月26日成为有效的标准。2006年，高级加密标准已然成为对称密钥加密中最流行的算法之一。 　　
 *
 * 该算法为比利时密码学家Joan Daemen和Vincent Rijmen所设计，结合两位作者的名字，以Rijndael之命名之，投稿高级加密标准的甄选流程。
 * （Rijdael的发音近于 "Rhinedoll"。）
 * </p>
 */
public class SymmetricEncrypt {

    /**
     * 提供对称密钥生成器的功能，支持各种算法
     */
    private KeyGenerator keygen;

    /**
     * 负责保存对称密钥
     */
    private SecretKey deskey;

    /**
     * 负责完成加密或解密工作
     */
    private Cipher cipher;

    public SymmetricEncrypt() throws NoSuchAlgorithmException, NoSuchPaddingException{
//        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        //实例化支持DES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)
        //DES、DESede(3DES)、AES
        keygen = KeyGenerator.getInstance("DES");
        //生成密钥
        deskey = keygen.generateKey();
        cipher = Cipher.getInstance("DES");
    }

    public byte[] encrypt(byte[] plaintext) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, deskey);
        return cipher.doFinal(plaintext);
    }

    public byte[] decrypt(byte[] ciphertext) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        return cipher.doFinal(ciphertext);
    }

    public static void main(String[] args) throws Exception {
        SymmetricEncrypt de1 = new SymmetricEncrypt();
        String msg ="hello world!";
        byte[] ciphertext = de1.encrypt(msg.getBytes());
        byte[] plaintext = de1.decrypt(ciphertext);
        System.out.println("明文是:" + msg);
        System.out.println("加密后:" + new String(ciphertext));
        System.out.println("解密后:" + new String(plaintext));
    }

}
