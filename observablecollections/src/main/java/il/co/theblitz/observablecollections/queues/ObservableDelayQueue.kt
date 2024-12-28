package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.*
import java.util.concurrent.DelayQueue
import java.util.concurrent.Delayed

open class ObservableDelayQueue<X: Delayed> : ObservableBlockingQueue<X, DelayQueue<X>>, Serializable {

    constructor(factory: () -> DelayQueue<X> = { DelayQueue() }, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)

    constructor(inCollection: MutableCollection<X>, skipCurrentValueCall: Boolean = false): super({ DelayQueue<X>(inCollection) }, skipCurrentValueCall)

}
