package ����������֮�������;
import java.util.Scanner;
public class Project17 {
	    // ʮ�����·������ĺ�
		static int Add(int y, int m, int d)//�������涨��ĺ���Ҫ��̬������������
		{
			int mon[] = {0,31,59,90,120,151,181,212,243,273,304,334};
		    // ������ĺͣ���������ֱ�Ӽ�
		    int num = y * 365 + y/4 - y / 100 + y / 400;
		    // ���ϵ�����µ�����
		    num += mon[m-1];
		    // ��ǰ������
		    if(m > 2 && (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)))
		       num += 1;
		    // ���ϵ�����յ�����
		    num += d;
		    return num;
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nums[] = new String[2];
		/*�����ַ��������鲻���Ƴ��ȣ�������Ҫ��sc.nextLine();��������n�Ļس������µĻ�������������*/
		for(int i=0;i<nums.length;i++) {
			nums[i] = sc.next();
		   }
		 //��ȡ�Ӵ���ת��Ϊint��
         int y1 = Integer.parseInt(nums[0].substring(0,4));
         int m1 = Integer.parseInt(nums[0].substring(4,6));
         int d1 = Integer.parseInt(nums[0].substring(6,8));
         int y2 = Integer.parseInt(nums[1].substring(0,4));
         int m2 = Integer.parseInt(nums[1].substring(4,6));
         int d2 = Integer.parseInt(nums[1].substring(6,8));
         int n1 = Add(y1, m1, d1);
         int n2 = Add(y2, m2, d2);
         System.out.print( Math.abs(n1 - n2) + 1 );//����������
	}
}
