package Repository.User;

import Model.User;
import Model.Validation.Notification;
import java.util.List;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public interface UserRepository {
    List<User> findAll();
    Notification<User> findByUsernameAndPassword(String username, String password) throws AuthenticationException;
    Notification<Boolean> saveUser(User user);
    Notification<Boolean> deleteUserRole(Long idUser);
    Notification<Boolean> deleteUser(Long idUser);
    void removeAll();
    Notification<Long> findUserId(String username, String password) throws AuthenticationException;
    public Notification<Boolean> modifyUsername(String username, Long idUser);
    public Notification<Boolean> modifyPassword(String password, Long idUser);

}