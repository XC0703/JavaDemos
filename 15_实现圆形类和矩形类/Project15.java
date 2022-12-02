package ʵ��Բ����;�����;
import java.util.Scanner;
public class Project15 {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  Shape[] shape = new Shape[n];
  if(n > 0) {
   for(int i =0; i<n; i++) {
    int k = sc.nextInt();
    if(k == 1) {
     float r = sc.nextFloat();
     shape[i] = new Circle(r);
    }else if(k == 2){
     float x = sc.nextFloat();
     float y = sc.nextFloat();
     shape[i] = new Rectangle(x,y);
    }else {
     System.out.println("�������");
    }
   }
  }else {
   System.out.println("�������");
  }
  for(int j = 0; j<n; j++) { //ת��Ϊ��λС�����
   System.out.println(String.format("%.2f",shape[j].getArea())+" "+String.format("%.2f",shape[j].getPerimeter()));}
 }
}
/**����ӿ�*/
interface Shape{
float getArea();  //�����
float getPerimeter();  //���ܳ�
}
//Բ����
class Circle implements Shape{
float PI = (float) Math.PI;
float radius;
Circle(float r){  //���캯��
 radius = r;
}
@Override
public float getArea() {//�����
 return   PI  * radius * radius;  
}
@Override
public float getPerimeter() {// ���ܳ�
 return 2 * PI *radius;
}
}
//������
class Rectangle implements Shape{
float width,height;
Rectangle(float x, float y){  //���캯��
 this.width = x;
 this.height = y;
}
@Override
public float getArea() { //�����
 float area = width * height;
 return area;
}
@Override
public float getPerimeter() { // ���ܳ�
 float perimeter =2*( width+height);
 return perimeter;
}
}

