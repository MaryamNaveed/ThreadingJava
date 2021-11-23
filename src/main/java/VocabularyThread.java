import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VocabularyThread extends Thread {
	public String filename;

	public VocabularyThread(String filename) {
		this.filename = filename;
	}
	
	public VocabularyThread() {
		
	}



	public void run() {
		System.out.println("Thread: "+ this.getName()+" started");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String line;  
        
        FileReader file;
		try {
			file = new FileReader(filename);
			BufferedReader br = new BufferedReader(file);   
			  
		     
		      while((line = br.readLine()) != null) {   
		            String words[] = line.split(" "); 
		            for(int i=0; i<words.length; i++) {
		            	MainClass.tree.insert(words[i]);
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
	MainClass.BSTmade=true;
	
	System.out.println("Thread: "+ this.getName()+" Done");
	
//	synchronized(this) {
//		this.notifyAll();
//	}
//		
//		
//		synchronized(MainClass.tree) {
//			MainClass.tree.notifyAll();
//			System.out.println("Notified All");
//		}
		
    
	}
	
	

}
