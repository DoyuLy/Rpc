package org.doyo.dynamic.util;

import java.util.Date;

public class Logger {
	public static void logging(Level level, String context) { 
        if (level.equals(Level.INFO)) { 
            System.out.println(new Date().toLocaleString() + " " + context); 
        } 
        if (level.equals(Level.DEBUGE)) { 
            System.err.println(new Date().toLocaleString() + " " + context); 
        } 
    } 
}
