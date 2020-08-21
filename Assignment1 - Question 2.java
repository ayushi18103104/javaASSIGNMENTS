import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter paragraph");
		String inputPara = sc.nextLine();
		System.out.println("Enter number of words you want to replace. ");
		int number = sc.nextInt();
		String [] words = new String [number];
		System.out.println("Enter words ");
		for(int i =0; i <words.length ;i++)
		{
			words[i] = sc.nextLine();
		}
		List <String> wordsToReplace = Arrays.asList(words);
		System.out.println(replace(inputPara, wordsToReplace));
	}

	private static String replace(String word, List <String> wordsToReplace)
	{
		for (String s : wordsToReplace)
		{
			Pattern p = Pattern.compile(s, Pattern.CASE_INSENSITIVE); 
			Matcher m = p.matcher(word); 
			StringBuilder sb = new StringBuilder();
			if (m.find())
			{ 
				for (int i = 0; i < s.length(); i++) {
				sb.append("*");
			}
		}
		word = m.replaceAll(sb.toString()); 
		}
		return word; 
	}
}