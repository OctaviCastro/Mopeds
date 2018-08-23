package octavicastro.mopeds.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.List;

import octavicastro.mopeds.Model.Moped;
import octavicastro.mopeds.Operations.MopedOperations;
import octavicastro.mopeds.R;

public class PagerViewAdapter extends PagerAdapter {

    Context context;

    MopedOperations mopedOperations;

    public PagerViewAdapter(Context context, MopedOperations mopedOperations) {
        this.context = context;
        this.mopedOperations = mopedOperations;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout relativeLayoutView = (RelativeLayout) layoutInflater.inflate(R.layout.fragment_main, container, false);

        List<Moped> mopedList = mopedOperations.getMopedsBymopedCo("mopedCo" + (position + 1));

        if(mopedList.size() == 0) {
            mopedOperations.addMopeds();
            mopedList = mopedOperations.getMopedsBymopedCo("mopedCo" + (position + 1));
        }

        GridView gridView = (GridView) relativeLayoutView.findViewById(R.id.gridview);

        GridViewAdapter gridViewAdapter = new GridViewAdapter(context, mopedList);
        gridView.setAdapter(gridViewAdapter);

        container.addView(relativeLayoutView);

        return relativeLayoutView;
    }
}
