package ru.kataCrudApp.CrudApp.service;

//import Crud.dao.UserDAOImpl;
//import Crud.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kataCrudApp.CrudApp.models.User;
import ru.kataCrudApp.CrudApp.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ServiceUserImpl implements ServiceUser {
    private final UsersRepository usersRepository;

    @Autowired
    public ServiceUserImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }




//    public ServiceUserImpl() {
//    }

    @Override
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public User getUserbyId(int id) {
        Optional <User> foundUser = usersRepository.findById(id);
        return foundUser.orElse(null);
    }
    @Transactional
    @Override
    public void add(User user) {
    usersRepository.save(user);
    }
    @Transactional
    @Override
    public void edit(int id, User userUpdate) {
    userUpdate.setId(id);
    usersRepository.save(userUpdate);
    }
    @Transactional
    @Override
    public void delete(int id) {
    usersRepository.deleteById(id);
    }
}
