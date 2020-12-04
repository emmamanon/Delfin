package DelfinAdmin;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Member;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Emma, Rasmus, Martin, Samavia og Marc
 */
public class Main {
    private ArrayList<Medlem> medlemArray;
    private ArrayList<Medlem> ændredeMedlemmer;
    private Scanner scanner;

    void alterResults() {
        scanner = new Scanner(System.in);
        System.out.println("Indtast medlemmets navn du ønsker at redigere tider for:");
        String navn = scanner.nextLine();

        if (medlemArray.get(searchMembersByName(navn)) instanceof KonkurrenceSvømmer) {

            System.out.println("Ønsker du at tilføje nye træningstider, eller et nyt konkurrenceresultat?" +
                    "(t for træningstider, k for konkurrenceresultat");
            String userAnswer = scanner.nextLine();

            while (!userAnswer.equalsIgnoreCase("t") &&
                    !userAnswer.equalsIgnoreCase("k")) {

                System.out.println("Indtast venligst t eller k");
                userAnswer = scanner.nextLine();
            }

            if (userAnswer.equalsIgnoreCase("t")) {
                ArrayList<SvømmeDisciplin> helpArrayTræning =
                        ((KonkurrenceSvømmer) medlemArray.get(searchMembersByName(navn))).getSvømmediscipliner();
                boolean run = true;

                while (run) {

                    System.out.println("Hvilken disciplin har svømmeren forbedret sin tid i?" +
                            "(bryst, crawl, rygcrawl eller butterfly");
                    String disciplin = scanner.nextLine();
                    System.out.println("Hvad var tiden? (i sekunder og millisekunder)");
                    double tid = Double.parseDouble(scanner.nextLine());
                    helpArrayTræning.add(new SvømmeDisciplin(disciplin, tid));

                    System.out.println("Ønsker du at opdatere flere træningstider? (y for ja, n for nej");
                    String userDecision = scanner.nextLine();

                    while (!userDecision.equalsIgnoreCase("y") &&
                            !userDecision.equalsIgnoreCase("n")) {

                        System.out.println("Indtast venligst y eller n");
                        userDecision = scanner.nextLine();
                    }

                    if (userDecision.equalsIgnoreCase("n")) {
                        run = false;
                    }
                }

                ((KonkurrenceSvømmer) medlemArray.get(searchMembersByName(navn))).setSvømmediscipliner(helpArrayTræning);
            } else {
                ArrayList<KonkurrenceResultat> helpArrayKonkurrence =
                        ((KonkurrenceSvømmer) medlemArray.get(searchMembersByName(navn))).getKonkurrenceResultater();
                boolean run = true;

                System.out.println("Hvilket stævne deltog svømmeren i?");
                String compName = scanner.nextLine();

                while (run) {
                    System.out.println("Hvilken disciplin deltog svømmeren i?");
                    String disciplin = scanner.nextLine();
                    System.out.println("Hvilken placering opnåede svømmeren i denne disciplin?");
                    int rank = Integer.parseInt(scanner.nextLine());
                    System.out.println("I hvilken tid svømmede deltageren? (i sekunder, og millisekunder)");
                    double swimTime = Double.parseDouble(scanner.nextLine());

                    helpArrayKonkurrence.add(new KonkurrenceResultat(compName, disciplin, rank, swimTime));

                    System.out.println("Deltog svømmeren i andre discipliner ved samme stævne? (y for ja, n for nej");
                    String userDecision = scanner.nextLine();

                    while (!userDecision.equalsIgnoreCase("y") &&
                            !userDecision.equalsIgnoreCase("n")) {

                        System.out.println("Indtast venligst y eller n");
                        userDecision = scanner.nextLine();
                    }

                    if (userDecision.equalsIgnoreCase("n")) {
                        run = false;
                    }
                }
                ((KonkurrenceSvømmer) medlemArray.get(searchMembersByName(navn))).setKonkurrenceResultater(helpArrayKonkurrence);
            }

        } else {
            System.out.println("Medlemmet er ikke registreret som konkurrence svømmer");
        }
    }

    void registerPayment() {
        scanner = new Scanner(System.in);
        System.out.println("Hvilket medlem ønsker du, at registere en betaling for?");
        String navn = scanner.nextLine();
        if (searchMembersByName(navn) != -1) {
            medlemArray.get(searchMembersByName(navn)).setKontingentPayed(true);
            System.out.println("Betaling er nu registreret");
        } else {
            System.out.println("Betaling kunne ikke registreres, da medlemmet ikke blev fundet");
        }
        System.out.println(medlemArray.get(searchMembersByName(navn)).isKontingentPayed());

    }

