package go.and.fast.com.fastandgo.model.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import go.and.fast.com.fastandgo.model.entity.Filter;
import go.and.fast.com.fastandgo.model.repository.helper.DatabaseHelper;

/**
 * Created by Jay Paul on 20 Feb 2019.
 */

public class FilterRepository {

    private static String TABLE_NAME = "Filter";
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static FilterRepository instance;
    Cursor cursor = null;

    public FilterRepository(Context context) {
        this.openHelper = new DatabaseHelper(context);
    }

    public static FilterRepository getInstance(Context context) {
        if (instance == null) {
            instance = new FilterRepository(context);
        }

        return instance;
    }

    public List<Filter> getAllFilters() {
        db = openHelper.getReadableDatabase();

        cursor = db.rawQuery("select * from "+TABLE_NAME, null);
        List<Filter> filters = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Filter filter = new Filter();

                int filterId = Integer.parseInt(cursor.getString(0));
                int establishmentId = cursor.getInt(1);
                String filterDescription = cursor.getString(2);

                filter.setFilterId(filterId);
                filter.setEstablishmentId(establishmentId);
                filter.setFilterDescription(filterDescription);

                filters.add(filter);
                cursor.moveToNext();
            }
        }


        cursor.close();
        db.close();

        return filters;
    }

    public List<Filter> getAllFiltersByEstablishmentId(int id) {
        db = openHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + "  WHERE EstablishmentId = " + id, null);
        List<Filter> filters = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Filter filter = new Filter();

                int filterId = Integer.parseInt(cursor.getString(0));
                int establishmentId = cursor.getInt(1);
                String filterDescription = cursor.getString(2);

                filter.setFilterId(filterId);
                filter.setEstablishmentId(establishmentId);
                filter.setFilterDescription(filterDescription);

                filters.add(filter);
                cursor.moveToNext();
            }
        }


        cursor.close();
        db.close();

        return filters;
    }
}
