import java.util.Scanner;

public class Fibv4 {

	static int[][] power(int [][]a,int n){
		int y[][]={{1,0},{0,1}};
		//int a[][]= {{1,1},{1,0}};
		
		while(n>0) {
 
			if(n%2!=0) {
				y=mul(y,a);
			}
			a=mul(a,a);
			n/=2;
			
		}
		return y;
	}
	public static int fib(int n[]) {
		int y[][]= {{1,0},{0,1}};
		int b[][]={{1,0},{0,1}};
		int a[][]= {{1,1},{1,0}};
		int d[][]={{1,1},{1,0}};
		//int a[][]=new int [2][2];
		int i=99999;
		while(i>=0) {
			if(n[i]!=0) {
				b=power(d,n[i]);
				y=mul(y,b);
			}
			a=power(a,10); //remove a= in the end
			d=a.clone();
			i--;
		}
		return y[1][0];
	}
	public static int[][] mul(int [][]y,int [][]a){

		int	e=y[0][0]*a[0][0]+y[0][1]*a[1][0];
		int f=y[0][0]*a[0][1]+y[0][1]*a[1][1];
		int g=y[1][0]*a[0][0]+y[1][1]*a[1][0];
		int h=y[1][0]*a[0][1]+y[1][1]*a[1][1];
		y[0][0]=e%100; 
		y[0][1]=f%100;
		y[1][0]=g%100;
		y[1][1]=h%100;
		return y;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr=new Scanner(System.in);
		int n[]=new int[100000];
		for(int i=0;i<100000;i++) {
			if(i==99999)// || i==9998)
				n[i]=6;
			else if(i==99998)
				n[i]=4;
			else if(i==99997)
				n[i]=2;
			else if(i==99996)
				n[i]=2;
			else if(i==99995)
				n[i]=1;
			else
				n[i]=1;
		}
		System.out.println(fib(n));
		
		//System.out.println();
		
	}
	
}
	
