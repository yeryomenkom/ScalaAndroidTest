scalaVersion := "2.11.12"

enablePlugins(AndroidApp)
enablePlugins(AndroidProtify)
android.useSupportVectors

versionCode := Some(1)
version := "0.1-SNAPSHOT"

instrumentTestRunner :=
  "android.support.test.runner.AndroidJUnitRunner"

platformTarget := "android-26"

minSdkVersion in Android := "26"

/* disable proguard */
useProguard in Test := false
useProguard in Android := false
useProguard := false


retrolambdaEnabled := false

javacOptions in Compile ++= "-source" :: "1.7" :: "-target" :: "1.7" :: Nil

libraryDependencies ++= Seq(
  "com.android.support" % "appcompat-v7" % "24.0.0",

  "com.android.support.test" % "runner" % "0.5" % "androidTest",
  "com.android.support.test.espresso" % "espresso-core" % "2.2.2" % "androidTest"
)

val circeVersion = "0.9.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

