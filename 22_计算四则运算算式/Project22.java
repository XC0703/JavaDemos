package 计算四则运算算式;
import java.util.Scanner;
public class Project22 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();//利用nextLine()方法读取整条算式
		int[] a = new int[100];//用于存储数字
		String[] strs = str.split("\\+|\\-|\\*|\\/|\\=");//提取数字
		String[] strss = str.split("\\d+");//提取运算符
		for(int i=0;i<strs.length;i++)  
		{
			a[i]=Integer.parseInt(strs[i],10);
		}
		int b=a[0],i=0; 
		for(int j=1;j<strss.length;j++)//split方法分割时，如果分割符在开头或者结尾，会默认产生一个空，因此j从1开始
	    {   //注意，split分割的结果是字符串，要用双引号
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
		    	System.out.println(b);//输出结果
		    }
		
	   }	
  }
}
