import java.util.ArrayList;
import java.util.Vector;

public class main {

	static BinarySearchTree  bt = new BinarySearchTree();
	static ArrayList<word> Word = new ArrayList<word>();
	static Vector<String> vector = new Vector<String>(); 
	public static void main(String[] args) {  
		 ArrayList<input1> t1 = new ArrayList<input1>();
		int j=0;
		vocabulary t = new vocabulary(args[0]);
		for(int i=0;i<args.length;i++)
		{
			if(i==0)
			{
				
			    t.setName(args[0]);  
                t.start();
               
			}
			else 
			{
				t1.add(i-1,new input1(args[i]));
				t1.get(i-1).setName(args[i]);
				t1.get(i-1).start();
			}
		}
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         while(j<args.length-1)
         {
        	 try {
				t1.get(j).join();
				j++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
         menu m=new menu(args);
         m.displaymenu();
	
	}
	
	
	
}
