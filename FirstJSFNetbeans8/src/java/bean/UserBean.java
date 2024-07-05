import entity.User;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable{

    private User user = new User();
    private List<User> userList;
    private UserDAO userDAO;

    @PostConstruct
    public void init() {
        userDAO = new UserDAO();
        getUsers();
    }

    public List<User> getUsers() {
        userList = userDAO.getUsers();
        //System.out.println(userList.size() + "------------------------");
        //for (User user : userList) {
        //    System.out.println(user.getName());
        //}
        return userList;
    }

    public void create() {
        userDAO.createUser(user);
        user = new User(); //Reset
        getUsers(); //Refresh
    }

    public void delete(User user) {
        userDAO.deleteUser(user);
        user = new User(); //Reset
        getUsers(); //Refresh
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
