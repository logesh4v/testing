package com.ems.EMS.model;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
 
//@Configuration
@ComponentScan(basePackages = "com.ems.EMS")
@PropertySource("classpath:application.properties")
//public class EmsAppConfig
//{
// 
//	//Address Bean
//	@Bean
//	public Address address() {
//		Address address = new Address();
//		address.setStreet(null);
//		return address;
//	}
//	@Bean
//	public Department department() {
//		Department department = new Department();
//		department.setDepId(2);
//		department.setDeptName("Operations");
//		return department;
//	}
//	@Bean
//	public List<String> skills() {
//		return Arrays.asList("Java", "MySQL", "Spring Framerwork");
//	}
//	@Bean
//	public Employee employee() {
//		Employee employee = new Employee();
//		employee.setId(3);
//		employee.setAddress(address()); //inject address bean -> just pass the name address
//		employee.setDepartment(department());
//		employee.setSkills(skills());
//		employee.setSalary(55000);
//		return employee;
//	}
//	@Bean
//	public Payroll payroll() {
//		Payroll payroll = new Payroll();
//		payroll.setBaseSalary(66000);
//		return payroll;
//	}
//	@Bean
//	public Performance performance() {
//		Performance performance = new Performance();
//		performance.setEmployee(0);
//		performance.setRating(4.9);
//		return performance;
//	}
//	@Bean
//	public Map<Integer, Employee> empRecords() {
//		Map<Integer, Employee> records = new HashMap<>();
//		records.put(1, employee());
//		return records;
//	}
//	@Bean
//	public HR hr() {
//		HR hr = new HR();
//		hr.setEmployeeRecords(empRecords());
//		return hr;
//	}
//}
  



