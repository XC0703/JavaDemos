package ���ŷ�����;
import java.util.Scanner;
public class Project21{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxcount=0;
        int n = sc.nextInt();
        int a[]= new int[100];
        for(int i = 0;i<n;i++){
        	a[i] = sc.nextInt();
        }
        for(int i = 0;i<n;i++){//������ظ������ظ�����
        	int count=0;//ÿ��ѭ��ǰcount��Ҫ��0
        	for(int j = 0;j<n;j++){
        		if(a[j] ==a[i]){
        			count++;
        		}
        	}
        	if(count>maxcount){
        		maxcount = count;
        	}
        }
        if(n%2==0){//���n��ż��������ظ������ظ�����С�ڵ���n/2���ɵ���
        	if(maxcount<=n/2){
        		System.out.println("YES");  
        	}
        	else{
        		System.out.println("NO");
        	}
        }
        else{//���n������������ظ������ظ�����С�ڵ���n/2+1���ɵ���
        	if(maxcount<=(n/2+1)){
        		System.out.println("YES");  
        	}
        	else{
        		System.out.println("NO");
        	}
        }
    }
}
