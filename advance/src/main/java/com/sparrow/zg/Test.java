package main.java.com.sparrow.zg;

public class Test {

	//	public static void main(String[] args) {
//		StringBuffer a = new StringBuffer("A");
//		StringBuffer b = new StringBuffer("B");
//		operator(a,b);
//		System.out.println(a+","+b);
//	}
//
//	private static void operator(StringBuffer x, StringBuffer y) {
//		x.append(y);
//		y = x;
//	}
//
//	public static void main(String[] args) {
//		byte b1 = 1,b2 = 2 ,b3;
//		final byte b4 = 4,b5 = 6;
//		byte b6 = b4+b5;
//		b3 = (byte) (b1+b2);
//		System.out.println(b3+b6);
//
//	}
	public static void main(String[] args) {
		System.out.println(fib(15));

	}
	public static int fib(int res){
		int fib = 1;
		int pre = 1;
		for(int i = 0;i<1000001;i++){
			pre = fib;
			fib += pre ;
			if(res < fib) {
				System.out.println(res + ":" + fib);
				break;//前
			}
		}
		return Math.max(fib-res,res-pre);
	}
}
