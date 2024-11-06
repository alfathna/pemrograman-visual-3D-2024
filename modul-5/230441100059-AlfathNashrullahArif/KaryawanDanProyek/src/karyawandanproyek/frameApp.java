/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package karyawandanproyek;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class frameApp extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel model1, model2, model3;
    /**
     * Creates new form frameApp
     */
    public frameApp() {
        initComponents();
        this.setLocationRelativeTo(null);
        conn = koneksi.getConnection();
        tabelKaryawan();
        tabelProyek();
        tabelTransaksi();
        loadKaryawanComboBox();
        loadProyekComboBox();
        
        KeyListener keyListener = new KeyAdapter() {
//            @Override
            public void keyReleased(KeyEvent e) {
                checkButtonKaryawan();
                checkButtonProyek();
                checkButtonTransaksi();
            }
        };
    
        idK.addKeyListener(keyListener);
        namaK.addKeyListener(keyListener);
        departemenK.addKeyListener(keyListener);
        jabatanK.addKeyListener(keyListener);
        
        idP.addKeyListener(keyListener);
        namaP.addKeyListener(keyListener);
        durasiP.addKeyListener(keyListener);
        
        cbIDK.addKeyListener(keyListener);
        cbIDP.addKeyListener(keyListener);
        durasiT.addKeyListener(keyListener);
       
        checkButtonKaryawan(); 
        checkButtonProyek();
        checkButtonTransaksi();
        
        cbIDK.setSelectedItem(null);
        cbIDP.setSelectedItem(null);
        btnDeleteT.setEnabled(false);
        
        cekAngka(idK);
        cekAngka(idP);
        cekAngka(durasiP);
        cekAngka(durasiT);
    }
    
    private void cekAngka(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "INPUT HANYA BISA DIISI DENGAN ANGKA!", 
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });    
    }
    
// ======================================== CEK BUTTON ========================================
    private void checkButtonKaryawan() {
        boolean isIdFilled = !idK.getText().trim().isEmpty();
        boolean isNamaFilled = !namaK.getText().trim().isEmpty();
        boolean isDepartemenFilled = !departemenK.getText().trim().isEmpty();
        boolean isJabatanFilled = !jabatanK.getText().trim().isEmpty();

        if (isIdFilled && !isNamaFilled && !isDepartemenFilled && !isJabatanFilled) {
            btnDeleteK.setEnabled(true);
            btnUpdateK.setEnabled(false);
            btnSimpanK.setEnabled(false);
        } else if (isIdFilled && isNamaFilled && isDepartemenFilled && isJabatanFilled) {
            btnDeleteK.setEnabled(false);
            btnUpdateK.setEnabled(true);
            btnSimpanK.setEnabled(false);
        } else if (!isIdFilled && isNamaFilled && isDepartemenFilled && isJabatanFilled) {
            btnDeleteK.setEnabled(false);
            btnUpdateK.setEnabled(false);
            btnSimpanK.setEnabled(true);
        } else {
            btnDeleteK.setEnabled(false);
            btnUpdateK.setEnabled(false);
            btnSimpanK.setEnabled(false);
        }
    }

    private void checkButtonProyek() {
        boolean isIdFilled = !idP.getText().trim().isEmpty();
        boolean isNamaFilled = !namaP.getText().trim().isEmpty();
        boolean isDepartemenFilled = !durasiP.getText().trim().isEmpty();

        if (isIdFilled && !isNamaFilled && !isDepartemenFilled ) {
            btnDelete2.setEnabled(true);
            btnUpdateP.setEnabled(false);
            btnSimpanP.setEnabled(false);
        } else if (isIdFilled && isNamaFilled && isDepartemenFilled ) {
            btnDelete2.setEnabled(false);
            btnUpdateP.setEnabled(true);
            btnSimpanP.setEnabled(false);
        } else if (!isIdFilled && isNamaFilled && isDepartemenFilled ) {
            btnDelete2.setEnabled(false);
            btnUpdateP.setEnabled(false);
            btnSimpanP.setEnabled(true);
        } else {
            btnDelete2.setEnabled(false);
            btnUpdateP.setEnabled(false);
            btnSimpanP.setEnabled(false);
        }
    }
    
    private void checkButtonTransaksi() {
        boolean IdK_isi = cbIDK.getSelectedItem() != null; 
        boolean idP_isi = cbIDP.getSelectedItem() != null; 
        boolean peran_isi = !durasiT.getText().trim().isEmpty(); 

        if (IdK_isi && idP_isi && !peran_isi) {
            btnDeleteT.setEnabled(true);
            btnUpdateT.setEnabled(false);
            btnSimpanT.setEnabled(false);
        } else if (IdK_isi && idP_isi && peran_isi) {
            btnDeleteT.setEnabled(false);
            btnUpdateT.setEnabled(true);
            btnSimpanT.setEnabled(true);
        } else {
            btnDeleteT.setEnabled(false);
            btnUpdateT.setEnabled(false);
            btnSimpanT.setEnabled(false);
        }
    }
