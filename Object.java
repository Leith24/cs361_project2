public class Object{
	SecurityLevel security;
	String name;
	int value = 0;
	public Object(String n, SecurityLevel sec){
		security = sec;
		name = n.toLowerCase();
	}

}