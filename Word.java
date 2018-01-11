import java.util.*;
import java.io.*;
public class Word{
    private String word;
    private Word[] linksTo;
    //possibly totally unnecessary
    //private boolean visited;
    private int distance;

    public Word(){
    //    visited = false;
        distance = 2404;
    }


    public int getDistance(){
        return distance;
    }

    
    public void setDistance(int d){
         distance = d;
    }


    public String getWord(){
        return word;
    }

    //possibly totally irrelevant depending on the success of our algorithm.
    /*
    public Word nextWord(String end){
	if (linksTo.length != 0){
	    Word next = linksTo[0];
	    int maxSimi = 0;
	    for(int i = 0; i < linksTo.length; i ++){
		int simi = 0;
		for(int x = 0; x < 4; x++){
		    if (linksTo[i].getWord().charAt(x) == end.charAt(x)){
			simi++;
		    }
		}
		if (maxSimi < simi || ( !(linksTo[i].isVisited()) && next.isVisited())){
		    next = linksTo[i];
		    maxSimi = simi;
		}

	    }
	
	    return next;
        }

	return null;
    }

    */
    
    public void branch(int d){
        for(int i = 0; i < linksTo.length; i++){
            if(linksTo[i].getDistance() == 2404){
                linksTo[i].setDistance(d);
            }
        }
    }
    
    public boolean branched(){
        for(int i = 0; i < linksTo.length; i++){  
            if(linksTo[i].getDistance() == 2404){
                return false;
            }
        }
        return true;
    }
    
    public Word backTrack(){
        int mindex = 0;
        for(int i = 0; i < linksTo.length; i ++){
            if(linksTo[i].getDistance() < linksTo[mindex].getDistance()){
                mindex = i;
            }
        }
        return linksTo[mindex];
    }
    
    public void makeLinks(int[] indices, Word[] wordList){
       linksTo = new Word[indices.length];
       for(int i = 0; i < indices.length; i++){
           linksTo[i] = wordList[indices[i]];
       }   
    }
    
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
    
    public static void directions(){
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
     
		try{
		    File f = new File("adjacentWords.txt");
		    Scanner reader = new Scanner(f);
		    int i = 0;
		    while(reader.hasNext()){  
			words[i].makeLinks(words[i].parseLine(reader.nextLine()), words);
			i++;
		    }
		}catch(FileNotFoundException e){
            
		}
          
		String startW = "hate";
		String endW = "love";
        
        
		for(int i = 0; i < words.length; i++){
		    if(words[i].getWord().equals(startW)){
			words[i].setDistance(0);
		    }
		}
        
        
		boolean found = false;
		boolean allFull = false;
		for(int i = 0; !allFull &&  !found ; i++ ){
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
	    }
	    else{directions();}
        
	    }
}

