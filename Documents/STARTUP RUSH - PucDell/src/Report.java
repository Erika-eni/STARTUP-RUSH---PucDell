import java.io.Serializable;

public class Report implements Serializable {
    private int amountPichs;
    private int amountBugs;
    private int amountTraction;
    private int amountAngryInvestor;
    private int amountFakeNews;
    private int amountPenalies;


    public int contpichs(){return amountPichs++;}
    public int contBugs(){return amountBugs++;}
    public int contTraction(){return amountTraction++;}
    public int contAngryInvestor(){return amountAngryInvestor++;}
    public int contFakeNews(){return amountFakeNews++;}
    public int contPenalies(){return amountPenalies++;}

    @Override
    public String toString() {
        return  "\n" +
                "Amount of piches: " + amountPichs + "\n" +
                "Amount of bugs: " + amountBugs + "\n" +
                "Amount of good traction: " + amountTraction + "\n" +
                "Amount of Angry Investor: " + amountAngryInvestor + "\n" +
                "Amount of fake news on pich: " + amountFakeNews + "\n" +
                "Amount of penalies: " + amountPenalies + "\n";
    }
}
