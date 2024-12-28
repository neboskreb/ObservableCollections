package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.concurrent.PriorityBlockingQueue

open class ObservablePriorityBlockingQueue<X> : ObservableBlockingQueue<X, PriorityBlockingQueue<X>>, Serializable {

    constructor(factory: () -> PriorityBlockingQueue<X> = { PriorityBlockingQueue() }, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)

    constructor(inCollection: MutableCollection<X>, skipCurrentValueCall: Boolean = false): this({ PriorityBlockingQueue<X>(inCollection) }, skipCurrentValueCall)

    constructor(capacity: Int, skipCurrentValueCall: Boolean = false): this({ PriorityBlockingQueue<X>(capacity) }, skipCurrentValueCall)

    constructor(capacity: Int, comparator: Comparator<in X>, skipCurrentValueCall: Boolean = false): this({ PriorityBlockingQueue<X>(capacity, comparator) }, skipCurrentValueCall)
}
