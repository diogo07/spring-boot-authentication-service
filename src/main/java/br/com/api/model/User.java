package br.com.api.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private int active;

    private String roles = "";
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		  name = "user_permission", 
    		  joinColumns = @JoinColumn(name = "user_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions;

    public User(String username, String password, String roles, List<Permission> permissions){
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.active = 1;
    }

    protected User(){}

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<Permission> getPermissionList(){
        return this.permissions;
    }
}
