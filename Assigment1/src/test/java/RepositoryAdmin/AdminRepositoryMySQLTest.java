package RepositoryAdmin;

import DataBase.DBConnectionFactory;
import Repository.Admin.AdminRepository;
import Repository.Admin.AdminRepositoryMySQL;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdminRepositoryMySQLTest {
    private static AdminRepository repository;

    @BeforeClass
    public static void setupClass() {
        repository = new AdminRepositoryMySQL(
                        new DBConnectionFactory().getConnectionWrapper(true).getConnection()
        );
    }

    @Before
    public void setUp() throws Exception {
        repository.saveEmployee("test1", (long) 1);
        repository.saveEmployee("test2", (long) 2);
        repository.saveEmployee("test3", (long) 3);
    }


    @Test
    public void modifyName() throws Exception {

        if(!repository.modifyName("TestBun", (long) 1).getResult()){
            assertTrue(false);
        }

        if(!repository.deleteEmployee((long) 1).getResult()) {
            assertTrue(false);
        }

        if(!(repository.findEmployeeId("test2").getResult()==2)){
            assertTrue(false);
        }

        if(repository.findAllEmployee().hasErrors()){
            assertTrue(false);
        }

    }
}
