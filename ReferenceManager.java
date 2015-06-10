public class ReferenceManager{

    public enum SecurityLevel{HIGH,LOW};

    Subject lyle;
    Subject hal;
    Object hobj;
    Object lobj;
    InstructionObject instr;
    Object objectUsed;
    Subject subjectUsed;

    public ReferenceManager(Subject lyle, Subject hal, Object hobj, Object lobj){

    	this.lyle = lyle;
    	this.hal = hal;
    	this.hobj = hobj;
    	this.lobj = lobj;
    	
    }

    public setInstruction(InstructionObject instr){
    	this.instr=instr;
    }

    public boolean isValid(){

    	if(!checkObjExist()){
    		false;
    	}

    	else if (instr.type.equals(type.BAD)){
    		return false;
    	}
    	else
    		return isDominant();
    }

    public boolean isDominant(){
        /*returns whether there is dominance*/
    	return (instr.type.equals(Type.READ) && objectUsed.security <= subjectUsed.security) ||
    	  (istr.type.equals(Type.WRITE) && subjectUsed.security <= objectUsed.security );

    }
    
    public boolean getObjectSubject(){
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