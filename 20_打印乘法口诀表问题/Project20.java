package ��ӡ�˷��ھ�������;
import java.util.Scanner;
import java.util.Arrays;
public class Project20 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){//���ж������Ƿ�Ϊ���ͣ���ִ�д���
			int n = sc.nextInt();
			String str[][] = new String[n][];//����һ���ַ����Ͷ�ά����
			for(int i=1;i<=n;i++){
				str[i-1] = new String[i];//Ҫ�ȸ���ά�������һά�������ռ䣬�������
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
			System.out.println(Arrays.deepToString(str));//��ӡ��ά�����е�����
	}
}
}
