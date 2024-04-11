package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Interface.InThongKe;
import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;

import entity.Tour;
import ui.ThongKe;

public class ThongKe_DAO implements InThongKe {

	public ThongKe_DAO() throws SQLException {
		ConnectDB.getInstance().connect();
	}

	@Override
	public ArrayList<Object[]> getAllThongKe() {
		ArrayList<java.lang.Object[]> dscthd = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT \r\n"
//					+ "    t.tenTour AS 'tenTour', \r\n"
//					+ "    COUNT(cthd.maTour) AS 'SoLanDat', \r\n"
//					+ "    SUM(cthd.SoLuongKhach) AS 'SLK', \r\n"
//					+ "    t.giaTour AS 'GiaTour', \r\n"
//					+ "    SUM(cthd.ThanhTien) AS 'ThanhTien'\r\n"
//					+ "FROM \r\n"
//					+ "    Tour t \r\n"
//					+ "    JOIN ChiTietHoaDon cthd ON t.maTour = cthd.maTour\r\n"
//					+ "GROUP BY \r\n"
//					+ "    t.tenTour, \r\n"
//					+ "    t.giaTour\r\n"
//					+ "";
			String sql = "SELECT \r\n" + "    Tour.tenTour AS 'tenTour', \r\n"
					+ "    COUNT(CASE WHEN ChiTietHoaDon.MaTour IS NOT NULL THEN 1 END) AS 'SoLanDat', \r\n"
					+ "    SUM(COALESCE(ChiTietHoaDon.soLuongKhach, 0)) AS 'SLK', \r\n"
					+ "    Tour.giaTour AS 'GiaTour', \r\n"
					+ "    SUM(COALESCE(ChiTietHoaDon.ThanhTien, 0)) AS 'ThanhTien' \r\n" + "FROM \r\n"
					+ "    Tour \r\n" + "    LEFT JOIN ChiTietHoaDon ON Tour.MaTour = ChiTietHoaDon.MaTour \r\n"
					+ "GROUP BY \r\n" + "    Tour.maTour, \r\n" + "    Tour.tenTour, \r\n" + "    Tour.giaTour \r\n"
					+ "ORDER BY \r\n" + "    Tour.maTour;\r\n" + "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ten = rs.getString("tenTour");
				int sld = rs.getInt("SoLanDat");
				int slk = rs.getInt("SLK");

				double donGia = rs.getDouble("GiaTour");
				double thanhTien = rs.getDouble("ThanhTien");

				Object[] row = { ten, sld, slk, donGia, thanhTien };
				dscthd.add(row);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dscthd;
	}

