package ��������������ʽ;
import java.util.Scanner;
public class Project22 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();//����nextLine()������ȡ������ʽ
		int[] a = new int[100];//���ڴ洢����
		String[] strs = str.split("\\+|\\-|\\*|\\/|\\=");//��ȡ����
		String[] strss = str.split("\\d+");//��ȡ�����
		for(int i=0;i<strs.length;i++)  
		{
			a[i]=Integer.parseInt(strs[i],10);
		}
		int b=a[0],i=0; 
		for(int j=1;j<strss.length;j++)//split�����ָ�ʱ������ָ���ڿ�ͷ���߽�β����Ĭ�ϲ���һ���գ����j��1��ʼ
	    {   //ע�⣬split�ָ�Ľ�����ַ�����Ҫ��˫����
			if(strss[j].equals("+"))
			{
				i++;
				b=b+a[i];
			}
		    else if(strss[j].equals("-"))
		    {
		    	i++;
		    	b=b-a[i];
		    }
		    else if(strss[j].equals("*"))
		    {
		    	i++;
		    	b=b*a[i];
		    }
		    else if(strss[j].equals("/"))
		    {
		    	i++;
		    	if(a[i]==0)
		    	{
		    		System.out.println("ERROR");
		    		break;
		    	}
		    	else
		    	b=b/a[i];
		    }
		    else if(strss[j].equals("="))
		    {
		    	System.out.println(b);//������
		    }
		
	   }	
  }
}
