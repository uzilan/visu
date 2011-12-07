package com.jayway.visu

import net.kuruvila.graphviz.DotLanguage.Digraph
import java.lang.reflect.Field

case class Visu(root: AnyRef) {

  val dot = new Dot

  addFields(root.getClass, root.getClass.getDeclaredFields())

  def getDot(): Digraph = {
    dot.dot()
  }

  def addFields(obj: AnyRef, fields: Array[Field]): Unit = {
    fields foreach {
      field =>
        val objType = obj.getClass
        val fieldType = field.getType
        dot.addField(objType.getSimpleName, fieldType.getSimpleName)
        addFields(fieldType.getSimpleName, fieldType.getDeclaredFields)
    }
  }
}