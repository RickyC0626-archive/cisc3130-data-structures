package generics;

public class Box<E>
{
    private E param;

    protected Box() {}

    public Box(E param)
    {
        this.param = param;
    }

    public void set(E param) { this.param = param; }
    public E get() { return param; }
}
