public class Subject{
    	SecurityLevel security;
    	String name;
    	int temp = 0;
    	public Subject(String n, SecurityLevel sec){
    		security =  sec;
    		name = n.toLowerCase();
    	}
 }