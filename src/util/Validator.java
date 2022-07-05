package util;

import java.lang.reflect.Array;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public static boolean isSet(Object o) {
		if(o == null) return false;
		
		try {
			String s = (String) o;
			if(s != null && !s.equals("")) return true;
			else return false;
		} catch(Exception e1) {
			try {
				if(Array.getLength(o) > 0) return true;
				else return false;
			} catch(Exception e2) {
				try {
					Vector<Object> l = (Vector<Object>) o;
					if(l != null && l.size() > 0) return true;
				else return false;
				} catch(Exception e3) {
					if(o != null) return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isMatch(String input, String regex)
    {
        if (!isSet(input) || !isSet(regex)) return false;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
	
	public static boolean isGender(String input)
    {
        if (!isSet(input) || input.equals("Female") || input.equals("Male") || input.equals("Others")) return true;
        return false;
    }

    public static boolean isNumber(String input)
    {
    	String regex = "(^[0-9]{1,}$)";
        return isMatch(input, regex);
    }

    public static boolean isDate(String input)
    {
    	String regex = "(^[0-9]{1,2})/([0-9]{1,2})/([0-9]{2,4}$)";
        return isMatch(input, regex);
    }

    public static boolean isPhoneNUmber(String input)
    {
    	boolean rs = false;
        String regex = "^[0-9]{10}$";
        rs = isMatch(input, regex);
        if (rs == true) return rs;

        regex = "^+[0-9]{2}\s[0-9]{2}\s[0-9]{8}$";
        rs = isMatch(input, regex);
        if (rs == true) return rs;

        regex = "^[0-9]{3}-[0-9]{4}-[0-9]{4}$";
        rs = isMatch(input, regex);
        if (rs == true) return rs;

        return rs;
    }

//    public static boolean isEmail(String input)
//    {
//        string regex = "\A(?:[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\.)+[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?)\Z";
//        return isMatch(input, regex);
//    }
}
