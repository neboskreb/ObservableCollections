package il.co.theblitz.observablecollections.abstracts

import java.io.Serializable
import java.util.concurrent.TransferQueue

open class ObservableTransferQueue<X, T: TransferQueue<X>> : ObservableBlockingQueue<X, T>, Serializable {
    constructor(factory: () -> T, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)
}
