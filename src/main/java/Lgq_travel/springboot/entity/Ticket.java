package Lgq_travel.springboot.entity;

public class Ticket {
    private int id;
    private int sid; //旅游景点id
    private float DPrice;  //成人票价
    private float CPrice; //儿童票价
    private String message; //详情信息
    private int DPNum;   //成人票数量
    private int CPNum;  //儿童票数量

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", sid=" + sid +
                ", DPrice=" + DPrice +
                ", CPrice=" + CPrice +
                ", message='" + message + '\'' +
                ", DPNum=" + DPNum +
                ", CPNum=" + CPNum +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public float getDPrice() {
        return DPrice;
    }

    public void setDPrice(float DPrice) {
        this.DPrice = DPrice;
    }

    public float getCPrice() {
        return CPrice;
    }

    public void setCPrice(float CPrice) {
        this.CPrice = CPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDPNum() {
        return DPNum;
    }

    public void setDPNum(int DPNum) {
        this.DPNum = DPNum;
    }

    public int getCPNum() {
        return CPNum;
    }

    public void setCPNum(int CPNum) {
        this.CPNum = CPNum;
    }
}
