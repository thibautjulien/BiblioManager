import BilbioManager.src.db.Database;

public class App {

    public static void main(String[] args) throws Exception {
        Database.initSchema();
        System.out.println("Base de données initialisée !");
    }
}

