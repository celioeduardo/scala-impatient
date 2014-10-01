package capitulo06

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite


abstract class UndoableAction(val description: String){
  def undo(): Unit
  def redo(): Unit
}

object DoNothingAction extends UndoableAction("Do nothing"){
  override def undo() {}
  override def redo() {}
}

@RunWith(classOf[JUnitRunner])
class ObjetoExtendendoClasseOuTrait extends FunSuite{
	
  test("O objeto DoNothingAction pode ser compartilhado em vários lugares"){
    val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction);
    
    assert("Do nothing" == DoNothingAction.description);
  }
  
  
}