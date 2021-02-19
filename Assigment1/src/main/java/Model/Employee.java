package Model;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class Employee {
    private  Long idUser;
    private String name;

    public Employee(Long idUser,String name) {
        this.idUser= idUser;
        this.name = name;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
