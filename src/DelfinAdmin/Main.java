package DelfinAdmin;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Member;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {
    private ArrayList<Medlem> medlemArray;
    private ArrayList<Medlem> ændredeMedlemmer;
    private Scanner scanner;



    void addNewMember() {
        medlemArray = new SwimReader().loadMedlemmer();
        ændredeMedlemmer = new ArrayList<>();
        scanner = new Scanner(System.in);

        int id = medlemArray.size() + 1;
        System.out.println("Indtast medlemmets navn:");
        String navn = scanner.nextLine();
        System.out.println("Indtast medlemmets fødselsår:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Indtast medlemmets fødselsmåned:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Indtast medlemmets fødselsdag:");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate birthday = LocalDate.of(year, month, day);
        int alder = new Alder(birthday).getAgeNow();
        System.out.println("Indtast true for aktivt eller false for " +
                "passivt medlemskab");
        boolean aktivStatus = Boolean.parseBoolean(scanner.nextLine());

        if (!aktivStatus) {
            ændredeMedlemmer.add(new Medlem(navn, id, alder, false, false));
        } else {

            System.out.println("Indtast true for konkurrenceSvømmer eller false " +
                    "for almindeligt medlem");
            boolean konkurrenceSvømmer = Boolean.parseBoolean(scanner.nextLine());

            if (konkurrenceSvømmer) {
                int holdNr = (alder < 18 ? 2 : 1);
                ændredeMedlemmer.add(new KonkurrenceSvømmer(navn, id, alder, true, true,
                        new Træner((alder < 18 ? "Ole Juniorsen" : "Gunnar Seniorsen")),
                        new ArrayList<SvømmeDisciplin>(), holdNr,  new ArrayList<KonkurrenceResultat>()));
            } else {
                ændredeMedlemmer.add(new Medlem(navn, id, alder, true, false));
            }
        }
    }

    void  run() {

        SwimReader swimReader = new SwimReader();

        GeneriskMenu menu = new GeneriskMenu("DelfinAdmin", "Vælg menupunkt: ",
                new String[]{"1. Tilføj nyt medlem", "2. Indtast bestilling", "3. Vis bestillingskø",
                        "4. Næste ordre", "5. Færdiggør ordre", "6. Statistik menu",  "9. Exit"});

        while (true) {

            medlemArray = swimReader.loadMedlemmer();

            menu.printGeneriskMenu();
            int choice = menu.readChoice();

            switch (choice) {

                case 1: //Add new member
                    addNewMember();
                    break;



                case 2:



                case 3:
                    medlemArray.addAll(ændredeMedlemmer);
                    swimReader.writeToFiles(medlemArray);
                    ændredeMedlemmer.clear();
                    break;

                case 4:
                    for (Medlem element : medlemArray) {
                        System.out.println(element.getNavn());
                    }
                    break;
                case 5:
                    int i = 0;
                    for (Medlem element : medlemArray) {
                        if (element instanceof KonkurrenceSvømmer) {
                            System.out.println(((KonkurrenceSvømmer) element).getSvømmediscipliner().get(i).getTidISekunder());
                        }
                    }

                case 6:

                case 9:

                    return;

            }

        }
    }

    public static void main(String[] args) {

        new Main().run();


    }
}
