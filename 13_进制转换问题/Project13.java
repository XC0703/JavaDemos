package ����ת������;
import java.util.Scanner;
public class Project13 {

 public static void main(String[] args) {
  transform tra = new transform();
  Scanner sc=new Scanner(System.in);//�û�����
  int a,b,c,d;
  a = sc.nextInt();
  b = sc.nextInt();
  d = sc.nextInt();
  c=a+b;
  tra.digui(c,d);
  sc.close(); //�ر�������
 }
}
//������ѧ�� �������Խ���ȡ��ķ����� �������Ӻ���ǰ����һ��String��������ʵ�ֽ��Ƶ�ת��
class transform{
  //�ݹ���⣬Ҳ�ɲ��÷ǵݹ�ѭ���ķ�ʽ���
  String a=" ";//��a����ʼ��ֵ
  void digui(int n,int x) {
   String s=String.valueOf(n%x);//������ת�����ַ���
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