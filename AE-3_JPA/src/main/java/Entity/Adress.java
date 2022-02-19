package Entity;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.util.Objects;

@Embeddable
public class Adress {

    private String roadType;
    private String roadName;
    private int num;
    private String city;

    @OneToOne
    Library library;

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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress)) return false;
        Adress adress = (Adress) o;
        return num == adress.num && Objects.equals(roadType, adress.roadType) && Objects.equals(roadName, adress.roadName) && Objects.equals(city, adress.city) && Objects.equals(library, adress.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roadType, roadName, num, city, library);
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
