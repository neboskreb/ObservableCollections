package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.concurrent.SynchronousQueue

open class ObservableSynchronousQueue<X> : ObservableBlockingQueue<X, SynchronousQueue<X>>, Serializable {

    constructor(factory: () -> SynchronousQueue<X> = { SynchronousQueue() }, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)

    constructor(fair: Boolean = false, skipCurrentValueCall: Boolean = false): this({ SynchronousQueue<X>(fair) }, skipCurrentValueCall)

}
