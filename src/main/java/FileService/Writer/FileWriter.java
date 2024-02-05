package FileService.Writer;


import lombok.AllArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Класс, используемый для записи данных в файлы
 */
@AllArgsConstructor
public class FileWriter {
    /**
     * Файл для записи
     */
    private File fileToWrite;
    /**
     * Массив, содержащий данные для записи
     */
    private ArrayList<String> data;

    /**
     * Метод, используемый для записи данных в файл
     */
    public void writeData() throws IOException {
        if (this.data != null && this.data.size() != 0) {
            java.io.FileWriter fileWriter = new java.io.FileWriter(this.fileToWrite, true);
            for(String value : data) {
                fileWriter.write(value);
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        }
    }
}