//address bean
//
//	@Value("${address.street}")
//	private String street;
//
//	@Value("${address.city}")
//	private String city;
//
//	@Value("${address.state}")
//	private String state;  // Updated this line
//
//	@Value("${address.zipcode}")
//	private String Zipcode;
//
//	@Bean
//	public Address address() {
//	    Address address = new Address();
//	    address.setStreet(street);
//	    address.setCity(city);
//	    address.setState(state);  // Updated this line
//	    address.setZipcode(Zipcode);
//	    return address;
//	}
//
////dep bean
//
//@Value("${department.id}")
//private int departmentId;
//
//@Value("${department.name}")
//private String departmentName;
//
//@Bean
//public Department department() {
//    Department department = new Department();
//    department.setDepId(departmentId);
//    department.setDeptName(departmentName);
//    return department;
//}
//
//
//@Value("${employee.id}")
//private int employeeId;
//
//@Value("${employee.name}")
//private String employeeName;
//
//@Value("${employee.email}")
//private String employeeEmail;
//
//@Value("${employee.phone}")
//private String employeePhone;
//
//@Value("${employee.salary}")
//private double employeeSalary;
//
//@Value("${employee.designation}")
//private String employeeDesignation;
//
//@Value("${employee.skills}")
//private String[] employeeSkills;
//
//@Bean
//public Employee employee() {
//    Employee employee = new Employee();
//    employee.setId(employeeId);
//    employee.setName(employeeName);
//    employee.setEmail(employeeEmail);
//    employee.setPhone(employeePhone);
//    employee.setSalary(employeeSalary);
//    employee.setDesignation(employeeDesignation);
//    employee.setSkills(Arrays.asList(employeeSkills));
//    employee.setAddress(address());
//    employee.setDepartment(department());
//    return employee;
//}
//
//@Bean
//public HR hr() {
//    HR hr = new HR();
//    hr.setEmployeeRecords(empRecords());
//    return hr;
//}
//
//@Bean
//public Map<Integer, Employee> empRecords() {
//    Map<Integer, Employee> records = new HashMap<>();
//    records.put(employeeId, employee());
//    return records;
//}
//
//@Value("${payroll.baseSalary}")
//private double baseSalary;
//
//@Value("${payroll.bonuses}")
//private double bonuses;
//
//@Value("${payroll.deductions}")
//private double deductions;
//
//@Bean
//public Payroll payroll() {
//    Payroll payroll = new Payroll();
//    payroll.setBaseSalary(baseSalary);
//    payroll.setBonuses(bonuses);
//    payroll.setDeductions(deductions);
//    return payroll;
//}
//
//
//
//
//
//}
	
	
	
	
	
	
	@Configuration
	@ComponentScan(basePackages = "com.ems.EMS")
	public class EmsAppConfig {

	    // Address Configuration
	    @Value("${address.street}")
	    private String street;

	    @Value("${address.city}")
	    private String city;

	    @Value("${address.state}")
	    private String state;

	    @Value("${address.zipcode}")
	    private String Zipcode;

	    @Bean
	    public Address address() {
	        Address address = new Address();
	        address.setStreet(street);
	        address.setCity(city);
	        address.setState(state);
	        address.setZipcode(Zipcode);
	        return address;
	    }

	    // Department Configuration
	    @Value("${department.id}")
	    private int departmentId;

	    @Value("${department.name}")
	    private String departmentName;

	    @Bean
	    public Department department() {
	        Department department = new Department();
	        department.setDepId(departmentId);
	        department.setDeptName(departmentName);
	        return department;
	    }

	    // Employee Configuration
	    @Value("${employee.id}")
	    private int employeeId;

	    @Value("${employee.name}")
	    private String employeeName;

	    @Value("${employee.email}")
	    private String employeeEmail;

	    @Value("${employee.phone}")
	    private String employeePhone;

	    @Value("${employee.salary}")
	    private double employeeSalary;

	    @Value("${employee.designation}")
	    private String employeeDesignation;

	    @Value("${employee.skills}")
	    private String[] employeeSkills;

	    @Bean
	    public Employee employee() {
	        Employee employee = new Employee();
	        employee.setId(employeeId);
	        employee.setName(employeeName);
	        employee.setEmail(employeeEmail);
	        employee.setPhone(employeePhone);
	        employee.setSalary(employeeSalary);
	        employee.setDesignation(employeeDesignation);
	        employee.setSkills(Arrays.asList(employeeSkills));
	        employee.setAddress(address());
	        employee.setDepartment(department());
	        return employee;
	    }

	    // HR Configuration
	    @Bean
	    public HR hr() {
	        HR hr = new HR();
	        hr.setEmployeeRecords(empRecords());
	        return hr;
	    }

	    @Bean
	    public Map<Integer, Employee> empRecords() {
	        Map<Integer, Employee> records = new HashMap<>();
	        records.put(employeeId, employee());
	        return records;
	    }

	    // Performance Configuration
	    @Value("${performance.employeeId}")
	    private int performanceEmployeeId;

	    @Value("${performance.rating}")
	    private double performanceRating;

	    @Value("${performance.feedback}")
	    private String performanceFeedback;

	    @Value("${performance.projectHandled}")
	    private String[] performanceProjectsHandled;

	    @Value("${performance.EligibleForpromotion}")
	    private boolean performanceEligibleForPromotion;

	    @Bean
	    public Performance performance() {
	        Performance performance = new Performance();
	        performance.setEmployee(performanceEmployeeId);
	        performance.setRating(performanceRating);
	        performance.setFeedback(performanceFeedback);
	        performance.setProjectsHandled(Arrays.asList(performanceProjectsHandled));
	        performance.setEligibleForpromotion(performanceEligibleForPromotion);
	        return performance;
	    }

	    // Payroll Configuration
	    @Value("${payroll.baseSalary}")
	    private double baseSalary;

	    @Value("${payroll.bonuses}")
	    private double bonuses;

	    @Value("${payroll.deductions}")
	    private double deductions;

	    @Bean
	    public Payroll payroll() {
	        Payroll payroll = new Payroll();
	        payroll.setBaseSalary(baseSalary);
	        payroll.setBonuses(bonuses);
	        payroll.setDeductions(deductions);
	        return payroll;
	    }
	}
