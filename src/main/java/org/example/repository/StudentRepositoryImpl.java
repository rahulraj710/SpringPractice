package org.example.repository;

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private final SessionFactory sessionFactory;

    @Autowired
    public StudentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> getStudents(Optional<Integer> age) {
        Session session = sessionFactory.openSession();
        try {
            String queryString = "from Student";
            if(age.isPresent()){
                queryString += " where age = :age";
            }
            Query<Student> query = session.createQuery(queryString, Student.class);
            if(age.isPresent()){
                query.setParameter("age", age.get());
            }
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    @Override
    public Student getStudent(int id){
        Session session = sessionFactory.openSession();
        try {
            String queryString = "from Student where id = :id";
            Query<Student> query = session.createQuery(queryString, Student.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(student); // Save the student object to the database
            transaction.commit();  // Commit the transaction
        } catch (Exception e) {
            transaction.rollback(); // Rollback in case of an error
            throw e; // Rethrow the exception
        } finally {
            session.close();
        }
    }

    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(student); // Update the student object in the database
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            transaction.rollback(); // Rollback in case of an error
            throw e; // Rethrow the exception
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Student student = session.get(Student.class, id); // Get the student by ID
            if (student != null) {
                session.delete(student); // Delete the student if it exists
                transaction.commit(); // Commit the transaction
            }
        } catch (Exception e) {
            transaction.rollback(); // Rollback in case of an error
            throw e; // Rethrow the exception
        } finally {
            session.close();
        }
    }
}
