package DelfinAdmin;

import java.util.ArrayList;

/**
 * @author Rasmus
 */

public class Top5Sortering {
    private ArrayList<Medlem> alleMedlemmer;
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


        this.alleMedlemmer = alleMedlemmer;
        this.konkurrenceHoldJuniorer = konkurrenceHoldJuniorer;
        this.konkurrenceHoldSeniorer = konkurrenceHoldSeniorer;


    }

    ArrayList<KonkurrenceSvømmer> getKonkurrenceHoldJuniorer() { return konkurrenceHoldJuniorer;}
    ArrayList<KonkurrenceSvømmer> getKonkurrenceHoldSeniorer() { return konkurrenceHoldSeniorer;}


    void helpMethodJunior(ArrayList<KonkurrenceSvømmer> teams) {
        ArrayList<KonkurrenceSvømmer> butterflyJunior = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> crawlJunior = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> rygCrawlJunior = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> brystsvømningJunior = new ArrayList<>();



        for (Medlem konkurrenceSvømmer : teams) {
            if (konkurrenceSvømmer instanceof KonkurrenceSvømmer) {
                for (SvømmeDisciplin element : ((KonkurrenceSvømmer) konkurrenceSvømmer).getSvømmediscipliner()) {
                    if (element.getNavn().equalsIgnoreCase("butterfly")) {
                        butterflyJunior.add((KonkurrenceSvømmer) konkurrenceSvømmer);
                    } else if (element.getNavn().equalsIgnoreCase("crawl")) {
                        crawlJunior.add((KonkurrenceSvømmer) konkurrenceSvømmer);
                    } else if (element.getNavn().equalsIgnoreCase("rygCrawl")) {
                        rygCrawlJunior.add((KonkurrenceSvømmer) konkurrenceSvømmer);
                    } else if (element.getNavn().equalsIgnoreCase("bryst")) {
                        brystsvømningJunior.add((KonkurrenceSvømmer) konkurrenceSvømmer);
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
                for (SvømmeDisciplin element : ((KonkurrenceSvømmer) konkurrenceSvømmer).getSvømmediscipliner()) {
                    if (element.getNavn().equalsIgnoreCase("butterfly")) {
                        butterflySenior.add((KonkurrenceSvømmer) konkurrenceSvømmer);
                    } else if (element.getNavn().equalsIgnoreCase("crawl")) {
                        crawlSenior.add((KonkurrenceSvømmer) konkurrenceSvømmer);
                    } else if (element.getNavn().equalsIgnoreCase("rygCrawl")) {
                        rygCrawlSenior.add((KonkurrenceSvømmer) konkurrenceSvømmer);
                    } else if (element.getNavn().equalsIgnoreCase("bryst")) {
                        brystsvømningSenior.add((KonkurrenceSvømmer) konkurrenceSvømmer);
                    }
                }
            }
        }

        this.butterflySenior = butterflySenior;
        this.crawlSenior = crawlSenior;
        this.rygCrawlSenior = rygCrawlSenior;
        this.brystsvømningSenior = rygCrawlSenior;

    }



    ArrayList<KonkurrenceSvømmer> sortAfterFastestTime(ArrayList<KonkurrenceSvømmer> svømmere) {
        if(svømmere == null)
            return null;

        for (int i = 1; i < svømmere.size(); i++) {
            for (int j = 0; j < svømmere.get(j).getSvømmediscipliner().size(); j++) {
                KonkurrenceSvømmer temp = svømmere.get(j);
                if (temp.getSvømmediscipliner().get(j).getTidISekunder() >
                        (svømmere.get(i).getSvømmediscipliner().get(j).getTidISekunder())) {
                    temp = svømmere.get(i);
                    svømmere.set(i, svømmere.get(j));
                    svømmere.set(j, temp);

                }
            }
        }
        return svømmere;
    }


    void printListHelp(ArrayList<KonkurrenceSvømmer> helpSvømmere) {
        if (helpSvømmere == null) {
            System.out.println("Ingen tider for denne disciplin");
        } else {

            if (helpSvømmere.size() >= 5) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(helpSvømmere.get(i).toString());
                }
            } else if (helpSvømmere.size() > 0) {
                for (KonkurrenceSvømmer svømmere : helpSvømmere) {
                    System.out.println(svømmere.toString());
                }
            } else {
                System.out.println("Ingen registrede træningsresultater for denne svømmeart");
            }
        }
    }

    void printTop5Sortering() throws NullPointerException {
        ArrayList<ArrayList<KonkurrenceSvømmer>> masterList = new ArrayList<>();

        helpMethodJunior(konkurrenceHoldJuniorer);
        helpMethodSenior(konkurrenceHoldSeniorer);

        butterflyJunior = sortAfterFastestTime(butterflyJunior);
        butterflySenior = sortAfterFastestTime(butterflySenior);
        crawlJunior = sortAfterFastestTime(crawlJunior);
        crawlSenior = sortAfterFastestTime(crawlSenior);
        rygCrawlJunior = sortAfterFastestTime(rygCrawlJunior);
        rygCrawlSenior = sortAfterFastestTime(rygCrawlSenior);
        brystsvømningJunior = sortAfterFastestTime(brystsvømningJunior);
        brystsvømningSenior = sortAfterFastestTime(butterflySenior);

        masterList.add(butterflyJunior);
        masterList.add(crawlJunior);
        masterList.add(rygCrawlJunior);
        masterList.add(brystsvømningJunior);
        masterList.add(butterflySenior);
        masterList.add(crawlSenior);
        masterList.add(rygCrawlSenior);
        masterList.add(brystsvømningSenior);

        String[] disciplinNames = new String[]{"Butterfly", "Crawl", "RygCrawl", "Brystsvømning"};





        for (int i = 0; i < 4; i++) {
            System.out.printf("Svømme Disciplin: %s - Top5 træningsresultater U18\n", disciplinNames[i]);

            printListHelp(masterList.get(i));
        }
        for (int i = 0; i < 4; i++) {
            System.out.printf("Svømme Disciplin: %s - Top5 træningsresultater SENIOR\n", disciplinNames[i]);

            printListHelp(masterList.get(i+4));

        }

    }
}
