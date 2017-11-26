package classwork;


public class Min_heap {
	int heap[];
	int capacity;
	int size;
	public Min_heap(int cap) {
		// TODO Auto-generated constructor stub
		capacity=cap;
		size=0;
		heap=new int [capacity];
	}
	public int get_min() {
		if(size==0) {
			System.out.println("Heap empty");
			return -1;
		}
		else
			return heap[0];
	}
	public void build_heap(int a[]) {
		size=a.length;
		for(int i=0;i<size;i++) {
			heap[i]=a[i];
		}
		for(int i=size/2;i>=0;i--) {
			heapify(i);
		}
	}
	public void insert(int k) {
		if(size==capacity) {
			System.out.println("Overflow");
		}
		
		int i=size++;
		heap[i]=k;
		int parent=(i-1)/2;;
		while(i!=0 && heap[parent]>heap[i]) {
			int temp=heap[parent];
			heap[parent]=heap[i];
			heap[i]=temp;
			i=parent;
			parent=(i-1)/2;
		}
	}
	public int delete_min() {
		if(size==0) {
			System.out.println("Heap empty");
			return -1;
		}
		else {
			int min=heap[0];
			heap[0]=heap[size-1];
			size--;
			heapify(0);
			return min;
		}
	}
	public void heapify(int i) {
		int l=2*i+1;
		int r=2*i+2;
		int smallest=i;
		if(l<size && heap[i]>heap[l]) {
			smallest=l;
		}
		if(r<size && heap[smallest]>heap[r]) {
			smallest=r;
			
		}
		if(smallest!=i) {
			int temp=heap[smallest];
			heap[smallest]=heap[i];
			heap[i]=temp;
			heapify(smallest);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {5,3,7,8,2,6,4};
		Min_heap h1=new Min_heap(10);
		h1.build_heap(a);
		h1.insert(1);
		
//		for(int i=0;i<a.length;i++) {
//			System.out.println(h1.heap[i]);
//		}
//		
		System.out.println(h1.delete_min());
		System.out.println(h1.delete_min());
		System.out.println(h1.delete_min());
		System.out.println(h1.delete_min());
		System.out.println(h1.delete_min());
		System.out.println(h1.delete_min());
		System.out.println(h1.delete_min());
		System.out.println(h1.delete_min());
		h1.insert(1);
		//System.out.println(h1.heap[0]);
		//System.out.println(h1.delete_min());
	}

}
