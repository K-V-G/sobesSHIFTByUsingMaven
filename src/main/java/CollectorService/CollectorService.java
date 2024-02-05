package CollectorService;

import CollectorService.CollectorsValue.CollectorDouble;
import CollectorService.CollectorsValue.Collectors;
import CollectorService.CollectorsValue.CollectorsInteger;
import CollectorService.CollectorsValue.CollectorsString;
import lombok.Data;

import java.io.File;
import java.util.List;
import java.util.Scanner;
/**
 * Класс, используемый для реализации обработки данных входящих файлов с данными и распределение их по
 * массивам с определенным типом (по сути, по объектам, в которых есть эти массивы)
 */
@Data
public class CollectorService {
    /**
     * Объект данных типа Double
     *
     * @see CollectorDouble
     */
    private Collectors collectorDouble = new CollectorDouble();
    /**
     * Объект данных типа Integer
     *
     * @see CollectorsInteger
     */
    private Collectors collectorsInteger = new CollectorsInteger();
    /**
     * Объект данных типа String
     *
     * @see CollectorsString
     */
    private Collectors collectorsString = new CollectorsString();

    /**
     * Метод, используемый для обработки данных и распределение их по массивам внутри объектов
     *
     * @param filesData Массив входных файлов
     * @throws Exception Обработка отсутствия входных файлов
     */
    public void collectData(List<File> filesData) throws Exception {
        if (filesData  == null || filesData.isEmpty()) {
            throw new Exception("Не указаны файлы для сбора данных");
        }
        for (File file : filesData) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String lines = scanner.nextLine();
                if (isNumber(lines.trim())) {
                    collectorsInteger.add(lines.trim());
                }
                else if (isDouble(lines.trim())) {
                    collectorDouble.add(lines.trim());
                }
                else {
                    collectorsString.add(lines.trim());
                }
            }
        }
    }

    /**
     * Метод, который используется для проверки, является ли тип передаваемого значения целочисленным
     *
     * @param str Значение для проверки
     */
    public static boolean isNumber(String str) {
        try {
            Long.parseLong(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    /**
     * Метод, который используется для проверки, является ли тип передаваемого значения дробным
     * (с плавающей запятой, с фиксированной запятой)
     *
     * @param str Значение для проверки
     */
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
