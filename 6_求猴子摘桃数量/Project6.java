package �����ժ������;
import java.util.Scanner;
public class Project6 {

 public static void main(String[] args) {
  // TODO �Զ����ɵķ������
       int peach=1,i;
       Scanner sc = new Scanner (System.in);
       //����ɨ����ɨ��Ӽ������������
       System.out.println("������������");
       int N = sc.nextInt();
       for(i=1;i<N;i++){
        peach=(peach+1)*2;
       }
       System.out.println("��һ��ժ������Ϊ:");
       System.out.println(peach);
 }

}