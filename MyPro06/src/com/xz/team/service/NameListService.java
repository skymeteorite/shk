package com.xz.team.service;

import com.xz.team.domain.Architect;
import com.xz.team.domain.Designer;
import com.xz.team.domain.Employee;
import com.xz.team.domain.Equipment;
import com.xz.team.domain.NoteBook;
import com.xz.team.domain.PC;
import com.xz.team.domain.Printer;
import com.xz.team.domain.Programmer;

import static com.xz.team.service.Data.*;

/**
 * 
 * @Description 负责将Data中的数据封装在Employee[]数组，同时提供相关操作Employee[]的方法
 * @author Agiz  Email:1229836201@qq.com
 * @version v1.0
 * @date 2020年5月4日下午6:05:16
 */
public class NameListService {
	private Employee[] employees;

	//给数组及数组元素初始化
	public NameListService() {
		employees = new Employee[EMPLOYEES.length];
		
		for(int i = 0; i < employees.length; i++) {
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			//获取Employee的4个信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;
			
			switch (type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}
	//获取指定索引上员工的设备
	private Equipment createEquipment(int index) {
		int key = Integer.parseInt(EQUIPMENTS[index][0]);
		String modelOrName = EQUIPMENTS[index][1];
		switch (key) {
		case PC://21
			String display = EQUIPMENTS[index][2];
			return new PC(modelOrName, display);
		case NOTEBOOK://22
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(modelOrName, price);
		case PRITNER://23
			String type = EQUIPMENTS[index][2];
			return new Printer(modelOrName, type);
		}
		return null;
	}
	
	public Employee[] getAllEmployees() {
		return employees;
	}
	public Employee getEmployee(int id) throws TeamException {
		for(int i = 0; i < employees.length; i++) {
			if(employees[i].getId() == id)
				return employees[i];
		}
		throw new TeamException("找不到指定的员工");
	}
}
