package training.test_examples.mocking.helper;

public class NoiseRepeater
{
    private final NoiseMaker
        noiseMaker;
    
    private int
        numberOfRepeats = 1;
    
    
    public NoiseRepeater(NoiseMaker noiseMaker)
    {
        this.noiseMaker = noiseMaker;
    }
    
    public String makeNoise()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numberOfRepeats; i++)
        {
            sb.append(noiseMaker.makeNoise());
        }
        return sb.toString();
    }
    
    public void setNumberOfRepeats(int numberOfRepeats)
    {
        this.numberOfRepeats = numberOfRepeats;
    }
}
