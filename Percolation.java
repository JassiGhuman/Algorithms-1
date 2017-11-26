//import edu.princeton.cs.algs4.StdRandom;
//import edu.princeton.cs.algs4.StdStats;
//import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.*;
import java.util.Arrays;
public class Percolation {
   String a[][];
   public Percolation(int n)                // create n-by-n grid, with all sites blocked
   {
	a=new String[n+1][n+1];
	if(n<=0)
		throw new IllegalArgumentException();
   	for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++)
		{	
			a[i][j]=0+"-"+0;
		}
	}

	
   }

   public void open(int row, int col)    // open site (row, col) if it is not open already
   {
	if(!isOpen(row,col))
	{
		a[row][col]=row+"-"+col;
	}
   }

   public boolean isOpen(int row, int col)  // is site (row, col) open?
   {
	if(a[row][col].equals(0+"-"+0)){
		return false;
	}
	return true;
   } 
   public boolean connected(int p,int q,int r,int s) {
	if(root(p,q).equals(root(r,s)))//if(root(p)==root(q))
			return true;
		return false;
   }
   private String root(int p,int q) {
	   String s=a[p][q];
	   int x=Integer.parseInt(s.split("-")[0]);
	   int y=Integer.parseInt(s.split("-")[1]);
	   while(x!=p || y!=q) {
		   //id[i]=id[id[i]];
		   p=x;
		   q=y;
		   s=a[p][q];
		   
		   x=Integer.parseInt(s.split("-")[0]);
		   y=Integer.parseInt(s.split("-")[1]);
		   
	   }
	   return a[x][y];
   }
   
   public void union(int p,int q) {
	 
	   open(p, q);
	   String s=root(p,q);
				if(q<a.length-1 && isOpen(p,q+1) && !connected(p, q, p, q+1)) {
					check(p,q+1,s);
//					System.out.println("1");
				}
				
				if(q>1 && isOpen(p, q-1) && !connected(p, q, p, q-1))
					{
					check(p, q-1, s);
//					System.out.println("1");
					}
					if(p>1 && isOpen(p-1,q) && !connected(p, q, p-1, q))
					{	check(p-1, q, s);
//						System.out.println("1");
					}
				if(p<a.length-1 && isOpen(p+1, q) && !connected(p, q, p+1, q))
					{check(p+1, q, s);
					
					//System.out.println("12"+s+a[3][1]);
					}
				
   }
   
   private void check(int p,int q,String s) {
	   			
	   		int x=Integer.parseInt(s.split("-")[0]);
	   		int y=Integer.parseInt(s.split("-")[1]);
	   			
			String r=root(p,q);
			//System.out.println(r);
			int x1=Integer.parseInt(r.split("-")[0]);
			int y1=Integer.parseInt(r.split("-")[1]);
			
			if(x<=x1)
			{
				a[x1][y1]=s;
				//System.out.println(x1+"      "+y1);
				//size[i]+=size[j];
			}
			else
			{
				a[x][y]=r;
			}
	}
   
   
   public boolean percolates()              // does the system percolate?
   {	System.out.println("kuch bho");
	   	for(int i=1;i<a.length;i++) {
	   		System.out.println("heheh");
		if(isOpen(a.length-1,i) && root(a.length-1,i).matches("1-.*"))
			return true;
	}
	   	//System.out.println("kuch bho");
	return false;
   }
   	
   public static void main(String[] args)   // test client (optional)
   {
	   
	try {
		
	BufferedReader br = new BufferedReader(new FileReader("/home/abhishek/Documents/percolation/input3.txt")) ;
    	String line;
    	line = br.readLine();
    	int n=Integer.parseInt(line.trim());
    	Percolation perc=new Percolation(n); 
    		while ((line = br.readLine()) != null) {
    			// process the line.
    			line=line.trim();
    			System.out.println(line);
    			int p=0;
    			int q=0;
    			
    			String[] array = line.split(" +");
    			Arrays.sort(array);
    			p=Integer.parseInt(array[0]);
    			q=Integer.parseInt(array[1]);
    			//System.out.println(p+"v"+q);
    			perc.union(p,q);
    		}
    		for(int i=1;i<perc.a.length;i++) {
    			for(int j=1;j<perc.a.length;j++)
    				System.out.print(perc.a[i][j]+"  ");
    		System.out.println();
    		}
    		System.out.println(perc.percolates());
    		
    		
	br.close();
   }
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
   }
   
}
