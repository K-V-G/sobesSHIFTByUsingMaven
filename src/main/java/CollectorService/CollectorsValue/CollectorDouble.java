package CollectorService.CollectorsValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
/**
 * Класс, используемый для хранения данных типа Double, полученных из файлов с данными, передаваемых в запросе.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectorDouble implements Collectors {
    /**
     * Массив, который хранит данных типа Double
     */
    private ArrayList<String> resultDouble = new ArrayList<>();
    /**
     * Метод, который используется для добавления элементов в массив данных
     *
     * @param arg Значение, которое добавляется в массив
     */
    @Override
    public void add(String arg) {
        resultDouble.add(arg);
    }

    /**
     * Метод, используемый для возврата массива данных. Добавлялся когда была идея реализовать полиморфизм.
     * Так можно использовать и обычный геттер
     *
     * @return  Массив с данными типа Double
     */
    @Override
    public ArrayList<String> getResult() {
        return resultDouble;
    }
}
