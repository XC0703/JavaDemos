package �߿�׹������;
import java.util.Scanner;
public class Project8 {

 public static void main(String[] args) {
  // TODO �Զ����ɵķ������
  int i;
  double sn=0;
  Scanner s = new Scanner(System.in);
  double an=s.nextDouble();
  int n=s.nextInt();
  sn=an;      //n==1ʱ�����
  //n==0ʱ�����
  if(n==0)
  {
   sn=0;
   an=0;
  }
  //��2��nѭ��
  for(i=2;i<=n;i++)
  {
   an=an/2.0;
   sn=sn+2.0*an;
  }
  an=an/2.0;   //��Ҫ�����ٳ���2���������һ�� 
   System.out.print(String.format("%.1f",sn)); 
   System.out.print(" "); 
   System.out.println(String.format("%.1f",an)); 
 }

}