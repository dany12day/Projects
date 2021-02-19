package Model;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class Right {
    private Long id;
    private String right;

    public Right(Long id, String right) {
        this.id = id;
        this.right = right;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
