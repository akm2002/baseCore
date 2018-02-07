package com.hellokoding.account.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author Oreo
 *
 */
public class UUIDUtilTest {

	@Test
    public void testGetUUID(){
        assertTrue(!UUIDUtil.getUUID().equals(""));
        assertTrue(UUIDUtil.getUUID().equals("-"));
    }
}