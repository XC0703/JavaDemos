package Ӣ����ӵߵ��������;
import java.util.Scanner;
public class Project16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//����nextLine()����ѡ�񵥴ʴӶ��������
		String str = sc.nextLine().trim();//trim()��������ȥ���ַ�����ͷ�ͽ�β�Ŀո�
	    String[] strs = str.split(" +");//split(" +")�����ǽ��ַ�����һ�������ո���в��
	    for(int i=strs.length-1;i>=0;i--)  
	    {  
	        System.out.print(strs[i]);  
	        if(i!=0)  
	          System.out.print(" ");
	    }  
	}
}
