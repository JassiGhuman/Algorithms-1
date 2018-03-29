public class Longest_Palindromic_Substring {
    public String longestPalindrome(String A) {
        int len=A.length();
        if(len==0)
            return "";
        int n=2*len+1;
        int lps[]=new int[n];
        lps[0]=0;
        lps[1]=1;
        int R=2;
        int C=1;
        int i_mirror; //mirror image of i w.r.t C
        int max=1;
        int max_idx=0;
        for(int i=2;i<n;i++){
            int diff=R-i;
            i_mirror=2*C-i;
            if(diff>0)
                lps[i]=Math.min(diff,lps[i_mirror]);
            //System.out.println(i+" "+lps[i]+" "+C);
            //expand your value of lps[i] by going in both directions
            while((i+lps[i]+1<n) && (i-lps[i]>0))
            {
                    if((i+lps[i]+1)%2==0){
                        lps[i]++;
                    }   
                    else if(A.charAt((i+lps[i]+1)/2)==A.charAt((i-lps[i]-1)/2))
                        lps[i]++;
                    else
                        break;
                    }
            if(lps[i]>max){
                max=lps[i];
                max_idx=i;
            }
            if(lps[i]+i>R){
                C=i;
                R=i+lps[i];
            }
        }
        String s=A.substring((max_idx-max)/2,(max_idx-max)/2+max);
        return s;
    }
}
