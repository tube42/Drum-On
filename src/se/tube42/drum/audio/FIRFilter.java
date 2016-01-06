
package se.tube42.drum.audio;

import se.tube42.drum.data.*;

/*
 * simple averaging filter
 */

public final class FIRFilter extends Effect
{
    private int size;
    private float []v;
    private Ring ring;

    public FIRFilter(int size)
    {
        this.size = size;
        this.v = new float[size];
        this.ring = new Ring(size);

        for(int i = 0; i < v.length; i++)
            v[i] = 0;

        reset();
    }

    // -----------------------------------------------------------------

    public void reset()
    {
        ring.reset();
    }

    // -----------------------------------------------------------------

    public int getSize()
    {
        return size;
    }

    public void set(int index, float val)
    {
        if(index >= 0 && index < v.length)
            v[index] = val;
    }

    public float process(float in)
    {
        ring.write(in);
        return ring.mac(v);
    }

    public void process(final float [] data, int offset, final int size)
    {
        for(int i = size; i != 0; i--) {
            final float a0 = data[offset];
            final float b0 = process(a0);
            data[offset++] = b0;
        }
    }
}
