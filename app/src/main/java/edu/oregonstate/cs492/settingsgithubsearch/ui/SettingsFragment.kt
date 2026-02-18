package edu.oregonstate.cs492.settingsgithubsearch.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import edu.oregonstate.cs492.settingsgithubsearch.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }
}