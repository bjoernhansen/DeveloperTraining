package training.design_pattern.bridge;

class Main
{
    public static void main(String[] args)
    {
        Device device = new SonyTV();
        var remoteControl = new RemoteControl(device);
        remoteControl.turnOf();
    }
}
