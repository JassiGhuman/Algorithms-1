package dynamic_programming;

import java.util.ArrayList;

public class Longest_Increasing_Subsequence {
	
	public static int lis(int a[]){
		int n=a.length;
		ArrayList<Integer> list =new ArrayList<>();
		list.add(a[0]);
		for(int i=1;i<n;i++){
			search(list, a[i]);
		}
		return list.size();
	}
	public static int search(ArrayList<Integer> a,int x){
		int n=a.size();
		int low=0;
		int high=n-1;
		int mid=0;
		if(a.get(n-1)<x){
			a.add(x);
			return n+1;
		}
		while(low<=high){
			mid=(low+high)/2;
			if(a.get(mid)==x){
				return n;
			}
			else if(a.get(mid)>x){
				if(mid==0 || a.get(mid-1)<x){
					a.set(mid, x);
					return n;
				}
				else{
					high=mid-1;
				}
			}
			else{
				low=mid+1;
			}
		}
		return n+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={ 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(lis(a));
	}

}
