import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MatchWordThread extends Thread {
	public String filename;

	
	public MatchWordThread(String filename) {
		this.filename = filename;
	}

	public MatchWordThread() {

	}

	public void run() {
		System.out.println("Match Word Thread: " + this.getName() + " started");
		String line;
		try {

			FileReader file = new FileReader(filename);
			BufferedReader br = new BufferedReader(file);

			while ((line = br.readLine()) != null) {
				String words[] = line.split(" ");
				MainClass.lock.lock();
				//System.out.println("Start: "+line);
				
				for (int i = 0; i < words.length; i++) {
					if (MainClass.tree.search(words[i])) {
						//System.out.println("::" + words[i] + ",");
						boolean isalreadyInInstance = false;
						for (int j = 0; j < MainClass.instancewords.size(); j++) {
							if (MainClass.instancewords.get(j).getWord().equalsIgnoreCase(words[i])) {

								isalreadyInInstance = true;
								MainClass.instancewords.get(j)
										.setFrequency((MainClass.instancewords.get(j).getFrequency() + 1));
							}
						}
						if (!isalreadyInInstance) {
							MainClass.instancewords.add(new WordClass(words[i], 1));
							
						}

					}

				}
				//System.out.println("End: " + line);
				//System.out.println();
				MainClass.lock.unlock();

				
			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
