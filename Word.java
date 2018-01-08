public class Word{
    private String word;
    private Word[] linksTo;
    private boolean visited;

    public Word(String w){
	word = w;
	visited = false;
	//add linksTo later
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

    public Word nextWord(String){
	//goes through linksTo and finds the most similar word
    }
}
