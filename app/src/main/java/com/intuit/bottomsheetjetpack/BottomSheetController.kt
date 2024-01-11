package com.intuit.bottomsheetjetpack

/**
 * Controller for managing the visibility of the bottom sheet.
 * Provides a method to show the bottom sheet and a method for the BottomSheetHandler
 * to link its state to this controller.
 */
class BottomSheetController {
    private var showBottomSheet: () -> Unit = {}

    /**
     * Triggers the visibility of the bottom sheet.
     */
    fun show() {
        showBottomSheet()
    }

    /**
     * Internal function used by the BottomSheetHandler to link the show functionality.
     */
    internal fun setShowBottomSheet(show: () -> Unit) {
        this.showBottomSheet = show
    }
}
