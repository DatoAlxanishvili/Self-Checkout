package geogroup.selfcheckout;

import android.widget.BaseAdapter;

/**
 * Created by vano on 11/6/2015.
 */
public class ProductObj {
   private String name;
    private double price;


    public ProductObj(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
