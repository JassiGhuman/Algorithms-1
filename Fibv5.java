import java.util.Scanner;

public class Fibv5 {

	static int fib(int n,int m){
		int y[][]={{1,0},{0,1}};
		int a[][]= {{1,1},{1,0}};
		
		while(n>0) {

			if(n%2!=0) {
				y=mul(y,a,m);
			}
			a=mul(a,a,m);
			n/=2;
			
		}
		return y[1][0];
	}
	
	public static int[][] mul(int [][]y,int [][]a,int m){

		int	e=y[0][0]*a[0][0]+y[0][1]*a[1][0];
		int f=y[0][0]*a[0][1]+y[0][1]*a[1][1];
		int g=y[1][0]*a[0][0]+y[1][1]*a[1][0];
		int h=y[1][0]*a[0][1]+y[1][1]*a[1][1];
		y[0][0]=e%m;
		y[0][1]=f%m;
		y[1][0]=g%m;
		y[1][1]=h%m;
		return y;
	}
	static int period(int m) {
		for(int i=2;i<10001;i++) {
			if(fib(i,m)==0 && fib(i+1,m)==1) {
				return i;
			}
		}
		return -1;
		
	}
	public static int fib(int []n,int m) {
		int period = period(m);
		int mod=modulus(n,period);
		return fib(mod,m);
	}
	
	public static int modulus(int []n,int period) {
		int size=0;
		for(int i=0;i<10000;i++) {
			if(n[i]!=0) {
				size=10000-i;
				break;
			}
		}
		String num="";
		for(int i=10000-size;i<10000;i++) {
			num=num+n[i];
			int number=Integer.parseInt(num);
			if(number>=period) {
				num=""+(number%period);
			}
		} 
		
		int number=Integer.parseInt(num);
		return number;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr=new Scanner(System.in);
		int n[]=new int[10000];
		for(int i=0;i<10000;i++) {
			if(i==9999 || i==9998 || i==9997)
				n[i]=3;
			else
				n[i]=0;
		}
		//System.out.println(fib(n,100));
		
		System.out.println(period(700));
		
	}
	
}
	
