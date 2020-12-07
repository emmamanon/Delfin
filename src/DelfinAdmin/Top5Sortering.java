package DelfinAdmin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * @author Rasmus
 */

public class Top5Sortering {
    private ArrayList<KonkurrenceSvømmer> konkurrenceHoldJuniorer;
    private ArrayList<KonkurrenceSvømmer> konkurrenceHoldSeniorer;
    private ArrayList<KonkurrenceSvømmer> butterflyJunior = new ArrayList<>();
    private ArrayList<KonkurrenceSvømmer> crawlJunior = new ArrayList<>();
    private ArrayList<KonkurrenceSvømmer> rygCrawlJunior = new ArrayList<>();
    private ArrayList<KonkurrenceSvømmer> brystsvømningJunior = new ArrayList<>();
    private ArrayList<KonkurrenceSvømmer> butterflySenior = new ArrayList<>();
    private ArrayList<KonkurrenceSvømmer> crawlSenior = new ArrayList<>();
    private ArrayList<KonkurrenceSvømmer> rygCrawlSenior = new ArrayList<>();
    private ArrayList<KonkurrenceSvømmer> brystsvømningSenior = new ArrayList<>();

    Top5Sortering (ArrayList<Medlem> alleMedlemmer) {
        ArrayList<KonkurrenceSvømmer> konkurrenceHoldJuniorer = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> konkurrenceHoldSeniorer = new ArrayList<>();

        for (Medlem medlem : alleMedlemmer) {
            if (medlem instanceof KonkurrenceSvømmer)  {
                if (medlem.getAlder() < 18) {
                    konkurrenceHoldJuniorer.add((KonkurrenceSvømmer) medlem);
                } else {
                    konkurrenceHoldSeniorer.add((KonkurrenceSvømmer) medlem);
                }
            }
        }

        this.konkurrenceHoldJuniorer = konkurrenceHoldJuniorer;
        this.konkurrenceHoldSeniorer = konkurrenceHoldSeniorer;
    }

    void helpMethodJunior(ArrayList<KonkurrenceSvømmer> teams) {
        ArrayList<KonkurrenceSvømmer> butterflyJunior = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> crawlJunior = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> rygCrawlJunior = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> brystsvømningJunior = new ArrayList<>();

        for (Medlem konkurrenceSvømmer : teams) {
            if (konkurrenceSvømmer instanceof KonkurrenceSvømmer) {
                KonkurrenceSvømmer temp = (KonkurrenceSvømmer) konkurrenceSvømmer;

                for (SvømmeDisciplin element : ((KonkurrenceSvømmer) konkurrenceSvømmer).getSvømmediscipliner()) {

                    if (element.getNavn().equalsIgnoreCase("butterfly")) {
                        butterflyJunior.add(temp);
                    }
                    else if (element.getNavn().equalsIgnoreCase("crawl")) {
                        crawlJunior.add(temp);
                    }
                    else if (element.getNavn().equalsIgnoreCase("rygCrawl")) {
                        rygCrawlJunior.add(temp);
                    }
                    else if (element.getNavn().equalsIgnoreCase("bryst")) {
                        brystsvømningJunior.add(temp);
                    }
                }
            }
        }

        this.butterflyJunior = butterflyJunior;
        this.crawlJunior = crawlJunior;
        this.rygCrawlJunior = rygCrawlJunior;
        this.brystsvømningJunior = brystsvømningJunior;

    }

    void helpMethodSenior(ArrayList<KonkurrenceSvømmer> teams) {

        ArrayList<KonkurrenceSvømmer> butterflySenior = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> crawlSenior = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> rygCrawlSenior = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> brystsvømningSenior = new ArrayList<>();

        for (Medlem konkurrenceSvømmer : teams) {
            if (konkurrenceSvømmer instanceof KonkurrenceSvømmer) {
                KonkurrenceSvømmer temp = (KonkurrenceSvømmer) konkurrenceSvømmer;

                for (SvømmeDisciplin element : ((KonkurrenceSvømmer) konkurrenceSvømmer).getSvømmediscipliner()) {

                    if (element.getNavn().equalsIgnoreCase("butterfly")) {
                        butterflySenior.add(temp);
                    }
                    else if (element.getNavn().equalsIgnoreCase("crawl")) {
                        crawlSenior.add(temp);
                    }
                    else if (element.getNavn().equalsIgnoreCase("rygCrawl")) {
                        rygCrawlSenior.add(temp);
                    }
                    else if (element.getNavn().equalsIgnoreCase("bryst")) {
                        brystsvømningSenior.add(temp);
                    }
                }
            }

        }

        this.butterflySenior = butterflySenior;
        this.crawlSenior = crawlSenior;
        this.rygCrawlSenior = rygCrawlSenior;
        this.brystsvømningSenior = brystsvømningSenior;
    }


    double fastestTime(ArrayList<SvømmeDisciplin> svømmeDiscipliner, String disciplin) {
        double fastestTime = 10000;
        for (SvømmeDisciplin element : svømmeDiscipliner) {
            if (element.getNavn().equalsIgnoreCase(disciplin)) {
                if (element.getTidISekunder() < fastestTime) {
                    fastestTime = element.getTidISekunder();
                }
            }
        }
        return fastestTime;
    }


