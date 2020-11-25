package DelfinAdmin;

import java.util.ArrayList;

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
        ArrayList<SvømmeDisciplin> butterfly = new ArrayList<>();
        ArrayList<SvømmeDisciplin> crawl = new ArrayList<>();
        ArrayList<SvømmeDisciplin> rygCrawl = new ArrayList<>();
        ArrayList<SvømmeDisciplin> brystsvømning = new ArrayList<>();

        for (KonkurrenceSvømmer konkurrenceSvømmer : topElever) {
            for (SvømmeDisciplin svømmeDisciplin : konkurrenceSvømmer.getSvømmediscipliner()) {
                if(svømmeDisciplin.getNavn().equalsIgnoreCase("butterfly")) {
                    butterfly.add(svømmeDisciplin);
                } else if (svømmeDisciplin.getNavn().equalsIgnoreCase("crawl")) {
                    crawl.add(svømmeDisciplin);
                } else if (svømmeDisciplin.getNavn().equalsIgnoreCase("rygCrawl")) {
                    rygCrawl.add(svømmeDisciplin);
                } else if (svømmeDisciplin.getNavn().equalsIgnoreCase("brystsvømning")) {
                    brystsvømning.add(svømmeDisciplin);
                }
            }
        }
        // Måske en ny metode?{
        for (int i = 1; i < butterfly.size(); i++) {
            for (int j = 0; j < butterfly.size(); j++) {
                SvømmeDisciplin temp = butterfly.get(j);
                if (temp.getTidISekunder() > (butterfly.get(i).getTidISekunder())) {
                    temp = butterfly.get(i);
                    butterfly.set(i, butterfly.get(j));
                    butterfly.set(j, temp);

                }
            }
        }

        for (int i = 1; i < crawl.size(); i++) {
            for (int j = 0; j < crawl.size(); j++) {
                SvømmeDisciplin temp = crawl.get(j);
                if (temp.getTidISekunder() > (crawl.get(i).getTidISekunder())) {
                    temp = crawl.get(i);
                    crawl.set(i, crawl.get(j));
                    crawl.set(j, temp);
                }
            }
        }

        for (int i = 1; i < rygCrawl.size(); i++) {
            for (int j = 0; j < rygCrawl.size(); j++) {
                SvømmeDisciplin temp = rygCrawl.get(j);
                if (temp.getTidISekunder() > (rygCrawl.get(i).getTidISekunder())) {
                    temp = rygCrawl.get(i);
                    rygCrawl.set(i, rygCrawl.get(j));
                    rygCrawl.set(j, temp);
                }
            }
        }

        for (int i = 1; i < brystsvømning.size(); i++) {
            for (int j = 0; j < brystsvømning.size(); j++) {
                SvømmeDisciplin temp = brystsvømning.get(j);
                if (temp.getTidISekunder() > (brystsvømning.get(i).getTidISekunder())) {
                    temp = brystsvømning.get(i);
                    brystsvømning.set(i, brystsvømning.get(j));
                    brystsvømning.set(j, temp);
                }
            }
        }
    }
}
