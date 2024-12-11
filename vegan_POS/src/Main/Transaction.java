package Main;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Transaction extends javax.swing.JFrame {
String pathlogo = System.getProperty("user.dir") + "\\src\\picture\\vegan_logo2.png";
 ImageIcon logo = new ImageIcon(pathlogo);
    
    public Transaction() {
        initComponents();
        refresh_table();
        setIcon();
    }
private void setIcon(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(pathlogo));
}
private void refresh_table(){
    DefaultTableModel model;
    model = (DefaultTableModel) InvTable.getModel();
    model.setRowCount(0);
    int num_prod = 0; 
    try {
        String path = System.getProperty("user.dir") + "\\src\\DB\\StockIn.txt";
        File products = new File(path);
        Scanner dataIn = new Scanner(products);


        while(dataIn.hasNext()) {
            String[] data = dataIn.nextLine().split(",");
            num_prod++;
            model.addRow(data);
        } 
    } catch (FileNotFoundException ex) {

    } 
       numProd.setText(Integer.toString(num_prod));
    }
private void dataTo_file(){
    
    String capt = "";
    DefaultTableModel model2;
    model2 = (DefaultTableModel) InvTable.getModel();
    float newProfit = 0;
    String categ = "";
    System.out.println("table"+ table.getRowCount());
    for ( int row = 0; row < table.getRowCount(); row++){
               String ItemCode = table.getModel().getValueAt(row,0).toString();
               String ItemName = table.getModel().getValueAt(row,1).toString();
               String Quantity = table.getModel().getValueAt(row,2).toString();
               String Price = table.getModel().getValueAt(row,3).toString(); 
               String Total = table.getModel().getValueAt(row,4).toString();
               
        
        for (int i = 0; i < InvTable.getRowCount();i++){
           String codeID = InvTable.getModel().getValueAt(i, 0).toString();
           if (codeID.startsWith(ItemCode) ){ 
               capt = (InvTable.getModel().getValueAt(i, 3).toString());
               categ = (InvTable.getModel().getValueAt(i, 2).toString());
            

           }
        }
        newProfit = Float.parseFloat(Total) - (Float.parseFloat(Quantity)* Float.parseFloat(capt));
        Double roundProfit = Math.round(newProfit * 1000)/1000.0;
        String profit = Double.toString(roundProfit);
        try {        
            Transac transac = new Transac(ItemCode,ItemName,categ,Quantity,Price,Total,profit);
        } catch (IOException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
public void getAllDataTo_Print() {
    //Date
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = DateFor.format(date);
        //Time
        DateFormat TimeFormat = new SimpleDateFormat("hh:mm a");
    	String TimeString = TimeFormat.format(new Date()).toString();
    
    int count = 0;
    printTextArea.setFont(new Font("Monospaced",Font.PLAIN,12));
    printTextArea.setText("    ---------------------------------------------------------\n"
                + "                            V E G A N                         \n"
                + "                      Bicol University-Main                   \n"
                + "                          LEGAZPI ALBAY                       \n"
                + "                     www.facebook.com/VEGAN\n"
                + "                         +639123456789\n"
                + "    ---------------------------------------------------------\n"
                + "    Date:"+stringDate+"                      Time:"+TimeString+"\n"
                + "    ---------------------------------------------------------\n"
                + "    Item Name          Quantity       Price      Total\n\n");
      
               for ( int row = 0; row < table.getRowCount(); row++){
//               String ItemCode = table.getModel().getValueAt(row,0).toString();
               String ItemName = table.getModel().getValueAt(row,1).toString();
               String Quantity = table.getModel().getValueAt(row,2).toString();
               String Price = table.getModel().getValueAt(row,3).toString(); 
               String Total = table.getModel().getValueAt(row,4).toString();
               count++;
//               
                if (ItemName.length() >= 16){
    printTextArea.append("    " + ItemName.toUpperCase() +"    "+Quantity+" Kg\t       "+Price+"/Kg\t  "+ Total+"\n");              
                }else if (ItemName.length() < 16 && ItemName.length() >= 8) {
    printTextArea.append("    " + ItemName.toUpperCase() +"\t"+Quantity+" Kg\t       "+Price+"/Kg\t  "+ Total+"\n");                
                }else {
    printTextArea.append("    " + ItemName.toUpperCase() +"\t\t"+Quantity+" Kg\t       "+Price+"/Kg\t  "+ Total+"\n");                 
                }
    
//                  +"  "+ Quantity+"Kg\t\tPrice @" + Price+"/kg\t= Php" + Total +"\n\n");
            
               }
    printTextArea.append(
                        "    ---------------------------------------------------------\n"
                        +"    Total quantity: \t\t\t  " + count +"\n"
                        +"    Total amount  : \t\t\t" + "P "+total1.getText() +"\n"
                        +"    Cash          : \t\t\t" + "P "+amountt.getText() +"\n"
                        +"    Change        : \t\t\t" + "P "+changee.getText() +"\n"
                        +"    ---------------------------------------------------------\n\n\n"
                        +"    *********************************************************\n"
                        +"                      THANK YOU COME AGAIN!\n"
                        +"    *********************************************************\n"
    );
            
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainmenu = new javax.swing.JPanel();
        TransactionPanel = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_items = new javax.swing.JLabel();
        btn_logout = new javax.swing.JLabel();
        btn_avl_stocks = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        container = new javax.swing.JPanel();
        compute = new javax.swing.JPanel();
        btn_process = new javax.swing.JButton();
        stocks23 = new javax.swing.JLabel();
        stocks19 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        stocks26 = new javax.swing.JLabel();
        btn_addcart = new javax.swing.JLabel();
        stocks27 = new javax.swing.JLabel();
        totalamount = new javax.swing.JTextField();
        btn_removecart = new javax.swing.JLabel();
        item_input1 = new javax.swing.JTextField();
        subtotal = new javax.swing.JTextField();
        confirmBox = new javax.swing.JPanel();
        amount = new javax.swing.JLabel();
        change = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        total1 = new javax.swing.JTextField();
        changee = new javax.swing.JTextField();
        amountt = new javax.swing.JTextField();
        btn_process1 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        Infobox = new javax.swing.JPanel();
        stocks21 = new javax.swing.JLabel();
        stocks22 = new javax.swing.JLabel();
        stocks20 = new javax.swing.JLabel();
        stocks = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        code = new javax.swing.JTextField();
        stocks32 = new javax.swing.JLabel();
        Stocks = new javax.swing.JPanel();
        Header1 = new javax.swing.JPanel();
        Logo1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_items2 = new javax.swing.JLabel();
        btn_logout2 = new javax.swing.JLabel();
        btn_avl_stocks2 = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        InvTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        SearchBar = new javax.swing.JTextField();
        numProd = new javax.swing.JLabel();
        totalnum = new javax.swing.JLabel();
        receipt = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        printTextArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(190, 60));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        mainmenu.setMaximumSize(new java.awt.Dimension(1000, 600));
        mainmenu.setMinimumSize(new java.awt.Dimension(1000, 600));
        mainmenu.setPreferredSize(new java.awt.Dimension(1000, 600));
        mainmenu.setLayout(new java.awt.CardLayout());

        TransactionPanel.setBackground(new java.awt.Color(245, 245, 220));
        TransactionPanel.setMaximumSize(new java.awt.Dimension(1000, 600));
        TransactionPanel.setMinimumSize(new java.awt.Dimension(1000, 600));
        TransactionPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
        TransactionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(47, 118, 4));
        Header.setMaximumSize(new java.awt.Dimension(1000, 59));
        Header.setMinimumSize(new java.awt.Dimension(1000, 59));
        Header.setPreferredSize(new java.awt.Dimension(1000, 59));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/logo_vegan2.png"))); // NOI18N
        Header.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 80, 70));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VEGAN");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sales & Stock Control Management System");
        Header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        TransactionPanel.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 120));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_items.setBackground(new java.awt.Color(0, 153, 0));
        btn_items.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        btn_items.setForeground(new java.awt.Color(255, 255, 255));
        btn_items.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_items.setText("Cashier");
        btn_items.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_items.setOpaque(true);
        btn_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_itemsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_itemsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_itemsMouseExited(evt);
            }
        });
        jPanel2.add(btn_items, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 206, 58));

        btn_logout.setBackground(new java.awt.Color(0, 153, 0));
        btn_logout.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_logout.setText("Back to Inventory");
        btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout.setOpaque(true);
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
        });
        jPanel2.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 234, 206, 58));

        btn_avl_stocks.setBackground(new java.awt.Color(0, 153, 0));
        btn_avl_stocks.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        btn_avl_stocks.setForeground(new java.awt.Color(255, 255, 255));
        btn_avl_stocks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_avl_stocks.setText("Available Stocks");
        btn_avl_stocks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_avl_stocks.setOpaque(true);
        btn_avl_stocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_avl_stocksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_avl_stocksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_avl_stocksMouseExited(evt);
            }
        });
        jPanel2.add(btn_avl_stocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 165, 206, 58));

        TransactionPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 130, 230, 460));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Quantity in Kilo", "Price", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TransactionPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 750, -1));

        container.setLayout(new java.awt.CardLayout());

        compute.setBackground(new java.awt.Color(36, 52, 7));
        compute.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_process.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btn_process.setText("PROCESS");
        btn_process.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_process.setEnabled(false);
        btn_process.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_processFocusLost(evt);
            }
        });
        btn_process.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_processMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_processMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_processMouseExited(evt);
            }
        });
        btn_process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_processActionPerformed(evt);
            }
        });
        compute.add(btn_process, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 244, 210, 40));

        stocks23.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        stocks23.setForeground(new java.awt.Color(255, 255, 255));
        stocks23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stocks23.setText("Total Amount:");
        stocks23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        compute.add(stocks23, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 29, -1, -1));

        stocks19.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        stocks19.setForeground(new java.awt.Color(255, 255, 255));
        stocks19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stocks19.setText("Item:");
        stocks19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        compute.add(stocks19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 48, 28));

        quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quantity.setEnabled(false);
        quantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantityMouseClicked(evt);
            }
        });
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityKeyTyped(evt);
            }
        });
        compute.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 121, 211, 28));
        compute.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 106, 421, -1));

        stocks26.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        stocks26.setForeground(new java.awt.Color(255, 255, 255));
        stocks26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stocks26.setText("Total:");
        stocks26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        compute.add(stocks26, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 156, 43, 29));

        btn_addcart.setBackground(new java.awt.Color(0, 153, 0));
        btn_addcart.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btn_addcart.setForeground(new java.awt.Color(255, 255, 255));
        btn_addcart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_addcart.setText("Add to cart");
        btn_addcart.setBorder(new javax.swing.border.MatteBorder(null));
        btn_addcart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addcart.setOpaque(true);
        btn_addcart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addcartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addcartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addcartMouseExited(evt);
            }
        });
        compute.add(btn_addcart, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 201, 127, 35));

        stocks27.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        stocks27.setForeground(new java.awt.Color(255, 255, 255));
        stocks27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stocks27.setText("Quantity in Kilo:");
        stocks27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        compute.add(stocks27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 110, 29));

        totalamount.setEditable(false);
        totalamount.setBackground(new java.awt.Color(255, 255, 255));
        totalamount.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        totalamount.setText("0");
        compute.add(totalamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 13, 280, 40));

        btn_removecart.setBackground(new java.awt.Color(0, 153, 0));
        btn_removecart.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btn_removecart.setForeground(new java.awt.Color(255, 255, 255));
        btn_removecart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_removecart.setText("Remove from cart");
        btn_removecart.setBorder(new javax.swing.border.MatteBorder(null));
        btn_removecart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_removecart.setEnabled(false);
        btn_removecart.setOpaque(true);
        btn_removecart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_removecartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_removecartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_removecartMouseExited(evt);
            }
        });
        compute.add(btn_removecart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 201, 144, 37));

        item_input1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        item_input1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item_input1MouseClicked(evt);
            }
        });
        item_input1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_input1ActionPerformed(evt);
            }
        });
        item_input1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                item_input1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                item_input1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                item_input1KeyTyped(evt);
            }
        });
        compute.add(item_input1, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 66, 211, 30));

        subtotal.setEditable(false);
        subtotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                subtotalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                subtotalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                subtotalKeyTyped(evt);
            }
        });
        compute.add(subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 161, 211, 28));

        container.add(compute, "card5");

        confirmBox.setBackground(new java.awt.Color(36, 52, 7));

        amount.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 255, 255));
        amount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amount.setText("Amount:");
        amount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        change.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        change.setForeground(new java.awt.Color(255, 255, 255));
        change.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        change.setText("Change:");
        change.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        total.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setText("Total:");
        total.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        total1.setEditable(false);
        total1.setBackground(new java.awt.Color(255, 255, 255));
        total1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        changee.setEditable(false);
        changee.setBackground(new java.awt.Color(255, 255, 255));
        changee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        changee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeeActionPerformed(evt);
            }
        });

        amountt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        amountt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                amounttFocusLost(evt);
            }
        });
        amountt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amounttActionPerformed(evt);
            }
        });
        amountt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amounttKeyReleased(evt);
            }
        });

        btn_process1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btn_process1.setText("PROCESS");
        btn_process1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_process1.setEnabled(false);
        btn_process1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_process1FocusLost(evt);
            }
        });
        btn_process1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_process1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_process1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_process1MouseExited(evt);
            }
        });
        btn_process1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_process1ActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        back.setText("BACK");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                backFocusLost(evt);
            }
        });
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout confirmBoxLayout = new javax.swing.GroupLayout(confirmBox);
        confirmBox.setLayout(confirmBoxLayout);
        confirmBoxLayout.setHorizontalGroup(
            confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmBoxLayout.createSequentialGroup()
                .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(confirmBoxLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(total1)
                            .addComponent(changee)
                            .addComponent(amountt, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addGroup(confirmBoxLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(btn_process1)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        confirmBoxLayout.setVerticalGroup(
            confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmBoxLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_process1)
                    .addComponent(back))
                .addGap(26, 26, 26))
        );

        container.add(confirmBox, "card3");

        TransactionPanel.add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 420, 290));

        Infobox.setBackground(new java.awt.Color(36, 52, 7));
        Infobox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        Infobox.setForeground(new java.awt.Color(255, 255, 255));
        Infobox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stocks21.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        stocks21.setForeground(new java.awt.Color(255, 255, 255));
        stocks21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stocks21.setText("Name:");
        stocks21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Infobox.add(stocks21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 90, 30));

        stocks22.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        stocks22.setForeground(new java.awt.Color(255, 255, 255));
        stocks22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stocks22.setText("Price:");
        stocks22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Infobox.add(stocks22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 70, 30));

        stocks20.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        stocks20.setForeground(new java.awt.Color(255, 255, 255));
        stocks20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stocks20.setText("Stocks:");
        stocks20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Infobox.add(stocks20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 60, 30));

        stocks.setEditable(false);
        stocks.setBackground(new java.awt.Color(255, 255, 255));
        stocks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocksActionPerformed(evt);
            }
        });
        Infobox.add(stocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 200, 30));

        name.setEditable(false);
        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        Infobox.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 200, 30));

        price.setEditable(false);
        price.setBackground(new java.awt.Color(255, 255, 255));
        price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Infobox.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 200, 30));

        code.setEditable(false);
        code.setBackground(new java.awt.Color(255, 255, 255));
        code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Infobox.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 200, 30));

        stocks32.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        stocks32.setForeground(new java.awt.Color(255, 255, 255));
        stocks32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stocks32.setText("ID:");
        stocks32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Infobox.add(stocks32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 40));

        TransactionPanel.add(Infobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 320, 290));

        mainmenu.add(TransactionPanel, "card2");

        Stocks.setBackground(new java.awt.Color(245, 245, 220));
        Stocks.setMaximumSize(new java.awt.Dimension(1000, 600));
        Stocks.setMinimumSize(new java.awt.Dimension(1000, 600));
        Stocks.setPreferredSize(new java.awt.Dimension(1000, 600));
        Stocks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header1.setBackground(new java.awt.Color(47, 118, 4));
        Header1.setMaximumSize(new java.awt.Dimension(1000, 59));
        Header1.setMinimumSize(new java.awt.Dimension(1000, 59));
        Header1.setPreferredSize(new java.awt.Dimension(1000, 59));
        Header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/logo_vegan2.png"))); // NOI18N
        Header1.add(Logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 80, 70));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("VEGAN");
        Header1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sales & Stock Control Management System");
        Header1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        Stocks.add(Header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 120));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_items2.setBackground(new java.awt.Color(0, 153, 0));
        btn_items2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        btn_items2.setForeground(new java.awt.Color(255, 255, 255));
        btn_items2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_items2.setText("Cashier");
        btn_items2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_items2.setOpaque(true);
        btn_items2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_items2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_items2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_items2MouseExited(evt);
            }
        });
        jPanel4.add(btn_items2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 206, 58));

        btn_logout2.setBackground(new java.awt.Color(0, 153, 0));
        btn_logout2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        btn_logout2.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_logout2.setText("Back to Inventory");
        btn_logout2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout2.setOpaque(true);
        btn_logout2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logout2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logout2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logout2MouseExited(evt);
            }
        });
        jPanel4.add(btn_logout2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 234, 206, 58));

        btn_avl_stocks2.setBackground(new java.awt.Color(0, 153, 0));
        btn_avl_stocks2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        btn_avl_stocks2.setForeground(new java.awt.Color(255, 255, 255));
        btn_avl_stocks2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_avl_stocks2.setText("Available Stocks");
        btn_avl_stocks2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_avl_stocks2.setOpaque(true);
        btn_avl_stocks2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_avl_stocks2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_avl_stocks2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_avl_stocks2MouseExited(evt);
            }
        });
        jPanel4.add(btn_avl_stocks2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 165, 206, 58));

        Stocks.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 130, 230, 460));

        InvTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "CATEGORY", "CAPITAL PER KILO", "STOCKS", "SALES PER KILO", "DAMAGE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        InvTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InvTableMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(InvTable);

        Stocks.add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 710, 370));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/searchIcon.png"))); // NOI18N
        Stocks.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 30, 30));

        SearchBar.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        SearchBar.setText("Search");
        SearchBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchBarMouseClicked(evt);
            }
        });
        SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarActionPerformed(evt);
            }
        });
        SearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchBarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SearchBarKeyTyped(evt);
            }
        });
        Stocks.add(SearchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 240, 32));

        numProd.setBackground(new java.awt.Color(245, 245, 220));
        numProd.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        numProd.setText("0");
        Stocks.add(numProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, -1, -1));

        totalnum.setBackground(new java.awt.Color(245, 245, 220));
        totalnum.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        totalnum.setText("Total no. of products:");
        Stocks.add(totalnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, -1, -1));

        mainmenu.add(Stocks, "card2");

        receipt.setBackground(new java.awt.Color(0, 204, 102));
        receipt.setMaximumSize(new java.awt.Dimension(1000, 600));
        receipt.setMinimumSize(new java.awt.Dimension(1000, 600));
        receipt.setPreferredSize(new java.awt.Dimension(1000, 600));
        receipt.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                receiptPropertyChange(evt);
            }
        });
        receipt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel41FocusGained(evt);
            }
        });
        jPanel41.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel41ComponentShown(evt);
            }
        });
        jPanel41.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanel41PropertyChange(evt);
            }
        });

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        printTextArea.setEditable(false);
        printTextArea.setColumns(20);
        printTextArea.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        printTextArea.setRows(5);
        printTextArea.setText("\t");
        printTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printTextAreaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(printTextArea);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("FINISH");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(267, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        receipt.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 610));

        mainmenu.add(receipt, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_itemsMouseClicked
    mainmenu.removeAll();
    mainmenu.repaint();
    mainmenu.revalidate();
    mainmenu.add(TransactionPanel);
    mainmenu.repaint();
    mainmenu.revalidate();
        
    }//GEN-LAST:event_btn_itemsMouseClicked

    private void btn_itemsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_itemsMouseEntered
        btn_items.setBackground(new java.awt.Color(51,255,51));
        btn_items.setForeground(new java.awt.Color(0,153,0));
        btn_items.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_itemsMouseEntered

    private void btn_itemsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_itemsMouseExited
        btn_items.setBackground(new java.awt.Color(0,153,0));
        btn_items.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_itemsMouseExited

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        Product toProduct = new Product();
        toProduct.show();
        dispose();
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
        btn_logout.setBackground(new java.awt.Color(51,255,51));
        btn_logout.setForeground(new java.awt.Color(0,153,0));
        btn_logout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
        btn_logout.setBackground(new java.awt.Color(0,153,0));
        btn_logout.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_logoutMouseExited

    private void btn_avl_stocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocksMouseClicked
    mainmenu.removeAll();
    mainmenu.repaint();
    mainmenu.revalidate();
    mainmenu.add(Stocks);
    mainmenu.repaint();
    mainmenu.revalidate();
    }//GEN-LAST:event_btn_avl_stocksMouseClicked

    private void btn_avl_stocksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocksMouseEntered
    btn_avl_stocks.setBackground(new java.awt.Color(51,255,51));
    btn_avl_stocks.setForeground(new java.awt.Color(0,153,0));
    btn_avl_stocks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_avl_stocksMouseEntered

    private void btn_avl_stocksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocksMouseExited
        btn_avl_stocks.setBackground(new java.awt.Color(0,153,0));
        btn_avl_stocks.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_avl_stocksMouseExited

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
    int row = table.getSelectedRow();
    code.setText(table.getModel().getValueAt(row,0).toString());
    name.setText(table.getModel().getValueAt(row,1).toString());
    item_input1.setText(table.getModel().getValueAt(row,1).toString());
    quantity.setText(table.getModel().getValueAt(row,2).toString());
    price.setText(table.getModel().getValueAt(row,3).toString());
    subtotal.setText(table.getModel().getValueAt(row,4).toString());
    
    for (int i = 0; i < InvTable.getRowCount();i++){
        String id = (InvTable.getModel().getValueAt(i, 0).toString());
        if (id.equals(table.getModel().getValueAt(row,0).toString())){
            stocks.setText(InvTable.getModel().getValueAt(i, 4).toString());
        }   
    }
    btn_removecart.setEnabled(true);
    quantity.setEditable(true);
    }//GEN-LAST:event_tableMouseClicked

    private void btn_removecartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removecartMouseExited
        btn_removecart.setBackground(new java.awt.Color(0,153,0));
        btn_removecart.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_removecartMouseExited

    private void btn_removecartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removecartMouseEntered
        btn_removecart.setBackground(new java.awt.Color(51,255,51));
        btn_removecart.setForeground(new java.awt.Color(0,153,0));
        btn_removecart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_removecartMouseEntered

    private void btn_removecartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removecartMouseClicked
    if (!(code.getText()).isEmpty()){
        DefaultTableModel model;
        model = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();
        if(table.getSelectedRow() != -1) {
               // remove selected row from the model
               float gtotal = Float.parseFloat(totalamount.getText());
               float subT = Float.parseFloat(subtotal.getText());
               totalamount.setText(Float.toString(gtotal - subT));
               model.removeRow(row);
               
               float newquan = (Float.parseFloat(stocks.getText())) + Float.parseFloat(quantity.getText());
               String capt = "";
                DefaultTableModel model2 = (DefaultTableModel) InvTable.getModel();
                Object objquant = newquan;
                for (int i = 0; i < InvTable.getRowCount();i++){
                       String codeID = InvTable.getModel().getValueAt(i, 0).toString();
                       if (codeID.startsWith(code.getText()) ){
                           InvTable.getModel().setValueAt(objquant, i, 4);
                           String id = (InvTable.getModel().getValueAt(i, 0)).toString();
                           String namee = (InvTable.getModel().getValueAt(i, 1).toString());
                           String cate = (InvTable.getModel().getValueAt(i, 2).toString());
                           capt = (InvTable.getModel().getValueAt(i, 3).toString());
                           String quant = (InvTable.getModel().getValueAt(i, 4).toString());
                           String pricee = (InvTable.getModel().getValueAt(i, 5).toString());
                           String damage = (InvTable.getModel().getValueAt(i, 6).toString());
                           
                           Edit edit = new Edit (id,namee,cate,capt,quant,pricee,damage,i);


                       }
                    
                }
               
               code.setText("");
               name.setText("");
               price.setText("");
               stocks.setText("");
               item_input1.setText("");
               quantity.setText("");
               subtotal.setText("");
        }
    }
    if(Float.parseFloat(totalamount.getText()) != 0){
       btn_process.setEnabled(true); 
    }else{
        btn_process.setEnabled(false); 
    } 
    
    }//GEN-LAST:event_btn_removecartMouseClicked

    private void quantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyTyped

    }//GEN-LAST:event_quantityKeyTyped

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
       String stocksT = "";
        for (int i = 0; i < InvTable.getRowCount();i++){
           String sName = InvTable.getModel().getValueAt(i, 0).toString();
           if (sName.startsWith(code.getText()) ){
               stocksT = (InvTable.getModel().getValueAt(i, 4).toString());
               
           }
        }
        
        if (quantity.getText().isEmpty()){
            subtotal.setText("");
            stocks.setText(stocksT);
        }
        else if (!quantity.getText().isEmpty()){ // check if input is number
            float fvalue;
            try {
                fvalue = Float.parseFloat(quantity.getText());  
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Plese input the Quantity in Kilogram"); 
            quantity.setText("");
            return;
            }
            
            float q = Float.parseFloat(quantity.getText());
            float s = Float.parseFloat(stocksT);
            float p = Float.parseFloat(price.getText());
            float newStocks = s-q;
            Double rounded = Math.round(newStocks * 1000)/1000.0;
            stocks.setText(Double.toString(rounded));
            
            if (newStocks < 0){         //check if out of stock
                JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    quantity.setText("");
                    subtotal.setText("");
                    item_input1.setText("");
                    stocks.setText(stocksT);
                    return;

            }

            if(quantity.getText().equals("")){
                        subtotal.setText("");
                        stocks.setText(stocksT);
            }
            else{

                float total2 = p * q;
                Double newTotal = Math.round(total2 * 1000)/1000.0;
                subtotal.setText(Double.toString(newTotal));
            }
        }
    }//GEN-LAST:event_quantityKeyReleased

    private void quantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyPressed

    }//GEN-LAST:event_quantityKeyPressed

    private void btn_processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_processActionPerformed
    container.removeAll();
    container.repaint();
    container.revalidate();
    container.add(confirmBox);
    container.repaint();
    container.revalidate();
    total1.setText(totalamount.getText());
    }//GEN-LAST:event_btn_processActionPerformed

    private void btn_processMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_processMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_processMouseExited

    private void btn_processMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_processMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_processMouseEntered

    private void btn_processMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_processMouseClicked
    
    }//GEN-LAST:event_btn_processMouseClicked

    private void btn_processFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_processFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_processFocusLost

    private void item_input1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_input1KeyPressed

    
    }//GEN-LAST:event_item_input1KeyPressed

    private void item_input1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_input1KeyReleased
    if (item_input1.getText().equals("")){
        name.setText("");
        code.setText("");
        price.setText("");
        stocks.setText("");
        quantity.setText("");
        total.setText("");
    }else{
        for (int i = 0; i < InvTable.getRowCount();i++){
           String sName = InvTable.getModel().getValueAt(i, 1).toString();
           if (sName.startsWith(item_input1.getText()) || sName.substring(0, item_input1.getText().length()).equalsIgnoreCase(item_input1.getText())){
               code.setText(InvTable.getModel().getValueAt(i, 0).toString());
               name.setText(InvTable.getModel().getValueAt(i, 1).toString());
               price.setText(InvTable.getModel().getValueAt(i, 5).toString());
               stocks.setText(InvTable.getModel().getValueAt(i, 4).toString());
               quantity.setEnabled(true);
               quantity.setEditable(true);
           }
        }
       
        
    }
    }//GEN-LAST:event_item_input1KeyReleased

    private void item_input1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_input1KeyTyped
 
    }//GEN-LAST:event_item_input1KeyTyped

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void subtotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalKeyPressed

    private void subtotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalKeyReleased

    private void subtotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalKeyTyped

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void stocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stocksActionPerformed

    private void printTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printTextAreaMouseClicked

    }//GEN-LAST:event_printTextAreaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    DefaultTableModel model;
    model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);
    changee.setText("");
    totalamount.setText("");
    total1.setText("");
    amountt.setText("");
    
    mainmenu.removeAll();
    mainmenu.repaint();
    mainmenu.revalidate();
    mainmenu.add(TransactionPanel);
    mainmenu.repaint();
    mainmenu.revalidate();
    container.removeAll();
    container.repaint();
    container.revalidate();
    container.add(compute);
    container.repaint();
    container.revalidate();
    
    Toolkit tkp = printTextArea.getToolkit();
    PrintJob pjp = tkp.getPrintJob(this, null, null);
    Graphics g = pjp.getGraphics();
    printTextArea.print(g);
    g.dispose();
    pjp.end();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel41FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel41FocusGained

    }//GEN-LAST:event_jPanel41FocusGained

    private void jPanel41ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel41ComponentShown

    }//GEN-LAST:event_jPanel41ComponentShown

    private void jPanel41PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanel41PropertyChange

    }//GEN-LAST:event_jPanel41PropertyChange

    private void receiptPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_receiptPropertyChange

    }//GEN-LAST:event_receiptPropertyChange

    private void amounttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amounttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amounttActionPerformed

    private void changeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeeActionPerformed

    private void btn_process1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_process1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_process1FocusLost

    private void btn_process1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_process1MouseClicked
    
    }//GEN-LAST:event_btn_process1MouseClicked

    private void btn_process1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_process1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_process1MouseEntered

    private void btn_process1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_process1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_process1MouseExited

    private void btn_process1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_process1ActionPerformed
    mainmenu.removeAll();
    mainmenu.repaint();
    mainmenu.revalidate();
    mainmenu.add(receipt);
    mainmenu.repaint();
    mainmenu.revalidate();
    dataTo_file();
    getAllDataTo_Print();
    }//GEN-LAST:event_btn_process1ActionPerformed

    private void backFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_backFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_backFocusLost

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_backMouseExited

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    container.removeAll();
    container.repaint();
    container.revalidate();
    container.add(compute);
    container.repaint();
    container.revalidate();
    }//GEN-LAST:event_backActionPerformed

    private void btn_addcartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addcartMouseExited
        btn_addcart.setBackground(new java.awt.Color(0,153,0));
        btn_addcart.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_addcartMouseExited

    private void btn_addcartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addcartMouseEntered
        btn_addcart.setBackground(new java.awt.Color(51,255,51));
        btn_addcart.setForeground(new java.awt.Color(0,153,0));
    }//GEN-LAST:event_btn_addcartMouseEntered

    private void btn_addcartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addcartMouseClicked

    if (quantity.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "No Input");
        return;
    }else{    
    DefaultTableModel model;
    model = (DefaultTableModel) table.getModel();
    float gTotal = 0;
    
        if (table.getRowCount() == 0){
            gTotal += Float.parseFloat(subtotal.getText());
            String [] data = {code.getText(),name.getText(),quantity.getText(),price.getText(),subtotal.getText()};
            model.addRow(data);
        }else{
            
            ArrayList<String> items = new ArrayList<>(); //
            for(int i = 0; i < table.getRowCount();i++){
                String id =    table.getModel().getValueAt( i, 0).toString();
                String nam =    table.getModel().getValueAt( i, 1).toString();
                String quan =     table.getModel().getValueAt( i, 2).toString();
                String pric =    table.getModel().getValueAt( i, 3).toString();
                String subT =    table.getModel().getValueAt( i, 4).toString();
                float sT = Float.parseFloat(subT);
                gTotal +=  sT;
                String data = (id+","+nam+","+quan+","+pric+","+subT);
                items.add(data);
            }
            int u = 0;
            for (int i = 0; i < items.size(); i++){
                model.setRowCount(i);
                String data = items.get(i);
                String dataT[];
                dataT = data.split(",");
                
                if (data.startsWith(code.getText())){ // if the product is already in the table
                    
                    float quan = Float.parseFloat(dataT[2]) + Float.parseFloat(quantity.getText()) ;
                    float subT = Float.parseFloat(dataT[4]) + Float.parseFloat(subtotal.getText());
                    gTotal += Float.parseFloat(subtotal.getText());
                    String [] newData = {code.getText(),name.getText(),Float.toString(quan),price.getText(),Float.toString(subT)};
                    model.addRow(newData);
                    u = 1;
                }else {
                    model.addRow(dataT);
                }
            
            }
            if (u == 0){ // if product is not in the table
                    gTotal += Float.parseFloat(subtotal.getText());
                    
                    String [] nData = {code.getText(),name.getText(),quantity.getText(),price.getText(),subtotal.getText()};
                    model.addRow(nData);
            }

        }
        String capt = "";
        DefaultTableModel model2;
        model2 = (DefaultTableModel) InvTable.getModel();
        Object newStock = stocks.getText();
        System.out.println(stocks.getText() + " "+InvTable.getRowCount() );
        for (int i = 0; i < InvTable.getRowCount();i++){
               String codeID = InvTable.getModel().getValueAt(i, 0).toString();
               if (codeID.startsWith(code.getText()) ){
                   InvTable.getModel().setValueAt(newStock, i, 4);
                   String id = (InvTable.getModel().getValueAt(i, 0)).toString();
                   String namee = (InvTable.getModel().getValueAt(i, 1).toString());
                   String cate = (InvTable.getModel().getValueAt(i, 2).toString());
                   capt = (InvTable.getModel().getValueAt(i, 3).toString());
                   String quant = (InvTable.getModel().getValueAt(i, 4).toString());
                   String pricee = (InvTable.getModel().getValueAt(i, 5).toString());
                   String damage = (InvTable.getModel().getValueAt(i, 6).toString());
                   Edit edit = new Edit (id,namee,cate,capt,quant,pricee,damage,i); // to edit the quantity


               }
            }
        
               
    Double roundedTotal = Math.round(gTotal * 1000)/1000.0;
    code.setText("");
    name.setText("");
    quantity.setText("");
    price.setText("");
    subtotal.setText("");
    item_input1.setText("");
    stocks.setText("");
    totalamount.setText(Double.toString(roundedTotal));
    item_input1.setFocusable(true);
    quantity.setEditable(false);
    quantity.setEnabled(false);
    }
    btn_process.setEnabled(true);
        
    }//GEN-LAST:event_btn_addcartMouseClicked

    private void item_input1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_input1ActionPerformed
    
    }//GEN-LAST:event_item_input1ActionPerformed

    private void btn_items2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_items2MouseClicked
    mainmenu.removeAll();
    mainmenu.repaint();
    mainmenu.revalidate();
    mainmenu.add(TransactionPanel);
    mainmenu.repaint();
    mainmenu.revalidate();
    }//GEN-LAST:event_btn_items2MouseClicked

    private void btn_items2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_items2MouseEntered
    btn_items2.setBackground(new java.awt.Color(51,255,51));
    btn_items2.setForeground(new java.awt.Color(0,153,0));
    btn_items2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_items2MouseEntered

    private void btn_items2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_items2MouseExited
    btn_items2.setBackground(new java.awt.Color(0,153,0));
    btn_items2.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_items2MouseExited

    private void btn_logout2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logout2MouseClicked
        Product toProduct = new Product();
        toProduct.show();
        dispose();    
    }//GEN-LAST:event_btn_logout2MouseClicked

    private void btn_logout2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logout2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logout2MouseEntered

    private void btn_logout2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logout2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logout2MouseExited

    private void btn_avl_stocks2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocks2MouseClicked
    mainmenu.removeAll();
    mainmenu.repaint();
    mainmenu.revalidate();
    mainmenu.add(Stocks);
    mainmenu.repaint();
    mainmenu.revalidate();
