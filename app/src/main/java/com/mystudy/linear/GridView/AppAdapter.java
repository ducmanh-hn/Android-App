package com.mystudy.linear.GridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mystudy.R;

import java.util.List;
import java.util.zip.Inflater;

public class AppAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<App> appList;

    public AppAdapter(Context context, int layout, List<App> appList) {
        this.context = context;
        this.layout = layout;
        this.appList = appList;
    }

    @Override
    public int getCount() {
        return appList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder ;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.nameApp);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.imageApp);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        App app = appList.get(position);
        viewHolder.name.setText(app.getName());
        viewHolder.image.setImageResource(app.getImage());

        return convertView;
    }
    private class ViewHolder{
        private ImageView image;
        private TextView name;
    }
}
