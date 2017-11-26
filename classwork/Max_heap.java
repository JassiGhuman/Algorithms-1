package classwork;

public class Max_heap {
	int heap[];
	int capacity;
	int size;
	public Max_heap(int cap) {
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
		int parent=(i-1)/2;
		while(i!=0 && heap[parent]<heap[i]) {	//bottom up heapify
			int temp=heap[parent];	//swap
			heap[parent]=heap[i];
			heap[i]=temp;
			i=parent;
			parent=(i-1)/2;
		}
	}
	public int delete_max() {
		if(size==0) {
			System.out.println("Heap empty");
			return -1;
		}
		else {
			int max=heap[0];
			heap[0]=heap[size-1];
			size--;
			heapify(0);
			return max;
		}
	}
	public void heapify(int i) {
		int l=2*i+1;
		int r=2*i+2;
		int largest=i;
		if(l<size && heap[i]<heap[l]) {
			largest=l;
		}
		if(r<size && heap[largest]<heap[r]) {
			largest=r;
			
		}
		if(largest!=i) {
			int temp=heap[largest];
			heap[largest]=heap[i];
			heap[i]=temp;
			heapify(largest);
		}
	}
	public void print_heap() {
		for(int i=0;i<size;i++) {
			System.out.println(this.heap[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {5,3,7,8,2,6,4};
		Max_heap h1=new Max_heap(10);
		h1.build_heap(a);
		//h1.insert(1);
		h1.print_heap();
		h1.delete_max();
		h1.print_heap();
	}

}
