package CheckerService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.ArrayList;

/**
 * Класс, используемый для реализации проверок тегов в массиве
 * передаваемых параметров и выполнении действий, если они есть
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Checker {
    /**
     * Массив файлов, из которых будут распределяться данные
     */
    private ArrayList<File> fileArray = new ArrayList<>();
    /**
     * Параметр пути для результатов. По умолчанию - пустая строка
     */
    private String oQuery = "";
    /**
     * Параметр префикса. По умолчанию - пустая строка
     */
    private String pQuery = "";
    /**
     * Режим добавления. По умолчанию - пустая строка
     */
    private String aQuery = "";
    /**
     * Вид статистики. По умолчанию - пустая строка
     */
    private String statQuery = "";

    /**
     * Метод используется для добавления в массив входных файлов наименований или путей до файлов с данными.
     * Наименования или пути - строки, происходит создание объектов файлов на основании наименования или пути.
     * Дополнительно проверяются параметры, если есть, присваиваются подходящему параметру класса
     *
     * @param args Массив входных значений, передаваемых в командной строке после запуска скомпилированного кода.
     */
    public void checkedArgs(String[] args) {
        if (args != null) {
            for (int i = 0; i < args.length;) {
                switch (args[i]) {
                    case "-o" -> {
                        oQuery = args[i + 1];
                        i = i + 2;
                    }
                    case "-p" -> {
                        pQuery = args[i + 1];
                        i = i + 2;
                    }
                    case "-a" -> {
                        aQuery = "append";
                        i++;
                    }
                    case "-s" -> {
                        statQuery = "short";
                        i++;
                    }
                    case "-f" -> {
                        statQuery = "full";
                        i++;
                    }
                    default -> {
                        fileArray.add(new File(args[i]));
                        i++;
                    }
                }
            }
        }
    }
}
