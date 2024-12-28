package il.co.theblitz.observablecollections.sets

import il.co.theblitz.observablecollections.abstracts.ObservableSet
import java.io.Serializable
import java.util.*
import kotlin.Comparator

open class ObservableTreeSet<X> : ObservableSet<X, TreeSet<X>>, Serializable {

    constructor(factory: () -> TreeSet<X> = { TreeSet() }, skipCurrentValue: Boolean = false) : super(factory, skipCurrentValue)

    constructor(comparator: Comparator<X>, skipCurrentValue: Boolean = false) : this({ TreeSet(comparator) }, skipCurrentValue)

    constructor(collection: Collection<X>, skipCurrentValue: Boolean = false) : this({ TreeSet(collection) }, skipCurrentValue)

    constructor(set: SortedSet<X>, skipCurrentValue: Boolean = false) : this({ TreeSet(set) }, skipCurrentValue)
}
