package il.co.theblitz.observablecollections.maps

import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable
import java.util.concurrent.ConcurrentHashMap

open class ObservableConcurrentHashMap<X, Y> : ObservableMap<X, Y, ConcurrentHashMap<X, Y>>, Serializable {

    constructor(factory: () -> ConcurrentHashMap<X, Y> = { ConcurrentHashMap() }, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)

    constructor(capacity: Int, skipCurrentValue: Boolean = false) : this({ ConcurrentHashMap(capacity) }, skipCurrentValue)

    constructor(capacity: Int, loadFactor: Float, skipCurrentValue: Boolean = false) : this({ ConcurrentHashMap(capacity, loadFactor) }, skipCurrentValue)

    constructor(map: Map<X, Y>, skipCurrentValue: Boolean = false) : this({ ConcurrentHashMap(map) }, skipCurrentValue)

}
