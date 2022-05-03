package com.fearlessbear.androidexperiment.view.scroll.nested

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.NestedScrollingParent3
import java.util.jar.Attributes
import kotlin.coroutines.coroutineContext

/**
 *
 *
 * @author cuihaichen on 2022/4/22
 */
class NestedScrollParentImpl : FrameLayout, NestedScrollingParent3 {

  val TAG="NestedScrollParentImpl"

  constructor(context: Context, attributes: AttributeSet) : super(context, attributes)
  constructor(context: Context, attributes: AttributeSet, defStyleAttr: Int) : super(context,
      attributes, defStyleAttr)

  override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
    Log.i(TAG, "onStartNestedScroll:")
    return true
  }

  override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) {
    TODO("Not yet implemented")
  }

  override fun onStopNestedScroll(target: View, type: Int) {
    TODO("Not yet implemented")
  }

  override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int, consumed: IntArray) {
    TODO("Not yet implemented")
  }

  override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
    TODO("Not yet implemented")
  }

  override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
    TODO("Not yet implemented")
  }
}