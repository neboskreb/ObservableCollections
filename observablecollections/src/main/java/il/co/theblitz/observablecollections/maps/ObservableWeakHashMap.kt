package il.co.theblitz.observablecollections.maps

import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable
import java.util.*

open class ObservableWeakHashMap<X, Y> : ObservableMap<X, Y, WeakHashMap<X, Y>>, Serializable {

    constructor(factory: () -> WeakHashMap<X, Y> = { WeakHashMap() }, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)

    constructor(capacity: Int, skipCurrentValue: Boolean = false) : this({ WeakHashMap(capacity) }, skipCurrentValue)

    constructor(capacity: Int, loadFactor: Float, skipCurrentValue: Boolean = false) : this({ WeakHashMap(capacity, loadFactor) }, skipCurrentValue)

    constructor(map: Map<X, Y>, skipCurrentValue: Boolean = false) : this({ WeakHashMap(map) }, skipCurrentValue)

}
