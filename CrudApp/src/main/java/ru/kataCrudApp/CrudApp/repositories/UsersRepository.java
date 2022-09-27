package ru.kataCrudApp.CrudApp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kataCrudApp.CrudApp.models.User;

@Repository
public interface UsersRepository extends JpaRepository <User,Integer> {
}
