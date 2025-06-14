//package view.costume;
//
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//import dao.RoomDAO;
//import model.Costume;
//import model.User;
//import view.user.ManagerHomeFrm;
//
//public class EditRoomFrm extends JFrame implements ActionListener{
//	private Costume costume;
//	private JTextField txtId, txtName, txtType, txtPrice, txtDes;
//	private JButton btnUpdate, btnReset;
//	private User user;
//
//
//	public EditRoomFrm(User user, Costume costume){
//		super("Edit a costume");
//		this.user = user;
//		this.costume = costume;
//
//		JPanel pnMain = new JPanel();
//		pnMain.setSize(this.getSize().width-5, this.getSize().height-20);
//		pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));
//		pnMain.add(Box.createRigidArea(new Dimension(0,10)));
//
//		JLabel lblHome = new JLabel("Edit a costume");
//		lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);
//		lblHome.setFont (lblHome.getFont ().deriveFont (20.0f));
//		pnMain.add(lblHome);
//		pnMain.add(Box.createRigidArea(new Dimension(0,20)));
//
//		txtId = new JTextField(15);
//		txtId.setEditable(false);
//		txtName = new JTextField(15);
//		txtType = new JTextField(15);
//		txtPrice = new JTextField(15);
//		txtDes = new JTextField(15);
//		btnUpdate = new JButton("Update");
//		btnReset = new JButton("Reset");
//
//		JPanel content = new JPanel();
//		content.setLayout(new GridLayout(6,2));
//		content.add(new JLabel("Costume ID:")); 	content.add(txtId);
//		content.add(new JLabel("Costume name:")); 	content.add(txtName);
//		content.add(new JLabel("Type:")); 	content.add(txtType);
//		content.add(new JLabel("Price:")); 	content.add(txtPrice);
//		content.add(new JLabel("Description:")); 	content.add(txtDes);
//		content.add(btnUpdate); 	content.add(btnReset);
//		pnMain.add(content);
//		btnUpdate.addActionListener(this);
//		btnReset.addActionListener(this);
//
//		initForm();
//		this.setContentPane(pnMain);
//		this.setSize(600,300);
//		this.setLocation(200,10);
//		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//	}
//
//	private void initForm(){
//		if(costume != null){
//			txtId.setText(costume.getId()+"");
//			txtName.setText(costume.getName());
//			txtType.setText(costume.getType());
//			txtPrice.setText(costume.getPrice()+"");
//			txtDes.setText(costume.getDes());
//		}
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		JButton btnClicked = (JButton)e.getSource();
//		if(btnClicked.equals(btnReset)){
//			initForm();
//			return;
//		}
//		if(btnClicked.equals(btnUpdate)){
//			costume.setName(txtName.getText());
//			costume.setType(txtType.getText());
//			costume.setPrice(Float.parseFloat(txtPrice.getText()));
//			costume.setDes(txtDes.getText());
//
//			RoomDAO rd = new RoomDAO();
//			if(rd.updateRoom(costume)) {
//				JOptionPane.showMessageDialog(this, "The costume is succeffully updated!");
//				(new ManagerHomeFrm(user)).setVisible(true);
//				this.dispose();
//			}
//		}
//	}
//}
