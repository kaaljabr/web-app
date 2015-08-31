package com.solid.codes.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	private static final Logger logger = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		CacheTable cacheTable = new CacheTable(50);
		cacheTable.put("Kareem", new Person("Kareem", 33));
		while (true) {
			try {
				Thread.sleep(200);
				if (cacheTable.get("Kareem") != null) {
					logger.debug("available {}", cacheTable.get("Kareem"));
				} else {
					logger.debug("NO FOUND");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static class Person {

		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Name: " + name + " Age: " + age;
		}

	}
}
