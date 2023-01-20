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

import java.util.List;

public class AdapterListe extends ArrayAdapter<Livraison> {

    private int idPresentationLigne;

    public AdapterListe(@NonNull Context context, int resource, @NonNull List<Livraison> objects) {
        super(context, resource, objects);
        idPresentationLigne = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View ligneView = inflater.inflate(idPresentationLigne, parent, false);

        TextView tvClient = ligneView.findViewById(R.id.nomClient);
        TextView tvAdresse = ligneView.findViewById(R.id.adresseClient);

        TextView tvQuantite = ligneView.findViewById(R.id.quantite);
        TextView tvMontant = ligneView.findViewById(R.id.montant);

        Livraison livraison = getItem(position);

        tvClient.setText(livraison.getClient());
        tvAdresse.setText(livraison.getAdresse());

        tvQuantite.setText(String.valueOf(livraison.nbColis()));
        tvMontant.setText(String.valueOf(livraison.montantPrixLivraisonColis()));

        return ligneView;
    }
}

