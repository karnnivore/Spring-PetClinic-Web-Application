package ca.georgebrown.comp3074.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemArrayAdapter extends ArrayAdapter<Item> {

    private final Context context;
    private final int layoutId;
    private final int largeTextId;
    private List<Item> values;
    private final int smallTextId;
    private final int iconId;

    public ItemArrayAdapter(@NonNull Context context,
                            int resource,
                            int textViewResourceId,
                            int smallTextResourceId,
                            int iconResourceId,
                            @NonNull List<Item> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.layoutId = resource;
        this.largeTextId = textViewResourceId;
        this.values = objects;
        this.smallTextId = smallTextResourceId;
        this.iconId = iconResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(this.layoutId, parent, false);

        TextView largeText = rowView.findViewById(this.largeTextId);
        largeText.setText(this.values.get(position).getLargeText());

        TextView smallText = rowView.findViewById(this.smallTextId);
        smallText.setText(this.values.get(position).getSmallText());

        ImageView icon = rowView.findViewById(this.iconId);
        icon.setImageResource(this.values.get(position).getIcon());
        return rowView;

    }
}
