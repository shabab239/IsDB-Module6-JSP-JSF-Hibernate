package bean;

import dao.EmployeeDAO;
import entity.Employee;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class EmployeeManageBean {

    private Employee employee = new Employee();

    public String saveEmployee() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        boolean result = employeeDAO.saveEmployee(employee);

        if (result) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee saved", ""));
            employee = new Employee();
            return "index.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee could not be saved", ""));
        }
        return null;
    }

    public String editEmployee(Long id) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employee = employeeDAO.getEmployeeById(id);

        if (employee != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee found", ""));
            return "edit_employee.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee not found", ""));
        }
        return null;
    }

    public String deleteEmployee(Long id) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        boolean result = employeeDAO.deleteEmployee(id);

        if (result) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee deleted", ""));
            return "index.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee could not be deleted", ""));
        }
        return null;
    }

    public List<Employee> employeeList() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employeeList = employeeDAO.getAllEmployees();
        return employeeList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
