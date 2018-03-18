package a11;

public class Q3 extends Thread {
	public int r;
	private int n;
	Q3(int n){
		this.n=n;
		
	}
	public void run(   ) {
		r=factorial(n);
	}
	public int factorial(int n) {
		int fact=1;
		for(int i=1;i<=n;i++) {
			fact*=i;
		}
		
		
		
		System.out.println(fact);
		return fact;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q3 a1= new Q3(5);
		Q3 a2= new Q3(4);
		Q3 a3= new Q3(3);
		Q3 a4= new Q3(2);
		Q3 a5= new Q3(1);
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a5.start();
		System.out.println(a1.r+a2.r+a3.r+a4.r+a5.r);
	}


}
