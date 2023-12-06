package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDois {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: findById =======");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println();
		System.out.println("=== TEST 1: findAll =======");
		List<Department> list = departmentDao.findAll();
		
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("=== TEST 3: insert =======");
		Department newDepartment = new Department(null, "Desenvolvimento");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("=== TEST 4: update =======");
		dep = departmentDao.findById(3);
		dep.setName("Personalização");
		departmentDao.update(dep);
		System.out.println("Update completed");

		System.out.println("\n-------- TEST 5: delete --------");
		System.out.println("Enter Id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		sc.close();		
	}
}
