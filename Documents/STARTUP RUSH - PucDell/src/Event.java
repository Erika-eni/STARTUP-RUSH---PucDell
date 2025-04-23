import java.util.InputMismatchException;
import java.util.Scanner;

public class Event {
    public static void ApplyEvent(Startup currentStartup, Report report, int option){
        switch(option){
            case 1:
                currentStartup.addPoints(6);
                currentStartup.getReport().contpichs();
                break;
            case 2:
                currentStartup.removePoints(4);
                currentStartup.getReport().contBugs();
                currentStartup.getReport().contPenalies();
                break;
            case 3:
                currentStartup.addPoints(3);
                currentStartup.getReport().contTraction();
                break;
            case 4:
                currentStartup.removePoints(6);
                currentStartup.getReport().contAngryInvestor();
                currentStartup.getReport().contPenalies();
                break;
            case 5:
                currentStartup.removePoints(8);
                currentStartup.getReport().contFakeNews();
                currentStartup.getReport().contPenalies();
                break;
            default:
                System.out.println(" ⚠️ Invalid option!");
        }
    }
}
