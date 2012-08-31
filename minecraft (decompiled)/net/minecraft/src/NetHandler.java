package net.minecraft.src;

public abstract class NetHandler
{
    /**
     * determine if it is a server handler
     */
    public abstract boolean isServerHandler();

    /**
     * Handle Packet51MapChunk (full chunk update of blocks, metadata, light levels, and optionally biome data)
     */
    public void handleMapChunk(Packet51MapChunk par1Packet51MapChunk) {}

    public void registerPacket(Packet par1Packet) {}

    public void handleErrorMessage(String par1Str, Object[] par2ArrayOfObj) {}

    public void handleKickDisconnect(Packet255KickDisconnect par1Packet255KickDisconnect)
    {
        this.registerPacket(par1Packet255KickDisconnect);
    }

    public void handleLogin(Packet1Login par1Packet1Login)
    {
        this.registerPacket(par1Packet1Login);
    }

    public void handleFlying(Packet10Flying par1Packet10Flying)
    {
        this.registerPacket(par1Packet10Flying);
    }

    public void handleMultiBlockChange(Packet52MultiBlockChange par1Packet52MultiBlockChange)
    {
        this.registerPacket(par1Packet52MultiBlockChange);
    }

    public void handleBlockDig(Packet14BlockDig par1Packet14BlockDig)
    {
        this.registerPacket(par1Packet14BlockDig);
    }

    public void handleBlockChange(Packet53BlockChange par1Packet53BlockChange)
    {
        this.registerPacket(par1Packet53BlockChange);
    }

    public void handleNamedEntitySpawn(Packet20NamedEntitySpawn par1Packet20NamedEntitySpawn)
    {
        this.registerPacket(par1Packet20NamedEntitySpawn);
    }

    public void handleEntity(Packet30Entity par1Packet30Entity)
    {
        this.registerPacket(par1Packet30Entity);
    }

    public void handleEntityTeleport(Packet34EntityTeleport par1Packet34EntityTeleport)
    {
        this.registerPacket(par1Packet34EntityTeleport);
    }

    public void handlePlace(Packet15Place par1Packet15Place)
    {
        this.registerPacket(par1Packet15Place);
    }

    public void handleBlockItemSwitch(Packet16BlockItemSwitch par1Packet16BlockItemSwitch)
    {
        this.registerPacket(par1Packet16BlockItemSwitch);
    }

    public void handleDestroyEntity(Packet29DestroyEntity par1Packet29DestroyEntity)
    {
        this.registerPacket(par1Packet29DestroyEntity);
    }

    public void handlePickupSpawn(Packet21PickupSpawn par1Packet21PickupSpawn)
    {
        this.registerPacket(par1Packet21PickupSpawn);
    }

    public void handleCollect(Packet22Collect par1Packet22Collect)
    {
        this.registerPacket(par1Packet22Collect);
    }

    public void handleChat(Packet3Chat par1Packet3Chat)
    {
        this.registerPacket(par1Packet3Chat);
    }

    public void handleVehicleSpawn(Packet23VehicleSpawn par1Packet23VehicleSpawn)
    {
        this.registerPacket(par1Packet23VehicleSpawn);
    }

    public void handleAnimation(Packet18Animation par1Packet18Animation)
    {
        this.registerPacket(par1Packet18Animation);
    }

    /**
     * runs registerPacket on the given Packet19EntityAction
     */
    public void handleEntityAction(Packet19EntityAction par1Packet19EntityAction)
    {
        this.registerPacket(par1Packet19EntityAction);
    }

    public void handleClientProtocol(Packet2ClientProtocol par1Packet2ClientProtocol)
    {
        this.registerPacket(par1Packet2ClientProtocol);
    }

    public void handleServerAuthData(Packet253ServerAuthData par1Packet253ServerAuthData)
    {
        this.registerPacket(par1Packet253ServerAuthData);
    }

    public void handleSharedKey(Packet252SharedKey par1Packet252SharedKey)
    {
        this.registerPacket(par1Packet252SharedKey);
    }

    public void handleMobSpawn(Packet24MobSpawn par1Packet24MobSpawn)
    {
        this.registerPacket(par1Packet24MobSpawn);
    }

