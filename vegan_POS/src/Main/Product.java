package Main;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;




public class Product extends javax.swing.JFrame {
// int num_prod;
 static float num_fruits ;
 static float num_vegetables;
 String pathlogo = System.getProperty("user.dir") + "\\src\\picture\\vegan_logo2.png";
 ImageIcon logo = new ImageIcon(pathlogo);

    public Product() {
        initComponents();
        refresh_table();
        report_table();
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
    num_fruits  = 0;
    num_vegetables = 0;
    float num_damage = 0;
    try {
        String path = System.getProperty("user.dir") + "\\src\\DB\\StockIn.txt";
        File products = new File(path);
        Scanner dataIn = new Scanner(products);
//        int row = 0;
//        String temp = "";

        while(dataIn.hasNext()) {
            float vege = 0;
            float fruits = 0;
            float damage = 0;
            String[] data = dataIn.nextLine().split(",");
            num_prod++;
            damage = Float.parseFloat(data[6]);
            model.addRow(data);
            
            if (data[2].equals("Fruit")){
                fruits = Float.parseFloat(data[4]);
                num_fruits += fruits;
                System.out.println(fruits);

            }
            if (data[2].equals("Vegetable")){
                vege = Float.parseFloat(data[4]);
                num_vegetables += vege ;

            }
            num_damage += damage;
        }
        
    } catch (FileNotFoundException ex) {

    } 
       numProd.setText(Integer.toString(num_prod));
       Pic1LB1.setText(Integer.toString(num_prod));
       Double roundedV = Math.round(num_vegetables * 1000)/1000.0;
       Pic2LB1.setText(Double.toString(roundedV)+" Kg");
       Double roundedF = Math.round(num_fruits* 1000)/1000.0;
       Pic3LB1.setText(Double.toString(roundedF)+" Kg");
       Double roundedD = Math.round(num_damage * 1000)/1000.0;
       Pic5LB1.setText(Double.toString(roundedD)+" Kg");
       
    }
 private void report_table(){
    DefaultTableModel model;
    model = (DefaultTableModel) outTable.getModel();
    model.setRowCount(0);
    int numP = 0;
    float numProfit = 0;
    try{
        String path = System.getProperty("user.dir") + "\\src\\DB\\StockOut.txt";
        File products = new File(path);
        Scanner dataIn = new Scanner(products);
         while(dataIn.hasNext()) {
            float profit = 0;
            String[] data = dataIn.nextLine().split(",");
            numP++;
            model.addRow(data);
            profit = Float.parseFloat(data[6]);
            numProfit += profit;
         }
    Double roundedProf = Math.round(numProfit * 1000)/1000.0;
    Pic4LB1.setText("P"+Double.toString(roundedProf));
        
    }catch (FileNotFoundException ex) {

    }
    totOutProduct.setText(Integer.toString(numP));
    totProfit.setText(Float.toString(numProfit));
 }
 
 private void search_name(String name){
     
     
//    DefaultTableModel table = (DefaultTableModel)InvTable.getModel();
//    String search = name;
//
//    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
//    InvTable.setRowSorter(tr);
//    tr.setRowFilter(RowFilter.regexFilter("^"+search));     
    DefaultTableModel model;
    model = (DefaultTableModel) InvTable.getModel();
    model.setRowCount(0);
    try {
        String path = System.getProperty("user.dir") + "\\src\\DB\\StockIn.txt";
        File products = new File(path);
        Scanner dataIn = new Scanner(products);
//        int row = 0;
//        String temp = "";

        while(dataIn.hasNext()) {
            String[] data = dataIn.nextLine().split(",");
            if (data[1].substring(0,name.length()).equalsIgnoreCase(name) || data[1].startsWith(name)){
                model.addRow(data);
                clear_text();
            }
        } 
    } catch (FileNotFoundException ex) {

    }
    clear_text();
 }
 
