/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btjava;

import java.sql.Connection;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author pc
 */
public class ListProduct extends javax.swing.JFrame {

    final String header[] = {"ID", "Tên Sản Phẩm", "Số Lượng"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);

    Connect cn = new Connect();
    Connection conn;

    
    public ListProduct() {
        initComponents();
        setLocationRelativeTo(null);
        loadTable();
    }

    public void loadTable() {
        try {
            conn = cn.getConnection();
            int number;
            Vector row;
            String sql = "select * from SanPham";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount();
            tb.setRowCount(0);
            while (rs.next()) {
                row = new Vector();
                for (int i = 1; i <= number; i++) {
                    row.addElement(rs.getString(i));
                }
                tb.addRow(row);
                ListTable.setModel(tb);
            }
            st.close();
            rs.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        ListTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (ListTable.getSelectedRow() >= 0) {
                    IDTF.setText(ListTable.getValueAt(ListTable.getSelectedRow(), 0) + "");
                    NameTF.setText(ListTable.getValueAt(ListTable.getSelectedRow(), 1) + "");
                    SLTF.setText(ListTable.getValueAt(ListTable.getSelectedRow(), 2) + "");
                    
                }
            }

        });
    }
    //hàm này sẽ xóa trắng dữ liệu sau khi thêm
    private void xoatrang() {
        IDTF.setText("");
        NameTF.setText("");
        SLTF.setText("");
        
        loadTable();
        IDTF.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IDTF = new javax.swing.JTextField();
        NameTF = new javax.swing.JTextField();
        SLTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListTable = new javax.swing.JTable();
        ThemButton = new javax.swing.JButton();
        SuaButton = new javax.swing.JButton();
        XoaButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIST PRODUCT");

        jLabel2.setText("ID Sản phẩm");

        jLabel3.setText("Tên Sản Phẩm");

        jLabel4.setText("Số Lượng");

        ListTable.setModel(new javax.swing.table.DefaultTableModel(
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
        ListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListTable);

        ThemButton.setBackground(new java.awt.Color(0, 51, 51));
        ThemButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        ThemButton.setForeground(new java.awt.Color(0, 255, 255));
        ThemButton.setText("Thêm");
        ThemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemButtonActionPerformed(evt);
            }
        });

        SuaButton.setBackground(new java.awt.Color(0, 51, 51));
        SuaButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        SuaButton.setForeground(new java.awt.Color(0, 255, 255));
        SuaButton.setText("Sửa");
        SuaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaButtonActionPerformed(evt);
            }
        });

        XoaButton.setBackground(new java.awt.Color(0, 51, 51));
        XoaButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        XoaButton.setForeground(new java.awt.Color(0, 255, 255));
        XoaButton.setText("Xóa");
        XoaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaButtonActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 51, 51));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 255, 255));
        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(ThemButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SuaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(XoaButton)
                                .addGap(41, 41, 41))
                            .addComponent(SLTF, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SLTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThemButton)
                    .addComponent(SuaButton)
                    .addComponent(XoaButton)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ThemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemButtonActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
        try {
            if(IDTF.getText().equals("") || NameTF.getText().equals("") || SLTF.getText().equals("")) {
                
                JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ dữ liệu");
            }else {
                
                StringBuffer sb = new StringBuffer();
                String sql_check_pk = "select ID from SanPham where ID = '" + IDTF.getText()+"'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql_check_pk);
                if(rs.next()) {
                    sb.append("Sản Phẩm này đã tồn tại");
                }
                if(sb.length()>0) { 
                    JOptionPane.showMessageDialog(this, sb.toString()); 
                }else {
                    // thêm 
                    String sql = "Insert into SanPham values('"+IDTF.getText()+"','"+NameTF.getText()+"','"+SLTF.getText()+"')";
                           
                    st = conn.createStatement();
                    int kq = st.executeUpdate(sql);
                    if(kq>0) {
                        JOptionPane.showMessageDialog(this,"Thêm mới thành công");
                        xoatrang();
                    }
                }
                st.close();
                rs.close();
            }
            conn.close();
        }catch(Exception e) {
            
        }
    }//GEN-LAST:event_ThemButtonActionPerformed

    private void ListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListTableMouseClicked
        // TODO add your handling code here:
        int x = ListTable.getSelectedRow();
        if(x>=0) {
            IDTF.setText(ListTable.getValueAt(x, 0) + "");
            NameTF.setText(ListTable.getValueAt(x, 1) + "");
            SLTF.setText(ListTable.getValueAt(x, 2) + "");
           
            IDTF.setEnabled(false);
        }
    }//GEN-LAST:event_ListTableMouseClicked

    private void XoaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaButtonActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
        try{
            String sql = "Delete SanPham where ID = '"+IDTF.getText()+"'";
            Statement st = conn.createStatement();
            int chk = JOptionPane.showConfirmDialog(this ,"Bạn chắc chắn xóa chứ", "Thông báo", JOptionPane.YES_NO_OPTION);
            if(chk == JOptionPane.YES_OPTION) {
                st.executeUpdate(sql);
                xoatrang();
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            }
        }catch(Exception e) {
            
        }
    }//GEN-LAST:event_XoaButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void SuaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaButtonActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
        try {
            if(NameTF.getText().equals("") || SLTF.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ dữ liệu");
            }else {
                StringBuffer sb = new StringBuffer();
                String sql_check_pk = "select ID from SanPham where ID = '" + IDTF.getText()+"'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql_check_pk);
                
                if(rs.next()) {
                    sb.append("Sản phẩm này đã tồn tại");
                    String sql = "update SanPham set TenSP = '" + NameTF.getText()+"', SoLuong = '" + SLTF.getText() + "' Where ID = '" + IDTF.getText()+"'";
                    st = conn.createStatement();
                    int kq = st.executeUpdate(sql);
                    if(kq>0) {
                        JOptionPane.showMessageDialog(this,"Cập nhật thành công");
                        xoatrang();
                    }
                }
                st.close();
                rs.close();
            }
            conn.close();
        }catch(Exception e) {
            
        }
    }//GEN-LAST:event_SuaButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDTF;
    private javax.swing.JTable ListTable;
    private javax.swing.JTextField NameTF;
    private javax.swing.JTextField SLTF;
    private javax.swing.JButton SuaButton;
    private javax.swing.JButton ThemButton;
    private javax.swing.JButton XoaButton;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
