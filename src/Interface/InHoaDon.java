package Interface;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import entity.HoaDon;

public interface InHoaDon extends java.rmi.Remote {
	public ArrayList<HoaDon> getAllHoaDon() throws java.rmi.RemoteException;

	public ArrayList<HoaDon> getHoaDonTheoMaHD(String maHD) throws java.rmi.RemoteException;

	public boolean create(HoaDon hd) throws java.rmi.RemoteException;

	public boolean delete(HoaDon hd) throws java.rmi.RemoteException;

	public String getTenKH(String maKH) throws RemoteException;

	public String getTenNV(String maNV) throws RemoteException;

	public List<HoaDon> getHoaDonsByKhachHang(String ma) throws RemoteException;

	public List<HoaDon> getHoaDonsByNhanVien(String ma) throws RemoteException;

	public ArrayList<HoaDon> getHoaDonTheoNgayLap(String nl) throws RemoteException;

	public List<HoaDon> getHoaDonsByNgayLap(int ngay, int thang, int nam) throws RemoteException;

}
