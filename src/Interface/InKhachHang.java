package Interface;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import entity.KhachHang;

public interface InKhachHang extends java.rmi.Remote {
	public ArrayList<KhachHang> getallkhachhang() throws java.rmi.RemoteException;

	public ArrayList<KhachHang> getkhachhangTheoMaKH(String id) throws java.rmi.RemoteException;

	public ArrayList<KhachHang> getkhachhangTheoMaTour(String id) throws java.rmi.RemoteException;

	public boolean create(KhachHang kh) throws java.rmi.RemoteException;

	public boolean update(KhachHang kh) throws java.rmi.RemoteException;

	public boolean delete(KhachHang kh) throws java.rmi.RemoteException;

	public ArrayList<KhachHang> getkhachhangTheoCCCD(String id) throws java.rmi.RemoteException;

	public ArrayList<KhachHang> getkhachhangTheoSDT(String sdt) throws java.rmi.RemoteException;
//	public String getfivemacuoiKH();

	public List<KhachHang> timKhachHangTheoChuoi(String chuoiTimKiem) throws RemoteException;
}
