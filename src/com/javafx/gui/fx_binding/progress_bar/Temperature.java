package com.javafx.gui.fx_binding.progress_bar;
/*
 * JavaFX-Bean -> Properties - mit Hilfe von Properties kann auf Veränderung der
 * Daten reagiert werden (informiert)
 */

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class Temperature
{
    // private float grad;
    private FloatProperty grad = new SimpleFloatProperty(); // Wrapper-Typ

    /*
     * getter für Property - für Binding - für Listener
     */
    public final FloatProperty gradProperty()
    {
        return this.grad;
    }

    /*
     * verhält sich wie eine "normale" getter
     */
    public final float getGrad()
    {
        return this.gradProperty().get();
    }

    /*
     * verhält sich wie eine "normale" setter
     */
    public final void setGrad(final float grad)
    {
        this.gradProperty().set(grad);
    }

}