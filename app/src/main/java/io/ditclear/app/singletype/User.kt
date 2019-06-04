package io.ditclear.app.singletype

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import io.ditclear.app.BR

/**
 * Description:
 * Created by FQH on 2019/6/4.
 */
class User: BaseObservable() {

    var sex: String = ""

    var name: String = ""

    var photoUrl: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.photoUrl)
        }
        @Bindable
        get() = field
}