package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

//Given an array of numbers, program to
//arrange the numbers to form the 
//largest number
public class Biggest_nos_arrangement {
	public static void arrange(int a[]){
		int n=a.length;
		double temp[]=new double[n];
		String arr[]=new String[n];
		for(int i=0;i<n;i++){
			arr[i]=(a[i]+"");
		}
		//Arrays.sort(a,new Comparator<Integer>());
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String X, String Y) {
			     
			    // first append Y at the end of X
			    String XY=X + Y;
			     
			    // then append X at the end of Y
			    String YX=Y + X;
			     
			    // Now see which of the two formed numbers 
			    // is greater
			    return XY.compareTo(YX) > 0 ? -1:1;
			}
		});
		for(int i=0 ; i< arr.length ; i++)
	        System.out.print(arr[i]);
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={54, 546, 548, 60};
		arrange(a);
	}

}
