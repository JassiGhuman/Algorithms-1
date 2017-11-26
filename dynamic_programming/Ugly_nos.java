package dynamic_programming;

public class Ugly_nos {
	//To check whether the number is a prime factor of 2,5,3 only
	public static int ugly(int n) {
		int ugly[]=new int [n];
		ugly[0]=1;
		int ugly_counter=1;
		int two_counter=0;
		int three_counter=0;
		int five_counter=0;
		for(int i=1;i<n;i++) {
			int a=Math.min(ugly[two_counter]*2,ugly[three_counter]*3 );
			int b=Math.min(a, ugly[five_counter]*5);
			ugly[ugly_counter]=b;
			ugly_counter++;
			if(b==ugly[two_counter]*2)
				two_counter++;
			if(b==ugly[three_counter]*3 )
				three_counter++;
			if(b==ugly[five_counter]*5)
				five_counter++;
		}
		return ugly[n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ugly(150));
	}
	
}
