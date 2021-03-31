package ru.geekbrains.homework8;

//        Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
//        При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//        Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
//        Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ
//                или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией,
//                в какой именно ячейке лежат неверные данные.
//        В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
//                MyArrayDataException и вывести результат расчета.

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[][] {
                {"13","2","56","25"},
                {"4","7","-55","71"},
                {"94","1","11","48"},
                {"-38","5","6","e"}
        };

        try {
            sum(array);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sum(String[][] array) {
        if (array.length != 4) throw new MyArraySizeException("Массив должен быть размером 4х4");
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new MyArraySizeException("Массив должен быть размером 4х4");
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch (RuntimeException e) { 
                    throw new MyArrayDataException("В ячейке [" + i + "]" + "[" + j + "]" + " не содержится число");
                }
            }
        }
        System.out.println("Сумма ячеек: " + sum);
        return sum;
    }

}


