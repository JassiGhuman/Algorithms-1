package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_k_sorted_arrays {
	 public static ArrayList<Integer> mergeKArrays(int[][]arrays,int k) 
     {
		 //add code here.
		 int n=arrays[0].length;
		 int output[]=new int[k*n];
		 for(int i=0;i<k;i++){
			 merge(output,arrays[i],arrays[i+1],i*n,(i+2)*n-1);
			 if(i+2==k-1){
				 merge(output,arrays[i+1],(i+2)*n);
				 break;
			 }
			 i++;
		 }
		 for(int x:output){
			 System.out.println(x);
		 }
		/* while(k!=1){
			 for(int i=0;i<k;i++){
				 //merge(output)
			 }
		 }
		 */
		 return new ArrayList<>();
     }
	 public static void merge(int []output,int a1[],int a2[],int start,int end){
		 int n=(end-start)/2;
		 int l[]=Arrays.copyOfRange(output, start,start+)
	 }
	 
	 
	 public static void merge(int []output,int a1[],int start){
		 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { {1, 3, 5, 7},
	            {2, 4, 6, 8},
	            {0, 9, 10, 11}} ;
		mergeKArrays(arr, 3);
	}

}
