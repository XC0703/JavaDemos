package 英语句子颠倒输出问题;
import java.util.Scanner;
public class Project16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//利用nextLine()方法选择单词从而倒序输出
		String str = sc.nextLine().trim();//trim()方法用于去掉字符串开头和结尾的空格
	    String[] strs = str.split(" +");//split(" +")作用是将字符串按一个或多个空格进行拆分
	    for(int i=strs.length-1;i>=0;i--)  
	    {  
	        System.out.print(strs[i]);  
	        if(i!=0)  
	          System.out.print(" ");
	    }  
	}
}
