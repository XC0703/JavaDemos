package 评分系统;
import java.util.Scanner;
public class Project1 {

 public static void main(String[] args) {
  //创建一个扫描器
  Scanner sc = new Scanner (System.in);
  //调用扫描器扫描从键盘输入的数组
  int[] arr = new int[10];
  //输入的值放进数组中
  System.out.println("请录入成绩并以空格隔开:");
  for(int i =0; i < arr.length ; i++) {
   int a = sc.nextInt();
   arr[i] = a;
  }
  //求数组最小值
  int min = arr[0];
   for(int j = 1; j < arr.length ; j++) {
  
    if(arr[j] < min) {
    
     min = arr[j];
    }
  }
  //求数组最大值
  int max = arr[0];
   for(int k = 1; k < arr.length ; k++) {
  
    if(arr[k] > max) {
    
     max= arr[k];
    }
  }
  //求数组之和
  int sum = 0;
  for(int i = 0; i < arr.length ; i++) {
  
   sum += arr[i];
  }
  //求数组去除最大最小数后的平均值
  double average = (sum - max - min) / 8.0;
  System.out.println("\n最高成绩为:" + max);
  System.out.println("\n最低成绩为:" + min);
  System.out.println("\n平均成绩为:" + average + "\n");
 }
}