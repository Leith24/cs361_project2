
import java.io.*;
import java.util.*;
import java.lang.Number;

public class CovertChannel{
	public static final int NUM_INSTRUCTIONS = 4;
	public static final int NUM_SUBJECTS = 2;
	public static OutputStream output;
	public static void main(String args[]) throws Exception{

	    String[] instructions = {"create hal obj, create lyle obj, write lyle obj 1, read lyle obj, destroy lyle obj, run lyle"};
	    Bytes bytes;
	    if(args[0].equals("v")){
		output = new FileOutputStream(new File("log"));
		bytes = new Bytes(args[1]);
		
	    }
	    else{
	    	bytes = new Bytes(args[0]);
	    }
	    String[] bits_array;
	    ReferenceManager ref = new ReferenceManager(new Subject("Lyle", SecurityLevel.LOW),
	    	new Subject("Hal", SecurityLevel.HIGH),output);
	   
	   
	    while((bits_array=bytes.getBitsFromLine()) != null) {
	    	
	    	for (int i = 0 ; i < instructions.length; i++){
	    		InstructionObject instructionObject = new InstructionObject(
	    			instructions[i]);
	    		ref.setInstruction(instructionObject);
	    		
	    	}


	    }
	  
	 


	}


	


}
