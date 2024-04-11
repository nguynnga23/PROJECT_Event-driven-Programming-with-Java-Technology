package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Interface.InHoaDon;
import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Tour;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDon_DAO implements InHoaDon {
	public HoaDon_DAO() throws SQLException {
		ConnectDB.getInstance().connect();
	}
	@Override
	public ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM HoaDon ORDER BY maHD desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString("maHD");
				Date ngayLap = rs.getDate("ngayLap");
				KhachHang kh = new KhachHang(rs.getString("maKH"));
				NhanVien nv = new NhanVien(rs.getString("maNV"));
				double tongTien = rs.getDouble("tongTien");

				HoaDon hd = new HoaDon(ma, ngayLap, kh, nv, tongTien);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dshd;
	}
	@Override
	public ArrayList<HoaDon> getHoaDonTheoMaHD(String maHD) {
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT * FROM HoaDon WHERE maHD = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("maHD");
				Date ngayLap = rs.getDate("ngayLap");
				KhachHang kh = new KhachHang(rs.getString("maKH"));
				NhanVien nv = new NhanVien(rs.getString("maNV"));
				double tongTien = rs.getDouble("tongTien");

				HoaDon hd = new HoaDon(ma, ngayLap, kh, nv, tongTien);
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dshd;
	}
	@Override
	public boolean create(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO HoaDon values(?, ?, ?, ?, ?)");
			stmt.setString(1, hd.getMaHD());
			stmt.setDate(2, hd.getNgayLap());
			stmt.setString(3, hd.getKhachHang().getMaKH());
			stmt.setString(4, hd.getNhanVien().getMaNV());
			stmt.setDouble(5, hd.getTongTien());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	@Override
	public ArrayList<HoaDon> getHoaDonTheoNgayLap(String nl) {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {

			String sql = "Select * from HoaDon where ngayLap = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nl);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("maHD");
				Date ngayLap1 = rs.getDate("ngayLap");
				KhachHang kh = new KhachHang(rs.getString("maKH"));
				NhanVien nv = new NhanVien(rs.getString("maNV"));
				double tongTien = rs.getDouble("tongTien");

				HoaDon hd = new HoaDon(ma, ngayLap1, kh, nv, tongTien);
				dsHD.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dsHD;
	}
	@Override
	public boolean delete(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {

			String sqlDeleteChiTietHoaDon = "DELETE FROM ChiTietHoaDon WHERE maHD = ?";
			statement = con.prepareStatement(sqlDeleteChiTietHoaDon);
			statement.setString(1, hd.getMaHD());
			statement.executeUpdate();

			statement = con.prepareStatement("delete from HoaDon where maHD = ?");
			statement.setString(1, hd.getMaHD());
			n = statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	/**
	 * Lấy tên khách hàng khi biết mã khách hàng
	 * 
	 * @param ma
	 * @return tên khách hàng
	 */
	@Override
	public String getTenKH(String ma) {
		String ten = "";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select [tenKH]\r\n" + "from [dbo].[KhachHang]\r\n" + "where [maKH]=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String t = rs.getString(1);
				ten = t;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ten;
	}
	@Override
	public String getTenNV(String ma) {
		String ten = "";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select [tenNV]\r\n" + "from [dbo].[NhanVien]\r\n" + "where [maNV]=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String t = rs.getString(1);
				ten = t;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ten;
	}

	/**
	 * Lấy danh sách hóa đơn của nhân viên đã lập
	 * 
	 * @param ma
	 * @return danh sách hóa đơn
	 */
	@Override
	public List<HoaDon> getHoaDonsByNhanVien(String ma) {
		List<HoaDon> list = new ArrayList<HoaDon>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select [maHD],[ngayLap],[tongTien],nv.[maNV],[maKH]\r\n"
					+ "from [dbo].[HoaDon] hd  join [dbo].[NhanVien] nv on hd.maNV=nv.maNV\r\n" + "where nv.maNV = ? ";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				Date ngayLap1 = rs.getDate("ngayLap");
				KhachHang kh = new KhachHang(rs.getString("maKH"));
				NhanVien nv = new NhanVien(rs.getString("maNV"));
				double tongTien = rs.getDouble("tongTien");

				HoaDon hd = new HoaDon(maHD, ngayLap1, kh, nv, tongTien);
				list.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	/**
	 * Lấy Hóa đơn có ngày lập đã chọn
	 * 
	 * @param ngay
	 * @param thang
	 * @param nam
	 * @return hóa đơn
	 */
	@Override
	public List<HoaDon> getHoaDonsByNgayLap(int ngay, int thang, int nam) {
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {

			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "select [MaHoaDon],[NgayLap],[TongTien],[MaNhanVien],[MaKhachHang]\r\n"
					+ "from [dbo].[HoaDon]\r\n" + "where DAY([NgayLap])= " + ngay + "  and MONTH([NgayLap]) = " + thang
					+ " and YEAR([NgayLap])=" + nam + "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				Date ngayLap1 = rs.getDate("ngayLap");
				KhachHang kh = new KhachHang(rs.getString("maKH"));
				NhanVien nv = new NhanVien(rs.getString("maNV"));
				double tongTien = rs.getDouble("tongTien");

				HoaDon hd = new HoaDon(maHD, ngayLap1, kh, nv, tongTien);
				list.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	/**
	 * Lấy danh sách hóa đơn của khách hàng đã chọn mua
	 * 
	 * @param ten
	 * @return danh sách hóa đơn
	 */
	@Override
	public List<HoaDon> getHoaDonsByKhachHang(String ma) {
		List<HoaDon> list = new ArrayList<HoaDon>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select [maHD],[ngayLap],[tongTien],[maNV],kh.[maKH]\r\n"
					+ "from [dbo].[HoaDon] hd  join [dbo].[KhachHang] kh on hd.maKH=kh.maKH\r\n" + "where kh.maKH = ? ";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				Date ngayLap1 = rs.getDate("ngayLap");
				KhachHang kh = new KhachHang(rs.getString("maKH"));
				NhanVien nv = new NhanVien(rs.getString("maNV"));
				double tongTien = rs.getDouble("tongTien");

				HoaDon hd = new HoaDon(maHD, ngayLap1, kh, nv, tongTien);
				list.add(hd);
			}
		} catch (Exception e) {
		}
		return list;
	}

}
