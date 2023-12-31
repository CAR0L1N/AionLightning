/*
 * This file is part of aion-unique <aion-unique.com>.
 *
 *  aion-unique is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-unique is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-unique.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.openaion.gameserver.network.aion.serverpackets;

import java.nio.ByteBuffer;

import org.openaion.gameserver.network.aion.AionConnection;
import org.openaion.gameserver.network.aion.AionServerPacket;


/**
 * @author orz
 *
 */
public class SM_GATHER_STATUS extends AionServerPacket
{
	private int status;
	private int playerobjid;
	private int gatherableobjid;


	public SM_GATHER_STATUS(int playerobjid , int gatherableobjid, int status)
	{
		this.playerobjid = playerobjid;
		this.gatherableobjid = gatherableobjid;
		this.status = status;
	}

	/**
	 * {@inheritDoc}
	 */

	 @Override
	 protected void writeImpl(AionConnection con, ByteBuffer buf)
	 {              

		 writeD(buf, playerobjid);
		 writeD(buf, gatherableobjid);
		 writeH(buf, 0); //unk
		 writeC(buf, status);

	 }       
}
