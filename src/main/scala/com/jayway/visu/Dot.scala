package com.jayway.visu

import net.kuruvila.graphviz.DotLanguage._

class Dot {

  case class Field(obj: String, field: String)

  var objects = List[String]()
  var fields = List[Field]()

  def dot(): Digraph = {
    digraph(
      addFieldsToGraph()

    )
  }

  private def addFieldsToGraph(): Statement = {
    fields map {
      field =>
        field.obj --> field.field
    }
  }

  private[visu] def addField(obj: String, field: String): Field = {
    if (!(objects contains obj)) objects ::= obj
    if (!(objects contains field)) objects ::= field

    val newField = new Field(obj, field)

    fields ::= newField
    newField
  }

  /*
 *
 * val g = digraph(
*   subgraph(
*   style("filled"),
*     color("#eeeeee"),
*     node(style("filled"), color("#ffffff")),
*     "a0" --> "a1" --> "a2" --> "a3",
*     label("process #1")
*   ),
*  subgraph(
*     node(style("filled")),
*     "b0" --> "b1" --> "b2" --> "b3",
*     label("process #2"),
*     color("blue")
*   ),
*   "start" --> "a0",
*   "start" --> "b0",
*   "a1" --> "b3",
*   "b2" --> "a3",
*   "a3" --> "a0",
*   "a3" --> "end",
*   "b3" --> "end",
*   "start".attr(shape.Mdiamond),
*   "end".attr(shape.Msquare)
* )
 * */


}


