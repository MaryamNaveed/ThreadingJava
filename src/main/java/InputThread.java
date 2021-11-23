import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputThread extends Thread {
	public String filename;

	public InputThread() {
		
	}
	
	public InputThread(String filename) {
		this.filename = filename;
		
	}
	
	public void run() {
		System.out.println("Thread: "+ this.getName()+" started");
		
		String line;
		 FileReader file;
			try {
				file = new FileReader(filename);
				 BufferedReader br = new BufferedReader(file);  
				  
			     
			      while((line = br.readLine()) != null) {   
			            String words[] = line.split(" "); 
			            for(int i=0; i<words.length; i++) {
			            	MainClass.words.add(words[i]);
			            }
			            
			      }
			      
			      br.close();  
			            
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}


			
	}

}
