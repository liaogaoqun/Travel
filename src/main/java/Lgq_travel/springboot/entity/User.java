package Lgq_travel.springboot.entity;

import java.util.Date;

public class User {
    private Integer userid;
    private String name; //昵称

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Email='" + email + '\'' +
                ", Sex='" + sex + '\'' +
                ", Birthday=" + birthday +
                ", state=" + state +
                ", TePhone='" + tephone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String username;
    private String password;
    private String email;
    private String sex;
    private Date birthday;
    private int state;
    private String tephone;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String gettephone() {
        return tephone;
    }

    public void settephone(String tePhone) {
        this.tephone = tePhone;
    }

}
