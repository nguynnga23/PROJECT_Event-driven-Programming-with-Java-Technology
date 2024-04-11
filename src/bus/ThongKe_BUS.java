package bus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Interface.InThongKe;
import dao.ThongKe_DAO;

public class ThongKe_BUS extends UnicastRemoteObject implements InThongKe {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1333361080091023200L;
	private ThongKe_DAO tk_dao;

	public ThongKe_BUS() throws RemoteException, SQLException {
		super();
		tk_dao = new ThongKe_DAO();
	}

	@Override
	public ArrayList<Object[]> getAllThongKe() throws RemoteException {
		// TODO Auto-generated method stub
		return tk_dao.getAllThongKe();
	}

	@Override
	public ArrayList<Object[]> getThongKeTheo2ngay(Date ngBD, Date ngayKT) throws RemoteException {
		// TODO Auto-generated method stub
		return tk_dao.getThongKeTheo2ngay(ngBD, ngayKT);
	}

	@Override
	public ArrayList<Object[]> getThongKeTheoNgayBD(Date ngBD) throws RemoteException {
		// TODO Auto-generated method stub
		return tk_dao.getThongKeTheoNgayBD(ngBD);
	}

	@Override
	public ArrayList<Object[]> getThongKeTheoNgayKT(Date ngKT) throws RemoteException {
		// TODO Auto-generated method stub
		return tk_dao.getThongKeTheoNgayKT(ngKT);
	}

	@Override
	public ArrayList<Object[]> getThongKeTheoQuy(int quy, int nam) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
