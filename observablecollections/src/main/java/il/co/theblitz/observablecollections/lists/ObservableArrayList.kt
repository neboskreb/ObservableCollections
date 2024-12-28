package il.co.theblitz.observablecollections.lists

import android.annotation.TargetApi
import androidx.annotation.RequiresApi
import il.co.theblitz.observablecollections.abstracts.ObservableList
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.io.Serializable
import java.util.*
import java.util.function.UnaryOperator
import kotlin.collections.ArrayList

@Suppress("unused")
class ObservableArrayList<X> : ObservableList<X, ArrayList<X>>, RandomAccess, Serializable {

    constructor(factory: () -> ArrayList<X> = { ArrayList() }, skipCurrentValue: Boolean = false) : super(factory, skipCurrentValue)

    constructor(capacity: Int, skipCurrentValue: Boolean = false) : this({ ArrayList(capacity) }, skipCurrentValue)

    constructor(collection: Collection<X>, skipCurrentValue: Boolean = false) : this({ ArrayList(collection) }, skipCurrentValue)


    fun addAll(index: Int, elements: Collection<X>): Boolean {
        val added = collection.addAll(index, elements)
        if (added)
            signalChanged(ObservableCollectionsAction.AddAll, actionInt = index, actionElements = elements, resultBoolean = added)
        return added
    }

    @TargetApi (24)
    @RequiresApi(24)
    fun replaceAll(operator: UnaryOperator<X>) {
        collection.replaceAll(operator)
        signalChanged(ObservableCollectionsAction.ReplaceAll)
    }

    fun trimToSize() {
        collection.trimToSize()
    }

    fun toArray(): Array<Any> {
        return collection.toArray()
    }

    fun <T : Any?> toArray(a: Array<T>): Array<T> {
        return collection.toArray(a)
    }

    fun ensureCapacity(minCapacity: Int) {
        collection.ensureCapacity(minCapacity)
    }
}
