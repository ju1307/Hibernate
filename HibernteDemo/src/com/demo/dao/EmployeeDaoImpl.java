package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.entity.Employee;
import com.demo.utils.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public Employee getEmployeeById(final int id) {
		Transaction transaction = null;
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			// start a transaction
			transaction = session.beginTransaction();
			// get Employee entity using get() method
			employee = session.get(Employee.class, id);
			// commit transaction
			transaction.commit();
		} catch (final Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		Transaction transaction = null;
		List<Employee> employees = null;
		try (final Session session = HibernateUtil.getSessionFactory().openSession();) {
			// start a transaction
			transaction = session.beginTransaction();
			// get All employees
			employees = session.createQuery("from Employee").list();
			// commit transaction
			transaction.commit();
		} catch (final Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void addEmployee(final Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the Employee object
			session.save(employee);
			// commit transaction
			transaction.commit();
		} catch (final Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(final Employee employee) {
		Transaction transaction = null;
		try (final Session session = HibernateUtil.getSessionFactory().openSession();) {
			// start a transaction
			transaction = session.beginTransaction();
			// update the Employee object
			session.update(employee);
			// commit transaction
			transaction.commit();
		} catch (final Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployeeById(final int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			// start a transaction
			transaction = session.beginTransaction();
			// delete the Employee object
			final Employee employee = getEmployeeById(id);
			session.delete(employee);
			// commit transaction
			transaction.commit();
		} catch (final Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
