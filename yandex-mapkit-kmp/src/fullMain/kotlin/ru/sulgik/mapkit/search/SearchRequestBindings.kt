package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.WeakRef

/**
 * Associates a UI-thread request with its native handle without retaining either.
 */
internal class SearchRequestBindings<Native : Any, Request : Any> {

    private val bindings = mutableListOf<Binding<Native, Request>>()

    fun bind(native: Native, request: Request) {
        bindings.removeAll { binding ->
            val existing = binding.native.get()
            existing == null || binding.request.get() == null || existing === native || existing == native
        }
        bindings.add(Binding(WeakRef(native), WeakRef(request)))
    }

    fun requestFor(native: Native): Request? {
        val iterator = bindings.iterator()
        while (iterator.hasNext()) {
            val binding = iterator.next()
            val existing = binding.native.get()
            val request = binding.request.get()
            if (existing == null || request == null) {
                iterator.remove()
            } else if (existing === native || existing == native) {
                return request
            }
        }
        return null
    }

    private class Binding<Native : Any, Request : Any>(
        val native: WeakRef<Native>,
        val request: WeakRef<Request>,
    )
}
