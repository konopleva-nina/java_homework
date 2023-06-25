import java.util.*;


// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

public class hm_5 {

    public static void main(String[] args) {
        HashMap<String, String> phonebook = new HashMap<>();
        ArrayList<Integer> tel = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        HashMap<String, String> newphonebook = new HashMap<>();
        HashSet<String> Set = new HashSet<>();
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Сколько номеров телефонов хотите внести?");
        int n = scanner1.nextInt();
        System.out.println("Введите номера "+ n +" телефонов и их владельцев");
        int s=0;
        while (s < n) {
            System.out.println("Введите номер телефона (8 цифр) и нажмите ENTER");
            String str1 = scanner2.nextLine();
            System.out.println("Введите имя владельца телефона и нажмите ENTER: ");
            String str2 = scanner3.nextLine();
            phonebook.put(str1,str2);
            s++;
        }
        for (String i : phonebook.values()) {
            Set.add(i);
        }
        for (String i : phonebook.values()) {
            if (Set.contains(i)) {
                newphonebook.put(i, null);
                Set.remove(i);
            }
        }
        for (String j : phonebook.keySet()) {
            if (phonebook.containsValue(phonebook.get(j))) {
                newphonebook.replace(phonebook.get(j), newphonebook.get(phonebook.get(j)), newphonebook.get(phonebook.get(j)) + "; " + j);
            }
        }
        for (String i : newphonebook.keySet()) {
            newphonebook.replace(i, newphonebook.get(i), newphonebook.get(i).substring(5, newphonebook.get(i).length()));
        }
        System.out.println("Имена владельцев с номерами телефонов: ");
        for (String i : newphonebook.keySet()) {
            name.add(i);
            tel.add(newphonebook.get(i).length());
        }

        for (int i = 0; i < tel.size() - 1; i++) {
            for (int j = i + 1; j < tel.size(); j++) {
                if (Integer.parseInt(String.valueOf(tel.get(j))) > Integer.parseInt(String.valueOf(tel.get(i)))) {
                    Collections.swap(name, i, j);
                }
            }
        }
        for (int j = 0; j < tel.size(); j++) {
            for (String i : newphonebook.keySet()) {
                if (i == name.get(j)) {
                    System.out.println("" + i + " с номерами " + newphonebook.get(i));
                }
            }
        }
        scanner1.close();
        scanner2.close();
        scanner3.close();
    }

}


