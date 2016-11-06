package org.doyo.dynamic;

public class Hello implements IHello {
	public void sayHello(String name) {
		System.out.println(name + " Hello!");
	}

	public void sayGoogBye(String name) {
		System.out.println(name + " GoodBye!");
	}
}
