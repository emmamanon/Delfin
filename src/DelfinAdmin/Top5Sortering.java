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
                    //Caster, dvs. ændrer en datatype fra en til en anden. Viker kun hvis de extender hinanden
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
                if(svømmeDisciplin.getNavn().equalsIgnoreCase("butterfly")) {  //Equalscaseignore?
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
        // Måske en ny metode?
        void sortAfterPickUpTime() {
            for (int i = 1; i < butterfly.size(); i++) {
                for (int j = 0; j < butterfly.size(); j++) {
                    Order temp = butterfly.get(j);
                    if (temp.getPickUptime().isAfter(butterfly.get(i).getPickUptime())) {
                        temp = butterfly.get(i);
                        butterfly.set(i, butterfly.get(j));
                        pizzaQueue.set(j, temp);

                    }
                }
            }
        }
    }
}
