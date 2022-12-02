package 御膳房问题;
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
        for(int i = 0;i<n;i++){//求最多重复数的重复次数
        	int count=0;//每次循环前count都要置0
        	for(int j = 0;j<n;j++){
        		if(a[j] ==a[i]){
        			count++;
        		}
        	}
        	if(count>maxcount){
        		maxcount = count;
        	}
        }
        if(n%2==0){//如果n是偶数，最多重复数的重复次数小于等于n/2即可调整
        	if(maxcount<=n/2){
        		System.out.println("YES");  
        	}
        	else{
        		System.out.println("NO");
        	}
        }
        else{//如果n是奇数，最多重复数的重复次数小于等于n/2+1即可调整
        	if(maxcount<=(n/2+1)){
        		System.out.println("YES");  
        	}
        	else{
        		System.out.println("NO");
        	}
        }
    }
}
