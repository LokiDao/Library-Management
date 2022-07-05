package controller;

import java.util.Vector;

import dto.Book;
import dto.Member;
import dto.Order;
import util.CONSTANTS;
import util.FileHandller;
import util.Validator;

public class OrderController implements ProfileController {
	
	public static final String fileName = CONSTANTS.ORDER_FILE_NAME;
	
	@Override
	public Order get(String id) {
		Order m = new Order();
		if(!Validator.isSet(id)) return m;
		
		try {
			if(!FileHandller.openFileToRead(fileName)) return m;
			Vector<String> os = FileHandller.readMore();
			for(Object s : os) {
//				System.out.println(s.toString());
				m = new Order(s.toString());
				if(Validator.isSet(m.getId()) && m.getId().equals(id)) {
					FileHandller.closeFile();
					return m;
				}
			}
			FileHandller.closeFile();
			return m;
		} catch (Exception e) {
			e.printStackTrace();
			return m;
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
				Order m = new Order(o.toString());
				if(Validator.isSet(m.getId())) {
					if(Validator.isSet(key)) {
						if(m.getId().equals(key) || m.getName().equals(key) || m.getDoB().equals(key) || m.memberId.equals(key) || m.bookIds.equals(key)) {
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
			if(!FileHandller.openFileToRead(fileName)) return data;
			Vector<String> os = FileHandller.readMore();
			for(String o : os) {
//				System.out.println(o.toString());
				Order m = new Order(o.toString());
				if(Validator.isSet(m.getId())) {
					if(Validator.isSet(key)) {
						if(m.getId().equals(key) || m.getName().equals(key) || m.getDoB().equals(key) || m.memberId.equals(key) || m.bookIds.equals(key)) {
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
		
		Order mem = (Order) o;
//		System.out.println(mem.toString());
		if(Validator.isSet(this.get(mem.getId()))) return -1; // "Member " + mem.getId() + " is already existed.";
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
		Order m = (Order) o;
		Vector<Object> data = this.getMore(null);
		for(Object item : data) {
			Order mem = new Order(item.toString());
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
		Order m = (Order) o;
		Vector<Object> data = this.getMore(null);
		for(Object item : data) {
			Order mem = new Order(item.toString());
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
			Order mem = new Order(item.toString());
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
