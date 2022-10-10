package com.owner.resource;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.owner.model.User;
import com.owner.service.UserService;

@RestController
@CrossOrigin(origins ="http://localhost:4200" )
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/adduser")
	public void addUser(@RequestBody User user)
	{
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	
	@RequestMapping(method=RequestMethod.PUT, value="/updateuser/{userId}")
	public void updateUser(@RequestBody User user, @PathVariable Long userId )
	{
		userService.updateUser(userId,user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteuser/{userId}")
	public void deleteUser( @PathVariable Long userId )
	{
		userService.deleteUser(userId);
	}
	
}
