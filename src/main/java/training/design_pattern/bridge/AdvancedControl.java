package training.design_pattern.bridge;

public class AdvancedControl extends RemoteControl
{
    AdvancedControl(Device device)
    {
        super(device);
    }

    void setChannel(int id)
    {
        device.setChannel(id);
    }
}
