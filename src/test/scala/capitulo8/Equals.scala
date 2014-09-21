package capitulo8

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.FunSuite

class Item(val description: String, val price: Double){
  
  //Nota: Método definido como final por que 
  //é muito difícil extender igualdade corretamente
  //em uma subclasse. O problema é a simetria.
  //Você deseja que a.equals(b) tenha o mesmo
  //resultado que b.equas(a), mesmo quano b pertença
  //a ums subclasse
  final override def equals(other: Any) = {
    val that = other.asInstanceOf[Item]
    that != null && description == that.description && price == that.price
  }
  
  final override def hashCode = 13 * description.hashCode + 17 * price.hashCode

}

@RunWith(classOf[JUnitRunner])
class Equals extends FunSuite{
  //Para testar igualdade você geralmente não chama eq ou equals.
  //Simplesmente use o operador ==.Para referencias de tipo, ele
  //chama equals depois de verificar operandos null
  test("objetos iguais"){
    assert(new Item("A",19.13) == new Item("A",19.13))
  }
  
  test("descrição diferente"){
    assert(new Item("B",19.13) != new Item("A",19.13))
  }
  
  test("preço diferente"){
    assert(new Item("A",12.57) != new Item("A",19.13))
  }
    
}