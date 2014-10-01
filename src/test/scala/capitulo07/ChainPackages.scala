package capitulo7

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * Uma cláusula package pode conter um encadeamento,
 * ou segmento de caminho, por exmplo:
 */

package com.horstmaan.impatient {
  //membros de com e com.horstmaan NÃO são 
  //visíveis aqui
  package capitulo07{
    class Person
  }
}
/**
 * Essa cláusula limita os membros visíveis. 
 */
@RunWith(classOf[JUnitRunner])
class ChainPackages extends FunSuite{

}