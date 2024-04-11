
package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
 
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import com.toedter.calendar.JDateChooser;

import Interface.InChiTietHoaDon;
import Interface.InHoaDon;
import Interface.InKhachHang;
import Interface.InNhanVien;
import Interface.InTour;
import bus.ChiTietHoaDon_BUS;
import bus.HoaDon_BUS;
import bus.KhachHang_BUS;
import bus.NhanVien_BUS;
import bus.Tour_BUS;
import connectDB.ConnectDB;
import cre.ChiTietHoaDon_CRE;
import cre.HoaDon_CRE;
import cre.NhanVien_CRE;
import dao.*;
import entity.HoaDon;
import entity.ChiTietHoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Tour;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Point;
import javax.swing.JTextField;
import javax.swing.JViewport;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Button;

public class DatTour extends JFrame {

	private JPanel contentPane;

	private JTextField txtTenNV;
	private JTextField txtTongTien;
	private JTextField txtTenKH;
	private JTextField txtMaHD;
	private JTextField txtSLKhach;
	private JTextField txtDiaChi;
	private JTextField txtGia;
	private JTextField txtTenTour;
	private JTextField txtMess;
	

	
	private InKhachHang khBus;
	private InNhanVien nvBus;
	private InTour tourBus;
	private InHoaDon hoaDonBus;
	private InChiTietHoaDon ctHoaDonBus;
 
 

	private HoaDon_CRE hdcre;
	private ChiTietHoaDon_CRE cthdcre;
	
	
	private ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
	private ArrayList<Tour> listTour = new ArrayList<Tour>();
	private ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
	private ArrayList<HoaDon> listHD = new ArrayList<HoaDon>();
	private ArrayList<ChiTietHoaDon> listCTHD = new ArrayList<ChiTietHoaDon>();
	private DefaultTableModel model;
	
	private JDateChooser cbNgayBan;
	
	private JComboBox cbMaKH;
	private JComboBox cbMaNV;
	private JComboBox cbMaTour;
	
	private Tour_BUS tour_bus;
	
