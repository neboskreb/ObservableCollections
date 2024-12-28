package il.co.theblitz.observablecollections.maps

import java.io.Serializable

open class ObservableLinkedHashMap<X, Y> : ObservableHashMap<X, Y>, Serializable {

    constructor(factory: () -> LinkedHashMap<X, Y> = { LinkedHashMap() }, skipCurrentValue: Boolean = false) : super(factory, skipCurrentValue)

    constructor(capacity: Int, skipCurrentValue: Boolean = false) : this({ LinkedHashMap(capacity) }, skipCurrentValue)

    constructor(capacity: Int, loadFactor: Float, skipCurrentValue: Boolean = false) : this({ LinkedHashMap(capacity, loadFactor) }, skipCurrentValue)

    constructor(map: Map<X, Y>, skipCurrentValue: Boolean = false) : this({ LinkedHashMap(map) }, skipCurrentValue)
}
