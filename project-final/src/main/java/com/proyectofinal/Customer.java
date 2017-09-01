package com.proyectofinal;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class Customer 
{
	private int dni; //String?
	private String name;
	private Date birthday;
	private int phone;
	
	//GETTERS AND SETTERS -> ¿necesarios?
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	//CONSTRUCTORES
	//Por defecto
	public Customer()
	{
		
	}
	//Con parámetros
	public Customer(int dni, String name, Date birthday, int phone)
	{
		this.dni = dni;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
	}
	
	public Customer save()
	{
		return this;
	}
	
	public Customer load(int dni)
	{
		return this;		
	}
	
	public Customer update()
	{
		return this;
	}
	
	public List<Customer> search(DBClient client, String attribute,String value)
	{
		//ResultSet result = client.select("CUSTOMER",attribute, value);
		return null;
	}

}
