package arrays;

import java.util.Scanner;

public class Bitonic_subarray {
	public static int bitonic(int a[]){
		int max=1;
		int n=a.length;
		int down=0;
		int len=1;
		boolean up=true;
		int count=0;
		for(int i=1;i<n;i++){
			if(a[i]>a[i-1]){
				if(up){
					len++;
					//max=Math.max(len, max);
				}
				else{
					len=2;
					up=true;
				}
			}
			else if(a[i]<a[i-1]){
				len++;
				up=false;
			}
			else{
				len++;
				count++;
			}
			max=Math.max(len, max);
		}
		System.out.println("c"+count);
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//        int arr[] = {12, 4, 78, 90, 45, 23};
//        System.out.println(bitonic(arr));
		Scanner scr =new Scanner(System.in);
		int t=scr.nextInt();
		for(int t_i=0;t_i<t;t_i++){
		    int n =scr.nextInt();
		    int a[]=new int [n];
		    for(int i=0;i<n;i++){
		        a[i]=scr.nextInt();
		    }
		   System.out.println(bitonic(a));
		}

	}

}



