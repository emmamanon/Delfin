package Test;

import DelfinAdmin.Main;
import DelfinAdmin.Medlem;
import DelfinAdmin.SwimReader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void searchMembersByNameTEST() {

        // Arrange

        SwimReader swimReader = new SwimReader();
        ArrayList<Medlem> alleMedlemmer = swimReader.loadMedlemmer();
        Main main = new Main();


        String name1 = "Gunnar Bjerre";
        String name2 = "Lolat Lolat";
        String name3 = "Marc Pless";

        // Act
        var result1 = main.searchMembersByNameTEST(name1, alleMedlemmer);
        var result2 = main.searchMembersByNameTEST(name2, alleMedlemmer);
        var result3 = main.searchMembersByNameTEST(name3, alleMedlemmer);

        // Assert

        assertEquals(-1,result1);
        assertEquals(-1, result2);
        assertEquals(-1, result3);





    }
}