
package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Rectangle;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.RowFilter;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Interface.InChiTietHoaDon;
import Interface.InTour;
import bus.ChiTietHoaDon_BUS;
import bus.Tour_BUS;
import connectDB.ConnectDB;
import dao.ChiTietHoaDon_DAO;
import dao.DatTour_DAO;
import entity.Tour;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;

public class TrangChu extends JFrame {

	private JPanel contentPane;
	private JTextField txtmaTdanang_hoian;
	private JTextField txtTenTour_DN;
	private JTextField dateKH_danang_hoian;
	private JTextField txtgiatour_dananghoian;
	private JTextField txtddden;
	private JTextField dateKT;
	private JTextField txtmaLyson;
	private JTextField txttenLyson;
	private JTextField dateKHLySon;
	private JTextField txtgiaLyson;
	private JTextField txtdddLyson;
	private JTextField dateKTLyson;
	private JTextField textmahagiang;
	private JTextField txttenhagiang;
	private JTextField dateKHhagiang;
	private JTextField txtgia;
	private JTextField txtDDDhagiang;
	private JTextField dateKthagiang;
	private JTable table;
	private InTour tour_bus;
	private DefaultTableModel model;
	private JComboBox cbGia;
	private JComboBox cbTen;
	private JComboBox cbDD;
	private JDateChooser dateNgKH;
//	private DatTour datTour_dao;
//	private ChiTietHoaDon_DAO CTHD_dao;
	private JFrame frame;
	private Date ngayKH;
	private InChiTietHoaDon CTHD_bus;
	private static JLabel lblThongBao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
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
	public TrangChu() throws RemoteException, SQLException {
		setBackground(SystemColor.activeCaptionBorder);
		try {
			ConnectDB.getInstance().connect();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		tour_bus = new Tour_BUS();
		
		// lấy đối tượng GraphicsEnvironment để lấy kích thước màn hình
//		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		Rectangle bounds = env.getMaximumWindowBounds();
//		frame = new JFrame();
//		frame.setSize(bounds.width, bounds.height); // set kích thước frame
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null); // đặt vị trí của frame ở giữa màn hình
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // phóng to frame full màn hình
//		frame.setVisible(true); // hiển thị frame
		
		setTitle("TRANG CHỦ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 695);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.setForeground(SystemColor.textHighlight);
		tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 10));
		tabbedPane.setBounds(225, 85, 750, 563);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Tour phổ biến", null, panel, null);
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(SystemColor.window);
		panel_3_1.setBounds(20, 10, 705, 157);
		panel.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tour du lịch ĐÀ NẴNG - HỘI AN");
		lblNewLabel_2.setBounds(205, 10, 447, 19);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_3_1.add(lblNewLabel_2);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(205, 39, 230, 101);
		panel_3_1.add(verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JLabel lblMaTour1 = new JLabel("Mã tour:");
		lblMaTour1.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox.add(lblMaTour1);
		
		txtmaTdanang_hoian = new JTextField();
		horizontalBox.add(txtmaTdanang_hoian);
		txtmaTdanang_hoian.setColumns(10);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		JLabel lblTenTour = new JLabel("Tên Tour");
		lblTenTour.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_2.add(lblTenTour);
		
		txtTenTour_DN = new JTextField();
		horizontalBox_2.add(txtTenTour_DN);
		txtTenTour_DN.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
		
		JLabel lblTGKH1 = new JLabel("Thời gian khởi hành: ");
		lblTGKH1.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_3.add(lblTGKH1);
		
		dateKH_danang_hoian = new JTextField();
		horizontalBox_3.add(dateKH_danang_hoian);
		dateKH_danang_hoian.setColumns(10);
		
		Box verticalBox_3 = Box.createVerticalBox();
		verticalBox_3.setBounds(445, 39, 250, 101);
		panel_3_1.add(verticalBox_3);
		
		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_6);
		
		JLabel lblGiaTour1 = new JLabel("Giá tour:");
		lblGiaTour1.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_6.add(lblGiaTour1);
		
		txtgiatour_dananghoian = new JTextField();
		txtgiatour_dananghoian.setColumns(10);
		horizontalBox_6.add(txtgiatour_dananghoian);
		
