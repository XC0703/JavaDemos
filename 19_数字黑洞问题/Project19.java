package ���ֺڶ�����;
import java.util.Scanner;
import java.util.Arrays;
public class Project19 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] a = new int[4];
		int max = 0;
		int min = 0;
		 //��֤��λ�����Ƿ�ȫ�����
	    if(num%10 == num/10%10 && num%10 == num/100%10 && num%10 == num/1000){
	    	System.out.println("N-N=0000");
		    }            
	    else{       
		while(num!=6174){
			for(int i=0;i<a.length;i++) {  //������λ�ϵ�����������
                a[i] = num%10;
                num = num/10;
            }  
			Arrays.sort(a); //��������
			max = a[0]+a[1]*10+a[2]*100+a[3]*1000;
            min = a[0]*1000+a[1]*100+a[2]*10+a[3];
            System.out.println(leftPad(max,4,'0')+"-"+leftPad(min,4,'0')+"="+leftPad(max-min,4,'0'));        
            num = max-min;
		}
		}
	}
//����һ��ǰ�油0�ķ���
	private static String leftPad(int num,final int maxLen,char filledChar){
		StringBuffer sb = new StringBuffer(); //StringBuffer��һ�����޸Ķ���
		String str = String.valueOf(num);  //��numת��Ϊ�ַ�������
		for(int i = str.length();i<maxLen;i++){//�ж�numλ���Ƿ�����Ҫ��
			sb.append(filledChar);  //ͨ��append�������丳ֵ
		}
		return sb.append(str).toString();//��ĩλ����str��ת��ΪString����  
	}
}