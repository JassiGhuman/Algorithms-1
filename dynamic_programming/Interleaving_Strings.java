//https://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
public class Interleaving_Strings.java {
    public int isInterleave(String A, String B, String C) {
        int n=A.length();
        int m=B.length();
        if(n==0 || m==0)
            return 0;
        if(C.length()!=n+m)
            return 0;
        boolean M[][]=new boolean[n+1][m+1];
        M[0][0]=true;
        for(int i=1;i<=n;i++){
            if(C.charAt(i-1)==A.charAt(i-1)){
                M[i][0]=true;
            }
        }
        for(int i=1;i<=m;i++){
            if(C.charAt(i-1)==B.charAt(i-1)){
                M[0][i]=true;
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(A.charAt(i-1)==C.charAt(i+j-1) && B.charAt(j-1)==C.charAt(i+j-1) ){
                    M[i][j]=M[i-1][j]||M[i][j-1];
                }
                else if(A.charAt(i-1)==C.charAt(i+j-1)){
                    M[i][j]=M[i-1][j];
                }
                else if(B.charAt(j-1)==C.charAt(i+j-1)){
                    M[i][j]=M[i][j-1];
                }
                else{
                    M[i][j]=false;
                }
            }
        }
        if(M[n][m])
            return 1;
        return 0;    
    }
}
