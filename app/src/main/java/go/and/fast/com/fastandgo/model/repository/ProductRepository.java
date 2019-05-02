package go.and.fast.com.fastandgo.model.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import go.and.fast.com.fastandgo.model.entity.Product;
import go.and.fast.com.fastandgo.model.repository.helper.DatabaseHelper;

/**
 * Created by Jay Paul on 17 Feb 2019.
 */

public class ProductRepository {

    private static final String TABLE_NAME = "Product";
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static ProductRepository instance;
    private Cursor cursor = null;

    public ProductRepository(Context context) {
        this.openHelper = new DatabaseHelper(context);
    }

    public static ProductRepository getInstance(Context context) {
        if (instance == null) {
            instance = new ProductRepository(context);
        }

        return instance;
    }

    public List<Product> getAllProdcuts() {
        db = openHelper.getReadableDatabase();

        cursor = db.rawQuery("select * from "+TABLE_NAME, null);
        List<Product> products = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Product product = new Product();

                int productId = Integer.parseInt(cursor.getString(0));
                int establishmentId = cursor.getInt(1);
                String productName = cursor.getString(2);
                double price = cursor.getDouble(3);
                byte[] productImg = cursor.getBlob(4);
                String description = cursor.getString(5);
                String productCode = cursor.getString(6);
                boolean isNeededPrescription = cursor.getInt(7) > 0;

                product.setEstablishmentId(establishmentId);
                product.setEstablishmentId(establishmentId);
                product.setProductName(productName);
                product.setPrice(price);
                product.setProductImage(productImg);
                product.setDescription(description);
                product.setProductCode(productCode);
                product.setIsNeededPrescription(isNeededPrescription);

                products.add(product);
                cursor.moveToNext();
            }
        }


        cursor.close();
        db.close();

        return products;
    }

    public List<Product> getAllProductsByEstablishmentId(int id) {
        db = openHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + "  WHERE EstablishmentId = " + id, null);
        List<Product> products = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Product product = new Product();

                int productId = Integer.parseInt(cursor.getString(0));
                int establishmentId = cursor.getInt(1);
                String productName = cursor.getString(2);
                double price = cursor.getDouble(3);
                byte[] productImg = cursor.getBlob(4);
                String description = cursor.getString(5);
                String productCode = cursor.getString(6);
                boolean isNeededPrescription = cursor.getInt(7) > 0;

                product.setProductId(productId);
                product.setEstablishmentId(establishmentId);
                product.setProductName(productName);
                product.setPrice(price);
                product.setProductImage(productImg);
                product.setDescription(description);
                product.setProductCode(productCode);
                product.setIsNeededPrescription(isNeededPrescription);

                products.add(product);
                cursor.moveToNext();
            }
        }


        cursor.close();
        db.close();

        return products;
    }
}
