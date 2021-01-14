package generics;

public abstract class Menu implements MenuInterface, MenuInterface2
{
    @Override
    public boolean onCommand() { return false; }
    @Override
    public boolean onClick() { return false; }
}
