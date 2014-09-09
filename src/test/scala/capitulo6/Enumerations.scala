package capitulo6

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
/**
 * Scala não tem tipos Enumerados. Porém sua biblioteca
 * padrão fornece classe helper Enumeration que pode
 * ser usada para produzir Enumerations.
 * Defina um objeto que estende a classe Enumeration
 * e inicialize cada valor ao método Value. 
 */

object TrafficLightColor extends Enumeration{
  val Red, Yellow, Green = Value
}

/**
 * Alternativamente pode-se passar ID, nomes ou ambos
 * para o método Value.
 */
object TrafficLightColor2 extends Enumeration{
  val Red = Value(0,"Stop")
  val Yellow = Value(10) //Nome Yellow
  val Green = Value("Go") //ID 11
}
/**
 * Se não especificado o ID é um a mais que
 * o definido anteriormente. O nome default é
 * o nome do campo.
 * Lembre que o tipo do Enumeration é TrafficLightColor.Value e
 * não TrafficLightColor - este é o tipo do objeto que
 * contém os valores. Algumas pessoas recomendam que você
 * adicione o type alias
 *  
 */
object TrafficLightColor3 extends Enumeration{
  //Agora o tipo do Enumeration é TrafficLightColor3.TrafficLightColor3
  //que é apenas uma melhoria se você usa um import TrafficLightColor3._
  type TrafficLightColor3 = Value
  val Red, Yellow, Green = Value
  
  def doWhat(color: TrafficLightColor3) = {
    if (color == Red) "stop"
    else if (color == Yellow) "hurry up" 
    else "go"
  }
}

@RunWith(classOf[JUnitRunner])
class Enumerations extends FunSuite{
  
  test("usando um Enumeration"){
    assert(TrafficLightColor3.doWhat(TrafficLightColor3.Red) == "stop")
    assert(TrafficLightColor3.doWhat(TrafficLightColor3.Yellow) == "hurry up")
    assert(TrafficLightColor3.doWhat(TrafficLightColor3.Green ) == "go")
  }
  
  test("id e nome do Enumeration"){
    var s = ""
	for (c <- TrafficLightColor.values) s += c.id +":"+c.toString()+" "
	assert("0:Red 1:Yellow 2:Green " == s)
  }
  
  test("procurar valor da enumeração pelo id ou nome"){
    assert(TrafficLightColor.Red == TrafficLightColor(0)) //Chama o método apply()
    assert(TrafficLightColor.Red == TrafficLightColor.withName("Red"))
    assert(TrafficLightColor.Yellow  == TrafficLightColor(1)) //Chama o método apply()
    assert(TrafficLightColor.Yellow  == TrafficLightColor.withName("Yellow"))
    assert(TrafficLightColor.Green  == TrafficLightColor(2)) //Chama o método apply()
    assert(TrafficLightColor.Green  == TrafficLightColor.withName("Green"))
    
  }
  
}