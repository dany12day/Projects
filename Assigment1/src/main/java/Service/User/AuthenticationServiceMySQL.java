package Service.User;

import Model.Role;
import Model.User;
import Model.Builder.UserBuilder;
import Model.Validation.Notification;
import Service.UsefullFunctions.Validators.UserValidator;
import Repository.Security.RightsRolesRepository;
import Repository.Security.UserRoleRepository;
import Repository.User.AuthenticationException;
import Repository.User.UserRepository;
import Service.UsefullFunctions.EncodePassword;
import java.util.Collections;

import static DataBase.Constants.Roles.EMPLOYEE;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AuthenticationServiceMySQL implements AuthenticationService {

    private final UserRepository userRepository;
    private final RightsRolesRepository rightsRolesRepository;
    private final UserRoleRepository userRoleRepository;

    public AuthenticationServiceMySQL(UserRepository userRepository, RightsRolesRepository rightsRolesRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.rightsRolesRepository = rightsRolesRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Notification<Boolean> register(String username, String password) {
        Role customerRole = rightsRolesRepository.findRoleByTitle(EMPLOYEE);
        User user = new UserBuilder()
                .setUsername(username)
                .setPassword(password)
                .setRoles(Collections.singletonList(customerRole))
                .build();

        UserValidator userValidator = new UserValidator(user);
        boolean userValid = userValidator.validate();
        Notification<Boolean> userRegisterNotification = new Notification<>();

        if (!userValid) {
            userValidator.getErrors().forEach(userRegisterNotification::addError);
            userRegisterNotification.setResult(Boolean.FALSE);
        } else {
            user.setPassword(EncodePassword.encodePassword(password));
            userRegisterNotification.setResult(userRepository.saveUser(user).getResult());
        }
        return userRegisterNotification;
    }

    @Override
    public Notification<User> login(String username, String password) throws AuthenticationException {
        return userRepository.findByUsernameAndPassword(username, EncodePassword.encodePassword(password));
    }

    @Override
    public boolean logout(User user) {
        return false;
    }

    @Override
    public String getRole(String username, String password) {
        Notification<Long> idUser = null;
        try {
            idUser = userRepository.findUserId(username, EncodePassword.encodePassword(password));
        } catch (AuthenticationException e) {
            idUser.setResult((long) 0);
            idUser.addError("User dose not exists");
        }
        long roleid = userRoleRepository.findRoleId(idUser.getResult());
        return rightsRolesRepository.findRoleById(roleid).getRole();
    }

    @Override
    public Notification<Boolean> UpdateUsername(String username, String password, String newUsername) {
        User user = new UserBuilder()
                .setUsername(newUsername)
                .setPassword(password)
                .build();

        UserValidator userValidator = new UserValidator(user);
        boolean userValid = userValidator.validate();
        Notification<Boolean> userRegisterNotification = new Notification<>();

        if (!userValid) {
            userValidator.getErrors().forEach(userRegisterNotification::addError);
            userRegisterNotification.setResult(Boolean.FALSE);
        } else {
            Notification<Long> idUser = null;
            try {
                idUser = userRepository.findUserId(username, EncodePassword.encodePassword(password));
            } catch (AuthenticationException e) {

            }
            if(idUser.hasErrors()){
                idUser.setResult((long) 0);
                userRegisterNotification.addError("User dose not exists");
                userRegisterNotification.setResult(false);
                return userRegisterNotification;
            }
            if(idUser.getResult()!=0)
                userRegisterNotification=userRepository.modifyUsername(newUsername,idUser.getResult());
            else{
                userRegisterNotification.addError(idUser.getFormattedErrors());
                userRegisterNotification.setResult(false);
            }

        }
        return userRegisterNotification;

    }

    @Override
    public Notification<Boolean> UpdatePassword(String username, String password, String newPassword) {
        User user = new UserBuilder()
                .setUsername(username)
                .setPassword(newPassword)
                .build();

        UserValidator userValidator = new UserValidator(user);
        boolean userValid = userValidator.validate();
        Notification<Boolean> userRegisterNotification = new Notification<>();

        if (!userValid) {
            userValidator.getErrors().forEach(userRegisterNotification::addError);
            userRegisterNotification.setResult(Boolean.FALSE);
        } else {
            Notification<Long> idUser = null;
            try {
                idUser = userRepository.findUserId(username, EncodePassword.encodePassword(password));
            } catch (AuthenticationException e) {

            }
            if(idUser.hasErrors()){
                idUser.setResult((long) 0);
                userRegisterNotification.addError("User dose not exists");
                userRegisterNotification.setResult(false);
                return userRegisterNotification;
            }
            if(idUser.getResult()!=0)
                userRegisterNotification=userRepository.modifyPassword(EncodePassword.encodePassword(newPassword),idUser.getResult());
            else{
                userRegisterNotification.addError(idUser.getFormattedErrors());
                userRegisterNotification.setResult(false);
            }

        }
        return userRegisterNotification;
    }

}