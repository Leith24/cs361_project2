
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
	    	
	        System.out.println(Arrays.toString(bits_array));
	        

	    }
	  
	 


	}

	public static String generate(){
	// 	Random random = new Random();
	// 	int value = random.nextInt(NUM_INSTRUCTIONS);
	// 	String instruction, subject, object;
	// 	Boolean number = false;
		
 //        /*generate instruction*/
	// 	if (value < 1){
	// 	    instruction = "READ ";
	// 	}
	// 	else if (value < 2 && value > 0){
	// 		instruction = "WRITE ";
	// 		number=true;
	// 	}
	// 	else if (value < 3 && value > 1){
	// 		instruction = "CREATE ";
	// 	}
	// 	else{
	// 		instruction = "DESTROY ";
	// 	}

	// 	/*generate subject*/
	// 	if (random.nextInt(NUM_SUBJECTS)<1)
	// 		subject = "lyle ";
	// 	else 
	// 		subject = "hal ";

	// 	/*generate object*/
	// 	if (random.nextInt(NUM_SUBJECTS)<1)
	// 		object = "hobj";
	// 	else 
	// 		object = "lobj";

	// 	return (number == false) ? instruction + subject + object : 
	// 		instruction + subject + object +" "+ random.nextInt(51);
		return "";
    }

	


}
