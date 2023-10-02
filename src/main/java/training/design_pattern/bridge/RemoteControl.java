package training.design_pattern.bridge;

class RemoteControl
{
    final Device device;

    RemoteControl(Device device)
    {
        this.device = device;
    }

    void turnOn()
    {
        device.turnOn();
    }

    void turnOf()
    {
        device.turnOf();
    }
}
