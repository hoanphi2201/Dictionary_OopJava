# Dictionary_OopJava
Demo bài tập lớn </br>
video demo app Dictionary - 16/9/2018 <a href="https://youtu.be/QikSkKiKPYo">Click here</a></br>
video demo game runaway robot - 23/9/2018 <a href="https://youtu.be/N1iF3Z4SXVU">Click here</a></br>

- Ngày 26/9/2018 sửa chức năng thêm sửa xoá và load từ hợp lý với tốc độ nhanh từ database
khi load dữ liệu từ cơ sở dữ liệu xảy ra hiện tượng dữ liệu quá nhiều =>load chậm => giải pháp đặt thanh scroll bar (có 3 thuộc tính min max value) set max bằng số phần tử trong database (thêm hàm count database) lăn thanh scroll đến đâu load dữ liệu ra đến đó.
- Ngày 29/9/2018 sửa được chức năng khi người dùng thêm sửa 1 từ xong thì cho selected vào chính phần tử đó để cho người dùng biết vừa thêm sửa cái nào, khi thêm mà không ở cuối thì thêm xong cho chạy xuống cuối, Xử lý thêm ô textfield khi palcehoder vào thì không cần phải bắt sự kiện mouse click(thêm lớp PlaceHoserTextField).
- Ngày 30/9/2018 chia thành các packages nhỏ thêm 2 clas hỗ trợ placehoder và class bodder radius.
- Hoàn thiện phiên bản Command line cải tiến lần 1 bổ sung hàm Insertfromfile() nhập dữ liệu từ điển từ tệp dictionaries.txt.
  class DictionaryCommandline bổ sung hàm showAllwords() in ra tất cả các từ trong danh sách.
