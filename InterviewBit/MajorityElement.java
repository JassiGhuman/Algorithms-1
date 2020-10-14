public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] A) {
        HashMap <Integer,Integer>map=new HashMap<Integer,Integer>();
        int n=A.length;
        if(n==1){
            return A[0];
        }
        for(int x:A){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
                if(map.get(x)>n/2)
                    return x;
            }
            else{
                map.put(x,1);
            }
        }
        return 1;
    }
}

