package com.example.examentp2;
// CustomAdapter.java
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] itemNames;
    private final int[] itemImages;

    public CustomAdapter(Context context, String[] itemNames, int[] itemImages) {
        super(context, R.layout.list_item, itemNames);
        this.context = context;
        this.itemNames = itemNames;
        this.itemImages = itemImages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView textView = rowView.findViewById(R.id.item_text);
        ImageView imageView = rowView.findViewById(R.id.item_image);

        textView.setText(itemNames[position]);
        imageView.setImageResource(itemImages[position]);

        return rowView;
    }
}
