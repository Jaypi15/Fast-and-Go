package go.and.fast.com.fastandgo.model.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import go.and.fast.com.fastandgo.model.entity.Establishment;
import go.and.fast.com.fastandgo.model.repository.helper.DatabaseHelper;

/**
 * Created by Jay Paul on 17 Feb 2019.
 */

public class EstablishmentRepository {

    private static String TABLE_NAME = "Establishment";
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static EstablishmentRepository instance;
    Cursor cursor = null;

    public EstablishmentRepository(Context context) {
        this.openHelper = new DatabaseHelper(context);
    }

    public static EstablishmentRepository getInstance(Context context) {
        if (instance == null) {
            instance = new EstablishmentRepository(context);
        }

        return instance;
    }

    public List<Establishment> getAllEstablishments() {
        db = openHelper.getReadableDatabase();

        cursor = db.rawQuery("select * from "+TABLE_NAME, null);
        StringBuffer buffer = new StringBuffer();
        List<Establishment> establishments = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Establishment establishment = new Establishment();

                int establishmentId = Integer.parseInt(cursor.getString(0));
                String establishmentName = cursor.getString(1);
                String establishmentCode = cursor.getString(2);
                Double rating = cursor.getDouble(3);
                byte[] logo = cursor.getBlob(4);
                String type = cursor.getString(5);

                establishment.setEstablishmentId(establishmentId);
                establishment.setEstablishmentName(establishmentName);
                establishment.setEstablishmentCode(establishmentCode);
                establishment.setRating(rating);
                establishment.setLogo(logo);
                establishment.setType(type);

                establishments.add(establishment);
                cursor.moveToNext();
            }
        }


        cursor.close();
        db.close();

        return establishments;
    }

    public List<Establishment> getAllEstablishmentsByType(String establishmentType) {
        db = openHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + "  WHERE TYPE = " + "'"+establishmentType+"'", null);
        StringBuffer buffer = new StringBuffer();
        List<Establishment> establishments = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Establishment establishment = new Establishment();

                int establishmentId = Integer.parseInt(cursor.getString(0));
                String establishmentName = cursor.getString(1);
                String establishmentCode = cursor.getString(2);
                Double rating = cursor.getDouble(3);
                byte[] logo = cursor.getBlob(4);
                String type = cursor.getString(5);

                establishment.setEstablishmentId(establishmentId);
                establishment.setEstablishmentName(establishmentName);
                establishment.setEstablishmentCode(establishmentCode);
                establishment.setRating(rating);
                establishment.setLogo(logo);
                establishment.setType(type);

                establishments.add(establishment);
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return establishments;
    }

}
