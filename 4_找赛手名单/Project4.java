package 找赛手名单;

public class Project4 {

 public static void main(String[] args) {
  // TODO 自动生成的方法存根
  for (char a = 'x'; a <= 'z'; a++) {
   for (char b = 'x'; b <= 'z'; b++) {
    // 两人匹配的不能是同一人
    if (a != b) {
     for (char c = 'x'; c <= 'z'; c++) {
      // 三人匹配的不能为同一人
      if (b != c && a != c) {
       // 加入题目给的条件，进行判断
       if (a != 'x' && c != 'z' && c != 'x') {
        System.out.println("比赛名单为：");
        System.out.println("a与" + a + "比赛");
        System.out.println("b与" + b + "比赛");
        System.out.println("c与" + c + "比赛");
       }
      }
     }
    }
   }
     }
     }
}