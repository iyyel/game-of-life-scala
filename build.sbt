import org.scalajs.linker.interface.ModuleSplitStyle

lazy val gameOfLifeScala = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaVersion := "3.4.2",
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("life"))
        )
    },
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.8.0",
      "com.raquo" %%% "airstream" % "17.0.0"
    )
  )
