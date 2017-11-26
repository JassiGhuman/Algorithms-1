package quicSort;

public class KwayMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,5,10,15};
		int b[]= {2,4,8,16};
		int c[]= {3,6,9,12};
		int d[]= {7,11,13,17};
		
		int k=4;
		int n=16;
		int arr[]=new int[n];
		int ai=0;
		int bi=0;
		int ci=0;
		int di=0;
		for(int idx=0;idx<n;) {
			if((ai<k && bi<k)&& a[ai]<b[bi])
			{
				ai++;
				arr[idx]=a[ai];
				idx++;
			}
			else if((ai<k && bi<k)&& a[ai] > b[bi]) {
				bi++;
				arr[idx]=b[bi];
				idx++;
			}
			
			if((ci<k && di<k)&& c[ci]<d[di])
			{
				ci++;
				arr[idx]=c[ci];
				idx++;
			}
			else if((ci<k && di<k)&& c[ci] > d[di]) {
				di++;
				arr[idx]=d[di];
				idx++;
			}
				
		}
	}

}
