package dotuantu_qlbh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DoTuanTu_HoaDonVip extends DoTuanTu_HoaDon {
	private int giamGia;

	public DoTuanTu_HoaDonVip(int id, String maHoaDon, Date ngayBan, DoTuanTu_KhachHang khachHang,
							  DoTuanTu_NhanVien nhanVien, int giamGia) {
		super(id, maHoaDon, ngayBan, khachHang, nhanVien);
		this.giamGia = giamGia;
	}

	public int getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}

	@Override
	public void inThongTinHoaDon() {
		String nb = new SimpleDateFormat("dd/MM/yyyy").format(ngayBan);
		System.out.println("Mã HĐ: " + id + ", số hóa đơn: " + maHoaDon + ", ngày bán: " + nb +
				", khách hàng: " + khachHang.toString() + ", giảm giá: "+ giamGia + ", nhân viên bán hàng: " + nhanVien.toString());
	}
}