    ArrayList<KonkurrenceSvømmer> sortAfterFastestTime(ArrayList<KonkurrenceSvømmer> svømmere, String disciplin) {

        for (int i = 0; i < svømmere.size() - 1; i++) {
            for (int j = 0; j < svømmere.size() - 1; j++) {
                if (fastestTime(svømmere.get(j).getSvømmediscipliner(), disciplin) >
                        fastestTime(svømmere.get(j+1).getSvømmediscipliner(), disciplin)){
                    Collections.swap(svømmere, j, j+1);
                }
            }
        }
        return svømmere;
    }


    void printListHelp(ArrayList<KonkurrenceSvømmer> helpSvømmere, String disciplin) {
        if (helpSvømmere == null) {
            System.out.println("Ingen tider for denne disciplin");
        } else {

            for (int i = 0; i < helpSvømmere.size() - 1; i++) {
                if (helpSvømmere.get(i).getNavn().equalsIgnoreCase(helpSvømmere.get(i+1).getNavn())) {
                    helpSvømmere.remove(i);
                }
            }

            if (helpSvømmere.size() >= 5) {
                for (int i = 0; i < 5; i++) {
                    System.out.println("\n" + helpSvømmere.get(i).toString(disciplin));
                }
            } else if (helpSvømmere.size() > 0) {
                for (KonkurrenceSvømmer svømmere : helpSvømmere) {
                    System.out.println("\n" + svømmere.toString(disciplin));
                }
            } else {
                System.out.println("Ingen registrede træningsresultater for denne svømmeart");
            }
        }
    }

    void printTop5Sortering() throws NullPointerException {
        ArrayList<ArrayList<KonkurrenceSvømmer>> masterListJunior = new ArrayList<>();
        ArrayList<ArrayList<KonkurrenceSvømmer>> masterListSenior = new ArrayList<>();

        String[] disciplinNames = new String[]{"Butterfly", "Crawl", "RygCrawl", "Bryst"};

        helpMethodJunior(konkurrenceHoldJuniorer);
        helpMethodSenior(konkurrenceHoldSeniorer);


        butterflyJunior = sortAfterFastestTime(butterflyJunior, disciplinNames[0]);
        butterflySenior = sortAfterFastestTime(butterflySenior, disciplinNames[0]);
        crawlJunior = sortAfterFastestTime(crawlJunior, disciplinNames[1]);
        crawlSenior = sortAfterFastestTime(crawlSenior, disciplinNames[1]);
        rygCrawlJunior = sortAfterFastestTime(rygCrawlJunior, disciplinNames[2]);
        rygCrawlSenior = sortAfterFastestTime(rygCrawlSenior, disciplinNames[2]);
        brystsvømningJunior = sortAfterFastestTime(brystsvømningJunior, disciplinNames[3]);
        brystsvømningSenior = sortAfterFastestTime(brystsvømningSenior, disciplinNames[3]);


        masterListJunior.add(butterflyJunior);
        masterListJunior.add(crawlJunior);
        masterListJunior.add(rygCrawlJunior);
        masterListJunior.add(brystsvømningJunior);

        masterListSenior.add(butterflySenior);
        masterListSenior.add(crawlSenior);
        masterListSenior.add(rygCrawlSenior);
        masterListSenior.add(brystsvømningSenior);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hvilken Disciplin ønskes top5 udtaget for?");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "Butterfly":
                System.out.printf("\nSvømme Disciplin: %s - Top5 træningsresultater U18\n", disciplinNames[0]);
                printListHelp(masterListJunior.get(0), disciplinNames[0]);
                System.out.printf("\nSvømme Disciplin: %s - Top5 træningsresultater SENIOR\n", disciplinNames[0]);
                printListHelp(masterListSenior.get(0), disciplinNames[0]);
                break;
            case "Crawl":
                System.out.printf("\nSvømme Disciplin: %s - Top5 træningsresultater U18\n", disciplinNames[1]);
                printListHelp(masterListJunior.get(1), disciplinNames[1]);
                System.out.printf("\nSvømme Disciplin: %s - Top5 træningsresultater SENIOR\n", disciplinNames[1]);
                printListHelp(masterListSenior.get(1), disciplinNames[1]);
                break;
            case "RygCrawl":
                System.out.printf("\nSvømme Disciplin: %s - Top5 træningsresultater U18\n", disciplinNames[1]);
                printListHelp(masterListJunior.get(2), disciplinNames[2]);
                System.out.printf("\nSvømme Disciplin: %s - Top5 træningsresultater SENIOR\n", disciplinNames[1]);
                printListHelp(masterListSenior.get(2), disciplinNames[2]);
                break;
            case "Bryst":
                System.out.printf("\nSvømme Disciplin: %s - Top5 træningsresultater U18\n", disciplinNames[3]);
                printListHelp(masterListJunior.get(3), disciplinNames[3]);
                System.out.printf("\nSvømme Disciplin: %s - Top5 træningsresultater SENIOR\n", disciplinNames[3]);
                printListHelp(masterListSenior.get(3), disciplinNames[3]);
                break;
            default:
                System.out.println("Denne disciplin findes ikke.");
        }
    }
}
