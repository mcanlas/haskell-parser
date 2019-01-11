package com.htmlism.haskellparser

import fastparse._, NoWhitespace._

/**
  * [[https://www.haskell.org/onlinereport/syntax-iso.html]]
  */
object HaskellParser {
  val reservedwords = Set("class", "where")

  def typeclassName[_ : P] = CharIn("A-Za-z").rep.!

  def simpleTypeclass[_ : P] = P(typeclassName ~ typeclassArgument)

  def typeExpression[_: P] = typeclassName ~ (ws ~ typeclassArgument).rep(1)

  def constrainedClass[_ : P] = P(typeclassName ~ typeclassArgument ~ "=>" ~ simpleTypeclass)

  def typeclassArgument[_ : P] = CharIn("a-z").rep.!.filter(!reservedwords(_))

  def typeClassConstructor[_ : P] = P(simpleTypeclass)

  def typeclassDeclaration[_: P] = P("class" ~ typeClassConstructor)

  def ws[_: P] = P(CharIn(" ").rep( 1))

  def token[_: P] = CharIn("A-z").rep(1).!

  def simple[_: P] = P("class" ~ ws ~ typeExpression ~ ws ~ "where")
}
