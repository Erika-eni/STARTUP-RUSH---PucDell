import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Battle {

    public static void start(Event event, List<Startup> startups) {
        Scanner scanner = new Scanner(System.in);
        List<Startup> allStartups = new ArrayList<>(startups);

        while (startups.size() > 1) {
            System.out.println();
            System.out.println(" ------ ▶️ Starting round...");
            List<List<Startup>> pairs = Tournament.drawDoubles(startups);
            List<Startup> winners = new ArrayList<>();

            List<Integer> penddingBattle = new ArrayList<>();
            for (int i = 0; i < pairs.size(); i++) {
                penddingBattle.add(i);
            }

            while (!penddingBattle.isEmpty()) {
                System.out.println();
                System.out.println(" -- 🏁 Available battles:");
                for (int i : penddingBattle) {
                    List<Startup> dupla = pairs.get(i);
                    System.out.println((i + 1) + " -> " + dupla.get(0).getName() + " vs " + dupla.get(1).getName());
                }

                System.out.print("Choose the battle number you want to manage: ");
                int choose = -1;
                try {
                    choose = Integer.parseInt(scanner.nextLine()) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please try again..");
                    continue;
                }

                if (!penddingBattle.contains(choose)) {
                    System.out.println("Invalid number or battle already administered. Please try again..");
                    continue;
                }

                List<Startup> chosenPair = pairs.get(choose);
                Startup startup1 = chosenPair.get(0);
                Startup startup2 = chosenPair.get(1);

                Round.rounds(startup1, startup2, event);

                if (startup1.getPoints() > startup2.getPoints()) {
                    winners.add(startup1);
                } else {
                    winners.add(startup2);
                }

                penddingBattle.remove(Integer.valueOf(choose));
            }

            startups = winners;
        }

        System.out.println();
        System.out.println("🎉 Champion Startup: " + startups.get(0).getName() + " with " + startups.get(0).getPoints() + " points!");
        System.out.println("  -->" + startups.get(0).getSlogan() );
        allStartups.sort(Comparator.comparingInt(Startup::getPoints).reversed());
        System.out.println("\n--------- RANKING ---------");
        for (Startup startup : allStartups) {
            System.out.println("--> " + startup.getName() + " = " + startup.getPoints() + " points");
            System.out.println(startup.getReport());
            System.out.println("--------------------------------------");
        }
        SaveRush.save("startup_rush_save.dat", allStartups, startups);
    }
}
