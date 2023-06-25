


import java.util.HashMap;
import java.util.Random;

//Создать словарь с ключом число и значением - случайное число. 
// Вывести в консоль только пары в которых значение кратно двум!
public class seminar5 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = map1();
        System.out.println(map);
        for (int i: map.values()) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }


    }
    public static HashMap<Integer,Integer> map1(){
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for (int i = 0; i < 10; i++){
            map1.put(i, new Random().nextInt(10));

        }
        return map1;
    }

}







// Создать два словаря, ключи это случайные числа до 25 а значения первого списка мужские имена 
// а второго женские. Вывести в консоль сумму значений только пар у которых есть ключ в обоих словарях.