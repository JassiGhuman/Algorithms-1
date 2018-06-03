public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = A.size();
        ArrayList<Integer>list = new ArrayList<>();
        result.add(list);
        
        for(int j=0;j<n;j++){
            list = new ArrayList<>();
            list.add(A.get(j));
            result.add(list);
            combinations(result,A,list,j+1);
        }
        Collections.sort(result,new Comparator<ArrayList<Integer>>(){
            @Override
        	public int compare(ArrayList<Integer> l1,ArrayList<Integer> l2){
        		int size = Math.min(l1.size(), l2.size());
        		for(int i = 0 ;i<size;i++){
        			if(l1.get(i)>l2.get(i)){
        				return 1;
        			}
        			else if(l1.get(i)<l2.get(i))
        				return -1;
        		}
        		
        		if(l1.size()>l2.size()){
        			return 1;
        		}
        		return -1;
        	}
        });
        return result;
    }
    
    public void combinations(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> A,
    ArrayList<Integer> list ,int index)
    {
        int n = A.size();
        if(index >= n)
            return ;
        for(int i = index ; i < n; i++){
            ArrayList<Integer> list_copy = new ArrayList<>(list);
            list_copy.add(A.get(i));
            result.add(list_copy);
            combinations(result,A,list_copy,i+1);
        }    
        
    }
    
    
}
