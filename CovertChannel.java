import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class CovertChannel{
	public static final int NUM_INSTRUCTIONS = 4;
	public static final int NUM_SUBJECTS = 2;
	
	public static void main(String args[]){

		Scanner scan = new Scanner(new File(args[0]));
		generate();


	}

	public static String generate(){
		Random random = new Random();
		int value = random.nextInt(NUM_INSTRUCTIONS);
		String instruction, subject, object;
		Boolean number = false;
		
        /*generate instruction*/
		if (value < 1){
		    instruction = "READ ";
		}
		else if (value < 2 && value > 0){
			instruction = "WRITE ";
			number=true;
		}
		else if (value < 3 && value > 1){
			instruction = "CREATE ";
		}
		else{
			instruction = "DESTROY ";
		}

		/*generate subject*/
		if (random.nextInt(NUM_SUBJECTS)<1)
			subject = "lyle ";
		else 
			subject = "hal ";

		/*generate object*/
		if (random.nextInt(NUM_SUBJECTS)<1)
			object = "hobj";
		else 
			object = "lobj";

		return (number == false) ? instruction + subject + object : 
			instruction + subject + object +" "+ random.nextInt(51);
		
	}


}