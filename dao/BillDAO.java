package dao;

import model.Bill;
import model.BorrowTicket;
import model.Client;
import model.ReturnCostume;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class BillDAO extends DAO{
    public BillDAO() { super();    }
    public ArrayList<Bill> getBillofCostume(int costumeId, String startDate, String endDate){
        ArrayList<Bill> result = new ArrayList<Bill>();
        String sql = "SELECT b.id, c.name, bt.borrowDate, b.returnDate, rc.rentalFee\n" +
                    "FROM tblBill b\n" +
                    "JOIN tblClient c ON c.id = b.clientid\n" +
                    "JOIN tblBorrowTicket bt ON bt.id = b.borrowticketid\n" +
                    "JOIN tblborrowcostume bc ON bc.borrowticketid = bt.id   \n" +
                    "JOIN tblReturnCostume rc ON rc.borrowcostumeid = bc.id\n" +
                    "WHERE \n" +
                    "\tbc.costumeid = ?\n" +
                    "\tAND b.returnDate > ?\n" +
                    "    AND bt.borrowDate< ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, costumeId);
            ps.setString(2, startDate);
            ps.setString(3, endDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Bill r = new Bill();
                r.setId(rs.getInt("id"));
                Client c = new Client();
                c.setName(rs.getString("name"));
                r.setClient(c);
                BorrowTicket bt = new BorrowTicket();
                bt.setBorrowDate(rs.getDate("borrowDate"));
                r.setBorrowTicket(bt);
                r.setReturnDate(rs.getDate("returnDate"));
                ReturnCostume rc = new ReturnCostume();
                rc.setRentalFee(rs.getInt("rentalFee"));
                ArrayList<ReturnCostume> rcList = new ArrayList<ReturnCostume>();
                rcList.add(rc);
                r.setReturnCostumes(rcList);
                result.add(r);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
