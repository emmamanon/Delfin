package DelfinAdmin;

import java.util.ArrayList;

public class KonkurrenceSvømmer extends Medlem {
    private Træner træner;
    private ArrayList<SvømmeDisciplin> svømmediscipliner;
    private int holdNr;
    private ArrayList<KonkurrenceResultat> konkurrenceResultater;


    KonkurrenceSvømmer(String navn, int ID, int alder, boolean aktivStatus, boolean konkurrenceSvømmer) {
        super(navn, ID, alder, aktivStatus, konkurrenceSvømmer);
    }

    KonkurrenceSvømmer(String navn, int ID, int alder, boolean aktivStatus, boolean konkurrenceSvømmer, Træner træner,
                       ArrayList<SvømmeDisciplin> svømmediscipliner,
                       int holdNr, ArrayList<KonkurrenceResultat> konkurrenceResultater) {

        super(navn, ID, alder, aktivStatus, konkurrenceSvømmer);
        this.træner = træner;
        this.svømmediscipliner = svømmediscipliner;
        this.holdNr = holdNr;
        this.konkurrenceResultater = konkurrenceResultater;
    }


    public ArrayList<SvømmeDisciplin> getSvømmediscipliner() {
        return svømmediscipliner;
    }

    public Træner getTræner() {
        return træner;
    }

    public int getHoldNr() {
        return holdNr;
    }

    public ArrayList<KonkurrenceResultat> getKonkurrenceResultater() {
        return konkurrenceResultater;
    }
}
