package Repository.Security;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public interface UserRoleRepository {
    public void addUserRole(long idUser, long idRole);
    public Long findRoleId(long idUser);

}
