import java.util.Scanner;

public class Fib {

	static int power(int n){
		int y[][]={{1,0},{0,1}};
		int a[][]= {{1,1},{1,0}};
		
		while(n>0) {

			if(n%2!=0) {
				int	e=y[0][0]*a[0][0]+y[0][1]*a[1][0];
				int f=y[0][0]*a[0][1]+y[0][1]*a[1][1];
				int g=y[1][0]*a[0][0]+y[1][1]*a[1][0];
				int h=y[1][0]*a[0][1]+y[1][1]*a[1][1];
				y[0][0]=e%100;
				y[0][1]=f%100;
				y[1][0]=g%100;
				y[1][1]=h%100;
			}
			int e=a[0][0]*a[0][0]+a[0][1]*a[1][0];
			int f=a[0][0]*a[0][1]+a[0][1]*a[1][1];
			int g=a[1][0]*a[0][0]+a[1][1]*a[1][0];
			int h=a[1][0]*a[0][1]+a[1][1]*a[1][1];
			
			a[0][0]=e%100;
			a[0][1]=f%100;
			a[1][0]=g%100;
			a[1][1]=h%100;
			
			n/=2;
			
		}
		return y[1][0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr=new Scanner(System.in);
		int a[]=new int[10000];
		for(int i=0;i<10000;i++) {
			a[i]=2;
		}
		System.out.println(power(33));
	}
	
}
	