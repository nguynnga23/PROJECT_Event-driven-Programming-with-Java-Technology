package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JViewport;

import com.toedter.calendar.JDateChooser;

import bus.ThongKe_BUS;
import connectDB.ConnectDB;
import dao.ThongKe_DAO;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;

public class ThongKe {

	public JFrame frame;
	private static JTable table;
	private static JTextField txtDT;
	private static JDateChooser dateBD;
	private static JDateChooser dateKT;
	private static ThongKe_DAO tk_dao;
	private static DefaultTableModel model;
	private static ThongKe_BUS tk_bus;
	private static Date ngayBD;
	private static Date ngayKT;
	private static JTextField txtNam;
	private static JComboBox<String> cbxQuy;
	private static DecimalFormat x = new DecimalFormat("###,###,###,###");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe window = new ThongKe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ThongKe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.scrollbar);
		frame.setBounds(100, 100, 985, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		tk_bus = new ThongKe_BUS();
		tk_dao = new ThongKe_DAO();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(10, 0, 964, 75);
		frame.getContentPane().add(panel);
		frame.setLocationRelativeTo(null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ DOANH THU");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setBackground(SystemColor.scrollbar);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 944, 56);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(10, 76, 964, 528);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(SystemColor.window);
		panel_2.setBounds(10, 11, 944, 80);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thống Kê Từ Ngày:");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 12, 123, 25);
		panel_2.add(lblNewLabel_1);
		
		 dateBD = new JDateChooser();
		 dateBD.addPropertyChangeListener(new PropertyChangeListener() {
		 	public void propertyChange(PropertyChangeEvent evt) {
//		 		Tim();
		 	}
		 });
		dateBD.setBounds(134, 12, 123, 25);
		panel_2.add(dateBD);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thống Kê Đến Ngày:");
		lblNewLabel_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(267, 12, 136, 25);
		panel_2.add(lblNewLabel_1_1);
		
		 dateKT = new JDateChooser();
		 dateKT.addPropertyChangeListener(new PropertyChangeListener() {
		 	public void propertyChange(PropertyChangeEvent evt) {
//		 		Tim();
		 	}
		 });
		dateKT.setBounds(399, 12, 123, 25);
		panel_2.add(dateKT);
		
		txtDT = new JTextField();
		txtDT.setHorizontalAlignment(SwingConstants.CENTER);
		txtDT.setBounds(612, 43, 149, 25);
		panel_2.add(txtDT);
		
		txtDT.setColumns(10);
		txtDT.setEditable(false);
		
		JButton btnThoat = new JButton("THOÁT");
		btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu tc = new TrangChu();
				tc.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(SystemColor.window);
		btnThoat.setBounds(832, 40, 102, 28);
		panel_2.add(btnThoat);
		
		JButton btnDS = new JButton("LÀM MỚI");
		btnDS.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				XoaDuLieutrenModel();
//				DocDuLieu();
				dateBD.setDate(null);
				dateKT.setDate(null);
				txtDT.setText(null);
			}
		});
		btnDS.setBackground(SystemColor.textHighlight);
		btnDS.setForeground(SystemColor.window);
		btnDS.setBounds(832, 10, 102, 28);
		panel_2.add(btnDS);
		
		JButton btnNewButton = new JButton("Xem Doanh Thu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tim();
				txtDT.setText(x.format(getTong()));;
			}
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(612, 10, 149, 25);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quý:");
		lblNewLabel_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(10, 44, 45, 25);
		panel_2.add(lblNewLabel_1_2);
		
		cbxQuy = new JComboBox<String>();
		cbxQuy.addItem("1");
		cbxQuy.addItem("2");
		cbxQuy.addItem("3");
		cbxQuy.addItem("4");
		cbxQuy.setBounds(50, 45, 45, 21);
		panel_2.add(cbxQuy);
		
		txtNam = new JTextField();
		txtNam.setBounds(150, 45, 61, 23);
		panel_2.add(txtNam);
		txtNam.setColumns(10);
		
		JButton btnQuy = new JButton("Xem Theo Quý");
		btnQuy.setForeground(Color.WHITE);
		btnQuy.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnQuy.setBackground(SystemColor.textHighlight);
		btnQuy.setBounds(234, 45, 149, 25);
		panel_2.add(btnQuy);
		btnQuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TimTheoQuy();
				txtDT.setText(x.format(getTong()));
			}
		});
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Năm: ");
		lblNewLabel_1_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(114, 45, 45, 25);
		panel_2.add(lblNewLabel_1_2_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.menu);
		panel_3.setBounds(10, 101, 944, 420);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 11, 944, 399);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn Tour", "S\u1ED1 L\u1EA7n \u0110\u1EB7t", "S\u1ED1 L\u01B0\u1EE3ng Kh\u00E1ch H\u00E0ng", "Gi\u00E1 Tour", "T\u1ED5ng Ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		DocDuLieu();
	}
	
	private static void DocDuLieu() {
	    ArrayList<Object[]> list = tk_bus.getAllThongKe();
	    for (Object[] tk : list) {
	        model.addRow(tk);
	    }
	}

	private static void XoaDuLieutrenModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	
	private static double getTong() {
		 double sum = 0;
		    int selectedRows = model.getRowCount();
		    for (int i = 0; i < selectedRows; i++) {
		        double value = Double.parseDouble(model .getValueAt(i, 4).toString());
		        sum += value;
		    }
		    return sum;
	    
	}

	
	private static void Tim() {
		try {
			txtDT.setText(x.format(getTong()));
			 try {
				 ngayBD = new java.sql.Date(dateBD.getDate().getTime());
				 ngayKT = new java.sql.Date(dateKT.getDate().getTime());
			} catch (Exception e) {
				// TODO: handle exception
				ngayBD=null;
				ngayKT=null;
			}
			 ArrayList<Object[]> list = new ArrayList<>();
			
			if(ngayBD==null && ngayKT ==null) {
				XoaDuLieutrenModel();
				DocDuLieu();
			}
			if(ngayBD!=null && ngayKT !=null) {
				XoaDuLieutrenModel();
				 list = tk_bus.getThongKeTheo2ngay(ngayBD, ngayKT);
				 for (Object[] tk : list) {
				        model.addRow(tk);
				    }
			}
			if(ngayBD!=null && ngayKT ==null) {
				XoaDuLieutrenModel();
				 list = tk_bus.getThongKeTheoNgayBD(ngayBD);
				 for (Object[] tk : list) {
				        model.addRow(tk);
				    }
			}
			if(ngayBD==null && ngayKT !=null) {
				XoaDuLieutrenModel();
				list = tk_bus.getThongKeTheoNgayKT(ngayKT);
				for (Object[] tk : list) {
			        model.addRow(tk);
			    }
			}
			if(list ==null) {
				JOptionPane.showMessageDialog(null, "Không hóa đơn nào !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
	private static void TimTheoQuy() {
	    try {
	        int nam = Integer.parseInt(txtNam.getText());
	        int quy = Integer.parseInt(cbxQuy.getSelectedItem().toString());

	        Date ngayBD = null;
	        Date ngayKT = null;
	        switch (quy) {
	            case 1:
	                ngayBD = Date.valueOf(nam + "-01-01"); // Quý 1 bắt đầu từ ngày 01/01
	                ngayKT = Date.valueOf(nam + "-03-31"); // Quý 1 kết thúc vào ngày 31/03
	                break;
	            case 2:
	                ngayBD = Date.valueOf(nam + "-04-01"); // Quý 2 bắt đầu từ ngày 01/04
	                ngayKT = Date.valueOf(nam + "-06-30"); // Quý 2 kết thúc vào ngày 30/06
	                break;
	            case 3:
	                ngayBD = Date.valueOf(nam + "-07-01"); // Quý 3 bắt đầu từ ngày 01/07
	                ngayKT = Date.valueOf(nam + "-09-30"); // Quý 3 kết thúc vào ngày 30/09
	                break;
	            case 4:
	                ngayBD = Date.valueOf(nam + "-10-01"); // Quý 4 bắt đầu từ ngày 01/10
	                ngayKT = Date.valueOf(nam + "-12-31"); // Quý 4 kết thúc vào ngày 31/12
	                break;
	        }
	   	 
	        txtDT.setText(x.format(getTong()));
	        
	        ArrayList<Object[]> list = new ArrayList<>();
	        XoaDuLieutrenModel();
	        list = tk_bus.getThongKeTheo2ngay(ngayBD, ngayKT);
	        for (Object[] tk : list) {
	            model.addRow(tk);
	        }

	        if (list.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Không có hóa đơn nào trong quý " + quy + " năm " + nam + "!");
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Năm không hợp lệ!");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
	    }
	}
}
