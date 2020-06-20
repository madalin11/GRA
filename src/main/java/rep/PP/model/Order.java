package rep.PP.model;

public class Order {
    private String nameCarord;

    private String color;
    private String wheels;
    private String interior;
    private String feedback;

    public Order(String nameCarord, String color, String wheels, String interior,String feedback) {
        this.nameCarord = nameCarord;
        this.feedback=feedback;
        this.color = color;
        this.wheels = wheels;
        this.interior = interior;
    }


    public String getNameCarord() {
        return nameCarord;
    }

    public void setNameCarord(String nameCarord) {
        this.nameCarord = nameCarord;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }
    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + nameCarord + '\'' +
                ", culoare='" + color + '\'' +
                ", jante='" + wheels + '\'' +
                ", interior='" + interior + '\'' +
                ", feedback='" + feedback + '\'' +

                '}';
    }
}
