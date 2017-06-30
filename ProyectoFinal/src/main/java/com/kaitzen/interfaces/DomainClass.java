package com.kaitzen.interfaces;

import java.util.List;

public interface DomainClass {
	public boolean save();
	public Object load(String id);
	public boolean update();
	public List<Object> search(String attribute, String value);
}
