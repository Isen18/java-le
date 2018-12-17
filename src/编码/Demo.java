package 编码;

import java.io.UnsupportedEncodingException;

/**
 * 
 *<p>Title: SymmetricEncryption</p>
 *<p>Description: 
 *１）将字符串用指定的编码集合解析成字节数组，完成Unicode－〉charsetName转换
	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException　
	
      ２）将字节数组以指定的编码集合构造成字符串，完成charsetName－〉Unicode转换
	public String(byte[] bytes, String charsetName) throws UnsupportedEncodingException
	
	
	１）Unicode和GBK
	测试结果如下，每个汉字转换为两个字节，且是可逆的，即通过字节可以转换回字符串
	String－GBK〉ByteArray：/u0061/u4E2D/u6587（a中文）－〉0x61 0xD6 0xD0 0xCE 0xC4
	ByteArray－GBK〉String：0x61 0xD6 0xD0 0xCE 0xC4－〉/u0061/u4E2D/u6587（a中文）
 
	２）Unicode和UTF-8
	测试结果如下，每个汉字转换为三个字节，且是可逆的，即通过字节可以转换回字符串
	String－UTF-8〉ByteArray：/u0061/u4E2D/u6587（a中文）－〉0x61 0xE4 0xB8 0xAD 0xE6 0x96 0x87
	ByteArray－UTF-8〉String：0x61 0xE4 0xB8 0xAD 0xE6%0x96 0x87－〉/u0061/u4E2D/u6587（a中文）
	
	３）Unicode和ISO-8859-1
	测试结果如下，当存在汉字时转换失败，非可逆，即通过字节不能再转换回字符串
	String－ISO-8859-1〉ByteArray：/u0061/u4E2D/u6587（a中文）－〉0x61 0x3F 0x3F
	ByteArray－ISO-8859-1〉String：0x61 0x3F 0x3F－〉/u0061/u003F/u003F（a??）
	
	
	
	１）能够正确显示的中间不正确转换
	我们知道String－GBK〉ByteArray－GBK〉String是正确的，但如果我们采用String－GBK〉ByteArray－ISO-8859-1〉String呢？通过测试结果如下：
	String－GBK〉ByteArray－ISO-8859-1〉String：/u0061/u4E2D/u6587（a中文）－〉0x61 0xD6 0xD0 0xCE 0xC4－〉/u0061/u00D6/u00D0/u00CE/u00C4（a????）
	 
	这时我们得到的字符串为？乱码“a????”，但是通过继续转换我们仍然可以复原回正确的字符串“a中文”，过程如下：
	String－GBK〉ByteArray－ISO-8859-1〉String－ISO-8859-1〉ByteArray－GBK〉String
	对应：/u0061/u4E2D/u6587（a中文）－〉0x61 0xD6 0xD0 0xCE 0xC4－〉/u0061/u00D6/u00D0/u00CE/u00C4（a????）－〉0x61 0xD6 0xD0 0xCE 0xC4－〉/u0061/u4E2D/u6587（a中文）
	 
	也就是我们在首次构造字符串时，我们用了错误的编码集合得到了错误的乱码，但是我们通过错上加错，再用错误的编码集合获取字节数组，然后再用正确的编码集合构造，就又恢复了正确的字符串。这时就属于是“能够正确显示的中间不正确转换”。在Jsp页面提交数据处理时常常发生这种情况。
	 
	此外能够正确显示的中间不正确转换还有：
	String－UTF-8〉ByteArray－ISO-8859-1〉String－ISO-8859-1〉ByteArray－UTF-8〉String
	和
	String－UTF-8〉ByteArray－GBK〉String－GBK〉ByteArray－UTF-8〉String ————不一定正确，要根据中文字数
	对应：/u0061/u4E2D/u6587（a中文）－〉0x61 0xE4 0xB8 0xAD 0xE6%0x96 0x87－〉/u0061/u6D93/uE15F/u6783（a涓枃）－〉0x61 0xE4 0xB8 0xAD 0xE6%0x96 0x87－〉/u0061/u4E2D/u6587（a中文）
	
	
	４、编码过程中错误诊断参考
	１）一个汉字对应一个问号
	在通过ISO-8859-1从字符串获取字节数组时，由于一个Unicode转换成一个byte，当遇到不认识的Unicode时，转换为0x3F，这样无论用哪种编码构造时都会产生一个？乱码。
	２）一个汉字对应两个问号
	在通过GBK从字符串获取字节数组时，由于一个Unicode转换成两个byte，如果此时用ISO-8859-1或用UTF-8构造字符串就会出现两个问号。
	若是通过ISO-8859-1构造可以再通过上面所说的错上加错恢复（即再通过从ISO-8859-1解析，用GBK构造）；
	若是通过UTF-8构造则会产生Unicode字符＂/uFFFD＂，不能恢复，若再通过String－UTF-8〉ByteArray－GBK〉String，则会出现杂码，如a锟斤拷锟斤拷
	３）一个汉字对应三个问号
	在通过UTF-8从字符串获取字节数组时，由于一个Unicode转换成三个byte，如果此时用ISO-8859-1构造字符串就会出现三个问号；用GBK构造字符串就会出现杂码，如a涓枃。
	
	
 *</p>
 * @author zhyi
 * @data 2017年3月3日
 * @time 下午3:21:53
 * @version 1.0
 *
 */
public class Demo {
	public static void main(String[] args) {
		String str="a中文";//unicode utf-16
		try {
			byte[] buff=str.getBytes("GBK");//gbk
			System.out.println(buff.length);
			str = new String(buff,"UTF-8");
			buff = str.getBytes("UTF-8");
			System.out.println(buff.length);
			str = new String(buff,"GBK");
			System.out.println(str);
			
			
//			System.out.println(str.length());
//			byte[] buff=str.getBytes("UTF-8");//gbk
//			str = new String(buff,"GBK");
//			buff = str.getBytes("GBK");
//			str = new String(buff,"UTF-8");
//			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
