package bus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import Interface.InNhanVien;
import dao.NhanVien_DAO;
import entity.NhanVien;

public class NhanVien_BUS extends UnicastRemoteObject implements InNhanVien {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8024955273201619535L;
	private NhanVien_DAO nv_dao;

	public NhanVien_BUS() throws RemoteException, SQLException {
		nv_dao = new NhanVien_DAO();
	}

	@Override
	public ArrayList<NhanVien> getallNhanVien() throws RemoteException {
		// TODO Auto-generated method stub
		return nv_dao.getallNhanVien();
	}

	@Override
	public ArrayList<NhanVien> getNhanVienTheoMaNV(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return nv_dao.getNhanVienTheoMaNV(id);
	}

	@Override
	public boolean create(NhanVien nv) throws RemoteException {
		// TODO Auto-generated method stub
		return nv_dao.create(nv);
	}

	@Override
	public boolean update(NhanVien nv) throws RemoteException {
		// TODO Auto-generated method stub
		return nv_dao.update(nv);
	}

	@Override
	public boolean delete(NhanVien nv) throws RemoteException {
		// TODO Auto-generated method stub
		return nv_dao.delete(nv);
	}

	@Override
	public ArrayList<NhanVien> getkhachhangTheoMaTour(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return nv_dao.getkhachhangTheoMaTour(id);
	}

}
