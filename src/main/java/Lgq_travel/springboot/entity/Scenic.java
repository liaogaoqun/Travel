package Lgq_travel.springboot.entity;

import java.util.List;

public class Scenic {
    private Integer id;
    private String name;
    private String address;
    private String theme;
    private String message;
    private Integer pollution; //最大可容纳人数
    private Integer hot;   //热度
    private Integer state; //状态
    private String img; //图片
    private List<Ticket> tickets; //门票
    private double price; //门票价格

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Scenic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", theme='" + theme + '\'' +
                ", message='" + message + '\'' +
                ", pollution=" + pollution +
                ", hot=" + hot +
                ", state=" + state +
                ", img='" + img + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getPollution() {
        return pollution;
    }

    public void setPollution(Integer pollution) {
        this.pollution = pollution;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
