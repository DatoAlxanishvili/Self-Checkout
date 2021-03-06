package geogroup.selfcheckout;

import android.content.Context;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class ListAdapter extends BaseAdapter {
    private ArrayList<ProductObj> product;
    private Context context;

    public ListAdapter(Context context, ArrayList<ProductObj> product) {
        this.context = context;
        this.product = product;
    }

    @Override
    public int getCount() {
        return product.size();
    }

    @Override
    public Object getItem(int position) {
        return product.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View itemView;
        viewHolder holder;
        if(convertView==null)
        {
            itemView=View.inflate(context,R.layout.list_item,null);

            final TextView priceView = (TextView) itemView.findViewById(R.id.productPrice);
            TextView nameView = (TextView) itemView.findViewById(R.id.productName);

            ImageButton btn=(ImageButton)itemView.findViewById(R.id.deleteButton);
            NumberPicker np = (NumberPicker) itemView.findViewById(R.id.numberPicker);

            holder = new viewHolder();
            holder.priceView = priceView;
            holder.nameView = nameView;
            holder.btn = btn;
            holder.np= np;


            holder.btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    product.remove(position);
                    notifyDataSetChanged();

                }
            });




            holder.np.setMaxValue(99);
            holder.np.setMinValue(1);
            holder.np.setValue(1);

            holder.np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {

                    double priceProduct = product.get(position).getPrice() * oldVal;
                    priceView.setText(String.valueOf(priceProduct));

                }
            });



            itemView.setTag(holder);

        }
        else {
            itemView=convertView;
            holder = (viewHolder) itemView.getTag();
        }



        ProductObj product = (ProductObj)getItem(position);




        /*profileImageView.setImageResource(student.getImage());*/
        holder.nameView.setText(product.getName());
        double a = product.getPrice();
        holder.priceView.setText(String.valueOf(a));


        return itemView;
    }




    private class viewHolder
    {
        TextView priceView;
        TextView nameView;
        ImageButton btn;
        NumberPicker np;
    }
}

