package 求小于2000的质数;

public class Project3 {

 public static void main(String[] args) {
  // TODO 自动生成的方法存根
  boolean flag;
  for(int i=2;i<2000;i++) {
   flag=true; //flag要放在循环里面，每个循环都要重新赋值
   for(int j=2;j<=Math.sqrt(i);j++) { //i取根号比除2这样效率高些
    if(i%j==0) {
     flag=false;
     break;
    }
   }
   if(flag) {
    System.out.println(i+" ");
   }
  }

 }

}