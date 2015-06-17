import java.util.*;
import java.io.*;
public class Bytes{
	String fileName;
	Scanner scan;
	public Bytes(String fileName) throws Exception{
		this.fileName = fileName;
		scan = new Scanner(new File(fileName));
	}
	public byte[] getByte(){

		return scan.hasNext() == true ? scan.nextLine().getBytes() :  null;
	}
}