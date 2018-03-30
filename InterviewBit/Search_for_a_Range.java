public class Search_for_a_Range {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    int start=-1;
	    int end=-1;
	    int n=a.size();
	    ArrayList<Integer>result=new ArrayList<>();
    	    int low=0;
    	    int high=n-1;
    	    int mid=0;
    	    while(low<=high){
    	        mid=(low+high)/2;
    	        if(a.get(mid)==b){
    	            if(mid==0 || a.get(mid-1)!=b){
    	                start=mid;
                        break;        	                
    	            }
    	            else{
    	                high=mid-1;
    	            }     
    	        }
    	        else if(a.get(mid)>b)
    	            high=mid-1;
    	        else
    	            low=mid+1;
    	        
    	    }
    	    low=0;
    	    high=n-1;
    	    mid=0;
    	    while(low<=high){
    	        mid=(low+high)/2;
    	        if(a.get(mid)==b){
    	            if(mid==n-1 || a.get(mid+1)!=b){
    	                end=mid;
    	                break;
    	            }
    	            else{
    	                low=mid+1;
    	            }     
    	        }
    	        else if(a.get(mid)>b)
    	            high=mid-1;
    	        else
    	            low=mid+1;
    	        
    	    }
    	    result.add(start);
    	    result.add(end);
	
	        return result;
	}
	
}
