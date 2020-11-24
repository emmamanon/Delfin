package DelfinAdmin;


import java.util.ArrayList;

public class Main {


    private ArrayList<Medlem> alleMedlemmer; //Unødvendig? Medmindre de har begge hold
    private ArrayList<Medlem> konkurrenceHoldJuniorer;
    private ArrayList<Medlem> konkurrenceHoldSeniorer;

    void splitMembersIntoTeams(ArrayList<Medlem> medlemmer) {

        for (Medlem element : medlemmer) {
            if (element instanceof KonkurrenceSvømmer) {
                if (element.getAlder() < 18)
                    konkurrenceHoldJuniorer.add(element);
                else
                    konkurrenceHoldSeniorer.add(element);
            }
        }
    }


    void run() {
        GeneriskMenu menu = new GeneriskMenu("DelfinAdmin", "Vælg menupunkt: ",
                new String[]{"1. Tilføj nyt medlem", "2. Indtast bestilling", "3. Vis bestillingskø",
                        "4. Næste ordre", "5. Færdiggør ordre", "6. Statistik menu",  "9. Exit"});

        while (true) {

            menu.printGeneriskMenu();
            int choice = menu.readChoice();

            switch (choice) {
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:

                case 6:

                case 9:

                    return;

            }
        }
    }

    public static void main(String[] args) {

    }
}
