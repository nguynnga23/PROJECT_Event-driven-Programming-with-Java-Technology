package server;

import javax.naming.NamingException;

import Interface.InChiTietHoaDon;
import Interface.InHoaDon;
import Interface.InKhachHang;
import Interface.InNhanVien;
import Interface.InThongKe;
import Interface.InTour;

import bus.KhachHang_BUS;
import bus.ChiTietHoaDon_BUS;
import bus.HoaDon_BUS;
import bus.NhanVien_BUS;
import bus.ThongKe_BUS;
import bus.Tour_BUS;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@SuppressWarnings("unused")
public class Server {
	public static void main(String[] args) throws RemoteException, NamingException, SQLException {
		Context context = new InitialContext();
		InChiTietHoaDon cthd_bus = new ChiTietHoaDon_BUS();
		InHoaDon hd_bus = new HoaDon_BUS();
		InKhachHang kh_bus = new KhachHang_BUS();
		InNhanVien nv_bus = new NhanVien_BUS();
		InThongKe tk_bus = new ThongKe_BUS();
		InTour tour_bus = new Tour_BUS();

		LocateRegistry.createRegistry(1791);
		try {
			context.rebind("rmi://localhost:1791/ChiTietHoaDon", cthd_bus);
			context.rebind("rmi://localhost:1791/HoaDon", hd_bus);
			context.rebind("rmi://localhost:1791/KhachHang", kh_bus);
			context.rebind("rmi://localhost:1791/NhanVien", nv_bus);
			context.rebind("rmi://localhost:1791/ThongKe", tk_bus);
			context.rebind("rmi://localhost:1791/Tour", tour_bus);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		if(context != null)
		{
			System.out.println("Server is running");
			System.out.println("Waiting for client...");
			// Kiểm tra xem client đã kết nối chưa
			while (true) {
				if (cthd_bus != null && hd_bus != null && kh_bus != null && nv_bus != null && tk_bus != null
						&& tour_bus != null) {
					System.out.println("Client connected");
//					System.out.println("Server is running");
					break;
				}
			}
		}
	}
}
