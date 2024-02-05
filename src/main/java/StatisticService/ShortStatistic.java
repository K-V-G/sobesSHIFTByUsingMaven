package StatisticService;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
/**
 * Класс, используемый для генерации сокращенного отчета
 */
@AllArgsConstructor
public class ShortStatistic {
    /**
     * Результирующий массив, который хранит данных типа Integer
     */
    private ArrayList<String> resultInteger;
    /**
     * Результирующий массив, который хранит данных типа String
     */
    private ArrayList<String> resultString;
    /**
     * Результирующий массив, который хранит данных типа Double
     */
    private ArrayList<String> resultDouble;
    /**
     * Метод, генерирующий сокращенный отчет
     */
    public void makeShortStat() {
        System.out.println("Кол-во целых чисел в файлах:" + resultInteger.size());
        System.out.println("Кол-во чисел с плавающей запятой в файлах:" + resultDouble.size());
        System.out.println("Кол-во строк в файлах:" + resultString.size());
    }
}
