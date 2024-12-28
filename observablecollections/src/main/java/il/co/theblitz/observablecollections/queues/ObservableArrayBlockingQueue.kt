package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableBlockingQueue
import java.io.Serializable
import java.util.concurrent.ArrayBlockingQueue

open class ObservableArrayBlockingQueue<X> : ObservableBlockingQueue<X, ArrayBlockingQueue<X>>, Serializable {

    constructor(skipCurrentValueCall: Boolean = false) : this(1, skipCurrentValueCall)

    constructor(capacity: Int, fair: Boolean, inCollection: MutableCollection<X>, skipCurrentValueCall: Boolean = false): super({ ArrayBlockingQueue(capacity, fair, inCollection) }, skipCurrentValueCall)

    constructor(capacity: Int, fair: Boolean, skipCurrentValueCall: Boolean = false): super({ ArrayBlockingQueue(capacity, fair) }, skipCurrentValueCall)

    constructor(capacity: Int, skipCurrentValueCall: Boolean = false):  super({ ArrayBlockingQueue(capacity) }, skipCurrentValueCall)

}