 int randomNum(){
      int min = 1000;
      int max = 100000;
      
      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
        
        
    }
 private Integer check_U(String name){
     int u=0;
     
     for (int i = 0; i < InvTable.getRowCount(); i++) {
        String newName = (InvTable.getModel().getValueAt(i, 1).toString());
        if (newName.equals(name) ){
            u = 1;
            
        }
        
    }

   return  u;
 }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Main_Frame = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Side_Menu = new javax.swing.JPanel();
        ProductsTab = new javax.swing.JPanel();
        btnProducts = new javax.swing.JLabel();
        InventoryTab = new javax.swing.JPanel();
        btnInventory = new javax.swing.JLabel();
        TransactionTab = new javax.swing.JPanel();
        btnTransaction = new javax.swing.JLabel();
        ReportsTab = new javax.swing.JPanel();
        btnReports = new javax.swing.JLabel();
        AboutTab = new javax.swing.JPanel();
        btnAbout = new javax.swing.JLabel();
        Mainmenu = new javax.swing.JPanel();
        Summary = new javax.swing.JPanel();
        Overview = new javax.swing.JLabel();
        Pic1Panel1 = new javax.swing.JPanel();
        Pic1Panel2 = new javax.swing.JPanel();
        Pic1 = new javax.swing.JLabel();
        Pic1LB1 = new javax.swing.JLabel();
        Pic1LB2 = new javax.swing.JLabel();
        Pic2Panel1 = new javax.swing.JPanel();
        Pic2Panel2 = new javax.swing.JPanel();
        Pic2 = new javax.swing.JLabel();
        Pic2LB1 = new javax.swing.JLabel();
        Pic2LB2 = new javax.swing.JLabel();
        Pic2LB3 = new javax.swing.JLabel();
        Pic3Panel1 = new javax.swing.JPanel();
        Pic3Panel2 = new javax.swing.JPanel();
        Pic3 = new javax.swing.JLabel();
        Pic3LB1 = new javax.swing.JLabel();
        Pic3LB2 = new javax.swing.JLabel();
        Pic3LB3 = new javax.swing.JLabel();
        Pic4Panel1 = new javax.swing.JPanel();
        Pic4Panel2 = new javax.swing.JPanel();
        Pic4 = new javax.swing.JLabel();
        Pic4LB1 = new javax.swing.JLabel();
        Pic4LB2 = new javax.swing.JLabel();
        Pic5Panel1 = new javax.swing.JPanel();
        Pic5Panel2 = new javax.swing.JPanel();
        Pic5 = new javax.swing.JLabel();
        Pic5LB1 = new javax.swing.JLabel();
        Pic5LB2 = new javax.swing.JLabel();
        Inventory = new javax.swing.JPanel();
        SearchPanel = new javax.swing.JPanel();
        SearchBar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        numitemsPanel = new javax.swing.JPanel();
        totalnum = new javax.swing.JLabel();
        numProd = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        InvTable = new javax.swing.JTable();
        ProdInfoPanel = new javax.swing.JPanel();
        ProdInfoTitlePnl = new javax.swing.JPanel();
        ProdInfo = new javax.swing.JLabel();
        ItemIDLB = new javax.swing.JLabel();
        IDPanel = new javax.swing.JPanel();
        ID = new javax.swing.JLabel();
        ItemNameLB = new javax.swing.JLabel();
        Category = new javax.swing.JTextField();
        CategoryLB = new javax.swing.JLabel();
        PriceLB = new javax.swing.JLabel();
        Price = new javax.swing.JTextField();
        AvStocksLB = new javax.swing.JLabel();
        AvStocks = new javax.swing.JTextField();
        StatusLB = new javax.swing.JLabel();
        Damage = new javax.swing.JTextField();
        DelbtnPanel = new javax.swing.JPanel();
        DeleteBTN = new javax.swing.JButton();
        AddbtnPanel = new javax.swing.JPanel();
        AddBTN = new javax.swing.JButton();
        EditbtnPanel = new javax.swing.JPanel();
        EditBTN = new javax.swing.JButton();
        EditbtnPanel1 = new javax.swing.JPanel();
        DamageBTN = new javax.swing.JButton();
        SalesT = new javax.swing.JTextField();
        CategoryLB1 = new javax.swing.JLabel();
        Namee = new javax.swing.JTextField();
        ADDPanel = new javax.swing.JPanel();
        AddBoxPanel = new javax.swing.JPanel();
        AddHeader = new javax.swing.JPanel();
        AddLabel = new javax.swing.JLabel();
        ItemIDlb = new javax.swing.JLabel();
        AddItemNameLB = new javax.swing.JLabel();
        AddCategoryLB = new javax.swing.JLabel();
        AddCapitalLB = new javax.swing.JLabel();
        AddStocksLB = new javax.swing.JLabel();
        AddStocks = new javax.swing.JTextField();
        AddCapital = new javax.swing.JTextField();
        AddItembtn = new javax.swing.JButton();
        ADDbackbtn = new javax.swing.JButton();
        AddSales = new javax.swing.JTextField();
        AddStocksLB1 = new javax.swing.JLabel();
        Add_Id = new javax.swing.JTextField();
        AddItemName = new javax.swing.JTextField();
        CategoryBox = new javax.swing.JComboBox<>();
        EDITPanel = new javax.swing.JPanel();
        EditBoxPanel = new javax.swing.JPanel();
        EditHeader = new javax.swing.JPanel();
        EditLabel = new javax.swing.JLabel();
        EditItemIDlb = new javax.swing.JLabel();
        EditItemIDLB1 = new javax.swing.JPanel();
        Edit_Id = new javax.swing.JLabel();
        EditItemNameLB = new javax.swing.JLabel();
        EditCategoryLB = new javax.swing.JLabel();
        EditPriceLB = new javax.swing.JLabel();
        EditStocksLB = new javax.swing.JLabel();
        EditName = new javax.swing.JTextField();
        EditPrice = new javax.swing.JTextField();
        EditStocks = new javax.swing.JTextField();
        DeleteItembtn = new javax.swing.JButton();
        Editbackbtn = new javax.swing.JButton();
        EditCapital = new javax.swing.JTextField();
        EditCategoryLB1 = new javax.swing.JLabel();
        categoryBox2 = new javax.swing.JComboBox<>();
        categoryBox1 = new javax.swing.JComboBox<>();
        DELETEPanel = new javax.swing.JPanel();
        deleteCont = new javax.swing.JPanel();
        DeleteBoxPanel = new javax.swing.JPanel();
        DeleteHeader = new javax.swing.JPanel();
        DeleteLabel = new javax.swing.JLabel();
        DeleteItemIDlb = new javax.swing.JLabel();
        EditItemNameLB2 = new javax.swing.JLabel();
        EditCategoryLB2 = new javax.swing.JLabel();
        EditPriceLB2 = new javax.swing.JLabel();
        EditStocksLB2 = new javax.swing.JLabel();
        AddItemID7 = new javax.swing.JLabel();
        Deletebackbtn = new javax.swing.JButton();
        DelelteItembtn = new javax.swing.JButton();
        EditCategoryLB3 = new javax.swing.JLabel();
        EditStocksLB3 = new javax.swing.JLabel();
        Del1 = new javax.swing.JTextField();
        Del2 = new javax.swing.JTextField();
        Del3 = new javax.swing.JTextField();
        Del4 = new javax.swing.JTextField();
        Del5 = new javax.swing.JTextField();
        Del6 = new javax.swing.JTextField();
        Del7 = new javax.swing.JTextField();
        Del8 = new javax.swing.JTextField();
        ConfirmDel = new javax.swing.JPanel();
        Del = new javax.swing.JPanel();
        deltext = new javax.swing.JLabel();
        conDelBtn = new javax.swing.JButton();
        conCnlBtn1 = new javax.swing.JButton();
        About = new javax.swing.JPanel();
        AboutBoxPanel = new javax.swing.JPanel();
        Vegan = new javax.swing.JLabel();
        text1 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        text3 = new javax.swing.JLabel();
        text4 = new javax.swing.JLabel();
        text5 = new javax.swing.JLabel();
        text6 = new javax.swing.JLabel();
        DAMAGED = new javax.swing.JPanel();
        AddBoxPanel1 = new javax.swing.JPanel();
        AddHeader1 = new javax.swing.JPanel();
        AddLabel1 = new javax.swing.JLabel();
        DmEnterLB = new javax.swing.JLabel();
        DmEnter = new javax.swing.JTextField();
        DmEnterbtn = new javax.swing.JButton();
        DmCnlbtn = new javax.swing.JButton();
        DmItemNameLB = new javax.swing.JLabel();
        DmCategoryLB = new javax.swing.JLabel();
        DmPriceLB = new javax.swing.JLabel();
        DmStocksLB = new javax.swing.JLabel();
        DmItemIDLB = new javax.swing.JPanel();
        DmItemID = new javax.swing.JLabel();
        DmCategory = new javax.swing.JTextField();
        DmPrice = new javax.swing.JTextField();
        DmStocks = new javax.swing.JTextField();
        DmItemName = new javax.swing.JTextField();
        DmIDlb = new javax.swing.JLabel();
        ReportsPanel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        StockOut1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        totProfit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        totOutProduct = new javax.swing.JTextField();
        SearchBar1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VEGAN");
        setLocation(new java.awt.Point(190, 60));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        Main_Frame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Main_Frame.setMaximumSize(new java.awt.Dimension(1000, 600));
        Main_Frame.setMinimumSize(new java.awt.Dimension(1000, 600));
        Main_Frame.setPreferredSize(new java.awt.Dimension(1000, 600));
        Main_Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(47, 118, 4));
        Header.setMaximumSize(new java.awt.Dimension(1000, 59));
        Header.setMinimumSize(new java.awt.Dimension(1000, 59));
        Header.setPreferredSize(new java.awt.Dimension(1000, 59));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/logo_vegan2.png"))); // NOI18N
        Header.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 70));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("V E G A N");
        Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sales & Stock Control Management System");
        Header.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        Main_Frame.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 80));

        Side_Menu.setBackground(new java.awt.Color(36, 52, 7));
        Side_Menu.setMaximumSize(new java.awt.Dimension(164, 543));
        Side_Menu.setMinimumSize(new java.awt.Dimension(164, 543));
        Side_Menu.setPreferredSize(new java.awt.Dimension(164, 543));
        Side_Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ProductsTab.setBackground(new java.awt.Color(36, 52, 7));
        ProductsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductsTabMouseClicked(evt);
            }
        });

        btnProducts.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnProducts.setForeground(new java.awt.Color(255, 255, 255));
        btnProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProducts.setText("Products");
        btnProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ProductsTabLayout = new javax.swing.GroupLayout(ProductsTab);
        ProductsTab.setLayout(ProductsTabLayout);
        ProductsTabLayout.setHorizontalGroup(
            ProductsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ProductsTabLayout.setVerticalGroup(
            ProductsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        Side_Menu.add(ProductsTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 19, 170, -1));

        InventoryTab.setBackground(new java.awt.Color(36, 52, 7));
        InventoryTab.setPreferredSize(new java.awt.Dimension(77, 56));
        InventoryTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InventoryTabMouseClicked(evt);
            }
        });

        btnInventory.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnInventory.setForeground(new java.awt.Color(255, 255, 255));
        btnInventory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInventory.setText("Inventory");
        btnInventory.setMaximumSize(new java.awt.Dimension(77, 25));
        btnInventory.setMinimumSize(new java.awt.Dimension(77, 25));
        btnInventory.setPreferredSize(new java.awt.Dimension(77, 25));
        btnInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInventoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInventoryMouseExited(evt);
            }
        });

        javax.swing.GroupLayout InventoryTabLayout = new javax.swing.GroupLayout(InventoryTab);
        InventoryTab.setLayout(InventoryTabLayout);
        InventoryTabLayout.setHorizontalGroup(
            InventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        InventoryTabLayout.setVerticalGroup(
            InventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventoryTabLayout.createSequentialGroup()
                .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        Side_Menu.add(InventoryTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 81, 170, -1));

        TransactionTab.setBackground(new java.awt.Color(36, 52, 7));
        TransactionTab.setMaximumSize(new java.awt.Dimension(77, 56));
        TransactionTab.setMinimumSize(new java.awt.Dimension(77, 56));
        TransactionTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransactionTabMouseClicked(evt);
            }
        });

        btnTransaction.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnTransaction.setForeground(new java.awt.Color(255, 255, 255));
        btnTransaction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTransaction.setText("Transaction");
        btnTransaction.setMaximumSize(new java.awt.Dimension(77, 56));
        btnTransaction.setMinimumSize(new java.awt.Dimension(77, 56));
        btnTransaction.setPreferredSize(new java.awt.Dimension(77, 56));
        btnTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTransactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTransactionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout TransactionTabLayout = new javax.swing.GroupLayout(TransactionTab);
        TransactionTab.setLayout(TransactionTabLayout);
        TransactionTabLayout.setHorizontalGroup(
            TransactionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransactionTabLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TransactionTabLayout.setVerticalGroup(
            TransactionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionTabLayout.createSequentialGroup()
                .addComponent(btnTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Side_Menu.add(TransactionTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 143, 170, -1));

        ReportsTab.setBackground(new java.awt.Color(36, 52, 7));
        ReportsTab.setMaximumSize(new java.awt.Dimension(77, 56));
        ReportsTab.setMinimumSize(new java.awt.Dimension(77, 56));
        ReportsTab.setPreferredSize(new java.awt.Dimension(77, 56));
        ReportsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReportsTabMouseClicked(evt);
            }
        });

        btnReports.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnReports.setForeground(new java.awt.Color(255, 255, 255));
        btnReports.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReports.setText("Reports");
        btnReports.setMaximumSize(new java.awt.Dimension(77, 25));
        btnReports.setMinimumSize(new java.awt.Dimension(77, 25));
        btnReports.setPreferredSize(new java.awt.Dimension(77, 25));
        btnReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ReportsTabLayout = new javax.swing.GroupLayout(ReportsTab);
        ReportsTab.setLayout(ReportsTabLayout);
        ReportsTabLayout.setHorizontalGroup(
            ReportsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
            .addGroup(ReportsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ReportsTabLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ReportsTabLayout.setVerticalGroup(
            ReportsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(ReportsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ReportsTabLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Side_Menu.add(ReportsTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 205, 170, 60));

        AboutTab.setBackground(new java.awt.Color(36, 52, 7));
        AboutTab.setMaximumSize(new java.awt.Dimension(77, 56));
        AboutTab.setMinimumSize(new java.awt.Dimension(77, 56));
        AboutTab.setPreferredSize(new java.awt.Dimension(77, 56));
        AboutTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutTabMouseClicked(evt);
            }
        });

        btnAbout.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnAbout.setForeground(new java.awt.Color(255, 255, 255));
        btnAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAbout.setText("About");
        btnAbout.setMaximumSize(new java.awt.Dimension(77, 25));
        btnAbout.setMinimumSize(new java.awt.Dimension(77, 25));
        btnAbout.setPreferredSize(new java.awt.Dimension(77, 25));
        btnAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAboutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAboutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout AboutTabLayout = new javax.swing.GroupLayout(AboutTab);
        AboutTab.setLayout(AboutTabLayout);
        AboutTabLayout.setHorizontalGroup(
            AboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAbout, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        AboutTabLayout.setVerticalGroup(
            AboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAbout, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        Side_Menu.add(AboutTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 267, 170, -1));

        Main_Frame.add(Side_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 170, 520));

        Mainmenu.setLayout(new java.awt.CardLayout());

        Summary.setBackground(new java.awt.Color(245, 245, 220));
        Summary.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Overview.setFont(new java.awt.Font("Tw Cen MT", 1, 55)); // NOI18N
        Overview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Overview.setText("OVERVIEW");
        Summary.add(Overview, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 300, 90));

        Pic1Panel1.setBackground(new java.awt.Color(119, 144, 100));

        Pic1Panel2.setBackground(new java.awt.Color(36, 52, 7));
        Pic1Panel2.setPreferredSize(new java.awt.Dimension(113, 113));

        Pic1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/4.png"))); // NOI18N

        javax.swing.GroupLayout Pic1Panel2Layout = new javax.swing.GroupLayout(Pic1Panel2);
        Pic1Panel2.setLayout(Pic1Panel2Layout);
        Pic1Panel2Layout.setHorizontalGroup(
            Pic1Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic1Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pic1Panel2Layout.setVerticalGroup(
            Pic1Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic1Panel2Layout.createSequentialGroup()
                .addComponent(Pic1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Pic1LB1.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        Pic1LB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic1LB1.setText("0");

        Pic1LB2.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        Pic1LB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic1LB2.setText("Total no. of Items");

        javax.swing.GroupLayout Pic1Panel1Layout = new javax.swing.GroupLayout(Pic1Panel1);
        Pic1Panel1.setLayout(Pic1Panel1Layout);
        Pic1Panel1Layout.setHorizontalGroup(
            Pic1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic1Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic1Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Pic1LB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pic1Panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Pic1LB2)
                .addGap(31, 31, 31))
        );
        Pic1Panel1Layout.setVerticalGroup(
            Pic1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic1Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic1Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pic1LB1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pic1LB2)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        Summary.add(Pic1Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 150, 210));

        Pic2Panel1.setBackground(new java.awt.Color(119, 144, 100));

        Pic2Panel2.setBackground(new java.awt.Color(36, 52, 7));
        Pic2Panel2.setPreferredSize(new java.awt.Dimension(113, 113));

        Pic2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/2.png"))); // NOI18N

        javax.swing.GroupLayout Pic2Panel2Layout = new javax.swing.GroupLayout(Pic2Panel2);
        Pic2Panel2.setLayout(Pic2Panel2Layout);
        Pic2Panel2Layout.setHorizontalGroup(
            Pic2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic2Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pic2Panel2Layout.setVerticalGroup(
            Pic2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic2Panel2Layout.createSequentialGroup()
                .addComponent(Pic2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Pic2LB1.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        Pic2LB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic2LB1.setText("0");

        Pic2LB2.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        Pic2LB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic2LB2.setText("Total no. of Vegetables");

        Pic2LB3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        Pic2LB3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic2LB3.setText("/10000 Kg");

        javax.swing.GroupLayout Pic2Panel1Layout = new javax.swing.GroupLayout(Pic2Panel1);
        Pic2Panel1.setLayout(Pic2Panel1Layout);
        Pic2Panel1Layout.setHorizontalGroup(
            Pic2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic2Panel1Layout.createSequentialGroup()
                .addGroup(Pic2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pic2Panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Pic2Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                    .addGroup(Pic2Panel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Pic2LB2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(Pic2LB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Pic2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Pic2Panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Pic2LB3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        Pic2Panel1Layout.setVerticalGroup(
            Pic2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic2Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic2Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pic2LB1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(Pic2LB2)
                .addContainerGap())
            .addGroup(Pic2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pic2Panel1Layout.createSequentialGroup()
                    .addContainerGap(184, Short.MAX_VALUE)
                    .addComponent(Pic2LB3)
                    .addGap(25, 25, 25)))
        );

        Summary.add(Pic2Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 150, 230));

        Pic3Panel1.setBackground(new java.awt.Color(119, 144, 100));

        Pic3Panel2.setBackground(new java.awt.Color(36, 52, 7));
        Pic3Panel2.setPreferredSize(new java.awt.Dimension(113, 113));

        Pic3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/3.png"))); // NOI18N

        javax.swing.GroupLayout Pic3Panel2Layout = new javax.swing.GroupLayout(Pic3Panel2);
        Pic3Panel2.setLayout(Pic3Panel2Layout);
        Pic3Panel2Layout.setHorizontalGroup(
            Pic3Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic3Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pic3Panel2Layout.setVerticalGroup(
            Pic3Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic3Panel2Layout.createSequentialGroup()
                .addComponent(Pic3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Pic3LB1.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        Pic3LB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic3LB1.setText("0");

        Pic3LB2.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        Pic3LB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic3LB2.setText("Total no. of Fruits");

        Pic3LB3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        Pic3LB3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic3LB3.setText("/10000 Kg");

        javax.swing.GroupLayout Pic3Panel1Layout = new javax.swing.GroupLayout(Pic3Panel1);
        Pic3Panel1.setLayout(Pic3Panel1Layout);
        Pic3Panel1Layout.setHorizontalGroup(
            Pic3Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic3Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic3Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Pic3LB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pic3Panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Pic3LB2)
                .addGap(32, 32, 32))
            .addGroup(Pic3Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Pic3Panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Pic3LB3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        Pic3Panel1Layout.setVerticalGroup(
            Pic3Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic3Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic3Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pic3LB1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(Pic3LB2)
                .addContainerGap())
            .addGroup(Pic3Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pic3Panel1Layout.createSequentialGroup()
                    .addContainerGap(187, Short.MAX_VALUE)
                    .addComponent(Pic3LB3)
                    .addGap(22, 22, 22)))
        );

        Summary.add(Pic3Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 150, 230));

        Pic4Panel1.setBackground(new java.awt.Color(119, 144, 100));

        Pic4Panel2.setBackground(new java.awt.Color(36, 52, 7));
        Pic4Panel2.setPreferredSize(new java.awt.Dimension(113, 113));

        Pic4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/6.png"))); // NOI18N

        javax.swing.GroupLayout Pic4Panel2Layout = new javax.swing.GroupLayout(Pic4Panel2);
        Pic4Panel2.setLayout(Pic4Panel2Layout);
        Pic4Panel2Layout.setHorizontalGroup(
            Pic4Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic4Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pic4Panel2Layout.setVerticalGroup(
            Pic4Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic4Panel2Layout.createSequentialGroup()
                .addComponent(Pic4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Pic4LB1.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        Pic4LB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic4LB1.setText("0");

        Pic4LB2.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        Pic4LB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic4LB2.setText("Total Profit");

        javax.swing.GroupLayout Pic4Panel1Layout = new javax.swing.GroupLayout(Pic4Panel1);
        Pic4Panel1.setLayout(Pic4Panel1Layout);
        Pic4Panel1Layout.setHorizontalGroup(
            Pic4Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pic4Panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Pic4LB2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Pic4Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic4Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Pic4LB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Pic4Panel1Layout.setVerticalGroup(
            Pic4Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic4Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic4Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pic4LB1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pic4LB2)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        Summary.add(Pic4Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 150, 210));

        Pic5Panel1.setBackground(new java.awt.Color(119, 144, 100));

        Pic5Panel2.setBackground(new java.awt.Color(36, 52, 7));
        Pic5Panel2.setPreferredSize(new java.awt.Dimension(113, 113));

        Pic5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/5.png"))); // NOI18N

        javax.swing.GroupLayout Pic5Panel2Layout = new javax.swing.GroupLayout(Pic5Panel2);
        Pic5Panel2.setLayout(Pic5Panel2Layout);
        Pic5Panel2Layout.setHorizontalGroup(
            Pic5Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic5Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pic5Panel2Layout.setVerticalGroup(
            Pic5Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic5Panel2Layout.createSequentialGroup()
                .addComponent(Pic5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Pic5LB1.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        Pic5LB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic5LB1.setText("0");

        Pic5LB2.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        Pic5LB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic5LB2.setText("Total no. of Damaged Items");

        javax.swing.GroupLayout Pic5Panel1Layout = new javax.swing.GroupLayout(Pic5Panel1);
        Pic5Panel1.setLayout(Pic5Panel1Layout);
        Pic5Panel1Layout.setHorizontalGroup(
            Pic5Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic5Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pic5Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pic5Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addGroup(Pic5Panel1Layout.createSequentialGroup()
                        .addComponent(Pic5LB2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(Pic5LB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Pic5Panel1Layout.setVerticalGroup(
            Pic5Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pic5Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pic5Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pic5LB1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pic5LB2)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        Summary.add(Pic5Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 150, 210));

        Mainmenu.add(Summary, "card7");

        Inventory.setBackground(new java.awt.Color(245, 245, 220));

        SearchPanel.setBackground(new java.awt.Color(245, 245, 220));
        SearchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        SearchPanel.add(SearchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 32));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/searchIcon.png"))); // NOI18N
        SearchPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 30, 30));

        numitemsPanel.setBackground(new java.awt.Color(245, 245, 220));

        totalnum.setBackground(new java.awt.Color(245, 245, 220));
        totalnum.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        totalnum.setText("Total no. of products:");

        numProd.setBackground(new java.awt.Color(245, 245, 220));
        numProd.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        numProd.setText("0");

        javax.swing.GroupLayout numitemsPanelLayout = new javax.swing.GroupLayout(numitemsPanel);
        numitemsPanel.setLayout(numitemsPanelLayout);
        numitemsPanelLayout.setHorizontalGroup(
            numitemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numitemsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalnum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numProd, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        numitemsPanelLayout.setVerticalGroup(
            numitemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(numProd, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(totalnum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

        ProdInfoPanel.setBackground(new java.awt.Color(119, 144, 100));
        ProdInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ProdInfoTitlePnl.setBackground(new java.awt.Color(36, 52, 7));

        ProdInfo.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        ProdInfo.setForeground(new java.awt.Color(255, 255, 255));
        ProdInfo.setText("PRODUCT INFORMATION");

        javax.swing.GroupLayout ProdInfoTitlePnlLayout = new javax.swing.GroupLayout(ProdInfoTitlePnl);
        ProdInfoTitlePnl.setLayout(ProdInfoTitlePnlLayout);
        ProdInfoTitlePnlLayout.setHorizontalGroup(
            ProdInfoTitlePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProdInfoTitlePnlLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ProdInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProdInfoTitlePnlLayout.setVerticalGroup(
            ProdInfoTitlePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProdInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        ProdInfoPanel.add(ProdInfoTitlePnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

        ItemIDLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        ItemIDLB.setText("Item ID: ");
        ProdInfoPanel.add(ItemIDLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 60, 28));

        ID.setBackground(new java.awt.Color(255, 255, 255));
        ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout IDPanelLayout = new javax.swing.GroupLayout(IDPanel);
        IDPanel.setLayout(IDPanelLayout);
        IDPanelLayout.setHorizontalGroup(
            IDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        IDPanelLayout.setVerticalGroup(
            IDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ProdInfoPanel.add(IDPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 43, 150, 27));

        ItemNameLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        ItemNameLB.setText("Item Name:");
        ProdInfoPanel.add(ItemNameLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 75, 27));

        Category.setEditable(false);
        Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryActionPerformed(evt);
            }
        });
        ProdInfoPanel.add(Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 149, 27));

        CategoryLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        CategoryLB.setText("Damage:");
        ProdInfoPanel.add(CategoryLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 60, 29));

        PriceLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        PriceLB.setText("Capital per Kilo:");
        ProdInfoPanel.add(PriceLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 105, 27));

        Price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PriceKeyReleased(evt);
            }
        });
        ProdInfoPanel.add(Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 151, 27));

        AvStocksLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        AvStocksLB.setText("Available Stocks: ");
        ProdInfoPanel.add(AvStocksLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 105, -1));

        AvStocks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AvStocksKeyReleased(evt);
            }
        });
        ProdInfoPanel.add(AvStocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 151, 27));

        StatusLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        StatusLB.setText("Sales per Kilo:");
        ProdInfoPanel.add(StatusLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 100, 27));

        Damage.setEditable(false);
        Damage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DamageActionPerformed(evt);
            }
        });
        ProdInfoPanel.add(Damage, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 150, 27));

        DelbtnPanel.setBackground(new java.awt.Color(119, 144, 100));
        DelbtnPanel.setMaximumSize(new java.awt.Dimension(105, 25));
        DelbtnPanel.setMinimumSize(new java.awt.Dimension(105, 25));
        DelbtnPanel.setPreferredSize(new java.awt.Dimension(105, 25));

        DeleteBTN.setBackground(new java.awt.Color(47, 118, 4));
        DeleteBTN.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        DeleteBTN.setForeground(new java.awt.Color(255, 255, 255));
        DeleteBTN.setText("DELETE");
        DeleteBTN.setEnabled(false);
        DeleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DelbtnPanelLayout = new javax.swing.GroupLayout(DelbtnPanel);
        DelbtnPanel.setLayout(DelbtnPanelLayout);
        DelbtnPanelLayout.setHorizontalGroup(
            DelbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeleteBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DelbtnPanelLayout.setVerticalGroup(
            DelbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeleteBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        ProdInfoPanel.add(DelbtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 154, 140, 30));

        AddbtnPanel.setBackground(new java.awt.Color(119, 144, 100));
        AddbtnPanel.setMaximumSize(new java.awt.Dimension(105, 25));
        AddbtnPanel.setMinimumSize(new java.awt.Dimension(105, 25));
        AddbtnPanel.setPreferredSize(new java.awt.Dimension(105, 25));

        AddBTN.setBackground(new java.awt.Color(47, 118, 4));
        AddBTN.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        AddBTN.setForeground(new java.awt.Color(255, 255, 255));
        AddBTN.setText("ADD");
        AddBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBTNMouseClicked(evt);
            }
        });
        AddBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddbtnPanelLayout = new javax.swing.GroupLayout(AddbtnPanel);
        AddbtnPanel.setLayout(AddbtnPanelLayout);
        AddbtnPanelLayout.setHorizontalGroup(
            AddbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AddbtnPanelLayout.setVerticalGroup(
            AddbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        ProdInfoPanel.add(AddbtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 35, 140, 30));

        EditbtnPanel.setBackground(new java.awt.Color(119, 144, 100));
        EditbtnPanel.setMaximumSize(new java.awt.Dimension(105, 25));
        EditbtnPanel.setMinimumSize(new java.awt.Dimension(105, 25));
        EditbtnPanel.setPreferredSize(new java.awt.Dimension(105, 25));

        EditBTN.setBackground(new java.awt.Color(47, 118, 4));
        EditBTN.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditBTN.setForeground(new java.awt.Color(255, 255, 255));
        EditBTN.setText("EDIT");
        EditBTN.setEnabled(false);
        EditBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditbtnPanelLayout = new javax.swing.GroupLayout(EditbtnPanel);
        EditbtnPanel.setLayout(EditbtnPanelLayout);
        EditbtnPanelLayout.setHorizontalGroup(
            EditbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EditBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        EditbtnPanelLayout.setVerticalGroup(
            EditbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EditBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ProdInfoPanel.add(EditbtnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 76, 140, 30));

        EditbtnPanel1.setBackground(new java.awt.Color(119, 144, 100));
        EditbtnPanel1.setMaximumSize(new java.awt.Dimension(105, 25));
        EditbtnPanel1.setMinimumSize(new java.awt.Dimension(105, 25));
        EditbtnPanel1.setPreferredSize(new java.awt.Dimension(105, 25));

        DamageBTN.setBackground(new java.awt.Color(47, 118, 4));
        DamageBTN.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        DamageBTN.setForeground(new java.awt.Color(255, 255, 255));
        DamageBTN.setText("DAMAGE");
        DamageBTN.setEnabled(false);
        DamageBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DamageBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditbtnPanel1Layout = new javax.swing.GroupLayout(EditbtnPanel1);
        EditbtnPanel1.setLayout(EditbtnPanel1Layout);
        EditbtnPanel1Layout.setHorizontalGroup(
            EditbtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DamageBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        EditbtnPanel1Layout.setVerticalGroup(
            EditbtnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DamageBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ProdInfoPanel.add(EditbtnPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 116, 140, 30));

        SalesT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesTActionPerformed(evt);
            }
        });
        SalesT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SalesTKeyReleased(evt);
            }
        });
        ProdInfoPanel.add(SalesT, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 150, 27));

        CategoryLB1.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        CategoryLB1.setText("Category:");
        ProdInfoPanel.add(CategoryLB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 75, 29));

        Namee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NameeKeyReleased(evt);
            }
        });
        ProdInfoPanel.add(Namee, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 149, 27));

        javax.swing.GroupLayout InventoryLayout = new javax.swing.GroupLayout(Inventory);
        Inventory.setLayout(InventoryLayout);
        InventoryLayout.setHorizontalGroup(
            InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventoryLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(InventoryLayout.createSequentialGroup()
                        .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204)
                        .addComponent(numitemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProdInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        InventoryLayout.setVerticalGroup(
            InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventoryLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numitemsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProdInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Mainmenu.add(Inventory, "card3");

        ADDPanel.setBackground(new java.awt.Color(245, 245, 220));
        ADDPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddBoxPanel.setBackground(new java.awt.Color(119, 144, 100));
        AddBoxPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddHeader.setBackground(new java.awt.Color(36, 52, 7));

        AddLabel.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        AddLabel.setForeground(new java.awt.Color(255, 255, 255));
        AddLabel.setText("ADD ITEM");

        javax.swing.GroupLayout AddHeaderLayout = new javax.swing.GroupLayout(AddHeader);
        AddHeader.setLayout(AddHeaderLayout);
        AddHeaderLayout.setHorizontalGroup(
            AddHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddHeaderLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(AddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AddHeaderLayout.setVerticalGroup(
            AddHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        AddBoxPanel.add(AddHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 634, -1));

        ItemIDlb.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        ItemIDlb.setText("Item ID :");
        AddBoxPanel.add(ItemIDlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 53, 26));

        AddItemNameLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        AddItemNameLB.setText("Item Name :");
        AddBoxPanel.add(AddItemNameLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 82, 26));

        AddCategoryLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        AddCategoryLB.setText("Category :");
        AddBoxPanel.add(AddCategoryLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 82, 26));

        AddCapitalLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        AddCapitalLB.setText("Stocks :");
        AddBoxPanel.add(AddCapitalLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, 26));

        AddStocksLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        AddStocksLB.setText("Capital :");
        AddBoxPanel.add(AddStocksLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 82, 26));

        AddStocks.setPreferredSize(new java.awt.Dimension(73, 26));
        AddStocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStocksActionPerformed(evt);
            }
        });
        AddStocks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddStocksKeyReleased(evt);
            }
        });
        AddBoxPanel.add(AddStocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 304, -1));

        AddCapital.setPreferredSize(new java.awt.Dimension(73, 26));
        AddCapital.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddCapitalKeyReleased(evt);
            }
        });
        AddBoxPanel.add(AddCapital, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 304, -1));

        AddItembtn.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        AddItembtn.setText("Back");
        AddItembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItembtnActionPerformed(evt);
            }
        });
        AddBoxPanel.add(AddItembtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 130, 40));

        ADDbackbtn.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        ADDbackbtn.setText("Add Item");
        ADDbackbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADDbackbtnMouseClicked(evt);
            }
        });
        ADDbackbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDbackbtnActionPerformed(evt);
            }
        });
        AddBoxPanel.add(ADDbackbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 130, 40));

        AddSales.setPreferredSize(new java.awt.Dimension(73, 26));
        AddSales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddSalesKeyReleased(evt);
            }
        });
        AddBoxPanel.add(AddSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 304, -1));

        AddStocksLB1.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        AddStocksLB1.setText("Price per Kilo :");
        AddBoxPanel.add(AddStocksLB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 110, 26));

        Add_Id.setEditable(false);
        AddBoxPanel.add(Add_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 310, 30));

        AddItemName.setPreferredSize(new java.awt.Dimension(73, 26));
        AddItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemNameActionPerformed(evt);
            }
        });
        AddItemName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddItemNameKeyReleased(evt);
            }
        });
        AddBoxPanel.add(AddItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 304, -1));

        CategoryBox.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        CategoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Fruit", "Vegetable" }));
        CategoryBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoryBoxMouseClicked(evt);
            }
        });
        CategoryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryBoxActionPerformed(evt);
            }
        });
        CategoryBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CategoryBoxKeyPressed(evt);
            }
        });
        AddBoxPanel.add(CategoryBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 170, 30));

        ADDPanel.add(AddBoxPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, 370));

        Mainmenu.add(ADDPanel, "card5");

        EDITPanel.setBackground(new java.awt.Color(245, 245, 220));
        EDITPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EditBoxPanel.setBackground(new java.awt.Color(119, 144, 100));
        EditBoxPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EditHeader.setBackground(new java.awt.Color(36, 52, 7));

        EditLabel.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        EditLabel.setForeground(new java.awt.Color(255, 255, 255));
        EditLabel.setText("EDIT ITEM");

        javax.swing.GroupLayout EditHeaderLayout = new javax.swing.GroupLayout(EditHeader);
        EditHeader.setLayout(EditHeaderLayout);
        EditHeaderLayout.setHorizontalGroup(
            EditHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditHeaderLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(EditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EditHeaderLayout.setVerticalGroup(
            EditHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EditLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        EditBoxPanel.add(EditHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 634, -1));

        EditItemIDlb.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditItemIDlb.setText("Item ID :");
        EditBoxPanel.add(EditItemIDlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 53, 26));

        javax.swing.GroupLayout EditItemIDLB1Layout = new javax.swing.GroupLayout(EditItemIDLB1);
        EditItemIDLB1.setLayout(EditItemIDLB1Layout);
        EditItemIDLB1Layout.setHorizontalGroup(
            EditItemIDLB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Edit_Id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        EditItemIDLB1Layout.setVerticalGroup(
            EditItemIDLB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Edit_Id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        EditBoxPanel.add(EditItemIDLB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 304, 26));

        EditItemNameLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditItemNameLB.setText("Item Name :");
        EditBoxPanel.add(EditItemNameLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 82, 26));

        EditCategoryLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditCategoryLB.setText("Category :");
        EditBoxPanel.add(EditCategoryLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 82, 26));

        EditPriceLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditPriceLB.setText("Price per Kilo :");
        EditBoxPanel.add(EditPriceLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, 26));

        EditStocksLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditStocksLB.setText("Stocks :");
        EditBoxPanel.add(EditStocksLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 82, 26));

        EditName.setPreferredSize(new java.awt.Dimension(73, 26));
        EditName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditNameActionPerformed(evt);
            }
        });
        EditName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditNameKeyReleased(evt);
            }
        });
        EditBoxPanel.add(EditName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 304, -1));

        EditPrice.setPreferredSize(new java.awt.Dimension(73, 26));
        EditPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditPriceKeyReleased(evt);
            }
        });
        EditBoxPanel.add(EditPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 304, -1));

        EditStocks.setPreferredSize(new java.awt.Dimension(73, 26));
        EditStocks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditStocksKeyReleased(evt);
            }
        });
        EditBoxPanel.add(EditStocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 304, -1));

        DeleteItembtn.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        DeleteItembtn.setText("Back");
        DeleteItembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItembtnActionPerformed(evt);
            }
        });
        EditBoxPanel.add(DeleteItembtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 130, 40));

        Editbackbtn.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        Editbackbtn.setText("Edit Item");
        Editbackbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditbackbtnActionPerformed(evt);
            }
        });
        EditBoxPanel.add(Editbackbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 130, 40));

        EditCapital.setPreferredSize(new java.awt.Dimension(73, 26));
        EditCapital.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditCapitalKeyReleased(evt);
            }
        });
        EditBoxPanel.add(EditCapital, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 304, -1));

        EditCategoryLB1.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditCategoryLB1.setText("Capital :");
        EditBoxPanel.add(EditCategoryLB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 82, 26));

        categoryBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Fruit", "Vegetable" }));
        categoryBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBox2ActionPerformed(evt);
            }
        });
        categoryBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                categoryBox2KeyPressed(evt);
            }
        });
        EditBoxPanel.add(categoryBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 170, 30));

        EDITPanel.add(EditBoxPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 75, -1, 370));

        categoryBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Fruit", "Vegetable" }));
        EDITPanel.add(categoryBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 170, 30));

        Mainmenu.add(EDITPanel, "card4");

        DELETEPanel.setBackground(new java.awt.Color(245, 245, 220));
        DELETEPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteCont.setLayout(new java.awt.CardLayout());

        DeleteBoxPanel.setBackground(new java.awt.Color(119, 144, 100));
        DeleteBoxPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DeleteHeader.setBackground(new java.awt.Color(36, 52, 7));

        DeleteLabel.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        DeleteLabel.setForeground(new java.awt.Color(255, 255, 255));
        DeleteLabel.setText("DELETE ITEM");

        javax.swing.GroupLayout DeleteHeaderLayout = new javax.swing.GroupLayout(DeleteHeader);
        DeleteHeader.setLayout(DeleteHeaderLayout);
        DeleteHeaderLayout.setHorizontalGroup(
            DeleteHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteHeaderLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(DeleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DeleteHeaderLayout.setVerticalGroup(
            DeleteHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeleteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        DeleteBoxPanel.add(DeleteHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 634, -1));

        DeleteItemIDlb.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        DeleteItemIDlb.setText("Item ID :");
        DeleteBoxPanel.add(DeleteItemIDlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 53, 26));

        EditItemNameLB2.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditItemNameLB2.setText("Item Name :");
        DeleteBoxPanel.add(EditItemNameLB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 82, 26));

        EditCategoryLB2.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditCategoryLB2.setText("Category :");
        DeleteBoxPanel.add(EditCategoryLB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 82, 26));

        EditPriceLB2.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditPriceLB2.setText("Price per Kilo :");
        DeleteBoxPanel.add(EditPriceLB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, 26));

        EditStocksLB2.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditStocksLB2.setText("Stocks :");
        DeleteBoxPanel.add(EditStocksLB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 82, 26));
        DeleteBoxPanel.add(AddItemID7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Deletebackbtn.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        Deletebackbtn.setText("Back");
        Deletebackbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebackbtnActionPerformed(evt);
            }
        });
        DeleteBoxPanel.add(Deletebackbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 130, 40));

        DelelteItembtn.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        DelelteItembtn.setText("Delete Item");
        DelelteItembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelelteItembtnActionPerformed(evt);
            }
        });
        DeleteBoxPanel.add(DelelteItembtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 130, 40));

        EditCategoryLB3.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditCategoryLB3.setText("Capital :");
        DeleteBoxPanel.add(EditCategoryLB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 82, 26));

        EditStocksLB3.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        EditStocksLB3.setText("Damage :");
        DeleteBoxPanel.add(EditStocksLB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 82, 26));

        Del1.setEditable(false);
        Del1.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        Del1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DeleteBoxPanel.add(Del1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 270, 30));

        Del2.setEditable(false);
        Del2.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        Del2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DeleteBoxPanel.add(Del2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 270, 30));

        Del3.setEditable(false);
        Del3.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        Del3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DeleteBoxPanel.add(Del3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 270, 30));

        Del4.setEditable(false);
        Del4.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        Del4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DeleteBoxPanel.add(Del4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 270, 30));

        Del5.setEditable(false);
        Del5.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        Del5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DeleteBoxPanel.add(Del5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 270, 30));

        Del6.setEditable(false);
        Del6.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        Del6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DeleteBoxPanel.add(Del6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 270, 30));

        Del7.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        Del7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DeleteBoxPanel.add(Del7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 270, 30));

        Del8.setEditable(false);
        Del8.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        Del8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DeleteBoxPanel.add(Del8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 270, 30));

        deleteCont.add(DeleteBoxPanel, "card2");

        ConfirmDel.setBackground(new java.awt.Color(245, 245, 220));
        ConfirmDel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Del.setBackground(new java.awt.Color(119, 144, 100));
        Del.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deltext.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        deltext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deltext.setText("Are you sure you want to delete the item?");
        Del.add(deltext, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 289, 44));

        conDelBtn.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        conDelBtn.setText("Delete");
        conDelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conDelBtnActionPerformed(evt);
            }
        });
        Del.add(conDelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 100, 40));

        conCnlBtn1.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        conCnlBtn1.setText("Cancel");
        conCnlBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conCnlBtn1ActionPerformed(evt);
            }
        });
        Del.add(conCnlBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 100, 40));

        ConfirmDel.add(Del, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 460, 220));

        deleteCont.add(ConfirmDel, "card3");

        DELETEPanel.add(deleteCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 630, 380));

        Mainmenu.add(DELETEPanel, "card4");

        About.setBackground(new java.awt.Color(245, 245, 220));
        About.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AboutBoxPanel.setBackground(new java.awt.Color(119, 144, 100));
        AboutBoxPanel.setPreferredSize(new java.awt.Dimension(634, 340));
        AboutBoxPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Vegan.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        Vegan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Vegan.setText("VEGAN");
        AboutBoxPanel.add(Vegan, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 180, 50));

        text1.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        text1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text1.setText("We are a group of BSIT 2A students from Bicol University College of Science.   ");
        AboutBoxPanel.add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 550, 40));

        text2.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        text2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text2.setText("Vegan uses a Sales and Stock Control Management System,");
        AboutBoxPanel.add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 440, 40));

        text3.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        text3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text3.setText("wherein you can add, search, update, and delete items from our database.");
        AboutBoxPanel.add(text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 510, 40));

        text4.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        text4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text4.setText("This project is solely for compliance for our IT108 Object Oriented Programming subject. ");
        AboutBoxPanel.add(text4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 610, 40));

        text5.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        text5.setText("- Alberto, Alianza, Bernal, Bolata, Guevarra");
        AboutBoxPanel.add(text5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, 40));

        text6.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        text6.setText("All Rights Reserved. To God be the Glory!");
        AboutBoxPanel.add(text6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, 30));

        About.add(AboutBoxPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 75, 634, 370));

        Mainmenu.add(About, "card4");

        DAMAGED.setBackground(new java.awt.Color(245, 245, 220));
        DAMAGED.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddBoxPanel1.setBackground(new java.awt.Color(119, 144, 100));
        AddBoxPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddHeader1.setBackground(new java.awt.Color(36, 52, 7));

        AddLabel1.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        AddLabel1.setForeground(new java.awt.Color(255, 255, 255));
        AddLabel1.setText("DAMAGED ITEM");

        javax.swing.GroupLayout AddHeader1Layout = new javax.swing.GroupLayout(AddHeader1);
        AddHeader1.setLayout(AddHeader1Layout);
        AddHeader1Layout.setHorizontalGroup(
            AddHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddHeader1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(AddLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(458, Short.MAX_VALUE))
        );
        AddHeader1Layout.setVerticalGroup(
            AddHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        AddBoxPanel1.add(AddHeader1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 634, -1));

        DmEnterLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        DmEnterLB.setText("Enter Damaged Item:");
        AddBoxPanel1.add(DmEnterLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 26));

        DmEnter.setPreferredSize(new java.awt.Dimension(73, 26));
        DmEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DmEnterMouseClicked(evt);
            }
        });
        DmEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DmEnterActionPerformed(evt);
            }
        });
        DmEnter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DmEnterKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DmEnterKeyReleased(evt);
            }
        });
        AddBoxPanel1.add(DmEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 210, -1));

        DmEnterbtn.setText("Enter");
        DmEnterbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DmEnterbtnActionPerformed(evt);
            }
        });
        AddBoxPanel1.add(DmEnterbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        DmCnlbtn.setText("Cancel");
        DmCnlbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DmCnlbtnActionPerformed(evt);
            }
        });
        AddBoxPanel1.add(DmCnlbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        DmItemNameLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        DmItemNameLB.setText("Item Name :");
        AddBoxPanel1.add(DmItemNameLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 80, 26));

        DmCategoryLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        DmCategoryLB.setText("Category :");
        AddBoxPanel1.add(DmCategoryLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 70, 26));

        DmPriceLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        DmPriceLB.setText("Price per Kilo :");
        AddBoxPanel1.add(DmPriceLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 90, 26));

        DmStocksLB.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        DmStocksLB.setText("Stocks :");
        AddBoxPanel1.add(DmStocksLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 80, 26));

        javax.swing.GroupLayout DmItemIDLBLayout = new javax.swing.GroupLayout(DmItemIDLB);
        DmItemIDLB.setLayout(DmItemIDLBLayout);
        DmItemIDLBLayout.setHorizontalGroup(
            DmItemIDLBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DmItemID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DmItemIDLBLayout.setVerticalGroup(
            DmItemIDLBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DmItemID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        AddBoxPanel1.add(DmItemIDLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 250, 26));

        DmCategory.setEditable(false);
        DmCategory.setPreferredSize(new java.awt.Dimension(73, 26));
        AddBoxPanel1.add(DmCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 250, -1));

        DmPrice.setEditable(false);
        DmPrice.setPreferredSize(new java.awt.Dimension(73, 26));
        AddBoxPanel1.add(DmPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 250, -1));

        DmStocks.setEditable(false);
        DmStocks.setPreferredSize(new java.awt.Dimension(73, 26));
        AddBoxPanel1.add(DmStocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 250, -1));

        DmItemName.setEditable(false);
        DmItemName.setPreferredSize(new java.awt.Dimension(73, 26));
        DmItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DmItemNameActionPerformed(evt);
            }
        });
        AddBoxPanel1.add(DmItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 250, -1));

        DmIDlb.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        DmIDlb.setText("Item ID :");
        AddBoxPanel1.add(DmIDlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, 26));

        DAMAGED.add(AddBoxPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, 370));

        Mainmenu.add(DAMAGED, "card5");

        ReportsPanel.setBackground(new java.awt.Color(245, 245, 220));
        ReportsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(47, 118, 4));

        StockOut1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        StockOut1.setForeground(new java.awt.Color(255, 255, 255));
        StockOut1.setText("Stock Out");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(StockOut1)
                .addGap(48, 48, 48))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StockOut1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ReportsPanel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 240, 40));

        outTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Category", "Quantity", "Price", "Total", "Profit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(outTable);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        ReportsPanel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 860, 330));

        jPanel6.setBackground(new java.awt.Color(47, 118, 4));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL PROFIT:");

        totProfit.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TOTAL PRODUCT:");

        totOutProduct.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totOutProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(totProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(totOutProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        ReportsPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 860, 70));

        SearchBar1.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        SearchBar1.setText("Search");
        SearchBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchBar1MouseClicked(evt);
            }
        });
        SearchBar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBar1ActionPerformed(evt);
            }
        });
        SearchBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchBar1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBar1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SearchBar1KeyTyped(evt);
            }
        });
        ReportsPanel.add(SearchBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 240, 32));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/searchIcon.png"))); // NOI18N
        ReportsPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 30, 30));

        Mainmenu.add(ReportsPanel, "card5");

        Main_Frame.add(Mainmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 860, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main_Frame, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Main_Frame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductsMouseEntered
        ProductsTab.setBackground(new java.awt.Color(119, 144, 100));
    }//GEN-LAST:event_btnProductsMouseEntered

    private void btnProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductsMouseExited
        ProductsTab.setBackground(new java.awt.Color(36, 52, 7));
    }//GEN-LAST:event_btnProductsMouseExited

    private void btnInventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventoryMouseEntered
        InventoryTab.setBackground(new java.awt.Color(119, 144, 100));
    }//GEN-LAST:event_btnInventoryMouseEntered

    private void btnInventoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventoryMouseExited
        InventoryTab.setBackground(new java.awt.Color(36, 52, 7));
    }//GEN-LAST:event_btnInventoryMouseExited

    private void btnTransactionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransactionMouseEntered
        TransactionTab.setBackground(new java.awt.Color(119, 144, 100));
    }//GEN-LAST:event_btnTransactionMouseEntered

    private void btnTransactionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransactionMouseExited
        TransactionTab.setBackground(new java.awt.Color(36, 52, 7));
    }//GEN-LAST:event_btnTransactionMouseExited

    private void btnAboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMouseEntered
        AboutTab.setBackground(new java.awt.Color(119, 144, 100));
    }//GEN-LAST:event_btnAboutMouseEntered

    private void btnAboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMouseExited
        AboutTab.setBackground(new java.awt.Color(36, 52, 7));
    }//GEN-LAST:event_btnAboutMouseExited

    private void btnProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductsMouseClicked
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Summary);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_btnProductsMouseClicked

    private void btnInventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventoryMouseClicked
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_btnInventoryMouseClicked

    private void btnTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransactionMouseClicked
        Transaction toTransaction = new Transaction();
        toTransaction.show();
        dispose();
    }//GEN-LAST:event_btnTransactionMouseClicked

    private void btnAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMouseClicked
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(About);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_btnAboutMouseClicked

    private void AddBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBTNActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(ADDPanel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        ADDbackbtn.setEnabled(false);
        
        int num = randomNum();
        Add_Id.setText(Integer.toString(num));
        
        if (ID.getText().equals("")){
        AddItemName.setText(Namee.getText());
        AddCapital.setText(Price.getText());
        AddStocks.setText(AvStocks.getText());
        AddSales.setText(SalesT.getText());
        }else{
        AddItemName.setText("");
        AddCapital.setText("");
        AddStocks.setText("");
        AddSales.setText(""); 
        }
           
    }//GEN-LAST:event_AddBTNActionPerformed

    private void AddItembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItembtnActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        clear_text();
    }//GEN-LAST:event_AddItembtnActionPerformed

    private void ADDbackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDbackbtnActionPerformed
    if (AddItemName.getText().isEmpty() || AddCapital.getText().isEmpty() || AddStocks.getText().isEmpty() || AddSales.getText().isEmpty()) { 
        JOptionPane.showMessageDialog(null, "Please enter all necessary fields!");  
        return;
    }else{
    String cate="";

            if ("Fruit".equals(CategoryBox.getSelectedItem().toString())){
                   cate = "Fruit";
                    ADDbackbtn.setEnabled(true);
                }else if ("Vegetable".equals(CategoryBox.getSelectedItem().toString())){
                    cate = "Vegetable";
                     ADDbackbtn.setEnabled(true);
                }else {
                      ADDbackbtn.setEnabled(false);
                }
            String addID = Add_Id.getText();
            String addName = AddItemName.getText();
            String addCap = AddCapital.getText();
            String addStocks = AddStocks.getText();
            String addSales = AddSales.getText();
            float capital = Float.parseFloat(addCap);
            float sales = Float.parseFloat(addSales);

            if (capital > sales){
                JOptionPane.showMessageDialog(null, "Sales Price must be higher than Capital");  
                return;  
            }

                try {
                    Add add = new Add(addID,addName,cate,addCap,addStocks,addSales);
                } catch (IOException ex) {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                }

            Mainmenu.removeAll();
            Mainmenu.repaint();
            Mainmenu.revalidate();
            Mainmenu.add(Inventory);
            Mainmenu.repaint();
            Mainmenu.revalidate();
            refresh_table();
            clear_text();
            EditBTN.setEnabled(false);
            DamageBTN.setEnabled(false);
            DeleteBTN.setEnabled(false);

    }
    }//GEN-LAST:event_ADDbackbtnActionPerformed

    private void EditNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditNameActionPerformed

    private void DeleteItembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItembtnActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_DeleteItembtnActionPerformed

    private void EditbackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditbackbtnActionPerformed
        String categ = "";
        if ("Fruit".equals(categoryBox2.getSelectedItem().toString())){
               categ = "Fruit";
                Editbackbtn.setEnabled(true);
                
        }else if ("Vegetable".equals(categoryBox2.getSelectedItem().toString())){
                categ = "Vegetable";
                Editbackbtn.setEnabled(true);
                
        }else {
                 Editbackbtn.setEnabled(false);
        }
        
        float capital = Float.parseFloat(EditCapital.getText());
        float sales = Float.parseFloat(EditPrice.getText());

       if (capital > sales){
                JOptionPane.showMessageDialog(null, "Sales Price must be higher than Capital");  
                return;  
       }
       int row = InvTable.getSelectedRow();
       String id, name, price, quan, cap,damage;          // gets the input(s) from each of the textfields
        id = Edit_Id.getText();
        name = EditName.getText();
        cap = EditCapital.getText();
        price = EditPrice.getText();
        quan = EditStocks.getText();
       damage = Damage.getText();
       
       if(row >= 0) {                         
           InvTable.getModel().setValueAt(id, row, 0);     // sets the 
           InvTable.getModel().setValueAt(name, row, 0); 
           InvTable.getModel().setValueAt(categ, row, 0); 
           InvTable.getModel().setValueAt(cap, row, 0);
           InvTable.getModel().setValueAt(quan, row, 0); 
           InvTable.getModel().setValueAt(price, row, 0); 
           InvTable.getModel().setValueAt(damage, row, 0); 
        }
       Edit edit = new Edit(id, name, categ, cap, quan,price,damage, row);
