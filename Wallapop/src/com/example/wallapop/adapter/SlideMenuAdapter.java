
package com.example.wallapop.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wallapop.R;

public class SlideMenuAdapter extends BaseAdapter {

    private Context mContext;

    private int[] slideItemIcons = null;

    private TypedArray typedArray = null;

    public SlideMenuAdapter(Context context) {
        mContext = context;
        slideItemIcons = new int[] {
                R.drawable.ic_drawer_chat, R.drawable.ic_drawer_notification,
                R.drawable.ic_drawer_collection, R.drawable.ic_drawer_categories,
                R.drawable.ic_drawer_new, R.drawable.ic_drawer_invite, R.drawable.ic_drawer_support
        };
        typedArray = context.getResources().obtainTypedArray(R.array.slide_item);

    }

    @Override
    public int getCount() {
        return typedArray.length();
    }

    @Override
    public Object getItem(int position) {
        return typedArray.getText(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.slide_menu_item_layout, null);
            viewHolder.slide_menu_item_icon = (ImageView)convertView
                    .findViewById(R.id.slide_menu_item_icon);
            viewHolder.slide_menu_item_text = (TextView)convertView
                    .findViewById(R.id.slide_menu_item_text);
            viewHolder.icon_arrow = (ImageView)convertView.findViewById(R.id.icon_arrow);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.slide_menu_item_icon.setImageResource(slideItemIcons[position]);
        viewHolder.slide_menu_item_text.setText(typedArray.getText(position));
        if (typedArray.getText(position).equals(typedArray.getText(3))) {
            viewHolder.icon_arrow.setVisibility(View.VISIBLE);
        } else {
            viewHolder.icon_arrow.setVisibility(View.GONE);
        }

        return convertView;
    }

    class ViewHolder {
        ImageView slide_menu_item_icon;

        TextView slide_menu_item_text;

        ImageView icon_arrow;
    }
}