// ======================================== CEK BUTTON ========================================

// ======================================== TABEL ========================================
    private void tabelKaryawan(){
        model1 = new DefaultTableModel();
        tabelK.setModel(model1);
        model1.addColumn("ID");
        model1.addColumn("Nama");
        model1.addColumn("Jabatan");
        model1.addColumn("Departemen");      
        loadDataK();
    }
    
    private void tabelProyek(){
        model2 = new DefaultTableModel();
        tabelP.setModel(model2);       
        model2.addColumn("ID");
        model2.addColumn("Proyek");
        model2.addColumn("Durasi");       
        loadDataP();    
    }
    
    private void tabelTransaksi(){
        model3 = new DefaultTableModel();
        tabelT.setModel(model3);       
        model3.addColumn("Karyawan");
        model3.addColumn("Proyek");
        model3.addColumn("Durasi");       
        loadDataT();
    }
// ======================================== TABEL ========================================

// ======================================== LOAD DATA ========================================
    private void loadDataK() {
        model1.setRowCount(0);
        try {
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               model1.addRow(new Object[]{
               rs.getInt("id"),
               rs.getString("nama"),
               rs.getString("jabatan"),
               rs.getString("departemen")
             });
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    private void loadDataP() {
        model2.setRowCount(0);
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               model2.addRow(new Object[]{
               rs.getInt("id"),
               rs.getString("nama_proyek"),
               rs.getInt("durasi_pengerjaan")+" Minggu",
             });
        }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    private void loadDataT(){
        model3.setRowCount(0);
        try {
            String sql = "SELECT karyawan.nama AS nama_karyawan, proyek.nama_proyek, transaksi.durasi " +
                        "FROM transaksi " +
                        "JOIN karyawan ON transaksi.id_karyawan = karyawan.id " +
                        "JOIN proyek ON transaksi.id_proyek = proyek.id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model3.addRow(new Object[]{
                    rs.getString("nama_karyawan"),
                    rs.getString("nama_proyek"),
                    rs.getString("durasi")+ " Minggu"
            });
        }
        } catch (SQLException e) {
            System.out.println("Error loading Transaksi data: " + e.getMessage());
        }        
    }
// ======================================== LOAD DATA ========================================

