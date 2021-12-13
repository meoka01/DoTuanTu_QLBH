package dotuantu_qlbh;

public class DoTuanTu_ChiTietHoaDon {
	private DoTuanTu_SanPham sanPham;
	private DoTuanTu_HoaDon hoaDon;
	private int soLuong;
	private int gia;

	public DoTuanTu_ChiTietHoaDon(DoTuanTu_SanPham sanPham, DoTuanTu_HoaDon hoaDon, int soLuong, int gia) {
		this.sanPham = sanPham;
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
		this.gia = gia;
	}

	public DoTuanTu_SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(DoTuanTu_SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public DoTuanTu_HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(DoTuanTu_HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}
}
