package org.openaion.loginserver.network.gameserver.serverpackets;

import java.nio.ByteBuffer;

import org.openaion.loginserver.model.AccountTime;
import org.openaion.loginserver.network.gameserver.GsConnection;
import org.openaion.loginserver.network.gameserver.GsServerPacket;


/**
 * In this packet LoginServer is answering on GameServer request about valid authentication data and also sends account
 * name of user that is authenticating on GameServer.
 *
 * @author -Nemesiss-
 *
 */
public class SM_ACCOUNT_AUTH_RESPONSE extends GsServerPacket
{
	/**
	 * Account id
	 */
	private final int		accountId;

	/**
	 * True if account is authenticated.
	 */
	private final boolean	ok;

	/**
	 * account name
	 */
	private final String	accountName;
	
	/**
	 * Access level
	 */
	private final byte		accessLevel;
	
	/**
	 * Membership
	 */
	private final byte		membership;

	/**
	 * Constructor.
	 *
	 * @param accountId
	 * @param ok
	 * @param accountName
	 * @param accessLevel 
	 * @param membership 
	 */
	public SM_ACCOUNT_AUTH_RESPONSE(int accountId, boolean ok, String accountName, byte accessLevel, byte membership)
	{
		super(0x01);

		this.accountId   = accountId;
		this.ok          = ok;
		this.accountName = accountName;
		this.accessLevel = accessLevel;
		this.membership  = membership;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeImpl(GsConnection con, ByteBuffer buf)
	{
		writeC(buf, getOpcode());
		writeD(buf, accountId);
		writeC(buf, ok ? 1 : 0);

		if(ok)
		{
			writeS(buf, accountName);

			AccountTime	accountTime = con.getGameServerInfo().getAccountFromGameServer(accountId).getAccountTime();

			writeQ(buf, accountTime.getAccumulatedOnlineTime());
			writeQ(buf, accountTime.getAccumulatedRestTime());
			writeC(buf, accessLevel);
			writeC(buf, membership);
		}
	}
}        
