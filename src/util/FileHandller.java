package util;

import java.io.*;
import java.util.Vector;

public class FileHandller {
	private static FileReader fr = null;
	private static FileWriter fw = null;
	private static BufferedReader br = null;
	private static BufferedWriter bw = null;
	private static PrintWriter out = null;
	
	public static boolean openFileToRead(String path) throws Exception {
		if(!Validator.isSet(path)) return false;
	
		fr = new FileReader(path);
	    br = new BufferedReader(fr);
	    return true;
	}
	
	public static boolean openFileToRewrite(String path) throws Exception {
		if(!Validator.isSet(path)) return false;
	
		fw = new FileWriter(path, false);
	    bw = new BufferedWriter(fw);
	    out = new PrintWriter(bw);
	    return true;
	}
	
	public static boolean openFileToAppend(String path) throws Exception {
		if(!Validator.isSet(path)) return false;
	
		fw = new FileWriter(path, true);
	    bw = new BufferedWriter(fw);
	    out = new PrintWriter(bw);
	    return true;
	}
	
	public static void closeFile() throws Exception {
		if(Validator.isSet(br)) {
			br.close();
			br  = null;
		}
		if(Validator.isSet(fr)) {
			fr.close();
			fr = null;
		}
		if(Validator.isSet(bw)) {
			bw.close();
			bw = null;
		}
		if(Validator.isSet(fw)) {
			fw.close();
			fw = null;
		}
		if(Validator.isSet(out)) {
			out.close();
			out = null;
		}
	}
	
	public static boolean wirte(String str)  throws Exception {
		if(!Validator.isSet(str) || !Validator.isSet(fw) || !Validator.isSet(bw) || !Validator.isSet(out)) return false;
		
	    bw.write(str);
	    bw.newLine();
	    bw.flush();
		return true;
	}
	
	public static boolean wirteMore(Vector<Object> os)  throws Exception {
		if(!Validator.isSet(os) || ! Validator.isSet(fw)) return false;
		
		for(Object o : os) {
			bw.write(o.toString());
		    bw.newLine();
		}
		bw.flush();
		return true;
	}
	
	public static String read()  throws Exception {
		if(!Validator.isSet(br)) return null;
		String str = br.readLine();
		return str;
	}
	
	public static Vector<String> readMore()  throws Exception {
		if(!Validator.isSet(br)) return null;

		Vector<String> str = new Vector<String>();
		String s = null;
		
		do
		{
			s = br.readLine();
			if(Validator.isSet(s)) str.add(s);
		} while (s != null);;
		return str;
	}
}
