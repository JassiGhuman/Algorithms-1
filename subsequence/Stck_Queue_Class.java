package subsequence;
/*
 * 
 * 


//Find Max out of each window of size K		
public class Stck_Queue_Class {
	
	
	public static void main(String[] args) {
		int l=0;
		int j=1;
		int r=0;
		int n=8;
		int k=3;
		int a[]= {1,6,8 ,7,5,10,9,1};
		int s[]=new int[8];
		int b[]=new int[8-k+1];
		s[0]=0;
		while(j<k) {
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
			j++;
		}
		//System.out.println(a[s[l]]);
		b[0]=a[s[l]];
		int index=0;
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
			if(s[r]-s[l]>=k)
				l++;


			j++;
			//System.out.println(l);
			//System.out.println(a[s[l]]);
			b[++index]=a[s[l]];
		}
		for(int x:b) {
			System.out.println(x);
		}
	}
	
	
}
*/	
