package eg.edu.alexu.csd.datastructure.hangman;

import java.io.*;
import java.util.*;

public class Hangman implements IHangman{
	
	
	String[] dic;
	String sword;
	int swordi,wguesses=0,Maxg;
	char[] used;
	char[] answer;
	
	String[] readDicintofile(String fname) {
		int listLength=0;
		String[] wordsList= {};
		try {
		BufferedReader scanner = new BufferedReader(new FileReader(fname));
		while(scanner.readLine()!=null)
			listLength++;
		scanner.close();
		wordsList=new String[listLength];
		for(int i=0;i<listLength;i++) 
			wordsList[i]=scanner.readLine();
		scanner.close();
		}catch(IOException e) {
			System.out.println("Failed to load file");
			
		}
		
		return wordsList;
		
		
	}
	
	public void setDictionary(String[] words) {
		dic=words;
	}
	
	public String selectRandomSecretWord() {
		if (dic.length==0)
			return null;
		swordi= new Random().nextInt(dic.length);
		sword= dic[swordi];
		used= new char[sword.length()];
		answer= new char[sword.length()];
		for(int i=0;i<sword.length();i++)
			answer[i]='-';
		return sword;
	}
	
	public String guess(Character c) throws Exception{
		int found=0;
		if (c==null)
			return String.valueOf(answer);
		for(int i=0;i<sword.length();i++) {
			if(c==used[i]) {
				System.out.println("You entered this letter before.");
				return String.valueOf(answer);
			}
		}
		for (int i=0;i<sword.length();i++) {
			char cCheck=sword.charAt(i);
			if (c==cCheck) {
				answer[i]=cCheck;
				found=1;
		}
		}
		if (found==0) {
			wguesses++;
			if(wguesses==Maxg) {
				System.out.println("Game over the secret word was" + sword);
				throw new Exception();
			}
			return String.valueOf(answer);
		}
		else if (String.valueOf(answer)==sword) {
			System.out.println("Correct" + sword);
		}
			return String.valueOf(answer);
	}
	
	public void setMaxWrongGuesses(Integer max) {
		if (max==null)
			Maxg=1;
		else 
			Maxg=max;
	}
}