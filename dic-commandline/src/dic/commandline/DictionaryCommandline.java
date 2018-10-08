package dic.commandline;

import java.util.*;

public class DictionaryCommandline {

    public void dictionaryBasic() {

    }

    public void dictionaryAdvanced() {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DictionaryManagement DicMana = new DictionaryManagement();
        DicMana.insertFromFile();
        int option;
        do {
            System.out.println("---------Từ điển Anh - Việt----------");
            System.out.println("------------Nhập lựa chọn------------");
            System.out.println("1. Tra từ");
            System.out.println("2. Thêm từ");
            System.out.println("3. Sửa từ");
            System.out.println("4. Xóa từ");
            System.out.println("5. In tất cả các từ trong từ điển");
            System.out.println("6. Kết thúc");
            System.out.println("-------------------------------------");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    DicMana.dictionarySearcher();
                    break;
                case 2:
                    DicMana.insertFromCommandline();
                    break;
                case 3:
                    DicMana.editWordInDic();
                    break;
                case 4:
                    DicMana.deleteWordInDic();
                    break;
                case 5:
                    DicMana.showAllWords();
                    break;
            }
            DicMana.dictionaryExportToFile();

        } while (option >= 1 && option <= 5);
    }

}
