package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PlayerInstance
{
    private final List playersInChunk;

    /** note: this is final */
    private final ChunkCoordIntPair chunkLocation;
    private short[] locationOfBlockChange;
    private int numberOfTilesToUpdate;
    private int field_73260_f;

    final PlayerManager myManager;

    public PlayerInstance(PlayerManager par1PlayerManager, int par2, int par3)
    {
        this.myManager = par1PlayerManager;
        this.playersInChunk = new ArrayList();
        this.locationOfBlockChange = new short[64];
        this.numberOfTilesToUpdate = 0;
        this.chunkLocation = new ChunkCoordIntPair(par2, par3);
        par1PlayerManager.getWorldServer().theChunkProviderServer.loadChunk(par2, par3);
    }

    /**
     * called for all chunks within the visible radius of the player
     */
    public void addPlayerToChunkWatchingList(EntityPlayerMP par1EntityPlayerMP)
    {
        if (this.playersInChunk.contains(par1EntityPlayerMP))
        {
            throw new IllegalStateException("Failed to add player. " + par1EntityPlayerMP + " already is in chunk " + this.chunkLocation.chunkXPos + ", " + this.chunkLocation.chunkZPos);
        }
        else
        {
            this.playersInChunk.add(par1EntityPlayerMP);
            par1EntityPlayerMP.chunksToLoad.add(this.chunkLocation);
        }
    }

    public void sendThisChunkToPlayer(EntityPlayerMP par1EntityPlayerMP)
    {
        if (this.playersInChunk.contains(par1EntityPlayerMP))
        {
            par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet51MapChunk(PlayerManager.getWorldServer(this.myManager).getChunkFromChunkCoords(this.chunkLocation.chunkXPos, this.chunkLocation.chunkZPos), true, 0));
            this.playersInChunk.remove(par1EntityPlayerMP);
            par1EntityPlayerMP.chunksToLoad.remove(this.chunkLocation);

            if (this.playersInChunk.isEmpty())
            {
                long var2 = (long)this.chunkLocation.chunkXPos + 2147483647L | (long)this.chunkLocation.chunkZPos + 2147483647L << 32;
                PlayerManager.getChunkWatchers(this.myManager).remove(var2);

                if (this.numberOfTilesToUpdate > 0)
                {
                    PlayerManager.getChunkWatchersWithPlayers(this.myManager).remove(this);
                }

                this.myManager.getWorldServer().theChunkProviderServer.unloadChunksIfNotNearSpawn(this.chunkLocation.chunkXPos, this.chunkLocation.chunkZPos);
            }
        }
    }

    public void flagChunkForUpdate(int par1, int par2, int par3)
    {
        if (this.numberOfTilesToUpdate == 0)
        {
            PlayerManager.getChunkWatchersWithPlayers(this.myManager).add(this);
        }

        this.field_73260_f |= 1 << (par2 >> 4);

        if (this.numberOfTilesToUpdate < 64)
        {
            short var4 = (short)(par1 << 12 | par3 << 8 | par2);

            for (int var5 = 0; var5 < this.numberOfTilesToUpdate; ++var5)
            {
                if (this.locationOfBlockChange[var5] == var4)
                {
                    return;
                }
            }

            this.locationOfBlockChange[this.numberOfTilesToUpdate++] = var4;
        }
    }

    public void sendToAllPlayersWatchingChunk(Packet par1Packet)
    {
        Iterator var2 = this.playersInChunk.iterator();

        while (var2.hasNext())
        {
            EntityPlayerMP var3 = (EntityPlayerMP)var2.next();

            if (!var3.chunksToLoad.contains(this.chunkLocation))
            {
                var3.serverForThisPlayer.sendPacketToPlayer(par1Packet);
            }
        }
    }

    public void sendChunkUpdate()
    {
        if (this.numberOfTilesToUpdate != 0)
        {
            int var1;
            int var2;
            int var3;

            if (this.numberOfTilesToUpdate == 1)
            {
                var1 = this.chunkLocation.chunkXPos * 16 + (this.locationOfBlockChange[0] >> 12 & 15);
                var2 = this.locationOfBlockChange[0] & 255;
                var3 = this.chunkLocation.chunkZPos * 16 + (this.locationOfBlockChange[0] >> 8 & 15);
                this.sendToAllPlayersWatchingChunk(new Packet53BlockChange(var1, var2, var3, PlayerManager.getWorldServer(this.myManager)));

                if (PlayerManager.getWorldServer(this.myManager).blockHasTileEntity(var1, var2, var3))
                {
                    this.sendTileToAllPlayersWatchingChunk(PlayerManager.getWorldServer(this.myManager).getBlockTileEntity(var1, var2, var3));
                }
            }
            else
            {
                int var4;

                if (this.numberOfTilesToUpdate == 64)
                {
                    var1 = this.chunkLocation.chunkXPos * 16;
                    var2 = this.chunkLocation.chunkZPos * 16;
                    this.sendToAllPlayersWatchingChunk(new Packet51MapChunk(PlayerManager.getWorldServer(this.myManager).getChunkFromChunkCoords(this.chunkLocation.chunkXPos, this.chunkLocation.chunkZPos), false, this.field_73260_f));

                    for (var3 = 0; var3 < 16; ++var3)
                    {
                        if ((this.field_73260_f & 1 << var3) != 0)
                        {
                            var4 = var3 << 4;
                            List var5 = PlayerManager.getWorldServer(this.myManager).getAllTileEntityInBox(var1, var4, var2, var1 + 16, var4 + 16, var2 + 16);
                            Iterator var6 = var5.iterator();

                            while (var6.hasNext())
                            {
                                TileEntity var7 = (TileEntity)var6.next();
                                this.sendTileToAllPlayersWatchingChunk(var7);
                            }
                        }
                    }
                }
                else
                {
                    this.sendToAllPlayersWatchingChunk(new Packet52MultiBlockChange(this.chunkLocation.chunkXPos, this.chunkLocation.chunkZPos, this.locationOfBlockChange, this.numberOfTilesToUpdate, PlayerManager.getWorldServer(this.myManager)));

                    for (var1 = 0; var1 < this.numberOfTilesToUpdate; ++var1)
                    {
                        var2 = this.chunkLocation.chunkXPos * 16 + (this.locationOfBlockChange[var1] >> 12 & 15);
                        var3 = this.locationOfBlockChange[var1] & 255;
                        var4 = this.chunkLocation.chunkZPos * 16 + (this.locationOfBlockChange[var1] >> 8 & 15);

                        if (PlayerManager.getWorldServer(this.myManager).blockHasTileEntity(var2, var3, var4))
                        {
                            this.sendTileToAllPlayersWatchingChunk(PlayerManager.getWorldServer(this.myManager).getBlockTileEntity(var2, var3, var4));
                        }
                    }
                }
            }

            this.numberOfTilesToUpdate = 0;
            this.field_73260_f = 0;
        }
    }

    private void sendTileToAllPlayersWatchingChunk(TileEntity par1TileEntity)
    {
        if (par1TileEntity != null)
        {
            Packet var2 = par1TileEntity.getAuxillaryInfoPacket();

            if (var2 != null)
            {
                this.sendToAllPlayersWatchingChunk(var2);
            }
        }
    }

    static ChunkCoordIntPair getChunkLocation(PlayerInstance par0PlayerInstance)
    {
        return par0PlayerInstance.chunkLocation;
    }

    static List getPlayersInChunk(PlayerInstance par0PlayerInstance)
    {
        return par0PlayerInstance.playersInChunk;
    }
}
