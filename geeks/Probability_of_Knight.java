package geeks;

public class Probability_of_Knight {
	static double chess[][][]=new double[8][8][3];
	public static double findProb(int x,int y,int n,int count) {
		double prob=Math.round(0f);
	
		if(count==3) {
			return 1;
		}
		if(x>=n || x<0 || y>=n || y<0) {
			return 0;
		}
		if(chess[x][y][count]!=0) {
			//System.out.println("works");
			return chess[x][y][count];
		}

		int available=0;
		double p=0;
		if(x+1<n && y+2<n && count<3) {
			p+=findProb(x+1,y+2,n,count+1);
			available++;
		}
		if(x+2 < n && y+1 <n && count<3) {
			p+=findProb(x+2,y+1,n,count+1);
			available++;
		}
		if(y-2 >=0 && x+1<n && count<3)
			{
				p+=findProb(x+1,y-2,n,count+1);
				available++;
			}
		if(x+2<n && y-1 >=0 && count<3) {	
			p+=findProb(x+2,y-1,n,count+1);
			
			available++;
		}
		if(x-2>=0 && y-1>=0 && count<3) {
			p+=findProb(x-2, y-1, n, count+1);
			available++;
		}
		if(x-1>=0 && y-2>=0 && count<3) {
			p+=findProb(x-1, y-2, n, count+1);
			available++;
		}
		if(x-2>=0 && y+1<n && count<3) {
			p+=findProb(x-2, y+1, n, count+1);
			available++;
		}
		if(x-1>=0 && y+2<n && count<3) {
			p+=findProb(x-1, y+2, n, count+1);
			available++;
		}
		
		prob=(double)p/8.0;
		chess[x][y][count]=prob;
			return prob;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findProb(0,0,8,0));
	}

}
