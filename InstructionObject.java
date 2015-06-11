public class InstructionObject{
	Type type;
	String subjectName; //typecast to object???
	String objectName;
	int val;
	
	public InstructionObject(String instr){
		/*parses the instruction line*/
		String [] tok = instr.split("[ ]+");


		if (tok[0].toLowerCase().equals("read") && tok.length == 3 && tok[1] instanceof String &&
			   tok[2] instanceof String){
			
			type = Type.READ;
		    subjectName = tok[1];
		    objectName = tok[2];

		}
		else if (tok[0].toLowerCase().equals("write")&& tok.length == 4 && tok[1] instanceof String &&
			   tok[2] instanceof String){
			  

			   type = Type.WRITE;
			   subjectName = tok[1];
			   objectName = tok[2];
			   val = Integer.parseInt(tok[3]);
			   //System.out.println(val);
		} else {//return bad instruction object}

			type = Type.BAD;

	    }
	    //System.out.println(type.toString());
	}	
}