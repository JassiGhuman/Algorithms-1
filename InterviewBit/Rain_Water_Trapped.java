public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int n=A.length;
        int stck[]=new int[n];
        int top=0;
        int i=0;
        int area=0;
        int result=0;
        int temp=0;
        int count=0;
        int max=0;
        while(i<n){
            if(top==0 && A[i]!=0){
                stck[top++]=i;
                max=A[stck[top-1]];
            }
            else if(top!=0 && A[i]>=max){
                while(top!=0){
                    result=(i-stck[top-1]-1)*A[stck[top-1]]-count;
                    count+=A[stck[top-1]];
                    //System.out.println(result);
                    top--;
                }
                count=0;
                max=A[i];
                area+=result;
                stck[top++]=i;
            }
            else if(top!=0 && A[i]<max && A[i]!=0){
                stck[top++]=i;
            }
            i++;
        }
        int new_stck[]=new int[n];
        int index=stck[0];
        int new_a[]=new int[n-index];
        // for(int i=0;i<new_a.length();i++){
        //     new_a[i]=A[n-1-i];
        // }
        int new_top=0;
        result=0;
        count=0;
        top--;
        max=0;
        while(top>=0){
            if(new_top==0){
                new_stck[new_top++]=stck[top];
                max=A[new_stck[new_top-1]];
            }
            else if(new_top!=0 && A[stck[top]]>=max){
                while(new_top!=0){
                    result=(Math.abs(new_stck[new_top-1]-stck[top])-1)
                    *A[new_stck[new_top-1]]-count;
                    count+=A[new_stck[new_top-1]];
                    //System.out.println(result);
                    new_top--;
                }
                count=0;
                max=A[stck[top]];
                area+=result;
                new_stck[new_top++]=stck[top];
            }
            else if(new_top!=0 && A[stck[top]]<max){
                new_stck[new_top++]=stck[top];
            }
            top--;
        }
        
        //area+=result;
        return area;
    }
}
