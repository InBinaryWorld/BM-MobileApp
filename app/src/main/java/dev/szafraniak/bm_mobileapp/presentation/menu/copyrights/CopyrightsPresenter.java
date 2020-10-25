package dev.szafraniak.bm_mobileapp.presentation.menu.copyrights;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.mics.CopyrightAuthorsModel;
import lombok.Setter;

public class CopyrightsPresenter {

    @Setter
    CopyrightsView view;

    public CopyrightsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void openInBrowser(String url) {
        Uri uri = Uri.parse(url);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
        view.getActivity().startActivity(browserIntent);
    }

    public void loadData() {
        List<CopyrightAuthorsModel> authors = new ArrayList<>();
        authors.add(new CopyrightAuthorsModel("Eucalyp", "https://creativemarket.com/eucalyp"));
        authors.add(new CopyrightAuthorsModel("Freepik", "https://www.flaticon.com/authors/freepik"));
        authors.add(new CopyrightAuthorsModel("Kiranshastry", "https://www.flaticon.com/authors/kiranshastry"));
        authors.add(new CopyrightAuthorsModel("bqlqn", "https://www.flaticon.com/authors/bqlqn"));
        authors.add(new CopyrightAuthorsModel("Pixel perfect", "https://www.flaticon.com/authors/pixel-perfect"));
        authors.add(new CopyrightAuthorsModel("Smashicons", "https://smashicons.com/"));
        authors.add(new CopyrightAuthorsModel("Icongeek26", "https://www.flaticon.com/authors/icongeek26"));

        CopyrightsDataModel model = new CopyrightsDataModel();
        model.setAuthors(authors);
        model.setDeliveryBy("FlatIcon.com");
        view.setData(model);
    }
}
