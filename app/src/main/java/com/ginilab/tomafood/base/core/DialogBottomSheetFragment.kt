package com.ginilab.tomafood.base.core

import android.view.View
import com.ginilab.tomafood.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class DialogBottomSheetFragment : BaseBottomSheetDialogFragment<BaseViewModel>() {

    override val viewModel: BaseViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.fragment_bottom_sheet_dialog

    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onPreparationFinished(view: View) {
        super.onPreparationFinished(view)
    }

}
