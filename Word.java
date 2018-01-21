import java.util.*;
import java.io.*;

public class Word{
    
    private String word; //stores a four-letter English word
    
    private Word[] linksTo; //stores other Word objects, whose Strings are adjacent
    //to that Word's String
    
    private int distance; //represents the number of different letters between two Words
    
    public Word(){
        distance = 10000; //set to 10000 because this is ridiculously high
	//so no word can have this distance
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

    //used in our algorithm, branches out into the linked list of Words by setting distances 
    public void branch(int d){
        for(int i = 0; i < linksTo.length; i++){
            if(linksTo[i].getDistance() == 10000){
                linksTo[i].setDistance(d);
            }
        }
    }

    //determines if a Word has all the elements in its linksTo list reached already
    public boolean branched(){
        for(int i = 0; i < linksTo.length; i++){  
            if(linksTo[i].getDistance() == 10000){
                return false;
            }
        }
        return true;
    }

    /*backTrack determines the previous Word in the word ladder by finding
      an adjacent word with the smallest distance*/
    public Word recursify(){
	int mindex = 0;
	
	for(int i = 0; i < linksTo.length; i ++){
	    if(linksTo[i].getDistance() < linksTo[mindex].getDistance()){
		mindex = i;
	    }
	}


        if(((int) ((Math.random() * 10) % 2)) == 2){
	    for(int i = 0; i < linksTo.length; i++){
		if(linksTo[i].getDistance() == linksTo[mindex].getDistance()){
		    return linksTo[i];
		}
	    }
	}else{
	    for(int i = linksTo.length - 1; i >= 0; i--){
                if(linksTo[i].getDistance() == linksTo[mindex].getDistance()){
                   return  linksTo[i];
                }
            }
	}
        return linksTo[mindex];
    }

    /*parseLine reads into the precomputed file of all four-letter English
      words and their adjacent words and returns an array of the indices of
      the adjacent four-letter words*/
    public int[] parseLine(String line){
        word = line.substring(0,line.indexOf(' '));
        line = line + "   ";
        line = line.substring(line.indexOf(' ') + 1 ,line.length());
        String[] wordFam = line.split(" ");
        int[] wordFam2 = new int[wordFam.length];
        for(int x = 0; x < wordFam.length; x++){
            wordFam2[x] = Integer.parseInt(wordFam[x]);
	    
        }
        return wordFam2;
    }

    /*makeLinks reads into the array of indices produced by parseLine and
      populates the linksTo array with links to other words in the big array*/
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
	    File f = new File("EnglishWords.txt");
	    Scanner in = new Scanner(f);
	    String s = "";
	    while (in.hasNext()){
		String nextLine = in.nextLine() + "  ";
	        if (nextLine.substring(0, nextLine.indexOf(' ')).equals(word)){
			return true;
		}
	    }
	    in.close();
	}
	    catch(FileNotFoundException e){
	    System.exit(1);
	    }
	    return false;
	}
	
	//the directions print if the user doesn't input data correctly
	public static void directions(){
	System.out.println("Welcome to Word Barf!");
	System.out.println("This is a program that takes two same length  English words and prints");
	System.out.println("a string of words going from one to the other changing one letter at a time.");
	System.out.println("Please enter the word you would like to start with,");
	System.out.println("followed by the word you would like to end with in the following format:");
	System.out.println("java Word startWord endWord");
	System.out.println("Thank you!");
    }



    

    //    public static void recursify(Word endingWord, ArrayList<String> runningList){
	//System.out.println(endingWord.getWord());
	//System.out.println(startingWord.getWord());
    //	Word[] linksList = new Word[0];
    //	if(endingWord.getDistance() == 0){
    //	    System.out.println(endingWord.getWord());
    //	    System.out.println(runningList);
    //	    runningList.clear();
    //	}else{
    //	    for(int i = 0; i < endingWord.linksTo.length; i ++){
    //		
    //		if (endingWord.linksTo[i].getDistance() < endingWord.getDistance()){
    //		    linksList = endingWord.linksTo;
    //		    runningList.add(endingWord.getWord());
    //		    recursify(linksList[i], runningList);
		    // System.out.println(endingWord.getWord());
    //		}
    //		
    //	    }
    //	}
	
	
	
	
	    //	}

    
    public static void main (String[] args){
	//checks that the user has inputted two samelength English words
	if (args.length == 2 && args[0].length() == args[1].length() && isEnglish(args[0]) && isEnglish(args[1])){
	    //creates a new Word for each four-letter English word
	    Word[] words = new Word[126576];
	    for(int i = 0; i < words.length; i++){
		words[i] = new Word();
		//System.out.println("asdf");
	    }
	    
	    //writes the linksTo array for each Word
	    try{
		File f = new File("EnglishConnections.txt");
		Scanner reader = new Scanner(f);
		int i = 0;
		while(reader.hasNext()){
		    String newLine = reader.nextLine();
		    //System.out.println(newLine);
		    
		    // if(newLine.substring(0, newLine.indexOf(' ')).length() == 4){
		    //	System.out.println(newLine);
			words[i].makeLinks(words[i].parseLine(newLine), words);
			i++;
			// }
		}
		
	    }catch(FileNotFoundException e){
            
	    }

	    // for testing purposes
	    //  System.out.println("Completed the file parsing");

	    
	    //takes the user input and makes them the starting and ending words
	    String startW = args[1];
	    String endW = args[0];
	    Word endingWord = new Word();
	    //For testing purposes
	    for(int i = 0; i < words.length; i++){
		//	System.out.println(words[i].getWord());
		
	    }
	    
	   
	    
	    //sets the distance of the starting word to zero
	    for(int i = 0; i < words.length; i++){
		if(words[i].getWord().equals(startW)){
		    words[i].setDistance(0);
		}
	    }
	    
	    /*goes through the Words and assigns them a distance from the starting word,
	      stopping once the end word has been found*/
	    boolean found = false;
	    boolean allFull = false;
	    for(int i = 0; !allFull && !found ; i++ ){
		allFull = true;
		for(int j = 0; j < words.length; j++){
		    if(words[j].getDistance() == i){
			allFull = allFull && words[j].branched(); 
			words[j].branch(i + 1);
                    
			//System.out.println(words[j].getWord()); // for testing 
			//System.out.println(words[j].getDistance()); // for testing
		    }
		    if(words[j].getWord().equals(endW) && words[j].getDistance() < 10000){
			//System.out.println(words[j].getDistance()); // for testing
			found = true;
			endingWord = words[j];
		    }
		}
	    }
	    
	    /*if all the Words have been branched and the end word has not been found,
	      the system will exit*/
	    if(allFull){
		System.out.println("Sorry, there is no such path");
		System.exit(1);
	    }
	    
		
	    //System.out.println(allFull); // for testing
	   
	      System.out.println(endW);
	      boolean done = false;
	    	    Word on = new Word();
        
	    /*prints out the list of words, starting from the first word and "backtracking"
	      to the last word*/
	     for(int x = 0; x < words.length; x++){
			if(words[x].getWord().equals(endW)){
		      on = words[x];
		    	}
            
		 }
        
	     while(on.getDistance() != 0){
			on = on.recursify();
			System.out.println(on.getWord());
		   }

	    //   System.out.println("\n\n\n\n\n\n\n\n\n");
	    //    ArrayList<String> runningList = new ArrayList<String>();
	    //  recursify(endingWord, runningList);
	    
	}
	//prints directions if the user input does not comply with the format
	else{
	    directions();
	}
    }
}

