import java.io.FileReader;
import java.io.IOException;

public class hm_2_task2 {

//    Дана json-строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//    Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//    Пример вывода:
//    Студент Иванов получил 5 по предмету Математика.
//    Студент Петрова получил 4 по предмету Информатика.
//    Студент Краснов получил 5 по предмету Физика.

    public static void main(String[] args) throws Exception {
        StringBuilder builder = new StringBuilder();
        try (FileReader reader = new FileReader("C:/file2.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        SQL(builder);
    }

    private static void SQL(StringBuilder builder1) {
        String str = new String(builder1);
//        str = StandardCharsets.UTF_8.encode(str).toString();
        str = str.replace("[", ",");
        str = str.replace("]", "");
        str = str.replace("{", "");
        String[][] strmass = new String[3][3];
        if (str.trim().length() != 0) {
            String[] strList1 = str.split("}");
            for (int i = 0; i < strList1.length; i++) {
                strList1[i] = strList1[i].replace("}", "");
                String[] strList2 = strList1[i].split(",");
                for (int j = 1; j < strList2.length; j++) {
                    strmass[i][j-1] = strList2[j].substring(strList2[j].indexOf(':') + 1).replace("\"", "");
                }
                System.out.println("Студент " + strmass[i][0] + " получил " + strmass[i][1] + " по предмету " + strmass[i][2] + ".");
            }
        } else
            System.out.println("Файл пустой");
    }
}