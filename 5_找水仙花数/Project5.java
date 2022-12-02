package 找水仙花数;

public class Project5 {

 public static void main(String[] args) {
  // TODO 自动生成的方法存根
   int k,a,b,c;
   for(k=100;k<1000;k++){
    a=k/100;
    b=(k-a*100)/10;
    c=k%10;
    if(a*a*a+b*b*b+c*c*c==k){
     System.out.println(k);
    }
    } 
   }

}