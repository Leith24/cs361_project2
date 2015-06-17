public class InstructionObject{
	Type type;
	String subjectName; //typecast to object???
	String objectName;
	int val;
	
	public InstructionObject(String instr){
		/*parses the instruction line*/
		String [] tok = instr.split("[ ]+");


		if (tok[0].toLowerCase().equals("read")){
			
			type = Type.READ;
		    subjectName = tok[1].toLowerCase();
		    objectName = tok[2].toLowerCase();

		}
		else if(tok[0].toLowerCase().equals("create")){
			type = Type.CREATE;
		    subjectName = tok[1].toLowerCase();
		    objectName = tok[2].toLowerCase();

		}
		else if(tok[0].toLowerCase().equals("destroy")){
			type = Type.DESTROY;

			subjectName = tok[1].toLowerCase();
		    objectName = tok[2].toLowerCase();
		}
		else if(tok[0].toLowerCase().equals("run")){
			type = Type.RUN;
			subjectName = tok[1].toLowerCase();
		}
		else if (tok[0].toLowerCase().equals("write")){
			  

			   type = Type.WRITE;
			   subjectName = tok[1].toLowerCase();
			   objectName = tok[2].toLowerCase();
			   /*take this out later*/
			   try{
			   		val = Integer.parseInt(tok[3]);}
			   catch( NumberFormatException e) {
			   	    type = Type.BAD;
			   }
			   
		} 
		else if (tok[0].toLowerCase().equals("create") && tok.length == 3 && tok[1] instanceof String && tok[2] instanceof String){
			type = Type.CREATE;
			subjectName = tok[1].toLowerCase();
			objectName = tok[2];
		}
		else if (tok[0].toLowerCase().equals("destroy") && tok.length == 3 && tok[1] instanceof String && tok[2] instanceof String){
			type = Type.DESTROY;
			subjectName = tok[1].toLowerCase();
			objectName = tok[2];
		}
		else if (tok[0].toLowerCase().equals("run") && tok.length == 2 && tok[1] instanceof String){
			type = Type.RUN;
			subjectName = tok[1].toLowerCase();
		}
		else {

			type = Type.BAD;

	    }
	    
	}	
}
