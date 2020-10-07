name := """sensors-playing"""
organization := "com.gmail.shimonchuk"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.13.3"

libraryDependencies += guice
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.16"

