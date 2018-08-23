package octavicastro.mopeds.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import octavicastro.mopeds.Model.Moped;
import octavicastro.mopeds.R;

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private List<Moped> mopedList;

    public GridViewAdapter(Context context, List<Moped> mopedList) {
        this.context = context;
        this.mopedList = mopedList;
    }

    @Override
    public int getCount() {
        return mopedList.size();
    }

    @Override
    public Object getItem(int position) {
        return mopedList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mopedList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            convertView =  inflater.inflate(R.layout.moped_grid, null);
        }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.moped_grid_image);
            imageView.setAdjustViewBounds(true);
            TextView textView = (TextView) convertView.findViewById(R.id.moped_grid_name);

            textView.setText((CharSequence) mopedList.get(position).getName());
            imageView.setImageResource(mopedList.get(position).getImage());


        return convertView;
    }
}

