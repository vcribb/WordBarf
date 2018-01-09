import java.util.*;

public class Word{
    private String word;
    private Word[] linksTo;
    private boolean visited;

    public Word(String line){
	visited = false;
	/*
        word = line.substring(0,4);
	line = line.substring(4,line.length());
        String[] wordFam = line.split(" ");
	int[] wordFam2 = new int[wordFam.length];
	for(int x = 0; x < wordFam.length; x++){
	    wordFam2[x] = Integer.parseInt(wordFam[x]);
	    
	}

	linksTo = wordFam2;
	*/
    }

    //accessor for visited
    public boolean isVisited(){
	return visited;
    }

    public void visit(){
	visited = true;
    }

    //accessor for word
    public String getWord(){
	return word;
    }

    public void nextWord(String s){
	return linksTo[0];//goes through linksTo and finds the most similar word
    }

    public static void main (String[] args){
	Word robert = new Word("fish 12 523 23456 1234 6 254 1234 6 25 ");


	
    }
}
