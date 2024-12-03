package com.socialPeople.webredsocial.user;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user") // Ruta base del controlador
public class UserController {
    private UserService userService;
    // Maneja las solicitudes POST a /entrada/enviar

    public UserController(UserService userService){
          this.userService = userService;
    }

    @GetMapping("/get")
    @ResponseBody  
    public ArrayList<User> getUsers() {
        // Procesa el mensaje recibido y lo devuelve
        ArrayList<User> user = this.userService.getAllusers();
        return user;
    }
    /*
 @GetMapping("/info")
    @ResponseBody
    public String informacion() {
        // Procesa el mensaje recibido y lo devuelve
        return "Mensaje 2 recibido: ";
    }
*/

}
