package main.java.com.sparrow.zg.快速排序;


import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 4, 5, 5, 6, 3, 6, 6, 7, 8,};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length <= 0) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			int[] p = parration(arr, l, r);
			quickSort(arr, l, p[0]);
			quickSort(arr, p[1], r);
		}
	}

	private static int[] parration(int[] arr, int l, int r) {
		int less = l;
		int more = r;
		int i = l;
		while (i < more) {
			if (arr[i] < arr[r]) {
				swap(arr, less, i);
				i++;
				less++;
			} else if (arr[i] == arr[r]) {
				i++;
			} else {
				while (more > i && arr[more] > arr[r]) {
					more--;
				}
				swap(arr, i, more);
				more--;
			}
		}
		return new int[]{less - 1, more + 1};
	}

	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

}
