package dotuantu_qlbh;

import java.util.Date;

public abstract class DoTuanTu_HoaDon {
	public static int idHoaDon = 1;
	public static String maHD = "HD" + idHoaDon;

	public enum LoaiHoaDon {
		HOA_DON_THUONG, HOA_DON_VIP
	}
	protected int id;
	protected String maHoaDon;
	protected Date ngayBan;
	protected DoTuanTu_KhachHang khachHang;
	protected DoTuanTu_NhanVien nhanVien;

	public DoTuanTu_HoaDon(int id, String maHoaDon, Date ngayBan, DoTuanTu_KhachHang khachHang, DoTuanTu_NhanVien nhanVien) {
		this.id = id;
		this.maHoaDon = maHoaDon;
		this.ngayBan = ngayBan;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Date getNgayBan() {
		return ngayBan;
	}

	public void setNgayBan(Date ngayBan) {
		this.ngayBan = ngayBan;
	}

	public DoTuanTu_KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(DoTuanTu_KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public DoTuanTu_NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(DoTuanTu_NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public abstract void inThongTinHoaDon();
}
