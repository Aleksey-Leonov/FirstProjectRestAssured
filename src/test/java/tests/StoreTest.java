package tests;

import api.Specifications;
import org.junit.jupiter.api.Test;

public class StoreTest extends BaseTest{


    //Запросить список проданных животных findByStatus?status=sold и
    // сравнить количество согласно store/inventory параметр "sold".
    // (Размер полученного списка и параметр sold должны быть равны)
    @Test
    public void checkNumberOfAnimalsSold() {
        Specifications.installSpecification(properties.url(),200);


    }


}
