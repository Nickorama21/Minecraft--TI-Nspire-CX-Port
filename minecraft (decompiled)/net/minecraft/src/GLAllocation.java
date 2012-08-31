package net.minecraft.src;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.lwjgl.opengl.GL11;

public class GLAllocation
{
    private static final Map field_74531_a = new HashMap();
    private static final List field_74530_b = new ArrayList();

    /**
     * Generates the specified number of display lists and returns the first index.
     */
    public static synchronized int generateDisplayLists(int par0)
    {
        int var1 = GL11.glGenLists(par0);
        field_74531_a.put(Integer.valueOf(var1), Integer.valueOf(par0));
        return var1;
    }

    /**
     * Generates texture names and stores them in the specified buffer.
     */
    public static synchronized void generateTextureNames(IntBuffer par0IntBuffer)
    {
        GL11.glGenTextures(par0IntBuffer);

        for (int var1 = par0IntBuffer.position(); var1 < par0IntBuffer.limit(); ++var1)
        {
            field_74530_b.add(Integer.valueOf(par0IntBuffer.get(var1)));
        }
    }

    public static synchronized void deleteDisplayLists(int par0)
    {
        GL11.glDeleteLists(par0, ((Integer)field_74531_a.remove(Integer.valueOf(par0))).intValue());
    }

    /**
     * Deletes all textures and display lists. Called when Minecraft is shutdown to free up resources.
     */
    public static synchronized void deleteTexturesAndDisplayLists()
    {
        Iterator var0 = field_74531_a.entrySet().iterator();

        while (var0.hasNext())
        {
            Entry var1 = (Entry)var0.next();
            GL11.glDeleteLists(((Integer)var1.getKey()).intValue(), ((Integer)var1.getValue()).intValue());
        }

        field_74531_a.clear();
        var0 = field_74530_b.iterator();

        while (var0.hasNext())
        {
            int var2 = ((Integer)var0.next()).intValue();
            GL11.glDeleteTextures(var2);
        }

        field_74530_b.clear();
    }

    /**
     * Creates and returns a direct byte buffer with the specified capacity. Applies native ordering to speed up access.
     */
    public static synchronized ByteBuffer createDirectByteBuffer(int par0)
    {
        return ByteBuffer.allocateDirect(par0).order(ByteOrder.nativeOrder());
    }

    /**
     * Creates and returns a direct int buffer with the specified capacity. Applies native ordering to speed up access.
     */
    public static IntBuffer createDirectIntBuffer(int par0)
    {
        return createDirectByteBuffer(par0 << 2).asIntBuffer();
    }

    /**
     * Creates and returns a direct float buffer with the specified capacity. Applies native ordering to speed up
     * access.
     */
    public static FloatBuffer createDirectFloatBuffer(int par0)
    {
        return createDirectByteBuffer(par0 << 2).asFloatBuffer();
    }
}
