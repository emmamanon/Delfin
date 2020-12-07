package DelfinAdmin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public int numOfMedals(String disciplin) {
        int sum = 0;
        for (KonkurrenceResultat element : konkurrenceResultater) {
            if (element.getDisciplin().equalsIgnoreCase(disciplin)) {
                if (element.getRangering() == 1 || element.getRangering() == 2 || element.getRangering() == 3) {
                    sum++;
                }
            }
        }
        return sum;
    }

    ArrayList<SvømmeDisciplin> sortAfterFastestTime(ArrayList<SvømmeDisciplin> helpArray) {

        for (int i = 0; i < helpArray.size() - 1; i++) {
            for (int j = 0; j < helpArray.size() - 1; j++) {
                if (helpArray.get(j).getTidISekunder() > helpArray.get(j + 1).getTidISekunder()) {
                    Collections.swap(helpArray, j, j + 1);
                }
            }
        }
        return helpArray;
    }

    public double allTimePersonalBest(String discipline) {
        double personalBest = 10000;
        for (SvømmeDisciplin svømmeDisciplin : svømmediscipliner) {
            if (svømmeDisciplin.getNavn().equalsIgnoreCase(discipline)) {
                if (svømmeDisciplin.getTidISekunder() < personalBest) {
                    personalBest = svømmeDisciplin.getTidISekunder();
                }
            }
        }
        for (KonkurrenceResultat konkurrenceResultat : konkurrenceResultater) {
            if (konkurrenceResultat.getDisciplin().equalsIgnoreCase(discipline)) {
                if (konkurrenceResultat.getTidISekunder() < personalBest) {
                    personalBest = konkurrenceResultat.getTidISekunder();
                }
            }
        }
        return personalBest;
    }





    public String toString(String disciplin) {


        String toString = String.format("Id: #%d\nNavn: %s\nAlder: %d\nPersonligt bedste i disciplinen: %s" +
                        "\nAntal medaljer i disciplinen: %d\nRegistrerede træningsresultater:\n",
                super.getID(), super.getNavn(), super.getAlder(),
                tidTilString(allTimePersonalBest(disciplin)), numOfMedals(disciplin));

        sortAfterFastestTime(svømmediscipliner);


        for (SvømmeDisciplin svømmeDisciplin : svømmediscipliner) {
            if (svømmeDisciplin.getNavn().equalsIgnoreCase(disciplin)) {
                toString += String.format("Tid: %s\nDato sat: %s\n",
                        tidTilString(svømmeDisciplin.getTidISekunder()), svømmeDisciplin.getDatoSat());
            }
        }
        return toString;
    }



}



