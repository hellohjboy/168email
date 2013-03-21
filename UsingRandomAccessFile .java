package cn.richinfo.IO;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {

  static String file = "C:\\Documents and Settings\\Administrator\\桌面\\hello.txt";
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		RandomAccessFile rf = new RandomAccessFile(file,"rw");
		for(int i = 0; i < 7; i++) {
			rf.writeDouble(i * 1.414);
			
		}
		rf.writeUTF("The end of the file");
		rf.close();
		display();
		rf = new RandomAccessFile(file,"rw");
		rf.seek(5*8);
		rf.writeDouble(121.121);
		rf.close();
		display();
		
				
	}
	
	static void display() throws IOException {
		RandomAccessFile rf = new RandomAccessFile(file,"r");
		for(int i = 0; i < 7;i++) {
			System.out.println(
					"value" + i + ":" + rf.readDouble());
		}
		System.out.println(rf.readUTF());
		rf.close();
	}

}
