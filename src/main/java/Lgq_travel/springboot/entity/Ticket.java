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

    private Double cprice;  //市场价
    private Double dprice; //优惠价
    private String message; //详情信息
    private Integer dpNum;   //总票数
    private Integer cpNum;  //已售票数
    private Scenic scenic;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", sid=" + sid +
                ", name='" + name + '\'' +
                ", cprice=" + cprice +
                ", dprice=" + dprice +
                ", message='" + message + '\'' +
                ", dpNum=" + dpNum +
                ", cpNum=" + cpNum +
                ", scenic=" + scenic +
                '}';
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

    public Double getCprice() {
        return cprice;
    }

    public void setCprice(Double cprice) {
        this.cprice = cprice;
    }

    public Double getDprice() {
        return dprice;
    }

    public void setDprice(Double dprice) {
        this.dprice = dprice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getDpNum() {
        return dpNum;
    }

    public void setDpNum(Integer dpNum) {
        this.dpNum = dpNum;
    }

    public Integer getCpNum() {
        return cpNum;
    }

    public void setCpNum(Integer cpNum) {
        this.cpNum = cpNum;
    }

    public Scenic getScenic() {
        return scenic;
    }

    public void setScenic(Scenic scenic) {
        this.scenic = scenic;
    }
}
