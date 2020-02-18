package com.example.spring.repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.entity.Address_;
import com.example.spring.entity.Student;
import com.example.spring.entity.Student_;

@Repository
@Transactional(readOnly = true)
public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {

	@Resource
	private EntityManager entityManager;

	@Override
	public Student getdata(final Long addressId) {

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Student> createQuery = criteriaBuilder.createQuery(Student.class);
		final Root<Student> root = createQuery.from(Student.class);

		final Predicate equal = criteriaBuilder.equal(root.get(Student_.ADDRESS).get(Address_.ADDR_ID), addressId);

		createQuery.where(equal);
		createQuery.select(root);

		try {
			return entityManager.createQuery(createQuery).getSingleResult();
		} catch (final NoResultException e) {
			return null;
		}
	}

}
