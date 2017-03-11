package pl.databasejpa.utils;

import pl.databasejpa.entities.Dictionary;
import pl.databasejpa.entities.Records;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author damia
 */
public class DictionaryCreator {

    public static List<Dictionary> createDictionaries(int dicNumber, int recNumber) {
        List<Dictionary> dicList = new ArrayList<>();

        for (int i = 0; i < dicNumber; i++) {
            List<Records> records = new ArrayList<>();
            Dictionary dic = new Dictionary();
            dic.setName("NAME" + i);
            dic.setDescription("DESC" + i);

            for (int j = 0; j < recNumber; j++) {
                Records r = new Records();
                r.setDicId(dic);
                r.setCode("CODE" + j);
                r.setValue("VALUE" + j);
                records.add(r);
            }
            dic.setRecordsList(records);
            dicList.add(dic);
        }
        return dicList;
    }

}
