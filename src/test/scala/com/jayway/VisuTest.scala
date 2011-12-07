package com.jayway

import org.specs2.mutable._
import visu.Visu

class Pointee

class Pointer(val p: Pointee)

class Third(val p1: Pointer, val p2: Pointee)

class VisuTest extends Specification {

  "Pointer" should {


    "point to the pointee" in {
      val v = new Visu(new Pointer(new Pointee))
      val dot = v.getDot
      dot.repr must contain("Pointer -> Pointee")
    }

    "allow complex pointing" in {
      val p1 = new Pointee
      val p2 = new Pointer(p1)
      val p3 = new Third(p2, p1)

      val v = new Visu(p3)
      val dot = v.getDot

      println("dot:" + dot.repr)

      dot.repr must contain("Pointer -> Pointee")
      dot.repr must contain("Third -> Pointer")
      dot.repr must contain("Third -> Pointee")

    }

  }

}