/*
 * Copyright (C) 2019 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo.yukiprjkt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.VisibleForTesting;
import androidx.preference.Preference;

import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.core.BasePreferenceController;
import com.android.settings.slices.Sliceable;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;

public class YukiVersionPreferenceController extends BasePreferenceController {

    private static final String TAG = "yukiVersionDialogCtrl";

    private static final String KEY_YUKI_VERSION_PROP = "ro.yukiprjkt.branding.version";
    private static final String KEY_YUKI_CODENAME = "ro.yukiprjkt.codename";
    private static final String KEY_YUKI_BUILD_TYPE = "ro.yukiprjkt.status";

    public YukiVersionPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public boolean useDynamicSliceSummary() {
        return true;
    }

    @Override
    public boolean isSliceable() {
        return true;
    }

    @Override
    public CharSequence getSummary() {
        String yukiVersion = SystemProperties.get(KEY_YUKI_VERSION_PROP);
        String yukiCodename = SystemProperties.get(KEY_YUKI_CODENAME);
        String yukiBuildType = SystemProperties.get(KEY_YUKI_BUILD_TYPE);
        return yukiVersion + " | " + yukiCodename + " | " + yukiBuildType;
    }
}