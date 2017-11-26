package hackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Node {
	int data;
	int distance;
	Node prev;
	
	int visited;
	int index_heap;//for decrease key
	Node(int x){
		data=x;
		distance=Integer.MAX_VALUE;
		visited=0;						//0 for unvisited 	1 for still being in heap  2. for getting deleted permanently
		
	}
}
class Min_heap {
	Node heap[];
	int capacity;
	int size;
	public Min_heap(int cap) {
		// TODO Auto-generated constructor stub
		capacity=cap;
		size=0;
		heap=new Node [capacity];
	}
	public Node get_min() {
		if(size==0) {
			System.out.println("Heap empty");
			return null;
		}
		else
			return heap[0];
	}
	
	public void insert(Node k) {

		int i=size++;
		heap[i]=k;
		int parent=(i-1)/2;
		while(i!=0 && heap[parent].distance>heap[i].distance) {
			Node temp=heap[parent];
			heap[parent]=heap[i];
			heap[i]=temp;
			heap[i].index_heap=i;
			heap[parent].index_heap=parent;
			i=parent;
			parent=(i-1)/2;
			
		}
		
	}
	public Node delete_min() {
		
			Node min=heap[0];
			heap[0]=heap[size-1];
			heap[0].index_heap=0;
			size--;
			heapify(0);
			return min;
	}
	public void heapify(int i) {
		int l=2*i+1;
		int r=2*i+2;
		int smallest=i;
		if(l<size && heap[i].distance>heap[l].distance) {
			smallest=l;
		}
		if(r<size && heap[smallest].distance>heap[r].distance) {
			smallest=r;
			
		}
		if(smallest!=i) {
			Node temp=heap[smallest];
			heap[smallest]=heap[i];
			heap[i]=temp;
			heap[smallest].index_heap=smallest;
			heap[i].index_heap=i;
			heapify(smallest);
			
		}
	}
	public void decrease_key(int index,Node n) {
		int parent=(index-1)/2;
		
		while(index!=0 && heap[index].distance<heap[parent].distance) {
			Node temp=heap[parent];
			heap[parent]=heap[index];
			heap[index]=temp;
			heap[index].index_heap=index;
			heap[parent].index_heap=parent;
			index=parent;
			parent=(index-1)/2;
		}
	}

}

class Graph{
	public LinkedList<Node> edges[];
	public LinkedList<Integer>distance[];
	public Integer vertices;
	Graph(int vertices){
		this.vertices=vertices;
		edges=new LinkedList[vertices];
		distance=new LinkedList[vertices];
		for(int i=0;i<vertices;i++) {
			edges[i]=new LinkedList<>();
			distance[i]=new LinkedList<>();
		}
	}
	
	public void addEdge(Node u,Node v,int d) {
		if(u!=v) {
			edges[u.data].add(v);
			distance[u.data].add(d);
			
			//for directed
			edges[v.data].add(u);
			distance[v.data].add(d);

		}
	}
	
}
class Dijkstra {
	Graph graph;
	public Dijkstra(Graph g)  {
		this.graph=g;
	}
	public void dijkstra(Node source) {
		int n=graph.vertices;
		
		source.distance=0;
		Node u=source;
		Min_heap heap=new Min_heap(n);
		heap.insert(u);
        int result[]=new int[graph.vertices];
        Arrays.fill(result,-1);
		u.visited=1;
		u.prev=u;

		while(heap.size!=0) {
			//System.out.println("1");
			int i=0;
			int size=graph.edges[u.data].size();
			while(i<size) {
				
				Node v=graph.edges[u.data].get(i);
				if(v.distance>u.distance + graph.distance[u.data].get(i)) {
					v.distance=u.distance + graph.distance[u.data].get(i);
//					v.prev=u;
					if(v.visited==1) {
						v.prev=u;
						heap.decrease_key(v.index_heap, v);
						//v.distance=Math.min(v.distance,v.prev.distance + graph.distance[u.data].get(i));
					}
					if(v.visited==0) {
							v.prev=u;
						//	v.distance=Math.min(v.distance,v.prev.distance + graph.distance[u.data].get(i));
							heap.insert(v);
							v.visited=1;
					}
					
				}
				result[v.data]=v.distance;
				i++;
			}
			heap.get_min().visited=2;
            result[u.data]=u.distance;
			heap.delete_min();			//distance or prev doesnt get update
			u=heap.get_min();
		}
        for(int i:result){
		  if(i!=source.data)
            System.out.println(i);
        }
     }
	
	
}



public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            Node nodes[]=new Node[n];
            Graph g = new Graph(n);
            int m = in.nextInt();
            for(int a1 = 0; a1 < m; a1++){
                int x = in.nextInt();
                if(nodes[x-1]==null)
                    nodes[x-1]=new Node(x-1);
                int y = in.nextInt();
                if(nodes[y-1]==null)
                    nodes[y-1]=new Node(y-1);
                int z = in.nextInt();
                g.addEdge(nodes[x-1],nodes[y-1],z);
                
                
            }
            Dijkstra dj=new Dijkstra(g);
            int s = in.nextInt();
            dj.dijkstra(nodes[s-1]);
        }
    }
}
