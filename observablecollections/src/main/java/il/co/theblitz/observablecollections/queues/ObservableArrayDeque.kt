package il.co.theblitz.observablecollections.queues

import il.co.theblitz.observablecollections.abstracts.ObservableDeque
import java.io.Serializable
import java.util.ArrayDeque

open class ObservableArrayDeque<X> : ObservableDeque<X, ArrayDeque<X>>, Serializable {
    constructor(factory: () -> ArrayDeque<X> = { ArrayDeque() }, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)
}
