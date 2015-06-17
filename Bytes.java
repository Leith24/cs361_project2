import java.util.*;
import java.io.*;
public class Bytes{
	String fileName;
	Scanner scan;

	public static final int END_OF_LINE = 10;
	public Bytes(String fileName) throws Exception{
		this.fileName = fileName;
		scan = new Scanner(new File(fileName));
	}
	/*method that reads in nextLine of file and coverts it into array of bits*/
	public String[] getBitsFromLine(){

		return scan.hasNextLine() == true ? convert_to_binary(scan.nextLine().getBytes()) : 
		    null;

	}

	/*method that converts array of bytes to array of corresonding bits
	  plus the ENDOFLINE at the end. */
	public String[] convert_to_binary(byte[] temp){

		/*make returned array one length longer for end of line*/
		String[] result = new String[temp.length + 1];
		
		
		/*interate through temp and convert ascii to String of binary*/
		for (int i = 0; i < temp.length; i++)
			   result[i] = Integer.toBinaryString(temp[i]);
		
		

		/*convert end of line ascii to binary and return string array*/
		result[result.length - 1] = Integer.toBinaryString(END_OF_LINE);
		

		return result;

	}
	


}