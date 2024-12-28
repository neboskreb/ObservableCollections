package il.co.theblitz.observablecollections.abstracts

import android.annotation.TargetApi
import androidx.annotation.RequiresApi
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.io.Serializable
import java.util.*
import java.util.stream.Stream
import kotlin.random.Random

@Suppress("unused", "ConvertSecondaryConstructorToPrimary")
abstract class ObservableList<X, T: MutableList<X>> : Serializable, ObservableCollection<X, T>, MutableList<X> {

    constructor(factory: () -> T, skipCurrentValue: Boolean = false) : super(factory, skipCurrentValue)

    override val collection: T
        get() = _collection

    override fun add(index: Int, element: X) {
        collection.add(index, element)
        signalChanged(ObservableCollectionsAction.Add, actionInt = index, actionElement = element)
    }

    override operator fun get(index: Int): X {
        return collection[index]
    }

    fun getOrNull(index: Int): X? {
        return collection.getOrNull(index)
    }

    fun getOrElse(index: Int, defaultValue: (Int) -> X): X {
        return collection.getOrElse(index, defaultValue)
    }

    override fun indexOf(element: X): Int {
        return collection.indexOf(element)
    }

    override fun lastIndexOf(element: X): Int {
        return collection.lastIndexOf(element)
    }

    fun indexOfFirst(predicate: (X) -> Boolean): Int {
        return collection.indexOfFirst(predicate)
    }

    fun indexOfLast(predicate: (X) -> Boolean): Int {
        return collection.indexOfLast(predicate)
    }

    override fun listIterator(): MutableListIterator<X> {
        return collection.listIterator()
    }

    override fun listIterator(index: Int): MutableListIterator<X> {
        return collection.listIterator(index)
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<X> {
        return collection.subList(fromIndex, toIndex)
    }


    override fun removeAt(index: Int): X {
        val resultElement = collection.removeAt(index)
        signalChanged(ObservableCollectionsAction.RemoveAt, actionInt = index, resultElement = resultElement)
        return resultElement
    }

    fun fill(value: X) {
        collection.fill(value)
        signalChanged(ObservableCollectionsAction.Fill, actionElement = value)
    }

    override operator fun set(index: Int, element: X): X {
        val resultElement = collection.set(index, element)
        signalChanged(ObservableCollectionsAction.Set, actionInt = index, actionElement = element, resultElement = resultElement)
        return resultElement
    }

    fun reverse() {
        collection.reverse()
        signalChanged(ObservableCollectionsAction.Reverse)
    }

    fun shuffle(random: Random) {
        collection.shuffle(random)
        signalChanged(ObservableCollectionsAction.Shuffle)
    }

    fun sortWith(comparator: Comparator<in X>) {
        collection.sortWith(comparator)
        signalChanged(ObservableCollectionsAction.Sort)
    }


    @TargetApi(24)
    @RequiresApi(24)
    override fun spliterator(): Spliterator<X> {
        return collection.spliterator()
    }

    @TargetApi(24)
    @RequiresApi(24)
    override fun stream(): Stream<X> {
        return collection.stream()
    }
}

