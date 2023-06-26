//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

public class hm_6 {
    // Создать метод, который будет имитировать работу HashSet
    public static void main(String[] args) {
        SetImitation setImitation = new SetImitation();
        System.out.println(setImitation.add(9));
        System.out.println(setImitation.add(9));
        System.out.println(setImitation.add(9));
        System.out.println(setImitation.add(8));
        System.out.println(setImitation.add(1));
        System.out.println(setImitation.delete(9));
        System.out.println(setImitation.delete(9));
        System.out.println(setImitation.size());
        System.out.println(setImitation.isEmpty());
        System.out.println(setImitation.contains(9));
        for (int i = 0; i < 10; i++) {
            setImitation.add(new Random().nextInt(1000));
        }
        Iterator<Integer> iterator = setImitation.iterator();
        while (iterator.hasNext()){
            int i = iterator.next();
            System.out.println(i + " ");
        }
        System.out.println();
        System.out.println(setImitation.geyElementByIndex(3));
        

    }
    
}

//class SetImitation{

    // ArrayList<Integer> list = new ArrayList<>();

    // Метод добавления элементов
    // вариант1
    
    /*public boolean add(int num) {
        for (int i = 0; i < list.size(); i++) {
            if(num == list.get(i)){
                return false;
            }
        }
        list.add(num);
        return true;
        
    } */

    // вариант2

    /* public boolean add(int num) {
            if(list.contains(num)){
                return false;
            }

        list.add(num);
        return true;
            
    } 
} */
    // вариант3
class SetImitation<E>{

    private HashMap<E, Object> list = new HashMap<>();

    private static final Object OBJECT = new Object();
    public boolean add(E num){
        return list.put(num, OBJECT) == null;
    }
    // метод добавления элементов
    public boolean delete(E num){
        return list.remove(num, OBJECT);
    }
    // метод определения сколько элементов находится в сет
    public int size(){
        return list.size();
    }
    // метод - пустой ли список 
    public boolean isEmpty(){
        return list.isEmpty();
    }
    // метод - есть ли в сете переданный объект
    public boolean contains(Object num){
        return list.containsKey(num);
    }
    // метод выборки данных из сета
    public Iterator<E> iterator(){
        return list.keySet().iterator();
    }
    // метод, который выбирает элемент по индексу
    public E geyElementByIndex(int index){
        E[] listArray = (E[]) list.keySet().toArray();
        return listArray[index];


    }

}

