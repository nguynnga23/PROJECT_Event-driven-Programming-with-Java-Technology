package Interface;

import java.util.ArrayList;

import entity.NhanVien;

public interface InNhanVien extends java.rmi.Remote {
	public ArrayList<NhanVien> getallNhanVien() throws java.rmi.RemoteException;

	public ArrayList<NhanVien> getNhanVienTheoMaNV(String id) throws java.rmi.RemoteException;

	public boolean create(NhanVien nv) throws java.rmi.RemoteException;

	public boolean update(NhanVien nv) throws java.rmi.RemoteException;

	public boolean delete(NhanVien nv) throws java.rmi.RemoteException;

	public ArrayList<NhanVien> getkhachhangTheoMaTour(String id) throws java.rmi.RemoteException;
}
