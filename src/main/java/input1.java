
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
public class input1 extends Thread{
	String file;
	input1(String f){
		this.file=f;
	}
	 public void run()
	 {
		 
		 File file = new File(this.file);
		  
		  try {
				Scanner scan=new Scanner(file);
				while(scan.hasNextLine())
				{
				    main.vector.add(scan.next());  
				}
			
		  }
		  catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		  Scanner scan1;
		try {
			scan1 = new Scanner(file);
			String matchword; int i=0;
			while(scan1.hasNextLine())
			{
			    matchword=scan1.next();
			   // System.out.println(matchword+"called");
			    boolean found=main.bt.search(matchword);
			   // System.out.println(found);
			    if(found==true)
			    	
			    {
			    	boolean find=false;
			    	for(int j=0;j<main.Word.size();j++)
			    	{
			    		if(matchword.compareTo(main.Word.get(j).getWord())==0) {
			    			find=true;
			    			main.Word.get(j).setFrequency(main.Word.get(j).getFrequency()+1);
			    		}
			    			
			    		
			    	}
			    	if(!find) {
			    		main.Word.add(i,new word(matchword,1));
			    		i++;
			    	}
		    			
			    }
			    
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	 }
	 

}
