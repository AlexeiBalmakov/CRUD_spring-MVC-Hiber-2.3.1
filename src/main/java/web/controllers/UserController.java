package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.UserDAO.UserDAO;
import web.UserDAO.UserDAOImpl;
import web.userconfig.User;


@Controller
public class UserController {

    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("users", userDAO.getAllUsers());
        return "index";
    }
    @GetMapping("/addNewUser")
    public String addUser(Model model) {
        model.addAttribute("users", new User());
        return "addNewUser";
    }

    @PostMapping("/addNewUser")
    public String addUser(@ModelAttribute User user) {
        userDAO.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/")
    public String deleteUser(@RequestParam("id") int id) {
        userDAO.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("users", userDAO.getUser(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String deleteUser(@ModelAttribute User user) {
        userDAO.updateUser(user);
        return "redirect:/";
    }

}
