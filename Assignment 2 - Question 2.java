import java.io.*; 
import java.lang.*; 
import java.util.*;
class countingSort 
{ 
    void sort(int arr[]) 
    { 
        int n = arr.length; 
        int arr2[] = new int[n]; 
 
        int cnt[] = new int[256]; 
        for (int i=0; i<256; ++i) 
            cnt[i] = 0; 
		
        for (int i=0; i<n; ++i) 
            ++cnt[arr[i]]; 
   
        for (int i=1; i<=255; ++i) 
            cnt[i] += cnt[i-1]; 
  
        for (int i = n-1; i>=0; i--) 
        { 
            arr2[cnt[arr[i]]-1] = arr[i]; 
            --cnt[arr[i]]; 
        } 
  
        for (int i = 0; i<n; ++i) 
            arr[i] = arr2[i]; 
    } 

    public static void main(String args[]) 
    { 
		Scanner sc = new Scanner(System.in);
        countingSort obj = new countingSort(); 
		System.out.println("Enter the size of the array");
		int n = sc.nextInt();
        int arr[] = new int[n]; 
		System.out.println("Enter the array elements ")
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
        obj.sort(arr); 
  
        System.out.println("Sorted array is "); 
        for (int i=0; i<arr.length; ++i) 
		{
            System.out.print(arr[i]+" "); 
		}
    } 
} 