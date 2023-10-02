package training.design_pattern.bridge;

class SonyTV implements Device
{
    @Override
    public void turnOn()
    {
        System.out.println("Sony: turn on");
    }

    @Override
    public void turnOf()
    {
        System.out.println("Sony: turn off");
    }

    @Override
    public void setChannel(int id)
    {
        System.out.println("Sony: set channel " + id);
    }
}
