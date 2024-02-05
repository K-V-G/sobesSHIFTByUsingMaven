package CollectorService.CollectorsValue;

import java.util.ArrayList;

/**
 * Интерфейс использовался, как попытка убрать жесткую связку + была попытка реализации механизма полиморфизма.
 * С одной стороны удалось, но может смогу придумать что-нибудь позже.
 */
public interface Collectors {
    void add(String arg);

    ArrayList<String> getResult();
}
