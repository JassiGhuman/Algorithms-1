import java.util.ArrayList;

public class Dbl {
	static int arr[];
	static int count=0;
	static int f(int n) {

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String line = br.readLine();
int N = Integer.parseInt(line);
		if(count==0)
			arr=new int[n];
		count++; 
		System.out.println(arr.length);
		if(n>1)
			f(n-1);
		return 1;
	}
	public static void main(String[] args) {
		f(5);
		
   }
}