		Box horizontalBox_1_3 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_1_3);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		verticalBox_3.add(verticalStrut_4);
		
		Box horizontalBox_2_3 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_2_3);
		
		JLabel lblDiaDiemDen1 = new JLabel("Địa điểm đến:");
		lblDiaDiemDen1.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_2_3.add(lblDiaDiemDen1);
		
		txtddden = new JTextField();
		txtddden.setColumns(10);
		horizontalBox_2_3.add(txtddden);
		
		Component verticalStrut_1_3 = Box.createVerticalStrut(20);
		verticalBox_3.add(verticalStrut_1_3);
		
		Box horizontalBox_3_3 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_3_3);
		
		JLabel lblTGKT1 = new JLabel("Thời gian kết thúc: ");
		lblTGKT1.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_3_3.add(lblTGKT1);
		
		dateKT = new JTextField();
		dateKT.setColumns(10);
		horizontalBox_3_3.add(dateKT);
		List<Tour> list = tour_bus.getTourOderMax();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Tour t =list.get(0)	;		
			txtmaTdanang_hoian.setText(t.getMaTour());
			txtTenTour_DN.setText(t.getTenTour());
			txtgiatour_dananghoian.setText(Double.toString(t.getGiatien()));
			txtddden.setText(t.getDiadiemden());
			dateKH_danang_hoian.setText(formatter.format(t.getNgaykhoihanh()));
			dateKT.setText(formatter.format(t.getNgaykethuc()));
			lblNewLabel_2.setText("Tour du lịch "+txtTenTour_DN.getText()+"-"+txtddden.getText());
		
		txtmaTdanang_hoian.setEditable(false);
		txtTenTour_DN.setEditable(false);
		txtTenTour_DN.setEditable(false);
		txtgiatour_dananghoian.setEditable(false);
		txtddden.setEditable(false);
		dateKH_danang_hoian.setEditable(false);
		dateKT.setEditable(false);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(SystemColor.window);
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBounds(20, 365, 705, 159);
		panel.add(panel_3_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tour du lịch LÝ SƠN - QUẢNG NGÃI");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(205, 10, 458, 19);
		panel_3_1_1.add(lblNewLabel_2_2);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(205, 39, 230, 101);
		panel_3_1_1.add(verticalBox_1);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_4);
		
		JLabel lblMaTour3 = new JLabel("Mã tour:");
		lblMaTour3.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_4.add(lblMaTour3);
		
		txtmaLyson = new JTextField();
		txtmaLyson.setColumns(10);
		horizontalBox_4.add(txtmaLyson);
		
		Box horizontalBox_1_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_1_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_2);
		
		Box horizontalBox_2_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_2_1);
		
		JLabel lblDiaDiemDi3 = new JLabel("Tên Tour");
		lblDiaDiemDi3.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_2_1.add(lblDiaDiemDi3);
		
		txttenLyson = new JTextField();
		txttenLyson.setColumns(10);
		horizontalBox_2_1.add(txttenLyson);
		
		Component verticalStrut_1_1 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_1_1);
		
		Box horizontalBox_3_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3_1);
		
		JLabel lblTGKH3 = new JLabel("Thời gian khởi hành: ");
		lblTGKH3.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_3_1.add(lblTGKH3);
		
		dateKHLySon = new JTextField();
		dateKHLySon.setColumns(10);
		horizontalBox_3_1.add(dateKHLySon);
		
		Box verticalBox_3_1 = Box.createVerticalBox();
		verticalBox_3_1.setBounds(445, 39, 250, 101);
		panel_3_1_1.add(verticalBox_3_1);
		
		Box horizontalBox_6_1 = Box.createHorizontalBox();
		verticalBox_3_1.add(horizontalBox_6_1);
		
		JLabel lblGiaTour3 = new JLabel("Giá tour:");
		lblGiaTour3.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_6_1.add(lblGiaTour3);
		
		txtgiaLyson = new JTextField();
		txtgiaLyson.setColumns(10);
		horizontalBox_6_1.add(txtgiaLyson);
		
		Box horizontalBox_1_3_1 = Box.createHorizontalBox();
		verticalBox_3_1.add(horizontalBox_1_3_1);
		
		Component verticalStrut_4_1 = Box.createVerticalStrut(20);
		verticalBox_3_1.add(verticalStrut_4_1);
		
		Box horizontalBox_2_3_1 = Box.createHorizontalBox();
		verticalBox_3_1.add(horizontalBox_2_3_1);
		
		JLabel lblDiaDiemDen3 = new JLabel("Địa điểm đến:");
		lblDiaDiemDen3.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_2_3_1.add(lblDiaDiemDen3);
		
		txtdddLyson = new JTextField();
		txtdddLyson.setColumns(10);
		horizontalBox_2_3_1.add(txtdddLyson);
		
		Component verticalStrut_1_3_1 = Box.createVerticalStrut(20);
		verticalBox_3_1.add(verticalStrut_1_3_1);
		
		Box horizontalBox_3_3_1 = Box.createHorizontalBox();
		verticalBox_3_1.add(horizontalBox_3_3_1);
		
		JLabel lblTGKT3 = new JLabel("Thời gian kết thúc: ");
		lblTGKT3.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_3_3_1.add(lblTGKT3);
		
		dateKTLyson = new JTextField();
		dateKTLyson.setColumns(10);
		horizontalBox_3_3_1.add(dateKTLyson);
		list = tour_bus.getTourOderMax();
		Tour t1 =list.get(1);
		
			txtmaLyson.setText(t1.getMaTour());
			txttenLyson.setText(t1.getTenTour());
			txtgiaLyson.setText(Double.toString(t1.getGiatien()));
			txtdddLyson.setText(t1.getDiadiemden());
			dateKHLySon.setText(formatter.format(t1.getNgaykhoihanh()));
			dateKTLyson.setText(formatter.format(t1.getNgaykethuc()));
			lblNewLabel_2_2.setText("Tour du lịch "+txttenLyson.getText()+"-"+txtdddLyson.getText());

		
		txtmaLyson.setEditable(false);
		txttenLyson.setEditable(false);
		txtgiaLyson.setEditable(false);
		txtdddLyson.setEditable(false);
		dateKHLySon.setEditable(false);
		dateKTLyson.setEditable(false);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBackground(SystemColor.window);
		panel_3_1_2.setLayout(null);
		panel_3_1_2.setBounds(20, 186, 705, 157);
		panel.add(panel_3_1_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Tour du lịch HÀ GIANG - HÀ GIANG");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(205, 10, 545, 19);
		panel_3_1_2.add(lblNewLabel_2_3);
		
		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setBounds(205, 39, 230, 101);
		panel_3_1_2.add(verticalBox_2);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_5);
		
		JLabel lblMaTour2 = new JLabel("Mã tour:");
		lblMaTour2.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_5.add(lblMaTour2);
		
		textmahagiang = new JTextField();
		textmahagiang.setColumns(10);
		horizontalBox_5.add(textmahagiang);
		
		Box horizontalBox_1_2 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_1_2);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalBox_2.add(verticalStrut_3);
		
		Box horizontalBox_2_2 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_2_2);
		
		JLabel lblDiaDiemDi2 = new JLabel("Tên Tour");
		lblDiaDiemDi2.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_2_2.add(lblDiaDiemDi2);
		
		txttenhagiang = new JTextField();
		txttenhagiang.setColumns(10);
		horizontalBox_2_2.add(txttenhagiang);
		
		Component verticalStrut_1_2 = Box.createVerticalStrut(20);
		verticalBox_2.add(verticalStrut_1_2);
		
		Box horizontalBox_3_2 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_3_2);
		
		JLabel lblTGKH2 = new JLabel("Thời gian khởi hành: ");
		lblTGKH2.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_3_2.add(lblTGKH2);
		
		dateKHhagiang = new JTextField();
		dateKHhagiang.setColumns(10);
		horizontalBox_3_2.add(dateKHhagiang);
		
		Box verticalBox_3_2 = Box.createVerticalBox();
		verticalBox_3_2.setBounds(445, 39, 250, 101);
		panel_3_1_2.add(verticalBox_3_2);
		
		Box horizontalBox_6_2 = Box.createHorizontalBox();
		verticalBox_3_2.add(horizontalBox_6_2);
		
		JLabel lblGiaTour2 = new JLabel("Giá tour:");
		lblGiaTour2.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_6_2.add(lblGiaTour2);
		
		txtgia = new JTextField();
		txtgia.setColumns(10);
		horizontalBox_6_2.add(txtgia);
		
		Box horizontalBox_1_3_2 = Box.createHorizontalBox();
		verticalBox_3_2.add(horizontalBox_1_3_2);
		
		Component verticalStrut_4_2 = Box.createVerticalStrut(20);
		verticalBox_3_2.add(verticalStrut_4_2);
		
		Box horizontalBox_2_3_2 = Box.createHorizontalBox();
		verticalBox_3_2.add(horizontalBox_2_3_2);
		
		JLabel lblDiaDiemDen2 = new JLabel("Địa điểm đến:");
		lblDiaDiemDen2.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_2_3_2.add(lblDiaDiemDen2);
		
		txtDDDhagiang = new JTextField();
		txtDDDhagiang.setColumns(10);
		horizontalBox_2_3_2.add(txtDDDhagiang);
		
		Component verticalStrut_1_3_2 = Box.createVerticalStrut(20);
		verticalBox_3_2.add(verticalStrut_1_3_2);
		
		Box horizontalBox_3_3_2 = Box.createHorizontalBox();
		verticalBox_3_2.add(horizontalBox_3_3_2);
		
		JLabel lblTGKT2 = new JLabel("Thời gian kết thúc: ");
		lblTGKT2.setFont(new Font("Tahoma", Font.BOLD, 10));
		horizontalBox_3_3_2.add(lblTGKT2);
		
		dateKthagiang = new JTextField();
		dateKthagiang.setColumns(10);
		horizontalBox_3_3_2.add(dateKthagiang);
		list = tour_bus.getTourOderMax();
		Tour t2 =list.get(2) ;
		
			textmahagiang.setText(t2.getMaTour());
			txttenhagiang.setText(t2.getTenTour());
			txtgia.setText(Double.toString(t2.getGiatien()));
			txtDDDhagiang.setText(t2.getDiadiemden());
			dateKHhagiang.setText(formatter.format(t2.getNgaykhoihanh()));
			dateKthagiang.setText(formatter.format(t2.getNgaykethuc()));
			lblNewLabel_2_3.setText("Tour du lịch "+txttenhagiang.getText()+"-"+txtDDDhagiang.getText());
		
		
		textmahagiang.setEditable(false);
		txttenhagiang.setEditable(false);
		txtgia.setEditable(false);
		txtDDDhagiang.setEditable(false);
		dateKHhagiang.setEditable(false);
		dateKthagiang.setEditable(false);
		
		lblMaTour1.setPreferredSize(lblTGKH1.getPreferredSize());
		lblMaTour2.setPreferredSize(lblTGKH1.getPreferredSize());
		lblMaTour3.setPreferredSize(lblTGKH1.getPreferredSize());
		lblGiaTour1.setPreferredSize(lblTGKT1.getPreferredSize());
		lblGiaTour2.setPreferredSize(lblTGKT1.getPreferredSize());
		lblGiaTour3.setPreferredSize(lblTGKT1.getPreferredSize());
		lblTenTour.setPreferredSize(lblTGKH1.getPreferredSize());
		lblDiaDiemDi2.setPreferredSize(lblTGKH1.getPreferredSize());
		lblDiaDiemDi3.setPreferredSize(lblTGKH1.getPreferredSize());
		lblDiaDiemDen1.setPreferredSize(lblTGKT1.getPreferredSize());
		
		JButton btnDatHoiAn = new JButton("ĐẶT TOUR");
		btnDatHoiAn.setForeground(new Color(255, 255, 255));
		btnDatHoiAn.setBackground(SystemColor.textHighlight);
		btnDatHoiAn.setFont(new Font("Segoe UI", Font.BOLD, 9));
		btnDatHoiAn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(t.getSoluong()-getSLTTour(txtmaTdanang_hoian.getText())==0) {
						JOptionPane.showMessageDialog(null, "Hiện tại Tour này đã hết chổ ! Bạn có thể tìm Tour khác ở danh sách Tour.");
						
						return;
					}
				} catch (HeadlessException | RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				QuanLyKhachHang qlkh = null;
				try {
					qlkh = new QuanLyKhachHang();
				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				qlkh.getMaTourInTrangChu(txtmaTdanang_hoian.getText());
				qlkh.setVisible(true);
				
				setVisible(false);
			}
		});
		btnDatHoiAn.setBounds(65, 126, 80, 21);
		panel_3_1.add(btnDatHoiAn);
		
		JLabel lblIMG1 = new JLabel("");
		lblIMG1.setIcon(new ImageIcon("img\\hoian.png"));
		lblIMG1.setBounds(10, 15, 185, 101);
		panel_3_1.add(lblIMG1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 10, 185, 106);
		panel_3_1.add(lblNewLabel_4);
		lblDiaDiemDen2.setPreferredSize(lblTGKT1.getPreferredSize());
		
		JButton btnDatHaGiang = new JButton("ĐẶT TOUR");
		btnDatHaGiang.setForeground(new Color(255, 255, 255));
		btnDatHaGiang.setBackground(SystemColor.textHighlight);
		btnDatHaGiang.setFont(new Font("Segoe UI", Font.BOLD, 9));
		btnDatHaGiang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(t2.getSoluong()-getSLTTour(textmahagiang.getText())==0) {
						JOptionPane.showMessageDialog(null, "Hiện tại Tour này đã hết chổ ! Bạn có thể tìm Tour khác ở danh sách Tour.");
						
						return;
					}
				} catch (HeadlessException | RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				QuanLyKhachHang qlkh = null;
				try {
					qlkh = new QuanLyKhachHang();
				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				qlkh.getMaTourInTrangChu(textmahagiang.getText());
				qlkh.setVisible(true);
				
				setVisible(false);

			}
		});
		btnDatHaGiang.setBounds(69, 126, 80, 21);
		panel_3_1_2.add(btnDatHaGiang);
		
		JLabel lblIMG2 = new JLabel("");
		lblIMG2.setIcon(new ImageIcon("img\\hagiang22.png"));
		lblIMG2.setBounds(10, 15, 185, 101);
		panel_3_1_2.add(lblIMG2);
		lblDiaDiemDen3.setPreferredSize(lblTGKT1.getPreferredSize());
		
		JButton btnDatLySon = new JButton("ĐẶT TOUR");
		btnDatLySon.setForeground(new Color(255, 255, 255));
		btnDatLySon.setBackground(SystemColor.textHighlight);
		btnDatLySon.setFont(new Font("Segoe UI", Font.BOLD, 9));
		btnDatLySon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(t1.getSoluong()-getSLTTour(txtmaLyson.getText())==0) {
						JOptionPane.showMessageDialog(null, "Hiện tại Tour này đã hết chổ ! Bạn có thể tìm Tour khác ở danh sách Tour.");
						
						return;
					}
				} catch (HeadlessException | RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				QuanLyKhachHang qlkh = null;
				try {
					qlkh = new QuanLyKhachHang();
				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				qlkh.getMaTourInTrangChu(txtmaLyson.getText());
				qlkh.setVisible(true);
				
				setVisible(false);
				
			}
		});
		btnDatLySon.setBounds(65, 126, 80, 21);
		panel_3_1_1.add(btnDatLySon);
		
		JLabel lblIMG3 = new JLabel("");
		lblIMG3.setIcon(new ImageIcon("img\\lyson.png"));
		lblIMG3.setBounds(10, 15, 185, 101);
		panel_3_1_1.add(lblIMG3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBackground(SystemColor.menu);
		tabbedPane.addTab("Danh Sách Tour", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBackground(SystemColor.window);
		panel_4.setBounds(10, 11, 724, 130);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblTen = new JLabel("Tìm theo tên");
		lblTen.setBounds(10, 11, 81, 14);
		panel_4.add(lblTen);
		
		JLabel lblDD = new JLabel("Địa điểm");
		lblDD.setBounds(10, 51, 81, 14);
		panel_4.add(lblDD);
		
		
		String all[] = {"Tất Cả"};
		 cbDD = new JComboBox(all);
		 cbDD.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Tim();
//		 		 String selectedDD = (String) cbDD.getSelectedItem();
//		 		 XoahetDuLieutrenTable();
//		 		 searchToursByAdress(selectedDD);
//		 		String col ="Địa điểm";
//		 		TimKiem(selectedDD,col);
		 	}
		 });
		cbDD.setBounds(101, 47, 230, 22);
		panel_4.add(cbDD);
		
		cbTen = new JComboBox(all);
		cbTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tim();
