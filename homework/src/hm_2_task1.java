

import java.io.*;

public class hm_2_task1 {

    //    Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//    Если значение null, то параметр не должен попадать в запрос.
//    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//    "name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"
//    В итоге должно получится select * from students where name=Ivanov, country=Russia, city=Moscow, age=null

    public static void main(String[] args) throws Exception {
        StringBuilder builder = new StringBuilder();
        try (FileReader reader = new FileReader("C:/file.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(SQL(builder));
    }

    private static String SQL(StringBuilder builder1) {
        String str = new String(builder1);
        if (str.trim().length() != 0) {
            str = str.replace(":", "=");
            str = str.replace("\"", "");
            String[] strList = str.split(", ");
            str = "select * from students where " + strList[0] + ", " + strList[1] + ", " + strList[2] + ", " + strList[3];
        } else
            str = "Файл пустой";
        return str;
    }
}
