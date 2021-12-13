package dotuantu_qlbh;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DoTuanTu_QuanLy {
	private List<DoTuanTu_NhanVien> nhanVienList;

	public DoTuanTu_QuanLy(List<DoTuanTu_NhanVien> nhanVienList) {
		this.nhanVienList = nhanVienList;
	}

	public List<DoTuanTu_NhanVien> getNhanVienList() {
		return nhanVienList;
	}

	public void setNhanVienList(List<DoTuanTu_NhanVien> nhanVienList) {
		this.nhanVienList = nhanVienList;
	}

	public List<DoTuanTu_HoaDon> timKiemHoaDonTheoNgay(Date ngayBanHang) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String ngayBH = format.format(ngayBanHang);
		List<DoTuanTu_HoaDon> hoaDons = this.nhanVienList.get(0).getHoaDonList().stream()
				.filter(hd -> ngayBH.equals(format.format(hd.getNgayBan()))).collect(Collectors.toList());
		return hoaDons;
	}

	public List<DoTuanTu_HoaDon> timKiemHoaDonTheoKhachHang(String tenKhachHang) {
		List<DoTuanTu_HoaDon> hoaDons = this.nhanVienList.get(0).getHoaDonList().stream()
				.filter(hd -> hd.getKhachHang().getTen().contains(tenKhachHang)).collect(Collectors.toList());
		return hoaDons;
	}

	public List<DoTuanTu_HoaDon> timKiemHoaDonTheoNgayVaTenKH(Date ngayBanHang, String tenKH) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String ngayBH = format.format(ngayBanHang);
		List<DoTuanTu_HoaDon> hoaDons = this.nhanVienList.get(0).getHoaDonList().stream()
				.filter(hd -> hd.getKhachHang().getTen().contains(tenKH) && ngayBH.equals(format.format(hd.getNgayBan())))
				.collect(Collectors.toList());
		return hoaDons;
	}

	public List<DoTuanTu_HoaDon> sapXepHoaDonTheoNgayBanHang() {
		return this.nhanVienList.get(0).getHoaDonList().stream().sorted(Comparator.comparing(DoTuanTu_HoaDon::getNgayBan).reversed()).collect(Collectors.toList());
	}

	public List<DoTuanTu_HoaDon> sapXepHoaDonTheoTongTien() {
		return this.nhanVienList.get(0).getHoaDonList().stream().sorted((o1, o2) -> {
			List<DoTuanTu_ChiTietHoaDon> cthd1 = this.nhanVienList.get(0).getChiTietHoaDonList()
					.stream()
					.filter(t -> t.getHoaDon().id == o1.getId())
					.collect(Collectors.toList());
			int tongTien1 = 0;
			for (DoTuanTu_ChiTietHoaDon cthd : cthd1) {
				tongTien1 += cthd.getGia();
			}

			List<DoTuanTu_ChiTietHoaDon> cthd2 = this.nhanVienList.get(0).getChiTietHoaDonList()
					.stream()
					.filter(t -> t.getHoaDon().id == o2.getId())
					.collect(Collectors.toList());
			int tongTien2 = 0;
			for (DoTuanTu_ChiTietHoaDon cthd : cthd2) {
				tongTien2 += cthd.getGia();
			}
			return tongTien1 - tongTien2;
		}).collect(Collectors.toList());
	}

	public void inHoaDon(List<DoTuanTu_HoaDon> hoaDonList) {
		this.nhanVienList.get(0).inHoaDon(hoaDonList);
	}

	public int thongKeDoanhThuTheoNgay(String ngayBanHang) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		List<DoTuanTu_HoaDon> hoaDons = this.nhanVienList.get(0).getHoaDonList().stream()
				.filter(hd -> ngayBanHang.equals(format.format(hd.getNgayBan()))).collect(Collectors.toList());
		int tongTien = 0;
		for (DoTuanTu_HoaDon hoaDon : hoaDons) {
			List<DoTuanTu_ChiTietHoaDon> cthdList = this.nhanVienList.get(0).getChiTietHoaDonList()
					.stream()
					.filter(t -> t.getHoaDon().id == hoaDon.getId())
					.collect(Collectors.toList());
			for (DoTuanTu_ChiTietHoaDon cthd : cthdList) {
				tongTien += cthd.getGia();
			}
		}
		return tongTien;
	}

	public int thongKeDoanhThuTheoThang(String thang, String nam) {
		List<DoTuanTu_HoaDon> hoaDons = this.nhanVienList.get(0).getHoaDonList()
				.stream()
				.filter(hd -> {
					String thangBanHang = new SimpleDateFormat("MM").format(hd.getNgayBan());
					String namBanHang = new SimpleDateFormat("yyyy").format(hd.getNgayBan());
					return thang.equalsIgnoreCase(thangBanHang) && nam.equalsIgnoreCase(namBanHang);
				})
				.collect(Collectors.toList());
		int tongTien = 0;
		for (DoTuanTu_HoaDon hoaDon : hoaDons) {
			List<DoTuanTu_ChiTietHoaDon> cthdList = this.nhanVienList.get(0).getChiTietHoaDonList()
					.stream()
					.filter(t -> t.getHoaDon().id == hoaDon.getId())
					.collect(Collectors.toList());
			for (DoTuanTu_ChiTietHoaDon cthd : cthdList) {
				tongTien += cthd.getGia();
			}
		}
		return tongTien;
	}

	public int thongKeDoanhThuTheoNam(String nam) {
		List<DoTuanTu_HoaDon> hoaDons = this.nhanVienList.get(0).getHoaDonList()
				.stream()
				.filter(hd -> {
					String namBanHang = new SimpleDateFormat("yyyy").format(hd.getNgayBan());
					return nam.equalsIgnoreCase(namBanHang);
				})
				.collect(Collectors.toList());
		int tongTien = 0;
		for (DoTuanTu_HoaDon hoaDon : hoaDons) {
			List<DoTuanTu_ChiTietHoaDon> cthdList = this.nhanVienList.get(0).getChiTietHoaDonList()
					.stream()
					.filter(t -> t.getHoaDon().id == hoaDon.getId())
					.collect(Collectors.toList());
			for (DoTuanTu_ChiTietHoaDon cthd : cthdList) {
				tongTien += cthd.getGia();
			}
		}
		return tongTien;
	}

	public void xoaHoaDon(int maHD) throws Exception {
		Optional<DoTuanTu_HoaDon> optHoaDon = this.nhanVienList.get(0).getHoaDonList().stream().filter(hd -> hd.getId() == maHD).findFirst();
		DoTuanTu_HoaDon hoaDon = optHoaDon.orElseThrow(() -> new Exception("Không tồn tại mã hóa đơn!!"));
		nhanVienList.get(0).getHoaDonList().remove(hoaDon);
		for (DoTuanTu_ChiTietHoaDon cthd : hoaDon.getNhanVien().getChiTietHoaDonList()) {
			nhanVienList.get(0).getChiTietHoaDonList().remove(cthd);
		}
		System.out.println("Xóa hóa đơn thành công!!");
	}
}
