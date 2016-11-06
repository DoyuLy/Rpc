package org.doyo.dynamic;

import org.doyo.dynamic.operation.LoggerOperation;

public class Test {
	  public static void main(String[] args) { 
	        IHello hello = (IHello)new DynaProxyHello().bind(new Hello(),new LoggerOperation()); 
	        
	        hello.sayHello("duyu"); 
	        hello.sayGoogBye("duyu"); 
	        
	    } 
}