//            try {
//                String pathDB = System.getProperty("user.dir") + "\\src\\DB\\Data.txt";
//                File f = new File(pathDB);
//                String rtemp = Edit_Id.getText();
//                Scanner read = new Scanner(f);
//                
//                String temp1 = "";
//                String store = "";
//                String store1 = "";
//                
//                while (!temp1.startsWith(rtemp)) {
//                    temp1 = read.nextLine();
//                    if (!temp1.startsWith(rtemp)) {
//                        store += temp1 + "\n";
//                    }
//                }
//                while (read.hasNextLine()) {
//                    store1 += read.nextLine() + "\n";
//                }
//                
//                
//                
//                
//                String data = (Edit_Id.getText() + "," +EditName.getText() +","+categ+","+EditCapital.getText()+","+EditStocks.getText()+","+EditPrice.getText()+","+Damage.getText()+"\n");
//                FileWriter output;
//                output = new FileWriter(f);
//                output.write(store);
//                output.write(data);
//                output.write(store1);
//                output.close();
//
//
//
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
//            } 
//        catch (IOException ex) {
//            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        refresh_table();
        clear_text();
        EditBTN.setEnabled(false);
        DamageBTN.setEnabled(false);
        DeleteBTN.setEnabled(false);
    }//GEN-LAST:event_EditbackbtnActionPerformed

    private void DeletebackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebackbtnActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_DeletebackbtnActionPerformed

    private void DelelteItembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelelteItembtnActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(ConfirmDel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_DelelteItembtnActionPerformed

    private void EditBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBTNActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(EDITPanel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Editbackbtn.setEnabled(false);
        

    }//GEN-LAST:event_EditBTNActionPerformed

    private void DeleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBTNActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(DELETEPanel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_DeleteBTNActionPerformed

    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
    refresh_table();
    }//GEN-LAST:event_SearchBarActionPerformed

    private void btnReportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportsMouseExited
        ReportsTab.setBackground(new java.awt.Color(36, 52, 7));
    }//GEN-LAST:event_btnReportsMouseExited

    private void btnReportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportsMouseEntered
        ReportsTab.setBackground(new java.awt.Color(119, 144, 100));
    }//GEN-LAST:event_btnReportsMouseEntered

    private void btnReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportsMouseClicked
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(ReportsPanel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_btnReportsMouseClicked

    private void InventoryTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventoryTabMouseClicked
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_InventoryTabMouseClicked

    private void AboutTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutTabMouseClicked
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(About);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_AboutTabMouseClicked

    private void ProductsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductsTabMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductsTabMouseClicked

    private void TransactionTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionTabMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TransactionTabMouseClicked

    private void ReportsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportsTabMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ReportsTabMouseClicked

    private void conDelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conDelBtnActionPerformed
        try {
                String pathDB = System.getProperty("user.dir") + "\\src\\DB\\StockIn.txt";
                File f = new File(pathDB);
                String rtemp = ID.getText();
                Scanner read = new Scanner(f);
                
                String temp1 = "";
                String store = "";
                String store1 = "";
                
                while (!temp1.startsWith(rtemp)) {
                    temp1 = read.nextLine();
                    if (!temp1.startsWith(rtemp)) {
                        store += temp1 + "\n";
                    }
                }
                while (read.hasNextLine()) {
                    store1 += read.nextLine() + "\n";
                }
                FileWriter output;
                output = new FileWriter(f);
                output.write(store);
                output.write(store1);
                output.close();



            } catch (FileNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            } 
        catch (IOException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        refresh_table();
        clear_text();
        EditBTN.setEnabled(false);
        DamageBTN.setEnabled(false);
        DeleteBTN.setEnabled(false);
    }//GEN-LAST:event_conDelBtnActionPerformed

    private void conCnlBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conCnlBtn1ActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(DELETEPanel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_conCnlBtn1ActionPerformed

    private void DamageBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DamageBTNActionPerformed
    Mainmenu.removeAll();
    Mainmenu.repaint();
    Mainmenu.revalidate();
    Mainmenu.add(DAMAGED);
    Mainmenu.repaint();
    Mainmenu.revalidate();
    DmEnterbtn.setEnabled(false);
    }//GEN-LAST:event_DamageBTNActionPerformed

    private void AddStocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStocksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddStocksActionPerformed

    private void ADDbackbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDbackbtnMouseClicked
        
    }//GEN-LAST:event_ADDbackbtnMouseClicked

    private void AddBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBTNMouseClicked
        
    }//GEN-LAST:event_AddBTNMouseClicked

    private void InvTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InvTableMouseClicked
        
        int row = InvTable.getSelectedRow();
        ID.setText(InvTable.getModel().getValueAt(row,0).toString());
        Namee.setText(InvTable.getModel().getValueAt(row,1).toString());
        Category.setText(InvTable.getModel().getValueAt(row,2).toString());
        Price.setText(InvTable.getModel().getValueAt(row,3).toString());
        AvStocks.setText(InvTable.getModel().getValueAt(row,4).toString());
        SalesT.setText(InvTable.getModel().getValueAt(row,5).toString());
        Damage.setText(InvTable.getModel().getValueAt(row,6).toString());
       
        Edit_Id.setText(InvTable.getModel().getValueAt(row,0).toString());
        EditName.setText(InvTable.getModel().getValueAt(row,1).toString());
        
        EditCapital.setText(InvTable.getModel().getValueAt(row,3).toString());
        EditStocks.setText(InvTable.getModel().getValueAt(row,4).toString());
        EditPrice.setText(InvTable.getModel().getValueAt(row,5).toString());
        
        Del2.setText(InvTable.getModel().getValueAt(row,0).toString());
        Del3.setText(InvTable.getModel().getValueAt(row,1).toString());
        Del4.setText(InvTable.getModel().getValueAt(row,2).toString());
        Del6.setText(InvTable.getModel().getValueAt(row,3).toString());
        Del5.setText(InvTable.getModel().getValueAt(row,4).toString());
        Del7.setText(InvTable.getModel().getValueAt(row,5).toString());
        Del1.setText(InvTable.getModel().getValueAt(row,6).toString());
        
        DmItemID.setText(InvTable.getModel().getValueAt(row,0).toString());
        DmItemName.setText(InvTable.getModel().getValueAt(row,1).toString());
        DmCategory.setText(InvTable.getModel().getValueAt(row,2).toString());
        DmPrice.setText(InvTable.getModel().getValueAt(row,3).toString());
        DmStocks.setText(InvTable.getModel().getValueAt(row,4).toString());
        
   
    EditBTN.setEnabled(true);
    DamageBTN.setEnabled(true);
    DeleteBTN.setEnabled(true);
   
        
    }//GEN-LAST:event_InvTableMouseClicked

    private void categoryBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryBox2KeyPressed
        if ("Fruit".equals(categoryBox2.getSelectedItem().toString())){
               
                Editbackbtn.setEnabled(true);
               
        }else if ("Vegetable".equals(categoryBox2.getSelectedItem().toString())){
                
                Editbackbtn.setEnabled(true);
                
        }else {
                 Editbackbtn.setEnabled(false);
        }
    }//GEN-LAST:event_categoryBox2KeyPressed

    private void categoryBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBox2ActionPerformed
   if ("Fruit".equals(categoryBox2.getSelectedItem().toString())){
               
                Editbackbtn.setEnabled(true);
               
        }else if ("Vegetable".equals(categoryBox2.getSelectedItem().toString())){
                
                Editbackbtn.setEnabled(true);
                
        }else {
                 Editbackbtn.setEnabled(false);
        }
    }//GEN-LAST:event_categoryBox2ActionPerformed

    private void SearchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarKeyReleased
        search_name(SearchBar.getText());
        clear_text();
    }//GEN-LAST:event_SearchBarKeyReleased

    private void SearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchBarMouseClicked
        SearchBar.setText("");
    }//GEN-LAST:event_SearchBarMouseClicked

    private void SearchBarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarKeyTyped
        
    }//GEN-LAST:event_SearchBarKeyTyped

    private void SearchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarKeyPressed
