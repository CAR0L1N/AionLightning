/**
 * This file is part of aion-emu <aion-emu.com>.
 *
 *  aion-emu is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-emu is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-emu.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.openaion.gameserver.network.aion.serverpackets;

import java.nio.ByteBuffer;

import org.openaion.gameserver.network.aion.AionConnection;
import org.openaion.gameserver.network.aion.AionServerPacket;


/**
 * Response for CM_RECONNECT_AUTH with key that will be use for authentication at LoginServer.
 * 
 * @author -Nemesiss-
 * 
 */
public class SM_RECONNECT_KEY extends AionServerPacket
{
	/**
	 * key for reconnection - will be used for authentication
	 */
	private final int	key;

	/**
	 * Constructs new <tt>SM_RECONNECT_KEY</tt> packet
	 * 
	 * @param key
	 *            key for reconnection
	 */
	public SM_RECONNECT_KEY(int key)
	{
		this.key = key;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeImpl(AionConnection con, ByteBuffer buf)
	{
		writeC(buf, 0x00);
		writeD(buf, key);
	}
}
