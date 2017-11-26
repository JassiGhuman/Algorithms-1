package a11;

public class Q2 extends Thread{
	private int n;
	Q2(int n){
		this.n=n;
	}
	public void run( ) {
	factorial(n);
		
	}
	public void factorial(int n) {
		int fact=1;
		for(int i=1;i<=n;i++) {
			fact*=i;
		}
		System.out.println(fact);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q2 a1= new Q2(5);
		
		Q2 a2= new Q2(4);
		a2.start();
		Q2 a3= new Q2(3);
		a3.start();
		Q2 a4= new Q2(2);
		a4.start();
		Q2 a5= new Q2(1);
		a5.start();
		a1.start();
	}

}
