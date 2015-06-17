import java.util.*;
import java.io.*;
public class Bytes{
	String fileName;
	Scanner scan;
	InputStream input;
	public Bytes(String fileName) throws Exception{
		this.fileName = fileName;
		scan = new Scanner(new File(fileName));
	}
	public byte[] getByte(){

		return scan.hasNextByte() == true ? scan.nextByte() :  null;
	}
}