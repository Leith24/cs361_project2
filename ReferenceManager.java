public class ReferenceManager{

    

    static Subject lyle;
    static Subject hal;
    static InstructionObject instr;
    static Subject subjectUsed;
    ObjectManager objectManager;
    String output;

    public ReferenceManager(Subject lyle, Subject hal){

    	this.lyle = lyle;
    	this.hal = hal;
    }
    
    public void initiateObjectManager(SecurityLevel security){
    
         objectManager = new ObjectManager();
            
    }
    
    public void execute(String bits){

   

        if(instr.type.equals(Type.READ)) { 
            subjectUsed.temp = objectManager.read();
            syncSubjects();
          //  output = subjectUsed.name + " reads " + objectUsed.name;
        } 

        else if (instr.type.equals(Type.CREATE)) {


        } 
        else if (instr.type.equals(Type.DESTROY)) {

            objectManager.destroy(instr.objectName);

        } 
        else if (instr.type.equals(Type.RUNS)){

            lyle.run_Lyle(bits);

        }
        else {
            objectManager.write(instr.val);
          //  output = subjectUsed.name + " writes value " + instr.val +
           // " to " + objectUsed.name; 
        }
       // System.out.println(output);


    }

    public void syncSubjects(){
        if (subjectUsed.name.equals(lyle.name)){
            lyle.temp = subjectUsed.temp;
        }
        else {
            hal.temp = subjectUsed.temp;
        }
    }


    public void setInstruction(InstructionObject instr){
    	this.instr=instr;

    }

    public boolean isValid(){
       

            /*check for domanince, set to zero if not*/
            setObjectSubject();

    		if( !isDominant() ){
                if(instr.type.equals(Type.READ)) { 
                    subjectUsed.temp = 0;

                  //  output = subjectUsed.name + " reads " + objectUsed.name;
                } else {
        
                   // output = subjectUsed.name + " writes value " + instr.val +
                   // " to " + objectUsed.name; 
                }
                syncSubjects();
                //System.out.println(output);
                return false;
            } 
            return true;

   
    }

    public boolean isDominant(){
        /* simple property */
    	return (instr.type.equals(Type.READ) && (objectUsed.security.equals(SecurityLevel.LOW) && 
    	(subjectUsed.security.equals(SecurityLevel.LOW) || subjectUsed.security.equals(SecurityLevel.HIGH)))) || 

        (instr.type.equals(Type.READ) && (objectUsed.security.equals(SecurityLevel.HIGH) &&
        (subjectUsed.security.equals(SecurityLevel.HIGH) ))) ||
    	  /* star property */
    	(instr.type.equals(Type.WRITE) && (subjectUsed.security.equals(SecurityLevel.LOW) &&
    	(objectUsed.security.equals(SecurityLevel.HIGH) || objectUsed.security.equals(SecurityLevel.LOW)))) ||

        (instr.type.equals(Type.WRITE) && (subjectUsed.security.equals(SecurityLevel.HIGH) &&
        (objectUsed.security.equals(SecurityLevel.HIGH) )));

    }
    
    public void setObjectSubject(){
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

    	return( instr.subjectName.equals(lyle.name) ||  instr.subjectName.equals(hal.name))  && 
    	  (object_exists(instr.objectName) > -1);
    }


	public class ObjectManager {

        /*lists of objects created*/
        Object[] objects;		
        Object objectUsed; //don't know if need this variable
        public ObjectManager(Object o){
            objects = new ArrayList<Object>();
        }

        public int read(){
            return object.value;
        }

        public void write(int val){
            object.value = val;

        }

        /*The semantics of CREATE is that a new object is added to 
        the state with SecurityLevel equal to the level of the 
        creating subject. It is given an initial value of 0. If 
        there already exists an object with that name at any level, 
        the operation is a no-op.*/
        public void create(SecurityLevel sec, String name){

            if (!object_exists(name))
                object.add(new Object(name, sec));
        }

        /*DESTROY will eliminate the designated object from the state,
         assuming that the object exists and the subject has 
         WRITE access to the object according to the *-property of 
         BLP. Otherwise, the operation is a no-op.*/
        public void destroy(String name){
            int index;
            if ((index = object_exists(name)) != -1){
                objects.remove(index);
            }
                

        }

        public int object_exists(String name){
            /*return true if the object of hte same name exists, else false*/
            for (int i = 0;i < objects.length; i++)
                if (name.toLowerCase().equals(objects.get(i).name().toLowerCase()))
                    return i;
            return -1;
        }

	}
}