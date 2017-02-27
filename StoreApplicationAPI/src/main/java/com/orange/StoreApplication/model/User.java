package com.orange.StoreApplication.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author asaied
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String password;
    private String mail;
    private String address;
    private String phone;

    public User() {
    }

    public User(String name, String password, String mail, String address, String phone) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.address = address;
        this.phone = phone;
    }

    public boolean isEmpty(User user){
        return user.getId()==0 && user.getName()== null && user.getPassword()== null && user.getMail()== null && user.getAddress()== null && user.getPhone()== null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", password=" + password + ", mail=" + mail + ", address=" + address + ", phone=" + phone + '}';
    }
    
    public static StringBuilder  ListUser(List<User> userList){
        StringBuilder sb = new StringBuilder();
        for (User user : userList) {
          sb.append(user.toString());
          sb.append("\n");
        }
        return sb;
    }
}
