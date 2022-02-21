package entity;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.util.Objects;

@Embeddable
public class Address {

    private String roadType;
    private String roadName;
    private int num;
    private String city;

    public Address() {
    }

    public Address(String roadType, String roadName, int num, String city) {
        this.roadType = roadType;
        this.roadName = roadName;
        this.num = num;
        this.city = city;
    }

    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address adress = (Address) o;
        return num == adress.num && Objects.equals(roadType, adress.roadType) && Objects.equals(roadName, adress.roadName) && Objects.equals(city, adress.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roadType, roadName, num, city);
    }

    @Override
    public String toString() {
        return "Adress{" +
                "roadType='" + roadType + '\'' +
                ", roadName='" + roadName + '\'' +
                ", num=" + num +
                ", city='" + city + '\'' +
                '}';
    }
}
