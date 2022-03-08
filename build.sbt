name := """simplePlay"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

// Dockerパッケージングのための設定
enablePlugins(DockerPlugin) // sbt-native-packagerでdockerビルドを行う設定
dockerBaseImage := "openjdk:11" // デフォルトではopenjdk8になってしまうのでバージョンを指定する

// 実行時にPIDファイルを開こうとして失敗してしまう．
// Dockerの中ではPIDを心配することはないので使わないようにする
javaOptions in Universal ++= Seq(
  "-Dpidfile.path=/dev/null"
)