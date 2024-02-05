package StatisticService;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
/**
 * Класс, используемый для генерации отчета
 */
@AllArgsConstructor
@Data
public class StatisticService {
    /**
     * Параметр вида статистики
     */
    private String statQuery;
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
     * Метод, сравнивающий вид отчета и генерирующий данный вид, исходя из сравнения
     */
    public void getStatisticByQuery() {
        if (statQuery.equals("short")) {
            ShortStatistic shortStatistic = new ShortStatistic(resultInteger, resultString, resultDouble);
            shortStatistic.makeShortStat();
        }
        else if (statQuery.equals("full")) {
            ShortStatistic shortStatistic = new ShortStatistic(resultInteger, resultString, resultDouble);
            FullStatistic fullStatistic = new FullStatistic(resultInteger, resultString, resultDouble);

            shortStatistic.makeShortStat();
            fullStatistic.makeStat();
        }
        else {
            System.out.println("А нет статистки, кто то не ввел код");
        }
    }
}
