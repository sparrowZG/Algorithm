package main.java.com.sparrow.zg.人民币转换;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static char[] g = new char[]{'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖', '万', '亿', '元', '角', '分', '整'};


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double r = in.nextDouble();
		StringBuilder res = new StringBuilder("人民币");

		r = r * 100;
		int d = (int) r;
		ArrayList<Integer> arr = new ArrayList();
		while (d != 0) {
			arr.add(d % 10);
			d = d / 10;
		}
		int size = arr.size();
		if (size <= 6) {
			//千
			String str = findShiBaiQian(2,arr);
			String str2 = findJiaoFen(arr);
			System.out.println(str);
			System.out.println(str2);
		} else if (size <= 10) {
			//万
		} else {
			//亿
		}

	}
	public static String findJiaoFen(ArrayList<Integer> arrayList){
		int jiao = arrayList.get(1);
		int fen = arrayList.get(0);
		StringBuffer res = new StringBuffer();
		if(jiao==0&&fen==0){
			return "整";
		}else{
			if(jiao!=0){
				char temp = findShu(jiao);
				res.append(temp).append('角');
			}
			if(fen!=0){
				char temp = findShu(fen);
				res.append(temp).append('分');
			}
		}
		return res.toString();
	}
	public static String findShiBaiQian(int i, ArrayList<Integer> arrayList) {
		StringBuffer res = new StringBuffer();
		for (int x = 0; x < 4; x++) {
			if (i < arrayList.size()) {
				int index = arrayList.get(i);
				char temp = findShu(index);
				res.append(temp);
				if (x == 0) {
					res.append('拾');
				} else if (x == 1) {
					res.append('佰');
				} else if (x == 2) {
					res.append('仟');
				}
				i++;
			}
		}
		return res.reverse().toString();
	}

	public static char findShu(int i) {
		switch (i) {
			case 0:
				return g[0];
			case 1:
				return g[1];
			case 2:
				return g[2];
			case 3:
				return g[3];
			case 4:
				return g[4];
			case 5:
				return g[5];
			case 6:
				return g[6];
			case 7:
				return g[7];
			case 8:
				return g[8];
			case 9:
				return g[9];
		}
		return 0;
	}
}
