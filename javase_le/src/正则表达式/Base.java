package 正则表达式;

public class Base {
//	Pattern
//	Matcher
//	PatternSyntaxException
	public static void main(String[] args) {
//		System
//		String str = new String();
		String str = "56×2";

		int idx = str.indexOf("折");
		if(idx != -1 && idx < str.indexOf("张")){
			System.out.println("不需要元");
		}else {
			System.out.println("元");
		}

	}
}
