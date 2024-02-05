package CollectorService.CollectorsValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
/**
 * Класс, используемый для хранения данных типа String, полученных из файлов с данными, передаваемых в запросе.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectorsString implements Collectors {
    /**
     * Массив, который хранит данных типа String
     */
    private ArrayList<String> resultString = new ArrayList<>();
    /**
     * Метод, который используется для добавления элементов в массив данных
     *
     * @param arg Значение, которое добавляется в массив
     */
    @Override
    public void add(String arg) {
        resultString.add(arg);
    }
    /**
     * Метод, используемый для возврата массива данных. Добавлялся когда была идея реализовать полиморфизм.
     * Так можно использовать и обычный геттер
     *
     * @return  Массив с данными типа String
     */
    @Override
    public ArrayList<String> getResult() {
        return resultString;
    }
}
