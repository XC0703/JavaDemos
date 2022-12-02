package 判断是否为回文串;
import java.util.Scanner;
public class Project12 {

 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);//用户输入
  int arr[] = new int[255];            //定义存储字符串的数组
  String str = sc.nextLine();    //从键盘中输出字符串
  int j = str.length() - 1;   //将字符串的长度-1之后赋值给j
  for (int i = 0; i < str.length(); i++) { //将字符串存储在数组中
   arr[i] = str.charAt(i);
  }
  int flag = 1;
  for (int i = 0; i < j; i++, j--) {   //判断数组两边对称的位置是否有不相等的元素
   if (arr[i] != arr[j]) {
    flag = 0;
    break;
   }
  }
     //输出
  if (flag == 1) {
   System.out.print("YES");
  } 
  else {
   System.out.print("NO");
  }
 }
}