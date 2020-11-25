package DelfinAdmin;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {

    private ArrayList<Medlem> medlemArray;
    void  run() {
        GeneriskMenu menu = new GeneriskMenu("DelfinAdmin", "Vælg menupunkt: ",
                new String[]{"1. Tilføj nyt medlem", "2. Indtast bestilling", "3. Vis bestillingskø",
                        "4. Næste ordre", "5. Færdiggør ordre", "6. Statistik menu",  "9. Exit"});

        while (true) {

            menu.printGeneriskMenu();
            int choice = menu.readChoice();

            switch (choice) {

                case 1: //Add new member
                    Scanner scanner = new Scanner(System.in);
                    int id = medlemArray.size()+1;
                    boolean aktivstatus = true;
                    boolean konkurrenceSvømmer = true;
                    String option_input;
                    System.out.println("Indtast navn:");
                    String navn = scanner.next();
                    System.out.println("Indtast alder:");
                    int alder = scanner.nextInt();
                    System.out.println("Indtast Y/N for aktiv status");
                    option_input = scanner.next();

                    if (option_input.equals('Y'))
                    {
                        aktivstatus = true;
                    }
                    else if(option_input.equals('N'))
                    {
                        aktivstatus = false;
                    }
                    System.out.println("Indtast Y/N for konkurrence svømmer");
                    option_input = scanner.next();

                    if (option_input.equals('Y'))
                    {
                        konkurrenceSvømmer = true;
                    }
                    else if(option_input.equals('N'))
                    {
                        konkurrenceSvømmer = false;
                    }
                    Medlem medlem = new Medlem(navn, id, alder, aktivstatus, konkurrenceSvømmer);
                    medlemArray.add(medlem);


                case 2:

                case 3:

                case 4:

                case 5:

                case 6:

                case 9:

                    return;

            }

        }
    }

    public static void main(String[] args) {
        Main m = new Main(); //Hvorfor skal jeg lave instance
        m.medlemArray = new ArrayList<Medlem>(); //Arraylisten få sig en objekt
        m.run();
        try {
            FileWriter virkNu = new FileWriter("filename.txt");
            int ID;
            String navn;
            int alder;
            boolean aktivStatus;
            boolean konkurrenceSvømmer;
            String line;
            for (int i = 0; i < m.medlemArray.size(); i++)
            {
                ID = m.medlemArray.get(i).getID();
                navn = m.medlemArray.get(i).getNavn();
                alder = m.medlemArray.get(i).getAlder();
                aktivStatus = m.medlemArray.get(i).isAktivStatus(); // skal de være med?
                konkurrenceSvømmer = m.medlemArray.get(i).isKonkurrenceSvømmer(); // skal de være med?
                line = Integer.toString(ID) +" "+ navn +" "+ Integer.toString(alder) +" "+ Boolean.toString(aktivStatus)
                        +" "+ Boolean.toString(konkurrenceSvømmer)+ "\n";
                virkNu.write(line);

            }
            virkNu.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
