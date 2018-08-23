package octavicastro.mopeds.Operations;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import octavicastro.mopeds.Model.Moped;
import octavicastro.mopeds.R;

public class MopedOperations {

    private Realm realm;

    public MopedOperations(Realm realm) {
        this.realm = realm;
    }

    public void addMopeds() {

        //realm.beginTransaction();

        Integer [] imageIDs = {
                R.drawable.moped1, R.drawable.moped2, R.drawable.moped3, R.drawable.moped4, R.drawable.moped5,
                R.drawable.moped6, R.drawable.moped7, R.drawable.moped8, R.drawable.moped9, R.drawable.moped10,
                R.drawable.moped11, R.drawable.moped12, R.drawable.moped13, R.drawable.moped14, R.drawable.moped15,
                R.drawable.moped16, R.drawable.moped17, R.drawable.moped18, R.drawable.moped19, R.drawable.moped20
                };

        for(int i = 0; i < 20; i++) {
            if (i < 10) {
                addMoped(i, "moped" + (i + 1), "mopedCo1", imageIDs[i]);
            } else {
                addMoped(i, "moped" + (i - 9), "mopedCo2", imageIDs[i]);
            }
        }

        //realm.commitTransaction();
    }

    private void addMoped(int id, String name, String company, int imageName) {

        realm.beginTransaction();

        Moped m = realm.createObject(Moped.class, id);
        m.setName(name);
        m.setCompany(company);
        m.setImage(imageName);

        realm.commitTransaction();
    }

    public Moped[] getMopeds() {

        RealmResults<Moped> mopedList = realm.where(Moped.class).findAll();

        return mopedList.toArray(new Moped[mopedList.size()]);
    }

    public List<Moped> getMopedsBymopedCo(String mopedCo) {
        List<Moped> mopedList = (List<Moped>) realm.where(Moped.class).equalTo("company", mopedCo).findAll();

        return mopedList;
    }

    public void deleteAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }
}
