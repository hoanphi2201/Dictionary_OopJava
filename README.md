# Dictionary_OopJava
Demo bài tập lớn </br>
video demo app Dictionary - 16/9/2018 <a href="https://youtu.be/QikSkKiKPYo">Click here</a></br>
video demo game runaway robot - 23/9/2018 <a href="https://youtu.be/N1iF3Z4SXVU">Click here</a></br>

Ngày 26/9/2018 sửa chức năng thêm sửa xoá và load từ hợp lý với tốc độ nhanh từ database
- khi load dữ liệu từ cơ sở dữ liệu xảy ra hiện tượng dữ liệu quá nhiều =>load chậm => giải pháp đặt thanh scroll bar (có 3 thuộc tính min max value) set max bằng số phần tử trong database (thêm hàm count database) lăn thanh scroll đến đâu load dữ liệu ra đến đó
## game Dò mìn (Minesweeper)
–   Có mìn: được đặt ngẫu nhiên lúc khởi tạo
–   Đã mở: Khi người dùng nhấn chuột trái vào ô
–   Được cắm cờ: Khi người dùng nhấn phải vào ô
–   Được đánh dấu: Khi nhấn phải vào ô đã được “cắm cờ”
–   Bình thường: không có tất cả các trạng thái trên
Các trường hợp khi mở một ô
Khi mở một ô X nào đó, có 3 trường hợp có thể xảy ra:
-   X có mìn: hiện tất cả mìn trong bảng ra và ‘game over’.
-   X không có mìn nhưng 8 ô xung quanh có mìn: hiện số mìn xung quanh vào X.
-   X không có mìn và xung quanh cũng không có mìn: mở lần lượt các ô xung quanh X cho đến khi gặp các trường hợp 1 và 2.
