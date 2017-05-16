inThisBuild(
  Seq(
    scalaVersion := "2.12.2",
    sonatypeGithub := ("fommil", "drone-dynamic-agents"),
    licenses := Seq(Apache2)
  )
)

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser",
  "io.circe" %% "circe-fs2"
).map(_ % "0.8.0") ++ Seq(
  "org.typelevel" %% "cats" % "0.9.0",
  "com.spinoco" %% "fs2-http" % "0.1.6"
)

scalacOptions ++= Seq(
  "-unchecked",
  "-explaintypes",
  "-Ywarn-value-discard",
  "-Ywarn-numeric-widen",
  "-language:higherKinds",
  "-Ypartial-unification",
  "-Xlog-free-terms",
  "-Xlog-free-types",
  "-Xlog-reflective-calls",
  "-Yrangepos",
  "-Yno-imports",
  "-Yno-predef"
)

scalacOptions += "-Ywarn-unused:implicits,imports,locals,params,patvars,privates"

wartremoverWarnings in (Compile, compile) := Warts.unsafe ++ Seq(
  Wart.FinalCaseClass,
  Wart.ExplicitImplicitTypes
)
wartremoverWarnings in (Compile, compile) -= Wart.Any // https://github.com/frees-io/freestyle/issues/313
wartremoverWarnings in (Compile, compile) -= Wart.FinalCaseClass // https://github.com/frees-io/freestyle/issues/314
wartremoverWarnings in (Compile, compile) -= Wart.ExplicitImplicitTypes // https://github.com/frees-io/freestyle/issues/314
wartremoverWarnings in (Compile, compile) -= Wart.DefaultArguments // not sure I agree with this one...

// http://frees.io/docs/
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.patch)
resolvers += Resolver.sonatypeRepo("snapshots")
libraryDependencies += "io.frees" %% "freestyle" % "0.1.2-SNAPSHOT"
