package br.com.api.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.api.model.Permission;

import br.com.api.model.User;

import java.util.List;



@Service
public class DbInit implements CommandLineRunner {
    
	private UserRepository userRepository;
	@Autowired
	private PermissionRepository permissionRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.setUserRepository(userRepository);
        this.setPasswordEncoder(passwordEncoder);
    }

    @Override
    public void run(String... args) {
        // Delete all users
    	// Used only to tests
        this.userRepository.deleteAll();
        this.permissionRepository.deleteAll();

        // Create users
        // Used only to tests   	
    	
    	Permission permissionUser = new Permission("USER");
    	Permission permissionAdmin = new Permission("ADMIN");
    	Permission permissionManager = new Permission("MANAGER");
    	
    	this.permissionRepository.saveAll(Arrays.asList(permissionUser, permissionAdmin, permissionManager));
    	
    	User user = new User("user",passwordEncoder.encode("user123"),"USER", Arrays.asList(permissionUser));
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN", Arrays.asList(permissionAdmin));
        User manager = new User("manager",passwordEncoder.encode("manager123"), "MANAGER", Arrays.asList(permissionManager));

        List<User> users = Arrays.asList(user,admin,manager);

        this.userRepository.saveAll(users);
        
    }

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
}
