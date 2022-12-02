package 进制转换问题;
import java.util.Scanner;
public class Project13 {

 public static void main(String[] args) {
  transform tra = new transform();
  Scanner sc=new Scanner(System.in);//用户输入
  int a,b,c,d;
  a = sc.nextInt();
  b = sc.nextInt();
  d = sc.nextInt();
  c=a+b;
  tra.digui(c,d);
  sc.close(); //关闭输入流
 }
}
//采用数学上 ‘数除以进制取余的方法’ 将余数从后往前存入一个String变量，来实现进制的转换
class transform{
  //递归求解，也可采用非递归循环的方式求解
  String a=" ";//给a附初始空值
  void digui(int n,int x) {
   String s=String.valueOf(n%x);//将余数转换成字符串
   if(n<x){
    a=s+a;
    System.out.println(a);
   }
   else {
    a=s+a;
    digui(n/x,x);
   }
  }
}