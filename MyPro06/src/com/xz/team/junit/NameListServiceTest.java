package com.xz.team.junit;

import org.junit.Test;

import com.xz.team.domain.Employee;
import com.xz.team.service.NameListService;

/**
 * 
 * @Description 对NameListService测试
 * @author Agiz  Email:1229836201@qq.com
 * @version
 * @date 2020年5月5日下午3:02:13
 */
public class NameListServiceTest {
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id = 10;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
