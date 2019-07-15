package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task makeTask(final String taskClass, String taskName, String colorWhereWhat, String paintUsingQuantity) {
        switch (taskClass) {
            case DRIVING:
                return new DrivingTask(taskName, colorWhereWhat, paintUsingQuantity);
            case PAINTING:
                return new PaintingTask(taskName, colorWhereWhat, paintUsingQuantity);
            case SHOPPING:
                return new ShoppingTask(taskName, colorWhereWhat, Double.parseDouble(paintUsingQuantity));
            default:
                return null;
        }
    }
}
