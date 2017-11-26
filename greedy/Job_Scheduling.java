package greedy;

import java.util.Random;

public class Job_Scheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start[]= {1,2,4,4,5};
		int end[]= {3,4,5,6,7};
		sort_jobs(start,end);
		System.out.println(start[0]+" "+end[0]);
		int st=start[0];
		int nd=end[0];
		for(int i=1;i<start.length;i++) {
			if(start[i]>=nd) {
				System.out.println(start[i]+" "+end[i]);
				st=start[i];
				nd=end[i];
			}
		}

	}
	public static void sort_jobs(int start[],int end[])
	{
		quickSort(end,start, 0, start.length);
	}
	static int rank(int a[],int b[],int p,int r,int rank){
		int q=0;
		if(p<r) {
			int pvt=pivot(a,p,r);
			q=partition(a,b,p,r,pvt);
			int rnk=r-q;
			if(rnk==rank)
				return q;
			else if(rank<rnk)
			{
				return rank(a,b,q+1,r,rank);
			}
			else
			{
				return rank(a,b, p, q,rank-rnk);	
			}
		}
		return -1;
	}
	static void quickSort(int a[],int []b,int p,int r){
		int q=0;
		if(p<r) {
			q=rank(a,b,p,r,(r-p)-(r-p)/2);
			//System.out.println(q);
			// int pvt=r-1;
			//q=partition(a,p,r,pvt);
		quickSort(a,b, p, q);
		quickSort(a,b, q+1,r);
		}
	}
	
	static int pivot (int a[],int p,int r) {
		Random rand=new Random();
		int pivot=rand.nextInt(r-p)+p;
		//System.out.println(pivot);
		return pivot;
	}
	static int partition(int a[],int b[],int p,int r,int pivot) {
		int i=p-1;
		// System.out.println(a[pivot]);
		int pvt=a[pivot];
		for(int j=p;j<r;j++) {
			if(a[j]<pvt) {
				i++;
				if(i==pivot)
					pivot=j;
				if(i!=j)
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					
					temp=b[i];
					b[i]=b[j];
					b[j]=temp;
				}
			}
		}
		int temp=a[pivot];
		a[pivot]=a[i+1];
		a[i+1]=temp;
		
		temp=b[pivot];
		b[pivot]=b[i+1];
		b[i+1]=temp;

		return i+1;
	}

}
