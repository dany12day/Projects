package Repository.Admin;

import Model.Employee;
import Repository.Cache;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public abstract class AdminRepositoryDecoration implements AdminRepository{
    protected AdminRepositoryMock decoratedRepository;
    private Cache<Employee> cache;
    public AdminRepositoryDecoration(AdminRepositoryMock adminRepositoryMock, Cache<Employee> cache) {
        this.decoratedRepository = adminRepositoryMock;
        this.cache = cache;
    }
}
