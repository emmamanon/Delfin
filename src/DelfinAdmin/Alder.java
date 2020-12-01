package DelfinAdmin;

import java.time.LocalDate;
import java.time.Period;

public class Alder {
    private LocalDate birthday;
    private int ageNow;


    Alder(LocalDate birthday){
        LocalDate now;

        this.birthday = birthday;
        now = LocalDate.now();

        Period difference = Period.between(birthday, now);

        ageNow = difference.getYears();

    }

    public int getAgeNow() {
        return ageNow;
    }
}
