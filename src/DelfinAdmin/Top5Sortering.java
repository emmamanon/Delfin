package DelfinAdmin;

import java.util.ArrayList;

public class Top5Sortering {
    protected ArrayList<Medlem> ikkeKonkurrerene; //Unødvendig?
    protected ArrayList<Medlem> konkurrenceHoldJuniorer;
    protected ArrayList<Medlem> konkurrenceHoldSeniorer;

    void splitMembersIntoTeams(ArrayList<Medlem> medlemmer) {

        for (Medlem element : medlemmer) {
            if (element instanceof KonkurrenceSvømmer) {
                if (element.getAlder() < 18)
                    konkurrenceHoldJuniorer.add(element);
                else
                    konkurrenceHoldSeniorer.add(element);
            }
            else
                ikkeKonkurrerene.add(element);
        }
    }
}
