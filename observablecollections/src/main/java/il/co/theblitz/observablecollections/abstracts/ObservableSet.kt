package il.co.theblitz.observablecollections.abstracts

abstract class ObservableSet<X, T : MutableSet<X>> : ObservableCollection<X, T> {
    constructor(factory: () -> T, skipCurrentValueCall: Boolean = false) : super(factory, skipCurrentValueCall)
}
