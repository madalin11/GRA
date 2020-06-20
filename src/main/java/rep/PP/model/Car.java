package rep.PP.model;

public class Car {
    private String jante;
    private String culoare;
    private String interior;
    private String pret;
    private String nameCar;
    public Car(String jante, String culoare , String interior , String pret,String nameCar){
        this.culoare=culoare;
        this.jante=jante;
        this.interior=interior;
        this.pret=pret;
        this.nameCar=nameCar;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String getJante() {
        return jante;
    }

    public void setJante(String jante) {
        this.jante = jante;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }
    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + nameCar + '\'' +
                ", culoare='" + culoare + '\'' +
                ", jante='" + jante + '\'' +
                ", interior='" + interior + '\'' +
                ", pret='" + pret + '\'' +
                '}';
    }

}