package Interface;

import java.sql.Date;

import java.util.ArrayList;

public interface InThongKe extends java.rmi.Remote {
	public ArrayList<Object[]> getAllThongKe() throws java.rmi.RemoteException;

	public ArrayList<Object[]> getThongKeTheo2ngay(Date ngBD, Date ngayKT) throws java.rmi.RemoteException;

	public ArrayList<Object[]> getThongKeTheoNgayBD(Date ngBD) throws java.rmi.RemoteException;

	public ArrayList<Object[]> getThongKeTheoNgayKT(Date ngKT) throws java.rmi.RemoteException;

	public ArrayList<Object[]> getThongKeTheoQuy(int quy, int nam)throws java.rmi.RemoteException;

}
