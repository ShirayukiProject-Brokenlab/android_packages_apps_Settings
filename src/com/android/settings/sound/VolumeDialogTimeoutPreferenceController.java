/*
 * Copyright (C) 2020 Yet Another AOSP Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.android.settings.sound;

import android.content.Context;
import android.provider.Settings;

import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settingslib.core.AbstractPreferenceController;

import com.yukiprjkt.yukispace.preferences.CustomSeekBarPreference;

/**
 * A simple preference controller for volume dialog timeout
 */
public class VolumeDialogTimeoutPreferenceController extends AbstractPreferenceController
        implements Preference.OnPreferenceChangeListener {

    private static final String KEY = "volume_dialog_timeout";

    private CustomSeekBarPreference mDialogTimeoutSeekBar;

    public VolumeDialogTimeoutPreferenceController(Context context) {
        super(context);
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String getPreferenceKey() {
        return KEY;
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        mDialogTimeoutSeekBar = (CustomSeekBarPreference) screen.findPreference(KEY);
        mDialogTimeoutSeekBar.setValue(Settings.System.getInt(
                mContext.getContentResolver(), KEY, 5));
        mDialogTimeoutSeekBar.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Settings.System.putInt(mContext.getContentResolver(), KEY, (Integer) newValue);
        return true;
    }
}