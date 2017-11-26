import java.util.Scanner;

public class Fibv3 {

	static int power(int n[]){
		int y[][]={{1,0},{0,1}};
		int a[][]= {{1,1},{1,0}};
		
		while(nispositive(n)) {

			if(n[9999]%2!=0) {
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
			
			n=dividebytwo(n);
			
		}
		return y[1][0];
	}
	public static boolean nispositive(int n[]) {
		for(int i=0;i<10000;i++) {
			if(n[i]!=0)
				return true;
		}
		return false;
	}
	public static int [] dividebytwo(int n[]) {
		int f[]=new int[10000];
		for(int i=0;i<10000;i++) {
			f[i]=0;
		}
		for(int i=0;i<10000;i++) {
			
			if(n[i]==1 && i!=9999)
			{	
				f[i+1]=(10+n[i+1])/2;
				//System.out.println(f[9999]);
				if(n[i+1]!=1 || i==9998)
					i++;
			}
			else 
				f[i]=n[i]/2;
		}
		n=f;
		return f;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr=new Scanner(System.in);
		int n[]=new int[10000];
		for(int i=0;i<10000;i++) {
			if(i==9999 || i==9998)
				n[i]=9;
			else
				n[i]=0;
		}
		
		 //System.out.println(power(n));
		System.out.println(dividebytwo(n)[9998]);
		
	}
	
}
	