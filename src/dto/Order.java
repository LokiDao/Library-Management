package dto;

import java.util.Vector;

import util.CONSTANTS;
import util.FileHandller;
import util.Validator;

public class Order extends Profile {

	public String memberId;
	public String bookIds;
	public String returnedDate;
	public String status;
	
	public Order() {

	}
	
	public Order(String str) {
		if(!Validator.isSet(str)) return;
		
		String[] p = str.split(",");
		
		if(!Validator.isSet(p)) return;
		
		this.setId(p[0]);
		this.setName(p[1]);
		this.setDoB(p[2]);
		this.memberId = p[3];
		this.bookIds = p[4];
		this.returnedDate = p[5];
		this.status = p[6];
	}
	
	public Order(String id, String name, String dob, String memberId, String bookIds, String returnedDate, String status) {
		this.setId(id);
		this.setName(name);
		this.setDoB(dob);
		this.memberId = memberId;
		this.bookIds = bookIds;
		this.returnedDate = returnedDate;
		this.status = status;
	}
	
	public void sets(String name, String dob, String memberId, String bookIds, String returnedDate, String status) {
		this.setName(name);
		this.setDoB(dob);
		this.memberId = memberId;
		this.bookIds = bookIds;
		this.returnedDate = returnedDate;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return this.getId() + "," + this.getName() + "," + this.getDoB() + "," + this.memberId + "," + this.bookIds + "," + this.returnedDate + "," + this.status;
	}
	
	@Override
	public Vector<String> parse() {
		Vector<String> col = new Vector<String>();
		col.add(this.getId());
		col.add(this.getName());
		col.add(this.getDoB());
		col.add(this.memberId);
		col.add(this.bookIds);
		col.add(returnedDate);
		col.add(returnedDate);
		col.add(status);
		return col;
	}
}