//				   String selectedTen = (String) cbTen.getSelectedItem();
//				   XoahetDuLieutrenTable();
//				   searchToursByName(selectedTen);
//				   TimTenTour(selectedTen);
//				   String col ="Tên Tour";
//				   TimKiem(selectedTen,col);
				   
			}
		});
		cbTen.setBounds(101, 7, 230, 22);
		panel_4.add(cbTen);
		
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setBounds(10, 91, 81, 14);
		panel_4.add(lblGi);
		
		String gia[]="Tất Cả;1.000.000-2.000.000;2.000.000-5.000.000;5.000.000 Trở lên".split(";");
		
		 cbGia = new JComboBox(gia);
		 cbGia.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Tim();
//		 		 String selectedGia = (String) cbGia.getSelectedItem();
//		 		  List<Tour> list = tour_bus.getalltbTour();
//		 		  String selectedTen = (String) cbTen.getSelectedItem();
//				  
//		        if (!selectedGia.equals("Tất Cả")) {
//		        	XoahetDuLieutrenTable();
//		            searchToursByPrice(selectedGia, list);
////		            searchToursByName(selectedTen);
//		            
//		        }
		 	}
		 });
		cbGia.setBounds(101, 87, 230, 22);
		panel_4.add(cbGia);
		
		ArrayList<Tour> listTour = tour_bus.getalltbTour();
		//Địa điểm không bị trùng trong JcomboBox
		Set<String> uniqueDD = new HashSet<>();
		for (Tour tour : listTour) {
		    String dd = tour.getDiadiemden();
		    if (!uniqueDD.contains(dd)) {
		        uniqueDD.add(dd);
		        cbDD.addItem(dd);
		    }
		}
		//Tên không bị trùng trong JcomboBox
		Set<String> uniqueTen = new HashSet<>();
		for(Tour tour:listTour) {
			String ten = tour.getTenTour();
			if (!uniqueTen.contains(ten)) {
		        uniqueTen.add(ten);
		        cbTen.addItem(ten);
		    }
		}
		
		 dateNgKH = new JDateChooser();
		 
		dateNgKH.setBounds(475, 7, 200, 25);
		panel_4.add(dateNgKH);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày Khởi Hành");
		lblNewLabel_3.setBounds(365, 11, 100, 14);
		panel_4.add(lblNewLabel_3);
		
		JButton btnDS = new JButton("Danh Sách");
		btnDS.setBackground(SystemColor.textHighlight);
		btnDS.setForeground(SystemColor.window);
		btnDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!cbTen.getSelectedItem().equals("Tất Cả"))cbTen.setSelectedIndex(0);
				if(!cbDD.getSelectedItem().equals("Tất Cả"))cbDD.setSelectedIndex(0);
				if(!cbGia.getSelectedItem().equals("Tất Cả"))cbGia.setSelectedIndex(0);
				if(dateNgKH!=null) dateNgKH.setDate(null);
				XoahetDuLieutrenTable();
				try {
					try {
						DocDuLieuTuDB();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return;
			}
		});
		btnDS.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDS.setBounds(575, 47, 100, 28);
		panel_4.add(btnDS);
		
		JButton btnDatTour = new JButton("Đặt");
		btnDatTour.setBackground(SystemColor.textHighlight);
		btnDatTour.setForeground(SystemColor.window);
		btnDatTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int row =-1;
					 row = table.getSelectedRow();
					if(row==-1) {
//						JOptionPane.showMessageDialog(null, "Chưa chọn Tour trong table !");
						lblThongBao.setText("Chưa chọn Tour trong table !");
						return;
					}
				int slt = Integer.parseInt(table.getValueAt(row, 6).toString());
				if(slt >0) {
//					int hoi = JOptionPane.showConfirmDialog(null, "Khách Hàng đã có Thông Tin chưa ?","Chú ý",JOptionPane.YES_NO_OPTION);
//					if(hoi==JOptionPane.YES_OPTION) {
//						dt.getMaTourInTrangChu(table.getValueAt(row, 0).toString());
//						dt.setVisible(true);
//						setVisible(false);
//					}
//					else if(hoi==JOptionPane.NO_OPTION) {
//					dt.getMaTourInTrangChu(table.getValueAt(row, 0).toString());
//					getMaTour();
							QuanLyKhachHang qlkh = null;
							try {
								qlkh = new QuanLyKhachHang();
							} catch (RemoteException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							qlkh.getMaTourInTrangChu(table.getValueAt(row, 0).toString());
							qlkh.setVisible(true);
							
							setVisible(false);
//						}
				}
				
				else {
//					JOptionPane.showMessageDialog(null, "Tour đã hết vé");
					lblThongBao.setText("Tour đã hết vé");
				}
				
				
			}
		});
		btnDatTour.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDatTour.setBounds(475, 47, 89, 28);
		panel_4.add(btnDatTour);
		
		 lblThongBao = new JLabel("");
		lblThongBao.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		lblThongBao.setBounds(440, 105, 274, 14);
		panel_4.add(lblThongBao);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 152, 724, 372);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		JViewport viewport = scrollPane.getViewport();
		viewport.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 724, 362);
		panel_5.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		table.setModel(model=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Tour", "T\u00EAn Tour", "\u0110\u1ECBa \u0111i\u1EC3m", "Ng\u00E0y kh\u1EDFi h\u00E0nh", "Ng\u00E0y k\u1EBFt th\u00FAc", "Gi\u00E1 ", "S\u1ED1 l\u01B0\u1EE3ng t\u1ED3n"
			}
		));
		scrollPane.setViewportView(table);
		DocDuLieuTuDB();

		dateNgKH.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
		    @Override
		    public void propertyChange(PropertyChangeEvent evt) {
		        if (evt.getPropertyName().equals("date")) {
		        	 Tim();
		        }
		       
		    }
		});

		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(10, 108, 215, 539);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnFR_QLTour = new JButton("QUẢN LÝ TOUR");
		btnFR_QLTour.setHorizontalAlignment(SwingConstants.LEFT);
		btnFR_QLTour.setForeground(SystemColor.text);
		btnFR_QLTour.setBackground(SystemColor.textHighlight);
		btnFR_QLTour.setIcon(new ImageIcon("img\\Address book.png"));
		btnFR_QLTour.setBounds(10, 35, 195, 40);
		panel_2.add(btnFR_QLTour);
		btnFR_QLTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyTour qlTour = null;
				try {
					qlTour = new QuanLyTour();
				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				qlTour.setVisible(true);
				setVisible(false);
			}
		});
		btnFR_QLTour.setFont(new Font("Segoe UI", Font.BOLD, 11));
		
		JButton btnFR_Thoat = new JButton("ĐĂNG XUẤT");
		btnFR_Thoat.setForeground(SystemColor.text);
		btnFR_Thoat.setIcon(new ImageIcon("img\\Log out.png"));
		btnFR_Thoat.setBackground(new Color(255, 99, 71));
		btnFR_Thoat.setBounds(10, 485, 195, 40);
		panel_2.add(btnFR_Thoat);
		btnFR_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap dn = new DangNhap();
				dn.setVisible(true);
				setVisible(false);
			}
		});
		btnFR_Thoat.setFont(new Font("Segoe UI", Font.BOLD, 11));
		
		JButton btnFR_THONGKE = new JButton("THỐNG KÊ");
		btnFR_THONGKE.setHorizontalAlignment(SwingConstants.LEFT);
		btnFR_THONGKE.setForeground(SystemColor.text);
		btnFR_THONGKE.setBackground(SystemColor.textHighlight);
		btnFR_THONGKE.setIcon(new ImageIcon("img\\ticket.png"));
		btnFR_THONGKE.setBounds(10, 395, 195, 40);
		panel_2.add(btnFR_THONGKE);
		btnFR_THONGKE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				HoaDon hd = new HoaDon();