//    refresh_table();
    }//GEN-LAST:event_btn_avl_stocks2MouseClicked

    private void btn_avl_stocks2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocks2MouseEntered
    btn_avl_stocks2.setBackground(new java.awt.Color(51,255,51));
    btn_avl_stocks2.setForeground(new java.awt.Color(0,153,0));
    btn_avl_stocks2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_avl_stocks2MouseEntered

    private void btn_avl_stocks2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocks2MouseExited
    btn_avl_stocks2.setBackground(new java.awt.Color(0,153,0));
    btn_avl_stocks2.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_avl_stocks2MouseExited

    private void InvTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InvTableMouseClicked


    }//GEN-LAST:event_InvTableMouseClicked

    private void SearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchBarMouseClicked
        SearchBar.setText("");
    }//GEN-LAST:event_SearchBarMouseClicked

    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
        refresh_table();
    }//GEN-LAST:event_SearchBarActionPerformed

    private void SearchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarKeyPressed
        //        SearchBar.setText("");
    }//GEN-LAST:event_SearchBarKeyPressed

    private void SearchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarKeyReleased
//        search_name(SearchBar.getText());
//        clear_text();
    }//GEN-LAST:event_SearchBarKeyReleased

    private void SearchBarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarKeyTyped

    }//GEN-LAST:event_SearchBarKeyTyped

    private void item_input1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item_input1MouseClicked
        item_input1.setText("");
    }//GEN-LAST:event_item_input1MouseClicked

    private void quantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityMouseClicked
    quantity.setText("");
    subtotal.setText("");
    }//GEN-LAST:event_quantityMouseClicked

    private void amounttKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amounttKeyReleased
        if(!amountt.getText().isEmpty()){
        float amnt =0;
        try{
        amnt = Float.parseFloat(amountt.getText());
        }catch(NumberFormatException w){
            JOptionPane.showMessageDialog(null, "Invalid Input");
            amountt.setText("");
            amountt.setFocusable(true);
            return;
        }
        float totall = Float.parseFloat(total1.getText());
        float chng = amnt - totall;
        Double roundedChange = Math.round(chng * 1000)/1000.0;
        
        changee.setText(Double.toString(roundedChange));
           if (chng >= 0 ){
              btn_process1.setEnabled(true);
           }else{
              btn_process1.setEnabled(false); 
           }
        }else{
            changee.setText("");
            amountt.setText("");
        }
        

    }//GEN-LAST:event_amounttKeyReleased

    private void amounttFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amounttFocusLost
    
        if (Float.parseFloat(changee.getText()) < 0 ){
           JOptionPane.showMessageDialog(null, "Amount is not enough");
           amountt.setText("");
           changee.setText("");
           amountt.setFocusable(true);
           return;
        }
    }//GEN-LAST:event_amounttFocusLost

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
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Header1;
    private javax.swing.JPanel Infobox;
    private javax.swing.JTable InvTable;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Logo1;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JPanel Stocks;
    private javax.swing.JPanel TransactionPanel;
    private javax.swing.JLabel amount;
    private javax.swing.JTextField amountt;
    private javax.swing.JButton back;
    private javax.swing.JLabel btn_addcart;
    private javax.swing.JLabel btn_avl_stocks;
    private javax.swing.JLabel btn_avl_stocks2;
    private javax.swing.JLabel btn_items;
    private javax.swing.JLabel btn_items2;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_logout2;
    private javax.swing.JButton btn_process;
    private javax.swing.JButton btn_process1;
    private javax.swing.JLabel btn_removecart;
    private javax.swing.JLabel change;
    private javax.swing.JTextField changee;
    private javax.swing.JTextField code;
    public javax.swing.JPanel compute;
    private javax.swing.JPanel confirmBox;
    private javax.swing.JPanel container;
    private javax.swing.JTextField item_input1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel41;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainmenu;
    private javax.swing.JTextField name;
    private javax.swing.JLabel numProd;
    private javax.swing.JTextField price;
    private javax.swing.JTextArea printTextArea;
    private javax.swing.JTextField quantity;
    private javax.swing.JPanel receipt;
    private javax.swing.JTextField stocks;
    private javax.swing.JLabel stocks19;
    private javax.swing.JLabel stocks20;
    private javax.swing.JLabel stocks21;
    private javax.swing.JLabel stocks22;
    private javax.swing.JLabel stocks23;
    private javax.swing.JLabel stocks26;
    private javax.swing.JLabel stocks27;
    private javax.swing.JLabel stocks32;
    private javax.swing.JTextField subtotal;
    public javax.swing.JTable table;
    private javax.swing.JLabel total;
    private javax.swing.JTextField total1;
    public javax.swing.JTextField totalamount;
    private javax.swing.JLabel totalnum;
    // End of variables declaration//GEN-END:variables
}
