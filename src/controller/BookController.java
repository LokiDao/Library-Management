package controller;

import java.util.Vector;

import dto.Book;
import dto.Member;
import util.CONSTANTS;
import util.FileHandller;
import util.Validator;

public class BookController implements ProfileController {
	
	public static final String fileName = CONSTANTS.BOOK_FILE_NAME;
	
	@Override
	public Book get(String id) {
		Book m = new Book();
		if(!Validator.isSet(id)) return m;
		
		try {
			if(!FileHandller.openFileToRead(fileName)) return m;
			Vector<String> os = FileHandller.readMore();
			for(Object s : os) {
//				System.out.println(s.toString());
				m = new Book(s.toString());
				if(Validator.isSet(m.getId()) && m.getId().equals(id)) {
					FileHandller.closeFile();
					return m;
				}
			}
			FileHandller.closeFile();
			return new Book();
		} catch (Exception e) {
			e.printStackTrace();
			return new Book();
		}
	}

	@Override
	public Vector<Object> getMore(String key) {
		Vector<Object> ms = new Vector<Object>();
		try {
			if(!FileHandller.openFileToRead(fileName)) return ms;
			Vector<String> os = FileHandller.readMore();
			for(Object o : os) {
//				System.out.println(o.toString());
				Book m = new Book(o.toString());
				if(Validator.isSet(m.getId())) {
					if(Validator.isSet(key)) {
						if(m.getId().equals(key) || m.getName().equals(key) || m.getDoB().equals(key) || m.author.equals(key) || m.publisher.equals(key)) {
							ms.add(m);
						}
					} else ms.add(m);
				}
			}
			FileHandller.closeFile();
			return ms;
		} catch(Exception e) {
			e.printStackTrace();
			return ms;
		}
	}
	
	@Override
	public Vector<Vector<String>> getMultiple(String key) {
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			if(!FileHandller.openFileToRead(fileName)) return null;
			Vector<String> os = FileHandller.readMore();
			for(String o : os) {
//				System.out.println(o.toString());
				Book m = new Book(o.toString());
				if(Validator.isSet(m.getId())) {
					if(Validator.isSet(key)) {
						if(m.getId().equals(key) || m.getName().equals(key) || m.getDoB().equals(key) || m.author.equals(key) || m.publisher.equals(key)) {
							data.add(m.parse());
						} 
					} else data.add(m.parse());
				}
			}
			FileHandller.closeFile();
			return data;
		} catch(Exception e) {
			e.printStackTrace();
			return data;
		}
	}

	@Override
	public int add(Object o) {
		if(!Validator.isSet(o)) return 0; // "There is no data provided.";
		
		Book mem = (Book) o;
//		System.out.println(mem.toString());
		if(Validator.isSet(this.get(mem.getId()).getId())) return -1; // "Member " + mem.getId() + " is already existed.";
		else {
			try {
				FileHandller.openFileToAppend(fileName);
				boolean rs = FileHandller.wirte(o.toString());
				FileHandller.closeFile();
				return (rs) ? 1 /*"Member " + mem.getId() + " has been added."*/ : -2; //"Data source is still not opened yet.";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -3; //"An error occured.";
			}
		}
	}

	@Override
	public int update(Object o) {
		if(!Validator.isSet(o)) return 0; // "There is no data provided.";
		Book m = (Book) o;
		Vector<Object> data = this.getMore(null);
		for(Object item : data) {
			Book mem = new Book(item.toString());
			if(mem.getId().equals(m.getId())) {
				data.set(data.indexOf(item), m.toString());
				try {
					FileHandller.openFileToRewrite(fileName);
					boolean rs = FileHandller.wirteMore(data);
					FileHandller.closeFile();
					return (rs) ? 1 /*"Member " + m.getId() + " has been updated."*/ : -2; //"Data source is still not opened yet.";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return -3; //"An error occured.";
				}
			}
		}
		return -1; //"Member " + m.getId() + " does not existed.";
	}

	@Override
	public int delete(Object o) {
		if(!Validator.isSet(o)) return 0; // "There is no data provided.";
		Book m = (Book) o;
		Vector<Object> data = this.getMore(null);
		for(Object item : data) {
			Book mem = new Book(item.toString());
			if(mem.getId().equals(m.getId())) {
				data.set(data.indexOf(item), "");
				try {
					FileHandller.openFileToRewrite(fileName);
					boolean rs = FileHandller.wirteMore(data);
					FileHandller.closeFile();
					return (rs) ? 1 /*"Member " + m.getId() + " has been deleted."*/ : -2; //"Data source is still not opened yet.";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return -3; //"An error occured.";
				}
			}
		}
		return -1; //"Member " + m.getId() + " does not existed.";
	}

	@Override
	public int delete(String id) {
		if(!Validator.isSet(id)) return 0; // "There is no data provided.";
		Vector<Object> data = this.getMore(null);
		for(Object item : data) {
			Book mem = new Book(item.toString());
			if(mem.getId().equals(id)) {
				data.set(data.indexOf(item), "");
				try {
					FileHandller.openFileToRewrite(fileName);
					boolean rs = FileHandller.wirteMore(data);
					FileHandller.closeFile();
					return (rs) ? 1 /*"Member " + id + " has been deleted."*/ : -2; //"Data source is still not opened yet.";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return -3; //"An error occured.";
				}
			}
		}
		return -1; // "Member " + id + " does not existed.";
	}

}
