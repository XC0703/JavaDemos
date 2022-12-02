package 求两个日期之间的天数;
import java.util.Scanner;
public class Project17 {
	    // 十二个月份天数的和
		static int Add(int y, int m, int d)//主类里面定义的函数要静态声明，否则会错
		{
			int mon[] = {0,31,59,90,120,151,181,212,243,273,304,334};
		    // 处理年的和，对于闰年直接加
		    int num = y * 365 + y/4 - y / 100 + y / 400;
		    // 加上当年的月的天数
		    num += mon[m-1];
		    // 当前是闰年
		    if(m > 2 && (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)))
		       num += 1;
		    // 加上当年的日的天数
		    num += d;
		    return num;
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nums[] = new String[2];
		/*假如字符串型数组不限制长度，则这里要用sc.nextLine();吸收输入n的回车键导致的缓冲区，否则会错*/
		for(int i=0;i<nums.length;i++) {
			nums[i] = sc.next();
		   }
		 //截取子串后转换为int型
         int y1 = Integer.parseInt(nums[0].substring(0,4));
         int m1 = Integer.parseInt(nums[0].substring(4,6));
         int d1 = Integer.parseInt(nums[0].substring(6,8));
         int y2 = Integer.parseInt(nums[1].substring(0,4));
         int m2 = Integer.parseInt(nums[1].substring(4,6));
         int d2 = Integer.parseInt(nums[1].substring(6,8));
         int n1 = Add(y1, m1, d1);
         int n2 = Add(y2, m2, d2);
         System.out.print( Math.abs(n1 - n2) + 1 );//计算天数差
	}
}
