package capitulo04

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * Quando se trabalha com Map é preciso escolher uma implementação
 * um "hash table" ou um "balanced tree".
 * Por default o Scala dá um hash table. Você pode querer um "tree map"
 * se você não tem uma boa função de hash para as funções, ou se você 
 * precisa visitar as chaves seguindo uma ordem 
 */

@RunWith(classOf[JUnitRunner])
class MapsOrdenados extends FunSuite{
	
  test("map ordenado"){
    val scores = scala.collection.immutable.SortedMap("Alice" -> 10, "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8)
    var s = ""
    for ((k,v) <- scores) s += k + "->" + v + " "
    assert("Alice->10 Bob->3 Cindy->8 Fred->7 " == s)
  }
  
  test("para visitar as chaves na ordem de inserção use um LinkedHashMap"){
    val scores = scala.collection.mutable.LinkedHashMap("Janeiro"->1, "Fevereiro"->2, "Março"->3, "Abril"->4)
    var s = ""
    for ((k,v) <- scores) s += k + "->" + v + " "
    assert("Janeiro->1 Fevereiro->2 Março->3 Abril->4 " == s)
  }
  
  
}