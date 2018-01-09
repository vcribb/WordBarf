import java.util.*;
import java.io.*;
public class Word{
    private String word;
    private Word[] linksTo;
    private boolean visited;

    public Word(){
        visited = false;
    }


    public boolean isVisited(){
        return visited;
    }

    
    public void visit(){
        visited = true;
    }


    public String getWord(){
        return word;
    }

    public Word nextWord(String s){
        return linksTo[0];//goes through linksTo and finds the most similar word
    }

    public void makeLinks(int[] indices, Word[] wordList){
       for(int i = 0; i < indices.length; i++){
           linksTo[i] = wordList[indices[i]];
       }   
    }
    
    public int[] parseLine(String line){
        word = line.substring(0,4);
        line = line.substring(4,line.length());
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
 
        
        
    
        for(int i = 0; i < words.length; i++){
            System.out.println(words[i].getWord());
        }
    }
}