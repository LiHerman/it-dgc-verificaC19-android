/*
 *  ---license-start
 *  eu-digital-green-certificates / dgca-verifier-app-android
 *  ---
 *  Copyright (C) 2021 T-Systems International GmbH and all other contributors
 *  ---
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  ---license-end
 *
 *  Created by nicolamcornelio on 07/10/2021, 11:49
 */

package it.ministerodellasalute.verificaC19.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import it.ministerodellasalute.verificaC19.R
import it.ministerodellasalute.verificaC19.VerificaApplication
import it.ministerodellasalute.verificaC19.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSwitchesValue()

        binding.backImage.setOnClickListener(this)
        binding.backText.setOnClickListener(this)
        binding.totemSwitch.setOnClickListener(this)
    }

    private fun setSwitchesValue() {
        binding.totemSwitch.isChecked = VerificaApplication.isTotemModeActive
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.back_image || v?.id == R.id.back_text) {
            finish()
        } else if (v?.id == R.id.totem_switch) {
            VerificaApplication.isTotemModeActive = binding.totemSwitch.isChecked
        }
    }
}