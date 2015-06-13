package eu.leadowl.rd.axon.quickstart.aggregate

import eu.leadowl.rd.axon.quickstart.commands.{MarkCompletedCommand, CreateToDoItemCommand}
import eu.leadowl.rd.axon.quickstart.events.{ToDoItemCompletedEvent, ToDoItemCreatedEvent}
import org.axonframework.scynapse.test.EventMatchers
import org.axonframework.test.Fixtures
import org.scalatest.FlatSpec
import org.specs2.matcher.ShouldMatchers

/**
 * Created by leadowl on 13/06/2015.
 */
class ToDoItemTest extends FlatSpec with ShouldMatchers with EventMatchers {
  "ToDoItem" should "be created" in new sut {
    fixture
      .given()
      .when(CreateToDoItemCommand("todo1", "need to implement the aggregate"))
      .expectEventsMatching( withPayloads(isEqualTo(ToDoItemCreatedEvent("todo1", "need to implement the aggregate"))))
  }
  it should "be marked completed" in new sut {
    fixture
      .given(ToDoItemCreatedEvent("todo1", "need to implement the aggregate"))
      .when(MarkCompletedCommand("todo1"))
      .expectEventsMatching( withPayloads(isEqualTo(ToDoItemCompletedEvent("todo1"))))
  }
}

trait sut {
  val fixture = {
    val f = Fixtures.newGivenWhenThenFixture(classOf[ToDoItem])
    f.setReportIllegalStateChange(false)
    f
  }
}

