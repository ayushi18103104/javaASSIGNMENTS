import java.io.*; 
import java.lang.*; 
import java.util.*;
public class mySolution
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first string");
		String inp1 =sc.nextLine();
		System.out.println("Enter the second string");
		String inp2 = sc.nextLine();
		
		char str1[] = inp1.toCharArray();
		char str2[] = inp2.toCharArray();
		
		if(inp1.length() != inp2.length())
		{
			System.out.println("Not Equal");
		}
		else
		{
			int flag = 1;
			for(int i=0;i<inp1.length();i++)
			{
				if(str1[i] != str2[i]) 
					flag = 0;
			}
			if(flag == 1)
			{
				System.out.println("Equal Strings");
			}
			else
			{
				System.out.println("Not Equal");
			}
		}
		
		
	}
}
