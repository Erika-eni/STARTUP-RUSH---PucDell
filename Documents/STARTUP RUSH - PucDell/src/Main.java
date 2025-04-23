import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Startup Race - STARTUP RUSH");
        System.out.println();

        while (true) {
            System.out.println("---------- Choose an option ----------:");
            System.out.println("1 - Start new tournament");
            System.out.println("2 - Load saved tournament");
            System.out.println("3 - Delete saved tournament");
            System.out.println("4 - Exit");
            System.out.println("--------------------------------------");
            System.out.print("Choice: ");

            String option = scanner.nextLine();

            List<Startup> startups = new ArrayList<>();
            List<Startup> winners = new ArrayList<>();

            switch (option) {
                case "1":

                    startups = StartupRegistter.Registter();
                    Event event = new Event();
                    Tournament.start(startups, event);

                    System.out.print(" --> Enter a name to save the tournament: ");
                    String saveName = scanner.nextLine();
                    SaveRush.save(saveName + ".dat", startups, winners);
                    System.out.println("✅ Tournament saved as " + saveName + ".dat");
                    break;

                case "2":
                    File folder = new File("./");
                    File[] files = folder.listFiles((dir, name) -> name.endsWith(".dat"));

                    if (files != null && files.length > 0) {
                        System.out.println("Available saved tournaments:");
                        for (int i = 0; i < files.length; i++) {
                            System.out.println((i + 1) + " - " + files[i].getName());
                        }

                        System.out.print("Choose a saved tournament to load: ");
                        int choice = Integer.parseInt(scanner.nextLine());

                        if (choice >= 1 && choice <= files.length) {
                            String fileName = files[choice - 1].getName();
                            StartupData loaded = SaveRush.load(fileName);
                            if (loaded != null) {
                                startups = loaded.getStartups();
                                winners = loaded.getWinners();
                                System.out.println("✅ Loaded successfully!");

                                System.out.println("\n--------- RANKING ---------");
                                startups.sort(Comparator.comparingInt(Startup::getPoints).reversed());
                                for (Startup startup : startups) {
                                    System.out.println("--> " + startup.getName() + " = " + startup.getPoints() + " points");
                                    System.out.println(startup.getReport());
                                    System.out.println("--------------------------------------");
                                }
                            } else {
                                System.out.println("⚠️ Failed to load the selected tournament.");
                            }
                        } else {
                            System.out.println("⚠️ Invalid choice.");
                        }
                    } else {
                        System.out.println("⚠️ No saved tournaments found.");
                    }
                    break;

                case "3":
                    File folderDelete = new File("./");
                    File[] deleteFiles = folderDelete.listFiles((dir, name) -> name.endsWith(".dat"));

                    if (deleteFiles != null && deleteFiles.length > 0) {
                        System.out.println(" --> Available saved tournaments to delete:");
                        for (int i = 0; i < deleteFiles.length; i++) {
                            System.out.println((i + 1) + " - " + deleteFiles[i].getName());
                        }

                        System.out.print(" --> Choose a saved tournament to delete: ");
                        int deleteChoice = Integer.parseInt(scanner.nextLine());

                        if (deleteChoice >= 1 && deleteChoice <= deleteFiles.length) {
                            String fileNameToDelete = deleteFiles[deleteChoice - 1].getName();
                            SaveRush.delete(fileNameToDelete);
                        } else {
                            System.out.println();
                            System.out.println("⚠️ Invalid choice.");
                        }
                    } else {
                        System.out.println();
                        System.out.println("⚠️ No saved tournaments found.");
                    }
                    break;

                case "4":
                    System.out.println();
                    System.out.println("👋 Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
                    continue;
            }
        }
    }
}
