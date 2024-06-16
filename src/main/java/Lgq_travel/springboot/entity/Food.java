package Lgq_travel.springboot.entity;

public class Food {
    private int id;
    private String foodname;
    private String address;
    private String message;  //详情信息
    private String img;   //图片

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", FoodName='" + foodname + '\'' +
                ", address='" + address + '\'' +
                ", message='" + message + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodName) {
        this.foodname = foodName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
