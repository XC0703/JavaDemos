package ����������;

public class Project4 {

 public static void main(String[] args) {
  // TODO �Զ����ɵķ������
  for (char a = 'x'; a <= 'z'; a++) {
   for (char b = 'x'; b <= 'z'; b++) {
    // ����ƥ��Ĳ�����ͬһ��
    if (a != b) {
     for (char c = 'x'; c <= 'z'; c++) {
      // ����ƥ��Ĳ���Ϊͬһ��
      if (b != c && a != c) {
       // ������Ŀ���������������ж�
       if (a != 'x' && c != 'z' && c != 'x') {
        System.out.println("��������Ϊ��");
        System.out.println("a��" + a + "����");
        System.out.println("b��" + b + "����");
        System.out.println("c��" + c + "����");
       }
      }
     }
    }
   }
     }
     }
}