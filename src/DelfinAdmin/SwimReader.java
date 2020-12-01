package DelfinAdmin;

import java.io.File;
import java.io.FileNotFoundException;
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


    SwimReader() {
        super();
    }

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

        try {
            fileReader1 = new Scanner(file1);
            fileReader2 = new Scanner(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        while (fileReader1.hasNext()) {
            int id = Integer.parseInt(fileReader1.nextLine());
            String navn = fileReader1.nextLine();
            int alder = Integer.parseInt(fileReader1.nextLine());
            boolean aktivStatus = Boolean.parseBoolean(fileReader1.nextLine());
            boolean konkurrenceSvømmer = Boolean.parseBoolean(fileReader1.nextLine());

            medlemsListe.add(new Medlem(navn, id, alder, aktivStatus, konkurrenceSvømmer));

        }

        while (fileReader2.hasNext()) {
            String testHelp = fileReader2.nextLine();
            int id = Integer.parseInt(fileReader2.nextLine());
            String navn = fileReader2.nextLine();
            int alder = Integer.parseInt(fileReader2.nextLine());
            boolean aktivStatus = Boolean.parseBoolean(fileReader2.nextLine());
            boolean konkurrenceSvømmer = Boolean.parseBoolean(fileReader2.nextLine());
            Træner træner = new Træner(fileReader2.nextLine());
            String[] svømmeDisciplinerOgTiderArray = fileReader2.nextLine().split(",");
            ArrayList<SvømmeDisciplin> svømmeDisciplinerOgTiderArrayList = new ArrayList<>();

            if (svømmeDisciplinerOgTiderArray.length < 1) {
                svømmeDisciplinerOgTiderArrayList.add(new SvømmeDisciplin());
            } else {

                int j = 1;
                for (int i = 0; i < svømmeDisciplinerOgTiderArray.length - 1; i += 2) {


                    svømmeDisciplinerOgTiderArrayList.add(new SvømmeDisciplin(svømmeDisciplinerOgTiderArray[i]
                            , Double.parseDouble(svømmeDisciplinerOgTiderArray[j])));

                    j += 2;
                }
            }
            int holdNr = (alder < 18 ? 2 : 1);

            String[] konkurrenceResultaterArray = fileReader2.nextLine().split(",");
            ArrayList<KonkurrenceResultat> konkurrenceResultaterArrayList = new ArrayList<>();

            if (konkurrenceResultaterArray.length < 1) {
                konkurrenceResultaterArrayList.add(new KonkurrenceResultat());
            } else {

                int k = 1;
                int l = 2;
                int m = 3;
                for (int i = 0; i < konkurrenceResultaterArray.length - 3; i += 4) {

                    konkurrenceResultaterArrayList.add(new KonkurrenceResultat(konkurrenceResultaterArray[i],
                            konkurrenceResultaterArray[k], Integer.parseInt(konkurrenceResultaterArray[l]),
                            Double.parseDouble(konkurrenceResultaterArray[m])));

                    k += 4;
                    l += 4;
                    m += 4;

                }
            }
            medlemsListe.add(new KonkurrenceSvømmer(navn, id, alder, aktivStatus, konkurrenceSvømmer, træner,
                    svømmeDisciplinerOgTiderArrayList, holdNr, konkurrenceResultaterArrayList));

        }

        return medlemsListe;
    }


    void WriteToFilesHelper(ArrayList<Medlem> medlemmer) {

    }

    void writeToFiles(ArrayList<Medlem> medlemmer) {

        file1 = new File("SwimClubMembers.txt");
        file2 = new File("SwimClubMembersCompetition.txt");


        try {
            fileWriter1 = new FileWriter(file1);
            fileWriter2 = new FileWriter(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Medlem element : medlemmer) {
            int id = element.getID();
            String navn = element.getNavn();
            int alder = element.getAlder();
            boolean aktivStatus = element.isAktivStatus();
            boolean konkurrenceSvømmer = element.isKonkurrenceSvømmer();
            if (element instanceof KonkurrenceSvømmer) {
                Træner træner = ((KonkurrenceSvømmer) element).getTræner();
                ArrayList<SvømmeDisciplin> svømmeDiscipliner =
                        ((KonkurrenceSvømmer) element).getSvømmediscipliner();
                int holdNr = ((KonkurrenceSvømmer) element).getHoldNr();
                ArrayList<KonkurrenceResultat> konkurrenceResultater =
                        ((KonkurrenceSvømmer) element).getKonkurrenceResultater();

                try {
                    fileWriter2.write("\n");
                    fileWriter2.write(String.valueOf(id) + "\n");
                    fileWriter2.write(navn + "\n");
                    fileWriter2.write(String.valueOf(alder) + "\n");
                    fileWriter2.write(String.valueOf(aktivStatus) + "\n");
                    fileWriter2.write(String.valueOf(konkurrenceSvømmer) + "\n");
                    fileWriter2.write(træner.getName() + "\n");
                    if (svømmeDiscipliner.size() < 1) {
                        fileWriter2.write("\n" );
                    } else {
                        for (SvømmeDisciplin svømmeDisciplin : svømmeDiscipliner) {
                            fileWriter2.write(svømmeDisciplin.getNavn() + "," +
                                    svømmeDisciplin.getTidISekunder() + ",");
                        }
                        fileWriter2.write("\n");
                    }

                    fileWriter2.write(String.valueOf(holdNr));
                    if (konkurrenceResultater.size() < 1) {
                        fileWriter2.write ( "\n");
                    } else {
                        for (KonkurrenceResultat konkurrenceResultat : konkurrenceResultater) {
                            fileWriter2.write(konkurrenceResultat.getKonkurrenceNavn() + "," +
                                    konkurrenceResultat.getDisciplin() + "," + konkurrenceResultat.getRangering() + "," +
                                    konkurrenceResultat.getTidISekunder() + ",");
                        }
                        fileWriter2.write("" + "\n");
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

                try {
                    fileWriter1.write(id + "\n");
                    fileWriter1.write(navn + "\n");
                    fileWriter1.write(alder + "\n");
                    fileWriter1.write(aktivStatus + "\n");
                    fileWriter1.write(konkurrenceSvømmer + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        try {
            fileWriter1.flush();
            fileWriter2.flush();
            fileWriter1.close();
            fileWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
