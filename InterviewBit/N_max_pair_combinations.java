class pair implements Comparable<pair> {
    int i;
    int j;
    Integer sum=0;
    pair(int i1,int j1,int s){
        i=i1;
        j=j1;
        sum=s;
    }
    public int compareTo(pair p){
        return p.sum.compareTo(this.sum);
    }
    
}
public class N_max_pair_combinations {
    public int[] solve(int A[],int B[]) {
        int n=A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int result[]=new int[n];
        int idx=0;
        int i=n-1;
        int j=n-1;
        HashMap<String,Integer>map=new HashMap<>();
        PriorityQueue<pair>heap=new PriorityQueue<pair>();
        pair p=new pair(i,j,A[i]+B[j]);
        map.put(i+"-"+j,0);
        heap.add(p);
        while(idx<n){
            pair p1=heap.poll();
            result[idx++]=p1.sum;
            i=p1.i;
            j=p1.j;
            pair p2;
            if(i!=0){
                if(!map.containsKey((i-1)+"-"+j)){
                
                    p2=new pair(i-1,j,A[i-1]+B[j]);
                    heap.add(p2);
                    map.put((i-1)+"-"+j,0);
                }
            }
            if(j!=0){
                if(!map.containsKey((i)+"-"+(j-1))){
                    p2=new pair(i,j-1,A[i]+B[j-1]);
                    heap.add(p2);
                    map.put((i)+"-"+(j-1),0);
                }
            }
        }
        return result;
    }
}
