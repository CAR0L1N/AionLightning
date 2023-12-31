/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.openaion.gameserver.task;

import org.openaion.commons.utils.concurrent.ExecuteWrapper;
import org.openaion.gameserver.utils.ThreadPoolManager;


/**
 * @author NB4L1
 */
public abstract class FIFORunnableQueue<T extends Runnable> extends FIFOSimpleExecutableQueue<T>
{
	@Override
	protected final void removeAndExecuteFirst()
	{
		ExecuteWrapper.execute(removeFirst(), ThreadPoolManager.MAXIMUM_RUNTIME_IN_MILLISEC_WITHOUT_WARNING);
	}
}
