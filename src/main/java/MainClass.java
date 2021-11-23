import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class MainClass {

	public static BST tree= new BST();
	public static Vector<String> words = new Vector<String>();  
	public static ArrayList<WordClass> instancewords= new ArrayList<WordClass>();
	
	public static boolean BSTmade= false;
	public static Lock lock = new Lock();
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Vocabulary Thread for making BST from Vocabulary File
		 * Input Thread to build vectors from Input File
		 * MatchWord Thread to make Instances of words matched from BST and store their frequency
		 * QuerySearch tree to search words in all the given Files and Print it
		 */
		
		String filenames[]= {};
		try {
			filenames=new String[args.length];
		}
		catch(Exception e){
			
		}
		
		
		for(int i=0; i<args.length; i++) {
			filenames[i]=args[i];
			//System.out.println(filenames[i-2]+ "   " + args[i]);
		}
		
		VocabularyThread vocab=new VocabularyThread();
		InputThread[] inputs= {};
		MatchWordThread[] matchthread= {};
		
		try {
			inputs = new InputThread[filenames.length-1]; 
		}
		catch(Exception e) {
			
		}
		try {
			matchthread = new MatchWordThread[filenames.length-1]; 
		}
		catch(Exception e) {
			
		}
		
		System.out.println("No of Files: " + filenames.length);
		System.out.println("Files Names");
		
		for(int i=0; i<filenames.length; i++) {
			System.out.println((i+1) + ". " + filenames[i] );
		}
		
		
		
		for(int i=0; i<filenames.length; i++) {  
			if(i==0) {
				String threadname;     
				int index = -1;
				try {
					index = filenames[i].indexOf("."); 
				}
				catch(Exception e){
					
				}
				
				if (index != -1) 
				{
					threadname= filenames[i].substring(0 , index); 
				}
				else {
					threadname=filenames[i];
				}
				vocab=new VocabularyThread(filenames[i]);
				vocab.setName(threadname);
				vocab.start();
				
			}
			else {
				String threadname;    
				int index=-1;
				try {
					index = filenames[i].indexOf("."); 
				}
				catch(Exception e) {
					
				}
				
				if (index != -1) 
				{
					threadname= filenames[i].substring(0 , index); 
				}
				else {
					threadname=filenames[i];
				}
				try {
					inputs[i-1]=new InputThread(filenames[i]);
					inputs[i-1].setName(threadname);
					inputs[i-1].start();
					
					matchthread[i-1]=new MatchWordThread(filenames[i]);
					matchthread[i-1].setName(threadname);
				}
				catch(Exception e){
					
				}
				
			}
		} 
		
		if(filenames.length>0) {
			try {
				vocab.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		for(int i=1; i<filenames.length; i++) {  
				
				try {
					
					matchthread[i-1].start();
				}
				catch(Exception e){
					
				}
				
			
		} 
	
		for(int i=1; i<filenames.length; i++) {  
			try {
				inputs[i-1].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i=1; i<filenames.length; i++) {  
			try {
				matchthread[i-1].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		String option;
		while(true) {
			System.out.println("---------------------------------------------");
			System.out.println("Enter Your choice");
			System.out.println("1) Displaying BST build from Vocabulary File.");
			System.out.println("2) Displaying Vectors build from Input files.");
			System.out.println("3) Viewing Match words and its frequency.");
			System.out.println("4) Searching a query");
			System.out.println("5) Enter 5 for Exiting");
			System.out.println("--------------------------------------------");
			
			Scanner input = new Scanner(System.in);
			option = input.nextLine();
			
			if(option.compareTo("1")==0) {
				tree.inorder();
				
			}
			
			else if(option.compareTo("2")==0) {
				System.out.println(words.toString());
			}
			
			else if(option.compareTo("3")==0) {
				System.out.println(instancewords.size());
				for(int i=0; i<instancewords.size(); i++) {
					try {
						System.out.println(instancewords.get(i).toString());
					}
					catch(Exception e) {
						
					}
					
				}
			}
						
			else if(option.compareTo("4")==0) {
				String lineinput;
				System.out.println("Enter a sequence of word separeted by space (a sentence)");
				Scanner inputobj=new Scanner(System.in);
				lineinput=inputobj.nextLine();
				QuerySearchThread[] query=new QuerySearchThread[filenames.length];
				for(int i=0; i<filenames.length; i++) {  
					
						try {
							query[i]=new QuerySearchThread(lineinput, filenames[i]);
							query[i].setName(filenames[i]);
							query[i].start();
						}
						catch(Exception e){
							
						}
						
				}
				
				for(int i=0; i<filenames.length; i++) {  
					try {
						query[i].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
						
			else if(option.compareTo("5")==0) {
				break;
			}
			
			else {
				System.out.println("Invalid option selected");
			}
			
		}
		
		
		
		 
	}

}
