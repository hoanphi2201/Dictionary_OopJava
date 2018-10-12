package ver_1;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Screen;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javazoom.jl.player.Player;
/**
 * @author phixuanhoan
 */
public class formMain extends javax.swing.JFrame {
    //Khai báo biến có thuộc tính static nhằm mục đích không cần khởi tạo đối tượng nhưng có thể truy cập từ form khác
    public static boolean flagAddMainForm = false;
    public static boolean flagEditMainForm = false;
    public static int selectedItem;
    
    public static String textSpelling;
    public static String textExplain;
    public static String textTranscription;
    public static String textExample;
    public static String textExplainExample;
//    public static String define;
//    public static String 
    public static JList<String> listAddView = new JList<String>();
    
    //Khời tạo từ điển
    public static dictionary Dictionary = new dictionary();
    
    public static topic Topic = new topic();
    public int start = 0;

    //Danh sách hiển thị từ tiéng anh
    public static DefaultListModel dlmWord = new DefaultListModel();
    /**
     * Creates new form formMain
     */
    public formMain() {
        initComponents();
        areaInfoOfWord.setLineWrap(true);      //xuống dòng
        areaInfoOfWord.setWrapStyleWord(true); 
        areaInfoOfWord.setEditable(false); 
        listWordView.setSize(260, 444);
        scrollWord.setSize(260, 444);
        this.setLocationRelativeTo(null);
         try {
           Dictionary.loadData();                                 // load dữ liệu từ database  
           Dictionary.setTotalWord(Dictionary.listWord.size());   // thiết lập lại kích thước của Dictionary
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Load dữ liệu thất bại hãy thử lại sau !");
        }
        showAllWord();   //hiển thị ra
        
        /**
         * Trang học từ vựng
         */
        //icon1.setIcon(new ImageIcon("images_topic/age.jpg"));
        btn4.setSize(170, 44);
        Topic.getAllTopic();
        loadTopicToPage(start);
        


    }
    public void loadTopicToPage(int start){
        for(int i = 0; i<7; i++){
            switch(i){
                case 0:{
                    icon1.setIcon(new ImageIcon("images_topic/"+Topic.listTopic.get(start).getTopicName()+".jpg"));
                    btn1.setText(Topic.listTopic.get(start).getId() + ": " + Topic.listTopic.get(start).getTopicName());
                    break;
                }
                case 1:{
                    icon2.setIcon(new ImageIcon("images_topic/"+Topic.listTopic.get(start).getTopicName()+".jpg"));
                    btn2.setText(Topic.listTopic.get(start).getId() + ": " + Topic.listTopic.get(start).getTopicName());
                    break;
                }
                case 2:{
                    icon3.setIcon(new ImageIcon("images_topic/"+Topic.listTopic.get(start).getTopicName()+".jpg"));
                    btn3.setText(Topic.listTopic.get(start).getId() + ": " + Topic.listTopic.get(start).getTopicName());
                    break;
                }
                case 3:{
                    icon4.setIcon(new ImageIcon("images_topic/"+Topic.listTopic.get(start).getTopicName()+".jpg"));
                    btn4.setText(Topic.listTopic.get(start).getId() + ": " + Topic.listTopic.get(start).getTopicName());
                    break;
                }
                case 4:{
                    icon5.setIcon(new ImageIcon("images_topic/"+Topic.listTopic.get(start).getTopicName()+".jpg"));
                    btn5.setText(Topic.listTopic.get(start).getId() + ": " + Topic.listTopic.get(start).getTopicName());
                    break;
                }
                case 5:{
                    icon6.setIcon(new ImageIcon("images_topic/"+Topic.listTopic.get(start).getTopicName()+".jpg"));
                    btn6.setText(Topic.listTopic.get(start).getId() + ": " + Topic.listTopic.get(start).getTopicName());
                    break;
                }
                case 6:{
                    icon7.setIcon(new ImageIcon("images_topic/"+Topic.listTopic.get(start).getTopicName()+".jpg"));
                    btn7.setText(Topic.listTopic.get(start).getId() + ": " + Topic.listTopic.get(start).getTopicName());
                    break;
                }
                
            }
            start++;
        }
    }
    /**
     * Load dữ liệu ra từ database
     */
    public static void loadDataFromDatabase(){
        try {
           Dictionary.loadData();             // load dữ liệu từ database  
           Dictionary.setTotalWord(Dictionary.listWord.size());   // thiết lập lại kích thước của Dictionary
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Load dữ liệu thất bại hãy thử lại sau !");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnDeleteList = new javax.swing.JButton();
        btnAddWord = new javax.swing.JButton();
        scrollWord = new javax.swing.JScrollPane();
        listWordView = new javax.swing.JList<>();
        txtSearch = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnShowWord = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        areaInfoOfWord = new javax.swing.JTextArea();
        btnPhatAm = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        icon2 = new javax.swing.JLabel();
        icon3 = new javax.swing.JLabel();
        icon4 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        icon8 = new javax.swing.JLabel();
        icon5 = new javax.swing.JLabel();
        icon6 = new javax.swing.JLabel();
        icon7 = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        fileOpen = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dictionary");

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        btnDeleteList.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteList.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver_1/images/database_remove.png"))); // NOI18N
        btnDeleteList.setText("Xoá từ đang hiển thị");
        btnDeleteList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteListActionPerformed(evt);
            }
        });

        btnAddWord.setBackground(new java.awt.Color(204, 204, 204));
        btnAddWord.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver_1/images/note_add.png"))); // NOI18N
        btnAddWord.setText("Thêm từ");
        btnAddWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWordActionPerformed(evt);
            }
        });

        scrollWord.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollWord.setMinimumSize(new java.awt.Dimension(260, 444));

        listWordView.setBackground(new java.awt.Color(255, 255, 204));
        listWordView.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        listWordView.setMinimumSize(new java.awt.Dimension(260, 444));
        listWordView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listWordViewMouseClicked(evt);
            }
        });
        scrollWord.setViewportView(listWordView);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(204, 204, 204));
        txtSearch.setText("Nhập từ cần tìm kiếm ... ");
        txtSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtSearchMouseExited(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 204, 204));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver_1/images/note_remove.png"))); // NOI18N
        btnDelete.setText("Xoá từ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(204, 204, 204));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver_1/images/note_edit.png"))); // NOI18N
        btnEdit.setText("   Sửa từ");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnShowWord.setBackground(new java.awt.Color(204, 204, 204));
        btnShowWord.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnShowWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver_1/images/database_accept.png"))); // NOI18N
        btnShowWord.setText("Hiển tự từ vừa load");
        btnShowWord.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnShowWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowWordActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(204, 204, 204));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver_1/images/remove.png"))); // NOI18N
        btnExit.setText("     Thoát ");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(204, 255, 204));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver_1/images/archive.png"))); // NOI18N
        jLabel10.setText("Thông tin từ");
        jLabel10.setToolTipText("");
        jLabel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel10.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver_1/images/search_add.png"))); // NOI18N

        areaInfoOfWord.setBackground(new java.awt.Color(255, 255, 204));
        areaInfoOfWord.setColumns(20);
        areaInfoOfWord.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        areaInfoOfWord.setRows(5);

        btnPhatAm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver_1/images/if_Audio_1891017.png"))); // NOI18N
        btnPhatAm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhatAmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(scrollWord, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShowWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPhatAm)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(areaInfoOfWord, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(823, 823, 823))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPhatAm)))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnShowWord, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnDeleteList, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnAddWord, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollWord, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(areaInfoOfWord))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tuỳ chọn", jPanel1);

        jPanel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        icon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_topic/felling and emotions.jpg"))); // NOI18N

        icon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_topic/time 1.jpg"))); // NOI18N

        icon4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_topic/time 2.jpg"))); // NOI18N

        icon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_topic/felling.jpg"))); // NOI18N

        icon8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_topic/test.jpg"))); // NOI18N

        icon5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_topic/family 1.jpg"))); // NOI18N

        icon6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_topic/family 2.jpg"))); // NOI18N

        icon7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_topic/age.jpg"))); // NOI18N

        btn1.setBackground(new java.awt.Color(204, 255, 204));
        btn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn1.setText("felling");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(204, 255, 204));
        btn2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn2.setText("felling and emotions");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(204, 255, 204));
        btn3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn3.setText("time 1");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(204, 255, 204));
        btn4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn4.setText("time 2");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(204, 255, 204));
        btn5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn5.setText("family 1");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn7.setBackground(new java.awt.Color(204, 255, 204));
        btn7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn7.setText("age");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(204, 255, 204));
        btn6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn6.setText("family 2");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btnTest.setBackground(new java.awt.Color(204, 255, 204));
        btnTest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTest.setText("test");
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(204, 255, 204));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_topic/back.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(204, 255, 204));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_topic/next.png"))); // NOI18N
        btnNext.setText("Next");
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
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(icon5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icon2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icon6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icon3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(icon8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(icon4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(icon3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(icon7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(icon4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(icon8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(icon5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(icon6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Học từ vựng", jPanel2);

        jMenu1.setForeground(new java.awt.Color(0, 0, 153));
        jMenu1.setText("File");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        fileOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        fileOpen.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        fileOpen.setForeground(new java.awt.Color(0, 0, 153));
        fileOpen.setText("Open");
        fileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileOpenActionPerformed(evt);
            }
        });
        jMenu1.add(fileOpen);

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Save.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Save.setForeground(new java.awt.Color(0, 0, 153));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jMenu1.add(Save);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        Exit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Exit.setForeground(new java.awt.Color(0, 0, 153));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Tuỳ chọn");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveActionPerformed

    private void fileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileOpenActionPerformed
    
    /**
    * Hàm hiển thị từ đã load từ database / file
    */
    public void showAllWord(){
        dlmWord.removeAllElements();
        listWordView.removeAll();
        if (Dictionary.getTotalWord() == 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn file load dữ liệu");
        } else {
            for (int i = 0; i < Dictionary.listWord.size(); i++) {
                dlmWord.addElement(Dictionary.listWord.get(i).getId() + ": " + Dictionary.listWord.get(i).getSpelling());
            }
            listWordView.setModel(dlmWord);
        }
    }
    /**
    * Hàm xoá từ đã được hiển thị
    */
    public void removeAllWord(boolean ShowMessage){
        if(dlmWord.size() != 0){
            listWordView.getSelectionModel().clearSelection();
            dlmWord.removeAllElements();
            listWordView.removeAll();
            areaInfoOfWord.setText("");
        }else{
            if(ShowMessage == true){
                JOptionPane.showMessageDialog(null, "Danh sách trống ! Không có phần tử để xoá ");
            }
        }
    }
    
    /**
    * Hàm này sẽ xoá tất cả từ đang hiển thị trên list
    */
    private void btnDeleteListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteListActionPerformed
         removeAllWord(true);
    }//GEN-LAST:event_btnDeleteListActionPerformed

    private void btnShowWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowWordActionPerformed
        if(dlmWord.size() == 0){
            showAllWord();
        }else{
            JOptionPane.showMessageDialog(null, "Danh sách từ đã được hiển thị !");
        }
    }//GEN-LAST:event_btnShowWordActionPerformed
    /**
    * Thoát bằng btnExit
    */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
         int checkExit = JOptionPane.showConfirmDialog(this, "Bạn có chắc là sẽ thoát ứng dụng",
                        "Close app ?",JOptionPane.YES_NO_OPTION);
         if(checkExit ==0){
             System.exit(0);
         }else{
             setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
         }
    }//GEN-LAST:event_btnExitActionPerformed
    /**
    * Xử lý sự kiện khi click vào textbox thì xoá bỏ dòng chữ chờ đi
    */
    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        removeAllWord(false);
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchMouseClicked
    /**
    * Xử lý sự kiện khi dời khỏi text box thì set lại dòng chữ chờ
    */
    private void txtSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseExited
        if(txtSearch.getText().equals("")){
            txtSearch.setForeground(Color.gray);
            txtSearch.setText("Nhập từ cần tìm kiếm ...");
        }
    }//GEN-LAST:event_txtSearchMouseExited
    /**
    * Xử lý tìm kiếm theo key nhập vào
    */
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        txtSearch.setForeground(Color.black);
        removeAllWord(false);
        String keyWord = txtSearch.getText();
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            if (Dictionary.listWord.get(i).getSpelling().startsWith(keyWord)) {
                dlmWord.addElement(Dictionary.listWord.get(i).getId() +": " + Dictionary.listWord.get(i).getSpelling());
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased
    /**
    * Xử lý tìm kiếm theo key nhập vào
    */
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        int checkExit = JOptionPane.showConfirmDialog(this, "Bạn có chắc là sẽ thoát ứng dụng",
                        "Close app ?",JOptionPane.YES_NO_OPTION);
        if (checkExit == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_ExitActionPerformed
    /**
     * Khi click vào list view thì cần phải hiển thị thông tin chi tiết vào textarea
     */
    private void listWordViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listWordViewMouseClicked

        String selected  = listWordView.getSelectedValue().toString();
        String[] arrTmp = selected.split(":");
        int indexSelected = Integer.parseInt(arrTmp[0]) - 1;
        String infoWord = "";
        try {
            infoWord += "Từ(*): \n" + Dictionary.listWord.get(indexSelected).getSpelling() + "\n\n";
            infoWord += "Nghĩa từ : \n" + Dictionary.listWord.get(indexSelected).getExplain()+ "\n\n";
            infoWord += "Phiên âm : \n" + Dictionary.listWord.get(indexSelected).getTranscription()+ "\n\n";
            infoWord += "Câu ví dụ : \n" + Dictionary.listWord.get(indexSelected).getExample()+ "\n\n";
            infoWord += "Nghĩa câu ví dụ : \n" + Dictionary.listWord.get(indexSelected).getExlainExample()+ "\n\n";
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "bug");
            try {
                for(int i = 0; i < Dictionary.listWord.size(); i++){
                    if(indexSelected+1 == Dictionary.listWord.get(i).getId()){
                        infoWord += "Từ(*): \n" + Dictionary.listWord.get(i).getSpelling() + "\n\n";
                        infoWord += "Nghĩa từ : \n" + Dictionary.listWord.get(i).getExplain()+ "\n\n";
                        infoWord += "Phiên âm : \n" + Dictionary.listWord.get(i).getTranscription()+ "\n\n";
                        infoWord += "Câu ví dụ : \n" + Dictionary.listWord.get(i).getExample()+ "\n\n";
                        infoWord += "Nghĩa câu ví dụ : \n" + Dictionary.listWord.get(i).getExlainExample()+ "\n\n";
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Không tồn tại");
            }
        }
        
        areaInfoOfWord.setText(infoWord);
    }//GEN-LAST:event_listWordViewMouseClicked
    
    /**
     * Khối chức năng thêm sửa xoá 1 từ
     */   
    private void btnAddWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWordActionPerformed
        textSpelling        = "";
        textExplain         = "";
        textTranscription   = "";
        textExample         = "";
        textExplainExample  = "";
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame formAdd = new formAdd("Thêm từ mới ", "add");
                formAdd.setVisible(true); //hiện giao diện 
                formAdd.setSize(570, 500); // tạo chiều rộng chiều cao
            }
        });
        if(flagAddMainForm == true) {
            listWordView.removeAll();
            setListWordView(listAddView);  
        }
    }//GEN-LAST:event_btnAddWordActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String selected = "";
        String[] tmp;
        selected = listWordView.getSelectedValue();
        if(listWordView.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phần tử muốn sửa");

        }else{
            tmp = selected.split(":");        
            int indexSelected   = Integer.parseInt(tmp[0]) -1;
            try {
                 selectedItem        = indexSelected;
                textSpelling        = Dictionary.listWord.get(indexSelected).getSpelling();
                textExplain         = Dictionary.listWord.get(indexSelected).getExplain();
                textTranscription   = Dictionary.listWord.get(indexSelected).getTranscription();
                textExample         = Dictionary.listWord.get(indexSelected).getExample();
                textExplainExample  = Dictionary.listWord.get(indexSelected).getExlainExample();
            } catch (Exception e) {
                for(int i = 0; i < Dictionary.listWord.size(); i++){
                    if(indexSelected + 1 == Dictionary.listWord.get(i).getId()){
                         selectedItem        = i;
                        textSpelling        = Dictionary.listWord.get(i).getSpelling();
                        textExplain         = Dictionary.listWord.get(i).getExplain();
                        textTranscription   = Dictionary.listWord.get(i).getTranscription();
                        textExample         = Dictionary.listWord.get(i).getExample();
                        textExplainExample  = Dictionary.listWord.get(i).getExlainExample();
                    }
                }
            }
            

        }
        if(listWordView.getSelectedIndex() >= 0){
            SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                    JFrame formAdd      = new formAdd("Sửa từ được chọn !","edit");
                    formAdd.setVisible(true); //hiện giao diện 
                    formAdd.setSize(570, 500); // tạo chiều rộng chiều cao
                }
            });
        }else{
            
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int checkDelete             = JOptionPane.showConfirmDialog(this, "Bạn có chắc là sẽ xoá từ này",
                                      "Message delete ?",JOptionPane.YES_NO_OPTION);
        if(checkDelete ==0){
            String selected = "";
            selected        = listWordView.getSelectedValue();
            if(listWordView.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Vui lòng chọn phần tử muốn xoá");
            }else{
                String[] tmp        = selected.split(":");
                int indexSelected   = Integer.parseInt(tmp[0]) - 1; //trừ 1 vì trong list view chênh với database
                JOptionPane.showMessageDialog(null, indexSelected);
                int idDelete = indexSelected + 1;
                Dictionary.deleteData(idDelete);
            }
            dlmWord.removeAllElements();
            Dictionary.listWord.clear();
            loadDataFromDatabase();
            for (int i = 0; i < Dictionary.listWord.size(); i++) {
                dlmWord.addElement(Dictionary.listWord.get(i).getId() + ": " + Dictionary.listWord.get(i).getSpelling());
            }
            listWordView.setModel(dlmWord);
         }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnPhatAmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhatAmActionPerformed
        String selected = "";
        selected                = listWordView.getSelectedValue();
        if(listWordView.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phần tử muốn phát âm");
               
        }else{
            String[] tmp        = selected.split(":");
            int indexSelected   = Integer.parseInt(tmp[0]) -1;
            String name = "";
            try {
                name = Dictionary.listWord.get(indexSelected).getSpelling();
            } catch (Exception ea) {
                for(int i = 0; i < Dictionary.listWord.size(); i++){
                    if(indexSelected == Dictionary.listWord.get(i).getId()){
                        name = Dictionary.listWord.get(i).getSpelling();
                    }
                }
            }
            try {
                FileInputStream file = new FileInputStream("transcription/" + name.trim()+".mp3");
                Player player = new Player(file);
                player.play();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có phát âm cho từ này!");    
            }
        }
        
    }//GEN-LAST:event_btnPhatAmActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if(start + 7 < Topic.listTopic.size() -1){
            start = start+7;
            loadTopicToPage(start);
        }else{
            JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
        }
        
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if(start !=0){
            start = start - 7;
            loadTopicToPage(start);
        }else{
            JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
        }
    }//GEN-LAST:event_btnBackActionPerformed
    public void loadForm(String btnText){
        Topic.listWordTopic.clear();
        String[] tmp = btnText.split(":");
        int topic_id = Integer.parseInt(tmp[0]);
        String topicName = tmp[1];
        Topic.getWordByTopicID(topic_id);
        if(Topic.listWordTopic.size() == 0){
            JOptionPane.showMessageDialog(null, "Danh sách trống !");
        }else{
            SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                    JFrame formHocTuVung      = new formTuVung(topicName);
                    formHocTuVung.setVisible(true); //hiện giao diện 
                    formHocTuVung.setSize(850, 600); // tạo chiều rộng chiều cao
                }
        });
        }
    }
    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        String btnText = btn1.getText();
        loadForm(btnText);
    }//GEN-LAST:event_btn1ActionPerformed
    
    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        String btnText = btn2.getText();
        loadForm(btnText);
        
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
         String btnText = btn3.getText();
        loadForm(btnText);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
         String btnText = btn4.getText();
        loadForm(btnText);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
         String btnText = btn5.getText();
        loadForm(btnText);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        String btnText = btn6.getText();
        loadForm(btnText);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
         String btnText = btn7.getText();
        loadForm(btnText);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
