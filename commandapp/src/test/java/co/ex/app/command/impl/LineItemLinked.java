package co.ex.app.command.impl;

public class LineItemLinked {

  LineItem headlineItem;

  public LineItem makeHeadLineItem() {
      headlineItem = new LineItem(getNextLIne());
      return headlineItem;
  }

  public LineItem recurse(LineItem lineItem) {
    String txt = getNextLIne();
    if (txt == null) {
      return null;
    }
    LineItem li = new LineItem(txt);
    if (li.getLineItem() == null) {
      return lineItem;
    }

    lineItem.setNextLineItem(li);

    return recurse(li);
  }

  int nbr = 1;

  public String getNextLIne() {
    if (nbr > 100) {
      return null;
    }
    return "new line".concat(Integer.toString(nbr++));
  }

  public LineItem getHeadlineItem() {
    return headlineItem;
  }
}
