package training.javafx.service.messenger.model;

import java.io.Serializable;
import java.time.LocalTime;

public class MessageObject implements Serializable
{
    private static final long serialVersionUID = -2192983628881110768L;
    private String name;
    private String message;
    private LocalTime time;

    public MessageObject(String name, String message, LocalTime time)
    {
        this.name = name;
        this.message = message;
        this.time = time;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public LocalTime getTime()
    {
        return this.time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (this.message == null) ? 0 : this.message.hashCode());
        result = prime * result + ( (this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ( (this.time == null) ? 0 : this.time.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MessageObject other = (MessageObject)obj;
        if (this.message == null)
        {
            if (other.message != null) return false;
        }
        else if (!this.message.equals(other.message)) return false;
        if (this.name == null)
        {
            if (other.name != null) return false;
        }
        else if (!this.name.equals(other.name)) return false;
        if (this.time == null)
        {
            if (other.time != null) return false;
        }
        else if (!this.time.equals(other.time)) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "MessageObject [name=" + this.name + ", message=" + this.message
                + ", time=" + this.time + "]";
    }
}
