import java.util.*;

public class StartupRegistter {


    public static List<Startup> Registter()  {
        Scanner scanner = new Scanner(System.in);
        List<Startup> startups = new ArrayList<>();

        int option;

            do{
                try{
                System.out.println("----------Startup registration (choose one option)---------:");
                System.out.println("1- Add Startup");
                System.out.println("2- Go to the tournament");
                System.out.println("--------------------------------------");

                while (!scanner.hasNextInt()) {
                    scanner.next();
                }

                option = scanner.nextInt();
                scanner.nextLine();

                switch (option){
                    case 1:
                        System.out.println("  Name: ");
                        String name = scanner.nextLine();
                        System.out.println("  Slogan: ");
                        String slogan = scanner.nextLine();
                        int yearFoundation;
                        try{
                        System.out.println("  Year of foundation: ");
                            yearFoundation = scanner.nextInt();
                            scanner.nextLine();
                            Startup startup = new Startup(name,slogan,yearFoundation);
                            startups.add(startup);
                            if (startups.size() == 8) {
                                System.out.println();
                                System.out.println(" ---- ❌ Maximum number of startups reached! Starting the tournament...");
                                return startups;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(" ⚠\uFE0F Invalid option!");
                            break;
                        }
                        break;
                    case 2:
                        if (startups.size() >= 4 && startups.size() <= 8 && startups.size() % 2 == 0) {
                            return startups;
                        } else {
                            System.out.println();
                            System.out.println(" ---- ❌ The tournament must have between 4 and 8 startups and have an even number of startups.");
                            System.out.println(" Please add more startups.");
                            System.out.println();
                        }
                        break;
                    default:
                        System.out.println(" ⚠\uFE0F Invalid option! Please try again.");
                        break;
                }
                } catch (InputMismatchException e) {
                    System.out.println(" ⚠\uFE0F Invalid input! Use only numbers.");
                    scanner.nextLine();
                    option = 0;
                }
            } while  (startups.size() < 8 || option != 2);

            return startups;
        }

    }


