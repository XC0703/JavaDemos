package 求猴子摘桃数量;
import java.util.Scanner;
public class Project6 {

 public static void main(String[] args) {
  // TODO 自动生成的方法存根
       int peach=1,i;
       Scanner sc = new Scanner (System.in);
       //调用扫描器扫描从键盘输入的数组
       System.out.println("请输入天数：");
       int N = sc.nextInt();
       for(i=1;i<N;i++){
        peach=(peach+1)*2;
       }
       System.out.println("第一天摘桃数量为:");
       System.out.println(peach);
 }

}