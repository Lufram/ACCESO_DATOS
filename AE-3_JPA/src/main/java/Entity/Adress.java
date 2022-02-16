package Entity;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {

    private String roadType;
    private String roadName;
    private int num;
    private String city;

    public Adress() {
    }

    public Adress(String roadType, String roadName, int num, String city) {
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
}
