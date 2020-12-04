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

    String tidTilString(double tidISek) {
        String tidISekString = String.valueOf(tidISek);

        int min = (int) tidISek / 60;
        int sek = (int) tidISek % 60;



        String format = String.format("%d Minutter, %d Sekunder", min, sek);

        return format;



    }

    public int numOfMedals() {
        int sum = 0;
        for (KonkurrenceResultat element : konkurrenceResultater) {
            if (element.getRangering() == 1 || element.getRangering() == 2 || element.getRangering() == 3) {
                sum++;
            }

        }
        return sum;
    }

    public String toString() {
        String toString = String.format("Id: #%d\nNavn: %s\nAlder: %d\nAntal medaljer: %d\n",
                super.getID(), super.getNavn(), super.getAlder(), numOfMedals());

        for (SvømmeDisciplin svømmeDisciplin : svømmediscipliner) {
            toString += String.format("Tid: %s\n",
                    tidTilString(svømmeDisciplin.getTidISekunder()));
        }
        return toString;
    }


}



