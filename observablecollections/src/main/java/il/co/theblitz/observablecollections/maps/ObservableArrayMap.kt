package il.co.theblitz.observablecollections.maps

import androidx.collection.ArrayMap
import androidx.collection.SimpleArrayMap
import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable

open class ObservableArrayMap<X, Y> : ObservableMap<X, Y, ArrayMap<X, Y>>, Serializable {

    constructor(factory: () -> ArrayMap<X, Y> = { ArrayMap() }, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)

    constructor(capacity: Int, skipCurrentValue: Boolean = false) : this({ ArrayMap(capacity) }, skipCurrentValue)

    constructor(map: SimpleArrayMap<X, Y>, skipCurrentValue: Boolean = false) : this({ ArrayMap(map) }, skipCurrentValue)

}
