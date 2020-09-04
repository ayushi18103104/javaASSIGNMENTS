import java.util.*;
public class solution{
	public static int strCompare(String string1, 
			String string2) 
	{ 
		for (int i = 0; i < string1.length() &&  
				i < string2.length(); i++) { 
			if ((int)string1.charAt(i) ==  
					(int)string2.charAt(i)) { 
				continue; 
			}  
			else { 
				return (int)string1.charAt(i) -  
						(int)string2.charAt(i); 
			} 
		} 

		if (string1.length() < string2.length()) { 
			return (str1.length()-str2.length()); 
		}  
		else if (string1.length() > string2.length()) { 
			return (string1.length()-string2.length()); 
		} 

		else { 
			return 0; 
		} 
	} 

    public static void main(String[] args){
    	Scanner sc = new Scanner ( System.in ) ; 
    	System.out.println("Enter the size of array");
    	int n = sc.nextInt();
    	n=n+1;
    	String[] arr = new String[n];
    	System.out.println("Enter the elements : ");
    	for(int i = 0 ; i < n ; i++ ) {
    		arr[i] = sc.nextLine();
    	}
    	
    	for(int i = 0 ; i < n ; i++ ) {
    		for(int j = i+1 ; j < n ; j++ ) {
    			if(strCompare(arr[i],arr[j]) > 0) {
    				String t=arr[j];
    				arr[j]=arr[i];
    				arr[i]=t;
    			}
    			
    			else
    				continue;
    		}
    	}
    	
    	for(int i=0;i<n;i++) {
    		System.out.println(arr[i] + "   ");
    	}
    	
    }
}