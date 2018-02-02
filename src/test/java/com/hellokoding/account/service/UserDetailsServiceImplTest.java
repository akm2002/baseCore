package com.hellokoding.account.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImplTest{

	@Test
    public void testLoadUserByUsername() throws UsernameNotFoundException {
//    	String username = "admin";
    	UserDetailsService uds = new UserDetailsServiceImpl();
        assertTrue(uds!=null);

    }
}
