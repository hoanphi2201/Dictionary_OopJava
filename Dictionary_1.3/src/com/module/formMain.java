package com.module;

import com.app.DictionaryManagement;
import com.app.Word;
import com.app.topic;
import com.darkprograms.speech.synthesiser.Synthesiser;
import com.darkprograms.speech.translator.GoogleTranslate;
import com.libs.PlaceholderTextField;
import com.libs.TextBubbleBorder;
import com.model.myConnect;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.AbstractBorder;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author phixuanhoan
 */
public final class formMain extends javax.swing.JFrame {

    public static DictionaryManagement dictionaryManagement = new DictionaryManagement();   // Object DictionaryManagement
    private PlaceholderTextField txtSearch  = new PlaceholderTextField("");                 // Object textField
    public static Synthesiser Synthesiser   = new Synthesiser();                            // Object Synthesiser
    private DefaultListModel dlmWord        = new DefaultListModel();                       // DefaultListModel
    public static AbstractBorder brdr_b     = new TextBubbleBorder(Color.PINK, 1, 16, 0);   // Border big
    public static AbstractBorder brdr_s     = new TextBubbleBorder(Color.PINK, 1, 10, 0);   // Border small
    public static myConnect myConnect       = new myConnect();                              // MyConnect to database
    private JList listWordHistoryViews;                     // Object JList (History)
    private DefaultListModel dlmHistory;                    // Object Model JList (History)
    private JScrollPane scroll;                             // Object JScrollPane (History)
    private int numWordOfList       = 23;                   // Number word of list view
    private String pathTopicImage   = "public/images_topic/";      // Path topic image
    private String pathHistory = "public/history.txt";             // path history file
    private String targetLanguage   = "en";                 // Target language
    private int indexHienTai        = 1;                    // Index now scroll list view
    private int ClickSwap           = 0;                    // Swap language (vi - en)
    private int countClickDown      = 0;                    // Click down list
    private int countClickUp        = 0;                    // Click up list
    private boolean typeSearch      = true;                 // (int) Type seach (true: tuong doi)
    private int indexEditSelected;                          // Index selected edit
    private String process;                                 // Type process (Add | Edit)
    public static String selectedWordEdit;                  // (String) Type seach (true: tuong doi)
    public static Timer timer;                              // Timer process after add | edit
    private JLabel[][] iconTopic;                           // Image icon topic
    private JButton[][] buttonTopic;                        // Button topic
    public static topic topic = new topic();                // Object topic    
    private int start = 0;                                  // Start of page topic   
    private String typeUser;                                // type user (admin | member)
    private String fullname;                                // Fullname user
    private String mode = "normal";                         // Mode 

