package arrays;

import java.util.Scanner;

public class Max_product_subarray {
	public static void max_product(int a[]){
		int sum=1;
		int neg_sum=1;
		int neg_sum_end=1;
		int max=0;
		int n=a.length;
		for(int i=0;i<n;i++){
			if(a[i]<0){
				neg_sum*=a[i];
				neg_sum_end*=a[i];
				sum*=a[i];
				if(neg_sum>0){
					sum=neg_sum;
				    neg_sum_end=a[i];	
				}
				else if(neg_sum_end>0 && neg_sum<0){
				    sum=neg_sum_end;
				}
			}
			else if(a[i]==0){
				neg_sum=1;
				neg_sum_end=1;
				sum=1;
			}
			else{
				neg_sum*=a[i];
				neg_sum_end*=a[i];
				sum*=a[i];
			}
			if(sum<0){
			    sum=1;
			}
			max=Math.max(max, sum);
		}
		System.out.println(max);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr =new Scanner(System.in);
		int t=scr.nextInt();
		for(int t_i=0;t_i<t;t_i++){
		    int n =scr.nextInt();
		    int a[]=new int [n];
		    for(int i=0;i<n;i++){
		        a[i]=scr.nextInt();
		    }
		    max_product(a);
		}

	}

}
