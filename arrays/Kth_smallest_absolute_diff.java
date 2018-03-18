package arrays;

import java.util.Arrays;

public class Kth_smallest_absolute_diff {
	public static int upper_bound(int a[],int n,int l,int mid) {
		int m=(l+n)/2;
		if(m==n-1) {
			return n;
		}
		if(mid==a[m])
	    {   
	        if(m!=n-1 && a[m+1]!=a[m])
	            return m+1;
	        return upper_bound(a, n,m+1, mid); 
	    }
		
		if(mid>a[m-1] && mid<a[m])
				return m;
		
		else if(mid>a[m-1]) {
			return upper_bound(a, n,m, mid);
		}
		else {
			return upper_bound(a, m,l, mid);
		}
	}
	public static int count_combinations(int a[],int n,int mid) {
		int result=0;
		for(int i=0;i<n;i++) {
			result+=upper_bound(a, n, i, a[i]+mid)-i-1;
		}
		return result;
	}
	public static int kth_smallest_abs_diff(int a[],int k) {
		int n=a.length;
		Arrays.sort(a);
		int high=a[n-1]-a[0];
		int low=a[1]-a[0];
		for(int i=1;i<n-1;i++) {
			low=Math.min(low, a[i+1]-a[i]);
		}
		while(low<high) {
			int mid=(low+high)/2;
			if(count_combinations(a, n, mid)<k)
				low=mid+1;
			else
				high=mid;
		}
		return low;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 2, 3, 4};
		System.out.println(kth_smallest_abs_diff(a, 6));
	}

}
