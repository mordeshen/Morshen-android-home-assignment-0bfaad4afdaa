package homework.chegg.com.chegghomework.presentation.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.callbacks.onDismiss
import com.codingwithmitch.openapi.business.domain.util.*
import homework.chegg.com.chegghomework.R
import homework.chegg.com.chegghomework.buisness.domain.util.*

private val TAG: String = "AppDebug"

fun processQueue(
    context: Context?,
    queue: Queue<StateMessage>,
) {
    context?.let { ctx ->
        if(!queue.isEmpty()){
            queue.peek()?.let { stateMessage ->
                ctx.onResponseReceived(
                    response = stateMessage.response
                )
            }
        }
    }
}

private fun Context.onResponseReceived(
    response: Response) {
    when(response.uiComponentType){

        is UIComponentType.AreYouSureDialog -> {

            response.message?.let {
                areYouSureDialog(
                    message = it,
                    callback = response.uiComponentType.callback)
            }
        }

        is UIComponentType.Toast -> {
            response.message?.let {
                displayToast(
                    message = it
                )
            }
        }

        is UIComponentType.Dialog -> {
            displayDialog(
                response = response
            )
        }

        is UIComponentType.None -> {
            // This would be a good place to send to your Error Reporting
            // software of choice (ex: Firebase crash reporting)
            Log.i(TAG, "onResponseReceived: ${response.message}")
        }
    }
}


private fun Context.displayDialog(
    response: Response
){
    response.message?.let { message ->

        when (response.messageType) {

            is MessageType.Error -> {
                displayErrorDialog(
                    message = message,
                )
            }

            is MessageType.Success -> {
                displaySuccessDialog(
                    message = message
                )
            }

            is MessageType.Info -> {
                displayInfoDialog(
                    message = message)
            }

            else -> {
                // do nothing
                null
            }
        }
    }
}

private fun Context.displaySuccessDialog(
    message: String?,
) {
    MaterialDialog(this)
        .show{
            title(R.string.text_success)
            message(text = message)
            positiveButton(R.string.text_ok){
                dismiss()
            }
            onDismiss {
            }
            cancelable(false)
        }
}

private fun Context.displayErrorDialog(
    message: String?
) {
    MaterialDialog(this)
        .show{
            title(R.string.text_error)
            message(text = message)
            positiveButton(R.string.text_ok){
                dismiss()
            }
            onDismiss {
            }
            cancelable(false)
        }
}

private fun Context.displayInfoDialog(
    message: String?
) {
    MaterialDialog(this)
        .show{
            title(R.string.text_info)
            message(text = message)
            positiveButton(R.string.text_ok){
                dismiss()
            }
            onDismiss {
            }
            cancelable(false)
        }
}

private fun Context.areYouSureDialog(
    message: String,
    callback: AreYouSureCallback
) {
    MaterialDialog(this)
        .show{
            title(R.string.are_you_sure)
            message(text = message)
            negativeButton(R.string.text_cancel){
                callback.cancel()
                dismiss()
            }
            positiveButton(R.string.text_yes){
                callback.proceed()
                dismiss()
            }
            onDismiss {
            }
            cancelable(false)
        }
}

fun Context.displayToast(
    @StringRes message:Int,
){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.displayToast(
    message:String,
){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}


