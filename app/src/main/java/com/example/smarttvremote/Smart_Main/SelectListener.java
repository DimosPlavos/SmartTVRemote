package com.example.smarttvremote.Smart_Main;

import com.example.smarttvremote.Smart_Main.CategoryDomain;

public interface SelectListener {
    void onItemClicked(CategoryDomain myModel);
    void onItemClickedApps(AppsDomain myModel);
}
