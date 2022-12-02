package 打印数字金字塔;
import java.util.Scanner;
public class Test1 {
  public static void main(String[] args) {
   System.out.println("输入三角形层数:");
   int a = new Scanner(System.in).nextInt();
   for(int i=1; i<=a; i++) {
   for(int j=(a-i)*3; j>=0; j--) {     //实现每行缩进
   System.out.print(" ");
   }
   for(int j=i; j>=1; j--) {    //打印左半部分
   if(j<10)System.out.print("  ");
   else System.out.print(" ");
   System.out.print(j);
   }
   for(int j=2; j<=i; j++) {  //打印右半部分
   if(j<10)System.out.print("  ");
   else System.out.print(" ");
   System.out.print(j);
   }
   System.out.println("");
   }
   }
 }