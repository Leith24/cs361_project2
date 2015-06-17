
import java.io.*;
import java.util.*;
import java.lang.Number;

public class CovertChannel{
	public static final int NUM_INSTRUCTIONS = 4;
	public static final int NUM_SUBJECTS = 2;
	
	public static void main(String args[]) throws Exception{

		
	    Bytes bytes = new Bytes(args[0]);
	    String[] bits_array;
	   
	    while((bits_array=bytes.getBitsFromLine()) != null) {
	    	
	        
	        generate(bits_array);

	    }
	  
	 


	}

	public static String generate(){
	
		return "";
    }

	


}
