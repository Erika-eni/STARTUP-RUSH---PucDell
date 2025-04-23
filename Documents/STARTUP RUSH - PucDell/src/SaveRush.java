import java.io.*;
        import java.util.List;

public class SaveRush {
    public static void save(String fileName, List<Startup> startups, List<Startup> winners) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(new StartupData(startups, winners));
            System.out.println("✅ Game saved successfully.");
        } catch (IOException e) {
            System.out.println("⚠️ Error saving game: " + e.getMessage());
        }
    }

    public static StartupData load(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            StartupData data = (StartupData) in.readObject();
            System.out.println("✅ Game loaded successfully.");
            return data;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠️ Error loading game: " + e.getMessage());
            return null;
        }
    }

    public static void delete(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.delete()) {
            System.out.println("✅ Game deleted successfully.");
        } else {
            System.out.println("⚠️ Error deleting game.");
        }
    }
}
