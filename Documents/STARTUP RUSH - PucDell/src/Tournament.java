import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
    public static void start(List<Startup> startups, Event event){
        System.out.println();
        System.out.println(" ------ ▶\uFE0F Starting tournament....");
        Battle.start(event, startups);
    }



    public static List<List<Startup>> drawDoubles(List<Startup> startups) {
        Collections.shuffle(startups);
        List<List<Startup>> pairs = new ArrayList<>();

        for (int i = 0; i < startups.size(); i += 2) {
            List<Startup> pair = new ArrayList<>();
            pair.add(startups.get(i));
            pair.add(startups.get(i + 1));
            pairs.add(pair);
        }

        return pairs;
    }


}
