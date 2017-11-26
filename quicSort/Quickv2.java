package quicSort;

import java.util.Random;

public class Quickv2 	{

	static int rank(int a[],int p,int r,int rank){
		int q=0;
		if(p<r) {
			int pvt=pivot(a,p,r);
			q=partition(a,p,r,pvt);
			int rnk=r-q;
			if(rnk==rank)
				return q;
			else if(rank<rnk)
			{
				return rank(a,q+1,r,rank);
			}
			else
			{
				return rank(a, p, q,rank-rnk);	
			}
		}
		return -1;
	}
	static void quickSort(int a[],int p,int r){
		int q=0;
		if(p<r) {
			q=rank(a,p,r,(r-p)-(r-p)/2);
			//System.out.println(q);
			// int pvt=r-1;
			//q=partition(a,p,r,pvt);
		quickSort(a, p, q);
		quickSort(a, q+1,r);
		}
	}
	
	static int pivot (int a[],int p,int r) {
		Random rand=new Random();
		int pivot=rand.nextInt(r-p)+p;
		//System.out.println(pivot);
		return pivot;
	}
	static int partition(int a[],int p,int r,int pivot) {
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
				}
			}
		}
		int temp=a[pivot];
		a[pivot]=a[i+1];
		a[i+1]=temp;

		return i+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Random r=new Random();
		//System.out.println(r.nextInt(6)+5);
		int a[]= {221,44,5,2,33};
		//quickSort(a, 0, 5);
		System.out.println(rank(a, 0, a.length,5 ));
		//System.out.println(rank(a, 0, 5,3));
		//System.out.println(pivot(a, 0, 5));
		for(int i=0;i<5;i++) {
			System.out.println(a[i]);
		}
	}

}
