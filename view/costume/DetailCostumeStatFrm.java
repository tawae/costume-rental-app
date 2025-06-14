package view.costume;

import dao.BillDAO;
import model.Bill;
import model.CostumeStat;
import model.ReturnCostume;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

public class DetailCostumeStatFrm extends JFrame implements ActionListener {
    private JTable tblResult;
    private JButton btnQuit;
    private ArrayList<Bill> listBill;
    private User user;
    private DetailCostumeStatFrm mainFrm;
    private CostumeStat costumeStat;
    private String startDate, endDate;

    public DetailCostumeStatFrm(User user, CostumeStat stat, String startDate, String endDate) {
        super("Detailed costume statistics");
        this.user = user;
        this.costumeStat = stat;
        this.startDate = startDate;
        this.endDate = endDate;
        mainFrm = this;

        listBill = new ArrayList<>();

        JPanel pnMain = new JPanel();
//        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.PAGE_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));

        JLabel lblHome = new JLabel(stat.getName());
        lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHome.setFont (lblHome.getFont ().deriveFont (20.0f));
        pnMain.add(lblHome);
        pnMain.add(Box.createRigidArea(new Dimension(0,20)));


        tblResult = new JTable();

        JPanel pn1 = new JPanel();
        pn1.setLayout(new BoxLayout(pn1, BoxLayout.Y_AXIS));
//        pn1.setSize(this.getSize().width-5, 20);

        JScrollPane scrollPane = new JScrollPane(tblResult);
        tblResult.setFillsViewportHeight(false);
        scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, 250));
        pn1.add(scrollPane);
        btnQuit = new JButton("Quit");
        btnQuit.addActionListener(this);
        btnQuit.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pn1.add(btnQuit);
        pnMain.add(pn1);

        loadBillData();

        this.add(pnMain);
        this.setSize(600,300);
        this.setLocation(700,50);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void loadBillData() {
        BillDAO bd = new BillDAO();
        listBill = bd.getBillofCostume(costumeStat.getId(), startDate, endDate);

        String[] columnNames = {"ID", "Client name", "Borrow date", "Return date", "Total amount"};
        String[][] value = new String[listBill.size()][5];
        for (int i = 0; i < listBill.size(); i++) {
            Bill bill = listBill.get(i);
            value[i][0] = bill.getId() + "";
            value[i][1] = bill.getClient().getName();
            value[i][2] = bill.getBorrowTicket().getBorrowDate().toString();
            value[i][3] = bill.getReturnDate().toString();
            int totalAmount = 0;
            if (bill.getReturnCostumes() != null) {
                for (ReturnCostume rc : bill.getReturnCostumes()) {
                    totalAmount += rc.getRentalFee();
                }
            }
            value[i][4] = totalAmount + "";        }
        DefaultTableModel tableModel = new DefaultTableModel(value, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblResult.setModel(tableModel);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnQuit) {
            mainFrm.dispose();
        }
    }
}
