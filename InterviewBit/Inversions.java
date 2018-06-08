public class Inversions {
    public int countInversions(int[] A) {
        //inversions using mergeSort
        return mergeSort(0,A.length-1,A);    
    }
    public int mergeSort(int p,int q,int[] A){
        int inversions = 0;
        if(p>=q)
            return 0;
        int r = (p+q)/2;
        inversions+= mergeSort(p,r,A);
        inversions+=mergeSort(r+1,q,A);
        inversions+=merge(p,r,q,A);
        return inversions;
    }
    public int merge(int p,int r,int q,int A[]){
        int l_arr[] = new int[r-p+1];
        int r_arr[] = new int[q-r];
        int inversions = 0;     //compute this
        int n = l_arr.length;
        int m = r_arr.length;
        for(int i = 0 ;i < l_arr.length;i++){
            l_arr[i] = A[p+i];
        }
        for(int i = 0 ;i < r_arr.length;i++){
            r_arr[i] = A[r+1+i];
        }
        int index = p;
        int l_i = 0;
        int r_i = 0;
        while(index<=q){
            if(l_i==n){
                A[index] = r_arr[r_i];
                r_i++;
            }
            else if(r_i==m){
                A[index] = l_arr[l_i];
                l_i++;
            }
            else{
                if(r_arr[r_i]<l_arr[l_i]){
                    A[index] = r_arr[r_i];
                    inversions += (n-l_i);
                    r_i++;
                }
                else{
                    A[index] = l_arr[l_i];
                    l_i++;
                }
                    
            }
            index++;
        }
        return inversions;
    }
}
