package �ɼ�¼��ͳ������;
import java.util.Scanner;
public class Project14 {
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);//�û�����
  int count=sc.nextInt();
        int pass=0;
        int grade=0;  //gradeҪ��ʼ����������
        for (int i=0;i<count;i++){
         try{             //try����飬�������쳣ʱ��ת��catch�������
            grade=sc.nextInt();
            if (grade<0||grade>100){
             throw new ScoreException("invalid!");  //�����쳣ʱ�׳���Ϣ
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
//�Զ����쳣�࣬�̳���Exception��
class ScoreException extends Exception
{
 String message;
 public ScoreException(String message){ //���캯��
  this.message = message;
 }
 public String toString(){  //����ִ�и��쳣������toString��������
  return this.message;
 }
}