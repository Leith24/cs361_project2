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
        int count = 0;
        while (scan.hasNext()){
          

       		InstructionObject obj = new InstructionObject(scan.nextLine());
            
       		ref.setInstruction(obj); 
       		if(ref.isValid()){
             if (count++ == 0)
                ref.initiateObjectManager();
                ref.execute();
                output(true, ref);
            } else { output(false, ref);}
            
          

       }
	}

  public static void output(boolean valid, ReferenceManager reference){
    if (reference.instr.type.equals(Type.BAD)){
          System.out.println("BAD INSTRUCTION");
        }
      System.out.println("The current state is: ");
      System.out.println("   " + reference.lobj.name + " has value: " + reference.lobj.value);
      System.out.println("   " + reference.hobj.name + " has value: " + reference.hobj.value);
      System.out.println("   " + reference.lyle.name + " has recently read: " + reference.lyle.temp);
      System.out.println("   " + reference.hal.name + " has recently read: " + reference.hal.temp + "\n\n");
  }


}