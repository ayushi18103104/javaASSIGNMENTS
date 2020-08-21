import java.util.Scanner;

class solution
{ 
	void lpsarr(String pattern, int m, int lps[]) 
	{ 
		int l = 0, i=1; 
		lps[0] = 0;

		while (i < m) 
		{ 
			if (pattern.charAt(i) == pattern.charAt(l)) 
			{ 
				l++; 
				lps[i] = ln; 
				i++; 
			} 
			else 
			{ 
				if (l != 0) 
				{ 
					l = lps[l-1]; 
				} 
				else
				{ 
					lps[i] = l; 
					i++; 
				} 
			} 
		}
	}

	int search(String text, String pattern) 
	{ 
		int m = pattern.length(); 
		int n = text.length(); 

		int lps[] = new int[m]; 
		int j = 0; 

		lpsarray(pattern,m,lps); 

		int i = 0, count = 0, next_i = 0; 
		
		while (i < n) 
		{ 
			if (pattern.charAt(j) == text.charAt(i)) 
			{ 
				j++; 
				i++; 
			} 
			if (j == m) 
			{ 
				j = lps[j-1]; 
				count++; 

				if (lps[j]!=0) 
					i = ++next_i; 
				j = 0; 
			} 

			else if (i < n && pattern.charAt(j) != text.charAt(i)) 
			{ 
				if (j != 0) 
					j = lps[j-1]; 
				else
					i = i+1; 
			} 
		} 
		return count; 
	}

	public static void main(String args[]) 
	{ 
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter text ");
		String str1 = obj.nextLine();
		
		System.out.println("Enter the pattern to be searched for ");
		String str2 = obj.nextLine();
		
		int count = new Q1().search(str1,str2); 
		System.out.println(count); 
	}
}
