package com.kaitzen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DBClientTests {
	private Connection mockedConnection;
	private PreparedStatement mockedPreparedStatement;
	private ResultSet result;
	
	@Before
	public void setup() {
		mockedConnection = mock(Connection.class);
		mockedPreparedStatement = mock(PreparedStatement.class);
		result = mock(ResultSet.class);
	}
	
	@Test
	public void shouldInsertName() throws SQLException {
		DBClient dbClient = new DBClient();
		when(result.first()).thenReturn(true);
		when(result.getInt(1)).thenReturn(12);
		when(mockedPreparedStatement.getGeneratedKeys()).thenReturn(result);
		when(mockedConnection.prepareStatement(DBClient.INSERT_QUERY)).thenReturn(mockedPreparedStatement);
		dbClient.dbConnection = mockedConnection;
		Integer id = dbClient.insert("Fede");
		assertTrue(12 == id);
		verify(mockedPreparedStatement).setString(eq(1), eq("Fede"));
		verify(mockedConnection).prepareStatement(eq(DBClient.INSERT_QUERY));
		verify(result).getInt(eq(1));
	}
	
	@Test
	public void shouldSelectAll() throws SQLException {
		DBClient dbClient = new DBClient();
		when(result.next()).thenReturn(true,false);
		when(result.getInt("id")).thenReturn(12);
		when(result.getString("name")).thenReturn("Fede");
		when(mockedPreparedStatement.executeQuery()).thenReturn(result);
		doNothing().when(mockedPreparedStatement).close();
		when(mockedConnection.prepareStatement(DBClient.SELECT_ALL_QUERY)).thenReturn(mockedPreparedStatement);
		dbClient.dbConnection = mockedConnection;
		List<Person> results = dbClient.select();
		assertTrue(results.size() == 1);
		Person fede = results.get(0);
		assertTrue(12 == fede.getId());
		assertEquals("Fede", fede.getName());
		verify(result,times(1)).getInt(eq("id"));
		verify(mockedConnection, times(1)).prepareStatement(eq(DBClient.SELECT_ALL_QUERY));
	}
	
	@Test
	public void shouldSelectByName() throws SQLException {
		DBClient dbClient = new DBClient();
		when(result.first()).thenReturn(true);
		when(result.getInt("id")).thenReturn(16);
		when(result.getString("name")).thenReturn("Nico");
		doNothing().when(mockedPreparedStatement).setString(eq(1), eq("Nico"));
		when(mockedPreparedStatement.executeQuery()).thenReturn(result);
		when(mockedConnection.prepareStatement(DBClient.SELECT_NAME_QUERY)).thenReturn(mockedPreparedStatement);
		dbClient.dbConnection = mockedConnection;
		Person nico = dbClient.select("Nico");
		assertTrue(16 == nico.getId());
		assertEquals("Nico", nico.getName());
		verify(result,times(1)).getInt(eq("id"));
		verify(result,times(1)).getString(eq("name"));
		verify(mockedPreparedStatement).setString(eq(1), eq("Nico"));
		verify(mockedConnection).prepareStatement(eq(DBClient.SELECT_NAME_QUERY));
	}
	
	@Test
	public void shouldSelectById() throws SQLException {
		DBClient dbClient = new DBClient();
		dbClient.select(null);
	}
}
