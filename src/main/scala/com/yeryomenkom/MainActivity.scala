package com.yeryomenkom

import android.app.Activity
import android.os.Bundle
import android.graphics.drawable.Animatable
import android.view.View
import android.view.View.OnClickListener
import io.circe.Json
import io.circe.generic.auto._
import io.circe.syntax._

import scala.concurrent.ExecutionContext

case class A(r: Int, k: String)

class BaseActivity[ViewHolder <: TypedViewHolder[_]] extends Activity {


}

class MainActivity extends Activity {
    // allows accessing `.value` on TR.resource.constants
    implicit val context = this

  lazy val vh: TypedViewHolder.main2 = TypedViewHolder.setContentView(this, TR.layout.main2)

  def foo(): Unit = {
//    val httpClient = PooledHttp1Client.apply[IO]()
//    val request = httpClient.expect[Json]("https://api.fixer.io/latest")
  }

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    // type ascription is required due to SCL-10491
    println(A(1, "d").asJson.noSpaces)
    foo()


    vh.text2.setText(s"Hello world, from ${TR.string.app_name.value}")
    vh.image2.getDrawable match {
      case a: Animatable => a.start()
      case _ => // not animatable
    }
  }
}