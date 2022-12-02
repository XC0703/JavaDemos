package 高空坠球问题;
import java.util.Scanner;
public class Project8 {

 public static void main(String[] args) {
  // TODO 自动生成的方法存根
  int i;
  double sn=0;
  Scanner s = new Scanner(System.in);
  double an=s.nextDouble();
  int n=s.nextInt();
  sn=an;      //n==1时的情况
  //n==0时的情况
  if(n==0)
  {
   sn=0;
   an=0;
  }
  //从2到n循环
  for(i=2;i<=n;i++)
  {
   an=an/2.0;
   sn=sn+2.0*an;
  }
  an=an/2.0;   //不要忘记再除以2下落多走了一遍 
   System.out.print(String.format("%.1f",sn)); 
   System.out.print(" "); 
   System.out.println(String.format("%.1f",an)); 
 }

}