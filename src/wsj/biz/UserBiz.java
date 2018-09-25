package wsj.biz;
import java.util.List;
import wsj.bean.User; 
public interface UserBiz {
	public List<User> getAllUser(); 
    public User getUserById(int id);   
    public int addUser(User u);   
    public int updateUser(User u);   
    public int deleteUser(int id); 
    }