//				hd.setVisible(true);
//				setVisible(false);
				ThongKe tk = null;
				try {
					tk = new ThongKe();
				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tk.frame.setVisible(true);
				dispose();
			}
		});
		btnFR_THONGKE.setFont(new Font("Segoe UI", Font.BOLD, 11));
		
		JButton btnFR_DatTour = new JButton("ĐẶT TOUR ");
		btnFR_DatTour.setHorizontalAlignment(SwingConstants.LEFT);
		btnFR_DatTour.setForeground(SystemColor.text);
		btnFR_DatTour.setBackground(SystemColor.textHighlight);
		btnFR_DatTour.setIcon(new ImageIcon("img\\Book.png"));
		btnFR_DatTour.setBounds(10, 125, 195, 40);
		panel_2.add(btnFR_DatTour);
		btnFR_DatTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatTour dt = null;
				try {
					dt = new DatTour();
				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dt.setVisible(true);
				setVisible(false);
			}
		});
		btnFR_DatTour.setFont(new Font("Segoe UI", Font.BOLD, 11));
		
		JButton btnFR_QLKhach = new JButton("QUẢN LÝ KHÁCH HÀNG");
		btnFR_QLKhach.setHorizontalAlignment(SwingConstants.LEFT);
		btnFR_QLKhach.setForeground(SystemColor.text);
		btnFR_QLKhach.setBackground(SystemColor.textHighlight);
		btnFR_QLKhach.setIcon(new ImageIcon("img\\User group.png"));
		btnFR_QLKhach.setBounds(10, 215, 195, 40);
		panel_2.add(btnFR_QLKhach);
		btnFR_QLKhach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKhachHang qlKhach = null;
				try {
					qlKhach = new QuanLyKhachHang();
				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				qlKhach.setVisible(true);
				setVisible(false);
			}
		});
		btnFR_QLKhach.setFont(new Font("Segoe UI", Font.BOLD, 11));
		
		JButton btn_QLNV = new JButton("QUẢN LÝ NHÂN VIÊN");
		btn_QLNV.setHorizontalAlignment(SwingConstants.LEFT);
		btn_QLNV.setForeground(SystemColor.text);
		btn_QLNV.setBackground(SystemColor.textHighlight);
		btn_QLNV.setIcon(new ImageIcon("img\\User group.png"));
		btn_QLNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNhanVien nv = null;
				try {
					nv = new QuanLyNhanVien();
				} catch (RemoteException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nv.getFrame().setVisible(true);
				setVisible(false);
			}
		});
		btn_QLNV.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btn_QLNV.setBounds(10, 305, 195, 40);
		panel_2.add(btn_QLNV);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 10, 180, 13);
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 0, 965, 75);
		contentPane.add(panel_1);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(SystemColor.scrollbar);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("QUẢN LÝ THÔNG TIN DU LỊCH");
		lblNewLabel_5.setBackground(SystemColor.scrollbar);
		lblNewLabel_5.setForeground(SystemColor.window);
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 965, 75);
		panel_1.add(lblNewLabel_5);
	}
	public void DocDuLieuTuDB() throws RemoteException, SQLException {
		List<Tour> list = tour_bus.getalltbTour();
		int slt = 0;
		for(Tour tour: list) {
			slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
			model.addRow(new Object[] {
					tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
					tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
			});
		}
	}
