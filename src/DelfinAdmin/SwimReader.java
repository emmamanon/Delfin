package DelfinAdmin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SwimReader {
    private File file1;
    private File file2;
    private FileWriter fileWriter1;
    private FileWriter fileWriter2;
    private Scanner fileReader1;
    private Scanner fileReader2;


    SwimReader(File file1, File file2) {
        this.file1 = file1;
        this.file2 = file2;

        try {
            fileWriter1 = new FileWriter(file1);
            fileReader1 = new Scanner(file1);
            fileWriter2 = new FileWriter(file2);
            fileReader2 = new Scanner(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<Medlem> loadMedlemmer() {
        ArrayList<Medlem> medlemsListe = new ArrayList<>();

        file1 = new File("SwimClubMembers.txt");
        file2 = new File("SwimClubMembersCompetition.txt");


        while (fileReader1.hasNext()) {
            String navn = fileReader1.nextLine();
            int alder = Integer.parseInt(fileReader1.nextLine());
            boolean aktivStatus = Boolean.parseBoolean(fileReader1.nextLine());
            boolean konkurrenceSvømmer = Boolean.parseBoolean(fileReader1.nextLine());

            medlemsListe.add(new Medlem(navn, alder, aktivStatus, konkurrenceSvømmer));

        }

        while (fileReader2.hasNext()) {

            String navn = fileReader2.nextLine();
            int alder = Integer.parseInt(fileReader2.nextLine());
            boolean aktivStatus = Boolean.parseBoolean(fileReader2.nextLine());
            boolean konkurrenceSvømmer = Boolean.parseBoolean(fileReader2.nextLine());
            Træner træner = new Træner(fileReader2.nextLine());


        }




    }


}
