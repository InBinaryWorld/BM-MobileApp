package dev.szafraniak.bm_mobileapp.business.navigation;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.util.HashMap;
import java.util.Map;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.company.create.CompanyCreateFragment_;
import dev.szafraniak.bm_mobileapp.presentation.company.list.CompanyListFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.ModifyCompanyFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactsFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.CompanyContactListFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create.CompanyContactCreateFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details.CompanyContactDetailsFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify.CompanyContactModifyFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.IndividualContactListFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create.IndividualContactCreateFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details.IndividualContactDetailsFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify.IndividualContactModifyFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancesFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.ProductsListFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.create.ProductModelCreateFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.details.ProductModelDetailsFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.modify.ProductModelModifyFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.resources.ResourcesFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.settings.SettingsFragment_;
import dev.szafraniak.bm_mobileapp.presentation.shared.result.ActionStatusFragment_;


public abstract class FragmentFactory {
    public static final int FRAGMENT_COMPANY_LIST_ID = 10;
    public static final int FRAGMENT_COMPANY_CREATE_ID = 11;
    public static final int FRAGMENT_DASHBOARD_ID = 100;
    public static final int FRAGMENT_CONTACTS_ID = 200;
    public static final int FRAGMENT_INDIVIDUAL_CONTACT_LIST_ID = 210;
    public static final int FRAGMENT_INDIVIDUAL_CONTACT_CREATE_ID = 211;
    public static final int FRAGMENT_INDIVIDUAL_CONTACT_MODIFY_ID = 212;
    public static final int FRAGMENT_INDIVIDUAL_CONTACT_DETAILS_ID = 213;
    public static final int FRAGMENT_COMPANY_CONTACT_LIST_ID = 220;
    public static final int FRAGMENT_COMPANY_CONTACT_CREATE_ID = 221;
    public static final int FRAGMENT_COMPANY_CONTACT_MODIFY_ID = 222;
    public static final int FRAGMENT_COMPANY_CONTACT_DETAILS_ID = 223;
    public static final int FRAGMENT_RESOURCES_ID = 300;
    public static final int FRAGMENT_FINANCES_ID = 400;
    public static final int FRAGMENT_SETTINGS_ID = 500;
    public static final int FRAGMENT_SETTINGS_COMPANY_ID = 501;
    public static final int FRAGMENT_ACTION_STATUS = 600;
    public static final int FRAGMENT_PRODUCT_MODEL_LIST = 700;
    public static final int FRAGMENT_PRODUCT_MODEL_MODIFY = 701;
    public static final int FRAGMENT_PRODUCT_MODEL_CREATE = 702;
    public static final int FRAGMENT_PRODUCT_MODEL_DETAILS = 703;

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
            case FRAGMENT_COMPANY_CREATE_ID:
                fragment = new CompanyCreateFragment_();
                break;
            case FRAGMENT_COMPANY_LIST_ID:
                fragment = new CompanyListFragment_();
                break;
            case FRAGMENT_DASHBOARD_ID:
                fragment = new DashboardFragment_();
                break;
            case FRAGMENT_CONTACTS_ID:
                fragment = new ContactsFragment_();
                break;
            case FRAGMENT_INDIVIDUAL_CONTACT_LIST_ID:
                fragment = new IndividualContactListFragment_();
                break;
            case FRAGMENT_INDIVIDUAL_CONTACT_CREATE_ID:
                fragment = new IndividualContactCreateFragment_();
                break;
            case FRAGMENT_INDIVIDUAL_CONTACT_MODIFY_ID:
                fragment = new IndividualContactModifyFragment_();
                break;
            case FRAGMENT_INDIVIDUAL_CONTACT_DETAILS_ID:
                fragment = new IndividualContactDetailsFragment_();
                break;
            case FRAGMENT_COMPANY_CONTACT_LIST_ID:
                fragment = new CompanyContactListFragment_();
                break;
            case FRAGMENT_COMPANY_CONTACT_CREATE_ID:
                fragment = new CompanyContactCreateFragment_();
                break;
            case FRAGMENT_COMPANY_CONTACT_MODIFY_ID:
                fragment = new CompanyContactModifyFragment_();
                break;
            case FRAGMENT_COMPANY_CONTACT_DETAILS_ID:
                fragment = new CompanyContactDetailsFragment_();
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
            case FRAGMENT_ACTION_STATUS:
                fragment = new ActionStatusFragment_();
                break;
            case FRAGMENT_PRODUCT_MODEL_LIST:
                fragment = new ProductsListFragment_();
                break;
            case FRAGMENT_PRODUCT_MODEL_MODIFY:
                fragment = new ProductModelModifyFragment_();
                break;
            case FRAGMENT_PRODUCT_MODEL_CREATE:
                fragment = new ProductModelCreateFragment_();
                break;
            case FRAGMENT_PRODUCT_MODEL_DETAILS:
                fragment = new ProductModelDetailsFragment_();
                break;
            default:
                throw new Resources.NotFoundException("Not found fragment with id: " + fragmentId);
        }

        fragment.setArguments(new Bundle());
        return fragment;
    }

    @SuppressWarnings("ConstantConditions")
    public static int parseMenuIdToFragmentId(Integer menuId) {
        return menuMap.get(menuId);
    }

    public static int getCompanyMainFragmentId() {
        return FRAGMENT_COMPANY_LIST_ID;
    }

    public static int getMenuMainFragmentId() {
        return FRAGMENT_DASHBOARD_ID;
    }

}
