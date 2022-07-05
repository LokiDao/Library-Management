package controller;

import java.util.Vector;

public interface ProfileController {
	public Object get(String id);
	public Vector<Object> getMore(String key);
	public int add(Object o);
	public int update(Object o);
	public int delete(Object o);
	public int delete(String id);
	public Vector<Vector<String>> getMultiple(String key);
}
