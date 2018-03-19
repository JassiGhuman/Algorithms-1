package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

//Given an array of numbers, program to
//arrange the numbers to form the 
//largest number
public class Biggest_nos_arrangement {
//	public static void arrange(int a[]){
//		int n=a.length;
//		double temp[]=new double[n];
//		String arr[]=new String[n];
//		for(int i=0;i<n;i++){
//			arr[i]=(a[i]+"");
//		}
//		Arrays.sort(arr);
//		//Arrays.sort(a,new Comparator<Integer>());
////		Arrays.sort(arr, new Comparator<String>() {
////			public int compare(String X, String Y) {
////			     
////			    // first append Y at the end of X
////			    String XY=X + Y;
////			     
////			    // then append X at the end of Y
////			    String YX=Y + X;
////			     
////			    // Now see which of the two formed numbers 
////			    // is greater
////			    return YX.compareTo(XY);		//here if xy is comapred to yx then it should return according to max value
////			}
////		});
//		for(int i=0 ; i< arr.length ; i++)
//	        System.out.print(arr[i]);
//		
//		System.out.println();
//	}
    public String largestNumber(final int[] A) {
        int n=A.length;
        
        StringBuilder a[]=new StringBuilder[A.length];
        for(int i=0;i<n;i++){
            a[i]=new StringBuilder(A[i]+"");
        }
        Arrays.sort(a,new Comparator<StringBuilder>(){
           @Override
           public int compare(StringBuilder x,StringBuilder y){
               StringBuilder xy=x.append(y);
               StringBuilder yx=y.append(x);
               return yx.compareTo(xy);
           }
        });
        String result="";
        if(a[0].charAt(0)=='0')
            return "0";                
        for(StringBuilder s:a){
            result+=s.toString();
        }

        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		int a[]={ 3, 31, 34, 5, 9};
		//arrange(a);
	}

}
