package com.proyectofinal;

import java.util.List;

public class Car 
{
	private String domain;
	private String doors;
	private String color;
	private String fuel;
	private String kilometers;
	private Double baggageSpace;
	private int passengersSpace;
	
	//GETTERS AND SETTERS
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getDoors() {
		return doors;
	}
	public void setDoors(String doors) {
		this.doors = doors;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getKilometers() {
		return kilometers;
	}
	public void setKilometers(String kilometers) {
		this.kilometers = kilometers;
	}
	public Double getBaggageSpace() {
		return baggageSpace;
	}
	public void setBaggageSpace(Double baggageSpace) {
		this.baggageSpace = baggageSpace;
	}
	public int getPassengersSpace() {
		return passengersSpace;
	}
	public void setPassengersSpace(int passengersSpace) {
		this.passengersSpace = passengersSpace;
	}
	
	
	
	
	//CONSTRUCTORES
	//Por defecto
	public Car()
	{
		
	}
	//Con parámetros
	public Car(String domain, String doors, String color, String fuel, String kilometers, Double baggageSpace, int passengersSpace)
	{
		this.domain = domain;
		this.doors = doors;
		this.color = color;
		this.fuel = fuel;
		this.kilometers = kilometers;
		this.baggageSpace = baggageSpace;
		this.passengersSpace = passengersSpace;
	}
	
	public Car save() {
		return this;
	}
	
	public Car load(String domain) {
		return this;
	}
	
	public Car update() {
		return this;
	}
	
	public List<Car> search(String attribute, String value) {
		 return null;
	 }
}
