package com.hellokoding.account.utils;

import java.util.UUID;
/**
 * 
 * @author Oreo
 *
 */
public class UUIDUtil {

	UUIDUtil() {}
	
    public static String getUUID(){
         return UUID.randomUUID().toString().replace("-", "");
    }
}