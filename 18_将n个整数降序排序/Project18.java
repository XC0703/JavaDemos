package ��n��������������;
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
		for(int i=0;i<nums.length;i++) {  //ð������
			for(int j=0;j<nums.length-i-1;j++){//ÿ�������Ѿ���i����ȷ��λ��
				if(nums[j]<nums[j+1]){
					temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
				}
			}
		   }
		//�����ȷ����βû�пո�
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