	private DecimalFormat x = new DecimalFormat("###,###,###");
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatTour frame = new DatTour();
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
	public DatTour() throws RemoteException, SQLException {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 204, 204));
		setTitle("ĐẶT TOUR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 569);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
 
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		//Khởi tạo kết nối đến cơ sở dữ liệu:
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
			
		khBus = new KhachHang_BUS();
		nvBus = new NhanVien_BUS();
		tourBus = new Tour_BUS();
		hoaDonBus = new HoaDon_BUS();
		ctHoaDonBus = new ChiTietHoaDon_BUS();

		hdcre = new HoaDon_CRE();
		cthdcre = new ChiTietHoaDon_CRE();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(10, 76, 980, 475);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(SystemColor.textHighlight);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 10, 596, 164);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setForeground(SystemColor.textHighlight);
		lblMaNV.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaNV.setBounds(10, 10, 138, 23);
		panel_2.add(lblMaNV);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setForeground(SystemColor.textHighlight);
		lblTenNV.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTenNV.setBounds(10, 50, 97, 23);
		panel_2.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtTenNV.setEnabled(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(115, 50, 160, 25);
		txtTenNV.setDisabledTextColor(SystemColor.controlText); // Đặt màu chữ thành màu xám
		txtTenNV.setBackground(SystemColor.control);
		txtTenNV.setForeground(SystemColor.desktop);
		panel_2.add(txtTenNV);
		
		cbMaKH = new JComboBox();
		cbMaKH.setFont(new Font("Segoe UI", Font.BOLD, 11));
		cbMaKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = (String) cbMaKH.getSelectedItem();
				ArrayList<KhachHang> listKH = null;
				try {
					listKH = khBus.getkhachhangTheoMaKH(ma);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(KhachHang kh : listKH) {
					txtTenKH.setText(kh.getTenKH());
					txtDiaChi.setText(kh.getDiaChi());
				}
			}
		});
		cbMaKH.setToolTipText("");
		cbMaKH.setBounds(426, 10, 160, 25);
		panel_2.add(cbMaKH);
		
		//Đổ dữ liệu vào JComboBox MÃ KHÁCH HÀNG
		DefaultComboBoxModel<String> dataModelKH = new DefaultComboBoxModel<String>();
		dataModelKH.addElement("Chọn mã khách hàng");
		ArrayList<KhachHang> listKH = khBus.getallkhachhang();
		if(listKH != null) {
			for(KhachHang kh : listKH) {
				dataModelKH.addElement(kh.getMaKH());
			}
		}else {
			dataModelKH.addElement("Không có dữ liệu");
		}
		cbMaKH.setModel(dataModelKH);

		JLabel lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setForeground(SystemColor.textHighlight);
		lblMaKH.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaKH.setBounds(315, 10, 104, 23);
		panel_2.add(lblMaKH);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setForeground(SystemColor.textHighlight);
		lblTenKH.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTenKH.setBounds(315, 50, 110, 23);
		panel_2.add(lblTenKH);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setForeground(SystemColor.textHighlight);
		lblDiaChi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblDiaChi.setBounds(315, 90, 132, 23);
		panel_2.add(lblDiaChi);
		
		JLabel lblSLKhach = new JLabel("Số lượng khách");
		lblSLKhach.setForeground(SystemColor.textHighlight);
		lblSLKhach.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSLKhach.setBounds(315, 130, 110, 23);
		panel_2.add(lblSLKhach);
		
		
		cbMaNV = new JComboBox();
		cbMaNV.setFont(new Font("Segoe UI", Font.BOLD, 11));
		cbMaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = (String) cbMaNV.getSelectedItem();
				try {
					listNV = nvBus.getNhanVienTheoMaNV(ma);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(NhanVien nv : listNV) {
					txtTenNV.setText(nv.getTenNV());
				}
			}
		});
		cbMaNV.setToolTipText("");
		cbMaNV.setBounds(115, 10, 160, 25);
		panel_2.add(cbMaNV);
		
		//Đổ dữ liệu vào JComboBox MÃ NHÂN VIÊN
		DefaultComboBoxModel<String> dataModelNV = new DefaultComboBoxModel<String>();
		dataModelNV.addElement("Chọn mã nhân viên");
		ArrayList<NhanVien> listNV = nvBus.getallNhanVien();
		if(listNV != null) {
			for(NhanVien nv : listNV) {
				dataModelNV.addElement(nv.getMaNV());
			}
		}else {
			dataModelKH.addElement("Không có dữ liệu");
		}
		cbMaNV.setModel(dataModelNV);
		
		txtTenKH = new JTextField();
		txtTenKH.setEnabled(false);
		txtTenKH.setDisabledTextColor(SystemColor.controlText); // Đặt màu chữ thành màu xám
		txtTenKH.setBackground(SystemColor.control);
		txtTenKH.setForeground(SystemColor.desktop);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(426, 50, 160, 25);
	
		panel_2.add(txtTenKH);
		
		txtSLKhach = new JTextField();
		txtSLKhach.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				tinhTongTien();
			}
		});
		txtSLKhach.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tinhTongTien();
				}
			}
		});
		txtSLKhach.setColumns(10);
		txtSLKhach.setBounds(426, 130, 160, 25);
		panel_2.add(txtSLKhach);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEnabled(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(426, 90, 160, 25);
		txtDiaChi.setDisabledTextColor(SystemColor.controlText); // Đặt màu chữ thành màu xám
		txtDiaChi.setBackground(SystemColor.control);
		txtDiaChi.setForeground(SystemColor.desktop);
		panel_2.add(txtDiaChi);
		
		cbNgayBan = new JDateChooser() ;
		cbNgayBan.setBounds(115, 128, 160, 25);
		panel_2.add(cbNgayBan);
		cbNgayBan.setBackground(new Color(255, 255, 255));
		cbNgayBan.setDate(new java.util.Date());
		cbNgayBan.setEnabled(false);
		cbNgayBan.setToolTipText("");
		
		JLabel lblNgayBan = new JLabel("Ngày lập");
		lblNgayBan.setBounds(10, 128, 104, 23);
		panel_2.add(lblNgayBan);
		lblNgayBan.setForeground(SystemColor.textHighlight);
		lblNgayBan.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(115, 89, 160, 25);
		panel_2.add(txtMaHD);
		txtMaHD.setFont(new Font("Segoe UI", Font.BOLD, 10));
		txtMaHD.setBackground(new Color(255, 255, 255));
		txtMaHD.setEnabled(false);
		txtMaHD.setColumns(10);
		
		
		JLabel lblMaHD = new JLabel("Mã hóa đơn");
		lblMaHD.setBounds(10, 90, 91, 23);
		panel_2.add(lblMaHD);
		lblMaHD.setForeground(SystemColor.textHighlight);
		lblMaHD.setBackground(SystemColor.textHighlight);
		lblMaHD.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(608, 10, 348, 164);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		cbMaTour = new JComboBox();
		cbMaTour.setFont(new Font("Segoe UI", Font.BOLD, 11));
		cbMaTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = (String) cbMaTour.getSelectedItem();
				try {
					listTour = tourBus.getTourTheoMaTour(ma);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(Tour t : listTour) {
					txtTenTour.setText(t.getTenTour());
					txtGia.setText(Double.toString(t.getGiatien()));
					
					
				}
			}
		});
		cbMaTour.setToolTipText("");
		cbMaTour.setBounds(121, 10, 160, 25);
		panel_3.add(cbMaTour);

		//Đổ dữ liệu vào JComboBox MÃ TOUR
		DefaultComboBoxModel<String> dataModelTour = new DefaultComboBoxModel<String>();
		dataModelTour.addElement("Chọn mã tour");
		ArrayList<Tour> listTour = tourBus.getalltbTour();
		for(Tour t : listTour) {
			dataModelTour.addElement(t.getMaTour());
		}
		cbMaTour.setModel(dataModelTour);
		
		JLabel lblMaTour = new JLabel("Mã tour");
		lblMaTour.setForeground(SystemColor.textHighlight);
		lblMaTour.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaTour.setBounds(10, 10, 104, 23);
		panel_3.add(lblMaTour);
		
		JLabel lblTenTour = new JLabel("Tên tour");
		lblTenTour.setForeground(SystemColor.textHighlight);
		lblTenTour.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTenTour.setBounds(10, 50, 110, 23);
		panel_3.add(lblTenTour);
		
		JLabel lblGia = new JLabel("Đơn giá");
		lblGia.setForeground(SystemColor.textHighlight);
		lblGia.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblGia.setBounds(10, 90, 132, 23);
		panel_3.add(lblGia);
		
		JLabel lblTongTien = new JLabel("Tổng tiền");
		lblTongTien.setForeground(SystemColor.textHighlight);
		lblTongTien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTongTien.setBounds(10, 130, 97, 23);
		panel_3.add(lblTongTien);

	
		txtTongTien = new JTextField();
		txtTongTien.setEnabled(false);
		txtTongTien.setColumns(20);
		txtTongTien.setBounds(121, 130, 160, 25);
		panel_3.add(txtTongTien);
		
		txtGia = new JTextField();
		txtGia.setEnabled(false);
		txtGia.setColumns(10);
		txtGia.setBounds(121, 91, 160, 25);
		txtGia.setDisabledTextColor(SystemColor.controlText); // Đặt màu chữ thành màu xám
		txtGia.setBackground(SystemColor.control);
		txtGia.setForeground(SystemColor.desktop);
		panel_3.add(txtGia);
		
		txtTenTour = new JTextField();
		txtTenTour.setEnabled(false);
		txtTenTour.setColumns(10);
		txtTenTour.setBounds(121, 51, 160, 25);
		txtTenTour.setDisabledTextColor(SystemColor.controlText); // Đặt màu chữ thành màu xám
		txtTenTour.setBackground(SystemColor.control);
		txtTenTour.setForeground(SystemColor.desktop);
		panel_3.add(txtTenTour);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.menu);
		panel_5.setBounds(10, 219, 946, 200);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 946, 186);
		panel_5.add(scrollPane);
		
		table = new JTable();
		table.setModel(model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Tour", "S\u1ED1 L\u01B0\u1EE3ng Kh\u00E1ch", "\u0110\u01A1n Gi\u00E1", "Th\u00E0nh Ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnThem = new JButton("ĐẶT TOUR");
		btnThem.setSelectedIcon(null);
		btnThem.setForeground(SystemColor.text);
		btnThem.setBackground(SystemColor.textHighlight);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Kiểm tra biểu thức chính quy
				//Lấy dữ liệu từ JTextField,tạo 1 hóa đơn
				try {
					if(validData()) {
						HoaDon hd = getSelectedDataHDTable();
						ChiTietHoaDon cthd = getSelectedDataCTHDTable();
						//Lưu vào database
						int select = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đặt tour?","Chú Ý",JOptionPane.YES_NO_OPTION);
						if(select == JOptionPane.YES_OPTION) {
							try {
								hoaDonBus.create(hd);
								ctHoaDonBus.create(cthd);
								model.addRow(new Object[] {
										cthd.getMaHD().getMaHD(),cthd.getMaTour().getMaTour(),cthd.getSoLuongKhach(),cthd.getDonGia(),cthd.getThanhTien()
								} );
								JOptionPane.showMessageDialog(null, "Đặt tour thành công!");
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Đặt tour thất bại!");
								e2.printStackTrace();
							}
						}
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThem.setBounds(498, 184, 100, 25);
		panel_1.add(btnThem);
		
		JButton btnThoat = new JButton("THOÁT");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?","Cảnh Báo",JOptionPane.YES_NO_OPTION);
				if(select == JOptionPane.YES_OPTION) {
					TrangChu tc = null;
					try {
						tc = new TrangChu();
					} catch (RemoteException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tc.setVisible(true);
					dispose();
			}
		}
	});
		
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThoat.setBackground(new Color(255, 69, 0));
		btnThoat.setBounds(856, 184, 100, 25);
		panel_1.add(btnThoat);
		
		txtMess = new JTextField();
		txtMess.setForeground(Color.RED);
		txtMess.setFont(new Font("Arial", Font.BOLD, 13));
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setBounds(20, 175, 328, 18);
		panel_1.add(txtMess);
		txtMess.setColumns(10);
		
		JButton btnLamMoi = new JButton("LÀM MỚI");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbMaNV.setSelectedIndex(0);
				txtTenNV.setText("");
				cbMaKH.setSelectedIndex(0);
				txtTenKH.setText("");
				txtDiaChi.setText("");
				txtSLKhach.setText("");
				cbMaTour.setSelectedIndex(0);
				txtTenTour.setText("");
				txtGia.setText("");
				txtTongTien.setText("");
				
				cbMaNV.requestFocus();;
			}
		});
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnLamMoi.setBackground(SystemColor.textHighlight);
		btnLamMoi.setBounds(746, 184, 100, 25);
		panel_1.add(btnLamMoi);
		
		JButton btnThngKHa = new JButton("DANH SÁCH HÓA ĐƠN");
		btnThngKHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyHoaDon tk = null;
				try {
					tk = new QuanLyHoaDon();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tk.setVisible(true);
				dispose();
			}
		});
		btnThngKHa.setForeground(Color.WHITE);
		btnThngKHa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThngKHa.setBackground(new Color(60, 179, 113));
		btnThngKHa.setBounds(756, 429, 200, 25);
		panel_1.add(btnThngKHa);
		
		JButton btnHuyTour = new JButton("HỦY ĐẶT TOUR");
		btnHuyTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<KhachHang> ds = null;
				try {
					ds = khBus.getkhachhangTheoMaKH(cbMaKH.getSelectedItem().toString());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				int hoi = JOptionPane.showConfirmDialog(null, "Bạn có chắc hủy đặt ?", "Chú ý",
						JOptionPane.YES_NO_OPTION);

				if (hoi == JOptionPane.YES_OPTION) {
					for (KhachHang kh : ds) {
						try {
							khBus.delete(kh);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
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
			}
		});
		btnHuyTour.setForeground(Color.WHITE);
		btnHuyTour.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnHuyTour.setBackground(SystemColor.textHighlight);
		btnHuyTour.setBounds(608, 184, 128, 25);
		panel_1.add(btnHuyTour);
		
		JLabel lblNewLabel = new JLabel("ĐẶT TOUR");
		lblNewLabel.setBackground(new Color(0, 120, 215));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel.setBounds(10, 0, 966, 75);
		contentPane.add(lblNewLabel);
		
//		DocDuLieuTuSQLVaoTable();
		
	}


	protected HoaDon getSelectedDataHDTable() {
		String maHD = getMaHD();
		java.sql.Date ngayLap=  new java.sql.Date(cbNgayBan.getDate().getTime());
//		cbMaKH.setSelectedItem(getmaKHtoOder(null));
		
		String maKH = (String) cbMaKH.getSelectedItem();
		KhachHang kh = new KhachHang(maKH);
		String maNV = (String) cbMaNV.getSelectedItem();
		NhanVien nv = new NhanVien(maNV);
		
		double tongTien = Double.parseDouble(txtTongTien.getText());
		HoaDon hd = new HoaDon(maHD, ngayLap, kh, nv, tongTien);
		return hd;
	}
	
	protected ChiTietHoaDon getSelectedDataCTHDTable() {
		String maCTHD = getMaCTHD();
		String maHD = getMaHD();
		HoaDon hd = new HoaDon(maHD);
		String maTour = (String) cbMaTour.getSelectedItem();
		Tour t = new Tour(maTour);
		int soLuongKhach = Integer.parseInt(txtSLKhach.getText());
		double donGia = Double.parseDouble(txtGia.getText());
		double thanhTien = Double.parseDouble(txtTongTien.getText());
		
		ChiTietHoaDon cthd = new ChiTietHoaDon(maCTHD, hd, t, soLuongKhach, donGia, thanhTien);
		return cthd;
	}
	
	

	protected boolean validData() throws RemoteException, SQLException {
		String sl = txtSLKhach.getText().trim();
		if(!isJComboBoxNotEmpty(cbMaNV)) {
			showMessageCB("Vui lòng chọn mã nhân viên!", cbMaNV);
			return false;
		}
		
		if(!isJComboBoxNotEmpty(cbMaKH)) {
			showMessageCB("Vui lòng chọn mã khách hàng!", cbMaKH);
			return false;
		}
		
		
		
		if(!isJComboBoxNotEmpty(cbMaTour)) {
			showMessageCB("Vui lòng chọn mã tour!", cbMaTour);
			return false;
		}
		
		if(sl.length() > 0) {
			try {
				int SL = Integer.parseInt(sl);
				if(SL < 0) {
					showMessageTXT("Số lượng khách từ 1 trở lên", txtSLKhach);
					return false;
				}
				else {
					List<Tour> list = tourBus.getTourTheoMaTour(cbMaTour.getSelectedItem().toString());
					int slt = 0;
					for(Tour tour: list) {
						slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
				}
					if(SL >slt) {
						txtMess.setText("Hiện tại tour chỉ còn "+slt+" vé");
						return false;
					}
				}
					
			}catch (NumberFormatException e) {
				// TODO: handle exception
				showMessageTXT("Số lượng khách phải là số nguyên dương",txtSLKhach);
				return false;
			}
		}else {
			showMessageTXT("Vui lòng nhập số lượng khách sẽ tham gia tour", txtSLKhach);
			return false;
		}
		return true;
	}
	
	public boolean isJComboBoxNotEmpty(JComboBox comboBox) {
		 return comboBox.getSelectedIndex() != 0;
	}

