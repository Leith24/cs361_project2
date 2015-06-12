public class ReferenceManager{

    

    static Subject lyle;
    static Subject hal;
    static Object hobj;
    static Object lobj;
    static InstructionObject instr;
    static Object objectUsed;
    static Subject subjectUsed;
    String output;
    ObjectManager obman;

    public ReferenceManager(Subject lyle, Subject hal, Object lobj, Object hobj){

    	this.lyle = lyle;
    	this.hal = hal;
    	this.hobj = hobj;
    	this.lobj = lobj;
    	
    }
    
    public void initiateObjectManager(){
    
         obman = new ObjectManager(hobj, lobj, objectUsed);
            

    }
    
    public void execute(){

        obman.changeObjectUsed(objectUsed);

        if(instr.type.equals(Type.READ)) { 
            subjectUsed.temp = obman.read();
            syncSubjects();
            output = subjectUsed.name + " reads " + objectUsed.name;
        } else {
            obman.write(instr.val);
            output = subjectUsed.name + " writes value " + instr.val +
            " to " + objectUsed.name; 
        }
        System.out.println(output);


    }

    public void syncSubjects(){
        if (subjectUsed.name.equals(lyle.name)){
            lyle.temp = subjectUsed.temp;
        }
        else {
            hal.temp = subjectUsed.temp;
        }
    }

    public void output(){


    }

    public void setInstruction(InstructionObject instr){
    	this.instr=instr;

    }

    public boolean isValid(){
        if (instr.type.equals(Type.BAD)){
           
            return false;

        }

    	else if(!checkObjExist()){

    		return false;
    	}



    	else{
            /*check for domanince, set to zero if not*/
            getObjectSubject();

    		if( !isDominant() ){
                if(instr.type.equals(Type.READ)) { 
                    subjectUsed.temp = 0;

                    output = subjectUsed.name + " reads " + objectUsed.name;
                } else {
        
                    output = subjectUsed.name + " writes value " + instr.val +
                    " to " + objectUsed.name; 
                }
                syncSubjects();
                System.out.println(output);
                return false;
            } 
            return true;

        }
    }

    public boolean isDominant(){
        /*returns whether there is dominance*/
    	return (instr.type.equals(Type.READ) && (objectUsed.security.equals(SecurityLevel.LOW) && 
    	 (subjectUsed.security.equals(SecurityLevel.LOW) || subjectUsed.security.equals(SecurityLevel.HIGH)))) || 

         (instr.type.equals(Type.READ) && (objectUsed.security.equals(SecurityLevel.HIGH) &&
         (subjectUsed.security.equals(SecurityLevel.HIGH) ))) ||
    	  
    	  (instr.type.equals(Type.WRITE) && (subjectUsed.security.equals(SecurityLevel.LOW) &&
    	   (objectUsed.security.equals(SecurityLevel.HIGH) || objectUsed.security.equals(SecurityLevel.LOW)))) ||

          (instr.type.equals(Type.WRITE) && (subjectUsed.security.equals(SecurityLevel.HIGH) &&
           (objectUsed.security.equals(SecurityLevel.HIGH) )));

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

    	return( instr.subjectName.equals(lyle.name) ||  instr.subjectName.equals(hal.name)  && 
    	  (instr.objectName.equals(hobj.name) )|| instr.objectName.equals(lobj.name));
    }

	public class ObjectManager {

        Object lobj;
        Object hobj;
        Object object_used;
		

        public ObjectManager(Object h, Object l, Object used){
            lobj = l;
            hobj = h;
            object_used = used;
        }

        public int read(){
            return object_used.value;
        }

        public void write(int val){
            object_used.value = val;
            if (object_used.name.equals(lobj.name)){
                lobj.value = object_used.value;
            }
            else{
                hobj.value = object_used.value;
            }

        }

        public void changeObjectUsed(Object diff){
            object_used = diff;
        }
	}
}