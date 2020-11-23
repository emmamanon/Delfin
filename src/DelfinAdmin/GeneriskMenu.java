package DelfinAdmin;
import java.util.Scanner;

public class GeneriskMenu {
    private String menuHeader;
    private String leadText;
    private String[] menuItems;
    private int exitNumber = 9;



    public GeneriskMenu(String menuHeader, String leadText, String[] menuItems){
        this.menuHeader = menuHeader;
        this.leadText = leadText;
        this.menuItems = menuItems;

    }

    public void printGeneriskMenu() {
        System.out.println(menuHeader);
        for (String element : menuItems) {
            System.out.println(element);
        }
        System.out.print("\n" + leadText);
    }


    public int readChoice() {
        Scanner in = new Scanner(System.in);

        int choice = -1;
        while (!in.hasNextInt()) {
            System.out.print(leadText);
            in.next();
        }
        choice = in.nextInt();
        while (((choice > menuItems.length - 1 || choice <= 0) && choice != exitNumber)) {
            System.out.println("\nMenupunkt ikke genkendt. Indtast venligst gyldigt menupunkt");
            printGeneriskMenu();
            if (in.hasNextInt())
                choice = in.nextInt();
            else
                in.next();
        }
        return choice;
    }

    public int getExitNumber() {
        return exitNumber;
    }
}
