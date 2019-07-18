package main.java.com.sparrow.zg.剑指Offer.数组中只出现一次的两个数;

/**
 * 知识点: 0 ^ n = n;
 *        a ^  b = diff;
 *        diff &= - diff;  得到的是 这个数中最低位 是1 的数
 *
 *
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Mian {
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		int diff = 0;
		for(int i = 0; i < array.length; i++){
			diff ^= array[i];
		}
		diff &= - diff;
		for(int num : array){
			if((num & diff) == 0){
				num1[0] ^= num;
			}else{
				num2[0] ^= num;
			}
		}
	}
}
