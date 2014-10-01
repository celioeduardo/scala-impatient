package capitulo09

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.collection.mutable.ArrayBuffer


/**
 * A trait Serializable é definida no pacote scala e não
 * exige import.
 * Você pode omitir a anotação @SerialVersionUID se aceitar
 * o ID default
 */
@SerialVersionUID(42L) class Person(val name:String) extends Serializable{

  // As coleções Scala são serializáveis, então você pode 
  // usá-las em suas classes serializáveis
  private val friends = new ArrayBuffer[Person]  
  
  final override def equals(other: Any) = {
    val that = other.asInstanceOf[Person]
    that != null && that.name == name
  }
}

@RunWith(classOf[JUnitRunner])
class Serializacao extends FunSuite{
	
  test("serialização e deserialização"){
    val martin = new Person("Martin")
    import java.io._
    val out = new ObjectOutputStream(new FileOutputStream("src/test/resources/serializacao/test.obj"))
    out.writeObject(martin)
    out.close()
    val in = new ObjectInputStream(new FileInputStream("src/test/resources/serializacao/test.obj"))
    val savedMartin = in.readObject().asInstanceOf[Person]
    
    assert(martin == savedMartin)
  }
  
}