    public void handleUpdateTime(Packet4UpdateTime par1Packet4UpdateTime)
    {
        this.registerPacket(par1Packet4UpdateTime);
    }

    public void handleSpawnPosition(Packet6SpawnPosition par1Packet6SpawnPosition)
    {
        this.registerPacket(par1Packet6SpawnPosition);
    }

    /**
     * Packet handler
     */
    public void handleEntityVelocity(Packet28EntityVelocity par1Packet28EntityVelocity)
    {
        this.registerPacket(par1Packet28EntityVelocity);
    }

    /**
     * Packet handler
     */
    public void handleEntityMetadata(Packet40EntityMetadata par1Packet40EntityMetadata)
    {
        this.registerPacket(par1Packet40EntityMetadata);
    }

    /**
     * Packet handler
     */
    public void handleAttachEntity(Packet39AttachEntity par1Packet39AttachEntity)
    {
        this.registerPacket(par1Packet39AttachEntity);
    }

    public void handleUseEntity(Packet7UseEntity par1Packet7UseEntity)
    {
        this.registerPacket(par1Packet7UseEntity);
    }

    /**
     * Packet handler
     */
    public void handleEntityStatus(Packet38EntityStatus par1Packet38EntityStatus)
    {
        this.registerPacket(par1Packet38EntityStatus);
    }

    /**
     * Recieves player health from the server and then proceeds to set it locally on the client.
     */
    public void handleUpdateHealth(Packet8UpdateHealth par1Packet8UpdateHealth)
    {
        this.registerPacket(par1Packet8UpdateHealth);
    }

    /**
     * respawns the player
     */
    public void handleRespawn(Packet9Respawn par1Packet9Respawn)
    {
        this.registerPacket(par1Packet9Respawn);
    }

    public void handleExplosion(Packet60Explosion par1Packet60Explosion)
    {
        this.registerPacket(par1Packet60Explosion);
    }

    public void handleOpenWindow(Packet100OpenWindow par1Packet100OpenWindow)
    {
        this.registerPacket(par1Packet100OpenWindow);
    }

    public void handleCloseWindow(Packet101CloseWindow par1Packet101CloseWindow)
    {
        this.registerPacket(par1Packet101CloseWindow);
    }

    public void handleWindowClick(Packet102WindowClick par1Packet102WindowClick)
    {
        this.registerPacket(par1Packet102WindowClick);
    }

    public void handleSetSlot(Packet103SetSlot par1Packet103SetSlot)
    {
        this.registerPacket(par1Packet103SetSlot);
    }

    public void handleWindowItems(Packet104WindowItems par1Packet104WindowItems)
    {
        this.registerPacket(par1Packet104WindowItems);
    }

    /**
     * Updates Client side signs
     */
    public void handleUpdateSign(Packet130UpdateSign par1Packet130UpdateSign)
    {
        this.registerPacket(par1Packet130UpdateSign);
    }

    public void handleUpdateProgressbar(Packet105UpdateProgressbar par1Packet105UpdateProgressbar)
    {
        this.registerPacket(par1Packet105UpdateProgressbar);
    }

    public void handlePlayerInventory(Packet5PlayerInventory par1Packet5PlayerInventory)
    {
        this.registerPacket(par1Packet5PlayerInventory);
    }

    public void handleTransaction(Packet106Transaction par1Packet106Transaction)
    {
        this.registerPacket(par1Packet106Transaction);
    }

    /**
     * Packet handler
     */
    public void handleEntityPainting(Packet25EntityPainting par1Packet25EntityPainting)
    {
        this.registerPacket(par1Packet25EntityPainting);
    }

    public void handleBlockEvent(Packet54PlayNoteBlock par1Packet54PlayNoteBlock)
    {
        this.registerPacket(par1Packet54PlayNoteBlock);
    }

    /**
     * runs registerPacket on the given Packet200Statistic
     */
    public void handleStatistic(Packet200Statistic par1Packet200Statistic)
    {
        this.registerPacket(par1Packet200Statistic);
    }

    public void handleSleep(Packet17Sleep par1Packet17Sleep)
    {
        this.registerPacket(par1Packet17Sleep);
    }

    public void handleBed(Packet70GameEvent par1Packet70GameEvent)
    {
        this.registerPacket(par1Packet70GameEvent);
    }

