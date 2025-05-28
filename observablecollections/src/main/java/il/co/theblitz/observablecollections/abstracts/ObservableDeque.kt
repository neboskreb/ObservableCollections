package il.co.theblitz.observablecollections.abstracts

import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import il.co.theblitz.observablecollections.queues.ObservableQueue
import java.util.*

abstract class ObservableDeque<X, T : Deque<X>> : ObservableQueue<X, T> {

    constructor(factory: () -> T, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)

    fun peekLast(): X {
        return collection!!.peekLast()
    }

    fun push(element: X) {
        collection!!.push(element)
        signalChanged(ObservableCollectionsAction.Push, actionElement = element)
    }

    fun getLast(): X {
        return collection!!.getLast()
    }

    fun addLast(element: X) {
        collection!!.addLast(element)
        signalChanged(ObservableCollectionsAction.AddLast, actionElement = element)
    }

    fun addFirst(element: X) {
        collection!!.addFirst(element)
        signalChanged(ObservableCollectionsAction.AddFirst, actionElement = element)
    }

    fun offerLast(element: X): Boolean {
        val added = collection!!.offerLast(element)
        if (added)
            signalChanged(ObservableCollectionsAction.OfferLast, actionElement = element, resultBoolean = added)
        return added
    }

    fun removeFirst(): X {
        val element = collection!!.removeFirst()
        if (element != null)
            signalChanged(ObservableCollectionsAction.RemoveFirst, resultElement = element)
        return element
    }

    fun getFirst(): X {
        return collection!!.first
    }

    fun removeLastOccurrence(element: X?): Boolean {
        val removed = collection!!.removeLastOccurrence(element)
        if (removed)
            signalChanged(ObservableCollectionsAction.RemoveLastOccurrence, actionElement = element, resultBoolean = removed)
        return removed
    }

    fun peekFirst(): X {
        return collection!!.peekFirst()
    }

    fun removeLast(): X {
        val resultElement = collection!!.removeLast()
        signalChanged(ObservableCollectionsAction.RemoveLast, resultElement = resultElement)
        return resultElement
    }

    fun offerFirst(element: X): Boolean {
        val offered = collection!!.offerFirst(element)
        if (offered)
            signalChanged(ObservableCollectionsAction.OfferFirst, actionElement = element, resultBoolean = offered)
        return offered
    }


    fun pollFirst(): X {
        val resultElement = collection!!.pollFirst()
        if (resultElement != null)
            signalChanged(ObservableCollectionsAction.PollFirst, resultElement = resultElement)
        return resultElement
    }

    fun pollLast(): X {
        val resultElement = collection!!.pollLast()
        if (resultElement != null)
            signalChanged(ObservableCollectionsAction.PollLast, resultElement = resultElement)
        return resultElement
    }

    fun pop(): X {
        val resultElement = collection!!.pop()
        signalChanged(ObservableCollectionsAction.Pop, resultElement = resultElement)
        return resultElement
    }

    fun removeFirstOccurrence(element: X?): Boolean {
        val removed = collection!!.removeFirstOccurrence(element)
        if (removed)
            signalChanged(ObservableCollectionsAction.RemoveFirstOccurrence, actionElement = element, resultBoolean = removed)
        return removed
    }

    fun descendingIterator(): MutableIterator<X> {
        return collection!!.descendingIterator()
    }

}