//        SearchBar.setText("");
    }//GEN-LAST:event_SearchBarKeyPressed

    private void SalesTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalesTActionPerformed

    private void DamageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DamageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DamageActionPerformed

    private void AddItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddItemNameActionPerformed

    private void CategoryBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryBoxMouseClicked
    
    }//GEN-LAST:event_CategoryBoxMouseClicked

    private void CategoryBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryBoxActionPerformed
    if ("Fruit".equals(CategoryBox.getSelectedItem().toString())){
               
                ADDbackbtn.setEnabled(true);
               
        }else if ("Vegetable".equals(CategoryBox.getSelectedItem().toString())){
                
                ADDbackbtn.setEnabled(true);
                
        }else {
                 ADDbackbtn.setEnabled(false);
        }
    }//GEN-LAST:event_CategoryBoxActionPerformed

    private void CategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryActionPerformed

    private void NameeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameeKeyReleased
        String none = "";
        if(( Namee.getText().equals(none)) && (Price.getText().equals(none)) && (AvStocks.getText().equals(none)) && (SalesT.getText().equals(none))){
           AddBTN.setEnabled(false);
        }else{
          AddBTN.setEnabled(true);  
        }
        
    
    }//GEN-LAST:event_NameeKeyReleased

    private void PriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PriceKeyReleased
        String none = "";
        if(( Namee.getText().equals(none)) && (Price.getText().equals(none)) && (AvStocks.getText().equals(none)) && (SalesT.getText().equals(none))){
           AddBTN.setEnabled(false);
        }else{
          AddBTN.setEnabled(true);  
        }
    }//GEN-LAST:event_PriceKeyReleased

    private void AvStocksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AvStocksKeyReleased
        String none = "";
        if(( Namee.getText().equals(none)) && (Price.getText().equals(none)) && (AvStocks.getText().equals(none)) && (SalesT.getText().equals(none))){
           AddBTN.setEnabled(false);
        }else{
          AddBTN.setEnabled(true);  
        }
    }//GEN-LAST:event_AvStocksKeyReleased

    private void SalesTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalesTKeyReleased
        String none = "";
        if(( Namee.getText().equals(none)) && (Price.getText().equals(none)) && (AvStocks.getText().equals(none)) && (SalesT.getText().equals(none))){
           AddBTN.setEnabled(false);
        }else{
          AddBTN.setEnabled(true);  
        }
    }//GEN-LAST:event_SalesTKeyReleased

    private void CategoryBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CategoryBoxKeyPressed
    if ("Fruit".equals(CategoryBox.getSelectedItem().toString())){
               
                ADDbackbtn.setEnabled(true);
               
        }else if ("Vegetable".equals(CategoryBox.getSelectedItem().toString())){
                
                ADDbackbtn.setEnabled(true);
                
        }else {
                 ADDbackbtn.setEnabled(false);
        }
    }//GEN-LAST:event_CategoryBoxKeyPressed

    private void DmEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DmEnterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DmEnterActionPerformed

    private void DmCnlbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DmCnlbtnActionPerformed
    Mainmenu.removeAll();
    Mainmenu.repaint();
    Mainmenu.revalidate();
    Mainmenu.add(Inventory);
    Mainmenu.repaint();
    Mainmenu.revalidate();
    }//GEN-LAST:event_DmCnlbtnActionPerformed

    private void DmItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DmItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DmItemNameActionPerformed

    private void DmEnterbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DmEnterbtnActionPerformed
        float d = Float.parseFloat(DmEnter.getText());
        float q = Float.parseFloat(AvStocks.getText());
        float newQ = q - d ;
        Double rounded = Math.round(newQ * 1000)/1000.0;
        if (rounded >= 0){
            
        DefaultTableModel model2;
        model2 = (DefaultTableModel) InvTable.getModel();
        
        for (int i = 0; i < InvTable.getRowCount();i++){
               String codeID = InvTable.getModel().getValueAt(i, 0).toString();
               if (codeID.startsWith(DmItemID.getText()) ){
                   String id = (InvTable.getModel().getValueAt(i, 0)).toString();
                   String namee = (InvTable.getModel().getValueAt(i, 1).toString());
                   String cate = (InvTable.getModel().getValueAt(i, 2).toString());
                   String capt = (InvTable.getModel().getValueAt(i, 3).toString());
                   String quant = (InvTable.getModel().getValueAt(i, 4).toString());
                   String pricee = (InvTable.getModel().getValueAt(i, 5).toString());
                   String damage = (InvTable.getModel().getValueAt(i, 6).toString());
                   String newDamage = Float.toString(d + Float.parseFloat(damage) );
                   String newQuant = Float.toString(Float.parseFloat(quant)- d);
                   Edit edit = new Edit (id,namee,cate,capt,newQuant,pricee,newDamage,i);


               }
            }

        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        refresh_table();
        clear_text();
        EditBTN.setEnabled(false);
        DamageBTN.setEnabled(false);
        DeleteBTN.setEnabled(false);
    }else{
        JOptionPane.showMessageDialog(this, "Enter a valid Number",
                                   "Invalid Input", JOptionPane.ERROR_MESSAGE);       
    }
    }//GEN-LAST:event_DmEnterbtnActionPerformed

    private void DmEnterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DmEnterKeyPressed
        
    }//GEN-LAST:event_DmEnterKeyPressed

    private void AddItemNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddItemNameKeyReleased
     
    if (!AddItemName.getText().isEmpty()){
        int u = check_U(AddItemName.getText());
            System.out.println(u);
        if (u !=0){
            String[] options = { "Back to Inventory","Input New Product"};
            var choice = JOptionPane.showOptionDialog(null, "Product is already in the list!", "Error", 
                                                              0, 2, null, options, options[0]);
            if (choice == 0) {
                Mainmenu.removeAll();
                Mainmenu.repaint();
                Mainmenu.revalidate();
                Mainmenu.add(Inventory);
                Mainmenu.repaint();
                Mainmenu.revalidate();
                refresh_table();
                clear_text();
                EditBTN.setEnabled(false);
                DamageBTN.setEnabled(false);
                DeleteBTN.setEnabled(false);
            }
            if (choice == 1) {
              AddItemName.setText("");
              AddCapital.setText("");
              AddStocks.setText("");
              AddSales.setText("");
              CategoryBox.setSelectedItem("Select Category");
            }

        }
    }
    }//GEN-LAST:event_AddItemNameKeyReleased

    private void AddSalesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddSalesKeyReleased
    if (!AddSales.getText().isEmpty()){
            
        float fvalue;
            try {
                fvalue = Float.parseFloat(AddSales.getText());  
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Plese input the Sales Price of Product"); 
            AddSales.setText("");
            return;
            }
         
    }  
    }//GEN-LAST:event_AddSalesKeyReleased

    private void AddStocksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddStocksKeyReleased
    
    if (!AddStocks.getText().isEmpty()){
        String addStocks = AddStocks.getText();
        try{
        float stocks = Float.parseFloat(addStocks);
        if ((stocks + num_fruits) > 10000){
                JOptionPane.showMessageDialog(null, "Insufficient Storage!");
                AddStocks.setText("");
                return;
            }
        }
         catch (NumberFormatException b) {
                JOptionPane.showMessageDialog(null, "Plese input the Number of Stocks in Kilo"); 
                AddStocks.setText("");
                return;
        }
    }
    }//GEN-LAST:event_AddStocksKeyReleased

    private void AddCapitalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddCapitalKeyReleased
    
        if (!AddCapital.getText().isEmpty()){
            
        float fvalue;
            try {
                fvalue = Float.parseFloat(AddCapital.getText());  
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Plese input the Capital Price of Product"); 
            AddCapital.setText("");
            return;
            }
         
        }    
    }//GEN-LAST:event_AddCapitalKeyReleased

    private void EditNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EditNameKeyReleased
    if (!EditName.getText().isEmpty()){
        int u = check_U(EditName.getText());
            System.out.println(u);
        if (u !=0){
            String[] options = { "Back to Inventory","Input New Product"};
            var choice = JOptionPane.showOptionDialog(null, "Product is already in the list!", "Error", 
                                                              0, 2, null, options, options[0]);
            if (choice == 0) {
                Mainmenu.removeAll();
                Mainmenu.repaint();
                Mainmenu.revalidate();
                Mainmenu.add(Inventory);
                Mainmenu.repaint();
                Mainmenu.revalidate();
                refresh_table();
                clear_text();
                EditBTN.setEnabled(false);
                DamageBTN.setEnabled(false);
                DeleteBTN.setEnabled(false);
            }
            if (choice == 1) {
              EditName.setText("");
              
            }

        }
    }
    }//GEN-LAST:event_EditNameKeyReleased

    private void EditCapitalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EditCapitalKeyReleased
    if (!EditCapital.getText().isEmpty()){
            
        float fvalue;
            try {
                fvalue = Float.parseFloat(EditCapital.getText());  
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Plese input the Capital Price of Product"); 
            EditCapital.setText("");
            return;
            }
         
        }
    }//GEN-LAST:event_EditCapitalKeyReleased

    private void EditStocksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EditStocksKeyReleased
    if (!EditStocks.getText().isEmpty()){
        String addStocks = EditStocks.getText();
        try{
        float stocks = Float.parseFloat(addStocks);
        if ((stocks + num_fruits) > 10000){
                JOptionPane.showMessageDialog(null, "Insufficient Storage!");
                EditStocks.setText("");
                return;
            }
        }
         catch (NumberFormatException b) {
                JOptionPane.showMessageDialog(null, "Plese input the Number of Stocks in Kilo"); 
                EditStocks.setText("");
                return;
        }
    }
    }//GEN-LAST:event_EditStocksKeyReleased

    private void EditPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EditPriceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EditPriceKeyReleased

    private void DmEnterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DmEnterKeyReleased
    if (DmEnter.getText().isEmpty()){
           DmEnterbtn.setEnabled(false);
    }else{
        float fvalue;
            try {
                fvalue = Float.parseFloat(DmEnter.getText());  
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Plese input the number of damage in kilo"); 
            DmEnter.setText("");
            return;
            }
            
        float stocks = Float.parseFloat(DmStocks.getText());
        float dm = Float.parseFloat(DmEnter.getText());
        if (stocks < dm){
            JOptionPane.showMessageDialog(null, "Invalid Input");
            DmEnter.setText("");
            return;
        }
        else{
            DmEnterbtn.setEnabled(true);
        }
    }
    }//GEN-LAST:event_DmEnterKeyReleased

    private void DmEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DmEnterMouseClicked
     DmEnter.setText("");
    }//GEN-LAST:event_DmEnterMouseClicked

    private void SearchBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchBar1MouseClicked
    SearchBar1.setText("");
    }//GEN-LAST:event_SearchBar1MouseClicked

    private void SearchBar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBar1ActionPerformed

    private void SearchBar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBar1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBar1KeyPressed

    private void SearchBar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBar1KeyReleased
    DefaultTableModel table = (DefaultTableModel)outTable.getModel();
    String search = SearchBar1.getText();

    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
    outTable.setRowSorter(tr);
    
    tr.setRowFilter(RowFilter.regexFilter(search));
    
    }//GEN-LAST:event_SearchBar1KeyReleased

    private void SearchBar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBar1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBar1KeyTyped
