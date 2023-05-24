package bus;

import java.util.ArrayList;
import java.util.List;

import Interface.InHoaDon;
import dao.HoaDon_DAO;
import entity.HoaDon;

public class HoaDon_BUS implements InHoaDon {
	HoaDon_DAO hd_dao = new HoaDon_DAO();
	@Override
	public ArrayList<HoaDon> getAllHoaDon() {
		// TODO Auto-generated method stub
		return hd_dao.getAllHoaDon();
	}
	@Override
	public ArrayList<HoaDon> getHoaDonTheoMaHD(String maHD) {
		// TODO Auto-generated method stub
		return hd_dao.getHoaDonTheoMaHD(maHD);
	}
	@Override
	public boolean create(HoaDon hd) {
		// TODO Auto-generated method stub
		return hd_dao.create(hd);
	}
	@Override
	public boolean delete(HoaDon hd) {
		return hd_dao.delete(hd);
	}
	
	public String getTenKH(String maKH) {
		// TODO Auto-generated method stub
		return hd_dao.getTenKH(maKH);
	}
	public String getTenNV(String maNV) {
		// TODO Auto-generated method stub
		return hd_dao.getTenNV(maNV);
	}
	
	public List<HoaDon> getHoaDonsByKhachHang(String ma){
		return hd_dao.getHoaDonsByKhachHang(ma);
	}
	
	public List<HoaDon> getHoaDonsByNhanVien(String ma){
		return hd_dao.getHoaDonsByNhanVien(ma);
	}
	
	public ArrayList<HoaDon> getHoaDonTheoNgayLap(String nl){
		return hd_dao.getHoaDonTheoNgayLap(nl);
	}
	public List<HoaDon> getHoaDonsByNgayLap(int ngay,int thang,int nam) {


		return hd_dao.getHoaDonsByNgayLap(ngay, thang, nam);
	}
	
	

}
