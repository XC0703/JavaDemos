package 将n个整数降序排序;
import java.util.Scanner;
public class Project18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		int temp;
		for(int i=0;i<nums.length;i++) {
			nums[i] = sc.nextInt();
		   }
		for(int i=0;i<nums.length;i++) {  //冒泡排序
			for(int j=0;j<nums.length-i-1;j++){//每轮排序已经有i个数确定位置
				if(nums[j]<nums[j+1]){
					temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
				}
			}
		   }
		//输出且确保结尾没有空格
		for(int i=0;i<nums.length;i++) {
			if(i<nums.length-1){
				System.out.print(nums[i]+" ");
			}
			else{
				System.out.print(nums[i]);
			}
		   }
	}
}
