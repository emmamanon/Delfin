package DelfinAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Samavia og Marc
 */

public class SwimReader {
    private File file1;
    private File file2;
    private FileWriter fileWriter1;
    private FileWriter fileWriter2;
    private Scanner fileReader1;
    private Scanner fileReader2;


    public SwimReader() {
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

    public ArrayList<Medlem> loadMedlemmer() {
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
            boolean kontingentPayed = Boolean.parseBoolean((fileReader1.nextLine()));

            medlemsListe.add(new Medlem(navn, id, alder, aktivStatus, konkurrenceSvømmer, kontingentPayed));

        }

        while (fileReader2.hasNext()) {
            String help = fileReader2.nextLine();
            int id = Integer.parseInt(fileReader2.nextLine());
            String navn = fileReader2.nextLine();
            int alder = Integer.parseInt(fileReader2.nextLine());
            boolean aktivStatus = Boolean.parseBoolean(fileReader2.nextLine());
            boolean konkurrenceSvømmer = Boolean.parseBoolean(fileReader2.nextLine());
            boolean kontingentPayed = Boolean.parseBoolean(fileReader2.nextLine());
            Træner træner = new Træner(fileReader2.nextLine());
            String[] svømmeDisciplinerOgTiderArray = fileReader2.nextLine().split(",");
            ArrayList<SvømmeDisciplin> svømmeDisciplinerOgTiderArrayList = new ArrayList<>();
            String[] konkurrenceResultaterArray = fileReader2.nextLine().split(",");
            ArrayList<KonkurrenceResultat> konkurrenceResultaterArrayList = new ArrayList<>();

            if (svømmeDisciplinerOgTiderArray.length < 2) {

            } else {

                int j = 1;
                for (int i = 0; i < svømmeDisciplinerOgTiderArray.length - 1; i += 2) {


                    svømmeDisciplinerOgTiderArrayList.add(new SvømmeDisciplin(svømmeDisciplinerOgTiderArray[i]
                            , Double.parseDouble(svømmeDisciplinerOgTiderArray[j])));

                    j += 2;
                }
            }

            if (konkurrenceResultaterArray.length < 4) {

            } else {


                int k = 1;
                int l = 2;
                int m = 3;
                for (int i = 0; i < konkurrenceResultaterArray.length - 3; i+=4) {

                    String name = konkurrenceResultaterArray[i];
                    String disciplin = konkurrenceResultaterArray[k];
                    int rank = Integer.parseInt(konkurrenceResultaterArray[l]);
                    double swimTime = Double.parseDouble(konkurrenceResultaterArray[m]);

                    KonkurrenceResultat konkurrenceResultat = new KonkurrenceResultat(name, disciplin, rank, swimTime);
                    konkurrenceResultaterArrayList.add(konkurrenceResultat);

                    k += 4;
                    l += 4;
                    m += 4;

                }

            }
            medlemsListe.add(new KonkurrenceSvømmer(navn, id, alder, aktivStatus, konkurrenceSvømmer, kontingentPayed,
                    træner, svømmeDisciplinerOgTiderArrayList, konkurrenceResultaterArrayList));

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
            boolean kontigentPayed = element.isKontingentPayed();
            if (element instanceof KonkurrenceSvømmer) {
                Træner træner = ((KonkurrenceSvømmer) element).getTræner();
                ArrayList<SvømmeDisciplin> svømmeDiscipliner =
                        ((KonkurrenceSvømmer) element).getSvømmediscipliner();
                ArrayList<KonkurrenceResultat> konkurrenceResultater =
                        ((KonkurrenceSvømmer) element).getKonkurrenceResultater();

                try {
                    fileWriter2.write("\n");
                    fileWriter2.write(id + "\n");
                    fileWriter2.write(navn + "\n");
                    fileWriter2.write(alder + "\n");
                    fileWriter2.write(aktivStatus + "\n");
                    fileWriter2.write(konkurrenceSvømmer + "\n");
                    fileWriter2.write(kontigentPayed + "\n");
                    fileWriter2.write(træner.getName() + "\n");
                    if (svømmeDiscipliner.size() < 1) {
                        fileWriter2.write("\n");

                    } else {
                        for (SvømmeDisciplin svømmeDisciplin : svømmeDiscipliner) {
                            fileWriter2.write(svømmeDisciplin.getNavn() + "," +
                                    svømmeDisciplin.getTidISekunder() + ",");
                        }
                        fileWriter2.write("\n");
                    }
                    if (konkurrenceResultater.size() < 1) {
                        fileWriter2.write("\n");

                    } else {
                        for (KonkurrenceResultat konkurrenceResultat : konkurrenceResultater) {
                            fileWriter2.write(konkurrenceResultat.getKonkurrenceNavn() + "," +
                                    konkurrenceResultat.getDisciplin() + "," + konkurrenceResultat.getRangering() + "," +
                                    konkurrenceResultat.getTidISekunder() + ",");
                        }
                        fileWriter2.write("\n");
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
                    fileWriter1.write(kontigentPayed + "\n");
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
