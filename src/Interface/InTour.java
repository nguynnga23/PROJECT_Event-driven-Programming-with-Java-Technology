package Interface;

import java.sql.Date;
import java.util.ArrayList;

import entity.Tour;

public interface InTour extends java.rmi.Remote {
	public ArrayList<Tour> getalltbTour() throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoMaTour(String maTourID) throws java.rmi.RemoteException;

	public boolean create(Tour tour) throws java.rmi.RemoteException;

	public boolean delete(Tour tour) throws java.rmi.RemoteException;

	public boolean update(Tour tour) throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimTen(String Ten) throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoDiaDiem(String dd) throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoGia(double giamin, double giamax) throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoNgayKH(Date ngayKh) throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimTenvsDiaDiem(String Ten, String dd) throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimTenvsGia(String Ten, double giamin, double giamax)
			throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimTenvsNgayKH(String Ten, Date NgayKH) throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimDiaDiemvsGia(String dd, double giamin, double giamax)
			throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimDiaDiemvsNgayKH(String dd, Date NgayKH) throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimGiavsNgayKH(double giamin, double giamax, Date NgayKH)
			throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimTenvsDiaDiemvsGia(String ten, String dd, double giamin, double giamax)
			throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimTenvsDiaDiemvsNgayKH(String ten, String dd, Date NgayKH)
			throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimTenvsGiavsNgayKH(String ten, double giamin, double giamax, Date NgayKH)
			throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimDiaDiemvsGiavsNgayKH(String dd, double giamin, double giamax, Date NgayKH)
			throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourTheoTimTheoALL(String ten, String dd, double giamin, double giamax, Date NgayKH)
			throws java.rmi.RemoteException;

	public ArrayList<Tour> getTourOderMax()throws java.rmi.RemoteException;

}
