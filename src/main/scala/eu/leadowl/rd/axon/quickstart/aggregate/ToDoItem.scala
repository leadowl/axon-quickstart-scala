package eu.leadowl.rd.axon.quickstart.aggregate

import eu.leadowl.rd.axon.quickstart.commands.{MarkCompletedCommand, CreateToDoItemCommand}
import eu.leadowl.rd.axon.quickstart.events.{ToDoItemCompletedEvent, ToDoItemCreatedEvent}
import org.axonframework.commandhandling.annotation.CommandHandler
import org.axonframework.eventhandling.annotation.EventHandler
import org.axonframework.eventsourcing.annotation.{AggregateIdentifier, AbstractAnnotatedAggregateRoot}

/**
 * Created by leadowl on 13/06/2015.
 */
class ToDoItem extends AbstractAnnotatedAggregateRoot[String] {

  @AggregateIdentifier
  private var id : String = _

  @CommandHandler
  def this(command : CreateToDoItemCommand) {
    this()
    apply(new ToDoItemCreatedEvent(command.todoId, command.description))
  }

  @EventHandler
  def on(e: ToDoItemCreatedEvent) = {
    id = e.todoId
  }

  @CommandHandler
  def markCompleted(command : MarkCompletedCommand) {
    apply(new ToDoItemCompletedEvent(id));
  }

}
