package com.proyectofinal;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class DBClient 
{	
	private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    private static final String CREATE_CUSTOMER_QUERY = "CREATE TABLE CUSTOMER(dni varchar(255) primary key, name varchar(255), birthday Date, phone varchar(255))";
    public static final String INSERT_CUSTOMER_QUERY = "INSERT INTO CUSTOMER (name, dni, birthday, phone) values (????)";
    private static final String CREATE_CAR_QUERY = "CREATE TABLE CAR(domain varchar(255) primary key, doors varchar(255), color varchar(255), fuel varchar(255), kilometers varchar(255), baggagespace float, passengerspace int)";
    public static final String INSERT_CAR_QUERY = "INSERT INTO CAR (domain, doors, color, fuel, kilometers, baggagespace, passengersspace) values (???????)";
    private static final String CREATE_RENT_QUERY = "CREATE TABLE RENT(id int primary key AUTO_INCREMENT, dni varchar(255), domain varchar(255), datefrom date, dateto date)";
    public static final String INSERT_RENT_QUERY = "INSERT INTO RENT (customer, car, datefrom, dateto) values (????)";
    public static final String SELECT_NAME_QUERY = "select * from CUSTOMER where name = ?";
    public static final String SELECT_ID_QUERY = "select * from CUSTOMER where id = ?";
    public static final String SELECT_ALL_QUERY = "select * from CUSTOMER";

    Connection dbConnection = null;

    public void init() {
    	if (dbConnection == null) {
    		connect();
    		generateDB();
    	}
    }

    public int insert(String name) throws SQLException {
    	init();
        PreparedStatement insertPreparedStatement = dbConnection.prepareStatement(INSERT_CUSTOMER_QUERY); //VER CUAL VA
        insertPreparedStatement.setString(1, name);
        insertPreparedStatement.executeUpdate();
        ResultSet rs = insertPreparedStatement.getGeneratedKeys();
        Integer userId = null;
        if (rs.first()) {
            userId = rs.getInt(1);
        }
        insertPreparedStatement.close();
        return userId;
    }

    public List select(int id) throws SQLException {
    	init();
    	PreparedStatement selectPreparedStatement = dbConnection.prepareStatement(SELECT_ID_QUERY);
        selectPreparedStatement.setInt(1,id);
        return select(selectPreparedStatement);
    }

    public List select(String name) throws SQLException{
    	init();
    	PreparedStatement selectPreparedStatement = dbConnection.prepareStatement(SELECT_NAME_QUERY);
        selectPreparedStatement.setString(1,name);
        return select(selectPreparedStatement);
    }

    private List select(PreparedStatement selectPreparedStatement) throws SQLException{
        //Person result = null;
        ResultSet rs = selectPreparedStatement.executeQuery();
        if (rs.first()) {
            //System.out.println("Id " + rs.getInt("id") + " Name " + rs.getString("name"));
            //result = new Person(rs.getInt("id"), rs.getString("name"));
        }
        selectPreparedStatement.close();
        return null;
    }

    public List select() throws SQLException{
    	init();
    	List<Object> crowd = new ArrayList<Object>();
        PreparedStatement selectPreparedStatement = dbConnection.prepareStatement(SELECT_ALL_QUERY);
        ResultSet rs = selectPreparedStatement.executeQuery();
        while (rs.next()) {
            //System.out.println("Id " + rs.getInt("id") + " Name " + rs.getString("name"));
            //crowd.add(new Person(rs.getInt("id"), rs.getString("name")));
        }
        selectPreparedStatement.close();
        return crowd;
    }

    //CONNECT
    private void connect() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void generateDB() {
        try {
            dbConnection.setAutoCommit(false);
            PreparedStatement createPreparedStatement = dbConnection.prepareStatement(CREATE_CUSTOMER_QUERY);
            createPreparedStatement.executeUpdate();
            createPreparedStatement.close();
            createPreparedStatement = dbConnection.prepareStatement(CREATE_CAR_QUERY);
            createPreparedStatement.executeUpdate();
            createPreparedStatement.close();
            createPreparedStatement = dbConnection.prepareStatement(CREATE_RENT_QUERY);
            createPreparedStatement.executeUpdate();
            createPreparedStatement.close();
        } catch(SQLException sqlEx) {
            System.out.println("ERROR: " + sqlEx.getMessage());
        }
    }
	
	
	public void createDB() 
	{
			
	}
	/*
	public void connect() 
	{
			
	}
	
	public List select() 
	{
		return null;
	}
	
	public boolean insert(String insertQuery) 
	{
		try{
			PreparedStatement InsertPreparedStatement client
		}
		return false;
	}
	*/
	public void update() 
	{
			
	}
}

