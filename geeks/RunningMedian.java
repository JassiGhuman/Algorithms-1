/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class RunningMedian {
	public static void main (String[] args) {
		//code
		Scanner scr =new Scanner(System.in);
		//int t=scr.nextInt();
		for(int t_i=0;t_i<1;t_i++){
		    int n =scr.nextInt();
		    int a[]=new int [n];
		    for(int i=0;i<n;i++){
		        a[i]=scr.nextInt();
		    }
		    int result[]=find_median(a);
		    for(int x: result)
		        System.out.println(x);
		}

	}
	public static int[] find_median(int a[]){
	    int n = a.length;
	    PriorityQueue<Integer>min = new PriorityQueue<>();              //min heap
	    PriorityQueue<Integer>max = new PriorityQueue<>(new Comparator<Integer>(){
			 public int compare(Integer i1,Integer i2){
				 return i2.compareTo(i1);
			 }
		 });   //max heap
	    int result[]=new int[n];
	    max.add(a[0]);
	    result[0]=a[0];
	    for(int i=1;i<n;i++){
	        if(min.size() == max.size()){
	            if(min.peek()<a[i]){
	                min.add(a[i]);
	                int x = min.poll();
	                max.add(x);
	            }
	            else{
	                max.add(a[i]);
	            }
	            result[i]=max.peek();
	        }
	        else{
	            if(max.peek()<=a[i]){
	                min.add(a[i]);
	            }
	            else{
	                max.add(a[i]);
	                int x = max.poll();
	                min.add(x);
	            }
	            result[i] = (min.peek()+max.peek())/2;
	        }
	    }
	    return result;
	    
	}
}
