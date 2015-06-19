import java.io.*; 
public class Subject{
    	SecurityLevel security;
    	String name;
    	int temp = 0;
    	StringBuilder buffer;
    	OutputStream output;
    	public Subject(String n, SecurityLevel sec) throws FileNotFoundException{
    		security =  sec;
    		name = n.toLowerCase();
    		buffer = new StringBuilder();
    		output = new FileOutputStream(new File("log"));
    	}

    	public void run_Lyle(String bit) throws IOException{
    		/*fill list up to eight buffer*/
    		if (buffer.length() < 8){
    			buffer.append(bit);

    		/*when list is full, write output to file, clear 
    		buffer and continue*/
    		} else {
    			output.write(Integer.parseInt(buffer.toString(),2));
    			buffer = new StringBuilder();
    		}
    	}

    	
 }
