package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import Interface.InKhachHang;
import Interface.InTour;
import bus.KhachHang_BUS;
import bus.Tour_BUS;
import connectDB.ConnectDB;
import cre.KhachHang_CRE;
import dao.KhachHang_DAO;
import dao.Tour_DAO;
import entity.Tour;
import entity.KhachHang;
import javax.swing.UIManager;

public class QuanLyKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtHoTen;
	private JTextField txtdiachi;
	private JTextField txtSDT;
	private JTextField txtemail;
	private JTextField txtCCCD;
	private JTable table;
	private DefaultTableModel modelkhachhang;
	private JDateChooser dateNgSinh;
//	private khachhang_dao kh_dao;
//	private tour_dao tour_dao;
	private InKhachHang kh_bus;
	private InTour tour_bus;
	private KhachHang_CRE kh_cre;
	private JTextField txtTimCCCD;
	private TableRowSorter<TableModel> sorter;
	private JTextField textTimTenKH;
	private static JLabel lblthongbao;
	private JTextField txtMaTourdangchon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKhachHang frame = new QuanLyKhachHang();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws RemoteException 
	 */
	public QuanLyKhachHang() throws RemoteException, SQLException {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
//		kh_dao = new khachhang_dao();
//		tour_dao = new tour_dao();
		kh_bus = new KhachHang_BUS();
		tour_bus = new Tour_BUS();
		kh_cre = new KhachHang_CRE();
		setTitle("QUẢN LÝ KHÁCH HÀNG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 700);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "TH\u00D4NG TIN KH\u00C1CH H\u00C0NG", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 72, 1000, 244);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.window);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(10, 21, 638, 202);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng  ");
		lblMaKH.setBounds(10, 15, 110, 25);
		panel_4.add(lblMaKH);
		lblMaKH.setForeground(SystemColor.textHighlight);
		lblMaKH.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(115, 15, 200, 25);
		panel_4.add(txtMaKH);
		txtMaKH.setColumns(10);
		txtMaKH.setEditable(false);
		
		JLabel lblHoTen = new JLabel("Họ tên ");
		lblHoTen.setBounds(10, 55, 110, 25);
		panel_4.add(lblHoTen);
		lblHoTen.setForeground(SystemColor.textHighlight);
		lblHoTen.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh ");
		lblNgaySinh.setBounds(10, 95, 110, 25);
		panel_4.add(lblNgaySinh);
		lblNgaySinh.setForeground(SystemColor.textHighlight);
		lblNgaySinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblDiaChi = new JLabel("Địa chỉ ");
		lblDiaChi.setBounds(10, 135, 110, 25);
		panel_4.add(lblDiaChi);
		lblDiaChi.setForeground(SystemColor.textHighlight);
		lblDiaChi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblSDT = new JLabel("Số điện thoại ");
		lblSDT.setBounds(330, 15, 110, 23);
		panel_4.add(lblSDT);
		lblSDT.setForeground(SystemColor.textHighlight);
		lblSDT.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblEmail = new JLabel("Email ");
		lblEmail.setBounds(330, 55, 82, 25);
		panel_4.add(lblEmail);
		lblEmail.setForeground(SystemColor.textHighlight);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(115, 55, 200, 25);
		panel_4.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtdiachi = new JTextField();
		txtdiachi.setBounds(115, 135, 200, 25);
		panel_4.add(txtdiachi);
		txtdiachi.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(425, 15, 200, 25);
		panel_4.add(txtSDT);
		txtSDT.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(425, 55, 200, 25);
		panel_4.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblCmndcccd = new JLabel("CMND/CCCD ");
		lblCmndcccd.setBounds(330, 95, 110, 25);
		panel_4.add(lblCmndcccd);
		lblCmndcccd.setForeground(SystemColor.textHighlight);
		lblCmndcccd.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		txtCCCD = new JTextField();
		txtCCCD.setBounds(425, 95, 200, 25);
		panel_4.add(txtCCCD);
		txtCCCD.setColumns(10);
		
		dateNgSinh = new JDateChooser();
		dateNgSinh.setBounds(115, 95, 200, 25);
		panel_4.add(dateNgSinh);
		
		 lblthongbao = new JLabel("");
		 lblthongbao.setHorizontalAlignment(SwingConstants.CENTER);
		lblthongbao.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 11));
		lblthongbao.setForeground(Color.RED);
		lblthongbao.setBounds(330, 166, 295, 25);
		panel_4.add(lblthongbao);
		
		JLabel lblMaTourdagchon = new JLabel("Mã Tour Đang Chọn");
		lblMaTourdagchon.setForeground(SystemColor.textHighlight);
		lblMaTourdagchon.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaTourdagchon.setBounds(330, 135, 143, 25);
		panel_4.add(lblMaTourdagchon);
		
		txtMaTourdangchon = new JTextField();
		txtMaTourdangchon.setBounds(469, 135, 156, 25);
		panel_4.add(txtMaTourdangchon);
		txtMaTourdangchon.setColumns(10);
		txtMaTourdangchon.setEditable(false);
		