// ======================================== KARYAWAN ========================================
    private void tambahDataK() {
        if (namaK.getText().trim().isEmpty() || jabatanK.getText().trim().isEmpty() 
            || departemenK.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ISI SEMUA DATA!", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
        }
        try{
            String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, Integer.parseInt(idK.getText()));
            ps.setString(1, namaK.getText());
            ps.setString(2, jabatanK.getText());
            ps.setString(3, departemenK.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data successfully added!");
            loadDataK();
            loadKaryawanComboBox();
        } catch (SQLException e) {
            System.out.println("Error! " + e.getMessage());
        }
        resetKaryawan();
        
    }
    
    private void editDataK() {
        try {
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, namaK.getText());
            ps.setString(2, jabatanK.getText());
            ps.setString(3, departemenK.getText());
            ps.setInt(4, Integer.parseInt(idK.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data successfully edited");
            loadDataK();
        }  catch (SQLException e) {
            System.out.println("Error! " + e.getMessage());
        }
        resetKaryawan();
    }
    
    private void hapusDataK() {
        try  {
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idK.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            loadDataK();
        } catch (SQLException e) {
             System.out.println("Error! " + e.getMessage());
        }
    }
// ======================================== KARYAWAN ========================================
    
// ======================================== PROYEK ========================================    
    private void tambahDataP() {
        if (namaP.getText().trim().isEmpty() || durasiP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mohon lengkapi semua data!", "Error!", JOptionPane.WARNING_MESSAGE);
        return;
        }
        try{
            String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, Integer.parseInt(idP.getText()));
            ps.setString(1, namaP.getText());
            ps.setInt(2, Integer.parseInt(durasiP.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data successfully added!");
            loadDataP();
            loadProyekComboBox();
        } catch (SQLException e) {
            System.out.println("Error! " + e.getMessage());
        }
        resetProyek();
    }
    
    private void editDataP() {
        try {
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, namaP.getText());
            ps.setString(2, durasiP.getText());
            ps.setInt(3, Integer.parseInt(idP.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data successfully edited");
            loadDataP();
        }  catch (SQLException e) {
            System.out.println("Error! " + e.getMessage());
        }
        resetProyek();
    }
        
    private void hapusDataP() {
        try  {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idP.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            loadDataP();
        } catch (SQLException e) {
             System.out.println("Error! " + e.getMessage());
        }
    }
// ======================================== PROYEK ========================================
  
// ======================================== LOAD COMBO BOX ========================================
    private void loadKaryawanComboBox(){
        cbIDK.removeAllItems();
        try {
            String sql = "SELECT id, nama FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()) {
                String idNama = rs.getInt("id") + " - " + rs.getString("nama");
                cbIDK.addItem(idNama); 
            }
        } catch (SQLException e) {
            System.out.println("Error loading Karyawan ComboBox: " + e.getMessage());
        }
    }
    
    private void loadProyekComboBox(){
        cbIDP.removeAllItems(); 
        try {
            String sql = "SELECT id, nama_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String idNamaProyek = rs.getInt("id") + " - " + rs.getString("nama_proyek"); 
                cbIDP.addItem(idNamaProyek); 
            }
        } catch (SQLException e) {
            System.out.println("Error loading Proyek ComboBox: " + e.getMessage());
        }    
    }  
// ======================================== LOAD COMBO BOX ========================================
    
// ======================================== TRANSAKSI ========================================
    private void tambahDataT() {
         if (durasiT.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "ISI SEMUA DATA!", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
        }
        try {
            String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, durasi) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(((String) cbIDK.getSelectedItem()).split(" - ")[0].trim()));
            ps.setInt(2, Integer.parseInt(((String) cbIDP.getSelectedItem()).split(" - ")[0].trim()));
            ps.setInt(3, Integer.parseInt(durasiT.getText()));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data transaksi berhasil ditambahkan!");
            loadDataT();
            loadKaryawanComboBox();
            loadProyekComboBox();
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, "Data transaksi dengan ID Karyawan dan ID Proyek ini sudah ada.", "Duplicate Entry Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error saat menambahkan data transaksi: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println("Error saat menambahkan data transaksi: " + e.getMessage());
        }
        resetTransaksi();
    
    }
    
    private void updateDataT() {
        if (cbIDK.getSelectedItem() == null || cbIDP.getSelectedItem() == null || durasiT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih ID Karyawan, ID Proyek, dan isi Peran untuk mengupdate transaksi!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            String sql = "UPDATE transaksi SET durasi = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, durasiT.getText());
            ps.setInt(2, Integer.parseInt(cbIDK.getSelectedItem().toString().split(" - ")[0].trim()));
            ps.setInt(3, Integer.parseInt(cbIDP.getSelectedItem().toString().split(" - ")[0].trim()));
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil diupdate!");
            } else {
                JOptionPane.showMessageDialog(this, "Transaksi tidak ditemukan!", "Update Data", JOptionPane.WARNING_MESSAGE);
            }
            loadDataT(); 
        } catch (SQLException e) {
            System.out.println("Error saat mengupdate data transaksi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error konversi ID: " + e.getMessage());
        }
        resetTransaksi();
    }
    
    private void hapusDataT() {
        if (cbIDK.getSelectedItem() == null || cbIDP.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Pilih ID Karyawan dan ID Proyek untuk menghapus transaksi!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(((String) cbIDK.getSelectedItem()).split(" - ")[0].trim()));
            ps.setInt(2, Integer.parseInt(((String) cbIDP.getSelectedItem()).split(" - ")[0].trim()));

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(this, "Transaksi tidak ditemukan!", "Delete Data", JOptionPane.WARNING_MESSAGE);
            }

            loadDataT();
        } catch (SQLException e) {
            System.out.println("Error saat menghapus data transaksi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error konversi ID: " + e.getMessage());
        }
    }
