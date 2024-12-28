package il.co.theblitz.observablecollections.queues

import android.annotation.TargetApi
import il.co.theblitz.observablecollections.abstracts.ObservableTransferQueue
import java.io.Serializable
import java.util.concurrent.LinkedTransferQueue

@TargetApi (21)
open class ObservableLinkedTransferQueue<X> : ObservableTransferQueue<X, LinkedTransferQueue<X>>, Serializable {

    constructor(factory: () -> LinkedTransferQueue<X> = { LinkedTransferQueue() }, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)

    constructor(inCollection: MutableCollection<X>, skipCurrentValueCall: Boolean = false): super({ LinkedTransferQueue<X>(inCollection) }, skipCurrentValueCall)

}