    void showMembersRestance() {
        System.out.println("Medlemmer i Restance:");
        for (Medlem element : medlemArray) {
            if (!element.isKontingentPayed()) {
                System.out.println("#" + element.getID() + " " + element.getNavn() + " Total restance: " +
                        element.getKontingentsats());
                System.out.println("*************");
            }
        }
    }


    // Kun til JunitTest!
    public int searchMembersByNameTEST(String navn, ArrayList<Medlem> medlemmer) {
        for (Medlem medlem : medlemmer) {
            if (medlem.getNavn().equalsIgnoreCase(navn)) {
                return medlemmer.indexOf(medlem);
            }
        }
        return -1;
    }





    int searchMembersByName(String navn) {
        for (Medlem element : medlemArray) {
            if (navn.equalsIgnoreCase(element.getNavn())) {
                return medlemArray.indexOf(element);
            }
        }
        System.out.println("Navnet findes ikke i listen");
        return -1;
    }

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
        System.out.println("Indtast true for betalt kontingent eller false for " +
                "ikke betalt kontingent");
        boolean kontingentPayed = Boolean.parseBoolean(scanner.nextLine());

        if (!aktivStatus) {
            ændredeMedlemmer.add(new Medlem(navn, id, alder, false, false, kontingentPayed));
        } else {

            System.out.println("Indtast true for konkurrenceSvømmer eller false " +
                    "for almindeligt medlem");
            boolean konkurrenceSvømmer = Boolean.parseBoolean(scanner.nextLine());

            if (konkurrenceSvømmer) {

                ændredeMedlemmer.add(new KonkurrenceSvømmer(navn, id, alder, true, true,
                        kontingentPayed, new Træner((alder < 18 ? "Ole Juniorsen" : "Gunnar Seniorsen")),
                        new ArrayList<SvømmeDisciplin>(), new ArrayList<KonkurrenceResultat>()));
            } else {
                ændredeMedlemmer.add(new Medlem(navn, id, alder, true, false, kontingentPayed));
            }
        }
    }

    void  run() {
        SwimReader swimReader = new SwimReader();
        scanner = new Scanner(System.in);
        medlemArray = swimReader.loadMedlemmer();
        boolean changesMade = false;

        GeneriskMenu menu = new GeneriskMenu("DelfinAdmin", "Vælg menupunkt: ",
                new String[]{"1. Tilføj nyt medlem", "2. Vis medlemmer i restance", "3. Gem ændringer",
                        "4. Udtag top5", "5. Tider for konkurrenceSvømmere",
                        "6. Redigér tider for konkurrenceSvømmere", "7. Registrer betaling af kontingent",
                        "8. Vis konkurrenceresultater", "9. Exit"});


        boolean run = true;
        while (run) {
            menu.printGeneriskMenu();
            int choice = menu.readChoice();

            switch (choice) {
                case 1: //Add new member
                    addNewMember();
                    break;

                case 2:
                    showMembersRestance();
                    break;

                case 3:
                    if (ændredeMedlemmer == null && !changesMade) {
                        System.out.println("Der er ingen ændringer at gemme");
                        break;
                    }

                    if (ændredeMedlemmer != null) {
                        medlemArray.addAll(ændredeMedlemmer);
                        ændredeMedlemmer.clear();
                    }
                    swimReader.writeToFiles(medlemArray);
                    break;

                case 4:
                    Top5Sortering top5 = new Top5Sortering(medlemArray);
                    top5.printTop5Sortering();
                    break;

                case 5:
                    int i = 0;
                    for (Medlem element : medlemArray) {
                        if (element instanceof KonkurrenceSvømmer) {
                            for (SvømmeDisciplin svømmeDisciplin : ((KonkurrenceSvømmer) element).getSvømmediscipliner()) {
                                System.out.println(svømmeDisciplin.getNavn() + ", " + svømmeDisciplin.getTidISekunder());
                            }

                        }
                        i++;
                    }
                    break;

                case 6:
                    alterResults();
                    changesMade = true;
                    break;

                case 7:
                    registerPayment();
                    break;

                case 8:
                    for (Medlem element : medlemArray) {
                        if (element instanceof KonkurrenceSvømmer) {
                            for (KonkurrenceResultat konkurrenceResultat : ((KonkurrenceSvømmer) element).getKonkurrenceResultater()) {
                                System.out.printf("Svømmer: %s\nStævne: %s\nDiscipling: %s\nPlacering: %d\nSvømmetid: %.2f\n",
                                        element.getNavn(), konkurrenceResultat.getKonkurrenceNavn(), konkurrenceResultat.getDisciplin(),
                                        konkurrenceResultat.getRangering(), konkurrenceResultat.getTidISekunder());

                            }
                        }
                    }
                    break;

                case 9:
                    run = false;
                    break;

            }

        }
    }

    public static void main(String[] args) {

        new Main().run();


    }
}
