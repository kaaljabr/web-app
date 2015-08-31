package com.solid.codes.cache;

public class TimeWrapper {
	private long age;
	private Object object;

	public TimeWrapper(Object object) {
		this.object = object;
		updateAge();
	}

	private void updateAge() {
		age = System.currentTimeMillis();
	}

	public long getAge() {
		return (System.currentTimeMillis() - age);
	}

	public Object getObject() {
		updateAge();
		return (object);
	}
}
