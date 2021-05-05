plugins {
    id("org.jetbrains.intellij") version "0.7.3"
    java
    kotlin("jvm") version "1.4.10"
}

group = "org.example"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
//    version = "2020.3"
}
tasks.getByName<org.jetbrains.intellij.tasks.PatchPluginXmlTask>("patchPluginXml") {
    changeNotes("""
      0.1.0.<br>
      <li>Initial version</li>
      """)
    sinceBuild("193.*")
    untilBuild("211.*")
}