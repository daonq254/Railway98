package com.vti.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository {
	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

// Hàm lấy danh sách phòng ban
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccount() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
//			Query<Account> query = session.createQuery("FROM Account order by id");
//			Criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Account> query = builder.createQuery(Account.class);
			Root<Account> root = query.from(Account.class); // From Account

			query.select(root);// select * From Account

			List<Account> listAccount = session.createQuery(query).list();
//			
			return listAccount;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

// Hàm tìm kiếm Account theo id
	public Account getAccountByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
//			Account account = session.get(Account.class, id);
//			String hqlString = "FROM Account AS a WHERE a.id = :idParam";
//			Query<Account> query = session.createQuery(hqlString, Account.class);
//			query.setParameter("idParam", id);
//			Tìm theo Account theo ID: Select * from account where AccountID = ?
//			Criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Account> query = builder.createQuery(Account.class);
			Root<Account> root = query.from(Account.class); // From Account
			query.select(root); // select * From Account
			query.where(builder.equal(root.get("id"), id)); // select * From Account where AccountID = id
			Account account = session.createQuery(query).uniqueResult();

//			Account account = query.uniqueResult();
			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	Tim Fullname của Account theo id
	public String getFullnameById(short id) {

		Session session = null;

		try {
			session = hibernateUtils.openSession();

//			String hqlString = "SELECT fullname FROM Account WHERE id = = :idParam";
//			Query<String> query = session.createQuery(hqlString, String.class);
//			query.setParameter("idParam", id);
//
//			String fullname = query.uniqueResult();
			NativeQuery query = session.createNativeQuery("SELECT FullName FROM account WHERE AccountID = ?;");
			query.setParameter(1, id);

			Object result = query.getSingleResult();
			String fullname = result.toString();

			return fullname;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	
}
