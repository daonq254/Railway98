package com.vti.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Department;

public class DepartmentRepository {
//	
	private SessionFactory sessionFactory;

	public DepartmentRepository() {
		super();
		sessionFactory = buildSessionFactory();
	}

	// Hàm tạo SessionFactory
	private SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Department.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

//	Hàm lấy danh sách phòng ban
	public List<Department> getListDepartments() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query<Department> query = session.createQuery("FROM Department");
			List<Department> listDepartments = query.list();
			return listDepartments;
		} finally {
			session.close();
		}

	}

//	Hàm tìm kiếm phòng ban theo id
	public Department getDepartmentByID(short id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Department department = session.get(Department.class, id);
			return department;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	Hàm tìm kiếm phòng ban theo tên
	public Department getDepartmentByName(String name) {
		Session session = null;
		try {
			// get session
			session = sessionFactory.openSession();

//
//			HQL
//			FROM Department WHERE name = :nameParameter
			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Department department = query.uniqueResult();
			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	Hàm thêm mới Department

	public void createDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = sessionFactory.openSession();
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
