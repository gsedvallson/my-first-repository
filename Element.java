

public class Element {
	private String word;
	int occurence = 0;
	public Element(String arg){
		word = arg; occurence = 1;
	}
	public void increaseOccurence(){
		occurence +=1;
	}
	public int getOccurences(){
		return occurence;
	}
	public String getWord(){
		return word;
	}
	public boolean smallerThan(Element arg){
		boolean test = false;
		if (occurence < arg.getOccurences()) test = true;
		return test;
	}
	public String toString(){
		return "The word " + word + " has occured " + occurence + " times.\n";
	}
}
