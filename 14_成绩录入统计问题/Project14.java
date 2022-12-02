package 成绩录入统计问题;
import java.util.Scanner;
public class Project14 {
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);//用户输入
  int count=sc.nextInt();
        int pass=0;
        int grade=0;  //grade要初始化，否则会错
        for (int i=0;i<count;i++){
         try{             //try代码块，当发生异常时会转到catch代码块中
            grade=sc.nextInt();
            if (grade<0||grade>100){
             throw new ScoreException("invalid!");  //出现异常时抛出信息
            }else if (grade>=60){
                pass++;
            }
            }  
         catch(ScoreException b){     
    System.out.println(grade + b.toString());
    i=i-1;
   }
        }
        System.out.println(pass);
        System.out.println(count-pass);
 }
}
//自定义异常类，继承自Exception类
class ScoreException extends Exception
{
 String message;
 public ScoreException(String message){ //构造函数
  this.message = message;
 }
 public String toString(){  //调用执行该异常类对象的toString（）方法
  return this.message;
 }
}