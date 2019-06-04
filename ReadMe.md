

## BindingListAdapter

功能：1、数据双向绑定
      2、局部刷新机制

该项目在[ditclear/BindingListAdapter](https://github.com/ditclear/BindingListAdapter)项目的基础上修改了局部刷新机制
考虑到实际使用场景，不使用androidx.databinding.ObservableField.ObservableField(T)再包裹一层，

局部刷新机制修改如下：
参考D:\app\src\main\java\io\ditclear\app\singletype\User.kt类
需要局部刷新的字段请这样重写get/set方法：
```
var photoUrl: String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.photoUrl)
    }
    @Bindable
    get() = field
```
不需要局部刷新的字段直接这样定义即可：
```
var name: String = ""
```
当需要刷新某一个控件的时候，只需要修改其绑定的值即可：
```
item.photoUrl = "http://cdn.duitang.com/uploads/item/201610/03/20161003000301_Wfm5X.jpeg"
```
而不需要再给控件设置值，或者调用adapter.notifyDataSetChanged()等刷新方法即可做到局部刷新
参考\app\src\main\java\io\ditclear\app\singletype\SingleTypeListKotlin.kt

### Thanks To

[ditclear/BindingListAdapter](https://github.com/ditclear/BindingListAdapter)

### License

[MIT](LICENSE.txt)





