package Implementations.Factories;

import Implementations.Layouts.SimpleLayout;
import Implementations.Layouts.XmlLayout;
import Interfaces.Factory;
import Interfaces.Layout;

public class LayoutFactory implements Factory<Layout> {

    @Override
    public Layout produce(String type) {
        return switch (type) {
            case "SimpleLayout" -> new SimpleLayout();
            case "XmlLayout" -> new XmlLayout();
            default -> throw new IllegalStateException("Invalid type of layout for " + type + " param.");
        };
    }
}
