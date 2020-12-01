package DelfinAdmin;

import java.util.ArrayList;

/**
 * @author Rasmus
 */

public class Top5Sortering {
    protected ArrayList<Medlem> ikkeKonkurrerene; //Unødvendig?
    protected ArrayList<KonkurrenceSvømmer> konkurrenceHoldJuniorer;
    protected ArrayList<KonkurrenceSvømmer> konkurrenceHoldSeniorer;

    Top5Sortering (ArrayList<Medlem> medlemmer) {
        for (Medlem element : medlemmer) {
            if (element instanceof KonkurrenceSvømmer) {
                if (element.getAlder() < 18)
                    //Caster, dvs. ændrer en datatype fra en til en anden. Virker kun hvis de extender hinanden
                    konkurrenceHoldJuniorer.add((KonkurrenceSvømmer) element);
                else
                    konkurrenceHoldSeniorer.add((KonkurrenceSvømmer) element);
            }
        }
    }

    void top5Sortering(ArrayList<KonkurrenceSvømmer> topElever) {
        ArrayList<KonkurrenceSvømmer> butterfly = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> crawl = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> rygCrawl = new ArrayList<>();
        ArrayList<KonkurrenceSvømmer> brystsvømning = new ArrayList<>();

        for (KonkurrenceSvømmer konkurrenceSvømmer : topElever) {
            for (SvømmeDisciplin element : konkurrenceSvømmer.getSvømmediscipliner()) {
                if(element.getNavn().equalsIgnoreCase("butterfly")) {
                    butterfly.add(konkurrenceSvømmer);
                } else if (element.getNavn().equalsIgnoreCase("crawl")) {
                    crawl.add(konkurrenceSvømmer);
                } else if (element.getNavn().equalsIgnoreCase("rygCrawl")) {
                    rygCrawl.add(konkurrenceSvømmer);
                } else if (element.getNavn().equalsIgnoreCase("brystsvømning")) {
                    brystsvømning.add(konkurrenceSvømmer);
                }
            }
        }
        // Måske en ny metode?{
        for (int i = 1; i < butterfly.size(); i++) {
            for (int j = 0; j < butterfly.size(); j++) {
                KonkurrenceSvømmer temp = butterfly.get(j);
                if (temp.getSvømmediscipliner().get(j).getTidISekunder() > (butterfly.get(i).getSvømmediscipliner().get(j).getTidISekunder())) {
                    temp = butterfly.get(i);
                    butterfly.set(i, butterfly.get(j));
                    butterfly.set(j, temp);

                }
            }
        }

        for (int i = 1; i < crawl.size(); i++) {
            for (int j = 0; j < crawl.size(); j++) {
                KonkurrenceSvømmer temp = crawl.get(j);
                if (temp.getSvømmediscipliner().get(j).getTidISekunder() > (crawl.get(i).getSvømmediscipliner().get(j).getTidISekunder())) {
                    temp = crawl.get(i);
                    crawl.set(i, crawl.get(j));
                    crawl.set(j, temp);
                }
            }
        }

        for (int i = 1; i < rygCrawl.size(); i++) {
            for (int j = 0; j < rygCrawl.size(); j++) {
                KonkurrenceSvømmer temp = crawl.get(j);
                if (temp.getSvømmediscipliner().get(j).getTidISekunder() > (rygCrawl.get(i).getSvømmediscipliner().get(j).getTidISekunder())) {
                    temp = rygCrawl.get(i);
                    rygCrawl.set(i, rygCrawl.get(j));
                    rygCrawl.set(j, temp);
                }
            }
        }

        for (int i = 1; i < brystsvømning.size(); i++) {
            for (int j = 0; j < brystsvømning.size(); j++) {
                KonkurrenceSvømmer temp = crawl.get(j);
                if (temp.getSvømmediscipliner().get(j).getTidISekunder() > (brystsvømning.get(i).getSvømmediscipliner().get(j).getTidISekunder())) {
                    temp = brystsvømning.get(i);
                    brystsvømning.set(i, brystsvømning.get(j));
                    brystsvømning.set(j, temp);
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(butterfly.get(i).toString());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(crawl.get(i).toString());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(rygCrawl.get(i).toString());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(brystsvømning.get(i).toString());
        }
    }
}
