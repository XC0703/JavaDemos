package �ж��Ƿ�Ϊ���Ĵ�;
import java.util.Scanner;
public class Project12 {

 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);//�û�����
  int arr[] = new int[255];            //����洢�ַ���������
  String str = sc.nextLine();    //�Ӽ���������ַ���
  int j = str.length() - 1;   //���ַ����ĳ���-1֮��ֵ��j
  for (int i = 0; i < str.length(); i++) { //���ַ����洢��������
   arr[i] = str.charAt(i);
  }
  int flag = 1;
  for (int i = 0; i < j; i++, j--) {   //�ж��������߶ԳƵ�λ���Ƿ��в���ȵ�Ԫ��
   if (arr[i] != arr[j]) {
    flag = 0;
    break;
   }
  }
     //���
  if (flag == 1) {
   System.out.print("YES");
  } 
  else {
   System.out.print("NO");
  }
 }
}