//         String btnText = btnTest.getText();
//        loadForm(btnText);
    }//GEN-LAST:event_btnTestActionPerformed
    public static  void addWordMain(){
        dlmWord.removeAllElements();
        if(flagAddMainForm == true){
            JOptionPane.showMessageDialog(null, "Thêm thành công !");
            int id =  Dictionary.listWord.get(Dictionary.listWord.size()-1).getId()+1;
            newWord word = new newWord(id ,textSpelling, textExplain, textTranscription, textExample, textExplainExample);
            Dictionary.listWord.add(word); //insert vào ArrayList
            Dictionary.insertData(word);   //insert vào database
            flagAddMainForm = false;
        }
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
                dlmWord.addElement(Dictionary.listWord.get(i).getId() + ": " + Dictionary.listWord.get(i).getSpelling());
            }
        listAddView.setModel(dlmWord);
    }
     public static  void editWordMain(){
       
        dlmWord.removeAllElements();
        if(flagEditMainForm == true){
            JOptionPane.showMessageDialog(null, "Sửa thành công !");
            
            
            Dictionary.listWord.get(selectedItem).setSpelling(textSpelling);
            Dictionary.listWord.get(selectedItem).setExplain(textExplain);
            Dictionary.listWord.get(selectedItem).setTranscription(textTranscription);
            Dictionary.listWord.get(selectedItem).setExample(textExample);
            Dictionary.listWord.get(selectedItem).setExplainExample(textExplainExample);

            Dictionary.updateData(Dictionary.listWord.get(selectedItem));
            flagEditMainForm = false;

        }
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
                dlmWord.addElement(Dictionary.listWord.get(i).getId() + ": " + Dictionary.listWord.get(i).getSpelling());
            }
        listAddView.setModel(dlmWord);
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem Save;
    private javax.swing.JTextArea areaInfoOfWord;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btnAddWord;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteList;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPhatAm;
    private javax.swing.JButton btnShowWord;
    private javax.swing.JButton btnTest;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JMenuItem fileOpen;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel icon5;
    private javax.swing.JLabel icon6;
    private javax.swing.JLabel icon7;
    private javax.swing.JLabel icon8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> listWordView;
    private javax.swing.JScrollPane scrollWord;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    /**
     * @param listWordView the listWordView to set
     */
    public void setListWordView(javax.swing.JList<String> listWordView) {
        this.listWordView = listWordView;
    }
}
