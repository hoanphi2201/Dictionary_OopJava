/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ver_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author phixuanhoan
 */
public class dictionary {

    public static final int FILE_OPEN = 1;
    public static final int FILE_SAVE = 2;
    private static boolean change = false;
    
    myConnect myconnect = new myConnect();
    // Thuộc tính của lớp dictionary
    public static ArrayList<newWord> listWord = new ArrayList();
    private int totalWord;

    public int getTotalWord() {
        return totalWord;
    }

    public void setTotalWord(int totalWord) {
        this.totalWord = totalWord;
    }

    public boolean existWord(String word) {
        for (int i = 0; i < listWord.size(); i++) {
            if (listWord.get(i).getSpelling().equals(word)) {
                return true; // đã tồn tại
            }
        }
        return false;

    }
    public void loadData() {
        myconnect.getData();
    }
    public void insertData(newWord word){
        myconnect.insertData(word.getId(),word.getSpelling(), word.getExplain(),
                  word.getTranscription(), word.getExample(),word.getExlainExample());
    }
     public void updateData(newWord word){
        myconnect.updateData(word.getId(),word.getSpelling(), word.getExplain(),
                  word.getTranscription(), word.getExample(),word.getExlainExample());
    }
     public void deleteData(int id){
         myconnect.deleteData(id);
     }
}
