package dto;

import java.util.Vector;

import util.CONSTANTS;
import util.FileHandller;
import util.Validator;

public class Member extends Profile {

	protected String gender;
	
	public Member() {

	}
	
	public Member(String str) {
		if(!Validator.isSet(str)) return;
		
		String[] p = str.split(",");
		
		if(!Validator.isSet(p)) return;
		
		this.setId(p[0]);
		this.setName(p[1]);
		this.setDoB(p[2]);
		this.setGender(p[3]);
	}
	
	public Member(String id, String name, String dob, String gender) {
		this.setId(id);
		this.setName(name);
		this.setDoB(dob);
		this.setGender(gender);
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void sets(String name, String dob, String gender) {
		this.setName(name);
		this.setDoB(dob);
		this.setGender(gender);
	}
	
	@Override
	public String toString() {
		return this.getId() + "," + this.getName() + "," + this.getDoB() + "," + this.gender;
	}
	
	@Override
	public Vector<String> parse() {
		Vector<String> col = new Vector<String>();
		col.add(this.getId());
		col.add(this.getName());
		col.add(this.getDoB());
		col.add(this.getGender());
		return col;
	}
}