//	private void DocDuLieuTuSQLVaoTable() {
//		ArrayList<HoaDon> listHD = hoaDonBus.getAllHoaDon();
//		for(HoaDon hd : listHD) {
//			model.addRow(new Object[] {hd.getMaHD(), hd.getNgayLap(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(), hd.getTongTien()});
//		}
//		
//	}

	private void tinhTongTien() {
		// TODO Auto-generated method stub
		try {
			int sl = Integer.parseInt(txtSLKhach.getText());
			double donGia = Double.parseDouble(txtGia.getText());
			double tongTien = donGia * sl;
			txtTongTien.setText(Double.toString(tongTien));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void showMessageCB(String message, JComboBox cb) {
		cb.requestFocus();
		txtMess.setText(message);
	}
	
	private  void showMessageTXT(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}
	private String getMaHD() {
		int maCuoi = Integer.parseInt(hdcre.getfivemacuoiHD());
		String maHD = "HD";
		String maCuoiHD = String.valueOf(maCuoi+1);
		int numZero = 3 - maCuoiHD.length();
		for (int i = 0; i < numZero; i++)
		{
			maHD += "0";
		}
		maHD += maCuoiHD;
		return maHD; 
	}
	
	private String getMaCTHD() {
		int maCuoi = Integer.parseInt(cthdcre.getfivemacuoiCTHD());
		String maCTHD = "CTHD";
		String maCuoiCTHD = String.valueOf(maCuoi+1);
		int numZero = 3 - maCuoiCTHD.length();
		for (int i = 0; i < numZero; i++)
		{
			maCTHD += "0";
		}
		maCTHD += maCuoiCTHD;
		return maCTHD; 
	}
	
	//-------------------------------------------------------------//
	public boolean getMaTourInTrangChu(String maTour) throws RemoteException {
		ArrayList<Tour> listTour = tourBus.getalltbTour();
		if(listTour != null) {
			for(Tour t : listTour) {
				if(t.getMaTour().equals(maTour)) {
					cbMaTour.setSelectedItem(t.getMaTour());
					return true;
				}
			}
		}
		return false;
	}
	public boolean getMaKHtoOder(String maKH) throws RemoteException {
		ArrayList<KhachHang> listKH = khBus.getallkhachhang();
		if(listKH != null) {
			for(KhachHang t : listKH) {
				if(t.getMaKH().equals(maKH)) {
					cbMaKH.setSelectedItem(t.getMaKH());
					return true;
				}
			}
		}
		return false;
	}
	
//	private void HuyTour() {
//		int row = table.getSelectedRow();
//		String mahd = table.getValueAt(row, 0).toString();
//		HoaDon hd = new HoaDon(mahd);
//		try {
//			int select = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn hủy đặt tour ?","Cảnh báo",JOptionPane.YES_NO_OPTION);
//			
//			if(select==JOptionPane.YES_NO_OPTION) {
//				hoaDonBus.delete(hd);
//				model.removeRow(row);
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			JOptionPane.showMessageDialog(null, "Xóa thất bại");
//		}
//	}
	public int getSLTTour(String ma) throws RemoteException, SQLException {
		ctHoaDonBus = new ChiTietHoaDon_BUS();
		return ctHoaDonBus.SLTourDaDat(ma);
	
	}
	
	public void showTongTien(String ma) throws RemoteException {
		ArrayList<entity.HoaDon> dshd = null;
		try {
			dshd = hoaDonBus.getHoaDonTheoMaHD(ma);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(entity.HoaDon hd : dshd) {
			DecimalFormat x = new DecimalFormat("###,###,###");
			txtTongTien.setText(x.format(hd.getTongTien()));
		}
	}
}