//		ArrayList<Tour> listTour = tour_bus.getalltbTour();
//		for(Tour t:listTour) {
//			cbMaTour.addItem(t.getMaTour());
//		}
//		
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(SystemColor.text);
		btnThem.setBackground(SystemColor.textHighlight);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					themActiosn();
				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnThem.setBounds(658, 198, 100, 25);
		panel.add(btnThem);
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setForeground(SystemColor.text);
		btnXoaRong.setBackground(SystemColor.textHighlight);
		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaRong();
			}
		});
		btnXoaRong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnXoaRong.setBounds(658, 163, 100, 25);
		panel.add(btnXoaRong);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(SystemColor.text);
		btnXoa.setBackground(SystemColor.textHighlight);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xoa();
			}
		});
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnXoa.setBounds(775, 198, 100, 25);
		panel.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setForeground(SystemColor.text);
		btnSua.setBackground(SystemColor.textHighlight);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sua();
			}
		});
		btnSua.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnSua.setBounds(775, 163, 100, 25);
		panel.add(btnSua);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.window);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(658, 21, 332, 132);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		
//		ArrayList<khachhang> listkh = kh_bus.getallkhachhang();
		
		JButton btnTimCCCDvsSDT = new JButton("Tìm kiếm ");
		btnTimCCCDvsSDT.setBounds(123, 97, 103, 25);
		panel_3.add(btnTimCCCDvsSDT);
		btnTimCCCDvsSDT.setBackground(SystemColor.textHighlight);
		btnTimCCCDvsSDT.setForeground(SystemColor.text);
		btnTimCCCDvsSDT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Tim();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTimCCCDvsSDT.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblNewLabel_1 = new JLabel("Nhập tên ");
		lblNewLabel_1.setBounds(10, 55, 120, 23);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		txtTimCCCD = new JTextField();
		txtTimCCCD.setBounds(140, 15, 180, 25);
		panel_3.add(txtTimCCCD);
		txtTimCCCD.setColumns(10);
		
		JLabel lblTmKhchHng = new JLabel("Nhập CMND/CCCD");
		lblTmKhchHng.setBounds(10, 15, 120, 23);
		panel_3.add(lblTmKhchHng);
		lblTmKhchHng.setForeground(SystemColor.textHighlight);
		lblTmKhchHng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		textTimTenKH = new JTextField();
		textTimTenKH.setBounds(140, 55, 180, 25);
		panel_3.add(textTimTenKH);
		textTimTenKH.setColumns(10);
		
		JButton btnNewButton = new JButton("Danh Sách");
		btnNewButton.setBounds(890, 163, 100, 25);
		panel.add(btnNewButton);
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoahetDuLieutrenTable();
				try {
					DocDuLieutrenSQL();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(890, 198, 100, 25);
		panel.add(btnThoat);
		btnThoat.setBackground(new Color(255, 69, 0));
		btnThoat.setForeground(SystemColor.text);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu tc = null;
				try {
					tc = new TrangChu();
				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tc.setVisible(true);
				setVisible(false);
			}
		});
		btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.scrollbar);
		panel_1.setBorder(null);
		panel_1.setBounds(10, 0, 1000, 75);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblTitle.setForeground(SystemColor.window);
		lblTitle.setBackground(new Color(0, 153, 255));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblTitle.setBounds(0, 0, 1000, 75);
		panel_1.add(lblTitle);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DANH S\u00C1CH KH\u00C1CH H\u00C0NG", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 315, 1000, 373);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 20, 980, 338);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaKH.setText(table.getValueAt(row, 0).toString());
				txtHoTen.setText(table.getValueAt(row, 1).toString());

			try {
				dateNgSinh.setDate((Date)table.getValueAt(row, 2));
			} catch (Exception e2) {
				
				 String dateString = table.getValueAt(row, 2).toString();
//				    SimpleDateFormat inputFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss");
//				    SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
				    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
				    try {
//				        java.util.Date date = inputFormat.parse(dateString);
//				        String formattedDate = outputFormat.format(date);
//				        dateNgSinh.setDate(outputFormat.parse(formattedDate));
				    	java.util.Date utilDate = outputFormat.parse(dateString);
				    	java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
				    	dateNgSinh.setDate(sqldate);
				    	
				    } catch (ParseException e1) {
				        // Handle the exception
				    }
				

			}	
				
				txtdiachi.setText(table.getValueAt(row, 3).toString());
				txtSDT.setText(table.getValueAt(row, 4).toString());
				txtCCCD.setText(table.getValueAt(row, 6).toString());
				txtemail.setText(table.getValueAt(row, 5).toString());
