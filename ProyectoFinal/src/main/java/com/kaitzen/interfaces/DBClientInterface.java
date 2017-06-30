package com.kaitzen.interfaces;

public interface DBClientInterface {
	public boolean createDB();
	public boolean connect();
	public Object select(String[] args);
	public Object insert(String[] args);
	public Object update(String[] args);
}
