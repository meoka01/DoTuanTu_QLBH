package dotuantu_qlbh;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class DoTuanTu_NhanVien {
	private int id;
	private String ten;
	private List<DoTuanTu_ChiTietHoaDon> chiTietHoaDonList;
	private List<DoTuanTu_KhachHang> khachHangList;
	private List<DoTuanTu_HoaDon> hoaDonList;

	public DoTuanTu_NhanVien(int id, String ten) {
		this.id = id;
		this.ten = ten;
		chiTietHoaDonList = new ArrayList<>();
		khachHangList = new ArrayList<>();
		hoaDonList = new ArrayList<>();
	}

	public List<DoTuanTu_ChiTietHoaDon> getChiTietHoaDonList() {
		return chiTietHoaDonList;
	}

	public void setChiTietHoaDonList(List<DoTuanTu_ChiTietHoaDon> chiTietHoaDonList) {
		this.chiTietHoaDonList = chiTietHoaDonList;
	}

	public void themChiTietHoaDon(DoTuanTu_ChiTietHoaDon chiTietHoaDon) {
		chiTietHoaDonList.add(chiTietHoaDon);
	}

	public void themHoaDon(DoTuanTu_HoaDon hoaDon) {
		hoaDonList.add(hoaDon);
	}

	public void themKhachHang(DoTuanTu_KhachHang khachHang) {
		khachHangList.add(khachHang);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<DoTuanTu_KhachHang> getKhachHangList() {
		return khachHangList;
	}

	public void setKhachHangList(List<DoTuanTu_KhachHang> khachHangList) {
		this.khachHangList = khachHangList;
	}

	public List<DoTuanTu_HoaDon> getHoaDonList() {
		return hoaDonList;
	}

	public void setHoaDonList(List<DoTuanTu_HoaDon> hoaDonList) {
		this.hoaDonList = hoaDonList;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", tên: " + ten;
	}

	public void inHoaDon(List<DoTuanTu_HoaDon> hoaDons) {
		hoaDons.forEach(h -> {
			h.inThongTinHoaDon();
			List<DoTuanTu_ChiTietHoaDon> chiTietHoaDonList = this.chiTietHoaDonList
					.stream()
					.filter(t -> t.getHoaDon().id == h.getId())
					.collect(Collectors.toList());
			double tongTien = 0;
			System.out.println("Chi tiết sản phẩm đã mua: ");
			for (DoTuanTu_ChiTietHoaDon cthd : chiTietHoaDonList) {
				int soLuong = cthd.getSoLuong();
				int gia = cthd.getGia();
				System.out.println("Sản phẩm: " + cthd.getSanPham().toString() + ", số lượng: " + soLuong + ", tổng giá: " + gia);
				tongTien += gia;
			}
			if (h instanceof DoTuanTu_HoaDonVip) {
				DoTuanTu_HoaDonVip vip = (DoTuanTu_HoaDonVip) h;
				tongTien = tongTien - tongTien * vip.getGiamGia() / 100;
			}
			System.out.println("Tổng tiền thanh toán " + tongTien);
			System.out.println("--------------------");
		});
	}
}