private void clear_text(){
    ID.setText("");
    Namee.setText("");
    Category.setText("");
    Price.setText("");
    AvStocks.setText("");
    SalesT.setText("");
    Damage.setText("");
    
    Add_Id.setText("");
    AddItemName.setText("");
    CategoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Fruit", "Vegetable" }));
    AddCapital.setText("");
    AddStocks.setText("");
    AddSales.setText("");
    
    Edit_Id.setText("");
    EditName.setText("");
    categoryBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Fruit", "Vegetable" }));
    EditCapital.setText("");
    EditStocks.setText("");
    EditPrice.setText("");
    
    Del1.setText("");
    Del2.setText("");
    Del3.setText("");
    Del4.setText("");
    Del5.setText("");
    Del6.setText("");
    Del7.setText("");
    
    DmItemID.setText("");
    DmItemName.setText("");
    DmPrice.setText("");
    DmStocks.setText("");
    DmEnter.setText("");
    DmCategory.setText("");
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
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADDPanel;
    private javax.swing.JButton ADDbackbtn;
    private javax.swing.JPanel About;
    private javax.swing.JPanel AboutBoxPanel;
    private javax.swing.JPanel AboutTab;
    private javax.swing.JButton AddBTN;
    private javax.swing.JPanel AddBoxPanel;
    private javax.swing.JPanel AddBoxPanel1;
    private javax.swing.JTextField AddCapital;
    private javax.swing.JLabel AddCapitalLB;
    private javax.swing.JLabel AddCategoryLB;
    private javax.swing.JPanel AddHeader;
    private javax.swing.JPanel AddHeader1;
    private javax.swing.JLabel AddItemID7;
    private javax.swing.JTextField AddItemName;
    private javax.swing.JLabel AddItemNameLB;
    private javax.swing.JButton AddItembtn;
    private javax.swing.JLabel AddLabel;
    private javax.swing.JLabel AddLabel1;
    private javax.swing.JTextField AddSales;
    private javax.swing.JTextField AddStocks;
    private javax.swing.JLabel AddStocksLB;
    private javax.swing.JLabel AddStocksLB1;
    private javax.swing.JTextField Add_Id;
    private javax.swing.JPanel AddbtnPanel;
    private javax.swing.JTextField AvStocks;
    private javax.swing.JLabel AvStocksLB;
    private javax.swing.JTextField Category;
    private javax.swing.JComboBox<String> CategoryBox;
    private javax.swing.JLabel CategoryLB;
    private javax.swing.JLabel CategoryLB1;
    private javax.swing.JPanel ConfirmDel;
    private javax.swing.JPanel DAMAGED;
    private javax.swing.JPanel DELETEPanel;
    private javax.swing.JTextField Damage;
    private javax.swing.JButton DamageBTN;
    private javax.swing.JPanel Del;
    private javax.swing.JTextField Del1;
    private javax.swing.JTextField Del2;
    private javax.swing.JTextField Del3;
    private javax.swing.JTextField Del4;
    private javax.swing.JTextField Del5;
    private javax.swing.JTextField Del6;
    private javax.swing.JTextField Del7;
    private javax.swing.JTextField Del8;
    private javax.swing.JPanel DelbtnPanel;
    private javax.swing.JButton DelelteItembtn;
    private javax.swing.JButton DeleteBTN;
    private javax.swing.JPanel DeleteBoxPanel;
    private javax.swing.JPanel DeleteHeader;
    private javax.swing.JLabel DeleteItemIDlb;
    private javax.swing.JButton DeleteItembtn;
    private javax.swing.JLabel DeleteLabel;
    private javax.swing.JButton Deletebackbtn;
    private javax.swing.JTextField DmCategory;
    private javax.swing.JLabel DmCategoryLB;
    private javax.swing.JButton DmCnlbtn;
    private javax.swing.JTextField DmEnter;
    private javax.swing.JLabel DmEnterLB;
    private javax.swing.JButton DmEnterbtn;
    private javax.swing.JLabel DmIDlb;
    private javax.swing.JLabel DmItemID;
    private javax.swing.JPanel DmItemIDLB;
    private javax.swing.JTextField DmItemName;
    private javax.swing.JLabel DmItemNameLB;
    private javax.swing.JTextField DmPrice;
    private javax.swing.JLabel DmPriceLB;
    private javax.swing.JTextField DmStocks;
    private javax.swing.JLabel DmStocksLB;
    private javax.swing.JPanel EDITPanel;
    private javax.swing.JButton EditBTN;
    private javax.swing.JPanel EditBoxPanel;
    private javax.swing.JTextField EditCapital;
    private javax.swing.JLabel EditCategoryLB;
    private javax.swing.JLabel EditCategoryLB1;
    private javax.swing.JLabel EditCategoryLB2;
    private javax.swing.JLabel EditCategoryLB3;
    private javax.swing.JPanel EditHeader;
    private javax.swing.JPanel EditItemIDLB1;
    private javax.swing.JLabel EditItemIDlb;
    private javax.swing.JLabel EditItemNameLB;
    private javax.swing.JLabel EditItemNameLB2;
    private javax.swing.JLabel EditLabel;
    private javax.swing.JTextField EditName;
    private javax.swing.JTextField EditPrice;
    private javax.swing.JLabel EditPriceLB;
    private javax.swing.JLabel EditPriceLB2;
    private javax.swing.JTextField EditStocks;
    private javax.swing.JLabel EditStocksLB;
    private javax.swing.JLabel EditStocksLB2;
    private javax.swing.JLabel EditStocksLB3;
    private javax.swing.JLabel Edit_Id;
    private javax.swing.JButton Editbackbtn;
    private javax.swing.JPanel EditbtnPanel;
    private javax.swing.JPanel EditbtnPanel1;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel ID;
    private javax.swing.JPanel IDPanel;
    private javax.swing.JTable InvTable;
    private javax.swing.JPanel Inventory;
    private javax.swing.JPanel InventoryTab;
    private javax.swing.JLabel ItemIDLB;
    private javax.swing.JLabel ItemIDlb;
    private javax.swing.JLabel ItemNameLB;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Main_Frame;
    private javax.swing.JPanel Mainmenu;
    private javax.swing.JTextField Namee;
    private javax.swing.JLabel Overview;
    private javax.swing.JLabel Pic1;
    private javax.swing.JLabel Pic1LB1;
    private javax.swing.JLabel Pic1LB2;
    private javax.swing.JPanel Pic1Panel1;
    private javax.swing.JPanel Pic1Panel2;
    private javax.swing.JLabel Pic2;
    private javax.swing.JLabel Pic2LB1;
    private javax.swing.JLabel Pic2LB2;
    private javax.swing.JLabel Pic2LB3;
    private javax.swing.JPanel Pic2Panel1;
    private javax.swing.JPanel Pic2Panel2;
    private javax.swing.JLabel Pic3;
    private javax.swing.JLabel Pic3LB1;
    private javax.swing.JLabel Pic3LB2;
    private javax.swing.JLabel Pic3LB3;
    private javax.swing.JPanel Pic3Panel1;
    private javax.swing.JPanel Pic3Panel2;
    private javax.swing.JLabel Pic4;
    private javax.swing.JLabel Pic4LB1;
    private javax.swing.JLabel Pic4LB2;
    private javax.swing.JPanel Pic4Panel1;
    private javax.swing.JPanel Pic4Panel2;
    private javax.swing.JLabel Pic5;
    private javax.swing.JLabel Pic5LB1;
    private javax.swing.JLabel Pic5LB2;
    private javax.swing.JPanel Pic5Panel1;
    private javax.swing.JPanel Pic5Panel2;
    private javax.swing.JTextField Price;
    private javax.swing.JLabel PriceLB;
    private javax.swing.JLabel ProdInfo;
    private javax.swing.JPanel ProdInfoPanel;
    private javax.swing.JPanel ProdInfoTitlePnl;
    private javax.swing.JPanel ProductsTab;
    private javax.swing.JPanel ReportsPanel;
    private javax.swing.JPanel ReportsTab;
    private javax.swing.JTextField SalesT;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JTextField SearchBar1;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JPanel Side_Menu;
    private javax.swing.JLabel StatusLB;
    private javax.swing.JLabel StockOut1;
    private javax.swing.JPanel Summary;
    private javax.swing.JPanel TransactionTab;
    private javax.swing.JLabel Vegan;
    private javax.swing.JLabel btnAbout;
    private javax.swing.JLabel btnInventory;
    private javax.swing.JLabel btnProducts;
    private javax.swing.JLabel btnReports;
    private javax.swing.JLabel btnTransaction;
    private javax.swing.JComboBox<String> categoryBox1;
    private javax.swing.JComboBox<String> categoryBox2;
    private javax.swing.JButton conCnlBtn1;
    private javax.swing.JButton conDelBtn;
    private javax.swing.JPanel deleteCont;
    private javax.swing.JLabel deltext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel numProd;
    private javax.swing.JPanel numitemsPanel;
    private javax.swing.JTable outTable;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    private javax.swing.JLabel text4;
    private javax.swing.JLabel text5;
    private javax.swing.JLabel text6;
    private javax.swing.JTextField totOutProduct;
    private javax.swing.JTextField totProfit;
    private javax.swing.JLabel totalnum;
    // End of variables declaration//GEN-END:variables
}
