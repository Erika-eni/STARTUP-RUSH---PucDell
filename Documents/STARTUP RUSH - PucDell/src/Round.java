import java.util.*;

public class Round {
    public static void rounds(Startup startup1, Startup startup2, Event event){
        Scanner scanner = new Scanner(System.in);
        Report reports = new Report();
        int count = 1;
        int option;

        Set<Integer> usedEvents = new HashSet<>();
        do{
            System.out.println();
            System.out.println( "--------- " + startup1.getName() + " VS " + startup2.getName() + " ---------");
            System.out.println("--------- Round " + count + " ---------");
            System.out.println();
            System.out.println( "    Startup " + startup1.getName() + " = " + startup1.getPoints() + " points");
            System.out.println( "    Startup " + startup2.getName() + " = " + startup2.getPoints() + " points");
            System.out.println();
            System.out.println("1- Choose event and startup");
            System.out.println("2- Next round");
            System.out.println("3- Finish battle");
            System.out.println("--------------------------------------");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    try{
                    int currentStartup;
                    System.out.println("----------Choose the Startup ---------:");
                    System.out.println("Press 1 to " + startup1.getName());
                    System.out.println("Press 2 to " + startup2.getName());
                    currentStartup = scanner.nextInt();
                        System.out.println("----------Choose the event (choose one option)---------:");
                        System.out.println("1- Convincing pitch (+6 points)");
                        System.out.println("2- Buggy product (-4 points)");
                        System.out.println("3- Good user traction (+3 points)");
                        System.out.println("4- Angry Investor (-6 points)");
                        System.out.println("5- Fake news in the pitch (-8 points)");
                        System.out.println("--------------------------------------");
                        int eventOption = scanner.nextInt();

                        if (usedEvents.contains(eventOption)) {
                            System.out.println(" ⚠️ This event has already been used in this round. Choose another.");
                        } else {
                            if (currentStartup == 1) {
                                Event.ApplyEvent(startup1, reports, eventOption);
                            } else if (currentStartup == 2) {
                                Event.ApplyEvent(startup2, reports, eventOption);
                            } else {
                                System.out.println(" ⚠️ Invalid startup option!");
                                break;
                            }
                            usedEvents.add(eventOption);
                        }

                    } catch (InputMismatchException e) {
                        System.out.println(" ⚠️ Invalid input!");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    count++;
                    usedEvents.clear();
                    break;
                case 3:
                    break;
                default:
                    System.out.println(" ⚠\uFE0F Invalid option!");
                    break;
            }

        }while(option != 3);

        if(startup1.getPoints() == startup2.getPoints()){
            System.out.println();
            System.out.println(" ❗❗❗ DRAW....");
            System.out.println("------------------ Shark Fight --------------------");
            Random random = new Random();
            int sorteio = random.nextInt(2);

            if (sorteio == 0) {
                startup1.addPoints(2);
                System.out.println(" -->" + startup1.getName() + " received +2 points!");
            } else {
                startup2.addPoints(2);
                System.out.println(" -->" + startup2.getName() + " received +2 points!");
            }
            System.out.println();
        }

        if (startup1.getPoints() > startup2.getPoints()){
            System.out.println("----------Winner of the battle: "+ startup1.getName() + " ("+ startup1.getPoints() +" points + 30) " + " ---------");
            startup1.addPoints(30);
        } else {
            System.out.println("----------Winner of the battle: "+ startup2.getName() + " ("+ startup2.getPoints() +" points + 30) " + " ---------");
            startup2.addPoints(30);
        }
    }

}
