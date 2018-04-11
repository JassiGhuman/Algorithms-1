public class Matrix_Median {
    public int findMedian(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        int r=n;
        int c=m;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,A[i][0]);
            max=Math.max(max,A[i][m-1]);
        }
        int mid=0;
        while(min<max){
            mid=min+(max-min)/2;
            int count=0;
            //boolean exists=false;           //tells whether the mid exists in the matrix or noot
            for(int i=0;i<n;i++){
                int idx=Arrays.binarySearch(A[i],mid);
               // System.out.println(idx);
                if(idx<0){
                    idx=Math.abs(idx+1);
                    count+=(idx);
                    //count+=();
                }
                else
                {
                    idx++;
                    while(idx<m && A[i][idx]==mid){
                        idx++;
                    }
                    //exists=true;  
                    
                    count+=idx;
                }
            }
            
            if(count<(r*c+1)/2){
                 min=mid+1;
            }
            else{
                max=mid;
            }
        }
        return min;
    }
    
}
