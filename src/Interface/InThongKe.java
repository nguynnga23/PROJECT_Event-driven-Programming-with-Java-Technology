package Interface;

import java.sql.Date;

import java.util.ArrayList;


public interface InThongKe {
	public ArrayList<Object[]> getAllThongKe();
	public ArrayList<Object[]> getThongKeTheo2ngay(Date ngBD,Date ngayKT);
	public ArrayList<Object[]> getThongKeTheoNgayBD(Date ngBD);
	public ArrayList<Object[]> getThongKeTheoNgayKT(Date ngKT);
//	public ArrayList<>

	public ArrayList<Object[]> getThongKeTheoQuy(int quy, int nam);
	
}


