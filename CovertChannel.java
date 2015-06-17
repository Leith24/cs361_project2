
import java.io.*;
import java.util.*;
import java.lang.Number;

public class CovertChannel{
	public static final int NUM_INSTRUCTIONS = 4;
	public static final int NUM_SUBJECTS = 2;
	
	public static void main(String args[]) throws Exception{

		/*creating new file stream with argument*/
		/*Bytes bytes = new Bytes(args[0]);
		byte[] array;
		while ((array = bytes.getByte()) != null) 
			System.out.println(array.toString());*/
	    Bytes bytes = new Bytes("test");
	    byte[] b;
	   // Integer inter = new Integer();
	    while((b=bytes.getByte()) != null) {
	    	System.out.println(Arrays.toString(b));
	        for(int j = 0; j<b.length; j++){
		    	int i = b[j];
		    	System.out.println(Integer.toBinaryString(i));
	        }
	        System.out.println(Integer.toBinaryString(255));

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
		
	// }

	


}
