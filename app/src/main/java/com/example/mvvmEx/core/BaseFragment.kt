package com.example.mvvmEx.core


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.doOnPreDraw
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater

abstract class BaseFragment<T : ViewDataBinding> constructor(
    @LayoutRes private val contentLayoutId: Int
) : Fragment() {


    private var bindingComponent: DataBindingComponent? = DataBindingUtil.getDefaultComponent()

    private lateinit var _binding: T

    protected val binding: T
        get() = _binding


    protected inline fun binding(block: T.() -> Unit): T {
        return binding.apply(block)
    }

    private val animation by lazy {
        TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater, contentLayoutId, container, false, bindingComponent
        )
        _binding.executePendingBindings()
        _binding.lifecycleOwner = this
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }

}

