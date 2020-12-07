package DelfinAdmin;


/**
 * @author Emma
 */

public class KonkurrenceResultat {
    private String konkurrenceNavn;
    private String disciplin;
    private int rangering;
    private double tidISekunder;


    KonkurrenceResultat(String konkurrenceNavn, String disciplin, int rangering, double tidISekunder) {
        this.konkurrenceNavn = konkurrenceNavn;
        this.disciplin = disciplin;
        this.rangering = rangering;
        this.tidISekunder = tidISekunder;
    }

    public String getKonkurrenceNavn() {
        return konkurrenceNavn;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public int getRangering() {
        return rangering;
    }

    public double getTidISekunder() {
        return tidISekunder;
    }
}
