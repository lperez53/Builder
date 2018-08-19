package ingsw.pdd.builder.dto;

import java.util.ArrayList;
import java.util.List;
import ingsw.pdd.builder.IBuilder;

public class Employee {
	
	private String name;
		private int age;
		private String gender;
		private Address adress;
		private List<Phone> phones;
		private List<Contact> contacs;
		
		private Employee(String name, int age, String gender, Address adress, List<Phone> phones, List<Contact> contacs) {
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.adress = adress;
			this.phones = phones;
			this.contacs = contacs;
		}
		
		public Employee(String name, int age, String gender){
			this.name = name;
			this.age = age;
			this.gender = gender;			
		}
		
		public Employee() {			
		}
		
		/** GET and SET */
		
		public static class EmployeeBuilder implements IBuilder<Employee>{
			private String name;
			private int age;
			private String gender;
			private Address adress;
			private final List<Phone> phones = new ArrayList<>();
			private final List<Contact> contacs = new ArrayList<>();
			
			public  EmployeeBuilder() {				
			}
			
			public EmployeeBuilder setName(String name) {
				this.name = name;
				return this;			
			}
			
			public EmployeeBuilder setAge(int age) {
				this.age = age;
				return this;				
			}
			
			public EmployeeBuilder setGender(String gender) {
				this.gender = gender;
				return this;
			}
			
			public EmployeeBuilder setAdress(String address, String city,String country, String cp) {
				adress = new Address(address, city, country, cp);
				return this;
			}
			
			public EmployeeBuilder addPhones(String phoneNumber, String ext, String phoneType) {
				phones.add(new Phone (phoneNumber, ext, phoneType));
				return this;
			}
			
			public EmployeeBuilder addContacs(String name, String phoneNumber, String ext, String phoneType,
					String address, String city, String country, String cp) {
				contacs.add(new Contact(name, new Phone(phoneNumber, ext, phoneType)
						,new Address(address, city, country, cp)));
				
				return this;
			}
			
			public EmployeeBuilder addContacs(String name, String phoneNumber,String ext, String phoneType) {
				contacs.add(new Contact(name, new Phone(phoneNumber, ext, phoneType)));
				return this;
			}
			
			@Override
			
			public Employee build() {
				return new Employee(name, age, gender, adress, phones, contacs);
			}

		}	

}
