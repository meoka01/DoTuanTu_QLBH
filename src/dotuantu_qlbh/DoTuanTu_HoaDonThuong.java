package dotuantu_qlbh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DoTuanTu_HoaDonThuong extends DoTuanTu_HoaDon {
	public DoTuanTu_HoaDonThuong(int id, String maHoaDon, Date ngayBan, DoTuanTu_KhachHang khachHang,
									   DoTuanTu_NhanVien nhanVien) {
		super(id, maHoaDon, ngayBan, khachHang, nhanVien);
	}

	@Override
	public void inThongTinHoaDon() {
		String nb = new SimpleDateFormat("dd/MM/yyyy").format(ngayBan);
		System.out.println("Mã HĐ: " + id + ", số hóa đơn: " + maHoaDon + ", ngày bán: " + nb +
				", khách hàng: " + khachHang.toString() + ", nhân viên bán hàng: " + nhanVien.toString());
	}
}
