package dotuantu_qlbh;

public class DoTuanTu_SanPham {
	private int id;
	private String ten;
	private int gia;

	public DoTuanTu_SanPham(int id, String ten, int gia) {
		this.id = id;
		this.ten = ten;
		this.gia = gia;
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

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	@Override
	public String toString() {
		return "tên: " + ten + ", giá: " + gia;
	}
}
