package es.ieslosmontecillos.introspeccion;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

public class MiControl extends Region
{
    public MiControl()
    {
        super();
        // marca la zona donde hacer click
        setStyle("-fx-border-color:red;");
        setPrefSize(100, 100);

        this.setOnMouseClicked(event ->
        {
            if (onActionProperty().get() != null)
                onActionProperty().get().handle(event);
        });
    }

    private final ObjectProperty<EventHandler<MouseEvent>> OnAction =
            new SimpleObjectProperty<>();

    public final ObjectProperty<EventHandler<MouseEvent>> onActionProperty() {
        return OnAction;
    }
    public final void setOnAction(EventHandler<MouseEvent> handler) {
        OnAction.set(handler);
    }
    public final EventHandler<MouseEvent> getOnAction() {
        return OnAction.get();
    }
}
