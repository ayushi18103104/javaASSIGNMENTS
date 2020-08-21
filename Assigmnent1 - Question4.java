import java.util.Arrays;
import java.util.Scanner;
public class Solution{
	static void isAnag(String s1 , String s2){
		String str1 = s1.replaceAll("\\s" , "");
		String str2 = s2.replaceAll("\\s" , "");
		boolean status = true;
		if(str1.length() != str2.length())
		{
			stat= false;
		}
		else
		{
			char[] ArrayS1 = str1.toLowerCase().toCharArray();
			char[] ArrayS2 = str2.toLowerCase().toCharArray();
			Arrays.sort(ArrayS1);
			Arrays.sort(ArrayS2);
			stat = Arrays.equals(ArrayS1 , ArrayS2);
		}
		if(status)
		{
			System.out.println(str1 + " and " + s2 + " are anagrams");
		}
		else
		{
			System.out.println(str1 + " and " + s2 +" are not anagrams");
		}
	}
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		String str1 = sc.nextLine();         
		String str2 = sc.nextLine();  
		isAnag(str1 , str2);
	}	
} 