    /**
     * Handles weather packet
     */
    public void handleWeather(Packet71Weather par1Packet71Weather)
    {
        this.registerPacket(par1Packet71Weather);
    }

    /**
     * Contains logic for handling packets containing arbitrary unique item data. Currently this is only for maps.
     */
    public void handleMapData(Packet131MapData par1Packet131MapData)
    {
        this.registerPacket(par1Packet131MapData);
    }

    public void handleDoorChange(Packet61DoorChange par1Packet61DoorChange)
    {
        this.registerPacket(par1Packet61DoorChange);
    }

    /**
     * Handle a server ping packet.
     */
    public void handleServerPing(Packet254ServerPing par1Packet254ServerPing)
    {
        this.registerPacket(par1Packet254ServerPing);
    }

    /**
     * Handle an entity effect packet.
     */
    public void handleEntityEffect(Packet41EntityEffect par1Packet41EntityEffect)
    {
        this.registerPacket(par1Packet41EntityEffect);
    }

    /**
     * Handle a remove entity effect packet.
     */
    public void handleRemoveEntityEffect(Packet42RemoveEntityEffect par1Packet42RemoveEntityEffect)
    {
        this.registerPacket(par1Packet42RemoveEntityEffect);
    }

    /**
     * Handle a player information packet.
     */
    public void handlePlayerInfo(Packet201PlayerInfo par1Packet201PlayerInfo)
    {
        this.registerPacket(par1Packet201PlayerInfo);
    }

    /**
     * Handle a keep alive packet.
     */
    public void handleKeepAlive(Packet0KeepAlive par1Packet0KeepAlive)
    {
        this.registerPacket(par1Packet0KeepAlive);
    }

    /**
     * Handle an experience packet.
     */
    public void handleExperience(Packet43Experience par1Packet43Experience)
    {
        this.registerPacket(par1Packet43Experience);
    }

    /**
     * Handle a creative slot packet.
     */
    public void handleCreativeSetSlot(Packet107CreativeSetSlot par1Packet107CreativeSetSlot)
    {
        this.registerPacket(par1Packet107CreativeSetSlot);
    }

    /**
     * Handle a entity experience orb packet.
     */
    public void handleEntityExpOrb(Packet26EntityExpOrb par1Packet26EntityExpOrb)
    {
        this.registerPacket(par1Packet26EntityExpOrb);
    }

    public void handleEnchantItem(Packet108EnchantItem par1Packet108EnchantItem) {}

    public void handleCustomPayload(Packet250CustomPayload par1Packet250CustomPayload) {}

    public void handleEntityHeadRotation(Packet35EntityHeadRotation par1Packet35EntityHeadRotation)
    {
        this.registerPacket(par1Packet35EntityHeadRotation);
    }

    public void handleTileEntityData(Packet132TileEntityData par1Packet132TileEntityData)
    {
        this.registerPacket(par1Packet132TileEntityData);
    }

    /**
     * Handle a player abilities packet.
     */
    public void handlePlayerAbilities(Packet202PlayerAbilities par1Packet202PlayerAbilities)
    {
        this.registerPacket(par1Packet202PlayerAbilities);
    }

    public void handleAutoComplete(Packet203AutoComplete par1Packet203AutoComplete)
    {
        this.registerPacket(par1Packet203AutoComplete);
    }

    public void handleClientInfo(Packet204ClientInfo par1Packet204ClientInfo)
    {
        this.registerPacket(par1Packet204ClientInfo);
    }

    public void handleLevelSound(Packet62LevelSound par1Packet62LevelSound)
    {
        this.registerPacket(par1Packet62LevelSound);
    }

    public void handleBlockDestroy(Packet55BlockDestroy par1Packet55BlockDestroy)
    {
        this.registerPacket(par1Packet55BlockDestroy);
    }

    public void handleClientCommand(Packet205ClientCommand par1Packet205ClientCommand) {}

    public void handleMapChunks(Packet56MapChunks par1Packet56MapChunks)
    {
        this.registerPacket(par1Packet56MapChunks);
    }

    /**
     * packet.processPacket is only called if this returns true
     */
    public boolean canProcessPackets()
    {
        return false;
    }
}
