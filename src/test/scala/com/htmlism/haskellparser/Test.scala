package com.htmlism.haskellparser

import fastparse._

object Test extends App {
  val simple =
    """class functor f where"""

  val complex =
    """class Profunctor p => Cartesian p where
      |first  :: p a b -> p (a, c) (b, c)
      |second :: p a b -> p (c, a) (c, b)""".stripMargin

  println {
    parse("class Functor f where", HaskellParser.simple(_), verboseFailures = true)
  }

//  println {
//    parse(simple, HaskellParser.typeclassDeclaration(_), verboseFailures = true) match {
//      case f: Parsed.Failure => f.longMsg
//    }
//  }
//
//  println {
//    parse(complex, HaskellParser.typeclassDeclaration(_), verboseFailures = true)
//  }
}
