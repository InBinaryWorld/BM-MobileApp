package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;

import static dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.InvoiceContactFormFragment.FORM_ID_CREATE_INVOICE_RECEIVER;
import static dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.InvoiceContactFormFragment.FORM_ID_KEY;

public class ClickableReceiverForm extends ClickableContactForm {

    public ClickableReceiverForm(LayoutInflater inflater, ViewGroup viewGroup, ClickableContactFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void navigateToContactForm(View clickedView) {
        executeSafeNavigation(view -> {
            Bundle args = new Bundle();
            args.putString(FORM_ID_KEY, FORM_ID_CREATE_INVOICE_RECEIVER);
            Navigator.navigateTo(view, FragmentFactory.FRAGMENT_FORM_CONTACT_AUTO_COMPETE, args);
        });
    }
}
