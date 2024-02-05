import CheckerService.Checker;
import CollectorService.CollectorService;
import FileService.Generator.FileGenerator;
import FileService.Writer.FileWriter;
import StatisticService.StatisticService;

/**
 * Главный класс проекта
 */
public class Main {
    /**
     * Запускающий метод
     *
     * @param args Параметры, передаваемые при вызове скомпилированного кода
     */
    public static void main(String[] args) throws Exception {
        Checker checker = new Checker();
        checker.checkedArgs(args);

        CollectorService collectorService = new CollectorService();
        collectorService.collectData(checker.getFileArray());

        FileGenerator fileGenerator = new FileGenerator();
        fileGenerator.generatePathOnParam(checker.getPQuery(), checker.getOQuery());
        fileGenerator.operationsFileOnA(
                checker.getAQuery(),
                collectorService.getCollectorsString().getResult(),
                collectorService.getCollectorDouble().getResult(),
                collectorService.getCollectorsInteger().getResult()
        );

        FileWriter fileWriterString = new FileWriter(fileGenerator.getFileString(),
                collectorService.getCollectorsString().getResult());
        FileWriter fileWriterInteger = new FileWriter(fileGenerator.getFileInteger(),
                collectorService.getCollectorsInteger().getResult());
        FileWriter fileWriterDouble = new FileWriter(fileGenerator.getFileFloat(),
                collectorService.getCollectorDouble().getResult());

        fileWriterString.writeData();
        fileWriterInteger.writeData();
        fileWriterDouble.writeData();

        StatisticService statisticService = new StatisticService(
                checker.getStatQuery(),
                collectorService.getCollectorsInteger().getResult(),
                collectorService.getCollectorsString().getResult(),
                collectorService.getCollectorDouble().getResult());
        statisticService.getStatisticByQuery();
    }
}
