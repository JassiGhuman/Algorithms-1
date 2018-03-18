package subsequence;

import java.util.Arrays;
import java.util.Comparator;

//Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
public class Max_Gap {
	O(nlogn)time
    public int maximumGap(final int[] A) {
        
        int n=A.length;
        class Pair{
            int index;
            int value;
            Pair(int i,int v){
                index=i;
                value=v;
            }
            
        }
        Pair pairs[]=new Pair[n];
        for(int i=0;i<n;i++){
            pairs[i]=new Pair(i,A[i]);
        }
        Arrays.sort(pairs,new Comparator<Pair>(){
           @Override
           public int compare(Pair p1, Pair p2) {
            return Integer.compare(p1.value, p2.value);
        }
        });
        int min=pairs[0].index;
        int max=0;
        for(int i=1;i<n;i++){
            min=Math.min(min,pairs[i].index);
            max=Math.max(pairs[i].index-min,max);
            
        }
        if(max<0)
            max=-1;
        //int j=n-1;
        return max;
    }
    //O(n)time second  approach
/*    
    int max(int x, int y) 
    
    {
        return x > y ? x : y;
    }
 
    int min(int x, int y) 
    {
        return x < y ? x : y;
    }
 
//     For a given array arr[], returns the maximum j-i such that
//       arr[j] > arr[i] 
    int maxIndexDiff(int arr[], int n) 
    {
        int maxDiff;
        int i, j;
 
        int RMax[] = new int[n];
        int LMin[] = new int[n];
 
//         Construct LMin[] such that LMin[i] stores the minimum value
//           from (arr[0], arr[1], ... arr[i]) 
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);
 
//         Construct RMax[] such that RMax[j] stores the maximum value
//           from (arr[j], arr[j+1], ..arr[n-1]) 
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);
 
        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n) 
        {
            if (LMin[i] < RMax[j]) 
            {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            } 
            else
                i = i + 1;
        }
 
        return maxDiff;
    }
  */  
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
