package com.clean_code;

public class ExtractingTryCatchBlocks
{
    public static void main(String[] args)
    {
        ExtractingTryCatchBlocks testObject = new ExtractingTryCatchBlocks();
        testObject.delete();
    }
    
    private void delete()
    {
        try {
            deleteContent();
        } catch (UnsupportedOperationException e) {
            logError(e);
        }
    }
    
    private void deleteContent() throws UnsupportedOperationException
    {
        // der Code der den Fehler werfen kann
        throw new UnsupportedOperationException("Das geht so nicht!");
    }
    
    private void logError(Exception e)
    {
        // logging
        System.out.println(e.getMessage());
    }
}
