package arrays;

import java.util.HashMap;
import java.util.Scanner;

//Largest subarray with equal number of 0s and 1s
public class Equal_0_1s {

    // This function Prints the starting and ending
    // indexes of the largest subarray with equal  
    // number of 0s and 1s. 
	public static int find_sub_array(int arr[]){
        // Your code here
	       HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
	       
	        int sum = 0;      // Initialize sum of elements
	        int max_len = 0;  // Initialize result
	 
	        // Traverse through the given array
	        for (int i = 0; i < arr.length; i++)
	        {
	            // Add current element to sum
	            sum += arr[i];
	            
	            if (arr[i] == 0)
	            	sum+=-1;
	            	
	            if (sum == 0)
	                max_len = i+1;
	 
	            // Look this sum in hash table
	            Integer prev_i = hM.get(sum);
	 
	            // If this sum is seen before, then update max_len
	            // if required
	            if (prev_i != null)
	               max_len = Math.max(max_len, i-prev_i);
	            else  // Else put this sum in hash table
	               hM.put(sum, i);
	        }
	        System.out.println(max_len);
	        return max_len;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 0, 0, 1, 0, 1, 1};
		find_sub_array(arr);
		Scanner scr =new Scanner(System.in);
		int t=scr.nextInt();
		for(int t_i=0;t_i<t;t_i++){
		    int n =scr.nextInt();
		    int a[]=new int [n];
		    for(int i=0;i<n;i++){
		        a[i]=scr.nextInt();
		    }
		    find_sub_array(a);
		}

		
	}

}
