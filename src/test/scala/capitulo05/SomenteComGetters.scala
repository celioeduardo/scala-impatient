package capitulo05

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

//Scala torna um campo private final e um método
//getter, sem o setter
class Message{
  val timeStamp = new java.util.Date
}

@RunWith(classOf[JUnitRunner])
class SomenteComGetters extends FunSuite{
  
  test("acessando getter da classe"){
    val msg = new Message
    assert(msg.timeStamp  != null)
  }
}