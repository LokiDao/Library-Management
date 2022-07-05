package dto;

import java.util.Vector;

public interface ProfileInterface {
	public String getId();
	public String getName();
	public String getDoB();
	
	public void setId(String id);
	public void setName(String name);
	public void setDoB(String dob);
	public Vector<String> parse();
	
	@Override
	public String toString();
}
