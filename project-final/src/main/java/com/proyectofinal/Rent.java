package com.proyectofinal;

import java.util.Date;
import java.util.List;

public class Rent
{
	private Customer customer;
	private Car car;
	private Date dateFrom;
	private Date dateTo;
	
	//GETTERS AND SETTERS
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	
	public Rent save() {
		return this;
	}
	
	public Rent update() {
		return this;
	}
	
	public List<Rent> search(Customer customer, Car car) {
		 return null;
	}
}
