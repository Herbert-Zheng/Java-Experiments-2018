import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PIManager{
    static int itemCounter = 0;
    static PIMEntity[] PIMEntities = new PIMEntity[100];

    public static void main(String[] args) {
        welcomeInterface();
        executeInputCommand();

    }

    static void welcomeInterface() {
        System.out.println("Welcome to PIM.");
        System.out.println("---Enter a command (supported commands are List Create Save Load Quit)---");
    }

    static String readInputText() {
        Scanner scan = new Scanner(System.in);
        String inputCommands = null;

        if (scan.hasNext())
            inputCommands = scan.next();

        return inputCommands;
    }

    static void executeInputCommand() {
        String command = readInputText();

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
            command = readInputText();
        }
    }

    static String readInputPriority() {
        Scanner scan = new Scanner(System.in);
        String inputPriority = scan.next();

        if (inputPriority.equalsIgnoreCase("Normal") || inputPriority.isEmpty())
            return "Normal";
        else if (inputPriority.equalsIgnoreCase("Urgent"))
            return "Urgent";
        else if (inputPriority.equalsIgnoreCase("Cancel"))
            welcomeInterface();
        else {
            System.err.println("Please input correct priority level:\nNormal Urgent");
            System.err.println("Or input Cancel to undo changes.");
            readInputPriority();
        }
        return inputPriority;
    }

    static String readInputTextLine() {
        Scanner scan = new Scanner(new InputStreamReader(System.in));
        String inputTexts = null;

        if (scan.hasNext())
            inputTexts = scan.nextLine();
        scan.close();

        return inputTexts;
    }

    static Date readInputDate() {
        Scanner scan = new Scanner(System.in);
        String dateStr;
        Date date = new Date();

        if (scan.hasNext("^\\d{2}/\\d{2}/\\d{4}$")) {
            dateStr = scan.next("^\\d{2}/\\d{2}/\\d{4}$");
            try {
                date = new SimpleDateFormat("MM/dd/yyyy").parse(dateStr);
            } catch (Exception e) {
                System.err.println("Wrong date format!(MM/DD/yyyy) Please input again.");
                readInputDate();
            }
        }
        // TODO Implement *return* condition in case user do not want to input date.
        else {
            System.err.println("Wrong date format!(MM/DD/yyyy) Please input again.");
            readInputDate();
        }
        return date;
    }

    static void List() {
        System.out.println("There are " + (itemCounter + 1) + " items.");
        for (int i = 0; i < itemCounter; i++) {
            System.out.print("Item " + (i + 1) + ":");
            System.out.println(PIMEntities[i]);
        }

        welcomeInterface();
    }

    static void Create() {
        System.out.println("Enter an item type (Todo, Note, Contact or Appointment).");
        readAndCreateInputItemType();
        itemCounter++;

        welcomeInterface();
    }

    static void readAndCreateInputItemType() {
        String itemType = readInputText();

        if (itemType.equalsIgnoreCase("Todo"))
            createTodo();
        else if (itemType.equalsIgnoreCase("Note"))
            createNote();
        else if (itemType.equalsIgnoreCase("Appointment"))
            createAppointment();
        else if (itemType.equalsIgnoreCase("Contact"))
            createContact();
        else if (itemType.equalsIgnoreCase("Cancel"))
            welcomeInterface();
        else {
            System.err.println("Please check if your input type is correct, ignoring case, and input again.");
            System.err.println("Or input Cancel to exit.");
            readAndCreateInputItemType();
        }
    }

    static void createTodo() {
        Date todoDate;
        String todoText;
        String todoPriority;

        System.out.println("Enter date for todo item(MM/DD/yyyy):");
        todoDate = readInputDate();

        System.out.println("Enter todo text:");
        todoText = readInputTextLine();

        System.out.println("Enter todo priority:");
        todoPriority = readInputPriority();

        PIMEntities[itemCounter] = new PIMTodo(todoPriority);
        PIMEntities[itemCounter].setFromString(todoText);
        PIMEntities[itemCounter].setDate(todoDate);
    }

    static void createNote() {
        String noteText;
        String notePriority;

        System.out.println("Enter note text:");
        noteText = readInputTextLine();

        System.out.println("Enter note priority:");
        notePriority = readInputPriority();

        PIMEntities[itemCounter] = new PIMNote(notePriority);
        PIMEntities[itemCounter].setFromString(noteText);
    }

    static void createAppointment() {
        Date appointDate;
        String appointDescrip;
        String appointPriority;

        System.out.println("Enter date for appointment item(MM/DD/yyyy):");
        appointDate = readInputDate();

        System.out.println("Enter appointment description:");
        appointDescrip = readInputTextLine();

        System.out.println("Enter appointment priority:");
        appointPriority = readInputPriority();

        PIMEntities[itemCounter] = new PIMAppointment(appointPriority);
        PIMEntities[itemCounter].setFromString(appointDescrip);
        PIMEntities[itemCounter].setMyDate(appointDate);
    }

    static void createContact() {
        String firstName;
        String lastName;
        String emailAddr;

        System.out.println("Enter contact first name:");
        firstName = readInputText();

        System.out.println("Enter contact last name:");
        lastName = readInputText();

        // TODO: filter email address.
        System.out.println("Enter email address:");
        emailAddr = readInputText();

        PIMEntities[itemCounter] = new PIMContact(firstName, lastName);
        PIMEntities[itemCounter].setFromString(emailAddr);
    }

    static void Save() {
        System.out.println("Items have been saved.");

        welcomeInterface();
    }

    static void Load() {
        // Leave it blank for further implementation.

        welcomeInterface();
    }

    static void Quit() {
        System.exit(0);
    }
}

