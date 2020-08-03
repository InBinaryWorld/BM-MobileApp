package dev.szafraniak.bm_mobileapp.business.navigation;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.util.HashMap;
import java.util.Map;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.ModifyCompanyFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactsFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancesFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.resources.ResourcesFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.settings.SettingsFragment_;


public abstract class FragmentFactory {
    public static final int FRAGMENT_DASHBOARD_ID = 100;
    public static final int FRAGMENT_CONTACTS_ID = 200;
    public static final int FRAGMENT_RESOURCES_ID = 300;
    public static final int FRAGMENT_FINANCES_ID = 400;
    public static final int FRAGMENT_SETTINGS_ID = 500;
    public static final int FRAGMENT_SETTINGS_COMPANY_ID = 501;

    public static final Map<Integer, Integer> menuMap = new HashMap<Integer, Integer>() {{
        put(R.id.menu_dashboard, FRAGMENT_DASHBOARD_ID);
        put(R.id.menu_contacts, FRAGMENT_CONTACTS_ID);
        put(R.id.menu_resources, FRAGMENT_RESOURCES_ID);
        put(R.id.menu_finances, FRAGMENT_FINANCES_ID);
        put(R.id.menu_settings, FRAGMENT_SETTINGS_ID);
    }};


    public static Fragment getFragmentById(int fragmentId) {
        Fragment fragment;

        switch (fragmentId) {
            case FRAGMENT_DASHBOARD_ID:
                fragment = new DashboardFragment_();
                break;
            case FRAGMENT_CONTACTS_ID:
                fragment = new ContactsFragment_();
                break;
            case FRAGMENT_RESOURCES_ID:
                fragment = new ResourcesFragment_();
                break;
            case FRAGMENT_FINANCES_ID:
                fragment = new FinancesFragment_();
                break;
            case FRAGMENT_SETTINGS_ID:
                fragment = new SettingsFragment_();
                break;
            case FRAGMENT_SETTINGS_COMPANY_ID:
                fragment = new ModifyCompanyFragment_();
                break;
            default:
                throw new Resources.NotFoundException("Not found fragment with id: " + fragmentId);
        }

        fragment.setArguments(new Bundle());
        return fragment;
    }

    public static int parseMenuIdToFragmentId(Integer menuId) {
        return menuMap.get(menuId);
    }

    public static int getMainId() {
        return FRAGMENT_DASHBOARD_ID;
    }

}
