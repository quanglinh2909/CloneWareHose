import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, CsvException, ParseException {
        ScrappingKQXS sm = new ScrappingKQXS();
        sm.getMultiDay("2022-01-01","2022-01-01");

        // Lấy tất cả dữ liệu
        // Chạy bộ lập lịch tự động lấy dữ liệu mỗi 8 giờ tối
//		sm.getMultiDay();
    }
}
