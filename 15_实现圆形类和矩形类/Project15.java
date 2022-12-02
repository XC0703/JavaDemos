package 实现圆形类和矩形类;
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
     System.out.println("输入错误！");
    }
   }
  }else {
   System.out.println("输入错误！");
  }
  for(int j = 0; j<n; j++) { //转换为两位小数输出
   System.out.println(String.format("%.2f",shape[j].getArea())+" "+String.format("%.2f",shape[j].getPerimeter()));}
 }
}
/**定义接口*/
interface Shape{
float getArea();  //求面积
float getPerimeter();  //求周长
}
//圆形类
class Circle implements Shape{
float PI = (float) Math.PI;
float radius;
Circle(float r){  //构造函数
 radius = r;
}
@Override
public float getArea() {//求面积
 return   PI  * radius * radius;  
}
@Override
public float getPerimeter() {// 求周长
 return 2 * PI *radius;
}
}
//矩形类
class Rectangle implements Shape{
float width,height;
Rectangle(float x, float y){  //构造函数
 this.width = x;
 this.height = y;
}
@Override
public float getArea() { //求面积
 float area = width * height;
 return area;
}
@Override
public float getPerimeter() { // 求周长
 float perimeter =2*( width+height);
 return perimeter;
}
}

