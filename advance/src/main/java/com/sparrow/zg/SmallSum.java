package main.java.com.sparrow.zg;

/**
 * 分治思想: 最小和问题:求一个数组每个数左边比当前数小的累加起来
 */
public class SmallSum {
	public static void main(String[] args) {
		int[] arr = {1,3,4,2,5};
		System.out.println(smallSum(arr));
	}

	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int l = 0;
		int r = arr.length - 1;
		return mergerSort(arr, l, r);
	}

	public static int mergerSort(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		int mid = l + ((r - l) >> 1);
		return mergerSort(arr, l, mid) + mergerSort(arr, mid + 1, r) + merger(arr, l, mid, r);
	}

	public static int merger(int[] arr, int l, int mid, int r) {
		int[] help = new int[r - l + 1];
		int p1 = l;
		int p2 = mid + 1;
		int i = 0;
		int res = 0;
		while (p1 <= mid && p2 <= r) {
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for(i=0;i<help.length;i++){
			arr[l+i] = help[i];
		}
		return res;
	}

}
