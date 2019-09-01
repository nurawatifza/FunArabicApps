package com.example.user.funarabicapps;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapterFamily extends BaseAdapter {
    private Context mContext;

    public ImageAdapterFamily(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            Integer width = mContext.getResources().getInteger(R.integer.character_width);
            Integer height = mContext.getResources().getInteger(R.integer.character_height);
            imageView.setLayoutParams(new GridView.LayoutParams(width, height));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 1, 0);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.definisikatagantikeduasatu, R.drawable.definisikatagantikeduadua,
            R.drawable.maksudanda, R.drawable.maksudaawak,
            R.drawable.maksudengkau, R.drawable.maksudtuanhamba,
            R.drawable.maksudtuanku, R.drawable.maksudkalian,
            R.drawable.maksudkamu,
    };
}
