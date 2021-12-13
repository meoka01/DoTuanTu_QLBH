package dotuantu_qlbh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DoTuanTu_KhachHang {
	public static int idKH = 1;

	private int id;
	private String ten;
	private Date ngaySinh;

	public DoTuanTu_KhachHang(int id, String ten, Date ngaySinh) {
		this.id = id;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
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

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Override
	public String toString() {
		String ns = new SimpleDateFormat("dd/MM/yyyy").format(ngaySinh);
		return "Tên: " + ten + ", ngày sinh: " + ns;
	}
}
