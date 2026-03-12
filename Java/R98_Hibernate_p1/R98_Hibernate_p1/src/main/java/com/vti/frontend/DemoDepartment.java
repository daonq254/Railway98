package com.vti.frontend;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Department;

public class DemoDepartment {
	public static void main(String[] args) {
// Hiển thị danh sách phòng ban
		Session session = null;
		try {
			session = buildSessionFactory().openSession();
//
			session.beginTransaction();
			String queryHQL = "FROM Department";
			Query<Department> query = session.createQuery(queryHQL);

			List<Department> listDepartments = query.list();
			for (Department department : listDepartments) {
				System.out.println(department.getId() + "       " + department.getName());
			}

//			Thêm phòng ban mới 
//			Tạo ra đối tượng Department(id, name)
			Department department = new Department();
			department.setName("Test");

			session.save(department);
			session.getTransaction().commit();

		} finally {
			session.close();
		}

	}

// Hàm tạo SessionFactory
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
//		
		configuration.addAnnotatedClass(Department.class);
//		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

}
