package dev.szafraniak.bm_mobileapp.business.navigation;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.util.HashMap;
import java.util.Map;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.company.create.CompanyCreateFragment_;
import dev.szafraniak.bm_mobileapp.presentation.company.list.CompanyListFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.modify.ModifyCompanyFragment_;
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
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.InvoicesFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.CreateInvoiceBaseDataFormFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.ProductsListFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.create.ProductModelCreateFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.details.ProductModelDetailsFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.modify.ProductModelModifyFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.resources.ResourcesFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.ServiceModelListFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.create.ServiceModelCreateFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.details.ServiceModelDetailsFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.modify.ServiceModelModifyFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.settings.SettingsFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.WarehouseListFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create.WarehouseCreateFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details.WarehouseDetailsFragment_;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify.WarehouseModifyFragment_;
import dev.szafraniak.bm_mobileapp.presentation.shared.result.ActionStatusFragment_;


public abstract class FragmentFactory {
    public static final int FRAGMENT_COMPANY_LIST = 10;
    public static final int FRAGMENT_COMPANY_CREATE = 11;
    public static final int FRAGMENT_DASHBOARD = 100;
    public static final int FRAGMENT_CONTACTS = 200;
    public static final int FRAGMENT_INDIVIDUAL_CONTACT_LIST = 210;
    public static final int FRAGMENT_INDIVIDUAL_CONTACT_CREATE = 211;
    public static final int FRAGMENT_INDIVIDUAL_CONTACT_MODIFY = 212;
    public static final int FRAGMENT_INDIVIDUAL_CONTACT_DETAILS = 213;
    public static final int FRAGMENT_COMPANY_CONTACT_LIST = 220;
    public static final int FRAGMENT_COMPANY_CONTACT_CREATE = 221;
    public static final int FRAGMENT_COMPANY_CONTACT_MODIFY = 222;
    public static final int FRAGMENT_COMPANY_CONTACT_DETAILS = 223;
    public static final int FRAGMENT_RESOURCES = 300;
    public static final int FRAGMENT_INVOICES = 400;
    public static final int FRAGMENT_INVOICES_CREATE_BASE_DATA = 401;
    public static final int FRAGMENT_SETTINGS = 500;
    public static final int FRAGMENT_SETTINGS_COMPANY = 501;
    public static final int FRAGMENT_ACTION_STATUS = 600;
    public static final int FRAGMENT_PRODUCT_MODEL_LIST = 700;
    public static final int FRAGMENT_PRODUCT_MODEL_MODIFY = 701;
    public static final int FRAGMENT_PRODUCT_MODEL_CREATE = 702;
    public static final int FRAGMENT_PRODUCT_MODEL_DETAILS = 703;
    public static final int FRAGMENT_SERVICE_MODEL_LIST = 800;
    public static final int FRAGMENT_SERVICE_MODEL_DETAILS = 801;
    public static final int FRAGMENT_SERVICE_MODEL_MODIFY = 802;
    public static final int FRAGMENT_SERVICE_MODEL_CREATE = 803;
    public static final int FRAGMENT_WAREHOUSE_LIST = 900;
    public static final int FRAGMENT_WAREHOUSE_CREATE = 901;
    public static final int FRAGMENT_WAREHOUSE_MODIFY = 902;
    public static final int FRAGMENT_WAREHOUSE_DETAILS = 903;
    public static final int FRAGMENT_FINANCES = 1000;

    public static final Map<Integer, Integer> menuMap = new HashMap<Integer, Integer>() {{
        put(R.id.menu_dashboard, FRAGMENT_DASHBOARD);
        put(R.id.menu_contacts, FRAGMENT_CONTACTS);
        put(R.id.menu_resources, FRAGMENT_RESOURCES);
        put(R.id.menu_invoices, FRAGMENT_INVOICES);
        put(R.id.menu_settings, FRAGMENT_SETTINGS);
    }};


    public static Fragment getFragmentById(int fragmentId) {
        Fragment fragment;

        switch (fragmentId) {
            case FRAGMENT_COMPANY_CREATE:
                fragment = new CompanyCreateFragment_();
                break;
            case FRAGMENT_COMPANY_LIST:
                fragment = new CompanyListFragment_();
                break;
            case FRAGMENT_DASHBOARD:
                fragment = new DashboardFragment_();
                break;
            case FRAGMENT_CONTACTS:
                fragment = new ContactsFragment_();
                break;
            case FRAGMENT_INDIVIDUAL_CONTACT_LIST:
                fragment = new IndividualContactListFragment_();
                break;
            case FRAGMENT_INDIVIDUAL_CONTACT_CREATE:
                fragment = new IndividualContactCreateFragment_();
                break;
            case FRAGMENT_INDIVIDUAL_CONTACT_MODIFY:
                fragment = new IndividualContactModifyFragment_();
                break;
            case FRAGMENT_INDIVIDUAL_CONTACT_DETAILS:
                fragment = new IndividualContactDetailsFragment_();
                break;
            case FRAGMENT_COMPANY_CONTACT_LIST:
                fragment = new CompanyContactListFragment_();
                break;
            case FRAGMENT_COMPANY_CONTACT_CREATE:
                fragment = new CompanyContactCreateFragment_();
                break;
            case FRAGMENT_COMPANY_CONTACT_MODIFY:
                fragment = new CompanyContactModifyFragment_();
                break;
            case FRAGMENT_COMPANY_CONTACT_DETAILS:
                fragment = new CompanyContactDetailsFragment_();
                break;
            case FRAGMENT_RESOURCES:
                fragment = new ResourcesFragment_();
                break;
            case FRAGMENT_INVOICES:
                fragment = new InvoicesFragment_();
                break;
            case FRAGMENT_INVOICES_CREATE_BASE_DATA:
                fragment = new CreateInvoiceBaseDataFormFragment_();
                break;
            case FRAGMENT_FINANCES:
                fragment = new FinancesFragment_();
                break;
            case FRAGMENT_SETTINGS:
                fragment = new SettingsFragment_();
                break;
            case FRAGMENT_SETTINGS_COMPANY:
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
            case FRAGMENT_SERVICE_MODEL_LIST:
                fragment = new ServiceModelListFragment_();
                break;
            case FRAGMENT_SERVICE_MODEL_DETAILS:
                fragment = new ServiceModelDetailsFragment_();
                break;
            case FRAGMENT_SERVICE_MODEL_MODIFY:
                fragment = new ServiceModelModifyFragment_();
                break;
            case FRAGMENT_SERVICE_MODEL_CREATE:
                fragment = new ServiceModelCreateFragment_();
                break;
            case FRAGMENT_WAREHOUSE_LIST:
                fragment = new WarehouseListFragment_();
                break;
            case FRAGMENT_WAREHOUSE_CREATE:
                fragment = new WarehouseCreateFragment_();
                break;
            case FRAGMENT_WAREHOUSE_MODIFY:
                fragment = new WarehouseModifyFragment_();
                break;
            case FRAGMENT_WAREHOUSE_DETAILS:
                fragment = new WarehouseDetailsFragment_();
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
        return FRAGMENT_COMPANY_LIST;
    }

    public static int getMenuMainFragmentId() {
        return FRAGMENT_DASHBOARD;
    }

}
