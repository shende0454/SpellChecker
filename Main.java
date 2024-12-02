package spellchecker;
import static java.lang.System.out;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
public static Scanner x;
public static Scanner scan = new Scanner(System.in);
public static List<String> scannedLexicon = new ArrayList<>();
	
	public static void main(String[] args)
  	{
		try
		{
			x = new Scanner(new File("C:\\Users\\Hende\\eclipse-workspace\\tests\\lexicon.txt"));
		}
		catch(Exception e)
		{
			System.out.println("could not find file");
		}
		while(x.hasNext())
		{
			scannedLexicon.add(x.next());
		}
		x.close();
		SpellChecker sc = new SpellChecker(scannedLexicon);
		while(true)
		{
			out.println("Enter a word to find suggested words");
			String str1 = scan.next();
			List<String> suggestedWords = new ArrayList<>();
			suggestedWords = sc.suggestWords(str1, str1.length());
			
			for(String word: suggestedWords)
			{
				out.println(word);
			}
		}
		
  	}
  	
}
