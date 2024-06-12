package Lgq_travel.springboot.entity;

public class Order {
    private int id;
    private int tid; //票id
    private int uid; //用户id
    private int num; //票数量
    private float price; //票价
    private String OrderNo; //订单编号
    private String TicketNo; //票编号
    private int state;  //票状态

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", tid=" + tid +
                ", uid=" + uid +
                ", num=" + num +
                ", price=" + price +
                ", OrderNo='" + OrderNo + '\'' +
                ", TicketNo='" + TicketNo + '\'' +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    public String getTicketNo() {
        return TicketNo;
    }

    public void setTicketNo(String ticketNo) {
        TicketNo = ticketNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