//	
	private void Tim() {
	    String selectedTen = (String) cbTen.getSelectedItem();
	    String selectedDD = (String) cbDD.getSelectedItem();
	    String selectedGia = (String) cbGia.getSelectedItem();
	    double min =0,max =0;
	    
	    if(selectedGia.equals("1.000.000-2.000.000")) {
	    	min = 1000000;
	    	max = 2000000;
	    }
	    if(selectedGia.equals("2.000.000-5.000.000")) {
	    	min = 2000000;
	    	max = 5000000;
	    }
	    if(selectedGia.equals("5.000.000 Trở lên")) {
	    	min = 5000000;
	    	max = 100000000;
	    }
//	    Date ngayKH;
	  try {
		  ngayKH = new java.sql.Date(dateNgKH.getDate().getTime());
	} catch (Exception e) {
		// TODO: handle exception
		ngayKH = null;
	}
	   try {
		 
		   List<Tour> list = null;
		  
		    if(!selectedTen.equals("Tất Cả") && !selectedDD.equals("Tất Cả") && selectedGia.equals("Tất Cả") && ngayKH ==null ) {
		    	  list = tour_bus.getTourTheoTimTenvsDiaDiem(selectedTen, selectedDD);
		    	 XoahetDuLieutrenTable();
		    	 for (Tour tour : list) {
		 			int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
					model.addRow(new Object[] {
							tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
							tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
					});
		             }
		         }
		     if(!selectedTen.equals("Tất Cả") && selectedDD.equals("Tất Cả") && selectedGia.equals("Tất Cả") && ngayKH ==null) {
		    	  list = tour_bus.getTourTheoTimTen(selectedTen);
		    	 XoahetDuLieutrenTable();
		    	 for (Tour tour : list) {
		    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
						model.addRow(new Object[] {
								tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
								tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
						});
	             }
		    }
		    if(selectedTen.equals("Tất Cả") && !selectedDD.equals("Tất Cả") && selectedGia.equals("Tất Cả") && ngayKH ==null) {
		    	 list = tour_bus.getTourTheoDiaDiem(selectedDD);
		    	XoahetDuLieutrenTable();
		    	 for (Tour tour : list) {
		    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
						model.addRow(new Object[] {
								tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
								tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
						});
	            }
		    }
		    if(selectedTen.equals("Tất Cả") && selectedDD.equals("Tất Cả") && !selectedGia.equals("Tất Cả") && ngayKH ==null) {
		    	 list = tour_bus.getTourTheoGia(min, max);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(!selectedTen.equals("Tất Cả") && !selectedDD.equals("Tất Cả") && !selectedGia.equals("Tất Cả") && ngayKH ==null) {
		    	 list = tour_bus.getTourTheoTimTenvsDiaDiemvsGia(selectedTen, selectedDD, min, max);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(selectedTen.equals("Tất Cả") && !selectedDD.equals("Tất Cả") && !selectedGia.equals("Tất Cả") && ngayKH ==null) {
		    	 list = tour_bus.getTourTheoTimDiaDiemvsGia(selectedDD,min, max);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(!selectedTen.equals("Tất Cả") && selectedDD.equals("Tất Cả") && !selectedGia.equals("Tất Cả") && ngayKH ==null) {
		    	 list = tour_bus.getTourTheoTimTenvsGia(selectedTen, min, max);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(selectedTen.equals("Tất Cả") && selectedDD.equals("Tất Cả") && selectedGia.equals("Tất Cả") && ngayKH !=null ) {
		    	 list = tour_bus.getTourTheoNgayKH(ngayKH);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(!selectedTen.equals("Tất Cả") && selectedDD.equals("Tất Cả") && selectedGia.equals("Tất Cả") && ngayKH !=null ) {
		    	 list = tour_bus.getTourTheoTimTenvsNgayKH(selectedTen, ngayKH);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(selectedTen.equals("Tất Cả") && !selectedDD.equals("Tất Cả") && selectedGia.equals("Tất Cả") && ngayKH !=null ) {
		    	 list = tour_bus.getTourTheoTimDiaDiemvsNgayKH(selectedDD,ngayKH);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(selectedTen.equals("Tất Cả") && selectedDD.equals("Tất Cả") && !selectedGia.equals("Tất Cả") && ngayKH !=null ) {
		    	 list = tour_bus.getTourTheoTimGiavsNgayKH(min, max, ngayKH);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(selectedTen.equals("Tất Cả") && !selectedDD.equals("Tất Cả") && !selectedGia.equals("Tất Cả") && ngayKH !=null ) {
		    	 list = tour_bus.getTourTheoTimDiaDiemvsGiavsNgayKH(selectedDD, min, max, ngayKH);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(!selectedTen.equals("Tất Cả") && !selectedDD.equals("Tất Cả") && selectedGia.equals("Tất Cả") && ngayKH !=null ) {
		    	 list = tour_bus.getTourTheoTimTenvsDiaDiemvsNgayKH(selectedTen, selectedDD, ngayKH);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(!selectedTen.equals("Tất Cả") && selectedDD.equals("Tất Cả") && !selectedGia.equals("Tất Cả") && ngayKH !=null ) {
		    	 list = tour_bus.getTourTheoTimTenvsGiavsNgayKH(selectedTen, min, max, ngayKH);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(!selectedTen.equals("Tất Cả") && !selectedDD.equals("Tất Cả") && !selectedGia.equals("Tất Cả") && ngayKH ==null ) {
		    	 list = tour_bus.getTourTheoTimTenvsDiaDiemvsGia(selectedTen, selectedDD, min, max);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(!selectedTen.equals("Tất Cả") && !selectedDD.equals("Tất Cả") && !selectedGia.equals("Tất Cả") && ngayKH !=null ) {
		    	 list = tour_bus.getTourTheoTimTheoALL(selectedTen, selectedDD, min, max, ngayKH);
			    	XoahetDuLieutrenTable();
			    	 for (Tour tour : list) {
			    		 int slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
							model.addRow(new Object[] {
									tour.getMaTour(), tour.getTenTour(), tour.getDiadiemden(),
									tour.getNgaykhoihanh(), tour.getNgaykethuc(), tour.getGiatien(), slt
							});
		            }
		    }
		    if(selectedTen.equals("Tất Cả") && selectedDD.equals("Tất Cả") && selectedGia.equals("Tất Cả") && ngayKH==null ) {
		    	XoahetDuLieutrenTable();
		    	DocDuLieuTuDB();
		    }
		    
		    if(list.isEmpty()) {
			   JOptionPane.showMessageDialog(null, "Không có Tour như bạn yêu cầu !");
			   XoahetDuLieutrenTable();
			   DocDuLieuTuDB();

		   }
		  
		    
	} catch (Exception e) {
		// TODO: handle exception
//		JOptionPane.showMessageDialog(null, "Lỗi !");
	}
	    
}
	
	

	private void XoahetDuLieutrenTable() {
		DefaultTableModel md = (DefaultTableModel)table.getModel();
		md.getDataVector().removeAllElements();
	}
	public int getSLTTour(String ma) throws RemoteException, SQLException {
		CTHD_bus = new ChiTietHoaDon_BUS();
		return CTHD_bus.SLTourDaDat(ma);
	
	}
	
	public String getMaTour() throws RemoteException, SQLException {
		DatTour dt = new DatTour();
		int row =-1;
			 row = table.getSelectedRow();
			if(row==-1) {
//				JOptionPane.showMessageDialog(null, "Chưa chọn Tour trong table !");
				lblThongBao.setText("Chưa chọn Tour trong table !");
				return null;
			}
		 return (table.getValueAt(row, 0).toString());
	}
}
