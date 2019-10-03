public class Solution {
    public int braces(String A) {
        int n=A.length();
        int top=0;
        char stck[]=new char[n];
        boolean redundant[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(A.charAt(i)=='('){
                stck[top++]='(';

                redundant[top-1]=true;
            }
            else if(A.charAt(i)==')'){
                top--;
                if(redundant[top]){
                    return 1;
                }
            }
            else if(A.charAt(i)=='+' || A.charAt(i)=='-' || A.charAt(i)=='*' || A.charAt(i)=='/'){
                if(top!=0)
                    redundant[top-1]=false;
            }
        }
        return 0;
    }
}
