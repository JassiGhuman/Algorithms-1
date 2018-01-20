package dynamic_programming;
//How to print maximum number of A’s using given four keys
public class Print_Max_As {
	// this function returns the optimal length string for N keystrokes
	public static int get_max_A (int n) {
		int result[]=new int [n];
		boolean copy=false;				//true if anything is copied in buffer
		int jump=0;						//no of A's to be pasted
		result[0]=1;
		for(int i=1;i<n;i++) {
			if(i < 6) {
				result[i]=i+1;
			}
			else {
				int max=0;
				int max1=0;
				for(int j=i-3;j>=1;j--) {
					max=Math.max(max, (result[j]*(i-j-1)));
				}
				
				//result[i]=Math.max(max,result[i-1]);
				result[i]=max;
			}
		}
		//System.out.println(copy);
		return result[n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(get_max_A(13));
	}

}
