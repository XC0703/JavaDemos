package 百钱买百鸡问题;

public class Project2 {

 public static void main(String[] args) {
  // TODO 自动生成的方法存根
  int cock,hen,chicken;

  for(cock=0;cock<=20;cock++){
       
      for(hen=0;hen<=33;hen++){

          for(chicken=0;chicken<=100;chicken++){
           
      if((5*cock+3*hen+chicken/3.0==100)&&(cock+hen+chicken==100))
        {
              System.out.println("\n鸡翁数量为" + cock + ","+"鸡母数量为" + hen + ","+"鸡雏数量为" + chicken );;
        }
      }
    }
    }
  
 }

}