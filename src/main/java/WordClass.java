
public class WordClass {
	private String word;
	private int frequency;
	private String filename;
	
	
	
	
	public WordClass() {
		
	}


	

	public WordClass(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}




	public WordClass(String word, int frequency, String filename) {
		this.word = word;
		this.frequency = frequency;
		this.filename = filename;
	}




	public String getWord() {
		return word;
	}




	public void setWord(String word) {
		this.word = word;
	}




	@Override
	public String toString() {
		return "WordClass [word=" + word + ", frequency=" + frequency + "]";
	}

	public void Display() {
		System.out.println("[filename=" + filename+ ", word=" + word + ", frequency=" + frequency + "]");
	}



	public int getFrequency() {
		return frequency;
	}




	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}




	public String getFilename() {
		return filename;
	}




	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
}
