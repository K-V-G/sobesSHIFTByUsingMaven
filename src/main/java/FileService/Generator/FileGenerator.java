package FileService.Generator;

import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Класс, используемый для генерации итоговых файлов в соответствии с параметрами и наличием результирующих
 * данных в передаваемых параметрах в командной строке
 */
@Data
public class FileGenerator {
    /**
     * Наименование файла для записи данных типа String
     */
    private String defaultStringFileName = "strings.txt";
    /**
     * Наименование файла для записи данных типа Integer
     */
    private String defaultIntegerFileName = "integers.txt";
    /**
     * Наименование файла для записи данных типа Double
     */
    private String defaultDoubleFileName = "floats.txt";
    /**
     * Файл для записи данных типа String
     */
    private File fileString;
    /**
     * Файл для записи данных типа Integer
     */
    private File fileInteger;
    /**
     * Файл для записи данных типа Double
     */
    private File fileFloat;

    /**
     * Метод, используемый для генерации файлов, исходя из параметров пути и префикса
     *
     * @param prefics Значение префикса
     * @param path Значение пути
     */
    public void generatePathOnParam(String prefics, String path) {
        if (path.equals("")) {
            fileInteger = new File("./" + prefics + defaultIntegerFileName);
            fileFloat = new File("./" + prefics + defaultDoubleFileName);
            fileString = new File("./" + prefics + defaultStringFileName);
        }

        else {
            File dirs = new File(path);

            if (!dirs.exists()) {
                dirs.mkdirs();
            }
            fileString = new File(path + "/" + prefics + defaultStringFileName);
            fileInteger = new File(path + "/" + prefics + defaultIntegerFileName);
            fileFloat = new File(path + "/" + prefics + defaultDoubleFileName);
        }
    }

    /**
     * Метод, используемый для механизмов создания и удаления файлов исходя из параметра -a
     *
     * @param aQuery Значение -a
     * @param resultString Массив значений типа String
     * @param resultDouble Массив значений типа Double
     * @param resultInteger Массив значений типа Integer
     */
    public void operationsFileOnA(String aQuery,
                                  ArrayList<String> resultString,
                                  ArrayList<String> resultDouble,
                                  ArrayList<String> resultInteger) throws IOException {

        if (!aQuery.equals("append")) {
            if (resultString.size() != 0) {
                if (!fileString.exists()) {
                    fileString.createNewFile();
                }
                else {
                    fileString.delete();
                    fileString.createNewFile();
                }
            }
            if (resultDouble.size() != 0) {
                if (!fileFloat.exists()) {
                    fileFloat.createNewFile();
                }
                else {
                    fileFloat.delete();
                    fileFloat.createNewFile();
                }
            }
            if (resultInteger.size() != 0) {
                if (!fileInteger.exists()) {
                    fileInteger.createNewFile();
                }
                else {
                    fileInteger.delete();
                    fileInteger.createNewFile();
                }
            }
        }
        //append
        else {
            if (resultString.size() != 0) {
                if (!fileString.exists()) {
                    fileString.createNewFile();
                }
            }
            if (resultDouble.size() != 0) {
                if (!fileFloat.exists()) {
                    fileFloat.createNewFile();
                }
            }
            if (resultInteger.size() != 0) {
                if (!fileInteger.exists()) {
                    fileInteger.createNewFile();
                }
            }
        }
    }
}
