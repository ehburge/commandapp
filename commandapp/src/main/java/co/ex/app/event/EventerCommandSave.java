package co.ex.app;


import java.util.List;

public interface EventerCommandSave<C> {
  List<co.ex.app000.aggregate.event.Event> process(C eventCommand);
}
