import java.util.Scanner;

public class Fibnew {

	static int[][] power(int [][]a,int n){
		int y[][]={{1,0,0},{0,1,0},{0,0,1}};
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
		int y[][]= {{1,0,0},{0,1,0},{0,0,1}};
		int b[][]={{1,0,0},{0,1,0},{0,0,1}};
		int a[][]= {{1,0,1},{1,0,0},{0,1,0}};
		int d[][]=a.clone();
		//int a[][]=new int [2][2];
		int i=9999;
		while(i>=0) {
			if(n[i]!=0) {
				b=power(d,n[i]);
				y=mul(y,b);
				
			}
			a=power(a,10); //remove a= in the end
			d=a.clone();
			i--;
		}
		return y[2][0]+y[2][1];
		//return y[1][0];
	}
	public static int[][] mul(int [][]y,int [][]a){
		int[][] c = new int[3][3];
		int e=(y[0][0]*a[0][0])%100+(y[0][1]*a[1][0])%100+(y[0][2]*a[2][0])%100;
		int f=(y[0][0]*a[0][1])%100+(y[0][1]*a[1][1])%100+(y[0][2]*a[2][1])%100;
		int g=(y[0][0]*a[0][2])%100+(y[0][1]*a[1][2])%100+(y[0][2]*a[2][2])%100;
		int h=(y[1][0]*a[0][0])%100+(y[1][1]*a[1][0])%100+(y[1][2]*a[2][0])%100;
		int i=(y[1][0]*a[0][1])%100+(y[1][1]*a[1][1])%100+(y[1][2]*a[2][1])%100;
		int j=(y[1][0]*a[0][2])%100+(y[1][1]*a[1][2])%100+(y[1][2]*a[2][2])%100;
		int k=(y[2][0]*a[0][0])%100+(y[2][1]*a[1][0])%100+(y[2][2]*a[2][0])%100;
		int l=(y[2][0]*a[0][1])%100+(y[2][1]*a[1][1])%100+(y[2][2]*a[2][1])%100;
		int m=(y[2][0]*a[0][2])%100+(y[2][1]*a[1][2])%100+(y[2][2]*a[2][2])%100;
		
		c[0][0]=(e%100);
		c[0][1]=(f%100);
		c[0][2]=(g%100);
		c[1][0]=(h%100);
		c[1][1]=(i%100);
		c[1][2]=(j%100);
		c[2][0]=(k%100);
		c[2][1]=(l%100);
		c[2][2]=(m%100);
		return c;
		/*
		    int m1 = a.length;
	        int n1 = a[0].length;
	        int m2 = b.length;
	        int n2 = b[0].length;
	        if (n1 != m2) throw new RuntimeException("Illegal matrix dimensions.");
	        int[][] c = new int[m1][n2];
	        for (int i = 0; i < m1; i++)
	        for (int j = 0; j < n2; j++)
	        for (int k = 0; k < n1; k++)
	        c[i][j] += (a[i][k] * b[k][j]) % 100;
	        return c;
	        */
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr=new Scanner(System.in);
		int n[]=new int[10000];
		for(int i=0;i<10000;i++) {
			if(i==9999)// || i==9998)
				n[i]=9;
			else if(i==9998)
				n[i]=9;
			else
				n[i]=0;
		}
		System.out.println(fib(n));
		int a[][]= {{1,0,1},{1,0,0},{0,1,0}};
		System.out.println(power(a,11)[1][0]);
	}
	
}
	