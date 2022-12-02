package 求特定序列的前N项之和;
import java.util.Scanner;
public class Project7 {

 public static void main(String[] args) {
  // TODO 自动生成的方法存根    
      int N = new Scanner(System.in).nextInt();
      double i=1.0;    
      double j=2.0;    
      double sum=0.0;    
      int k=1;    
      for(k=1;k<=N;k++){        
      sum+=j/i;        
      double x=i;        
      i=j;        
      j=j+x;          
      }       
      System.out.print(String.format("%.2f",sum));  
  
  
  
 }

}