//				cbMaTour.setSelectedItem(table.getValueAt(row, 7));
				
			}
		});
		table.setModel(modelkhachhang = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Kh\u00E1ch h\u00E0ng", "T\u00EAn Kh\u00E1ch H\u00E0ng", "Ng\u00E0y sinh", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email", "CMND/CCCD"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(88);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		DocDuLieutrenSQL();
	}
	private void themActiosn() throws RemoteException, SQLException {
			if(txtMaKH.getText().equals("")) {
				if(Invalid()) {
					
					
					String maKH = maKH();
					String tenKH = txtHoTen.getText();
					java.util.Date ngaysinh = dateNgSinh.getDate();
					java.sql.Date ngsinh=  new java.sql.Date(ngaysinh.getTime());
					String diachi =  txtdiachi.getText();
					String sdt= txtSDT.getText();
					
					String email = txtemail.getText();
					String cccd= (txtCCCD.getText());
					KhachHang kh = new KhachHang(maKH,tenKH,ngsinh,diachi,sdt,email,cccd);
					
					
					try {
						kh_bus.create(kh);
						String []datarow= {kh.getMaKH(),kh.getTenKH(),kh.getNgaySinh().toLocalDate().toString(),kh.getDiaChi(),kh.getSdt(),kh.getEmail(),kh.getCmnd()};
						modelkhachhang.addRow(datarow);
						lblthongbao.setText("Thêm Thành Công !");
						XoaRong();
						DatTour dt= new DatTour() ;		
						dt.getMaTourInTrangChu(txtMaTourdangchon.getText());
						dt.setVisible(true);
						dt.getMaKHtoOder(maKH);
						setVisible(false);
					} catch (Exception e) {
						// TODO: handle exception
//						JOptionPane.showMessageDialog(null, "Trùng mã");
						lblthongbao.setText("Trùng mã");
					}	
				}
			}
			else {
				DatTour dt= new DatTour() ;		
				dt.getMaTourInTrangChu(txtMaTourdangchon.getText());
				dt.setVisible(true);
				dt.getMaKHtoOder(txtMaKH.getText());
				setVisible(false);
			}
			
			
		
	}
	private void XoaRong() {
		txtMaKH.setText("");
		txtHoTen.setText("");
//		txtNgaySinh.setText("");
		dateNgSinh.setDate(null);
		txtdiachi.setText("");
		txtSDT.setText("");
		txtCCCD.setText("");
		txtemail.setText("");
		txtTimCCCD.setText("");
		textTimTenKH.setText("");
		lblthongbao.setText("");

	}
	private void XoahetDuLieutrenTable() {
		DefaultTableModel md = (DefaultTableModel)table.getModel();
		md.getDataVector().removeAllElements();
		
	}
	private void DocDuLieutrenSQL() throws RemoteException {
		List<KhachHang> list = kh_bus.getallkhachhang();
		if(modelkhachhang==null) {
			JOptionPane.showMessageDialog(null, "modelkhachhang không tồn tại");
			return;
		}
		sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		for(KhachHang kh:list) {
			modelkhachhang.addRow(new Object[] {kh.getMaKH(),kh.getTenKH(),kh.getNgaySinh(),kh.getDiaChi(),kh.getSdt(),kh.getEmail(),kh.getCmnd()});
		}
		
	}
	private void Xoa() {
		int row;
		 String makh =null ;
		try {
			 row = table.getSelectedRow();
			  makh = table.getValueAt(row, 0).toString();
			  KhachHang kh = new KhachHang(makh);
				try {
					int hoi = JOptionPane.showConfirmDialog(this,"Bạn chăc chắn Xóa ?","Chú ý",JOptionPane.YES_NO_OPTION);
					
					if(hoi==JOptionPane.YES_NO_OPTION) {
						kh_bus.delete(kh);
						modelkhachhang.removeRow(row);
						XoaRong();
					}
					
				} catch (Exception e) {
					// TODO: handle exception
//					JOptionPane.showMessageDialog(null, "Xóa thất bại");
					lblthongbao.setText("Xóa thất bại");
				}
		} catch (Exception e) {
			// TODO: handle exception
			lblthongbao.setText("Chưa chọn dữ liệu để xóa");
			
		}
		
		
		
		
	}
	
	private void Sua() {
		try {
			if(Invalid()) {
				String maKH = txtMaKH.getText();
				
				String tenKH = txtHoTen.getText();
				java.sql.Date ngaysinh=  new java.sql.Date(dateNgSinh.getDate().getTime());
				String diachi =  txtdiachi.getText();
				String sdt= txtSDT.getText();
				String email = txtemail.getText();
				String cccd= (txtCCCD.getText());

				
//				Tour tour = new Tour(maTour);
				KhachHang kh = new KhachHang(maKH,tenKH,ngaysinh,diachi,sdt,email,cccd);
				try {
					if(kh_bus.update(kh)) {
//						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
						lblthongbao.setText("Cập nhật thành công");
						XoahetDuLieutrenTable();
						DocDuLieutrenSQL();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			lblthongbao.setText("Chưa chọn dữ liệu cập nhật");
		}
	}
	
	private void Tim() throws RemoteException {
		try {

//			String CCCDTim = txtTimCCCD.getText();
			String sdtTim = textTimTenKH.getText();
			if(sdtTim.equals("")) {
				JOptionPane.showMessageDialog(null, " Vui lòng nhập tên ");
//				lblthongbao.setText("Vui lòng nhập CCCD hoặc số điện thoại ");
				return;
			}
			
			else {
//			List<KhachHang> listkhtheocmnd = null;
//			listkhtheocmnd = kh_bus.getkhachhangTheoCCCD(CCCDTim);

			List<KhachHang> listkhtheosdt = null;
			listkhtheosdt = kh_bus.timKhachHangTheoChuoi(sdtTim);
			
//			if(!listkhtheocmnd.isEmpty()) {
//				XoahetDuLieutrenTable();
//			for(KhachHang kh :listkhtheocmnd) {
//				modelkhachhang.addRow(new Object[] {kh.getMaKH(),kh.getTenKH(),kh.getNgaySinh(),kh.getDiaChi(),kh.getSdt(),kh.getEmail(),kh.getCmnd()});
//			}
//			
//			}
			if( !listkhtheosdt.isEmpty()){
				XoahetDuLieutrenTable();
				for(KhachHang kh :listkhtheosdt) {
					modelkhachhang.addRow(new Object[] {kh.getMaKH(),kh.getTenKH(),kh.getNgaySinh(),kh.getDiaChi(),kh.getSdt(),kh.getEmail(),kh.getCmnd()});
				}
			}
			else {
				JOptionPane.showMessageDialog(null, " Không có ");
			}
//			if(listkhtheocmnd.isEmpty() && listkhtheosdt.isEmpty()) {
////				JOptionPane.showMessageDialog(null,"Không tìm thấy ");
//				lblthongbao.setText("Không tìm thấy ");
//			}
			}
//			DocDuLieutrenSQL();
		} catch (Exception e) {
			// TODO: handle exception
//			JOptionPane.showMessageDialog(null, "Lỗi");
			DocDuLieutrenSQL();
		}
	}
	
	private String maKH() {
		int macuoi = Integer.parseInt(kh_cre.getfivemacuoiKH());
		String maKH = "KH";
		String macuoiKH = String.valueOf(macuoi+1);
		int numZeroes = 3- macuoiKH.length();
		for(int i=0;i<numZeroes;i++) {
			maKH +="0";
		}
		maKH +=macuoiKH;
		
		return maKH;
	}
	
	private boolean Invalid() throws RemoteException {
		String tenKH = txtHoTen.getText();
	
		String diachi =  txtdiachi.getText();
		String sdt= txtSDT.getText();
		String email = txtemail.getText();
		String cccd= (txtCCCD.getText());
		lblthongbao.setText("");
		
		if(tenKH.equals("")) {
//			JOptionPane.showMessageDialog(null, "Tên không được để rỗng");
			lblthongbao.setText("Tên không được để rỗng");
			return false;
		}
		if(!(tenKH.length() >0 && tenKH.matches("^[\\p{L}' ]+$"))) {
//			JOptionPane.showMessageDialog(null, "Tên nhập không có số và kí tự đặc biệt");
			lblthongbao.setText("Tên nhập không có số và kí tự đặc biệt");
			txtHoTen.selectAll();
			txtHoTen.requestFocus();
			return false;
		}

		
		
		try {
			java.sql.Date ngaysinh=  new java.sql.Date(dateNgSinh.getDate().getTime());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -18);
			java.util.Date tuoi18 = new java.sql.Date(cal.getTimeInMillis());
			if(!(ngaysinh.before(tuoi18))) {
//				JOptionPane.showMessageDialog(null, "Khách hàng chưa đủ 18 tuổi");
				lblthongbao.setText("Khách hàng chưa đủ 18 tuổi");
				return false;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
//			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống");
			lblthongbao.setText("Ngày sinh không được để trống");
			return false;
		}
		if(diachi.equals("")) {
//			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống");
			lblthongbao.setText("Địa chỉ không được để trống");
			return false;
		}
		if(!(diachi.length() >0 && diachi.matches("^[\\p{L}'0-9 ]+$"))) {
//			JOptionPane.showMessageDialog(null, "Địa chỉ không có kí tự đặc biệt");
			lblthongbao.setText("Địa chỉ không có kí tự đặc biệt");
			txtdiachi.selectAll();
			txtdiachi.requestFocus();
			return false;
		}
		
		if(sdt.equals("")) {
//			JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống");
			lblthongbao.setText("Số điện thoại không được để trống");
			return false;
		}
		if(!(sdt.length() >0 && sdt.matches("^(03|09|05|07|08)[0-9]{8}$"))) {
//			JOptionPane.showMessageDialog(null, "Số điện thoại có đầu là (03|09|05|07|08) và cuối là 8 số");
			lblthongbao.setText("Số điện thoại có đầu là (03|09|05|07|08) và cuối là 8 số");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		else {
			ArrayList<KhachHang> list = kh_bus.getallkhachhang();
			for(KhachHang kh : list) {
				if(kh.getSdt().equals(txtSDT.getText())) {
					lblthongbao.setText("Khách hàng đã tồn tại!");
					if(txtMaKH.getText().equals("")) {
					return false;
					}
					else return true;
				}
			}
		}

		if(email.equals("")) {
//			JOptionPane.showMessageDialog(null, "Email không được để trống");
			lblthongbao.setText("Email không được để trống");
			return false;
		}
		if(!(email.length() >0 && email.matches("^[a-z0-9*-+!]+(@gmail.com)$"))) {
//			JOptionPane.showMessageDialog(null, "Email nhập theo mẫu abc123@gmail.com");
			lblthongbao.setText("Email nhập theo mẫu abc123@gmail.com");
			txtemail.selectAll();
			txtemail.requestFocus();
			return false;
		}
		else {
			ArrayList<KhachHang> list = kh_bus.getallkhachhang();
			for(KhachHang kh : list) {
				if(kh.getEmail().equals(txtemail.getText())) {
					lblthongbao.setText("Khách hàng đã tồn tại!");
					if(txtMaKH.getText().equals("")) {
					return false;
					}
					else return true;
				}
			}
		}

		if(cccd.equals("")) {
//			JOptionPane.showMessageDialog(null, "CMND/CCCD không được để trống");
			lblthongbao.setText("CMND/CCCD không được để trống");
			return false;
		}
		if(!(cccd.length() >0 && cccd.matches("^(((0[1-9]||1[0-9]||2[0-9]||3[0-8])(\\d{7}))||((0)[0-9]{11}))$"))) 
//		if(!(cccd.length() >0 && cccd.matches("^((0[1-9]|1[0-9]|2[1-4])|(2[2-9]|3[1-9]|4[1-9]|5[1-2])|(6[0-9]|7[1-9]|8[1-9]|9[1-6]))\\d{3}(([0-9]{6})|([0-9]{9}))$")))
		{
//			JOptionPane.showMessageDialog(null, "CMND /CCCD 9 hoặc 12 số ");
			lblthongbao.setText("CMND /CCCD 9 hoặc 12 số và chưa đúng định dạng");
			txtCCCD.selectAll();
			txtCCCD.requestFocus();
			return false;
		}
		else {
			ArrayList<KhachHang> list = kh_bus.getallkhachhang();
			for(KhachHang kh : list) {
				if(kh.getCmnd().equals(txtCCCD.getText())) {
					lblthongbao.setText("Khách hàng đã tồn tại!");
					if(txtMaKH.getText().equals("")) {
					return false;
					}
					else return true;
				}
			}
		}
		
		return true;
	}
	
	public boolean getMaTourInTrangChu(String maTour) {
		txtMaTourdangchon.setText(maTour);
		return false;
	}
}
