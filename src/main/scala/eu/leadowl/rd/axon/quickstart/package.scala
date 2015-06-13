package eu.leadowl.rd.axon.quickstart

import org.axonframework.scynapse.annotations.aggregateId

/**
 * Created by leadowl on 13/06/2015.
 */
package object commands{
  case class CreateToDoItemCommand(@aggregateId todoId: String, description: String)
  case class MarkCompletedCommand(@aggregateId todoId: String)
}

package object events{
  case class ToDoItemCreatedEvent(todoId: String, description: String)
  case class ToDoItemCompletedEvent(todoId: String)
}