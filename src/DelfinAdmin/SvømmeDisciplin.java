package DelfinAdmin;

public class SvømmeDisciplin {
    //For at lave top 5 giver det mere kodemæssigt mening at lave tid om til double
    private String navn;
    private Medlem medlem;
    private double tidISekunder;


    SvømmeDisciplin(){

    }

    SvømmeDisciplin(String navn, double tidISekunder) {
        this.navn = navn;
        this.tidISekunder = tidISekunder;
    }


    public String getNavn() {
        return navn;
    }
    public Medlem getMedlem() {
        return medlem;
    }

    public double getTidISekunder() {
        return tidISekunder;
    }

    SvømmeDisciplin crawl(String navn, Medlem medlem, double tidISekunder) {
        this.navn = navn;
        this.medlem = medlem;
        this.tidISekunder = tidISekunder;
        return null;
    }

    SvømmeDisciplin butterfly(String navn, Medlem medlem, double tidISekunder) {
        this.navn = navn;
        this.medlem = medlem;
        this.tidISekunder = tidISekunder;
        return null;
    }


    SvømmeDisciplin rygCrawl(String navn, Medlem medlem, double tidISekunder) {
        this.navn = navn;
        this.medlem = medlem;
        this.tidISekunder = tidISekunder;
        return null;
    }

    SvømmeDisciplin brystSvømning(String navn, Medlem medlem, double tidISekunder) {
        this.navn = navn;
        this.medlem = medlem;
        this.tidISekunder = tidISekunder;
        return null;
    }


    SvømmeDisciplin hundeSvømning(String navn, Medlem medlem, double tidISekunder) {
        this.navn = navn;
        this.medlem = medlem;
        this.tidISekunder = tidISekunder;
        return null;
    }
}