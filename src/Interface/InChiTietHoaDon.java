package Interface;

import java.rmi.RemoteException;
import java.util.ArrayList;

import entity.ChiTietHoaDon;

public interface InChiTietHoaDon extends java.rmi.Remote {
	public ArrayList<ChiTietHoaDon> getAllCTHoaDon() throws java.rmi.RemoteException;

	public ArrayList<ChiTietHoaDon> getCTHoaDonTheoMaCTHD(String maCTHD) throws java.rmi.RemoteException;

	public ArrayList<ChiTietHoaDon> getCTHoaDonTheoMaHD(String mahd) throws java.rmi.RemoteException;

	public boolean create(ChiTietHoaDon cthd) throws java.rmi.RemoteException;

	public boolean delete(ChiTietHoaDon cthd) throws java.rmi.RemoteException;

	public int SLTourDaDat(String ma) throws RemoteException;
}
