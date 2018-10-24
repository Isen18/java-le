package test;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

class Object{
	int a = 10;
}

public class Demo1 {
	public static void main(String[] args) {
//		Object o = new Object();
//		System.out.println(o.a);
//		ByteBuffer.allocate(10);
//		Date date = new Date();
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//		String daStr = sdf.format(date);
//		System.out.println(daStr);

		Integer a = 1 << 29;
//		Integer a = -1;
		System.out.printf(Integer.toBinaryString(a));
	}
}
