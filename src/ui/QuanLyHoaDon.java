package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import bus.HoaDon_BUS;
import connectDB.ConnectDB;
import entity.HoaDon;


import javax.swing.border.EtchedBorder;


//import gui.FrmManHinhChinh;
//import model.ChiTietHoaDon;
//import model.HoaDon;

public class QuanLyHoaDon extends JFrame implements MouseListener {

	public static JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTenKH;
	private JTextField txtNVLap;
	private JTextField txtTongTien;
	private DefaultTableModel tblModelHoaDon = new DefaultTableModel();
	private DefaultTableModel tblModelChiTiet = new DefaultTableModel();
	private HoaDon_BUS hoaDonBus = new HoaDon_BUS();
	private JTextField txtNgayLap;
	private JComboBox cmbTim;
	private JRadioButton radMaHD,radMaKH,radMaNV,radNgayLap;
	
	
	private DefaultComboBoxModel cboModelma= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModelMaKH = new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModelMaNV = new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModelNgayLap= new DefaultComboBoxModel();
	
	private List<String> listMaKH = new ArrayList<String>();
	private List<String> listMaNV = new ArrayList<String>();
	private List<String> listma = new ArrayList<String>();
	private List<Date> listNgayLap = new ArrayList<Date>();
	
	private JTable table;
	private DefaultTableModel model;
	private JTable tableHoaDon;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyHoaDon frame = new QuanLyHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyHoaDon() {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	setIconImage(Toolkit.getDefaultToolkit()
	.getImage("Hinh\\pm.png"));
	setType(Type.POPUP);
	setResizable(false);
	setForeground(SystemColor.scrollbar);
	setBackground(new Color(176, 224, 230));
	setTitle("Phần mềm quản lý nhà thuốc Tây Nam");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1092, 715);
	contentPane = new JPanel();
	contentPane.setForeground(SystemColor.scrollbar);
	contentPane.setBackground(SystemColor.scrollbar);
	contentPane.setBorder(null);
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	setUndecorated(true);
	
