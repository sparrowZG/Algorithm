package main.java.com.sparrow.zg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_315_RightSum {
	public static void main(String[] args) {
		int[] arr = {0,2,1};
		System.out.println(countSmaller(arr));
	}

	public static List<Integer> countSmaller(int[] nums) {
		int[] res = new int[nums.length];
		mergerSort(nums, 0, nums.length - 1, res);
		List<Integer> list = new ArrayList<>();
		for (int re : res) {
			list.add(re);
		}
		return list;
	}

	private static void mergerSort(int[] nums, int l, int r, int[] res) {
		if (l == r) {
			return;
		}
		int mid = l + ((r - l) >> 1);
		mergerSort(nums, l, mid, res);
		mergerSort(nums, mid + 1, r, res);
		merger(nums, l, mid, r, res);
	}

	private static void merger(int[] nums, int l, int mid, int r, int[] res) {
		int[] help = new int[r - l + 1];
		int p1 = l;
		int p2 = mid + 1;
		int i = 0;
		while (p1 <= mid && p2 <= r) {
			if(nums[p1]<nums[p2]){
				help[i++] = nums[p2++];
			}else{
				help[i++] = nums[p1];
				res[p1]+= (r-p2+1);
				p1++;
			}
		}
		while (p1 <= mid) {
			help[i++] = nums[p1++];
		}
		while (p2 <= r) {
			help[i++] = nums[p2++];
		}
		for(i=0;i<help.length;i++){
			nums[l+i] = help[i];
		}
	}
}
