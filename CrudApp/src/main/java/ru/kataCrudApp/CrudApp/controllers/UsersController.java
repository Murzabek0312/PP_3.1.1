package ru.kataCrudApp.CrudApp.controllers;

//import Crud.dao.UserDAOImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kataCrudApp.CrudApp.models.User;
import ru.kataCrudApp.CrudApp.service.ServiceUser;

@Controller
@RequestMapping("/users")
public class UsersController {

    ServiceUser serviceUser;

    @Autowired
    public UsersController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", serviceUser.getAll());
        return "users/getAll";
    }

    @GetMapping("/{id}")
    public String getUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", serviceUser.getUserbyId(id));
        return "users/getUser";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        serviceUser.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", serviceUser.getUserbyId(id));
        return "users/edit";

    }
    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        serviceUser.edit(id, user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        serviceUser.delete(id);
        return "redirect:/users";
    }


}
