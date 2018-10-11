package dic.commandline;

/**
 *
 * @author Nguyễn Giang
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {

    private Scanner sc = new Scanner(System.in);
    private static final String fileName = "dictionaries.txt";

    //Function showAllWords
    public void showAllWords() {
        if (!Dictionary.listWord.isEmpty()) {
            System.out.printf("%-4s%c%-20s%c%-20s\n", "STT", '|', "English", '|', "Vietnamese");
            int i = 1;
            for (Word ele : Dictionary.listWord) {
                System.out.printf("%-5d", i);
                ele.printWord();
                i++;
            }
        }
    }

    //Function insertFromCommandline
    public void insertFromCommandline() {
        System.out.println("---------Add word to dictionary---------");
        System.out.print("Input number of word to add: ");
        String num = null;
        boolean ktra = false;
        while (!ktra) {
            try {
                num = sc.next();
                Integer.parseInt(num);
                ktra = true;
            } catch (NumberFormatException e) {
                System.out.println("It's not a number. Try again: ");

                //num = sc.next();
            }
        }
        sc.nextLine();
        for (int i = 0; i < Integer.parseInt(num); i++) {
            System.out.print("Input word target: ");
            String spel = sc.nextLine();
            boolean check = false;
            for (Word ele : Dictionary.listWord) {
                if (ele.getWord_taget().equals(spel.trim())) {
                    System.out.println("Word '" + spel + "' has exist in dictionary!! Input again...");
                    check = true;
                    i--;
                    break;
                }
            }

            if (!check) {
                System.out.print("Input Vietnamese explain: ");
                String expl = sc.nextLine();
                Dictionary.listWord.add(new Word(spel, expl));
            }

        }
        System.out.println("Add successful " + num + " words to dictionary!");
    }

    public void insertFromFile() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            String line = br.readLine();;

            while (line != null) {

                if (line.indexOf("\t") == -1) {
                    line = br.readLine();
                    continue;
                }
                Word w = new Word(line);
                Dictionary.listWord.add(w);
                line = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }

    public void dictionaryLookup() {
        System.out.println("-----------LOOK UP------------");
        System.out.print("Enter word: ");
        String wordLookup = sc.nextLine();
        for (Word ele : Dictionary.listWord) {
            if (ele.getWord_taget().equals(wordLookup)) {
                System.out.println("Lookup Success!");
                System.out.print("Your word is: ");
                ele.printWord();
                return;
            }
        }
        System.out.println("Word Not Found!");
    }

    public void dictionarySearcher() {
        sc = new Scanner(System.in);
        System.out.println("----Search relative----");
        System.out.print("Input word: ");
        String wordSearch = sc.nextLine();
        ArrayList<Word> listWordSearch = new ArrayList<>();
        for (Word ele : Dictionary.listWord) {
            if (ele.getWord_taget().indexOf(wordSearch) == 0) {
                listWordSearch.add(ele);
            }
        }

        if (listWordSearch.isEmpty()) {
            System.out.println("Not exist in dictionary !!!");
        } else {
            System.out.println("Words start with \"" + wordSearch + "\": ");
            int i = 1;
            for (Word ele
                    : listWordSearch) {
                System.out.printf("%-4d", i);
                ele.printWord();
                i++;
            }
        }
    }

    public void editWordInDic() {
        System.out.println("--------Edit word in dictionary--------");
        System.out.println("Input edit word: ");
        String editW = sc.nextLine();
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            if (Dictionary.listWord.get(i).getWord_taget().equals(editW)) {
                System.out.println("Found '" + editW + "' in dictionary!");
                System.out.print("Edit word target: ");
                String spel = sc.nextLine();
                System.out.print("Edit Vietnamese explain:");
                String expl = sc.nextLine();
                Dictionary.listWord.set(i, new Word(spel, expl));
                System.out.println("Edit successful!!");
                return;
            }
        }
        System.out.println("Not found: " + editW);
    }

    public void deleteWordInDic() {
        System.out.println("--------Delete word in dictionary--------");
        System.out.println("Input delete word: ");
        String delW = sc.nextLine();
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            if (Dictionary.listWord.get(i).getWord_taget().equals(delW)) {
                System.out.println("Found " + delW + " in dictionary!");
                System.out.println("Do you want to delete '" + delW + "' ? (Y/N)?");
                char option = sc.next().charAt(0);
                if (option == 'Y' || option == 'y') {
                    Dictionary.listWord.remove(i);
                    System.out.println("Delete successful!!");
                } else if (option == 'N' || option == 'n') {
                    System.out.println("Delete failed!!");
                } else {
                    System.out.println("Lỗi");
                }
                return;
            }
        }
        System.out.println("Not found: " + delW);
    }

    public void dictionaryExportToFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (Word ele : Dictionary.listWord) {
                bw.write(ele.getWord_taget() + "\t" + ele.getWord_explain());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }

}
