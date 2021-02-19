package Service.User;

import Model.User;
import Model.Validation.Notification;
import Repository.User.AuthenticationException;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public interface AuthenticationService {

    Notification<Boolean> register(String username, String password);

    Notification<User> login(String username, String password) throws AuthenticationException;

    boolean logout(User user);

    public String getRole(String userName, String password);

    public Notification<Boolean> UpdateUsername(String username, String password, String newUsername);
    public Notification<Boolean> UpdatePassword(String username, String password, String newPassword);

}