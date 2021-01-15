package generics;

public class ConcreteMenu extends Menu
{
    @Override
    public boolean onItemPickup() { return false; }
    @Override
    public boolean onItemPlace() { return false; }
}
