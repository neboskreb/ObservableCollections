package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.concurrent.LinkedBlockingQueue

open class ObservableLinkedBlockingQueue<X>: ObservableBlockingQueue<X, LinkedBlockingQueue<X>>, Serializable {

    constructor(factory: () -> LinkedBlockingQueue<X> = { LinkedBlockingQueue() }, skipCurrentValueCall: Boolean = false): super(factory, skipCurrentValueCall)

    constructor(inCollection: MutableCollection<X>, skipCurrentValueCall: Boolean = false): super({ LinkedBlockingQueue<X>(inCollection) }, skipCurrentValueCall)

    constructor(capacity: Int, skipCurrentValueCall: Boolean = false): super({ LinkedBlockingQueue<X>(capacity) }, skipCurrentValueCall)

}
