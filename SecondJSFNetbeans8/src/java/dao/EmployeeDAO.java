package dao;

import entity.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EmployeeDAO {

    public boolean saveEmployee(Employee employee) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }
    
    public Employee getEmployeeById(Long id) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, id);
            transaction.commit();

            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }
    
    public boolean updateEmployee(Employee employee) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }

    public boolean deleteEmployee(Long id) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, id);
            session.delete(employee);
            transaction.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }

    public List<Employee> getAllEmployees() {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        List<Employee> employeeList = session.createQuery("from Employee").list();
        //List<Employee> employeeList = session.createCriteria(Employee.class, "from Employee").list();
        
        return employeeList;
    }

}
