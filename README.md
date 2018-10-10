# Dictionary_OopJava
Demo bài tập lớn </br>
video demo app Dictionary - 24/9/2018 <a href="https://youtu.be/QikSkKiKPYo">Click here</a></br>
- Ngày 24/9/2018 hoàn thiện phiên bản Command line cải tiến lần 1 bổ sung hàm Insertfromfile() nhập dữ liệu từ điển từ tệp dictionaries.txt.
- Ngày 25/9/2018 hoàn thành phiên bản Command line cải tiến lần 2 có chức năng thêm, sửa, xóa dữ liệu bằng dòng lệnh. Bổ sung hàm dictionarySearcher() có chức năng tìm kiếm các từ và hàm dictionaryExportToFile() xuất dữ liệu ra file.class DictionaryCommandline bổ sung hàm showAllwords() in ra tất cả các từ trong danh sách.
- Ngày 25/9/2018 hoàn thiện phiên bản commandline với file txt.
- Ngày 26/9/2018 lên giao diện ứng dụng cơ bản bằng javaswing
- Ngày 27/9/2018 tích hợp cơ sở dữ liệu bằng mysql để lưu trữ từ điển Anh - Việt thay load từ file txt.
- Ngày 29/9/2018 sửa chức năng thêm sửa xoá và load từ hợp lý với tốc độ nhanh từ database
khi load dữ liệu từ cơ sở dữ liệu xảy ra hiện tượng dữ liệu quá nhiều =>load chậm => giải pháp đặt thanh scroll bar (có 3 thuộc tính min max value) set max bằng số phần tử trong database (thêm hàm count database) lăn thanh scroll đến đâu load dữ liệu ra đến đó.
- Ngày 30/9/2018 sửa được chức năng khi người dùng thêm sửa 1 từ xong thì cho selected vào chính phần tử đó để cho người dùng biết vừa thêm sửa cái nào, khi thêm mà không ở cuối thì thêm xong cho chạy xuống cuối, Xử lý thêm ô textfield khi palcehoder vào thì không cần phải bắt sự kiện mouse click(thêm lớp PlaceHoserTextField).
- Ngày 1/10/2018 chia thành các packages nhỏ thêm 2 clas hỗ trợ placehoder và class bodder radius. sử dụng database 140000 từ. thao tác replateAll mã HTML
- Ngày 2/10/2018 fix chức năng khi người dùng đang ở chế độ tìm kiếm và sửa từ thì sau đó phải query đến đúng từ đó load ra hiển thị trên list
- 4/10/2018 thêm chức năng xem lịch sử những từ đã xem <= 50 từ


- Tích hợp sử dụng API google translate cơ bản để tra từ, dịch đoạn văn tiếng Anh
