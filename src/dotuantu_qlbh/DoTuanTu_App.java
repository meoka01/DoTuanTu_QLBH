package dotuantu_qlbh;

import java.text.SimpleDateFormat;
import java.util.*;

public class DoTuanTu_App {

    public static void main(String[] args) {
        DoTuanTu_NhanVien nhanVien = new DoTuanTu_NhanVien(1, "Nhân viên A");
        List<DoTuanTu_NhanVien> nhanVienList = new ArrayList<>();
        nhanVienList.add(nhanVien);
        DoTuanTu_QuanLy quanLy = new DoTuanTu_QuanLy(nhanVienList);

        DoTuanTu_SanPham sp1 = new DoTuanTu_SanPham(1, "Cốc", 5000);
        DoTuanTu_SanPham sp2 = new DoTuanTu_SanPham(2, "Điện thoại", 25000);
        DoTuanTu_SanPham sp3 = new DoTuanTu_SanPham(3, "Bánh mì", 3000);
        List<DoTuanTu_SanPham> sanPhamList = new ArrayList<>();
        sanPhamList.add(sp1);
        sanPhamList.add(sp2);
        sanPhamList.add(sp3);
        Scanner console = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Đỗ Tuấn Tú - CHƯƠNG TRÌNH QUẢN LÝ BÁN HÀNG TRONG SIÊU THỊ");
                System.out.print("Bạn là nhân viên hay quản lý? Nhập 1 là nhân viên, 2 là quản lý: ");
                int luaChon = Integer.parseInt(console.nextLine());
                while (true) {
                    if (luaChon == 1) {
                        System.out.println("Bạn là nhân viên, vui lòng nhập số từ 1 đến 2 tương ứng với chức năng bên dưới: ");
                        System.out.println("1. Thêm hóa đơn");
                        System.out.println("2. Hiển thị chi tiết hóa đơn");
                        System.out.println("3. Thoát");
                        int input = Integer.parseInt(console.nextLine());
                        if (input == 1) {
                            themHoaDon(console, nhanVien, sanPhamList);
                        } else if (input == 2) {
                            inHoaDon(nhanVien);
                        } else if (input == 3) {
                            break;
                        } else {
                            throw new Exception("Lựa chọn sai chức năng. Vui lòng nhập lại...");
                        }
                    } else if (luaChon == 2) {
                        System.out.println("Bạn là quản lý, vui lòng nhập số từ 1 đến 6 tương ứng với chức năng bên dưới: ");
                        System.out.println("1. Thêm hóa đơn");
                        System.out.println("2. Hiển thị chi tiết hóa đơn");
                        System.out.println("3. Xóa hóa đơn");
                        System.out.println("4. Tìm kiếm");
                        System.out.println("5. Sắp xếp");
                        System.out.println("6. Thống kê");
                        System.out.println("7. Thoát");
                        int input = Integer.parseInt(console.nextLine());
                        if (input == 1) {
                            themHoaDon(console, nhanVien, sanPhamList);
                        } else if (input == 2) {
                            inHoaDon(nhanVien);
                        } else if (input == 3) {
                            xoaHoaDon(console, quanLy);
                        } else if (input == 4) {
                            timKiemHoaDon(console, quanLy);
                        } else if (input == 5) {
                            sapXepHoaDon(console, quanLy);
                        } else if (input == 6) {
                            thongKeDoanhThu(console, quanLy);
                        } else if (input == 7) {
                            break;
                        } else {
                            throw new Exception("Lựa chọn sai chức năng. Vui lòng nhập lại...");
                        }
                    } else {
                        throw new Exception("Lựa chọn sai chức danh. Vui lòng nhập lại...");
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            console.close();
        }

    }

    private static void thongKeDoanhThu(Scanner console, DoTuanTu_QuanLy quanLy) {
        try {
            while (true) {
                System.out.println("Vui lòng nhập số tương ứng với chức năng để thực hiện thống kê ");
                System.out.println("1. Thống kê tổng doanh thu theo ngày bán hàng");
                System.out.println("2. Thống kê tổng doanh thu theo tháng");
                System.out.println("3. Thống kê tổng doanh thu theo năm");
                int so = Integer.parseInt(console.nextLine());
                if (so == 1) {
                    System.out.print("Nhập ngày cần thống kê, định dạng mm/dd/yyyy (VD: 30/01/1995): ");
                    String ngay = console.nextLine();
                    int tongTien = quanLy.thongKeDoanhThuTheoNgay(ngay);
                    System.out.println("Doanh thu theo ngày " + ngay + ", là: " + tongTien);
                } else if (so == 2) {
                    System.out.print("Nhập tháng, năm cần thống kê, định dạng mm/yyyy (VD 01/2021): ");
                    String thangNam = console.nextLine();
                    String thang = thangNam.split("/")[0];
                    String nam = thangNam.split("/")[1];
                    int tongTien = quanLy.thongKeDoanhThuTheoThang(thang, nam);
                    System.out.println("Doanh thu theo tháng " + thangNam + ", là: " + tongTien);
                } else if (so == 3) {
                    System.out.print("Nhập năm cần thống kê, định dạng yyyy (VD 2021): ");
                    String nam = console.nextLine();
                    int tongTien = quanLy.thongKeDoanhThuTheoNam(nam);
                    System.out.println("Doanh thu theo năm " + nam + ", là: " + tongTien);
                } else {
                    throw new Exception("Lựa chọn sai chức năng. Vui lòng chọn lại");
                }

                System.out.print("Bạn có muốn thực hiện tiếp không? (Y/N) ");
                String yn = console.nextLine();
                if ("N".equalsIgnoreCase(yn)) {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sapXepHoaDon(Scanner console, DoTuanTu_QuanLy quanLy) {
        try {
            while (true) {
                System.out.println("Vui lòng nhập số từ 1->2 tương ứng chức năng để thực hiện sắp xếp ");
                System.out.println("1. Sắp xếp hóa đơn theo thứ tự ngày bán hàng giảm dần");
                System.out.println("2. Sắp xếp hóa đơn theo thứ tự tổng tiền tăng dần");
                int so = Integer.parseInt(console.nextLine());
                List<DoTuanTu_HoaDon> hoaDonList;
                if (so == 1) {
                    hoaDonList = quanLy.sapXepHoaDonTheoNgayBanHang();
                } else if (so == 2) {
                    hoaDonList = quanLy.sapXepHoaDonTheoTongTien();
                } else {
                    throw new Exception("Lựa chọn sai chức năng. Vui lòng chọn lại");
                }
                System.out.println("Danh sách hóa đơn sau khi sắp xếp: ");
                quanLy.inHoaDon(hoaDonList);

                System.out.print("Bạn có muốn thực hiện tiếp không? (Y/N) ");
                String yn = console.nextLine();
                if ("N".equalsIgnoreCase(yn)) {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void timKiemHoaDon(Scanner console, DoTuanTu_QuanLy quanLy) {
        try {
            while (true) {
                System.out.println("Vui lòng nhập số từ 1->2 tương ứng chức năng để thực hiện tìm kiếm ");
                System.out.println("1. Tìm kiếm hóa đơn theo ngày");
                System.out.println("2. Tìm kiếm hóa đơn theo tên khách hàng");
                System.out.println("3. Tìm kiếm hóa đơn theo tên khách hàng và ngày bán hàng");
                int so = Integer.parseInt(console.nextLine());
                List<DoTuanTu_HoaDon> hoaDonList;
                if (so == 1) {
                    System.out.print("Nhập ngày cần tìm kiếm, định dạng mm/dd/yyyy (VD: 30/01/1995): ");
                    Date ngayBanHang = new SimpleDateFormat("dd/MM/yyyy").parse(console.nextLine());
                    hoaDonList = quanLy.timKiemHoaDonTheoNgay(ngayBanHang);
                } else if (so == 2) {
                    System.out.print("Nhập tên khách hàng : ");
                    String tenKH = console.nextLine();
                    hoaDonList = quanLy.timKiemHoaDonTheoKhachHang(tenKH);
                } else if (so == 3) {
                    System.out.print("Nhập ngày cần tìm kiếm, định dạng mm/dd/yyyy (VD: 30/01/1995): ");
                    Date ngayBanHang = new SimpleDateFormat("dd/MM/yyyy").parse(console.nextLine());
                    System.out.print("Nhập tên khách hàng : ");
                    String tenKH = console.nextLine();
                    hoaDonList = quanLy.timKiemHoaDonTheoNgayVaTenKH(ngayBanHang, tenKH);
                } else {
                    throw new Exception("Lựa chọn sai chức năng. Vui lòng chọn lại");
                }
                System.out.println("Danh sách hóa đơn sau khi tìm kiếm: ");
                quanLy.inHoaDon(hoaDonList);

                System.out.print("Bạn có muốn thực hiện tiếp không? (Y/N) ");
                String yn = console.nextLine();
                if ("N".equalsIgnoreCase(yn)) {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void xoaHoaDon(Scanner console, DoTuanTu_QuanLy quanLy) {
        try {
            while (true) {
                System.out.println("Danh sách các hóa đơn hiện tại: ");
                quanLy.inHoaDon(quanLy.getNhanVienList().get(0).getHoaDonList());
                System.out.print("Chọn mã hóa đơn cần xóa: ");
                int maHD = Integer.parseInt(console.nextLine());
                System.out.print("Bạn có muốn xóa hóa đơn này không? (Y/N) ");
                String yn = console.nextLine();
                if ("Y".equalsIgnoreCase(yn)) {
                    quanLy.xoaHoaDon(maHD);
                    System.out.print("Bạn có muốn thực hiện tiếp không? (Y/N) ");
                    yn = console.nextLine();
                    if ("N".equalsIgnoreCase(yn)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void inHoaDon(DoTuanTu_NhanVien nhanVien) {
        try {
            System.out.println("Danh sách hóa đơn hiện tại: ");
            nhanVien.inHoaDon(nhanVien.getHoaDonList());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void themHoaDon(Scanner console, DoTuanTu_NhanVien nhanVien, List<DoTuanTu_SanPham> sanPhamList) {
        try {
            while (true) {
                System.out.println("Nhập thông tin khách hàng");
                System.out.print("Nhập tên khách hàng: ");
                String ten = console.nextLine();
                System.out.print("Nhập ngày sinh, định dạng mm/dd/yyyy (VD: 30/01/1995): ");
                Date ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(console.nextLine());
                DoTuanTu_KhachHang khachHang = new DoTuanTu_KhachHang(DoTuanTu_KhachHang.idKH++, ten, ngaySinh);

                System.out.print("Nhập ngày bán hàng, định dạng mm/dd/yyyy (VD: 30/12/2021): ");
                Date ngayBanHang = new SimpleDateFormat("dd/MM/yyyy").parse(console.nextLine());
                System.out.println("Chọn loại hóa đơn theo danh sách sau: ");
                System.out.println("Mã: 1, " + DoTuanTu_HoaDon.LoaiHoaDon.HOA_DON_THUONG);
                System.out.println("Mã: 2, " + DoTuanTu_HoaDon.LoaiHoaDon.HOA_DON_VIP);
                System.out.print("Nhập mã loại hóa đơn: ");
                int idLoaiHoaDon = Integer.parseInt(console.nextLine());
                DoTuanTu_HoaDon.LoaiHoaDon loaiHoaDon;
                if (idLoaiHoaDon == 1) {
                    loaiHoaDon = DoTuanTu_HoaDon.LoaiHoaDon.HOA_DON_THUONG;
                } else if (idLoaiHoaDon == 2) {
                    loaiHoaDon = DoTuanTu_HoaDon.LoaiHoaDon.HOA_DON_VIP;
                } else {
                    throw new Exception("Không tồn tại loại hóa đơn!!");
                }

                DoTuanTu_HoaDon hoaDon;
                int giamGia = 0;
                if (loaiHoaDon == DoTuanTu_HoaDon.LoaiHoaDon.HOA_DON_THUONG) {
                    hoaDon = new DoTuanTu_HoaDonThuong(DoTuanTu_HoaDon.idHoaDon, DoTuanTu_HoaDon.maHD, ngayBanHang, khachHang, nhanVien);
                } else {
                    System.out.print("Nhập % giảm giá cho hóa đơn VIP này: ");
                    giamGia = Integer.parseInt(console.nextLine());
                    hoaDon = new DoTuanTu_HoaDonVip(DoTuanTu_HoaDon.idHoaDon, DoTuanTu_HoaDon.maHD, ngayBanHang, khachHang, nhanVien, giamGia);
                }
                DoTuanTu_HoaDon.idHoaDon++;
                double tongTien = 0;
                while (true) {
                    System.out.println("Chọn sản phẩm: ");
                    sanPhamList.forEach(p -> System.out.println("Mã : " + p.getId() + ", tên: " + p.getTen() + ", giá: " + p.getGia()));
                    System.out.print("Nhập mã sản phẩm bạn muốn chọn: ");
                    int idSanPham = Integer.parseInt(console.nextLine());
                    Optional<DoTuanTu_SanPham> optKhoa = sanPhamList.stream().filter(k -> k.getId() == idSanPham).findFirst();
                    DoTuanTu_SanPham sanPham = optKhoa.orElseThrow(() -> new Exception("Không tồn tại sản phẩm đã chọn"));

                    System.out.print("Nhập số lượng: ");
                    int soLuong = Integer.parseInt(console.nextLine());
                    int gia = soLuong * sanPham.getGia();
                    tongTien += gia;
                    System.out.println("Tổng tiền : " + gia);
                    DoTuanTu_ChiTietHoaDon chiTietHoaDon = new DoTuanTu_ChiTietHoaDon(sanPham, hoaDon, soLuong, gia);
                    nhanVien.themChiTietHoaDon(chiTietHoaDon);
                    System.out.print("Bạn có muốn thêm sản phẩm tiếp không? (Y/N) ");
                    String yn = console.nextLine();
                    if ("N".equalsIgnoreCase(yn)) {
                        break;
                    }
                }
                if (giamGia > 0) {
                    tongTien = tongTien - tongTien * giamGia / 100;
                }
                System.out.println("Tổng tiền cần thanh toán: " + tongTien);
                nhanVien.themHoaDon(hoaDon);
                nhanVien.themKhachHang(khachHang);
                System.out.println("Thêm hóa đơn thành công");
                System.out.print("Bạn có muốn thực hiện tiếp không? (Y/N) ");
                String yn = console.nextLine();
                if ("N".equalsIgnoreCase(yn)) {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}


