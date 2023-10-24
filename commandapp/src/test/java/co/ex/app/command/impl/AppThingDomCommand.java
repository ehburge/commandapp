package co.ex.app.command.impl;

import co.ex.domain.cmd.DomCommand;

import java.util.List;

public class AppThingDomCommand implements DomCommand {

  private Long thingNbr;
  private String description;
  private String fullDescription;
  private String status;
  private List<LineItem> lineItemList;

  AppThingDomCommand(
      Long thingNbr,
      String description,
      String fullDescription,
      String status,
      List<LineItem> lineItemList) {
    this.thingNbr = thingNbr;
    this.description = description;
    this.fullDescription = fullDescription;
    this.status = status;
    this.lineItemList = lineItemList;
  }

  public static AppThingCommandBuilder builder() {
    return new AppThingCommandBuilder();
  }

  public Long getThingNbr() {
    return this.thingNbr;
  }

  public String getDescription() {
    return this.description;
  }

  public String getFullDescription() {
    return this.fullDescription;
  }

  public String getStatus() {
    return this.status;
  }

  public List<LineItem> getLineItemList() {
    return this.lineItemList;
  }

  enum sts {
    CREATE,
    UPDATE,
    APPROVE,
    REJECT,
    CANCEL
  }

  public static class AppThingCommandBuilder {
    private Long thingNbr;
    private String description;
    private String fullDescription;
    private String status;
    private List<LineItem> lineItemList;

    AppThingCommandBuilder() {}

    public AppThingCommandBuilder thingNbr(Long thingNbr) {
      this.thingNbr = thingNbr;
      return this;
    }

    public AppThingCommandBuilder description(String description) {
      this.description = description;
      return this;
    }

    public AppThingCommandBuilder fullDescription(String fullDescription) {
      this.fullDescription = fullDescription;
      return this;
    }

    public AppThingCommandBuilder status(String status) {
      this.status = status;
      return this;
    }

    public AppThingDomCommand build() {
      return new AppThingDomCommand(thingNbr, description, fullDescription, status, lineItemList);
    }

    public String toString() {
      return "CreateThingCommand.CreateThingCommandBuilder(thingNbr="
          + this.thingNbr
          + ", description="
          + this.description
          + ", fullDescription="
          + this.fullDescription
          + ", price="
          + this.status
          + ")";
    }
  }
}
