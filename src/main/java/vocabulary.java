import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class vocabulary extends Thread{
	
	String filename;
	vocabulary(String f)
	{
		this.filename=f;
	}

	public void run()
	{
		
		File file = new File(this.filename); 
		try {
			Scanner scan=new Scanner(file);
			while(scan.hasNextLine())
			{
				 main.bt.insert(scan.next());  
			}
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
           
}
