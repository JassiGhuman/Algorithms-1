package arrays;
//Maximum circular subarray sum

import java.util.Scanner;

//We will first use kadene's algo and then we'll invert the sign
//of the nos in the array and apply kadene's algo on it.

public class Max_sum_circular_subarray {
	static void find_max_sum(int a[]){
		int max_positive=kadenes(a);
		int n=a.length;
		int whole_sum=0;	//sum of all elements of array
		for(int i=0;i<n;i++){
			whole_sum+=a[i];
			a[i]=-a[i];
		}
		int max=Math.max(max_positive, whole_sum+kadenes(a));
		if(max==0)
		    {
		        max=-a[0];
		        for(int x:a){
		            max=Math.max(max,-x);
		        }
		    }
		System.out.println(max);
	}
	static int kadenes(int a[]){
		int n=a.length;
		int sum=a[0];
		int max=a[0];
		if(sum<0){
		    sum=0;
            max=0;		
		    
		}
		int j=1;
		int l=0;
		int cross=0;
		for(;j<n;j++){
			//System.out.println("ada");
			sum+=a[j];
			if(sum<=0)
			{
				sum=0;
			}
			if(sum>max) {
				max=sum;
			}
			//System.out.println(sum);
			//System.out.println(sum+" "+j);
		}
		return max;
	}

	public static void main (String[] args) {
		//code
		Scanner scr =new Scanner(System.in);
		int t=scr.nextInt();
		for(int t_i=0;t_i<t;t_i++){
		    int n =scr.nextInt();
		    int a[]=new int [n];
		    for(int i=0;i<n;i++){
		        a[i]=scr.nextInt();
		    }
		    find_max_sum(a);
		}

	}
}
