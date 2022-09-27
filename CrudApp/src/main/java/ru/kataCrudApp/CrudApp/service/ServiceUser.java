package ru.kataCrudApp.CrudApp.service;



import ru.kataCrudApp.CrudApp.models.User;

import java.util.List;

public interface ServiceUser {
    public List<User> getAll();
    public User getUserbyId(int id);
    public void add(User user);
    public void edit(int id, User userUpdate);
    public void delete(int id);
}
