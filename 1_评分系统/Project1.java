package ����ϵͳ;
import java.util.Scanner;
public class Project1 {

 public static void main(String[] args) {
  //����һ��ɨ����
  Scanner sc = new Scanner (System.in);
  //����ɨ����ɨ��Ӽ������������
  int[] arr = new int[10];
  //�����ֵ�Ž�������
  System.out.println("��¼��ɼ����Կո����:");
  for(int i =0; i < arr.length ; i++) {
   int a = sc.nextInt();
   arr[i] = a;
  }
  //��������Сֵ
  int min = arr[0];
   for(int j = 1; j < arr.length ; j++) {
  
    if(arr[j] < min) {
    
     min = arr[j];
    }
  }
  //���������ֵ
  int max = arr[0];
   for(int k = 1; k < arr.length ; k++) {
  
    if(arr[k] > max) {
    
     max= arr[k];
    }
  }
  //������֮��
  int sum = 0;
  for(int i = 0; i < arr.length ; i++) {
  
   sum += arr[i];
  }
  //������ȥ�������С�����ƽ��ֵ
  double average = (sum - max - min) / 8.0;
  System.out.println("\n��߳ɼ�Ϊ:" + max);
  System.out.println("\n��ͳɼ�Ϊ:" + min);
  System.out.println("\nƽ���ɼ�Ϊ:" + average + "\n");
 }
}