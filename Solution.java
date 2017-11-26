import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long candies(int n, int[] arr) {
        // Complete this function
        int a[]=new int[n];
        int count=0;
        int start=0;
        int end=0;
        int series=0;
        for(int i=0;i<n;i++){
            a[i]=0;
        }
        if(arr[0]>arr[1]){
            a[0]=2;
            a[1]=1;
            start=0;
            end=1;
        }
        else if(arr[0]==arr[1]){
            a[0]=1;
            a[1]=1;
            start=1;
            end=1;
        }
        else{
            a[0]=1;
            a[1]=2;
            start=1;
            end=1;   
        }
        for(int i=1;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                series=0;     
                end=i+1;
            }
            else if(arr[i-1]==arr[i] && arr[i]==arr[i+1]){
                        a[i]=1;
                        a[i+1]=1;
                        
                        if(series==0)
                       { 
                            if(start!=end){
                                for(int j=start;j<=end;j++){
                                    if(a[j]<end-j+1)
                                    a[j]=end-j+1;
                                    //start++;
                                }
                            }
                       }
                       a[i]=1;
                       a[i+1]=1;
                       start=end=i+1;
                        series=1;
                        continue;
                  }
            else if(arr[i]==arr[i+1]){
                series=0;     
                end=i+1;
            }
            
    
            else{
                series=0;
                if(start!=end){
                for(int j=start;j<=end;j++){
                    
                    if(a[j]<end-j+1){
                        
                        a[j]=end-j+1;
                        
                    }
                    //start++;
                    }
                }
                a[i+1]=a[i]+1;
                
                start=end=i+1;
            }
        }
        if(a[n-1]==0){
             for(int j=start;j<=end;j++){
                    if(a[j]<end-j+1)
                        a[j]=end-j+1;
                    //start++;
                    }
            
        }
        long result=0;
        for(int i=0;i<n;i++){
            result+=a[i];
        //  System.out.println(a[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long result = candies(n, arr);
        System.out.println(result);
        in.close();
    }
}
