package capitulo04

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * Para converter Java Map para Scala Map é preciso importar
 * scala.collection.JavaConversions.mapAsScalaMap
 * Assim é possível trabalhar com a agradável API do Scala.
 * Também é útil para tralhar com tree map mutável que não
 * existe no Scala
 */

import java.awt.font.TextAttribute._

@RunWith(classOf[JUnitRunner])
class InteroperandoComJava extends FunSuite{

	test("assim é possível implementar um Map Scala com um Java TreeMap"){
	  import scala.collection.JavaConversions.mapAsScalaMap
	  val scores: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String,Int]
	}  
  
	test("além disso pode-se fazer uma conversão de java.util.Properties para um Map[String,String]"){
	  import scala.collection.JavaConversions.propertiesAsScalaMap
	  val scores: scala.collection.mutable.Map[String, String] = System.getProperties()
	}
	
	test("por outro lado, pode-se fazer uma conversão de Java Map para um Scala Map"){
	  val attrs = Map(FAMILY -> "Serif", SIZE -> 12) //um Scala Map
	  import scala.collection.JavaConversions.mapAsJavaMap
	  val font = new java.awt.Font(attrs)
	}
	
}