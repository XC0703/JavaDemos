package 数字黑洞问题;
import java.util.Scanner;
import java.util.Arrays;
public class Project19 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] a = new int[4];
		int max = 0;
		int min = 0;
		 //验证各位数字是否全部相等
	    if(num%10 == num/10%10 && num%10 == num/100%10 && num%10 == num/1000){
	    	System.out.println("N-N=0000");
		    }            
	    else{       
		while(num!=6174){
			for(int i=0;i<a.length;i++) {  //将各个位上的数存入数组
                a[i] = num%10;
                num = num/10;
            }  
			Arrays.sort(a); //升序排序
			max = a[0]+a[1]*10+a[2]*100+a[3]*1000;
            min = a[0]*1000+a[1]*100+a[2]*10+a[3];
            System.out.println(leftPad(max,4,'0')+"-"+leftPad(min,4,'0')+"="+leftPad(max-min,4,'0'));        
            num = max-min;
		}
		}
	}
//定义一个前面补0的方法
	private static String leftPad(int num,final int maxLen,char filledChar){
		StringBuffer sb = new StringBuffer(); //StringBuffer是一个可修改对象
		String str = String.valueOf(num);  //将num转换为字符串类型
		for(int i = str.length();i<maxLen;i++){//判断num位数是否满足要求
			sb.append(filledChar);  //通过append方法向其赋值
		}
		return sb.append(str).toString();//在末位插入str后，转换为String类型  
	}
}