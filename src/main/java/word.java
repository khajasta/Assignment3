
public class word {

	private String word;
	private int frequency;
	public word()
	{
		word=null;
		frequency=0;
	}
	public word(String word1,int freq)
	{
		word=word1;
		frequency=freq;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
}
