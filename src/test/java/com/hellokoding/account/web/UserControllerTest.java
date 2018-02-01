package com.hellokoding.account.web;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.support.BindingAwareModelMap;

import com.hellokoding.account.model.User;

public class UserControllerTest {

	public UserController cont;
	
	public Model model;

	@Ignore
    @Test
    public void testRegistration() {
    	cont = new UserController();
    	User user = new User();
    	BindingResult br = new BeanPropertyBindingResult("testTag", "objName");
    	model = new BindingAwareModelMap();
    	String result = cont.registration(user, br, model);
    	assertTrue(!result.equals(""));
    }

    @Test
    public void testLogin() {
    	String error = null;
    	String logout = null;
    	model = new BindingAwareModelMap();
    	cont = new UserController();
    	cont.login(model, error, logout);
    	assertTrue(model!=null);
    }

    @Test
    public void testWelcome() {
    	cont = new UserController();
    	model = new BindingAwareModelMap();
    	assertTrue(cont.welcome(model).equals("welcome"));
    }
}
