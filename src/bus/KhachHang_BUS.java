package bus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interface.InKhachHang;
import dao.KhachHang_DAO;
import entity.KhachHang;

public class KhachHang_BUS extends UnicastRemoteObject implements InKhachHang {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5295413536276265599L;
	/**
	 * 
	 */
	private KhachHang_DAO kh_dao;

	public KhachHang_BUS() throws RemoteException, SQLException {
		super();
		kh_dao = new KhachHang_DAO();
	}

	@Override
	public ArrayList<KhachHang> getallkhachhang() throws RemoteException {
		// TODO Auto-generated method stub
		return kh_dao.getallkhachhang();
	}

	@Override
	public ArrayList<KhachHang> getkhachhangTheoMaKH(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return kh_dao.getkhachhangTheoMaKH(id);
	}

	@Override
	public ArrayList<KhachHang> getkhachhangTheoMaTour(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return kh_dao.getkhachhangTheoMaTour(id);
	}

	@Override
	public boolean create(KhachHang kh) throws RemoteException {
		// TODO Auto-generated method stub
		return kh_dao.create(kh);
	}

	@Override
	public boolean update(KhachHang kh) throws RemoteException {
		// TODO Auto-generated method stub
		return kh_dao.update(kh);
	}

	@Override
	public boolean delete(KhachHang kh) throws RemoteException {
		// TODO Auto-generated method stub
		return kh_dao.delete(kh);
	}

	@Override
	public ArrayList<KhachHang> getkhachhangTheoCCCD(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return kh_dao.getkhachhangTheoCCCD(id);
	}

	@Override
	public ArrayList<KhachHang> getkhachhangTheoSDT(String sdt) throws RemoteException {
		// TODO Auto-generated method stub
		return kh_dao.getkhachhangTheoSDT(sdt);
	}

	@Override
	public List<KhachHang> timKhachHangTheoChuoi(String chuoiTimKiem) throws RemoteException {
		return kh_dao.timKhachHangTheoChuoi(chuoiTimKiem);
	}

}
