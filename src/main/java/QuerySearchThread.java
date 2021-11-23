import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class QuerySearchThread extends Thread {
	public String line;
	public String filename;

	public QuerySearchThread(String line, String filename) {
		this.line=line;
		this.filename = filename;
	}

	public QuerySearchThread() {

	}

	public void run() {
		System.out.println("Query Search Thread: "+ this.getName()+" started");
		String line1;
		LinkedList<WordClass> nwords = new LinkedList<WordClass>();
		try {
			String w[] = this.line.split(" ");

		
			for (int j = 0; j < w.length; j++) {
				nwords.add(new WordClass(w[j], 0, filename));

			}
			try {

				FileReader file = new FileReader(filename);
				BufferedReader br = new BufferedReader(file);

				while ((line1 = br.readLine()) != null) {
					String words[] = line1.split(" ");

					for (int i = 0; i < words.length; i++) {

						for (int j = 0; j < w.length; j++) {
							if (words[i].compareToIgnoreCase(w[j]) == 0) {
								nwords.get(j).setFrequency(nwords.get(j).getFrequency() + 1);
								
							}

						}

					}

				}

				br.close();

				for (int i = 0; i < w.length; i++) {
					nwords.get(i).Display();
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		} catch (Exception e) {

		}

	}
}
