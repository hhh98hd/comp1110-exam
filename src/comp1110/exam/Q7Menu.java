package comp1110.exam;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.*;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Q7Menu extends Application {

    private static final int WIDTH = 150;
    private static final int HEIGHT = 250;

    private final Group root = new Group();
    private final VBox controls = new VBox();

    /**
     * Helper methods to get and set the state of a checkbox. (These
     * are provided just so that you don't need to search the javafx
     * documentation for the right methods in the CheckBox class.)
     */
    private boolean getState(CheckBox box) {
	return box.isSelected();
    }

    private void setState(CheckBox box, boolean checked) {
	box.setSelected(checked);
    }

    /**
     * FIXME: Complete the event handlers of the four CheckBoxes created
     * in this method to make the application have the behaviour specified
     * in the question:
     * - when the "Select all" box is checked, set the state of all the
     *   other three boxes to checked (true);
     * - when the "Select all" box is unchecked, set the state of all the
     *   other three boxes to unchecked (false);
     * - when any of the "Breakfast", "Lunch" or "Dinner" boxes are unchecked,
     *   set the state of the "Select all" box to unchecked (false), if not
     *   already unchecked.
     * - The "Place order" button is not required to do anything.
     */
    private void makeControls() {
        CheckBox selectBreakfast = new CheckBox("Breakfast");
	selectBreakfast.setMinWidth(100);
        CheckBox selectLunch = new CheckBox("Lunch");
	selectLunch.setMinWidth(100);
        CheckBox selectDinner = new CheckBox("Dinner");
	selectDinner.setMinWidth(100);
        CheckBox selectAll = new CheckBox("Select all");
	selectAll.setMinWidth(100);
        Button orderButton = new Button("Place order");
	orderButton.setMinWidth(100);
	selectBreakfast.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    // FIXME: complete this method
		}
	    });
	selectLunch.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    // FIXME: complete this method
		}
	    });
	selectDinner.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    // FIXME: complete this method
		}
	    });
	selectAll.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    // FIXME: complete this method
		}
	    });
        controls.getChildren().addAll(selectBreakfast, selectLunch, selectDinner, selectAll, orderButton);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Menu selection");
        Scene scene = new Scene(root, WIDTH, HEIGHT);

	makeControls();
        controls.setSpacing(10);
        root.getChildren().add(controls);

	// Initially clear all selections
	setState((CheckBox)(controls.getChildren().get(0)), false);
	setState((CheckBox)(controls.getChildren().get(1)), false);
	setState((CheckBox)(controls.getChildren().get(2)), false);
	setState((CheckBox)(controls.getChildren().get(3)), false);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
