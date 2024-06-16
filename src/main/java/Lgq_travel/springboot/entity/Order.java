package Lgq_travel.springboot.entity;

public class Order {
    private Integer id;
    private Integer tid; //票id
    private Integer uid; //用户id
    private Integer num; //票数量
    private double price; //支付总额
    private String orderno; //订单编号
    private String ticketno; //取票码
    private Integer state;  //票状态
    private User user;
    private Ticket ticket;
    private Scenic scenic;

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", tid=" + tid +
                ", uid=" + uid +
                ", num=" + num +
                ", price=" + price +
                ", orderno='" + orderno + '\'' +
                ", ticketno='" + ticketno + '\'' +
                ", state=" + state +
                ", user=" + user +
                ", ticket=" + ticket +
                ", scenic=" + scenic +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}

