package bus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import Interface.InChiTietHoaDon;
import dao.ChiTietHoaDon_DAO;
import entity.ChiTietHoaDon;

public class ChiTietHoaDon_BUS extends UnicastRemoteObject implements InChiTietHoaDon {
	/**
	 * 
	 */
	private static final long serialVersionUID = -642029601372121403L;
	private ChiTietHoaDon_DAO cthd_dao;

	public ChiTietHoaDon_BUS() throws RemoteException, SQLException {
		super();
		cthd_dao = new ChiTietHoaDon_DAO();
	}

	@Override
	public ArrayList<ChiTietHoaDon> getAllCTHoaDon() throws RemoteException {
		return cthd_dao.getAllCTHoaDon();
	}

	@Override
	public ArrayList<ChiTietHoaDon> getCTHoaDonTheoMaCTHD(String maCTHD) throws RemoteException {
		return cthd_dao.getCTHoaDonTheoMaCTHD(maCTHD);
	}

	@Override
	public ArrayList<ChiTietHoaDon> getCTHoaDonTheoMaHD(String mahd) throws RemoteException {
		return cthd_dao.getCTHoaDonTheoMaHD(mahd);
	}

	@Override
	public boolean create(ChiTietHoaDon cthd) throws RemoteException {
		return cthd_dao.create(cthd);
	}

	@Override
	public boolean delete(ChiTietHoaDon cthd) throws RemoteException {
		return cthd_dao.delete(cthd);
	}

	@Override
	public int SLTourDaDat(String ma) throws RemoteException {
		return cthd_dao.SLTourDaDat(ma);
	}

}
