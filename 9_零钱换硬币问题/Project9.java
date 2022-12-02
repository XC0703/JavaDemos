package 零钱换硬币问题;
import java.util.Scanner;
public class Project9 {

 public static void main(String[] args) {
  // TODO 自动生成的方法存根
  int k=0,total,count=0,i,j;
  int x = new Scanner(System.in).nextInt();
     for(i=(x-3)/5;i>=1;i--)
     {
         for(j=(x-5*i-1)/2;j>=1;j--)
         {
             k=x-5*i-2*j;
             total=i+j+k;
             System.out.print("fen5: ");
             System.out.print(i);
             System.out.print(",");
             System.out.print("fen2: ");
             System.out.print(j);
             System.out.print(",");
             System.out.print("fen1: ");
             System.out.print(k);
             System.out.print(",");
             System.out.print("total: ");
             System.out.println(total);
             count++;
         }
     }
     System.out.print("count= ");
     System.out.println(count);
 }

}