package dev.szafraniak.bm_mobileapp.presentation.menu.activity;

import dev.szafraniak.bm_mobileapp.presentation.BaseView;

public interface MenuView extends BaseView {

    void logout();

    void setData(String data);
}
