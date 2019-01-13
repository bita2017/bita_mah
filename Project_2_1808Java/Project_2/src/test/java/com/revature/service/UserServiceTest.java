package com.revature.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.dao.UserDAO;
import com.revature.dao.VehicleDAO;
import com.revature.pojo.User;
import com.revature.pojo.Vehicle;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    
	
	@Mock
	UserDAO udao;
	
	@InjectMocks
	UserService userv;
	
	private static User u;
	
    private static List<User> userList;
    
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userList = new ArrayList<User>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.u = new  User(1, "john", "pass", false);
		this.userList.addAll(Arrays.asList(new User[] {this.u, new User()}));
		when(udao.getAllUsers()).thenReturn(this.userList);
		when(udao.getUser("john")).thenReturn(this.u);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllVehicle() {
		assertEquals("should get whole list of user", this.userList, this.userv.getAllUsers());
	
	}
	
	@Test
	public void testGetVehicle() {
		assertEquals("should get one  user", this.u, this.userv.getUser("john"));
	
	}

	@Test
	public void testMakeUser() {
		userv.newUser(this.u);
		verify(udao).newUser(u);
	
	}
	
	@Test
	public void testUpdateUser() {
		userv.updateUser(this.u);
		verify(udao).updateUser(u);
	
	}
	
	@Test
	public void testDeleteUser() {
		userv.deleteUser(u.getUsername());
		verify(udao).deleteUser("john");
	
	}

}
