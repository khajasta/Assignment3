import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class menu {
  String[] filenames;
  public menu(String[] f) {
    filenames = f;
  }
  void displaymenu() {
    int choice = 0;
    while (true) {
      System.out.println("1) Displaying BST build from Vocabulary File.");
      System.out.println("2) Displaying Vectors build from Input files.");
      System.out.println("3) Viewing Match words and its frequency.");
      System.out.println("4) Searching a query->It should display all the files query found in.");
      System.out.println("5) Enter 5 for Exiting.");
      try {
      Scanner scan = new Scanner(System.in);
      choice = scan.nextInt();
      }
      catch (InputMismatchException e)
      {
    	  System.out.println("Please enter integer");
    	  continue;
      }
      if (choice == 1) {
        main.bt.inorderTraverse(main.bt.root);
      } else if (choice == 2) {
        System.out.println("Vector Elements are: " + main.vector);
      } else if (choice == 3) {
        for (int m = 0; m < main.Word.size(); m++) {
          System.out.println("Word: " + main.Word.get(m).getWord() + " Frequency: " + main.Word.get(m).getFrequency());
        }
      } else if (choice == 4) {
        handlequery();
      } else if (choice == 5) {
        System.out.println("Program Terminated.");
        return;
      }
      else 
      {
    	  System.out.println("OOPS WRONG INPUT.Please Select from 1-5");
      }
    }
  }  
  void handlequery() {

      String query = new String();
      System.out.println("Please a enter query text to find it in files.");
      Scanner scan = new Scanner(System.in);
      query = scan.nextLine();
      String[] words = query.split("\\s");
      ArrayList<word> Word = new ArrayList<word>();
      ArrayList<String> filenames1 = new ArrayList<String>();
      for(int m=0;m<filenames.length;m++) {
      for(int i=0;i<words.length;i++)
      {
    	  File file=new File(filenames[m]);
    	  Scanner scan1;
  		try {
  			scan1 = new Scanner(file);
  			String matchword; int k=0;
  			while(scan1.hasNextLine())
  			{
  			    matchword=scan1.next();
  			   // System.out.println(matchword+"called");
  			    int found=matchword.compareTo(words[i]);
  			   // System.out.println(found);
  			    if(found==0)
  			    	
  			    {
  			    	boolean find=false;
  			    	for(int j=0;j<Word.size();j++)
  			    	{
  			    		if(matchword.compareTo(Word.get(j).getWord())==0) {
  			    			find=true;
  			    			Word.get(j).setFrequency(Word.get(j).getFrequency()+1);
  			    		}
  			    			
  			    		
  			    	}
  			    	if(!find) {
  			    	Word.add(k,new word(matchword,1));
  			    		k++;
  			    	}
  		    			
  			    }
  			    
  			}
  		} catch (FileNotFoundException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} 
      }
   
      for(int i=0;i<Word.size();i++)
      {
    	  try {
                   
    	  System.out.println("Word: "+Word.get(i).getWord()+" Frequency:"+Word.get(i).getFrequency()+" File: "+ filenames[m]);
                
               
                 Word.get(i).setFrequency(0);
    	  }
    	  catch(IndexOutOfBoundsException e)
    	  {
    		  System.out.println("Oops index out of bound");
    	  }
      }

      }
      
    
       
          }
}
        