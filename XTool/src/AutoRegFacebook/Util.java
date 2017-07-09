package AutoRegFacebook;

import java.util.Random;

/**
 * Created by Administrator on 06/12/2016.
 */
public class Util {
    public static final String List_First_Name[]={
            "Bùi","Cao","Chu","Chung","Chương","Cù","Diệp","Doãn","Dương","Đào","Đặng","Đậu","Đinh","Điền","Đoàn","Đỗ","Đường","Giang","Giao","Giáp","Giả","Hoàng","Huỳnh","Hà","Hạ","Hồ","Hồng","Hứa","Khương","Khổng","Kim","Kiều","La","Lã","Lê","Lô","Lý","Lưu","Lương","Mai","Mạc","Nguyễn","Nông","Ong","Phan","Phùng","Phương","Phạm","Quách","Thái","Tiêu","Triệu","Trương","Trần","Trịnh","Tô","Tăng","Tạ","Tống","Từ","Võ","Vũ","Vương"
    };
    public static final String List_Last_Name[]={
            "An","Anh","Bình","Bích","Băng","Bạch","Bảo","Ca","Chi","Chinh","Chiêu","Chung","Châu","Cát","Cúc","Cương","Cầm","Dao","Di","Diễm","Diệp","Diệu","Du","Dung","Duyên","Dân","Dương","Giang","Giao","Hiếu","Hiền","Hiệp","Hoa","Hoan","Hoài","Hoàn","Huyền","Huệ","Hà","Hân","Hòa","Hương","Hường","Hạ","Hạnh","Hải","Hảo","Hậu","Hằng","Hồng","Hợp","Khai","Khanh","Khuyên","Khuê","Khánh","Khê","Khôi","Kim","Kiều","Lam","Lan","Linh","Liên","Liễu","Loan","Ly","Lâm","Lý","Lễ","Lệ","Lộc","Lợi","Mai","Mi","Minh","Miên","My","Mẫn","Mỹ","Nga","Nghi","Nguyên","Nguyệt","Ngà","Ngân","Ngôn","Ngọc","Nhi","Nhiên","Nhung","Nhàn","Nhân","Nhã","Như","Nương","Nữ","Oanh","Phi","Phong","Phúc","Phương","Phước","Phượng","Phụng","Quyên","Quân","Quế","Quỳnh","Sa","San","Sinh","Sương","Thanh","Thảo","Thi","Thiên","Thiện","Thoa","Thoại","Thu","Thuần","Thuận","Thy","Thêu","Thùy","Thúy","Thơ","Thư","Thương","Thường","Thảo","Thắm","Thục","Thủy","Tiên","Trang","Trinh","Trung","Trà","Trâm","Trân","Trúc","Trầm","Tuyến","Tuyết","Tuyền","Tuệ","Ty","Tâm","Tú","Uyên","Uyển","Vi","Việt","Vy","Vân","Vũ","Vọng","Vỹ","Xuyến","Xuân","Yên","Yến","Ái","Ánh","Ân","Đan","Điệp","Đoan","Đài","Đàn","Đào","Đình","Đường","Đan","Ý"
    };

    public static int randInt(int min, int max) {
        // Usually this can be a field rather than a method variable
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}