	JPanel pnlThongTinHD = new JPanel();
	pnlThongTinHD.setBackground(SystemColor.window);
	pnlThongTinHD.setBorder(
			new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEFT, TitledBorder.TOP, null, SystemColor.textHighlight));
	pnlThongTinHD.setBounds(10, 75, 505, 208);
	contentPane.add(pnlThongTinHD);
	pnlThongTinHD.setLayout(null);

	JLabel lblMHan = new JLabel("Mã Hóa Đơn");
	lblMHan.setForeground(SystemColor.textHighlight);
	lblMHan.setFont(new Font("Segoe UI", Font.BOLD, 13));
	lblMHan.setBounds(10, 20, 122, 30);
	pnlThongTinHD.add(lblMHan);

	txtMa = new JTextField();
	txtMa.setEnabled(false);
	txtMa.setBounds(140, 20, 323, 30);
	pnlThongTinHD.add(txtMa);
	txtMa.setColumns(10);

	JLabel lblTnKhchHng = new JLabel("Khách Hàng");
	lblTnKhchHng.setForeground(SystemColor.textHighlight);
	lblTnKhchHng.setFont(new Font("Segoe UI", Font.BOLD, 13));
	lblTnKhchHng.setBounds(10, 125, 147, 30);
	pnlThongTinHD.add(lblTnKhchHng);

	txtTenKH = new JTextField();
	txtTenKH.setBounds(140, 125, 323, 30);
	pnlThongTinHD.add(txtTenKH);
	txtTenKH.setColumns(10);

	JLabel lblNhanVien = new JLabel("Nhân Viên ");
	lblNhanVien.setForeground(SystemColor.textHighlight);
	lblNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
	lblNhanVien.setBounds(10, 90, 122, 30);
	pnlThongTinHD.add(lblNhanVien);

	txtNVLap = new JTextField();
	txtNVLap.setBounds(140, 90, 324, 30);
	pnlThongTinHD.add(txtNVLap);
	txtNVLap.setColumns(10);

	JLabel lblNgayLap = new JLabel("Ngày Lập");
	lblNgayLap.setForeground(SystemColor.textHighlight);
	lblNgayLap.setFont(new Font("Segoe UI", Font.BOLD, 13));
	lblNgayLap.setBounds(10, 55, 100, 30);
	pnlThongTinHD.add(lblNgayLap);
	
	JLabel lblTongtien = new JLabel("Tổng Tiền");
	lblTongtien.setForeground(SystemColor.textHighlight);
	lblTongtien.setFont(new Font("Segoe UI", Font.BOLD, 13));
	lblTongtien.setBounds(10, 160, 100, 30);
	pnlThongTinHD.add(lblTongtien);
	
	txtTongTien = new JTextField();
	txtTongTien.setColumns(10);
	txtTongTien.setBounds(140, 160, 323, 30);
	pnlThongTinHD.add(txtTongTien);
	
	txtNgayLap = new JTextField();
	txtNgayLap.setColumns(10);
	txtNgayLap.setBounds(140, 55, 323, 30);
	pnlThongTinHD.add(txtNgayLap);
	ImageIcon iconAdd = new ImageIcon("Hinh/add.png");
	ImageIcon iconDelete = new ImageIcon("Hinh/delete.png");
	ImageIcon iconUpdate = new ImageIcon("Hinh/update.png");
	ImageIcon iconSearch = new ImageIcon("Hinh/search.png");
	ImageIcon iconSave = new ImageIcon("Hinh/save.png");
	ImageIcon iconExit = new ImageIcon("Hinh/exit.png");
	ImageIcon iconExcel = new ImageIcon("Hinh/excel.png");
	ImageIcon iconThoat = new ImageIcon("Hinh/exit.png");

	JPanel pnlTitle = new JPanel();
	pnlTitle.setBorder(null);
	pnlTitle.setBackground(SystemColor.scrollbar);
	pnlTitle.setBounds(0, 0, 1082, 70);
	contentPane.add(pnlTitle);
	pnlTitle.setLayout(null);

	JLabel lblQunLNhn = new JLabel("QUẢN LÝ HÓA ĐƠN");
	lblQunLNhn.setBackground(SystemColor.controlHighlight);
	lblQunLNhn.setForeground(Color.WHITE);
	lblQunLNhn.setHorizontalAlignment(SwingConstants.CENTER);
	lblQunLNhn.setFont(new Font("Segoe UI", Font.BOLD, 35));
	lblQunLNhn.setBounds(0, 0, 1070, 70);
	pnlTitle.add(lblQunLNhn);

	JPanel pnlHoaDon = new JPanel();
	pnlHoaDon.setLayout(null);
	pnlHoaDon.setForeground(Color.BLACK);
	pnlHoaDon.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
	pnlHoaDon.setBackground(SystemColor.menu);
	pnlHoaDon.setBounds(10, 290, 1068, 378);
	contentPane.add(pnlHoaDon);

	JScrollPane scrHoaDon = new JScrollPane();
	JViewport viewport = scrHoaDon.getViewport();
	viewport.setBackground(Color.WHITE);
	scrHoaDon.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrHoaDon.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrHoaDon.setBounds(12, 22, 1046, 346);
	pnlHoaDon.add(scrHoaDon);
	
	tableHoaDon = new JTable();
	tableHoaDon.setModel(model = new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp", "T\u00EAn kh\u00E1ch h\u00E0ng", "T\u00EAn nh\u00E2n vi\u00EAn", "T\u1ED5ng ti\u1EC1n"
		}
	));
	scrHoaDon.setViewportView(tableHoaDon);
	
	tableHoaDon.addMouseListener(this);
	
	JPanel pnlTimKiem = new JPanel();
	pnlTimKiem.setLayout(null);
	pnlTimKiem.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
	pnlTimKiem.setBackground(SystemColor.window);
	pnlTimKiem.setBounds(518, 75, 560, 208);
	contentPane.add(pnlTimKiem);
	
	JButton btnTimKiem = new JButton("Tìm kiếm");
	btnTimKiem.setBackground(new Color(60, 179, 113));
	btnTimKiem.setForeground(SystemColor.window);
	btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 13));
	btnTimKiem.setBounds(401, 20, 130, 30);
	pnlTimKiem.add(btnTimKiem);
	
	JLabel lblNhpThngTin = new JLabel("Nhập thông tin tìm kiếm");
	lblNhpThngTin.setForeground(SystemColor.textHighlight);
	lblNhpThngTin.setFont(new Font("Segoe UI", Font.BOLD, 13));
	lblNhpThngTin.setBounds(10, 20, 162, 30);
	pnlTimKiem.add(lblNhpThngTin);
	
	JLabel lblTmTheo = new JLabel("Tìm theo");
	lblTmTheo.setForeground(SystemColor.textHighlight);
	lblTmTheo.setFont(new Font("Segoe UI", Font.BOLD, 13));
	lblTmTheo.setBounds(10, 70, 63, 30);
	pnlTimKiem.add(lblTmTheo);
	
	radMaKH= new JRadioButton("Mã Khách Hàng ");
	radMaKH.setBackground(SystemColor.control);
	radMaKH.setHorizontalAlignment(SwingConstants.CENTER);
	radMaKH.setFont(new Font("Segoe UI", Font.BOLD, 13));
	radMaKH.setBounds(401, 70, 130, 30);
	pnlTimKiem.add(radMaKH);
	
	radNgayLap = new JRadioButton("Ngày lập");
	radNgayLap.setFont(new Font("Segoe UI", Font.BOLD, 13));
	radNgayLap.setBounds(401, 120, 130, 30);
	pnlTimKiem.add(radNgayLap);
	
	radMaHD = new JRadioButton("Mã Hóa Đơn");
	radMaHD.setSelected(true);
	radMaHD.setFont(new Font("Segoe UI", Font.BOLD, 13));
	radMaHD.setBounds(184, 70, 130, 30);
	pnlTimKiem.add(radMaHD);
	
	radMaNV = new JRadioButton("Mã nhân viên");
	radMaNV.setFont(new Font("Segoe UI", Font.BOLD, 13));
	radMaNV.setBounds(184, 120, 130, 30);
	pnlTimKiem.add(radMaNV);
	
	ButtonGroup group = new ButtonGroup();
	group.add(radMaHD);
	group.add(radNgayLap);
	group.add(radMaNV);
	group.add(radMaKH);
	
	cmbTim = new JComboBox();
	cmbTim.setBounds(184, 20, 130, 30);
	pnlTimKiem.add(cmbTim);
	
	JButton btnLamMoi = new JButton("Làm mới");
	btnLamMoi.setForeground(SystemColor.window);
	btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 13));
	btnLamMoi.setBackground(SystemColor.textHighlight);
	btnLamMoi.setBounds(184, 168, 130, 30);
	pnlTimKiem.add(btnLamMoi);
	
	JButton btnThoat = new JButton("Thoát");
	btnThoat.setForeground(SystemColor.textHighlightText);
	btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
	btnThoat.setBackground(new Color(255, 99, 71));
	btnThoat.setBounds(401, 168, 130, 30);
	pnlTimKiem.add(btnThoat);
	
	JButton btnXemHD = new JButton("XEM CHI TIẾT HÓA ĐƠN");
	btnXemHD.setForeground(Color.WHITE);
	btnXemHD.setFont(new Font("Segoe UI", Font.BOLD, 13));
	btnXemHD.setBackground(SystemColor.textHighlight);
	btnXemHD.setBounds(880, 678, 200, 25);
	contentPane.add(btnXemHD);
	btnXemHD.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int row = tableHoaDon.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn hóa đơn nào.");
                return;
            }
            String maHoaDon = tableHoaDon.getValueAt(row, 0).toString();

            // Hiển thị hóa đơn chi tiết
            ui.ChiTietHoaDon ct = new ui.ChiTietHoaDon();
            ct.frame.setVisible(true);
            ct.HienTableTheoMaHD(maHoaDon);
            ct.showTongTien(maHoaDon);
