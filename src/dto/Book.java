package dto;

import java.util.Vector;

import util.CONSTANTS;
import util.FileHandller;
import util.Validator;

public class Book extends Profile {

	public String author;
	public String publisher;
	
	public Book() {

	}
	
	public Book(String str) {
		if(!Validator.isSet(str)) return;
		
		String[] p = str.split(",");
		
		if(!Validator.isSet(p)) return;
		
		this.setId(p[0]);
		this.setName(p[1]);
		this.setDoB(p[2]);
		this.author = p[3];
		this.publisher = p[4];
	}
	
	public Book(String id, String name, String dob, String author, String publisher) {
		this.setId(id);
		this.setName(name);
		this.setDoB(dob);
		this.author = author;
		this.publisher = publisher;
	}
	
	public void sets(String name, String dob, String author, String publisher) {
		this.setName(name);
		this.setDoB(dob);
		this.author = author;
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return this.getId() + "," + this.getName() + "," + this.getDoB() + "," + this.author + "," + this.publisher;
	}
	
	@Override
	public Vector<String> parse() {
		Vector<String> col = new Vector<String>();
		col.add(this.getId());
		col.add(this.getName());
		col.add(this.getDoB());
		col.add(this.author);
		col.add(this.publisher);
		return col;
	}
}
