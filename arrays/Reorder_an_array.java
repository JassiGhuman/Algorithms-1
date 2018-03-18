package arrays;

import java.util.Arrays;
import java.util.Comparator;

//Reorder an array according to given indexes
//o(n) time and o(1) space
public class Reorder_an_array {
	public static void reorder(int a[],int index[]) {
		int max=a[0];
		int n=a.length;
		for(int i=0;i<n;) {
			if(index[i]!=i) {
				int idx=index[i];
				int temp=a[i];
				a[i]=a[idx];
				a[idx]=temp;
				
				index[idx]=idx;
				index[i]=i;
			}
			else {
				i++;
			}
		}
		for(int x:a)
			System.out.print(x+" ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {50, 40, 70, 60, 90};
		int index[] = new int[]{3,  0,  4,  1,  2};
		reorder(arr, index);     
	}

}
