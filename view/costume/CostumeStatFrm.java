package view.costume;

import dao.CostumeStatDAO;
import model.Costume;
import model.CostumeStat;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CostumeStatFrm extends JFrame implements ActionListener {
    private JTextField txtStartDate, txtEndDate;
    private JButton btnSearch;
    private JTable tblResult;
    private ArrayList<CostumeStat> listCostume;
    private User user;
    private CostumeStatFrm mainFrm;


    public CostumeStatFrm(User user) {
        super("Costume statistics");
        this.user = user;
        mainFrm = this;

        txtStartDate = new JTextField(10);
        txtEndDate = new JTextField(10);
        btnSearch = new JButton("Search");
        tblResult = new JTable();
        listCostume = new ArrayList<CostumeStat>();

        JPanel pnMain = new JPanel();
        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.PAGE_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));

        JLabel lblHome = new JLabel("Costume Statistics");
        lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHome.setFont (lblHome.getFont ().deriveFont (20.0f));
        pnMain.add(lblHome);
        pnMain.add(Box.createRigidArea(new Dimension(0,20)));

        JLabel lblnote = new JLabel("Vui lòng nhập đúng định dạng YYYY-MM-DD và số 0 ở đầu nếu cần");
        lblnote.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblnote.setFont (lblnote.getFont ().deriveFont (12.0f));
        pnMain.add(lblnote);
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));

        JPanel pn1 = new JPanel();
        pn1.setLayout(new BoxLayout(pn1,BoxLayout.X_AXIS));
        pn1.setSize(this.getSize().width-5, 20);
        pn1.add(new JLabel("Start date:"));
        pn1.add(txtStartDate);
        pn1.add(Box.createRigidArea(new Dimension(0,10)));
        pn1.add(new JLabel("End date:"));
        pn1.add(txtEndDate);
        pn1.add(Box.createRigidArea(new Dimension(0,10)));
        pn1.add(btnSearch);
        btnSearch.addActionListener(this);
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));
        pnMain.add(pn1);

        JPanel pn2 = new JPanel();
        pn2.setLayout(new BoxLayout(pn2,BoxLayout.Y_AXIS));
        pn2.setSize(this.getSize().width-5, 20);

        JScrollPane scrollPane = new JScrollPane(tblResult);
        tblResult.setFillsViewportHeight(false);
        scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, 250));

        tblResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int col = tblResult.getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / tblResult.getRowHeight();

                if (row < tblResult.getRowCount() && row >= 0 && col < tblResult.getColumnCount() && col >= 0) {
                    (new DetailCostumeStatFrm(user, listCostume.get(row), txtStartDate.getText(), txtEndDate.getText())).setVisible(true);
//                    mainFrm.setVisible(false);
                }
            }
        });

        pn2.add(scrollPane);
        pnMain.add(pn2);
        this.add(pnMain);
        this.setSize(600,300);
//        this.setLocation(200,10);
//        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() instanceof JButton && ((JButton) e.getSource()).equals(btnSearch)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                Date startDate = Date.valueOf(LocalDate.parse(txtStartDate.getText(), formatter));
                Date endDate = Date.valueOf(LocalDate.parse(txtEndDate.getText(), formatter));

                CostumeStatDAO csd = new CostumeStatDAO();
                listCostume = csd.getCostumeStat(startDate, endDate);

                String[] columnNames = {"ID", "Name", "Description", "Size", "Borrow Count", "Total Amount"};
                String[][] value = new String[listCostume.size()][6];
                for (int i = 0; i < listCostume.size(); i++) {
                    value[i][0] = listCostume.get(i).getId() + "";
                    value[i][1] = listCostume.get(i).getName();
                    value[i][2] = listCostume.get(i).getDes();
                    value[i][3] = listCostume.get(i).getSize();
                    value[i][4] = listCostume.get(i).getBorrowCount() + "";
                    value[i][5] = listCostume.get(i).getTotalAmount() + "";
                }
                DefaultTableModel tableModel = new DefaultTableModel(value, columnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        //unable to edit cells
                        return false;
                    }
                };
                tblResult.setModel(tableModel);
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, "Nhập sai định dạng, vui lòng nhập lại");
            return;
        }
    }
}
