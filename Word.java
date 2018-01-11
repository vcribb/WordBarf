import java.util.*;
import java.io.*;
public class Word{
    private String word;
    private Word[] linksTo;
    //possibly totally unnesesairy
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

    //possibly totally irrelivant depending on the success of our algorithm.
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
            if(linksTo[i].getDistance() = 2404){
                linksTo[i].setDistance(d);
            }
        }
    }
    
    public boolean branched(){
        for(int i = 0; i < linksTo.length; i++){  
            if(linksTo[i].getDistance() = 2404){
                return false;
            }
        }
        return true;
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
    
    public static void main (String[] args){
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
 
        


        

	   //for testing
       /*
        for(int i = 0; i < words.length; i++){
            System.out.println(words[i].getWord());
            try{
            System.out.println(words[i].nextWord("doom").getWord() + "\n\n\n\n\n");
	    }catch(NullPointerException e){
            System.out.println("\n");
	    }
        
        */
        
        //test for hate to love
        
        for(j = 0; j < words.length; j++){
            if(words[i].getWord().equals("hate"){
                words[i].setDistance(0);
            }
                
        }
        
        boolean allFull = false;
        boolean found = false;
            
        for(int i = 0; allFull || found; i++ ){
            
            for(j = 0; j < words.length; j++){
                if(words[j].getDistance() = i){
                    words[j].branch(i + 1);
                    
                }
                if(words[j].getWord().equals("love")){
                    found = true;
                }
            }
            
        }
        
        
        
        }
    }
}
