import java.io.Serializable;
import java.util.List;

public class StartupData implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Startup> startups;
    private List<Startup> winners;

    public StartupData(List<Startup> startups, List<Startup> winners) {
        this.startups = startups;
        this.winners = winners;
    }

    public List<Startup> getStartups() {
        return startups;
    }

    public List<Startup> getWinners() {
        return winners;
    }
}
