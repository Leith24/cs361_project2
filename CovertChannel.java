
import java.io.*;
import java.util.*;
import java.lang.Number;

public class CovertChannel{
	public static final int NUM_INSTRUCTIONS = 4;
	public static final int NUM_SUBJECTS = 2;
	public static OutputStream output;
	public static OutputStream out; //file for output
	static boolean v = false;
	public static void main(String args[]) throws Exception{

	    String[] instructions = {"create hal obj, create lyle obj, write lyle obj 1, read lyle obj, destroy lyle obj, run lyle"};
	    Bytes bytes;
	    if(args[0].equals("v")){
		System.out.println("Reading from file: " +args[1]);
		v = true;
		out = new FileOutputStream(args[1] +".out");
		output = new FileOutputStream(new File("log"));
		bytes = new Bytes(args[1]);
		
	    }
	    else{
		v = false;
		out = new FileOutputStream(args[0]+".out");
		System.out.println("Reading from file: "+args[0]);
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


/* Need some sort of timer for bits/ms. */


	    }
	  
	 


	}


	


}
