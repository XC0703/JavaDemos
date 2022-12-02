package ���֤����������;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class Project10 {

 public static void main(String[] args) {
   Scanner sc=new Scanner(System.in);//�û�����
   int n=sc.nextInt();
   sc.nextLine();
   String[] nums = new String[n];
   for(int i=0;i<n;i++) {
    String num = sc.next();
    nums[i] = num;
   }
   Comparator<String> com = new SortByAge();//����һ��������
   Arrays.sort(nums,com);
   boolean loop = true;
   while(loop) {
    String inputString = sc.next();
    switch (inputString) {
    case "sort1":
     for (String num:nums) {
      System.out.println(num.substring(6, 10)+"-"+num.substring(10, 12)+"-"+num.substring(12,14));
     }
     break;

    case "sort2":
     for (String num:nums) {
      System.out.println(num);
     }
     break;
     
    default:
     System.out.println("exit");
     loop = false;
     break;
    }
   }
   
   
  }
 }

/*�Զ����������*/
class SortByAge implements Comparator<String>{
 public int compare(String num1, String num2) {
  return num1.substring(6, 15).compareTo(num2.substring(6, 15));//��ȡ�ַ������Ƚ�
 }
}