package ��ӡ���ֽ�����;
import java.util.Scanner;
public class Test1 {
  public static void main(String[] args) {
   System.out.println("���������β���:");
   int a = new Scanner(System.in).nextInt();
   for(int i=1; i<=a; i++) {
   for(int j=(a-i)*3; j>=0; j--) {     //ʵ��ÿ������
   System.out.print(" ");
   }
   for(int j=i; j>=1; j--) {    //��ӡ��벿��
   if(j<10)System.out.print("  ");
   else System.out.print(" ");
   System.out.print(j);
   }
   for(int j=2; j<=i; j++) {  //��ӡ�Ұ벿��
   if(j<10)System.out.print("  ");
   else System.out.print(" ");
   System.out.print(j);
   }
   System.out.println("");
   }
   }
 }