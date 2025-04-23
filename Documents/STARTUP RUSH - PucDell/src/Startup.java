
import java.io.Serializable;
import java.util.UUID;
public class Startup implements Serializable {
    private UUID id;
    private String name;
    private String slogan;
    private int yearFoundation;
    private int points = 70;
    private Report report;


    public int getPoints() {
        return points;
    }
    public String getName() {
        return name;
    }
    public Report getReport() {
        return report;
    }
    public String getSlogan() {
        return slogan;
    }

    public Startup(String name, String slogan, int yearFoundation) {
        this.name = name;
        this.slogan = slogan;
        this.yearFoundation = yearFoundation;
        this.id = UUID.randomUUID();
        this.report = new Report();
    }


    public int addPoints(int amount){return points += amount;}
    public int removePoints(int amount){return points -= amount;}
}
