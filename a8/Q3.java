package a8;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		int sides[];
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		
		sides=new int[n];
		for(int i=0;i<n;i++) {
			sides[i]=s.nextInt();
		}
		Q3 q=new Q3();
		try {
		System.out.println(q.findTriangleType(sides));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
		public Triangle findTriangleType(int sides[]) throws Exception {
			if(sides.length>3)
			{
				throw new Exception("Array length greater than 3");
			}
			if(sides.length==0)
			{
				throw new Exception("Array is empty");
			}
			if(sides[0]+sides[1]<=sides[2] || sides[0]+sides[2]<=sides[1] || sides[1]+sides[2]<=sides[0])
			{
				throw new Exception("Not a Traingle");
			}
			if(sides[0]<=0 || sides[1]<=0 || sides[2]<=0) {
				throw new Exception("Invalid Side Entered");
			}
			if(sides[0]==sides[1] && sides[1]==sides[2])
				return Triangle.equilateral;
			if(sides[0]==sides[1]) {
				if((sides[0]*sides[0])+(sides[1]*sides[1])==(sides[2]*sides[2])) {
					return Triangle.rightAngledIsosceles;
				}
				else
					return Triangle.isosceles;
			}
			if(sides[1]==sides[2]) {
				if((sides[1]*sides[1])+(sides[2]*sides[2])==(sides[0]*sides[0])) {
					return Triangle.rightAngledIsosceles;
				}
				else
					return Triangle.isosceles;
			}
			if(sides[0]==sides[2]) {
				if((sides[0]*sides[0])+(sides[2]*sides[2])==(sides[1]*sides[1])) {
					return Triangle.rightAngledIsosceles;
				}
				else
					return Triangle.isosceles;
			}
			if((sides[0]*sides[0])+(sides[2]*sides[2])==(sides[1]*sides[1]) ||
					(sides[1]*sides[1])+(sides[2]*sides[2])==(sides[0]*sides[0]) ||
					(sides[0]*sides[0])+(sides[1]*sides[1])==(sides[2]*sides[2]))
				return Triangle.rightAngled;
			
			return Triangle.scalene;
			
	}

	
}
enum Triangle{ equilateral,
	rightAngled, isosceles, rightAngledIsosceles, scalene } 

