plugins {
    `java-library`
    id("io.papermc.paperweight.userdev") version "1.5.3"
    id("com.github.johnrengelman.shadow") version("8.1.1")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")
    implementation("org.jetbrains:annotations:20.1.0")
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    /*
    implementation("team.unnamed:creative-api:0.7.1-SNAPSHOT")
    implementation("team.unnamed:creative-serializer-minecraft:0.7.1-SNAPSHOT")
    implementation("team.unnamed:creative-server:0.7.1-SNAPSHOT")
    implementation 'commons-io:commons-io:2.11.0'

     */
    //   // implement form path
    //  implementation files('libs/Model-Engine-R3.1.8.jar')


    // implementation("org.incendo.interfaces:interfaces-paper:1.0.0-SNAPSHOT")
}
