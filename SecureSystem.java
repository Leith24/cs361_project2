import java.util.*;
import java.util.Scanner;
import java.io.File;
public class SecureSystem{
     
   
	public static void main(String args[]) throws Exception {

		SecurityLevel low = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;

		Subject lyle = new Subject("Lyle", low);
		Subject hal = new Subject("Hal",high);

		Object lObj = new Object("LObj", low);
		Object hObj = new Object("HObj", high);


        ReferenceManager ref = new ReferenceManager(lyle, hal, lObj, hObj);
        Scanner scan = new Scanner(new File(args[0]));
        while (scan.hasNext()){


       		InstructionObject obj = new InstructionObject(scan.nextLine());
            
       		ref.setInstruction(obj); 

       		if(ref.isValid()){
       			//object monitro stuff
       		}
            


       }
	}


}