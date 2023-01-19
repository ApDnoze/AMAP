package com.example.myapplication.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ColisAdapter extends ArrayAdapter<Colis> {

    private int idPresentationLigne;

    public ColisAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Colis> objects) {
        super(context, resource, objects);
        idPresentationLigne = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View ligneView = inflater.inflate(idPresentationLigne, parent, false);

        TextView refTV = ligneView.findViewById(R.id.reference);
        TextView priceTV = ligneView.findViewById(R.id.prix);

        Colis colis = getItem(position);

        refTV.setText(colis.getReference());
        priceTV.setText((int) colis.getMontant());

        return null;
    }
}
