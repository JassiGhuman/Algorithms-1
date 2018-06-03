//sorted arraylist of arrayLists using comparator
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
            //any dummy function
            //combinations(result,A,list,j+1);    
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
