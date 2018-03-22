public class Solution {
	public int pow(int x, int n, int d) {
	    if(x==0)
	        return 0;
	    if(n==0){
	        return 1;
	    }     
	    return (int)(remainder(x,n,d)%d);    
	}
	long remainder(int x,int n,int d){
	    int p=n/2;
	    if(n==1){
	        if(x>0)
	            return x%d;
	        else
	            return (d-(-x)%d);
	    }
	    long result=(remainder(x,p,d)%d);
	    if(n%2==0){
            return (result%d*result%d)%d;    	        
	    }
	    else{
	        return (result%d*result%d*(x%d))%d;
	    }
	}
}
