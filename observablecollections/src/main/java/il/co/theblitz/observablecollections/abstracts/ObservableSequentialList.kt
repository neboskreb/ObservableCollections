package il.co.theblitz.observablecollections.abstracts

import java.io.Serializable
import java.util.AbstractSequentialList

abstract class ObservableSequentialList<X, T: AbstractSequentialList<X>> : Serializable, ObservableList<X, T> {
    constructor(factory: () -> T, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)
}
