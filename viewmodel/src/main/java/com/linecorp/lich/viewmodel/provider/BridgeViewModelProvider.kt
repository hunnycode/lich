/*
 * Copyright 2019 LINE Corporation
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
package com.linecorp.lich.viewmodel.provider

import android.content.Context
import androidx.lifecycle.ViewModelStoreOwner
import com.linecorp.lich.viewmodel.AbstractViewModel
import com.linecorp.lich.viewmodel.ViewModelFactory
import com.linecorp.lich.viewmodel.internal.lichViewModelProvider

@Deprecated("Will be removed in 1.2.0")
interface BridgeViewModelProvider {
    @Deprecated("Will be removed in 1.2.0")
    fun <T : AbstractViewModel> getViewModel(
        context: Context,
        viewModelStoreOwner: ViewModelStoreOwner,
        factory: ViewModelFactory<T>
    ): T
}

@Suppress("FunctionName") // factory function
@Deprecated("Will be removed in 1.2.0")
fun BridgeViewModelProvider(): BridgeViewModelProvider =
    object : BridgeViewModelProvider {
        override fun <T : AbstractViewModel> getViewModel(
            context: Context,
            viewModelStoreOwner: ViewModelStoreOwner,
            factory: ViewModelFactory<T>
        ): T = lichViewModelProvider.getViewModel(context, viewModelStoreOwner, factory)
    }
