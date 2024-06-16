package Lgq_travel.springboot.Text;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

public class text1 {
    public static void main(String[] args) {
        QrCodeUtil.generate("https://4fb0-124-89-23-255.ngrok-free.app/user/test",
                300, 300, FileUtil.file("D:/桌面/二维码.jpg"));
    }
}