    /**
     * Creates new form mainForm
     * @param typeUser
     * @param fullname
     */
    @SuppressWarnings("empty-statement")
    public formMain(String typeUser, String fullname) {
        this.typeUser = typeUser;
        this.fullname = fullname;
        initComponents();
        this.setLocationRelativeTo(null);
        //SET BORDER
        listWordViews.setBorder(brdr_b);
        areaInfoWord.setBorder(brdr_b);
        areaText1.setBorder(brdr_b);
        areaText2.setBorder(brdr_b);
        lblInfoWord.setBorder(brdr_s);
        jLabel11.setBorder(brdr_s);
        lblText1.setBorder(brdr_s);
        lblText2.setBorder(brdr_s);
        jLabel1.setIcon(getIconButton("public/", "exit", "png", 30, 30));

        //SET TEXT AREA LINEWRAP 
        areaInfoWord.setLineWrap(true);
        areaInfoWord.setWrapStyleWord(true);
        areaInfoWord.setEditable(false);
        areaText1.setLineWrap(true);
        areaText1.setWrapStyleWord(true);
        areaText2.setLineWrap(true);
        areaText2.setWrapStyleWord(true);
        lblTotalWord.setText("Tổng số từ: " + myConnect.countWordInDatabase());
        
        // LOAD DATA CONSTRUCTOR
        myConnect.getData(1, numWordOfList);
        showAllWord();
        btnHome.setEnabled(false);
        //  SET BUTTON FOR USER 
        if (typeUser.equals("admin")) {
            setEnableButton(true);
        } else if (typeUser.equals("member")){
            setEnableButton(false);
        }

        // CREATE TEXT FIELD SEARCH
        txtSearch.setPlaceholder("Nhập từ muốn tìm kiếm !");
        final Font f = txtSearch.getFont();
        txtSearch.setFont(new Font(f.getName(), f.getStyle(), 15));
        txtSearch.setLocation(33, lblInfoWord.getLocation().y);
        txtSearch.setSize(275, 35);
        jPanel1.add(txtSearch);
        txtSearch.setBorder(brdr_s);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        // TIMER ADD | EDIT
        timer = new Timer(10, (ActionEvent e) -> {
            scrollValueSet(indexEditSelected, process);
        });
        //PANEL HOCTUVUNG
        myConnect.getAllTopic();
        iconTopic = new JLabel[2][4];
        buttonTopic = new JButton[2][4];
        int index = start;
        int sizeImageTopic = 163;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                // image
                iconTopic[i][j] = new JLabel();
                iconTopic[i][j].setSize(sizeImageTopic, sizeImageTopic);
                iconTopic[i][j].setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1f)));;
                iconTopic[i][j].setLocation(j * sizeImageTopic + 55 * j + 35, i * sizeImageTopic + i * 80 + 20);
                iconTopic[i][j].setIcon(getIconButton(pathTopicImage,topic.listTopic.get(index).getTopicName().trim(),"jpg", sizeImageTopic, sizeImageTopic));
                jPanel2.add(iconTopic[i][j]);
                //button
                buttonTopic[i][j] = new JButton();
                buttonTopic[i][j].setSize(sizeImageTopic, 35);
                buttonTopic[i][j].setLocation(iconTopic[i][j].getLocation().x, iconTopic[i][j].getLocation().y + sizeImageTopic + 15);
                buttonTopic[i][j].setText(topic.listTopic.get(index).getId() + ": " + topic.listTopic.get(index).getTopicName().trim());
                buttonTopic[i][j].setFont(new Font("Arial", Font.PLAIN, 14));
                buttonTopic[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                //event
                buttonTopic[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        mouseClickTopic(evt);
                    }
                });
                jPanel2.add(buttonTopic[i][j]);
                index++;
            }
        }
        
        // HISTORY
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(pathHistory), "UTF-8"));
            String line = br.readLine();;
            while (line != null) {
                if (!line.contains("\t")) {
                    line = br.readLine();
                    continue;
                }
                String word_taget = line.substring(0, line.indexOf("\t"));
                String word_explain = line.substring(line.indexOf("\t") + 1);
                Word w = new Word(word_taget, word_explain);
                dictionaryManagement.listWordHistory.add(w);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
           
        }
    }
    public void setEnableButton(boolean type){
        btnAdd.setVisible(type);
        btnEdit.setVisible(type);
        btnDelete.setVisible(type);
        jMenuItem4.setVisible(type);
        jMenuItem5.setVisible(type);
        jMenuItem6.setVisible(type);
    }
    public void mouseClickTopic(java.awt.event.MouseEvent evt) {
        String Topic = "";
        Object obj = (Object) evt.getSource();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (buttonTopic[i][j] == obj) {
                    Topic = buttonTopic[i][j].getText();
                    break;
                }
            }
        }
        loadForm(Topic);
    }

    public void loadForm(String btnText) {
        topic.listWordTopic.clear();
        String[] tmp = btnText.split(":");
        int topic_id = Integer.parseInt(tmp[0]);
        String topicName = tmp[1].trim();
        System.out.println(topic_id);
        System.out.println(topicName);
        myConnect.getWordByTopicID(topic_id);        
        if (topic.listWordTopic.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Danh sách trống !");
        } else {
            this.dispose();
            SwingUtilities.invokeLater(() -> {
                JFrame formHocTuVung = new formLearn(topicName, typeUser, fullname);
                formHocTuVung.setVisible(true);
            });
        }
    }

    /*
    * funtion return ImageIcon
     */
    public ImageIcon getIconButton(String path, String name, String type, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(path + name + "." + type);
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    /*
    * funtion load topic name
     */
    public void loadTopic() {
        int index = start;
        int sizeImageTopic = 163;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                String topicName = topic.listTopic.get(index).getTopicName().trim();
                iconTopic[i][j].setIcon(getIconButton(pathTopicImage , topicName, "jpg", sizeImageTopic, sizeImageTopic));
                buttonTopic[i][j].setText(topic.listTopic.get(index).getId() + ": " + topic.listTopic.get(index).getTopicName().trim());
                buttonTopic[i][j].setFont(new Font("Arial", Font.PLAIN, 14));
                index++;
            }
        }
    }
    /*
    * FUNCTION set index selected add & edit 
     */
    public void scrollValueSet(int index, String process) {
        timer.stop();
        if (process.equals("add")) {
            if(txtSearch.getText().equals("")){
                dictionaryManagement.listWord.clear();
                areaInfoWord.setText("");
                removeAllWord(false);
                myConnect.getData(indexHienTai, numWordOfList);
                showAllWord();
                listWordViews.setSelectedIndex(dlmWord.size() - 1);
                setTextAreaInfo(dictionaryManagement.listWord.get(dlmWord.size() - 1).getWord_target(), dictionaryManagement.listWord);
            }
            lblTotalWord.setText("Tổng số từ: " + myConnect.countWordInDatabase());
        } else if (process.equals("edit")) {
            dictionaryManagement.listWord.clear();
            areaInfoWord.setText("");
            removeAllWord(false);
            if (indexHienTai < numWordOfList) {
                if (txtSearch.getText().equals("")) {
                    myConnect.getData(indexHienTai, numWordOfList);
                    showAllWord();
                    listWordViews.setSelectedIndex(index);
                    setTextAreaInfo(dictionaryManagement.listWord.get(index).getWord_target(), dictionaryManagement.listWord);
                } else {
                    myConnect.seachKeyWord(selectedWordEdit, true);
                    showAllWord();
                    setTextAreaInfo(dictionaryManagement.listWord.get(0).getWord_explain(), dictionaryManagement.listWord);
                    for (int i = 0; i < dlmWord.size(); i++) {
                        if (dlmWord.get(i).equals(selectedWordEdit)) {
                            listWordViews.setSelectedIndex(i);
                            setTextAreaInfo(dictionaryManagement.listWord.get(i).getWord_target(), dictionaryManagement.listWord);
                            break;
                        }
                    }
                }
            } else {
                myConnect.getData(indexHienTai, numWordOfList);
                showAllWord();
                listWordViews.setSelectedIndex(index);
                setTextAreaInfo(dictionaryManagement.listWord.get(index).getWord_target(),dictionaryManagement.listWord);
            }

        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        areaInfoWord = new javax.swing.JTextArea();
        btnEdit = new javax.swing.JButton();
        btnRefesh = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        down = new javax.swing.JLabel();
        up = new javax.swing.JLabel();
        goLast = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        listWordViews = new javax.swing.JList<>();
        btnHistory = new javax.swing.JButton();
        lblTotalWord = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        iconSearch = new javax.swing.JLabel();
        lblInfoWord = new javax.swing.JLabel();
        btnAudio = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblText1 = new javax.swing.JLabel();
        lblText2 = new javax.swing.JLabel();
        btnSwap = new javax.swing.JButton();
        btnPhatAm1 = new javax.swing.JButton();
        btnPhatAm2 = new javax.swing.JButton();
        areaText1 = new javax.swing.JTextArea();
        areaText2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        lblFullnamex1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mnAuthor = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        lblFullnamex = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dictionary v1.3");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 34));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        areaInfoWord.setBackground(new java.awt.Color(204, 204, 255));
        areaInfoWord.setColumns(20);
        areaInfoWord.setRows(5);
        areaInfoWord.setToolTipText("InfoWord");
        areaInfoWord.setBorder(null);
        areaInfoWord.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel4.add(areaInfoWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 310, 470));

        btnEdit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/edit.png"))); // NOI18N
        btnEdit.setText("Sửa từ");
        btnEdit.setToolTipText("Edit");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel4.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 140, -1));

        btnRefesh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/load2.png"))); // NOI18N
        btnRefesh.setText("Làm mới");
        btnRefesh.setToolTipText("Refresh");
        btnRefesh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });
        jPanel4.add(btnRefesh, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 140, -1));

        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/add1.png"))); // NOI18N
        btnAdd.setText("Thêm từ");
        btnAdd.setToolTipText("Add");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 140, -1));

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/delete.png"))); // NOI18N
        btnDelete.setText("Xoá từ");
        btnDelete.setToolTipText("Delete");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel4.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 140, -1));

        down.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        down.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/down.png"))); // NOI18N
        down.setToolTipText("down");
        down.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        down.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        down.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downMouseClicked(evt);
            }
        });
        jPanel4.add(down, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 50, 160));

        up.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/up.png"))); // NOI18N
        up.setToolTipText("up");
        up.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        up.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upMouseClicked(evt);
            }
        });
        jPanel4.add(up, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 50, 160));

        goLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/down2.png"))); // NOI18N
        goLast.setToolTipText("last");
        goLast.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        goLast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goLastMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                goLastMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                goLastMouseEntered(evt);
            }
        });
        jPanel4.add(goLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 440, 30, -1));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/home-512.png"))); // NOI18N
        btnHome.setToolTipText("home");
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel4.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 50, 50));

        listWordViews.setBackground(new java.awt.Color(204, 204, 255));
        listWordViews.setToolTipText("");
        listWordViews.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listWordViews.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                listWordViewsMouseWheelMoved(evt);
            }
        });
        listWordViews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listWordViewsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(listWordViews, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(listWordViews, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 470));

        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/history.png"))); // NOI18N
        btnHistory.setToolTipText("history");
        btnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });
        jPanel4.add(btnHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 50));

        lblTotalWord.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTotalWord.setText("Tổng số từ: ");
        jPanel4.add(lblTotalWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 270, 20));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText(" Thoát");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 480, -1, -1));

        iconSearch.setBackground(new java.awt.Color(255, 255, 255));
        iconSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/search.png"))); // NOI18N

        lblInfoWord.setBackground(new java.awt.Color(204, 204, 255));
        lblInfoWord.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblInfoWord.setForeground(new java.awt.Color(0, 0, 153));
        lblInfoWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfoWord.setText("   Thông tin từ");
        lblInfoWord.setToolTipText("");
        lblInfoWord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblInfoWord.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lblInfoWord.setOpaque(true);

        btnAudio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/audio1.png"))); // NOI18N
        btnAudio.setToolTipText("history");
        btnAudio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAudio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAudioActionPerformed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(282, 282, 282)
                                .addComponent(iconSearch))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62)
                        .addComponent(btnAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(lblInfoWord, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(iconSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInfoWord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tìm kiếm", jPanel1);

        btnPrev.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/pre.png"))); // NOI18N
        btnPrev.setText("   Back");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/next.png"))); // NOI18N
        btnNext.setText("Next  ");
        btnNext.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 476, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(513, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("Học từ vựng", jPanel2);

        jPanel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel11.setBackground(new java.awt.Color(255, 204, 204));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Dịch từ / Dịch văn bản");
        jLabel11.setToolTipText("");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel11.setOpaque(true);

        lblText1.setBackground(new java.awt.Color(255, 204, 204));
        lblText1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblText1.setForeground(new java.awt.Color(0, 0, 153));
        lblText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText1.setText("Tiếng Việt");
        lblText1.setToolTipText("");
        lblText1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblText1.setOpaque(true);

        lblText2.setBackground(new java.awt.Color(255, 204, 204));
        lblText2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblText2.setForeground(new java.awt.Color(0, 0, 153));
        lblText2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText2.setText("Tiếng Anh");
        lblText2.setToolTipText("");
        lblText2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblText2.setOpaque(true);

        btnSwap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/swap.png"))); // NOI18N
        btnSwap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSwap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwapActionPerformed(evt);
            }
        });

        btnPhatAm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/audio1.png"))); // NOI18N
        btnPhatAm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhatAm1ActionPerformed(evt);
            }
        });

        btnPhatAm2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/audio1.png"))); // NOI18N
        btnPhatAm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhatAm2ActionPerformed(evt);
            }
        });

        areaText1.setBackground(new java.awt.Color(255, 204, 204));
        areaText1.setColumns(20);
        areaText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        areaText1.setRows(5);
        areaText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areaText1KeyReleased(evt);
            }
        });

        areaText2.setBackground(new java.awt.Color(255, 204, 204));
        areaText2.setColumns(20);
        areaText2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        areaText2.setRows(5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lblText1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnSwap, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(lblText2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPhatAm1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(areaText1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(areaText2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPhatAm2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSwap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPhatAm1)
                            .addComponent(btnPhatAm2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblText2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaText1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaText2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(149, 149, 149))
        );

        jTabbedPane1.addTab("Dịch văn bản", jPanel3);

        jMenu1.setForeground(new java.awt.Color(0, 0, 204));
        jMenu1.setText("Chức năng");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.META_MASK));
        jMenuItem4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(0, 51, 153));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/add2.png"))); // NOI18N
        jMenuItem4.setText("Thêm từ");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.META_MASK));
        jMenuItem5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jMenuItem5.setForeground(new java.awt.Color(0, 51, 153));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/edit2.png"))); // NOI18N
        jMenuItem5.setText("Sửa từ");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.META_MASK));
        jMenuItem6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jMenuItem6.setForeground(new java.awt.Color(0, 51, 153));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/delete2.png"))); // NOI18N
        jMenuItem6.setText("Xoá từ");
        jMenuItem6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.META_MASK));
        jMenuItem7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jMenuItem7.setForeground(new java.awt.Color(0, 51, 153));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/clearhis.png"))); // NOI18N
        jMenuItem7.setText("Xoá lịch sử");
        jMenuItem7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        lblFullnamex1.setText("   ");
        jMenuBar1.add(lblFullnamex1);

        jMenu3.setForeground(new java.awt.Color(0, 51, 204));
        jMenu3.setText("Cài đặt");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jMenu4.setForeground(new java.awt.Color(0, 51, 204));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/search2.png"))); // NOI18N
        jMenu4.setText("Kiểu tìm kiếm");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(0, 51, 153));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/search2.png"))); // NOI18N
        jMenuItem2.setText("Tương đối");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(0, 51, 153));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/search2.png"))); // NOI18N
        jMenuItem3.setText("Tuyệt đối");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenu3.add(jMenu4);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.META_MASK));
        jMenuItem9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jMenuItem9.setForeground(new java.awt.Color(0, 51, 153));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/search2.png"))); // NOI18N
        jMenuItem9.setText("Cut");
        jMenuItem9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.META_MASK));
        jMenuItem10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jMenuItem10.setForeground(new java.awt.Color(0, 51, 153));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/search2.png"))); // NOI18N
        jMenuItem10.setText("Copy");
        jMenuItem10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.META_MASK));
        jMenuItem11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jMenuItem11.setForeground(new java.awt.Color(0, 51, 153));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/search2.png"))); // NOI18N
        jMenuItem11.setText("Paste");
        jMenuItem11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        jMenu5.setForeground(new java.awt.Color(0, 0, 204));
        jMenu5.setText("     Thông tin");
        jMenu5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        mnAuthor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mnAuthor.setForeground(new java.awt.Color(0, 0, 153));
        mnAuthor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/user.png"))); // NOI18N
        mnAuthor.setText("Thông tin tác giả");
        mnAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAuthorActionPerformed(evt);
            }
        });
        jMenu5.add(mnAuthor);

        jMenuItem8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jMenuItem8.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/book.png"))); // NOI18N
        jMenuItem8.setText("Hướng dẫn");
        jMenu5.add(jMenuItem8);

        jMenuBar1.add(jMenu5);

        lblFullnamex.setText("                                                                                                                  ");
        lblFullnamex.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblFullnamex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuBar1.add(lblFullnamex);

        jMenu2.setForeground(new java.awt.Color(255, 0, 0));
        jMenu2.setText("Đăng xuất");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu2.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Tìm kiếm");

        pack();
    }// </editor-fold>//GEN-END:initComponents
     /*
    * FUNCTION set scroll mouse up
     */
    private void upMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upMouseClicked
        indexHienTai = indexHienTai > 1 ? (indexHienTai - 1) : indexHienTai;
        txtSearch.setText("");
        dictionaryManagement.listWord.clear();
        myConnect.getData(indexHienTai, numWordOfList);
        showAllWord();
    }//GEN-LAST:event_upMouseClicked
    /*
    * FUNCTION set scroll mouse down
     */
    private void downMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downMouseClicked
        indexHienTai = indexHienTai < myConnect.countWordInDatabase() - numWordOfList ? (indexHienTai + 1) : indexHienTai;       
        txtSearch.setText("");
        dictionaryManagement.listWord.clear();
        myConnect.getData(indexHienTai, numWordOfList);
        showAllWord();
    }//GEN-LAST:event_downMouseClicked

   /*
    * FUNCTION get selected value list and set info word
     */
    private void listWordViewsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listWordViewsMouseClicked
        if (evt.getModifiers() == InputEvent.BUTTON1_MASK) {
            if (listWordViews.getSelectedIndex() >= 0) {
                String selected = listWordViews.getSelectedValue();
                selected = selected.trim();
                setTextAreaInfo(selected, dictionaryManagement.listWord);
                String explain = "";
                for (int i = 0; i < dictionaryManagement.listWord.size(); i++) {
                    if (dictionaryManagement.listWord.get(i).getWord_target().equals(selected)) {
                        explain = dictionaryManagement.listWord.get(i).getWord_explain();
                    }
                }
                //lưu vào mảng history
                Word word = new Word(selected, explain);
                boolean flag = true;
                for (int i = 0; i < dictionaryManagement.listWordHistory.size(); i++) {
                    if (dictionaryManagement.listWordHistory.get(i).getWord_target().equals(selected)) {
                        flag = false;
                    }
                }
                if (flag == true) {
                    dictionaryManagement.listWordHistory.add(word);
                    if (dictionaryManagement.listWordHistory.size() > 50) {
                        dictionaryManagement.listWordHistory.remove(0);
                    }
                }
            }

        }
    }//GEN-LAST:event_listWordViewsMouseClicked
    /*
    * FUNCTION set type search relative
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        typeSearch = true; //relative
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    /*
    * FUNCTION set type search absolute
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        typeSearch = false; //absolute
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    /*
    * FUNCTION add word click menu bar
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.btnAddActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    /*
    * FUNCTION edit word click menu bar
     */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        process = "edit";
        String word = JOptionPane.showInputDialog(null, "Nhập vào từ muốn sửa");
        if (word != null) {
            ArrayList checkExistWord = myConnect.getInfoWordBySpelling(word.trim());
            if (checkExistWord.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Từ này không tồn tại trong danh sách !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            } else {
                selectedWordEdit = word;
                SwingUtilities.invokeLater(() -> {
                    JFrame formEdit = new formProcess("Sửa từ được chọn !", process);
                    formEdit.setVisible(true);  //hiện giao diện
                });
            }
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    /*
    * FUNCTION delete click menu bar
     */
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        String word = JOptionPane.showInputDialog(null, "Nhập vào từ muốn xoá");
        if (word != null) {
            ArrayList checkExistWord = myConnect.getInfoWordBySpelling(word.trim());
            if (checkExistWord.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Từ này không tồn tại trong danh sách !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            } else {
                dictionaryManagement.listWord.clear();
                indexHienTai = 1;
                myConnect.getData(indexHienTai, numWordOfList);
                showAllWord();
                myConnect.deleteData(word.trim());
                lblTotalWord.setText("Tổng số từ: " + myConnect.countWordInDatabase());
                JOptionPane.showMessageDialog(null, "Đã xoá thành công !", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed
    /*
    * FUNCTION refresh list word (start = 1)
     */
    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        if (indexHienTai == 1 && txtSearch.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Đã làm mới dữ liệu !", "thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            up.setVisible(true);
            down.setVisible(true);
            indexHienTai = 1;
            txtSearch.setText("");
            areaInfoWord.setText("");
            dictionaryManagement.listWord.clear();
            myConnect.getData(1, numWordOfList);
            indexHienTai = 1;
            showAllWord();
        }

    }//GEN-LAST:event_btnRefeshActionPerformed
    /*
    * FUNCTION add word click panel
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        process = "add";
        SwingUtilities.invokeLater(() -> {
            JFrame formAdd = new formProcess("Thêm từ mới !", process);
            formAdd.setVisible(true);
        });
        if(txtSearch.getText().equals("")){
            indexHienTai = myConnect.countWordInDatabase() - numWordOfList + 2;
        }
        
    }//GEN-LAST:event_btnAddActionPerformed
    /*
    * FUNCTION edit word click panel
     */
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        process = "edit";
        if (listWordViews.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phần tử muốn sửa !", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            indexEditSelected = listWordViews.getSelectedIndex();
            selectedWordEdit = listWordViews.getSelectedValue().trim();
            if (listWordViews.getSelectedIndex() >= 0) {
                SwingUtilities.invokeLater(() -> {
                    JFrame formEdit = new formProcess("Sửa từ được chọn !", process);
                    formEdit.setVisible(true); //hiện giao diện
                });
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed
    /*
    * FUNCTION set list word at last data
     */
    private void goLastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goLastMouseClicked
        if(txtSearch.getText().equals("")){
            if (indexHienTai < myConnect.countWordInDatabase() - numWordOfList) {
                indexHienTai = myConnect.countWordInDatabase() - numWordOfList + 1;
                dictionaryManagement.listWord.clear();
                myConnect.getData(indexHienTai, numWordOfList);
            }
            showAllWord();
        }
        
    }//GEN-LAST:event_goLastMouseClicked

   /*
    * FUNCTION delete word click panel
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String selectedValue = listWordViews.getSelectedValue();
        if (listWordViews.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn từ bạn muốn xoá!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } else {
            int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá từ: " + selectedValue, "Thông báo", JOptionPane.WARNING_MESSAGE);
            if (dialogButton == JOptionPane.YES_OPTION) {
                myConnect.deleteData(selectedValue.trim());
                JOptionPane.showMessageDialog(null, "Đã xoá thành công !", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
                lblTotalWord.setText("Tổng số từ: " + myConnect.countWordInDatabase());
                if (indexHienTai == 1) {
                    indexHienTai = indexHienTai + 1;
                } else {
                    indexHienTai = indexHienTai - 1;
                }
                dictionaryManagement.listWord.clear();
                myConnect.getData(indexHienTai, numWordOfList);
                showAllWord();
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    /*
    * FUNCTION logout click menu bar
     */
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        int checkExit = JOptionPane.showConfirmDialog(this, "Bạn có chắc là sẽ thoát ứng dụng",
                "Close app ?", JOptionPane.YES_NO_OPTION);
        if (checkExit == 0) {
            this.dispose();
            File file1 = new File("public/username.txt");
            if (file1.exists()) {
                file1.delete();
            }
            SwingUtilities.invokeLater(() -> {
                JFrame formLogin = new formLogin();
                formLogin.setVisible(true); //hiện giao diện 
            });
        } else {
            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_jMenu2MouseClicked
    /*
    * FUNCTION swap language translate
     */
    private void btnSwapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwapActionPerformed
        ClickSwap++;
        areaText1.setText("");
        areaText2.setText("");
        if (ClickSwap % 2 != 0) {
            lblText1.setText("Tiếng Anh");
            lblText2.setText("Tiếng Việt");
            targetLanguage = "vi";
        } else {
            lblText1.setText("Tiếng Việt");
            lblText2.setText("Tiếng Anh");
            targetLanguage = "en";
        }
    }//GEN-LAST:event_btnSwapActionPerformed

    private void btnPhatAm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhatAm1ActionPerformed
        String word = areaText1.getText();
        try {
            Player play = new Player(Synthesiser.getMP3Data(word));
            play.play();
        } catch (IOException | JavaLayerException e) {
            JOptionPane.showMessageDialog(null, "Không có phát âm cho từ này");
        }
    }//GEN-LAST:event_btnPhatAm1ActionPerformed

    private void btnPhatAm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhatAm2ActionPerformed
        String word = areaText2.getText();
        try {
            Player play = new Player(Synthesiser.getMP3Data(word));
            play.play();
        } catch (IOException | JavaLayerException e) {
            JOptionPane.showMessageDialog(null, "Không có phát âm cho từ này");
        }
    }//GEN-LAST:event_btnPhatAm2ActionPerformed

    private void areaText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaText1KeyReleased
        String word = areaText1.getText();
        String Explain = new String();
        try {
            String Langage = Synthesiser.getLanguage();
            Explain = GoogleTranslate.translate(targetLanguage, word);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Lỗi !");
        }
        areaText2.setText(Explain);
    }//GEN-LAST:event_areaText1KeyReleased
    
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (start + 8 < topic.listTopic.size() - 1) {
            start = start + 8;
            loadTopic();
        } else {
            JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        if (start != 0) {
            start = start - 8;
            loadTopic();
        } else {
            JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void mnAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAuthorActionPerformed
        formAuthor author = new formAuthor(this, true);
        author.setVisible(true);
    }//GEN-LAST:event_mnAuthorActionPerformed
    public void resetButton(boolean type1, boolean type2){ //type 1 = false 
        areaInfoWord.setText("");
        txtSearch.setEnabled(type1);    // false
        listWordViews.setVisible(type1);
        listWordViews.setEnabled(type1);
        up.setVisible(type1);
        down.setVisible(type1);
        goLast.setVisible(type1);
        
        btnHistory.setEnabled(type1);
        btnHome.setEnabled(type2);
        btnAudio.setEnabled(type1);
        btnRefesh.setEnabled(type1);
        btnAdd.setEnabled(type1);
        btnEdit.setEnabled(type1);
        btnDelete.setEnabled(type1);
        jMenuItem4.setEnabled(type1);
        jMenuItem5.setEnabled(type1);
        jMenuItem6.setEnabled(type1);
    }
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        lblTotalWord.setText("Tổng số từ: " + myConnect.countWordInDatabase());
        mode = "normal";
        jPanel5.remove(scroll);
        jPanel5.remove(listWordHistoryViews);
        scroll.setVisible(false);
        scroll.setEnabled(false);
        
        resetButton(true, false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void goLastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goLastMouseEntered
        goLast.setIcon(getIconButton("public/","down3","png" , 25, 25));
        
    }//GEN-LAST:event_goLastMouseEntered

    private void goLastMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goLastMouseExited
        goLast.setIcon(getIconButton("public/","down2","png" , 25, 25));
    }//GEN-LAST:event_goLastMouseExited

    private void btnAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAudioActionPerformed
         String selectedValue = "";
        if("normal".equals(mode)){
            selectedValue = listWordViews.getSelectedValue();
        } else if ("history".equals(mode)){
            selectedValue = listWordHistoryViews.getSelectedValue().toString();
        }
        
        if (listWordViews.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phần tử muốn phát âm !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);

        } else {
            try {
                Player play = new Player(Synthesiser.getMP3Data(selectedValue));
                play.play();
            } catch (IOException | JavaLayerException e) {
                JOptionPane.showMessageDialog(null, "Không có phát âm của từ này !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAudioActionPerformed
    public void listWordHistoryViewsClicked(java.awt.event.MouseEvent evt){
        if(listWordHistoryViews.getSelectedIndex() >= 0){
            String selected = listWordHistoryViews.getSelectedValue().toString();
            selected = selected.trim();
            setTextAreaInfo(selected, dictionaryManagement.listWordHistory);
        }
        
    }
    private void listWordViewsMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_listWordViewsMouseWheelMoved
        areaInfoWord.setText("");
        if(evt.getWheelRotation() > 0){
            indexHienTai = indexHienTai + 23 <= myConnect.countWordInDatabase() ? indexHienTai + 1 : indexHienTai;
        } else {
            indexHienTai = indexHienTai > 1 ? indexHienTai - 1 : indexHienTai;
        }
        
        if (txtSearch.getText().equals("") || dictionaryManagement.listWord.isEmpty()) {
            dictionaryManagement.listWord.clear();
            myConnect.getData(indexHienTai, numWordOfList);
            showAllWord();
        }
    }//GEN-LAST:event_listWordViewsMouseWheelMoved

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathHistory), "UTF-8"));
            for (Word ele : dictionaryManagement.listWordHistory) {
                bw.write(ele.getWord_target() + "\t" + ele.getWord_explain());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if("history".equals(mode)){
            listWordHistoryViews.removeAll();
            dlmHistory.clear();
        }        
        dictionaryManagement.listWordHistory.clear();
        File file1 = new File(pathHistory);
        if (file1.exists()) {
            file1.delete();
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    
    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        lblTotalWord.setText("Tổng số từ (H): " + dictionaryManagement.listWordHistory.size());
        mode = "history";
        dlmHistory = new DefaultListModel();
        for(int i = dictionaryManagement.listWordHistory.size() - 1; i >=0 ; i--){
            dlmHistory.addElement(dictionaryManagement.listWordHistory.get(i).getWord_target());
        }
        resetButton(false, true);
        
        listWordHistoryViews = new JList();
        scroll = new JScrollPane(listWordHistoryViews);
        listWordHistoryViews.setSize(listWordViews.getSize().width , areaInfoWord.getSize().height);
        listWordHistoryViews.setLocation(listWordViews.getLocation().x, listWordViews.getLocation().y);
        listWordHistoryViews.setModel(dlmHistory);
        listWordHistoryViews.setBackground(new java.awt.Color(204, 204, 255));
        scroll.setSize(listWordViews.getSize().width , areaInfoWord.getSize().height);
        scroll.setLocation(listWordViews.getLocation().x, listWordViews.getLocation().y);
        scroll.setVisible(true);
        jPanel5.add(scroll);
        
        listWordHistoryViews.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listWordHistoryViewsClicked(evt);
            }
        });
        
    }//GEN-LAST:event_btnHistoryActionPerformed
    final Clipboard clip  = Toolkit.getDefaultToolkit().getSystemClipboard();
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        String selection = ""; 
        if(areaText1.getSelectedText() != null){
            selection = areaText1.getSelectedText();
            areaText1.replaceRange("", areaText1.getSelectionStart(), areaText1.getSelectionEnd());
        } else if ( areaText2.getSelectedText() != null){
            selection = areaText1.getSelectedText();
            areaText2.replaceRange("", areaText2.getSelectionStart(), areaText2.getSelectionEnd());
        } 
        StringSelection data = new StringSelection(selection);
        clip.setContents(data, data);
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        String selection = ""; 
        if(areaText1.getSelectedText() != null){
            selection = areaText1.getSelectedText();
        } else if ( areaText2.getSelectedText() != null){
            selection = areaText1.getSelectedText();
        } 
        StringSelection data = new StringSelection(selection);
        clip.setContents(data, data);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Transferable clipData = clip.getContents(clip);
        try {
            if(clipData.isDataFlavorSupported(DataFlavor.stringFlavor)){
                String s = (String)(clipData.getTransferData(DataFlavor.stringFlavor));
                areaText1.replaceSelection(s);
            }
        } catch (UnsupportedFlavorException | IOException e) {
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát ? ", "Thông báo", JOptionPane.WARNING_MESSAGE);
        if (dialogButton == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel1MouseClicked
    public void setTextAreaInfo(String selected, ArrayList<Word> list) {
        String infoWord = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWord_target().equals(selected.trim())) {
                String word_Explain = list.get(i).getWord_explain();
                word_Explain = word_Explain.replaceAll("<br />", "\n    ").replaceAll("<[^>]*>", "")
                               .replaceAll("&amp", "").replaceAll("&lt;", "").replaceAll("&gt;", "");
                infoWord += "Word(*) : " + word_Explain;
                break;
            }
        }
        areaInfoWord.setText(infoWord);
    }

    /**
     * Load data from list to listView
     */
    public void showAllWord() {
        dlmWord.removeAllElements();
        listWordViews.removeAll();
        if (dictionaryManagement.listWord.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Quá trình load dữ liệu thất bại ! vui lòng kết nối internet");
            System.exit(0);
        } else {
            for (int i = 0; i < dictionaryManagement.listWord.size(); i++) {
                dlmWord.addElement(dictionaryManagement.listWord.get(i).getWord_target());
            }
            listWordViews.setModel(dlmWord);
        }
    }

    public void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {
        if ("normal".equals(mode)) {
            boolean check = false;
            if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE && txtSearch.getText().equals("")) {
                check = true;
                indexHienTai = 1;
                dictionaryManagement.listWord.clear();
                removeAllWord(false);
                myConnect.getData(1, numWordOfList);
                showAllWord();
                up.setVisible(true);
                down.setVisible(true);
                lblSearch.setText("");
            } else {
                up.setVisible(false);
                down.setVisible(false);
            }
            if (check == false) {
                removeAllWord(false);
                String keyWord = txtSearch.getText();
                if (false == keyWord.equals("")) {
                    dictionaryManagement.listWord.clear();
                    myConnect.seachKeyWord(keyWord, typeSearch);
                    if (dictionaryManagement.listWord.isEmpty()) {
                        lblSearch.setText("Từ cần tìm không tồn tại !");
                    } else {
                        showAllWord();
                        lblSearch.setText("");
                    }
                }
            }
            
        } 
    }

    /**
     * Remove all Word in listView
     * @param ShowMessage
     */
    public void removeAllWord(boolean ShowMessage) {
        if (dlmWord.size() != 0) {
            dlmWord.removeAllElements();
            listWordViews.removeAll();
            areaInfoWord.setText("");
        } else {
            if (ShowMessage == true) {
                JOptionPane.showMessageDialog(null, "Danh sách đã được xoá hết !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaInfoWord;
    private javax.swing.JTextArea areaText1;
    private javax.swing.JTextArea areaText2;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAudio;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPhatAm1;
    private javax.swing.JButton btnPhatAm2;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnSwap;
    private javax.swing.JLabel down;
    private javax.swing.JLabel goLast;
    private javax.swing.JLabel iconSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenu lblFullnamex;
    private javax.swing.JMenu lblFullnamex1;
    private javax.swing.JLabel lblInfoWord;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblText1;
    private javax.swing.JLabel lblText2;
    private javax.swing.JLabel lblTotalWord;
    private javax.swing.JList<String> listWordViews;
    private javax.swing.JMenuItem mnAuthor;
    private javax.swing.JLabel up;
    // End of variables declaration//GEN-END:variables
}
