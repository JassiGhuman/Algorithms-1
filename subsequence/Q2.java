package subsequence;
//max(aj-ai) j<i+l; O(n) and j>i
public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=9;
		int a[]= {21,19,27,40,3,60,455,600,700};
		int l=0;
		int r=0;
		int k=2;
		int max=a[1]-a[0];
		int aj=a[l];
		int ai=a[0];
		int s[]=new int[n];
		int j;
		s[0]=0;
		for(j=1;j<k;j++) {
			if(a[j]<ai)
				ai=a[j];
			if(a[j]-ai>max) {
				max=a[j]-ai;
			}
			
			if(a[j]>a[s[r]]) {
				s[++r]=j;
			}
			else {
				while(r>=l && a[j]<a[s[r]]) {
					r--;
				}
				//System.out.println(r);
				s[++r]=j;
			}
		}
		while(j<n) {
			if(a[j]>a[s[r]]){
				s[++r]=j;
			}
			else {
				while(r>=l && a[j]<a[s[r]]) {
					r--;
				}
				//System.out.println(r);
				s[++r]=j;
			}
			
			if(j<n && s[r]-s[l]>=k)
				l++;
			
			ai=a[s[l]];
			if(a[j]-ai>max) {
				max=a[j]-ai;
			}
			j++;
			//System.out.println(a[s[l]]);
		}
		System.out.println(max);
				
	}
}
