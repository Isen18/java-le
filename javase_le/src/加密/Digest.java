package 加密;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 单向加密(摘要)
 *
 * <p>
 * MD5  即Message-Digest Algorithm 5（信息-摘要算法 5），用于确保信息传输完整一致。
 * 是计算机广泛使用的杂凑算法之一（又译摘要算法、哈希算法），主流编程语言普遍已有MD5实现。
 * 将数据（如汉字）运算为另一固定长度值，是杂凑算法的基础原理，MD5的前身有MD2、MD3和MD4。
 * MD5的作用是让大容量信息在用数字签名软件签署私人密钥前被"压缩"成一种保密的格式
 * （就是把一个任意长度的字节串变换成一定长的十六进制数字串）。
 * 除了MD5以外，其中比较有名的还有sha-1、RIPEMD以及Haval等
 * </p>
 *
 * <p>
 * SHA 是一种数据加密算法，该算法经过加密专家多年来的发展和改进已日益完善，现在已成为公认的最安全的散列算法之一，并被广泛使用。
 * 该算法的思想是接收一段明文，然后以一种不可逆的方式将它转换成一段（通常更小）密文，也可以简单的理解为取一串输入码（称为预映射或信息），
 * 并把它们转化为长度较短、位数固定的输出序列即散列值（也称为信息摘要或信息认证代码）的过程。
 * 散列函数值可以说时对明文的一种“指纹”或是“摘要”所以对散列值的数字签名就可以视为对此明文的数字签名。
 * </p>
 */
public class Digest {

    public byte[] digest(byte[] text) throws NoSuchAlgorithmException {
        //支持MD5、SHA-1、SHA-256
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(text);
        return md5.digest();
    }

    public static void main(String args[]) throws NoSuchAlgorithmException{
        String msg = "hello word!";
        Digest digest = new Digest();
        byte[] digestText = digest.digest(msg.getBytes());

        System.out.println("密文是：" + new String(digestText));
        System.out.println("明文是：" + msg);
    }
}
