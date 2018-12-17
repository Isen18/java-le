package 加密;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * 非对称加密
 *
 * <P>
 * RSA 公钥加密算法是1977年由Ron Rivest、Adi Shamirh和LenAdleman在（美国麻省理工学院）开发的。
 * RSA取名来自开发他们三者的名字。RSA是目前最有影响力的公钥加密算法，它能够抵抗到目前为止已知的所有密码攻击，
 * 已被ISO推荐为公钥数据加密标准。RSA算法基于一个十分简单的数论事实：将两个大素数相乘十分容易，
 * 但那时想要对其乘积进行因式分解却极其困难，因此可以将乘积公开作为加密密钥。
 * </P>
 *
 * <p>
 *  Digital Signature Algorithm (DSA)是Schnorr和ElGamal签名算法的变种，被美国NIST作为DSS(DigitalSignature Standard)。
 * </p>
 */
public class AsymmetricEncrypt {
    /**
     * 私钥
     */
    private PrivateKey privateKey;

    /**
     * 公钥
     */
    private PublicKey publicKey;

    /**
     * 负责完成加密或解密工作
     */
    private Cipher cipher;

    public AsymmetricEncrypt() throws NoSuchAlgorithmException, NoSuchPaddingException {
//        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        //提供非对称密钥生成器的功能，支持各种算法
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        //初始化密钥对生成器，密钥大小为1024位
        keyPairGenerator.initialize(1024);
        //生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();
        cipher = Cipher.getInstance("RSA");
    }

    protected byte[] encrypt(byte[] srcBytes) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] resultBytes = cipher.doFinal(srcBytes);
        return resultBytes;
    }

    protected byte[] decrypt(byte[] srcBytes) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] resultBytes = cipher.doFinal(srcBytes);
        return resultBytes;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        AsymmetricEncrypt asymmetricEncrypt = new AsymmetricEncrypt();
        String msg = "hello world";
        //用公钥加密
        byte[] ciphertext = asymmetricEncrypt.encrypt(msg.getBytes());

        //用私钥解密
        byte[] plaintext = asymmetricEncrypt.decrypt(ciphertext);

        System.out.println("明文是:" + msg);
        System.out.println("加密后是:" + new String(ciphertext));
        System.out.println("解密后是:" + new String(plaintext));
    }

}
