package DelfinAdmin;

import java.util.ArrayList;

public class KonkurrenceSvømmer extends Medlem {
    private Træner træner;
    private ArrayList<SvømmeDisciplin> svømmediscipliner;
    private int holdNr;
    private ArrayList<KonkurrenceResultat> konkurrenceResultater;

    public Træner getTræner() {
        return træner;
    }

    public ArrayList<SvømmeDisciplin> getSvømmediscipliner() {
        return svømmediscipliner;
    }

    public int getHoldNr() {
        return holdNr;
    }

    public ArrayList<KonkurrenceResultat> getKonkurrenceResultater() {
        return konkurrenceResultater;
    }
}
