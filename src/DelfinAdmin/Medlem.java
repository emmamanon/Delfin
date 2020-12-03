package DelfinAdmin;

/**
 * @author Samavia
 */
public class Medlem {

    private int ID;
    private String navn;
    private int alder;
    private boolean aktivStatus;
    private boolean junior;
    private boolean konkurrenceSvømmer;
    private double kontingentsats;
    private boolean kontingentPayed;
    private final double KONTINGENTSATS_PASSIV = 500.0;
    private final double KONTINGENTSATS_JUNIOR = 1000.0;
    private final double KONTINGENTSATS_SENIOR = 1600.0;
    private final double SENIOR_RABAT = 0.75 * KONTINGENTSATS_SENIOR;



    Medlem() {
        super();
    }

    Medlem(String navn, int ID, int alder, boolean aktivStatus, boolean konkurrenceSvømmer, boolean kontingentPayed) {


        //ID = 1;
        this.ID = ID;
        this.navn = navn;
        this.alder = alder;
        this.aktivStatus = aktivStatus;
        junior = (alder < 18);
        this.konkurrenceSvømmer = konkurrenceSvømmer;
        this.kontingentPayed = kontingentPayed;


        if (!aktivStatus)
            kontingentsats = KONTINGENTSATS_PASSIV;
        else if (junior)
            kontingentsats = KONTINGENTSATS_JUNIOR;
        else if (alder > 60)
            kontingentsats = SENIOR_RABAT;
        else
            kontingentsats = KONTINGENTSATS_SENIOR;

        kontingentPayed = false;
    }





    public int getID() {
        return ID;
    }

    public String getNavn() {
        return navn;
    }

    public boolean isAktivStatus() {
        return aktivStatus;
    }

    public boolean isKonkurrenceSvømmer() {
        return konkurrenceSvømmer;
    }

    public int getAlder() {
        return alder;
    }

    public boolean isKontingentPayed() {
        return kontingentPayed;
    }
    public void setKontingentPayed(boolean bool) {
        kontingentPayed = bool;
    }

    public double getKontingentsats() {
        return kontingentsats;
    }
}



