package training.design_pattern.composite;

import java.util.ArrayList;
import java.util.List;


class Group implements Component
{
    private final List<Component> components = new ArrayList<>();

    Group(Component ... componentArray)
    {
        components.addAll(List.of(componentArray));
    }

    @Override
    public void render()
    {
        components.forEach(Component::render);
    }

    void add(Component component)
    {
        components.add(component);
    }
}
