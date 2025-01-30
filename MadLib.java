//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("punched");
		nouns.add("Wal-Mart");
		story = "I punched Wal-Mart in a massive way";
	}

	public MadLib(String fileName)
	{
		//load stuff
		
		try
		{
			Scanner wordScan = new Scanner(new File("story.dat"));
			//Read the different parts of the story and concatenate the resulting

			//While there is more of the story, read in the word/symbol
			while(wordScan.hasNext())
			{
				String x = wordScan.next();
				if(x.equals("#"))
				{
					//If what was read in is one of the symbols, find a random
					//word to replace it.
					story+= getRandomNoun();
				}
				else if(x.equals("&"))
				{
					story+= getRandomAdjective();

				}
				else if(x.equals("@"))
				{
					story+= getRandomVerb();
				}
				else
				{
					story += "" + wordScan.next();
				}
			}
			wordScan.close();
		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns()
	{
		try
		{
			Scanner nounReader = new Scanner (new File("nouns.dat"));
			while(nounReader.hasNext())
			{
				nouns.add(nounReader.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}

	}

	public void loadVerbs()
	{
	 
		try
		{
			Scanner verbReader = new Scanner (new File("verbs.dat"));
			while(verbReader.hasNext())
			{
				verbs.add(verbReader.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
		
	}

	public void loadAdjectives()
	{
		try
		{	
			Scanner adjReader = new Scanner (new File("adjectives.dat"));
			while(adjReader.hasNext())
			{
				adjectives.add(adjReader.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
	}

	public String getRandomVerb()
	{
		return "" + verbs.get((int)(Math.random()*12+1));
	}

	public String getRandomNoun()
	{
		return "" + nouns.get((int)(Math.random()*18+1));
	}

	public String getRandomAdjective()
	{
		return "" + adjectives.get((int)(Math.random()*15+1));
	}

	public String toString()
	{
		return "" + story;
	}
}