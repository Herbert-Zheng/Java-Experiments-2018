import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PIManager {
    static int itemCounter = 0;
    static PIMEntity[] PIMEntities = new PIMEntity[100];

    public static void main(String[] args) {
        System.out.println("Welcome to PIM.");
        System.out.println("---Enter a command (supported commands are List Create Save Load Quit)---");

        executeInputCommand();

    }

    static String readInputCommand() {
        Scanner scan = new Scanner(System.in);
        String inputCommands = null;

        if (scan.hasNext())
            inputCommands = scan.next();

        return inputCommands;
    }

    static void executeInputCommand() {
        String command = readInputCommand();

        while (command != null) {
            switch (command) {
                case ("List"):
                    List();
                case ("Create"):
                    Create();
                case ("Save"):
                    Save();
                case ("Load"):
                    Load();
                case ("Quit"):
                    Quit();
                default: {
                    System.err.println("Please check the command inputted, case sensitive.");
                }
            }
            command = readInputCommand();
        }
    }

    static String readInputText() {
        Scanner scan = new Scanner(new InputStreamReader(System.in));
        String inputTexts = null;

        if (scan.hasNext())
            inputTexts = scan.nextLine();
        scan.close();

        return inputTexts;
    }

    static String readInputPriority() {
        Scanner scan = new Scanner(System.in);
        String inputPriority = scan.next();

        if (inputPriority.equalsIgnoreCase("Normal") || inputPriority.equals(""))
            return "Normal";
        else if (inputPriority.equalsIgnoreCase("Urgent"))
            return "Urgent";
        else if (inputPriority.equalsIgnoreCase("Cancel"))
            return "Cancel";
        else {
            System.err.println("Please input correct priority level:\nNormal Urgent");
            System.err.println("Or input Cancel to undo changes.");
            readInputPriority();
        }
        return inputPriority;
    }

    static Date readInputDate() {
        Scanner scan = new Scanner(System.in);
        String dateStr;
        Date date = null;

        if (scan.hasNext("^\\d{2}/\\d{2}/\\d{4}$")) {
            dateStr = scan.next("^\\d{2}/\\d{2}/\\d{4}$");
            try {
                date = new SimpleDateFormat("MM/dd/yyyy").parse(dateStr);
            } catch (Exception e) {
                System.err.println("Wrong date format!(MM/DD/yyyy)");
            }
        } else {
            System.err.println("Wrong date format!(MM/DD/yyyy)");
        }
        return date;
    }

    static void List() {
        System.out.println("There are " + itemCounter + " items.");
    }

    static void Create() {
        System.out.println("Enter an item type (Todo, Note, Contact or Appointment).");
        readAndCreateInputItemType();
        itemCounter++;
    }

    static void readAndCreateInputItemType() {
        String itemType = readInputCommand();

        if (itemType.equalsIgnoreCase("Todo"))
            createTodo();
        else if (itemType.equalsIgnoreCase("Note"))
            createNote();
        else if (itemType.equalsIgnoreCase("Appointment"))
            createAppointment();
        else if (itemType.equalsIgnoreCase("Contact"))
            createContact();
        else if (itemType.equalsIgnoreCase("Cancel"))
            return;
        else {
            System.err.println("Please check if your input type is correct, ignoring case, and input again.");
            System.err.println("Or input Cancel to exit.");
            readAndCreateInputItemType();
        }
    }

    static void createTodo() {
        Date todoDate = null;
        String todoText = null;
        String todoPriority = null;

        System.out.println("Enter date for todo item(MM/DD/yyyy):");
        todoDate = readInputDate();

        System.out.println("Enter todo text:");
        todoText = readInputText();

        System.out.println("Enter todo priority:");
        if (!readInputPriority().equals("Cancel"))
            todoPriority = readInputPriority();
        else
            return;

        PIMEntities[itemCounter] = new PIMTodo();
    }

    static void createNote() {
        PIMEntities[itemCounter] = new PIMNote();
    }

    static void createAppointment() {
        PIMEntities[itemCounter] = new PIMAppointment();
    }

    static void createContact() {
        PIMEntities[itemCounter] = new PIMContact();

    }

    static void Save() {
        System.out.println("Items have been saved.");
    }

    static void Load() {
        // Leave it blank for further implementation.
    }

    static void Quit() {
        System.exit(0);
    }
}

