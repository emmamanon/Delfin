package DelfinAdmin;

import java.util.ArrayList;

/**
 * @author Emma
 */
public class KonkurrenceSvømmer extends Medlem {
    private Træner træner;
    private ArrayList<SvømmeDisciplin> svømmediscipliner;
    private int holdNr;
    private ArrayList<KonkurrenceResultat> konkurrenceResultater;


    KonkurrenceSvømmer(String navn, int ID, int alder, boolean aktivStatus, boolean konkurrenceSvømmer,
                       boolean kontingentPayed) {
        super(navn, ID, alder, aktivStatus, konkurrenceSvømmer, kontingentPayed);
    }

    KonkurrenceSvømmer(String navn, int ID, int alder, boolean aktivStatus, boolean konkurrenceSvømmer,
                       boolean kontingentPayed, Træner træner,
                       ArrayList<SvømmeDisciplin> svømmediscipliner
                       , ArrayList<KonkurrenceResultat> konkurrenceResultater) {

        super(navn, ID, alder, aktivStatus, konkurrenceSvømmer, kontingentPayed);
        this.træner = træner;
        this.svømmediscipliner = svømmediscipliner;
        holdNr = (super.isJunior() ? 2 : 1);
        this.konkurrenceResultater = konkurrenceResultater;
    }

    public Træner getTræner() {
        return træner;
    }

    public void setTræner(Træner træner) {
        this.træner = træner;
    }

    public ArrayList<SvømmeDisciplin> getSvømmediscipliner() {
        return svømmediscipliner;
    }

    public void setSvømmediscipliner(ArrayList<SvømmeDisciplin> svømmediscipliner) {
        this.svømmediscipliner = svømmediscipliner;
    }

    public int getHoldNr() {
        return holdNr;
    }

    public void setHoldNr(int holdNr) {
        this.holdNr = holdNr;
    }

    public ArrayList<KonkurrenceResultat> getKonkurrenceResultater() {
        return konkurrenceResultater;
    }

    public void setKonkurrenceResultater(ArrayList<KonkurrenceResultat> konkurrenceResultater) {
        this.konkurrenceResultater = konkurrenceResultater;
    }
}



