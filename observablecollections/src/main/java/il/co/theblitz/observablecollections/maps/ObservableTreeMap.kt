package il.co.theblitz.observablecollections.maps

import il.co.theblitz.observablecollections.abstracts.ObservableMap
import java.io.Serializable
import java.util.SortedMap
import java.util.TreeMap

open class ObservableTreeMap<X, Y> : ObservableMap<X, Y, TreeMap<X, Y>>, Serializable {

    constructor(factory: () -> TreeMap<X, Y> = { TreeMap() }, skipCurrentValue: Boolean = false) : super(factory, skipCurrentValue)

    constructor(comparator: Comparator<X>, skipCurrentValue: Boolean = false) : this({ TreeMap(comparator) }, skipCurrentValue)

    constructor(map: Map<X, Y>, skipCurrentValue: Boolean = false) : this({ TreeMap(map) }, skipCurrentValue)

    constructor(sortedMap: SortedMap<X, Y>, skipCurrentValue: Boolean = false) : this({ TreeMap(sortedMap) }, skipCurrentValue)
}
