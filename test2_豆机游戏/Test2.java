package ������Ϸ;

import java.util.*;
public class Test2 {

 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);//�û�����
  System.out.print("Enter the number of balls to drop:");
  int x=sc.nextInt();
  Scanner s=new Scanner(System.in);
  System.out.print("Enter the number of slots in the beanmachine:");
  int y=s.nextInt();
  
  int [] slots=new int[y];//ʵ���߼�
  Random r=new Random();
  for(int j=1;j<=x;j++) {
   int n=0;
  for(int i=1;i<=y-1;i++) {
  boolean b=r.nextBoolean();
  if(b==true) {
   char a='R';
   n++;
   System.out.print(a);
  }else {
   char c='L';
   System.out.print(c);
  }
  }
  slots[n]++;
  System.out.println();
  }
  /* ʵ��ԭ��
   *  1��ͨ��ϵͳ�ṩ��random��������ȸ��ʲ���false����true��ģ�����������
   *  2��һ��R���ڶ��ۣ�����R���������ۣ���n��R����n���ۣ�û��R�͵���һ����
   * ʵ���߼���
   *  1����һ��forѭ���������С����Ŀ���б������൱���ڶ�С����б�ţ�
   * Ϊ��һ��ÿ��С����˶�����������׼����
   *  2���ڶ���forѭ���Ƕ�ÿ��С������������˶����ٴε�����Ľ���
   * Ҳ����С���˶����ٴε�����Ҳ��ܵ�����Զ���Ĳۣ��˴����趹���ĸ߶Ȳ��̶���
   *  3���������߶ȹ̶�����������ҵĴ���Ҳ�ǹ̶��ģ�
   * ����ÿ���۶��п���������ô�۵ĸ���Ҳ���ܳ���һ����Χ��
   *  4������slots����ģ��ۣ�n������¼������ʱ���ڵڼ����ۣ���Ϊ���󲻲���Ӱ�죬���Բ���������
   */
  
  
  
  int max=getmax(slots);//��ӡͼ��
  System.out.println(Arrays.toString(slots));
  for(int n=max;n>0;n--) {
   for(int k=0;k<slots.length;k++) {
    if(n<=slots[k]) {
     System.out.print("0 ");
    }else {
     System.out.print("  ");
    }
   }
   System.out.println();
  }
 for(int u=1;u<=y;u++) {
  System.out.print(u+" ");
 }
 }
 /*��ӡԭ��
  * 1����һ��forѭ����Ϊ�˶�������б���ʱ���ж�����ĸ���λ����û����
  * �����������ģ���һ��forѭ����������Σ��Ӷ����ڴ˴���ӡ���������
  * 2���ڶ���ѭ���Ƕ�������б�������Ϊ��ȡ�����е�����Ϊif������̵�
  * 3������if���ʽ�Ǻ��ģ���Ҫ�Լ�ȥ��⣡
  * 4������ʵ�ֵ������ǣ�������Ϊ0�ĵط���ӡ�ո�����Ϊ1���ڲ�ѭ��ֻ��ӡһ��
  * ����Ϊ2���ڲ�ѭ�����ӡ����
  */
 
 
 
 public static int getmax(int []slots) {//��ȡslots�����е��������
  int max=slots[0];
  for(int i=1;i<=slots.length-1;i++) {
   if(slots[i]>max) {
    max=slots[i];
   }
  }
  return max;
 }

}
