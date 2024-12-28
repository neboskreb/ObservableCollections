package il.co.theblitz.observablecollections.maps

import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable

open class ObservableHashMap<X, Y> : ObservableMap<X, Y, HashMap<X, Y>>, Serializable {
    constructor(factory: () -> HashMap<X, Y> = { HashMap() }, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)

    constructor(capacity: Int, skipCurrentValue: Boolean = false) : this({ HashMap(capacity) }, skipCurrentValue)

    constructor(capacity: Int, loadFactor: Float, skipCurrentValue: Boolean = false) : this({ HashMap(capacity, loadFactor) }, skipCurrentValue)

    constructor(map: Map<X, Y>, skipCurrentValue: Boolean = false) : this({ HashMap(map) }, skipCurrentValue)
}
