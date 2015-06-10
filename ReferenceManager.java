public class ReferenceManager{

    

    static Subject lyle;
    static Subject hal;
    static Object hobj;
    static Object lobj;
    static InstructionObject instr;
    static Object objectUsed;
    static Subject subjectUsed;

    public ReferenceManager(Subject lyle, Subject hal, Object hobj, Object lobj){

    	this.lyle = lyle;
    	this.hal = hal;
    	this.hobj = hobj;
    	this.lobj = lobj;
    	
    }

    public void setInstruction(InstructionObject instr){
    	this.instr=instr;
    }

    public boolean isValid(){

    	if(!checkObjExist()){
    		return false;
    	}

    	else if (instr.type.equals(Type.BAD)){
    		return false;
    	}
    	else
    		return isDominant();
    }

    public boolean isDominant(){
        /*returns whether there is dominance*/
    	return (instr.type.equals(Type.READ) && (objectUsed.security.equals(SecurityLevel.HIGH) &&
    	 (subjectUsed.security.equals(SecurityLevel.LOW) || subjectUsed.security.equals(SecurityLevel.HIGH)))) ||
    	  
    	  (instr.type.equals(Type.WRITE) && (subjectUsed.security.equals(SecurityLevel.LOW) &&
    	   (objectUsed.security.equals(SecurityLevel.HIGH) || objectUsed.security.equals(SecurityLevel.LOW))));

    }
    
    public void getObjectSubject(){
    	if (instr.subjectName.equals(lyle.name))
    		subjectUsed = lyle;
    	else 
    		subjectUsed = hal;

    	if (instr.objectName.equals(lobj.name))
    		objectUsed = lobj;
    	else 
    		objectUsed = hobj;
    }
    public boolean checkObjExist(){

    	return( instr.subjectName.equals(lyle.name) || instr.subjectName.equals(hal.name) ) && 
    	  (instr.objectName.equals(hobj.name) || instr.objectName.equals(lobj.name));
    }

	public class ObjectManager{
		


	}
}