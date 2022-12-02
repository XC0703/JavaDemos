package 豆机游戏;

import java.util.*;
public class Test2 {

 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);//用户输入
  System.out.print("Enter the number of balls to drop:");
  int x=sc.nextInt();
  Scanner s=new Scanner(System.in);
  System.out.print("Enter the number of slots in the beanmachine:");
  int y=s.nextInt();
  
  int [] slots=new int[y];//实现逻辑
  Random r=new Random();
  for(int j=1;j<=x;j++) {
   int n=0;
  for(int i=1;i<=y-1;i++) {
  boolean b=r.nextBoolean();
  if(b==true) {
   char a='R';
   n++;
   System.out.print(a);
  }else {
   char c='L';
   System.out.print(c);
  }
  }
  slots[n]++;
  System.out.println();
  }
  /* 实现原理：
   *  1、通过系统提供的random函数随机等概率产生false或者true，模拟向左或向右
   *  2、一个R到第二槽，两个R到第三个槽，有n个R到第n个槽，没有R就到第一个槽
   * 实现逻辑：
   *  1、第一个for循环对输入的小球数目进行遍历，相当于在对小球进行编号，
   * 为下一步每个小球的运动过程生成做准备。
   *  2、第二个for循环是对每个小球向左或向右运动多少次的问题的解释
   * 也即是小球运动多少次的左或右才能到达最远处的槽（此处假设豆机的高度不固定）
   *  3、若豆机高度固定，则左或者右的次数也是固定的，
   * 若想每个槽都有可能有球，那么槽的个数也不能超过一定范围。
   *  4、数组slots用来模拟槽，n用来记录球向右时处在第几个槽，因为向左不产生影响，所以不考虑它。
   */
  
  
  
  int max=getmax(slots);//打印图形
  System.out.println(Arrays.toString(slots));
  for(int n=max;n>0;n--) {
   for(int k=0;k<slots.length;k++) {
    if(n<=slots[k]) {
     System.out.print("0 ");
    }else {
     System.out.print("  ");
    }
   }
   System.out.println();
  }
 for(int u=1;u<=y;u++) {
  System.out.print(u+" ");
 }
 }
 /*打印原理：
  * 1、第一个for循环是为了对数组进行遍历时，判断数组的各个位置有没有球
  * 如果有两个球的，下一层for循环会遍历两次，从而会在此处打印两个球出来
  * 2、第二个循环是对数组进行遍历，是为了取数组中的数，为if语句作铺垫
  * 3、其中if表达式是核心，需要自己去理解！
  * 4、反正实现到最后就是，数组中为0的地方打印空格，数字为1则内层循环只打印一次
  * 数字为2，内层循环会打印两次
  */
 
 
 
 public static int getmax(int []slots) {//获取slots数组中的最大球数
  int max=slots[0];
  for(int i=1;i<=slots.length-1;i++) {
   if(slots[i]>max) {
    max=slots[i];
   }
  }
  return max;
 }

}
