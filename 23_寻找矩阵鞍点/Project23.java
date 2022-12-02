package 寻找矩阵鞍点;
import java.util.Scanner;
public class Project23 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[10][10];
		int [] max=new int[10];//max数组默认初值为0
		int [] min=new int[10];
		for(int i=0;i<10;i++)
		{
			min[i]=10000;//给min数组赋初值
		}
		int flag=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j] = sc.nextInt();
		for(int i=0;i<n;i++)
		    for(int j=0;j<n;j++) 
		    {
		      if(a[i][j]>max[i])//查找在该行上最大的元素
		        max[i]=a[i][j];
		      if(a[i][j]<min[j])//查找在该列上最小的元素
		        min[j]=a[i][j];
		    }
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)//某一个元素满足在该行上最大、在该列上最小
			{if(a[i][j]==max[i]&&a[i][j]==min[j])
			    {
				System.out.println(i+" "+j);
			    flag=1; 
			    }
			}
		if(flag==0)//查找不到鞍点
		System.out.println("NONE");
	}
}
