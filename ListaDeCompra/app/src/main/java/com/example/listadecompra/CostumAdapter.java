package com.example.listadecompra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<Item> items;

    public CustomAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopping, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.itemImage);
        TextView titleTextView = convertView.findViewById(R.id.itemTitle);
        Button eliminarButton = convertView.findViewById(R.id.eliminar);

        Item item = items.get(position);
        imageView.setImageResource(item.getImageResId());
        titleTextView.setText(item.getTitle());

        eliminarButton.setOnClickListener(v -> {
            items.remove(position);
            notifyDataSetChanged(); // Actualiza la lista
        });

        return convertView;
    }
}
