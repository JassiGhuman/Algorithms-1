public class Word_Break {
    public int wordBreak(String A, String[] B) {
        int n=A.length();
        HashMap<String,Integer>map=new HashMap<>();
        
        boolean dp[]=new boolean[n];
        map=find(B,map);
        for(int i=0;i<n;i++){
            if(map.containsKey(A.substring(0,i+1))){
                dp[i]=true;
                continue;
            }
            String s="";
            for(int j=i-1;j>=0;j--){
                if(dp[j] && map.containsKey(A.substring(j+1,i+1))){
                    dp[i]=true;
                    break;
                }
            }            
        }
         if(dp[n-1])
            return 1;
        return 0;    
    }
    public HashMap<String,Integer> find(String B[],HashMap<String,Integer>map){
        int n=B.length;
        for(int i=0;i<n;i++){
            map.put(B[i],0);
        }
        return map;
    }
}
