import java.util.*;
import java.io.*;

public class Word{
    
    private String word; //stores a four-letter English word
    
    private Word[] linksTo; //stores adjacent four-letter English words
    
    private int distance; //the number of letters in the word that differ from
    //the starting word

    public Word(){
        distance = 2404;
    }

    //accessor for the distance variable
    public int getDistance(){
        return distance;
    }
    
    //setter for the distance variable
    public void setDistance(int d){
	distance = d;
    }

    //accessor for the word variable
    public String getWord(){
        return word;
    }

    //determines a Word's distance
    public void branch(int d){
        for(int i = 0; i < linksTo.length; i++){
            if(linksTo[i].getDistance() == 2404){
                linksTo[i].setDistance(d);
            }
        }
    }

    //determines if a Word has had its distance determined yet
    public boolean branched(){
        for(int i = 0; i < linksTo.length; i++){  
            if(linksTo[i].getDistance() == 2404){
                return false;
            }
        }
        return true;
    }

    /*backTrack determines the previous Word in the word ladder by finding
      an adjacent word with a smaller distance*/
    public Word backTrack(){
        int mindex = 0;
        for(int i = 0; i < linksTo.length; i ++){
            if(linksTo[i].getDistance() < linksTo[mindex].getDistance()){
                mindex = i;
            }
        }
        return linksTo[mindex];
    }

    /*parseLine reads into the precomputed file of all four-letter English
      words and their adjacent words and returns an array of the indices of
      the adjacent four-letter words*/
    public int[] parseLine(String line){
        word = line.substring(0,4);
        line = line + "   ";
        line = line.substring(5,line.length());
        String[] wordFam = line.split(" ");
        int[] wordFam2 = new int[wordFam.length];
        for(int x = 0; x < wordFam.length; x++){
            wordFam2[x] = Integer.parseInt(wordFam[x]);
	    
        }
        return wordFam2;
    }

    /*makeLinks reads into the array of indices produced by parseLine and
      copies the words with those indices into linksTo*/
    public void makeLinks(int[] indices, Word[] wordList){
	linksTo = new Word[indices.length];
	for(int i = 0; i < indices.length; i++){
	    linksTo[i] = wordList[indices[i]];
	}   
    }
    
    /*isEnglish checks if a word is in the saved file of all four-letter
      English words*/
    public static boolean isEnglish(String word){
	try{
	    File f = new File("FourLetterWords.txt");
	    Scanner in = new Scanner(f);
	    String s = "";
	    while (in.hasNext()){
		s += in.nextLine();
	    }
	    in.close();
	    String[] split = s.split(" ");
	    for (int x = 0; x < split.length; x++){
		if (split[x].equals(word)){
		    return true;
		}
	    }
	}
	catch(FileNotFoundException e){
	    System.exit(1);
	}
	return false;
    }

    //the directions print if the user doesn't input data correctly
    public static void directions(){
	System.out.println("Welcome to Word Barf!");
	System.out.println("This is a program that takes two four-letter English words and prints");
	System.out.println("a string of words going from one to the other changing one letter at a time.");
	System.out.println("Please enter the word you would like to start with,");
	System.out.println("followed by the word you would like to end with in the following format:");
	System.out.println("java Word startWord endWord");
	System.out.println("Thank you!");
    }
    
    public static void main (String[] args){
	if (args.length == 2){
	    Word[] words = new Word[2404];
	    for(int i = 0; i < words.length; i++){
		words[i] = new Word();
	    }
	    //creates a new Word for each four-letter English word
	    try{
		File f = new File("adjacentWords.txt");
		Scanner reader = new Scanner(f);
		int i = 0;
		while(reader.hasNext()){  
		    words[i].makeLinks(words[i].parseLine(reader.nextLine()), words);
		    i++;
		}
		//writes the linksTo array for each Word
	    }catch(FileNotFoundException e){
            
	    }
          
	    String startW = args[1];
	    String endW = args[0];
	    //takes the user input and makes them the starting and ending words

	    if (!isEnglish(startW) || !isEnglish(endW)){
		directions();
		System.exit(1);
	    }
	    //checks that the user has inputted two four-letter English words
        
	    for(int i = 0; i < words.length; i++){
		if(words[i].getWord().equals(startW)){
		    words[i].setDistance(0);
		}
	    }
	    //sets the distance of the starting word to zero
        
	    boolean found = false;
	    boolean allFull = false;
	    for(int i = 0; !allFull && !found ; i++ ){
		allFull = true;
		for(int j = 0; j < words.length; j++){
		    if(words[j].getDistance() == i){
			allFull = allFull && words[j].branched(); 
			words[j].branch(i + 1);
                    
			//System.out.println(words[j].getWord());
			//System.out.println(words[j].getDistance());
		    }
		    if(words[j].getWord().equals(endW) && words[j].getDistance() < 2404){
			//System.out.println(words[j].getDistance());
			found = true;
		    }
		}
	    }
	    /*goes through the Words and assigns them a distance from the starting word,
	      stopping once the end word has been found*/

	    if(allFull){
		System.out.println("Sorry, there is no such path");
		System.exit(1);
	    }
	    /*if all the Words have been branched and the end word has not been found,
	      the system will exit*/
		
	    //System.out.println(allFull);
	    System.out.println(endW);
	    boolean done = false;
	    Word on = new Word();
        
	    for(int x = 0; x < words.length; x++){
		if(words[x].getWord().equals(endW)){
		    on = words[x];
		}
            
	    }
        
	    while(on.getDistance() != 0){
		on = on.backTrack();
		System.out.println(on.getWord());
	    }
	    /*prints out the list of words, starting from the first word and "backtracking"
	      to the last word*/
	}
	else{
	    directions();
	}
    }
}

