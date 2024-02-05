package StatisticService;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
/**
 * Класс, используемый для генерации полного отчета
 */
@AllArgsConstructor
public class FullStatistic {
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
     * Основной метод, содержащий вызовы на методы генерации отчета
     */
    public void makeStat() {
        makeStatLong();
        makeStatDouble();
        makeStatString();
    }
    /**
     * Отчет о целых числах
     */
    public void makeStatLong() {
        Long maxValue;
        Long minValue;
        long summ;
        long middle;
        if (!resultInteger.isEmpty()) {
            maxValue = resultInteger.stream().map(Long::parseLong).toList().stream().max(Long::compare).get();
            minValue = resultInteger.stream().map(Long::parseLong).toList().stream().min(Long::compare).get();
            summ = resultInteger.stream().map(Long::parseLong).toList().stream().reduce(Long::sum).get();
            middle = summ / resultInteger.size();
            System.out.println("Целые числа: ");
            System.out.println("\t Максимальное значение:" + maxValue);
            System.out.println("\t Минимальное значение:" + minValue);
            System.out.println("\t Сумма:" + summ);
            System.out.println("\t Среднее значение:" + middle);
        }
    }
    /**
     * Отчет о числах с плавающей запятой
     */
    public void makeStatDouble() {
        Double maxValue;
        Double minValue;
        double summ;
        double middle;
        if (!resultDouble.isEmpty()) {
            maxValue = resultDouble.stream().map(Double::parseDouble).toList().stream().max(Double::compare).get();
            minValue = resultDouble.stream().map(Double::parseDouble).toList().stream().min(Double::compare).get();
            summ = resultDouble.stream().map(Double::parseDouble).toList().stream().reduce(Double::sum).get();
            middle = summ / resultDouble.size();
            System.out.println("Числа с плавающей запятой: ");
            System.out.println("\t Максимальное значение:" + maxValue);
            System.out.println("\t Минимальное значение:" + minValue);
            System.out.println("\t Сумма:" + summ);
            System.out.println("\t Среднее значение:" + middle);
        }
    }
    /**
     * Отчет о строках
     */
    public void makeStatString() {
        Integer maxValue;
        Integer minValue;
        if (!resultDouble.isEmpty()) {
            maxValue = resultString.stream().map(String::length).max(Integer::compare).get();
            minValue = resultString.stream().map(String::length).min(Integer::compare).get();

            System.out.println("Строки: ");
            System.out.println("\t Размер самой длинной:" + maxValue);
            System.out.println("\t Размер самой короткой:" + minValue);
        }
    }
}
