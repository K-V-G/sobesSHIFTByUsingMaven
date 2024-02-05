package CollectorService.CollectorsValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
/**
 * Класс, используемый для хранения данных типа Integer, полученных из файлов с данными, передаваемых в запросе.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectorsInteger implements Collectors {
    /**
     * Массив, который хранит данных типа Integer
     */
    private ArrayList<String> resultInteger = new ArrayList<>();
    /**
     * Метод, который используется для добавления элементов в массив данных
     *
     * @param arg Значение, которое добавляется в массив
     */
    @Override
    public void add(String arg) {
        resultInteger.add(arg);
    }
    /**
     * Метод, используемый для возврата массива данных. Добавлялся когда была идея реализовать полиморфизм.
     * Так можно использовать и обычный геттер
     *
     * @return  Массив с данными типа Integer
     */
    @Override
    public ArrayList<String> getResult() {
        return resultInteger;
    }
}
