package subsequence;
//max subsequence for i+l<j
public class Subsequencev2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=8;
		int l=3;
		int a[]= {-6,4,-200,7,990,-17,-2,-98};
		int sum=a[0];
		int max=a[0];
		int j=1;
		
		for(;j<=l;j++) {
			sum+=a[j];
			max=sum;
		}
		//System.out.println(sum);
		if(sum<0)
		{
			sum=0;
			max=0;
		}
		int i=0;
		for(;j<n;j++) {
			if(a[i]<0)
				sum-=a[i++];
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
