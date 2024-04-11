package bus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interface.InHoaDon;
import dao.HoaDon_DAO;
import entity.HoaDon;

public class HoaDon_BUS extends UnicastRemoteObject implements InHoaDon {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1692519224759378801L;
	private HoaDon_DAO hd_dao;

	public HoaDon_BUS() throws RemoteException, SQLException {
		hd_dao = new HoaDon_DAO();
	}

	@Override
	public ArrayList<HoaDon> getAllHoaDon() throws RemoteException {
		return hd_dao.getAllHoaDon();
	}

	@Override
	public ArrayList<HoaDon> getHoaDonTheoMaHD(String maHD) throws RemoteException {
		return hd_dao.getHoaDonTheoMaHD(maHD);
	}

	@Override
	public boolean create(HoaDon hd) throws RemoteException {
		return hd_dao.create(hd);
	}

	@Override
	public boolean delete(HoaDon hd) throws RemoteException {
		return hd_dao.delete(hd);
	}

	@Override
	public String getTenKH(String maKH) throws RemoteException {
		return hd_dao.getTenKH(maKH);
	}

	@Override
	public String getTenNV(String maNV) throws RemoteException {
		return hd_dao.getTenNV(maNV);
	}

	@Override
	public List<HoaDon> getHoaDonsByKhachHang(String ma) throws RemoteException {
		return hd_dao.getHoaDonsByKhachHang(ma);
	}

	@Override
	public List<HoaDon> getHoaDonsByNhanVien(String ma) throws RemoteException{
		return hd_dao.getHoaDonsByNhanVien(ma);
	}

	@Override
	public ArrayList<HoaDon> getHoaDonTheoNgayLap(String nl)throws RemoteException {
		return hd_dao.getHoaDonTheoNgayLap(nl);
	}

	@Override
	public List<HoaDon> getHoaDonsByNgayLap(int ngay, int thang, int nam)throws RemoteException {

		return hd_dao.getHoaDonsByNgayLap(ngay, thang, nam);
	}

}
