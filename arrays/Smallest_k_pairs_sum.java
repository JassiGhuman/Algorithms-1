package arrays;
//Find k pairs with smallest sums in two sorted arrays

public class Smallest_k_pairs_sum {
	public static void findKSmallPairs(int[] arr1, int[] arr2, int k){
	    int len1 = arr1.length;
    	int len2 = arr2.length;

	    int i = 0; int j = 0;
    	System.out.println(arr1[i] + "," + arr2[j]);
	    int count = 1;
	    int idx1=1;			//for traversing the opposite array
	    int idx2=1;
    	while(count < k){
    		
    		if(i<len1 && arr1[i]+arr2[j+idx2]<arr2[j]+arr1[i+idx1]) {
    			System.out.println(arr1[i] + "," + arr2[j+idx2]);
    			idx2++;
    			if(idx2+j>len2-1) {
    				idx2=0;
    				i++;
    			}
    		}
    		else {
    			System.out.println(arr1[i+idx1] + "," + arr2[j]);
    			idx1++;
    			if(idx1+i>len1-1) {
    				idx1=0;
    				j++;
    			}
    		}
    		count++;
    	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1, 7, 9};
		int arr2[] = {2, 4, 6};
		int k = 7;
		int x=(int)-3.2;
		System.out.println(4%-3);
		//findKSmallPairs(arr1, arr2, k);
	}

}
