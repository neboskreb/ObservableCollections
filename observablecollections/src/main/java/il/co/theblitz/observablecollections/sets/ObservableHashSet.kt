package il.co.theblitz.observablecollections.sets

import il.co.theblitz.observablecollections.abstracts.ObservableSet
import java.io.Serializable
import java.util.*
import kotlin.collections.HashSet

open class ObservableHashSet<X> : ObservableSet<X, HashSet<X>>, Serializable {

    constructor(factory: () -> HashSet<X> = { HashSet() }, skipCurrentValue: Boolean = false) : super(factory, skipCurrentValue)

    constructor(capacity: Int, skipCurrentValue: Boolean = false) : this({ HashSet(capacity) }, skipCurrentValue)

    constructor(collection: Collection<X>, skipCurrentValue: Boolean = false) : this({ HashSet(collection) }, skipCurrentValue)

}
