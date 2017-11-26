package dynamic_programming;
//A Dynamic Programming solution for subset sum problem
class Subset_sum
{
 // Returns true if there is a subset of set[] with sun equal to given sum
 static boolean isSubsetSum(int set[], int n, int sum)
 {
     // The value of subset[i][j] will be true if there 
         // is a subset of set[0..j-1] with sum equal to i
     boolean subset[][] = new boolean[sum+1][n+1];
   
     // If sum is 0, then answer is true
     for (int i = 0; i <= n; i++)
       subset[0][i] = true;
   
     // If sum is not 0 and set is empty, then answer is false
     for (int i = 1; i <= sum; i++)
       subset[i][0] = false;
     
      // Fill the subset table in botton up manner
      for (int i = 1; i <= sum; i++)
      {
        for (int j = 1; j <= n; j++)
        {
          subset[i][j] = subset[i][j-1];
          if (i >= set[j-1])
            subset[i][j] = subset[i][j] || 
                                       subset[i - set[j-1]][j-1];
        }
      }
   
      // uncomment this code to print table
 /*     for (int i = 0; i <= sum; i++)
      {
        for (int j = 0; j <= n; j++)
           System.out.print(subset[i][j]+"  ");
        //printf("n");
        System.out.println();
      } 
*/    String result="";
      find_subset(subset,set, sum, n, result);
      return subset[sum][n];
 }
 public static void find_subset(boolean a[][],int set[],int r,int c,String result) {
	 if(r==0) {
		 System.out.println(result);
		 return;
	 }
	 if(c!=0 && a[r][c-1]==true) {
		 find_subset(a,set,r,c-1,result);
	 }
	 else if(c!=0 && r-set[c-1]>=0 && a[r-set[c-1]][c-1]==true) {
		 find_subset(a, set,r-set[c-1] , c-1, " "+set[c-1]+result);
	 }
 }
 /* Driver program to test above function */
 public static void main (String args[])
 {
       int set[] = {3, 34, 12,4,6, 5,2};
       int sum = 9;
       int n = set.length;
       if (isSubsetSum(set, n, sum) == true)
          System.out.println("Found a subset with given sum");
       else
          System.out.println("No subset with given sum");
 }
}/* This code is contributed by Rajat Mishra */
