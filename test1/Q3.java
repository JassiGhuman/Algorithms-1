import java.util.*;
public class Q3 {

  
  public static int A[];
  public static int B[];
  public static int C[];
  public static int D[];
  
  public static char arr[];

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    System.out.println("Enter the length of String :");
    int n = s.nextInt();
    
    System.out.println("Enter the string :");
    String ss = s.next();
    
    arr = ss.toCharArray();
    int counta = 0;
    int countb = 0;
    int countc = 0;
    int countd = 0;
    
    for(int i = 0; i < arr.length ; i++ )
    {
      if(arr[i] == 'a')
        counta++;
      else if(arr[i] == 'b')
        countb++;
      else if(arr[i] == 'c')
        countc++;
      else if(arr[i] == 'd')
        countd++;
    }
    
    System.out.println("Enter the number of queries : ");
    int m = s.nextInt();
    
    A = new int[counta] ;
    B = new int[countb] ;
    C = new int[countc] ;
    D = new int[countd] ;
    
    changeme(A , B , C , D , arr);
    
    int key;
    char value;
    int pos = 0;
    System.out.println("Enter the queries : ");
    for(int i = 0; i < m ; i++)
    {
      
      key = s.nextInt();
      value = s.next().charAt(0);
      
      if(value == 'a')
      {
        pos = A[key-1];
        ss = ss.substring(0,pos)+'!'+ss.substring(pos+1);
        arr = ss.toCharArray();
        changeme(A , B , C , D , arr);
        
      }
      else if(value == 'b') {
        pos = B[key-1];
        ss = ss.substring(0,pos)+'!'+ss.substring(pos+1);
        arr = ss.toCharArray();
        changeme(A , B , C , D , arr);
        
        }
      else if(value == 'c') {
        pos = C[key-1];
        ss = ss.substring(0,pos)+'!'+ss.substring(pos+1);
        arr = ss.toCharArray();
        changeme(A , B , C , D , arr);
        
      }
      else if(value == 'd') {
        pos = D[key-1];
        ss = ss.substring(0,pos)+'!'+ss.substring(pos+1);
        arr = ss.toCharArray();
        changeme(A , B , C , D , arr);
        
        }
      
    }
    
    char finalarr[] = ss.toCharArray();
    for(int i = 0; i < finalarr.length ; i++)
    {
      if(finalarr[i] != '!')
        System.out.print(finalarr[i]);
    }
  }

  
  public static void changeme(int[] a , int b[] , int c[] , int d[] , char[] arr)
  {

    int counta = 0;
    int countb = 0;
    int countc = 0;
    int countd = 0;
    
    for(int i = 0; i < arr.length ; i++ )
    {
      if(arr[i] == 'a')
      {
        A[counta] = i;
        counta++;
      }
      else if(arr[i] == 'b') {
        B[countb] = i;
        countb++;
        }
      else if(arr[i] == 'c') {
        C[countc] = i;
        countc++;
        }
      else if(arr[i] == 'd') {
        D[countd] = i;
        countd++;
        }
    }
      
    
  }
}