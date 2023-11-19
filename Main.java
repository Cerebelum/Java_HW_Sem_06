// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков. Написать метод, который будет запрашивать у пользователя критерий
// (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
// Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить
// параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

package HW.Sem_06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(Brand.Acer, Color.Black, 4);
        Laptop laptop2 = new Laptop(Brand.Lenovo, Color.Gray, 8);
        Laptop laptop3 = new Laptop(Brand.Sony, Color.White, 16);
        Laptop laptop4 = new Laptop(Brand.Acer, Color.Black, 16);
        Laptop laptop5 = new Laptop(Brand.Mac, Color.Gray, 16);
        Laptop laptop6 = new Laptop(Brand.Lenovo, Color.Black, 8);
        Laptop laptop7 = new Laptop(Brand.Lenovo, Color.Black, 8); // повторяющийся объект для проверки

        HashSet<Laptop> laptopSet = new HashSet<>(Arrays.asList(laptop1, laptop2,
                laptop3, laptop4, laptop5, laptop6, laptop7));

        System.out.println("Полный список ноутбуков (Set без повторов)");
        for (Laptop laptop : laptopSet) {
            System.out.println(laptop);
        }
        System.out.println();
        printFiltered(laptopSet, getFilter());

    }

    public static Map<Integer, String> getFilter() {
        Map<Integer, String> filterMap = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберите критерий фильтрации (введите цифру):\n1 - бренд\n2 - цвет\n3 - ОЗУ\n");
        int input = scan.nextInt();
        if (input == 1) {
            System.out.println("Введите название бренда: ");
            filterMap.put(input, scan.next());
        } else if (input == 2) {
            System.out.println("Введите цвет: ");
            filterMap.put(input, scan.next());
        } else if (input == 3) {
            System.out.println("Введите минимальное значение ОЗУ: ");
            filterMap.put(input, scan.next());
        } else {
            System.out.println("Неправильный ввод");
        }
        scan.close();
        // System.out.println(filterMap);
        return filterMap;
    }

    public static void printFiltered(HashSet<Laptop> laptopSet, Map<Integer, String> filterMap) {
        for (Map.Entry<Integer, String> entry : filterMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            switch (key) {
                case 1:
                    for (Laptop laptop : laptopSet) {
                        if (laptop.brand.toString().equalsIgnoreCase(value))
                        System.out.println(laptop);
                    }
                    break;
                case 2:
                    for (Laptop laptop : laptopSet) {
                        if (laptop.color.toString().equalsIgnoreCase(value))
                        System.out.println(laptop);
                    }
                    break;
                case 3:
                    for (Laptop laptop : laptopSet) {
                        if (laptop.ram >= Integer.parseInt(value))
                        System.out.println(laptop);
                    }
                    break;
                default:
                    System.out.println("Ошибка!");
                    break;
            }
        }
    }
}
