package com.info.SpringTestDI2.entity;

public class Customer {
		private int id;
		private String name;
		private int age;
		private Nominee nominee;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public Nominee getNominee() {
			return nominee;
		}
		public void setNominee(Nominee nominee) {
			this.nominee = nominee;
		}
		
		
}
