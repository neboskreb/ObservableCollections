package il.co.theblitz.observablecollections.lists


import android.annotation.TargetApi
import androidx.annotation.RequiresApi
import il.co.theblitz.observablecollections.abstracts.ObservableList
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.io.Serializable
import java.util.*
import java.util.function.UnaryOperator

@Suppress("unused", "ConvertSecondaryConstructorToPrimary")
open class ObservableStack<X> : Serializable, ObservableList<X, Stack<X>> {

    constructor(factory: () -> Stack<X> = { Stack() }, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)

    override fun addAll(index: Int, elements: Collection<X>): Boolean {
        val added = collection.addAll(index, elements)
        if (added)
            signalChanged(ObservableCollectionsAction.AddAll, actionInt = index, actionElements = elements, resultBoolean = added)
        return added
    }

    fun search(o: Any?): Int {
        return collection.search(o)
    }

    fun push(item: X): X {
        val resultElement = collection.push(item)
        signalChanged(ObservableCollectionsAction.Push, actionElement = item, resultElement = resultElement)
        return resultElement
    }

    fun peek(): X {
        return collection.peek()
    }

    fun empty(): Boolean {
        return collection.empty()
    }

    fun pop(): X {
        val resultElement = collection.pop()
        signalChanged(ObservableCollectionsAction.Push, resultElement = resultElement)
        return resultElement
    }

    @TargetApi(24)
    @RequiresApi(24)
    override fun replaceAll(operator: UnaryOperator<X>) {
        super<ObservableList>.replaceAll(operator)
    }

    @TargetApi(24)
    @RequiresApi(24)
    override fun sort(c: Comparator<in X>?) {
        super.sort(c)
    }
}

