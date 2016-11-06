package org.doyo.dynamic.operation;

import java.lang.reflect.Method;

import org.doyo.dynamic.util.Level;
import org.doyo.dynamic.util.Logger;

public class LoggerOperation implements IOperation {
	public void end(Method method) { 
        Logger.logging(Level.DEBUGE, method.getName() + " Method end ."); 
    } 

    public void start(Method method) { 
        Logger.logging(Level.INFO, method.getName() + " Method Start!"); 
    } 
}
