package capitulo7

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * Packages Scala aninham como todos os outros escopos.
 * Podem ser acessados os nomes do escopo mais externo.
 * 
 * Nomes de packages em Java sempre são absolutas iniciando na
 * raiz da hieraquia de packages. Em Scala nomes de packages
 * são relativas como nomes de classes aninhadas. No caso
 * de classes aninhadas isso geralmente não causa problema
 * porque todo o código está em um arquivo. Mas packages são
 * abertas-fechadas. Qualquer um pode contribuir para uma 
 * package a qualquer momento
 * 
 * Para usar nomes de packages absolutas usa-se _root_, por exmplo:
 * _root_.scala.collection.mutable.ArrayBuffer[Employee]
 */

package com {
  package horstmann {
	  object Utils {
	    def percentOf(value: Double, rate: Double) = value * rate / 100;
	  }
	  
	  package impatient {
	    class Employee{
	      var salary = 0.0
		  def giveRaise(rate: Double) {
	        //Note o Utils.percentOf. A classe Util está definida
	        //no pacote pai. Tudo no pacote pai está no escopo e
	        //não é necessario usar capitulo7.com.hortsmann.Utils.percentOf
			salary += Utils.percentOf(salary, rate)
	      }
	    }
	  }
  }
}

@RunWith(classOf[JUnitRunner])
class RegrasEscopo extends FunSuite{

}