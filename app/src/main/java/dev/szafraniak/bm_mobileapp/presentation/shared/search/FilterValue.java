package dev.szafraniak.bm_mobileapp.presentation.shared.search;

public abstract class FilterValue {
    private String _filterValue;

    public String getFilterValue() {
        if (_filterValue == null) {
            _filterValue = createDescriptionForFilter();
        }
        return _filterValue;
    }

    protected abstract String createDescriptionForFilter();
}
