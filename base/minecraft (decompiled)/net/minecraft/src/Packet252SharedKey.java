package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;

public class Packet252SharedKey extends Packet
{
    private byte[] field_73307_a = new byte[0];
    private byte[] field_73305_b = new byte[0];
    private SecretKey field_73306_c;

    public Packet252SharedKey() {}

    public Packet252SharedKey(SecretKey par1SecretKey, PublicKey par2PublicKey, byte[] par3ArrayOfByte)
    {
        this.field_73306_c = par1SecretKey;
        this.field_73307_a = CryptManager.func_75894_a(par2PublicKey, par1SecretKey.getEncoded());
        this.field_73305_b = CryptManager.func_75894_a(par2PublicKey, par3ArrayOfByte);
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.field_73307_a = readBytesFromStream(par1DataInputStream);
        this.field_73305_b = readBytesFromStream(par1DataInputStream);
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        writeByteArray(par1DataOutputStream, this.field_73307_a);
        writeByteArray(par1DataOutputStream, this.field_73305_b);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleSharedKey(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 2 + this.field_73307_a.length + 2 + this.field_73305_b.length;
    }

    public SecretKey func_73303_a(PrivateKey par1PrivateKey)
    {
        return par1PrivateKey == null ? this.field_73306_c : (this.field_73306_c = CryptManager.func_75887_a(par1PrivateKey, this.field_73307_a));
    }

    public SecretKey func_73304_d()
    {
        return this.func_73303_a((PrivateKey)null);
    }

    public byte[] func_73302_b(PrivateKey par1PrivateKey)
    {
        return par1PrivateKey == null ? this.field_73305_b : CryptManager.func_75889_b(par1PrivateKey, this.field_73305_b);
    }
}
