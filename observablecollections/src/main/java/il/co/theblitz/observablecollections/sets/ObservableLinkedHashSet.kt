package il.co.theblitz.observablecollections.sets

import il.co.theblitz.observablecollections.abstracts.ObservableSet
import java.io.Serializable
import kotlin.collections.LinkedHashSet

open class ObservableLinkedHashSet<X> : ObservableSet<X, LinkedHashSet<X>>, Serializable {

    constructor(factory: () -> LinkedHashSet<X> = { LinkedHashSet() }, skipCurrentValue: Boolean = false) : super(factory, skipCurrentValue)

    constructor(capacity: Int, skipCurrentValue: Boolean = false) : this({ LinkedHashSet(capacity) }, skipCurrentValue)

    constructor(collection: Collection<X>, skipCurrentValue: Boolean = false) : this({ LinkedHashSet(collection) }, skipCurrentValue)

}
