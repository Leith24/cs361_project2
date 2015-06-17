import java.util.*;   
import java.util.Scanner;
import java.io.File;
public class SecureSystem{
     
   
	public static void main(String args[]) throws Exception {

		SecurityLevel low = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;

		Subject lyle = new Subject("Lyle", low);
		Subject hal = new Subject("Hal",high);

    Object lobj = new Object("lObj", low);
    Object hobj = new Object("hobj", high);

        ReferenceManager ref = new ReferenceManager(lyle, hal, lobj, hobj);
        Scanner scan = new Scanner(new File(args[0]));
        int count = 0;
        while (scan.hasNext(b)){
          

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
          System.out.println("Bad Instruction");
        }
      System.out.println("The current state is: ");
      System.out.println("   LObj has value: " + reference.lobj.value);
      System.out.println("   HObj has value: " + reference.hobj.value);
      System.out.println("   Lyle has recently read: " + reference.lyle.temp);
      System.out.println("   Hal has recently read: " + reference.hal.temp + "\n");
  }


}