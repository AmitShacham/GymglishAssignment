package com.shacham.amit.gymglishtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class WebsiteListAdapter extends ArrayAdapter<Website> {

    public WebsiteListAdapter(Context context, int resource, List<Website> objects) {
        super(context, resource, objects);
    }

    private static class ViewHolder {
        private TextView itemView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.itemView = (TextView) convertView.findViewById(R.id.list_item_textview);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Website item = getItem(position);
        if (item != null) {
            viewHolder.itemView.setText(item.getName());
        }

        return convertView;
    }
}
