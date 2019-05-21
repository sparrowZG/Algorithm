package main.java.com.sparrow.zg.niuke.Code_5_21;

/**
 *
 */
public class CodeBoulter {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,0};
		System.out.println(count(arr, arr.length));

	}

	public static int count(int[] A, int n) {
		//数组的逆序对
		//求的是后面几个数比当前数小
		int l = 0;
		int r = n - 1;
		int res = mergerPire(A, l, r);
		return res;
	}

	private static int mergerPire(int[] a, int l, int r) {
		if (r == l) {
			return 0;
		}
		int mod = l + (r - l) / 2;

		;
		return mergerPire(a, l, mod)+mergerPire(a, mod + 1, r)+merger(a, l, mod, r);
	}

	private static int merger(int[] a, int l, int mod, int r) {
		int[] help = new int[r - l + 1];
		int p1 = l;
		int p2 = mod + 1;
		int res = 0;
		int  i = 0;
		while (p1 <= mod && p2 <= r) {
			res += a[p1] < a[p2] ? (r - p2 + 1) : 0;
			help[i++] = a[p1] < a[p2] ? a[p2++] : a[p1++];
		}
		while (p1<=mod){
			help[i++] = a[p1++];
		}
		while (p2<=r){
			help[i++] = a[p2++];
		}
		for(i=0;i<help.length;i++){
			a[l+i] = help[i];
		}
		return res;
	}
}

