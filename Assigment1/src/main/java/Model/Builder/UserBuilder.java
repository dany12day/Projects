package Model.Builder;

import Model.Role;
import Model.User;
import java.util.List;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class UserBuilder {
    private User user;

    public UserBuilder() {
        user = new User();
    }

    public UserBuilder setUsername(String username) {
        user.setUsername(username);
        return this;
    }

    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder setRoles(List<Role> roles) {
        user.setRoles(roles);
        return this;
    }

    public User build() {
        return user;
    }
}
