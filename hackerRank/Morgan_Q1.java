package hackerRank;

import java.util.Arrays;

public class Morgan_Q1 {

	public static void sum(char a[]){
		int n=a.length;
		int occurences[][]=new int [26][3]; //1 for count. 2 for last index.	3 for previous sum.
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=(n-i-1)*(n-i);
		}
		String s1[]={"1.1.1","1.1.0"};
		Arrays.sort(s1);
		System.out.println(s1[0]);
		//System.out.println(sum);
		for(int i=n-1;i>=0;i--){
			//occurences[a[i]-97][0]++;
			int count=++occurences[a[i]-97][0];
			int last_index=occurences[a[i]-97][1];
			int differences=occurences[a[i]-97][2];
			int d=last_index-i;
			
			if(count>1){
				sum-=((count-1)*(d*2)+occurences[a[i]-97][2]);
			}
			occurences[a[i]-97][1]=i;
			occurences[a[i]-97][2]=((count-1)*(d*2))+differences;
//			int differnce=()
//			occurences[a[i]-97][2]=
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aabbaac";
		char a[]=s.toCharArray();
		sum(a);
	}

}
