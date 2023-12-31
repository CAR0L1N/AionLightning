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
package org.openaion.gameserver.network.aion.clientpackets;

import org.openaion.gameserver.model.gameobjects.Gatherable;
import org.openaion.gameserver.model.gameobjects.VisibleObject;
import org.openaion.gameserver.model.gameobjects.player.Player;
import org.openaion.gameserver.network.aion.AionClientPacket;

/**
 * @author ATracer
 *
 */
public class CM_GATHER extends AionClientPacket
{
	boolean isStartGather = false;

	public CM_GATHER(int opcode)
	{
		super(opcode);
	}


	@Override
	protected void readImpl()
	{
		int action = readD();
		if(action == 0)
			isStartGather = true;
	}

	@Override
	protected void runImpl()
	{
		Player player = getConnection().getActivePlayer();
		if(player != null)
		{
			VisibleObject target = player.getTarget();
			if(target != null && target instanceof Gatherable)
			{
				if(isStartGather)
					((Gatherable)target).getController().onStartUse(player);
				else
					((Gatherable)target).getController().finishGathering(player);
			}
		}
	}
}
