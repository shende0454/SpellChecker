package spellchecker;

import java.util.ArrayList;
import java.util.List;

public class SpellChecker {
public int m[][];
public List<String> lexicon;

	public SpellChecker() {}
	
	public SpellChecker(List<String> lexicon) 
	{
		this.lexicon = new ArrayList<>(lexicon.size());
		
		for(int i = 0; i < lexicon.size(); i++)
		{
			this.lexicon.add(lexicon.get(i));
		}
	}
	public List<String> suggestWords(String word, int maxDistance)
	{
		List<String> suggestedWords = new ArrayList<>();
		for (int i = 0; i < this.lexicon.size(); i++)
		{
			int dist = editDistance(lexicon.get(i), word);
			
			if(dist < maxDistance )
			{
				if(dist == 0)
				{
					System.out.println("This word is spelled correctly");
					break;
				}
				
				if(dist <= 1)
				{
					suggestedWords.add(lexicon.get(i));
				}
			}
		}
		
		if(suggestedWords.size() == 0)
			System.out.println("There are no suggested words for this entry");
		return suggestedWords;
	}
	
	public int editDistance(String s1, String s2) {
		// table to store subproblems
		int[][] m = new int[s1.length()+1][s2.length()+1];
         // fill table from bottem to top
		for (int i = 0; i < s1.length() + 1; i++) {
			for (int j = 0; j < s2.length() + 1; j++) {
				if (i == 0 && j == 0) { // if first or second string is empty op equal to zero
					m[i][j] = 0;
				} else if (i == 0) {
					m[i][j] = m[i][j - 1] + 1;
				} else if (j == 0) {
					m[i][j] = m[i - 1][j] + 1;
				} else {// if last chars are the same leave last and recurse the rest
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						m[i][j] = m[i - 1][j - 1];
					} else {
						m[i][j] = 1 + min(m[i][j - 1], m[i - 1][j], m[i - 1][j - 1]);
					}
				}
			}
		}

		return m[s1.length()][s2.length()];
		
		}
	
	private int min(int a, int b, int c) {
		int min = 0;
		if (a < b && a < c) {
			min = a;
		} else if (b < a && b < c) {
			min = b;
		} else {
			min = c;
		}

		return min;
	}
}