// ======================================== TRANSAKSI ========================================
    
    private void resetKaryawan(){
        idK.setText("");
        namaK.setText("");
        jabatanK.setText("");
        departemenK.setText("");
    }
    
    private void resetProyek(){
        idP.setText("");
        namaP.setText("");
        durasiP.setText("");
    }
    
    private void resetTransaksi(){
        cbIDK.setSelectedItem(null);
        cbIDP.setSelectedItem(null);
        durasiT.setText("");        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pAtas = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pTengah = new javax.swing.JPanel();
        Tabbed = new javax.swing.JTabbedPane();
        tabKaryawan = new javax.swing.JPanel();
        pAtasK = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pTengahK = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idK = new javax.swing.JTextField();
        namaK = new javax.swing.JTextField();
        jabatanK = new javax.swing.JTextField();
        departemenK = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelK = new javax.swing.JTable();
        btnSimpanK = new javax.swing.JButton();
        btnUpdateK = new javax.swing.JButton();
        btnDeleteK = new javax.swing.JButton();
        tabProyek = new javax.swing.JPanel();
        pAtasP = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pTengahP = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        idP = new javax.swing.JTextField();
        namaP = new javax.swing.JTextField();
        durasiP = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelP = new javax.swing.JTable();
        btnSimpanP = new javax.swing.JButton();
        btnUpdateP = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();
        tabTransaksi = new javax.swing.JPanel();
        pAtasT = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pTengahT = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbIDK = new javax.swing.JComboBox<>();
        cbIDP = new javax.swing.JComboBox<>();
        durasiT = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelT = new javax.swing.JTable();
        btnSimpanT = new javax.swing.JButton();
        btnUpdateT = new javax.swing.JButton();
        btnDeleteT = new javax.swing.JButton();
        pBawah = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pAtas.setBackground(new java.awt.Color(74, 73, 71));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karyawandanproyek/employe.png"))); // NOI18N
        pAtas.add(jLabel8);

        jLabel1.setFont(new java.awt.Font("Schadow BT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 247, 240));
        jLabel1.setText("APLIKASI MANAJEMEN");
        pAtas.add(jLabel1);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/karyawandanproyek/employe2.png"))); // NOI18N
        pAtas.add(jLabel16);

        getContentPane().add(pAtas, java.awt.BorderLayout.PAGE_START);

        pTengah.setBackground(new java.awt.Color(177, 116, 87));

        Tabbed.setBackground(new java.awt.Color(216, 210, 194));
        Tabbed.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        tabKaryawan.setLayout(new java.awt.BorderLayout());

        pAtasK.setBackground(new java.awt.Color(216, 210, 194));

        jLabel2.setFont(new java.awt.Font("Schadow BT", 1, 16)); // NOI18N
        jLabel2.setText("KARYAWAN");
        pAtasK.add(jLabel2);

        tabKaryawan.add(pAtasK, java.awt.BorderLayout.PAGE_START);

        pTengahK.setBackground(new java.awt.Color(250, 247, 240));
        pTengahK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Departemen");
        pTengahK.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        jLabel6.setText("ID");
        pTengahK.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel7.setText("Nama");
        pTengahK.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel11.setText("Jabatan");
        pTengahK.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        idK.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                idKAncestorResized(evt);
            }
        });
        idK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idKKeyReleased(evt);
            }
        });
        pTengahK.add(idK, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 180, -1));

        namaK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                namaKKeyReleased(evt);
            }
        });
        pTengahK.add(namaK, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 180, -1));
        pTengahK.add(jabatanK, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 180, -1));
        pTengahK.add(departemenK, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 180, -1));

        tabelK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelK);

        pTengahK.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 400, 320));

        btnSimpanK.setText("Save");
        btnSimpanK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanKActionPerformed(evt);
            }
        });
        pTengahK.add(btnSimpanK, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, -1, -1));

        btnUpdateK.setText("Update");
        btnUpdateK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKActionPerformed(evt);
            }
        });
        pTengahK.add(btnUpdateK, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, -1, -1));

        btnDeleteK.setText("Delete");
        btnDeleteK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKActionPerformed(evt);
            }
        });
        pTengahK.add(btnDeleteK, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, -1, -1));

        tabKaryawan.add(pTengahK, java.awt.BorderLayout.CENTER);

        Tabbed.addTab("Karyawan", tabKaryawan);

        tabProyek.setLayout(new java.awt.BorderLayout());

        pAtasP.setBackground(new java.awt.Color(216, 210, 194));

        jLabel4.setFont(new java.awt.Font("Schadow BT", 1, 16)); // NOI18N
        jLabel4.setText("PROYEK");
        pAtasP.add(jLabel4);

        tabProyek.add(pAtasP, java.awt.BorderLayout.PAGE_START);

        pTengahP.setBackground(new java.awt.Color(250, 247, 240));
        pTengahP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("ID");
        pTengahP.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel10.setText("Nama Proyek");
        pTengahP.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel12.setText("Durasi Pengerjaan");
        pTengahP.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));
        pTengahP.add(idP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 180, -1));
        pTengahP.add(namaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 180, -1));
        pTengahP.add(durasiP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 180, -1));

        tabelP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelP);

        pTengahP.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 400, 320));

        btnSimpanP.setText("Save");
        btnSimpanP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPActionPerformed(evt);
            }
        });
        pTengahP.add(btnSimpanP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, -1, -1));

        btnUpdateP.setText("Update");
        btnUpdateP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePActionPerformed(evt);
            }
        });
        pTengahP.add(btnUpdateP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, -1, -1));

        btnDelete2.setText("Delete");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });
        pTengahP.add(btnDelete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, -1, -1));

        tabProyek.add(pTengahP, java.awt.BorderLayout.CENTER);

        Tabbed.addTab("Proyek", tabProyek);

        tabTransaksi.setLayout(new java.awt.BorderLayout());

        pAtasT.setBackground(new java.awt.Color(216, 210, 194));

        jLabel3.setFont(new java.awt.Font("Schadow BT", 1, 16)); // NOI18N
        jLabel3.setText("TRANSAKSI");
        pAtasT.add(jLabel3);

        tabTransaksi.add(pAtasT, java.awt.BorderLayout.PAGE_START);

        pTengahT.setBackground(new java.awt.Color(250, 247, 240));
        pTengahT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("ID Karyawan");
        pTengahT.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel14.setText("ID Proyek");
        pTengahT.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel15.setText("Durasi");
        pTengahT.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        cbIDK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pTengahT.add(cbIDK, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 180, -1));

        cbIDP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pTengahT.add(cbIDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 180, -1));
        pTengahT.add(durasiT, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 180, -1));

        tabelT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabelT);

        pTengahT.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 390, 320));

        btnSimpanT.setText("Save");
        btnSimpanT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanTActionPerformed(evt);
            }
        });
        pTengahT.add(btnSimpanT, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, -1));

        btnUpdateT.setText("Update");
        btnUpdateT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTActionPerformed(evt);
            }
        });
        pTengahT.add(btnUpdateT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, -1, -1));

        btnDeleteT.setText("Delete");
        btnDeleteT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTActionPerformed(evt);
            }
        });
        pTengahT.add(btnDeleteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));

        tabTransaksi.add(pTengahT, java.awt.BorderLayout.CENTER);

        Tabbed.addTab("Transaksi", tabTransaksi);

        javax.swing.GroupLayout pTengahLayout = new javax.swing.GroupLayout(pTengah);
        pTengah.setLayout(pTengahLayout);
        pTengahLayout.setHorizontalGroup(
            pTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabbed)
        );
        pTengahLayout.setVerticalGroup(
            pTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        getContentPane().add(pTengah, java.awt.BorderLayout.CENTER);

        pBawah.setBackground(new java.awt.Color(74, 73, 71));
        pBawah.setPreferredSize(new java.awt.Dimension(588, 47));

        btnExit.setBackground(new java.awt.Color(255, 0, 51));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBawahLayout = new javax.swing.GroupLayout(pBawah);
        pBawah.setLayout(pBawahLayout);
        pBawahLayout.setHorizontalGroup(
            pBawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBawahLayout.createSequentialGroup()
                .addContainerGap(457, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        pBawahLayout.setVerticalGroup(
            pBawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBawahLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnExit)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(pBawah, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanKActionPerformed
        // TODO add your handling code here:
        tambahDataK();
    }//GEN-LAST:event_btnSimpanKActionPerformed

    private void btnSimpanPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPActionPerformed
        // TODO add your handling code here:
        tambahDataP();
    }//GEN-LAST:event_btnSimpanPActionPerformed

    private void btnUpdateKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKActionPerformed
        // TODO add your handling code here:
        editDataK();
    }//GEN-LAST:event_btnUpdateKActionPerformed

    private void btnUpdatePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePActionPerformed
        // TODO add your handling code here:
        editDataP();
    }//GEN-LAST:event_btnUpdatePActionPerformed

    private void btnDeleteKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKActionPerformed
        // TODO add your handling code here:
        hapusDataK();
    }//GEN-LAST:event_btnDeleteKActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        // TODO add your handling code here:
        hapusDataP();
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnSimpanTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanTActionPerformed
        // TODO add your handling code here:
        tambahDataT();
    }//GEN-LAST:event_btnSimpanTActionPerformed

    private void btnUpdateTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTActionPerformed
        // TODO add your handling code here:
        updateDataT();
    }//GEN-LAST:event_btnUpdateTActionPerformed

    private void btnDeleteTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTActionPerformed
        // TODO add your handling code here:
        hapusDataT();
    }//GEN-LAST:event_btnDeleteTActionPerformed

    private void idKAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_idKAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_idKAncestorResized

    private void idKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_idKKeyReleased

    private void namaKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_namaKKeyReleased

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int exit = JOptionPane.showConfirmDialog(null,"Keluar Program?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(frameApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabbed;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnDeleteK;
    private javax.swing.JButton btnDeleteT;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSimpanK;
    private javax.swing.JButton btnSimpanP;
    private javax.swing.JButton btnSimpanT;
    private javax.swing.JButton btnUpdateK;
    private javax.swing.JButton btnUpdateP;
    private javax.swing.JButton btnUpdateT;
    private javax.swing.JComboBox<String> cbIDK;
    private javax.swing.JComboBox<String> cbIDP;
    private javax.swing.JTextField departemenK;
    private javax.swing.JTextField durasiP;
    private javax.swing.JTextField durasiT;
    private javax.swing.JTextField idK;
    private javax.swing.JTextField idP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jabatanK;
    private javax.swing.JTextField namaK;
    private javax.swing.JTextField namaP;
    private javax.swing.JPanel pAtas;
    private javax.swing.JPanel pAtasK;
    private javax.swing.JPanel pAtasP;
    private javax.swing.JPanel pAtasT;
    private javax.swing.JPanel pBawah;
    private javax.swing.JPanel pTengah;
    private javax.swing.JPanel pTengahK;
    private javax.swing.JPanel pTengahP;
    private javax.swing.JPanel pTengahT;
    private javax.swing.JPanel tabKaryawan;
    private javax.swing.JPanel tabProyek;
    private javax.swing.JPanel tabTransaksi;
    private javax.swing.JTable tabelK;
    private javax.swing.JTable tabelP;
    private javax.swing.JTable tabelT;
    // End of variables declaration//GEN-END:variables
}