	@Override
	public ArrayList<Object[]> getThongKeTheo2ngay(Date ngBD, Date ngayKT) {
		ArrayList<Object[]> dscthd = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "SELECT Tour.tenTour AS tenTour, COUNT(ChiTietHoaDon.maTour) AS SoLanDat, \r\n"
					+ "       SUM(ChiTietHoaDon.soLuongKhach) AS SLK, \r\n" + "       Tour.giaTour AS GiaTour, \r\n"
					+ "       SUM(ChiTietHoaDon.soLuongKhach * ChiTietHoaDon.donGia) AS ThanhTien\r\n" + "FROM Tour\r\n"
					+ "LEFT JOIN ChiTietHoaDon ON Tour.maTour = ChiTietHoaDon.maTour\r\n"
					+ "LEFT JOIN HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD\r\n"
					+ "WHERE HoaDon.ngayLap BETWEEN ? AND ? \r\n" + "GROUP BY Tour.tenTour, Tour.giaTour;\r\n" + "";

//			OR HoaDon.maHD IS NULL
//			Statement statement = con.createStatement();
			stmt = con.prepareStatement(sql);

			stmt.setDate(1, ngBD);
			stmt.setDate(2, ngayKT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String ten = rs.getString("tenTour");
				int sld = rs.getInt("SoLanDat");
				int slk = rs.getInt("SLK");

				double donGia = rs.getDouble("GiaTour");
				double thanhTien = rs.getDouble("ThanhTien");

				Object[] row = { ten, sld, slk, donGia, thanhTien };
				dscthd.add(row);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dscthd;
	}

	@Override
	public ArrayList<Object[]> getThongKeTheoNgayBD(Date ngBD) {
		ArrayList<Object[]> dscthd = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "SELECT Tour.tenTour AS tenTour, COUNT(ChiTietHoaDon.maTour) AS SoLanDat, \r\n"
					+ "       SUM(ChiTietHoaDon.soLuongKhach) AS SLK, \r\n" + "       Tour.giaTour AS GiaTour, \r\n"
					+ "       SUM(ChiTietHoaDon.soLuongKhach * ChiTietHoaDon.donGia) AS ThanhTien\r\n" + "FROM Tour\r\n"
					+ "LEFT JOIN ChiTietHoaDon ON Tour.maTour = ChiTietHoaDon.maTour\r\n"
					+ "LEFT JOIN HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD\r\n" + "WHERE HoaDon.ngayLap >= ? \r\n"
					+ "GROUP BY Tour.tenTour, Tour.giaTour;\r\n" + "";

//			OR HoaDon.maHD IS NULL
//			Statement statement = con.createStatement();
			stmt = con.prepareStatement(sql);

			stmt.setDate(1, ngBD);
//			stmt.setDate(2, ngayKT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String ten = rs.getString("tenTour");
				int sld = rs.getInt("SoLanDat");
				int slk = rs.getInt("SLK");

				double donGia = rs.getDouble("GiaTour");
				double thanhTien = rs.getDouble("ThanhTien");

				Object[] row = { ten, sld, slk, donGia, thanhTien };
				dscthd.add(row);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dscthd;
	}

	@Override
	public ArrayList<Object[]> getThongKeTheoNgayKT(Date ngKT) {
		ArrayList<Object[]> dscthd = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			String sql = "SELECT Tour.tenTour AS tenTour, COUNT(ChiTietHoaDon.maTour) AS SoLanDat, \r\n"
					+ "       SUM(ChiTietHoaDon.soLuongKhach) AS SLK, \r\n" + "       Tour.giaTour AS GiaTour, \r\n"
					+ "       SUM(ChiTietHoaDon.soLuongKhach * ChiTietHoaDon.donGia) AS ThanhTien\r\n" + "FROM Tour\r\n"
					+ "LEFT JOIN ChiTietHoaDon ON Tour.maTour = ChiTietHoaDon.maTour\r\n"
					+ "LEFT JOIN HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD\r\n" + "WHERE HoaDon.ngayLap <= ? \r\n"
					+ "GROUP BY Tour.tenTour, Tour.giaTour;\r\n" + "";

//			OR HoaDon.maHD IS NULL
//			Statement statement = con.createStatement();
			stmt = con.prepareStatement(sql);

//			stmt.setDate(1, ngBD);
			stmt.setDate(1, ngKT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String ten = rs.getString("tenTour");
				int sld = rs.getInt("SoLanDat");
				int slk = rs.getInt("SLK");

				double donGia = rs.getDouble("GiaTour");
				double thanhTien = rs.getDouble("ThanhTien");

				Object[] row = { ten, sld, slk, donGia, thanhTien };
				dscthd.add(row);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dscthd;
	}

	@Override
	public ArrayList<Object[]> getThongKeTheoQuy(int quy, int nam) {
		ArrayList<java.lang.Object[]> dscthd = new ArrayList<>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT Tour.tenTour AS tenTour, " + "       COUNT(ChiTietHoaDon.maTour) AS SoLanDat, "
					+ "       SUM(ChiTietHoaDon.soLuongKhach) AS SLK, " + "       Tour.giaTour AS GiaTour, "
					+ "       SUM(ChiTietHoaDon.soLuongKhach * ChiTietHoaDon.donGia) AS ThanhTien, "
					+ "       CONCAT(YEAR(HoaDon.ngayLap), '-', QUARTER(HoaDon.ngayLap)) AS Quy " + "FROM Tour "
					+ "LEFT JOIN ChiTietHoaDon ON Tour.maTour = ChiTietHoaDon.maTour "
					+ "LEFT JOIN HoaDon ON ChiTietHoaDon.maHD = HoaDon.maHD " + "WHERE YEAR(HoaDon.ngayLap) = ? "
					+ "GROUP BY Tour.tenTour, Tour.giaTour, YEAR(HoaDon.ngayLap), QUARTER(HoaDon.ngayLap)";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ten = rs.getString("tenTour");
				int sld = rs.getInt("SoLanDat");
				int slk = rs.getInt("SLK");
				double donGia = rs.getDouble("GiaTour");
				double thanhTien = rs.getDouble("ThanhTien");

				Object[] row = { ten, sld, slk, donGia, thanhTien };
				dscthd.add(row);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dscthd;
	}

}
