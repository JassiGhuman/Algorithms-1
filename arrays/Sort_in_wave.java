package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Sort_in_wave {
	
	public static void sort(int a[]){
		//Arrays.sort(a);			if we need the lexicographical order then sort it otherwise no need.
		int n=a.length;
		if(a[0]<a[1]){
			int temp=a[0];
			a[0]=a[1];
			a[1]=temp;
		}
		for(int i=2;i<a.length;i+=2){
			if(a[i]<a[i-1]){
				int temp=a[i-1];
				a[i-1]=a[i];
				a[i]=temp;
			}
			if(i!=n-1 && a[i]<a[i+1]){
				int temp=a[i+1];
				a[i+1]=a[i];
				a[i]=temp;
			}
		}
		//print array
		for(int x:a)
			System.out.print(x+" ");
		System.out.println();
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
		    sort(a);
		}

	}

}
