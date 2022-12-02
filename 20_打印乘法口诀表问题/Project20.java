package 打印乘法口诀表问题;
import java.util.Scanner;
import java.util.Arrays;
public class Project20 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){//先判断数据是否为整型，后执行代码
			int n = sc.nextInt();
			String str[][] = new String[n][];//建立一个字符串型二维数组
			for(int i=1;i<=n;i++){
				str[i-1] = new String[i];//要先给二维数组里的一维数组分配空间，否则出错
				for(int j=1;j<=i;j++){
					str[i-1][j-1]=i+"*"+j+"="+i*j;
					if(j<i){
						if(i*j<10){
							System.out.print(i+"*"+j+"="+i*j+"  ");
						}
						else{
							System.out.print(i+"*"+j+"="+i*j+" ");
						}
					}
					else{
					System.out.print(i+"*"+j+"="+i*j);
					}
				}
				System.out.println();
			}
			System.out.println(Arrays.deepToString(str));//打印二维数组中的内容
	}
}
}
