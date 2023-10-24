package co.ex.app.command.impl;

import lombok.Data;
import lombok.NonNull;

@Data
public class LineItem {

  @NonNull String lineItem;
  LineItem nextLineItem;

  public LineItem(@NonNull String lineItem) {
    this.lineItem = lineItem;
  }
}
