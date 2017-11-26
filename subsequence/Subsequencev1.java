package subsequence;
//sum of subsequnce shoud be max
public class Subsequencev1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=9;
		int a[]= {6,-3,4,-20,7,-1,17,-2,98};
		int sum=a[0];
		int max=a[0];
		for(int j=1;j<n;j++) {
			if(sum<0)
				sum=0;
			sum+=a[j];
			if(sum>max) {
				max=sum;
			}
			System.out.println(sum);
		}
		System.out.println(max);
	}

}
