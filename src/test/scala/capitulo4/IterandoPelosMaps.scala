package capitulo4

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class IterandoPelosMaps extends FunSuite{
  
   val scores = Map("Bob" -> 10, "Cindy" -> 8, "Fred" -> 7, "Alice" -> 10)
   
   test("for é capaz de acessar as chaves e os valores"){
     var s = ""
     for ( (k, v) <- scores) s += k + "->" + v + " "
     assert("Bob->10 Cindy->8 Fred->7 Alice->10 " == s)
   }
   
   test("para iterar pelos valores usa-se 'values'"){
     var s = ""
     for (v <- scores.values) s += v + " "
     assert("10 8 7 10 " == s)
   }
   
   test("para iterar pelas chaves usa-se 'keySet'"){
     var s = ""
     for (v <- scores.keySet) s += v + " "
     assert("Bob Cindy Fred Alice " == s)
   }
   
   test("para inverter um map, troque as chaves e os valores"){
     var s = ""
     val m = for ( (k,v) <- scores) yield (v, k)
     for ( (k, v) <- m) s += k + "->" + v + " "
     //note que Alice sobrescreveu Bob devido as chaves agora serem iguais '10'
     assert("10->Alice 8->Cindy 7->Fred " == s)
   }
}