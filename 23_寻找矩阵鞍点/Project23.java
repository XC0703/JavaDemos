package Ѱ�Ҿ��󰰵�;
import java.util.Scanner;
public class Project23 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[10][10];
		int [] max=new int[10];//max����Ĭ�ϳ�ֵΪ0
		int [] min=new int[10];
		for(int i=0;i<10;i++)
		{
			min[i]=10000;//��min���鸳��ֵ
		}
		int flag=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j] = sc.nextInt();
		for(int i=0;i<n;i++)
		    for(int j=0;j<n;j++) 
		    {
		      if(a[i][j]>max[i])//�����ڸ���������Ԫ��
		        max[i]=a[i][j];
		      if(a[i][j]<min[j])//�����ڸ�������С��Ԫ��
		        min[j]=a[i][j];
		    }
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)//ĳһ��Ԫ�������ڸ���������ڸ�������С
			{if(a[i][j]==max[i]&&a[i][j]==min[j])
			    {
				System.out.println(i+" "+j);
			    flag=1; 
			    }
			}
		if(flag==0)//���Ҳ�������
		System.out.println("NONE");
	}
}