//            setVisible(false);
		}
	});
	DocDuLieuTuSQLVaoTable();	
	
	btnThoat.addActionListener(new ActionListener() {	
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int select = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?","Cảnh Báo",JOptionPane.YES_NO_OPTION);
			if(select == JOptionPane.YES_OPTION) {
				DatTour tc = new DatTour();
				tc.setVisible(true);
				dispose();
				
		}
		}
		});
	btnLamMoi.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			lamMoi();
			DocDuLieuTuSQLVaoTable();;
		}
	});
	btnTimKiem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			TimKiem();
		}
	});
//	btnThoat.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			FrmManHinhChinh.tabbedPane.remove(contentPane);
//		}
//	});
	
	radMaHD.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cmbTim.setModel(cboModelma);
		}
	});
	radMaKH.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cmbTim.setModel(cboModelMaKH);
		}
	});
	radMaNV.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cmbTim.setModel(cboModelMaNV);
		}
	});
	radNgayLap.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cmbTim.setModel(cboModelNgayLap);
		}
	});
	docDuLieuCmb();

}
	
	

	

	public void DocDuLieuTuSQLVaoTable() {
		ArrayList<HoaDon> listHD = hoaDonBus.getAllHoaDon();
		for(HoaDon hd : listHD) {
			String nhanVien= hoaDonBus.getTenNV(hd.getNhanVien().getMaNV());
			String khachHang= hoaDonBus.getTenKH(hd.getKhachHang().getMaKH());
			model.addRow(new Object[] {hd.getMaHD(), hd.getNgayLap(), khachHang, nhanVien, hd.getTongTien()});
		}
	}
	
	/**
	 * Dùng đọc dữ liệu từ cơ sở dữ liệu lên bảng
	 */
	public void docDuLieuCmb() {
		
		List<HoaDon> list = hoaDonBus.getAllHoaDon();
		for(HoaDon x : list) {
//			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			String maNV = x.getNhanVien().getMaNV();
			String maKH = x.getKhachHang().getMaKH();
			if(listMaKH.contains(maKH)==false) {
				cboModelMaKH.addElement(maKH);	
				listMaKH.add(maKH);
			}
			if(listMaNV.contains(maNV)==false) {
				cboModelMaNV.addElement(maNV);	
				listMaNV.add(maNV);
			}
			if(listma.contains(x.getMaHD())==false) {
				cboModelma.addElement(x.getMaHD());	
				listma.add(x.getMaHD());
			}
			if(listNgayLap.contains(x.getNgayLap())==false) {
				cboModelNgayLap.addElement(x.getNgayLap());	
				listNgayLap.add((Date) x.getNgayLap());
			}
		}
	}
	
	
	public void TimKiem() {
		if(radMaHD.isSelected()) {
		
			String ma= cmbTim.getSelectedItem().toString();
			List<HoaDon> hds = hoaDonBus.getHoaDonTheoMaHD(ma);
			lamMoi();
			for(HoaDon hd: hds) {
				String nhanVien= hoaDonBus.getTenNV(hd.getNhanVien().getMaNV());
				String khachHang= hoaDonBus.getTenKH(hd.getKhachHang().getMaKH());
				model.addRow(new Object[] {hd.getMaHD(), hd.getNgayLap(), khachHang, nhanVien, hd.getTongTien()});
			}
		}
		if(radMaKH.isSelected()) {
			
			String ma= cmbTim.getSelectedItem().toString();
			List<HoaDon> hds= hoaDonBus.getHoaDonsByKhachHang(ma);
			lamMoi();
			for(HoaDon hd: hds) {
				String nhanVien= hoaDonBus.getTenNV(hd.getNhanVien().getMaNV());
				String khachHang= hoaDonBus.getTenKH(hd.getKhachHang().getMaKH());
				model.addRow(new Object[] {hd.getMaHD(), hd.getNgayLap(), khachHang, nhanVien, hd.getTongTien()});
			}
			
		}
		if(radMaNV.isSelected()) {
			
			String ma= cmbTim.getSelectedItem().toString();
			List<HoaDon> hds= hoaDonBus.getHoaDonsByNhanVien(ma);
			lamMoi();
			for(HoaDon hd: hds) {
				String nhanVien= hoaDonBus.getTenNV(hd.getNhanVien().getMaNV());
				String khachHang= hoaDonBus.getTenKH(hd.getKhachHang().getMaKH());
				model.addRow(new Object[] {hd.getMaHD(), hd.getNgayLap(), khachHang, nhanVien, hd.getTongTien()});
			}
		}
		if(radNgayLap.isSelected()) {
			String nl= cmbTim.getSelectedItem().toString();
			List<HoaDon> hds= hoaDonBus.getHoaDonTheoNgayLap(nl);
			lamMoi();
			for(HoaDon hd: hds) {
				String nhanVien= hoaDonBus.getTenNV(hd.getNhanVien().getMaNV());
				String khachHang= hoaDonBus.getTenKH(hd.getKhachHang().getMaKH());
				model.addRow(new Object[] {hd.getMaHD(), hd.getNgayLap(), khachHang, nhanVien, hd.getTongTien()});
			}
		}
	}
	
	public void lamMoi() {
		txtMa.setText("");
		txtNgayLap.setText("");
		txtNVLap.setText("");
		txtTenKH.setText("");
		txtTongTien.setText("");
	
		xoaTableHoaDon();
		
	}
	
	public void xoaTableHoaDon() {
		model.addRow(new Object[] {
				
		});
		DefaultTableModel tblModel2 = (DefaultTableModel) tableHoaDon.getModel();
		tblModel2.getDataVector().removeAllElements();	
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int row= tableHoaDon.getSelectedRow();
		txtMa.setText(tableHoaDon.getValueAt(row, 0).toString());
		txtNgayLap.setText(tableHoaDon.getValueAt(row, 1).toString());
		txtNVLap.setText(tableHoaDon.getValueAt(row, 2).toString());
		txtTenKH.setText(tableHoaDon.getValueAt(row, 3).toString());
		txtTongTien.setText(tableHoaDon.getValueAt(row, 4).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
