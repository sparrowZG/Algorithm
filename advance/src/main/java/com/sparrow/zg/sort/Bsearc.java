package main.java.com.sparrow.zg.sort;

public class Bsearc {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(bsearch(arr, 6));

	}

	/**
	 * 二分查找-非递归
	 * @param arr 要查找的有序数组
	 * @param value 查找的目标值
	 * @return 如果有返回对应数据的下标,没有返回-1
	 */
	public static int bsearch(int[] arr,int value){
		int lift = 0;
		int right = arr.length - 1;
		while(lift<=right){
			int mid = (right-lift)/2+lift;
			if(arr[mid]==value){
				return mid;
			}else if(arr[mid]<value){
				lift = mid+1;
			}else{
				right = mid-1;
			}
		}
		return -1;
	}
}
