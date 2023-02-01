package com.example.myapplication;
import android.os.AsyncTask;
import android.util.Log;

import com.example.myapplication.Class.Colis;
import com.example.myapplication.Class.Livraison;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LitFichier extends AsyncTask<String, Void, Boolean> {
    private List<Livraison> lesLivraison = new ArrayList<>();
    XmlPullParser parser = null;

    @Override
    protected Boolean doInBackground(String... urls) {
        URL url;
        XmlPullParserFactory parserFactory;

        try {
            XmlPullParser parser = null;
            parserFactory = XmlPullParserFactory.newInstance();
            parser = parserFactory.newPullParser();
            url = new URL(urls[0]);
            final InputStream is = url.openStream();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            int eventType = parser.getEventType();
            Livraison livraison = null;
            Colis colis = null;

            int idLiv = 0;
            int posLiv = 0;

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String eltName = null;
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        eltName = parser.getName();
                        if ("livraison".equals(eltName)) {
                            if (livraison != null) {
                                this.lesLivraison.add(livraison);
                            }
                            livraison = new Livraison();
                            livraison.setId(idLiv);
                            idLiv++;
                            livraison.setPosition(posLiv);
                            posLiv++;
                        } else if (livraison != null) {
                            if ("client".equals(eltName)) {
                                livraison.setClient(parser.nextText());
                            } else if ("adresse".equals(eltName)) {
                                livraison.setAdresse(parser.nextText());
                            } else if ("colis".equals(eltName)) {
                                colis = new Colis();
                            } else if ("ref".equals((eltName))) {
                                colis.setReference(parser.nextText());
                            } else if ("montant".equals((eltName))) {
                                colis.setMontant(Float.parseFloat(parser.nextText()));
                                colis.setIdLivraison(livraison.getId());
                                livraison.ajouterColis(colis);
                            }
                        }
                        break;

                }
                eventType = parser.next();
            }
            this.lesLivraison.add(livraison);
        } catch (MalformedURLException | XmlPullParserException e) {
            Log.i("Dieu", e.toString());
            return false;
        } catch (IOException e) {
            Log.i("Dieu", e.toString());
            return false;
        }
        return true;
    }

    public String donneNoms() {
        String liste = "";
        for (Livraison livraison : lesLivraison)
            liste += livraison.getClient() + "\n";
        return liste;
    }

    public List<Livraison> geLivraison() {

        return lesLivraison;
    }
}
