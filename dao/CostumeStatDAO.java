package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.CostumeStat;

public class CostumeStatDAO extends DAO{

	public CostumeStatDAO() {
		super();
	}
	
	public ArrayList<CostumeStat> getCostumeStat(Date startDate, Date endDate){
		ArrayList<CostumeStat> result = new ArrayList<CostumeStat>();
		String sql = "SELECT c.id, c.name, c.des, c.size,\n" +
					"  SUM(\n" +
					"    CASE \n" +
					"      WHEN bt.borrowDate BETWEEN ? AND ?\n" +
					"      THEN bc.quantity\n" +
					"      ELSE 0\n" +
					"    END\n" +
					"  ) AS borrowCount,\n" +
					"  SUM(\n" +
					"    CASE \n" +
					"      WHEN bt.borrowDate BETWEEN ? AND ?\n" +
					"      THEN \n" +
					"        CASE \n" +
					"          WHEN bc.isReturned = 1 THEN rc.rentalfee\n" +
					"          ELSE DATEDIFF(?, bt.borrowDate) * (c.price * 0.1)\n" +
					"        END\n" +
					"      ELSE 0\n" +
					"    END\n" +
					"  ) AS amount\n" +
					"FROM tblCostume c\n" +
					"LEFT JOIN tblBorrowCostume bc ON bc.costumeid = c.id\n" +
					"LEFT JOIN tblBorrowTicket bt ON bt.id = bc.borrowTicketid\n" +
					"LEFT JOIN tblReturnCostume rc ON rc.borrowCostumeid = bc.id\n" +
					"LEFT JOIN tblBill bill ON bill.id = rc.billid\n" +
					"GROUP BY c.id, c.name, c.des, c.size\n" +
					"ORDER BY borrowCount DESC, amount DESC;";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sdf.format(startDate));
			ps.setString(2, sdf.format(endDate));
			ps.setString(3, sdf.format(startDate));
			ps.setString(4, sdf.format(endDate));
			ps.setString(5, sdf.format(endDate));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				CostumeStat r = new CostumeStat();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				r.setSize(rs.getString("size"));
				r.setDes(rs.getString("des"));
				r.setBorrowCount(rs.getInt("borrowCount"));
				r.setTotalAmount(rs.getInt("amount"));
				result.add(r);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
