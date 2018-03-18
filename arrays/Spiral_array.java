package arrays;

public class Spiral_array {
    public int[] spiralOrder(final int[][] A) {
        
        int n=A.length;
        int m=A[0].length;
        int result[]=new int [m*n];
        int idx=0;
        int count=0;
        int relax=0;
        int d_dir=1;
        int r_dir=1;
        while(idx<m*n){
            if(r_dir== 1 && d_dir==1){
                for(int i=0+relax;i<m-relax && idx<m*n;i++){
                    result[idx++]=A[relax][i];
                }
                r_dir=0;
            }
            else if(d_dir==1 && r_dir==0){
                for(int i=1+relax;i<n-relax && idx<m*n;i++){
                    result[idx++]=A[i][m-relax-1];
                }
                relax++;
                d_dir=0;
            }
            else if(d_dir==0 && r_dir==0){
                for(int i=m-relax-1;i>=relax-1 && idx<m*n;i--){
                    result[idx++]=A[n-relax][i];
                }
                r_dir=1;
            }
            else if(r_dir==1 && d_dir==0){
                for(int i=n-relax-1;i>=relax && idx<m*n;i--){
                    result[idx++]=A[i][relax-1];
                }
                d_dir=1;
            }
            
        }
        return result;
    }
}
