package bus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Interface.InTour;
import dao.Tour_DAO;
import entity.Tour;

public class Tour_BUS extends UnicastRemoteObject implements InTour {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7651491013862602545L;
	private Tour_DAO t_dao;

	public Tour_BUS() throws RemoteException, SQLException {
		super();
		t_dao = new Tour_DAO();
	}

	@Override
	public ArrayList<Tour> getalltbTour() throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getalltbTour();
	}

	@Override
	public ArrayList<Tour> getTourTheoMaTour(String maTourID) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoMaTour(maTourID);
	}

	@Override
	public boolean create(Tour tour) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.create(tour);
	}

	@Override
	public boolean update(Tour tour) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.update(tour);
	}

	@Override
	public boolean delete(Tour tour) throws RemoteException {
		return t_dao.delete(tour);
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Tour> getTourTheoTimTenvsDiaDiem(String Ten, String dd) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimTenvsDiaDiem(Ten, dd);
	}

	@Override
	public ArrayList<Tour> getTourTheoTimTen(String Ten) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimTen(Ten);
	}

	@Override
	public ArrayList<Tour> getTourTheoDiaDiem(String dd) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoDiaDiem(dd);
	}

	@Override
	public ArrayList<Tour> getTourTheoGia(double giamin, double giamax) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoGia(giamin, giamax);
	}

	@Override
	public ArrayList<Tour> getTourTheoNgayKH(Date ngayKh) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoNgayKH(ngayKh);
	}

	@Override
	public ArrayList<Tour> getTourTheoTimTenvsGia(String Ten, double giamin, double giamax) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimTenvsGia(Ten, giamin, giamax);
	}

	@Override
	public ArrayList<Tour> getTourTheoTimTenvsNgayKH(String Ten, Date NgayKH) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimTenvsNgayKH(Ten, NgayKH);
	}

	@Override
	public ArrayList<Tour> getTourTheoTimDiaDiemvsGia(String dd, double giamin, double giamax) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimDiaDiemvsGia(dd, giamin, giamax);
	}

	@Override
	public ArrayList<Tour> getTourTheoTimDiaDiemvsNgayKH(String dd, Date NgayKH) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimDiaDiemvsNgayKH(dd, NgayKH);
	}

	@Override
	public ArrayList<Tour> getTourTheoTimGiavsNgayKH(double giamin, double giamax, Date NgayKH) throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimGiavsNgayKH(giamin, giamax, NgayKH);
	}

	@Override
	public ArrayList<Tour> getTourTheoTimTenvsDiaDiemvsGia(String ten, String dd, double giamin, double giamax)
			throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimTenvsDiaDiemvsGia(ten, dd, giamin, giamax);
	}

	@Override
	public ArrayList<Tour> getTourTheoTimTenvsDiaDiemvsNgayKH(String ten, String dd, Date NgayKH)
			throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimTenvsDiaDiemvsNgayKH(ten, dd, NgayKH);
	}

	@Override
	public ArrayList<Tour> getTourTheoTimTenvsGiavsNgayKH(String ten, double giamin, double giamax, Date NgayKH)
			throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimTenvsGiavsNgayKH(ten, giamin, giamax, NgayKH);
	}

	@Override
	public ArrayList<Tour> getTourTheoTimDiaDiemvsGiavsNgayKH(String dd, double giamin, double giamax, Date NgayKH)
			throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimDiaDiemvsGiavsNgayKH(dd, giamin, giamax, NgayKH);
	}

	@Override
	public ArrayList<Tour> getTourTheoTimTheoALL(String ten, String dd, double giamin, double giamax, Date NgayKH)
			throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourTheoTimTheoALL(ten, dd, giamin, giamax, NgayKH);
	}

	@Override
	public ArrayList<Tour> getTourOderMax() throws RemoteException {
		// TODO Auto-generated method stub
		return t_dao.getTourOderMax();
	}

}
