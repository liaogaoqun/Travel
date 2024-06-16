package Lgq_travel.springboot.entity;

public class Ticket {
    private Integer id;
    private Integer sid; //旅游景点id
    private String name; //门票名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Double DPrice;  //成人票价
    private Double CPrice; //儿童票价
    private String message; //详情信息
    private Integer DPNum;   //成人票数量
    private Integer CPNum;  //儿童票数量
    private Scenic scenic;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", sid=" + sid +
                ", name='" + name + '\'' +
                ", DPrice=" + DPrice +
                ", CPrice=" + CPrice +
                ", message='" + message + '\'' +
                ", DPNum=" + DPNum +
                ", CPNum=" + CPNum +
                ", scenic=" + scenic +
                '}';
    }

    public Scenic getScenic() {
        return scenic;
    }


    public void setScenic(Scenic scenic) {
        this.scenic = scenic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Double getDPrice() {
        return DPrice;
    }

    public void setDPrice(Double DPrice) {
        this.DPrice = DPrice;
    }

    public Double getCPrice() {
        return CPrice;
    }

    public void setCPrice(Double CPrice) {
        this.CPrice = CPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getDPNum() {
        return DPNum;
    }

    public void setDPNum(Integer DPNum) {
        this.DPNum = DPNum;
    }

    public Integer getCPNum() {
        return CPNum;
    }

    public void setCPNum(Integer CPNum) {
        this.CPNum = CPNum;
    }
}
