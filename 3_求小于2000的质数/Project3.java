package ��С��2000������;

public class Project3 {

 public static void main(String[] args) {
  // TODO �Զ����ɵķ������
  boolean flag;
  for(int i=2;i<2000;i++) {
   flag=true; //flagҪ����ѭ�����棬ÿ��ѭ����Ҫ���¸�ֵ
   for(int j=2;j<=Math.sqrt(i);j++) { //iȡ���űȳ�2����Ч�ʸ�Щ
    if(i%j==0) {
     flag=false;
     break;
    }
   }
   if(flag) {
    System.out.println(i+" ");
   }
  }

 }

}