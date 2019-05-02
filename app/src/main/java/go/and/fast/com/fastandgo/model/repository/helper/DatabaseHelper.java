package go.and.fast.com.fastandgo.model.repository.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Jay Paul on 11 Feb 2019.
 *
 * THIS IS TEMPORARY WE WILL HAVE A SERVER WHEN THE APP IS RELEASED
 */

public class DatabaseHelper extends SQLiteAssetHelper{

    private static final String DATABASE_NAME = "FastAndGo.db";
    private static final int DATABASE_VERSION = 3;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}
